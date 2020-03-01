package cn.cslg.bus_ZB1018144;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.google.gson.Gson;

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
 * Created by Alice on 2019/12/21.
 */
public class TrainNumActivity extends Activity {
    TextView hr,tno,date;
    TextView sequenceno,station,arrivaltime,departuretime,stoptime;//表头显示
    EditText num;
    Button search;
    ListView listview;
    String choosedate;
    SimpleAdapter adapter=null;
    List<Map<String,String>> data=new ArrayList<Map<String, String>>();
    android.os.Handler handler=new android.os.Handler() {

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            TrainNumBean trainnum = (TrainNumBean) bundle.getSerializable("trainnum");
            if (trainnum.getMsg().equals("ok")) {
                List<TrainNumBean.ResultBean.ListBean> lists = trainnum.getResult().getList();
                Log.i("lists",""+lists.size());
                for (int i = 0; i < lists.size(); i++) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("sequenceno",lists.get(i).getSequenceno());//序号
                    map.put("station", lists.get(i).getStation());//站名
                    map.put("arrivaltime", lists.get(i).getArrivaltime());//到达时间
                    map.put("departuretime", lists.get(i).getDeparturetime());//发车时间
                    map.put("stoptime", lists.get(i).getStoptime());//停留时间

                    data.add(map);
                }
                adapter = new SimpleAdapter(TrainNumActivity.this, data, R.layout.trainnum_item,
                        new String[]{"sequenceno", "station", "arrivaltime", "departuretime", "stoptime"},
                        new int[]{R.id.sno, R.id.stationitem, R.id.arriveitem, R.id.detimeitem, R.id.stopitem});
                listview.setAdapter(adapter);


            }
        }
    };
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainnum_layout);
        init();
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
    private void setLisenter() {
        search.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                data.clear();
                new Thread(){
                    @Override
                    public void run() {
                        super.run();

                        //链接网络获得数据
                        String trainno = num.getText().toString();
                        try {
                            URL url=new URL("https://api.jisuapi.com/train/line?appkey=ffc853aff8ae25f0&trainno="+trainno+"&date="+choosedate+"&format=json");
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
                                Log.i("trainnum",builder.toString());
                                Gson gson=new Gson();
                                TrainNumBean trainnum=gson.fromJson(builder.toString(),TrainNumBean.class);
                                Message msg=handler.obtainMessage();
                                Bundle bundle=new Bundle();
                                bundle.putSerializable("trainnum",trainnum);
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

                sequenceno.setText("站序");
                station.setText("站名");
                arrivaltime.setText("到达时间");
                departuretime.setText("出发时间");
                stoptime.setText("停留时间/(分钟)");
                hr.setBackgroundColor(android.graphics.Color.GRAY);
            }

        });
    }

    public void showDateDialog(View v) {
        DatePickerDialog dialog=new DatePickerDialog(TrainNumActivity.this, android.R.style.Theme_Holo,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日");
                        choosedate = year+"-"+monthOfYear+"-"+dayOfMonth;
                    }
                },2019,12,17);
        dialog.show();
    }
    private void init() {
        tno = (TextView) findViewById(R.id.trainnum);
        date= (TextView) findViewById(R.id.numdate);
        search = (Button) findViewById(R.id.numsearch);
        listview = (ListView) findViewById(R.id.triannumlv);
        num = (EditText) findViewById(R.id.trainnum);
        sequenceno = (TextView) findViewById(R.id.sequenceno);//表头
        station = (TextView) findViewById(R.id.station);
        arrivaltime = (TextView) findViewById(R.id.arrivaltime);
        departuretime = (TextView) findViewById(R.id.departuretime);
        stoptime = (TextView) findViewById(R.id.stoptime);
        hr = (TextView) findViewById(R.id.hr);


    }
}