package cn.cslg.bus_ZB1018144;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.google.gson.Gson;
import org.litepal.LitePal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alice on 2019/12/16.
 */
public class StationActivity extends Activity {
    String[] citynames = {"上海", "北京", "杭州", "广州", "苏州", "南京", "淮安", "徐州", "无锡","常州","南通","连云港","盐城","扬州","镇江","泰州","宿迁"};
    TextView start,end,date;
    Button search;
    ListView listview;
    String choosedate;
    SimpleAdapter adapter=null;
    List<Map<String,String>> data=new ArrayList<Map<String, String>>();
    android.os.Handler handler=new android.os.Handler() {

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            TrainBean train = (TrainBean) bundle.getSerializable("train");
            if (train.getMsg().equals("ok")) {
                List<TrainBean.ResultBean.ListBean> lists = train.getResult().getList();
                Log.i("lists",""+lists.size());
                for (int i = 0; i < lists.size(); i++) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("trainno", lists.get(i).getTrainno());//车次
                    map.put("station", lists.get(i).getStation());//出发地
                    map.put("endstation", lists.get(i).getEndstation());//到达地
                    map.put("departuretime", lists.get(i).getDeparturetime());//发车时间
                    map.put("arrivaltime", lists.get(i).getArrivaltime());//到达时间
                    map.put("costtime", lists.get(i).getCosttime());//耗时多久

                    data.add(map);
                }
                adapter = new SimpleAdapter(StationActivity.this, data, R.layout.train_item,
                        new String[]{"trainno", "station", "endstation", "departuretime", "arrivaltime", "costtime"},
                        new int[]{R.id.trainno, R.id.station, R.id.endstation, R.id.departuretime, R.id.arrivaltime, R.id.costtime});
                listview.setAdapter(adapter);
            }
        }
    };
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.station_layout);
        init();
            LitePal.getDatabase();//创建数据库
        setLisenter();
        getActionBar().setDisplayHomeAsUpEnabled(true);//启用向上返回按钮

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==RESULT_OK){//返回的请求码与当前活动请求码一致时，才执行后继操作
            int pos= data.getIntExtra("pos",-1);
            start.setText(citynames[pos]);
        }
        else if(requestCode==2&&resultCode==RESULT_OK){
            int pos= data.getIntExtra("pos",-1);
            end.setText(citynames[pos]);
        }
    }

    private void setLisenter() {

        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(StationActivity.this,CityActivity.class);
                startActivityForResult(intent,1);
            }
        });
        end.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(StationActivity.this,CityActivity.class);
                startActivityForResult(intent,2);

            }
        });

        search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                    data.clear();
                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            //链接网络获得数据
                            String station = start.getText().toString();
                            String endstation = end.getText().toString();

                            try {
                                URL url=new URL("https://api.jisuapi.com/train/station2s?appkey=ffc853aff8ae25f0&start="+station+"&end="+endstation+"&ishigh=0&date="+choosedate+"&format=json");
                                HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                                conn.setConnectTimeout(5000);
                                conn.setReadTimeout(5000);
                                conn.setRequestMethod("GET");
                                conn.connect();//可省略
                                int code=conn.getResponseCode();
                                if(code==200){//链接成功
                                    InputStream in=conn.getInputStream();
                                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                                    String str=reader.readLine();
                                    StringBuilder builder=new StringBuilder();
                                    while (str!=null){
                                        builder.append(str);
                                        str=reader.readLine();
                                    }
                                    Log.i("train",builder.toString());
                                    Gson gson=new Gson();
                                    TrainBean train=gson.fromJson(builder.toString(),TrainBean.class);
                                    Message msg=handler.obtainMessage();
                                    Bundle bundle=new Bundle();
                                    bundle.putSerializable("train",train);
                                    msg.setData(bundle);
                                    handler.sendMessage(msg);

                                }
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }.start();
                //将查询信息保留到数据库
                String station = start.getText().toString();
                String endstation = end.getText().toString();
                History remeber=new History();
                remeber.setStart(station);
                remeber.setEnd(endstation);
                remeber.save();//保存数据到数据库中
                Toast.makeText(StationActivity.this,"保存历史成功",Toast.LENGTH_SHORT).show();
                }

        });
    }
    public void showDateDialog(View v) {
        DatePickerDialog dialog=new DatePickerDialog(StationActivity.this, android.R.style.Theme_Holo,
                new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date.setText(year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日");
                choosedate =year+"-"+(monthOfYear+1)+"-"+dayOfMonth;
            }
        },2019,12,27);
        dialog.show();
    }
    private void init() {
        start = (TextView) findViewById(R.id.start);
        end = (TextView) findViewById(R.id.end);
        search = (Button) findViewById(R.id.search);
        date = (TextView) findViewById(R.id.date);
        listview = (ListView) findViewById(R.id.listview);

    }
}