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

import java.io.*;
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
public class TicketActivity extends Activity {
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
            TicketBean ticket = (TicketBean) bundle.getSerializable("ticket");
            if (ticket.getMsg().equals("ok")) {

                List<TicketBean.ResultBean.ListBean> lists = ticket.getResult().getList();
                Log.i("lists",""+lists.size());
                for (int i = 0; i < lists.size(); i++) {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("trainno", lists.get(i).getTrainno());//车次
                    map.put("station", lists.get(i).getStation());//出发地
                    map.put("endstation", lists.get(i).getEndstation());//到达地
                    map.put("departuretime", lists.get(i).getDeparturetime());//发车时间
                    map.put("arrivaltime", lists.get(i).getArrivaltime());//到达时间
                    map.put("costtime", lists.get(i).getCosttime());//耗时多久
                    map.put("numsw",lists.get(i).getNumsw());//商务座数量
                    map.put("numtd",lists.get(i).getNumtd());//特等座数量
                    map.put("numyd",lists.get(i).getNumyd());//一等座数量
                    map.put("numed",lists.get(i).getNumed());//二等座数量
                    map.put("numrz",lists.get(i).getNumrz());//软座数量
                    map.put("numyz",lists.get(i).getNumyz());//硬座数量
                    map.put("numgr",lists.get(i).getNumgr());//高级软卧数量
                    map.put("numrw",lists.get(i).getNumrw());//软卧数量
                    map.put("numyw",lists.get(i).getNumyw());//硬卧数量
                    map.put("numwz",lists.get(i).getNumwz());//无座数量
                    map.put("numqt",lists.get(i).getNumqt());//其他数量
                    data.add(map);
                }
                adapter = new SimpleAdapter(TicketActivity.this, data, R.layout.ticket_item,
                        new String[]{"trainno", "station", "endstation", "departuretime", "arrivaltime", "costtime","numsw","numtd","numyd","numed",
                                "numrz","numyz","numgr","numrw","numyw","numwz","numqt"},
                        new int[]{R.id.trainno, R.id.station, R.id.endstation, R.id.departuretime, R.id.arrivaltime, R.id.costtime,R.id.numsw,
                        R.id.numtd,R.id.numyd,R.id.numed,R.id.numrz,R.id.numyz,R.id.numgr,R.id.numrw,R.id.numyw,R.id.numwz,R.id.numqt});
                listview.setAdapter(adapter);
            }
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_layout);
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==3&&resultCode==RESULT_OK){//返回的请求码与当前活动请求码一致时，才执行后继操作
            int pos= data.getIntExtra("pos",-1);
            start.setText(citynames[pos]);
        }
        else if(requestCode==4&&resultCode==RESULT_OK){
            int pos= data.getIntExtra("pos",-1);
            end.setText(citynames[pos]);
        }
    }

    private void setLisenter() {
        start.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(TicketActivity.this,CityActivity.class);
                startActivityForResult(intent,3);
            }
        });
        end.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(TicketActivity.this,CityActivity.class);
                startActivityForResult(intent,4);

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
                            URL url=new URL("https://api.jisuapi.com/train/ticket?appkey=ffc853aff8ae25f0&start="+station+"&end="+endstation+"&date="+choosedate+"&format=json");
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
                                Log.i("ticket",builder.toString());
                                Gson gson=new Gson();
                                TicketBean ticket=gson.fromJson(builder.toString(),TicketBean.class);
                                Message msg=handler.obtainMessage();
                                Bundle bundle=new Bundle();
                                bundle.putSerializable("ticket",ticket);
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
            }

        });
    }
    public void showDateDialog(View v) {
        DatePickerDialog dialog=new DatePickerDialog(TicketActivity.this, android.R.style.Theme_Holo,
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
        start = (TextView) findViewById(R.id.ticketstart);
        end = (TextView) findViewById(R.id.ticketend);
        date = (TextView) findViewById(R.id.ticketdate);
        search = (Button) findViewById(R.id.ticketsearch);
        listview = (ListView) findViewById(R.id.ticketlv);


    }
}