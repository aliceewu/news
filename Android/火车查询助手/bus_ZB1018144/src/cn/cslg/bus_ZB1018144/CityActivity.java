package cn.cslg.bus_ZB1018144;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Alice on 2019/12/2.
 */
public class CityActivity extends Activity {

    String[] citynames = {"上海", "北京", "杭州", "广州", "苏州", "南京", "淮安", "徐州", "无锡","常州","南通","连云港","盐城","扬州","镇江","泰州","宿迁"};
    ListView listview;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_layout);
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
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent = new Intent();
                 intent.putExtra("pos", position);//将结果装入Intent
                 setResult(RESULT_OK,intent);//设置返回结果
                 finish();//结束当前活动

            }
        });
    }

    private void init() {

        listview = (ListView) findViewById(R.id.listView);

        //使用BaseAdapter实现适配器
        listview.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {//定义一个类继承自BaseAdapter

        @Override
        public int getCount() {
            return citynames.length;//通过数组长度返回
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //1.减少inflate的次数，通过复用converView
            MyHolder holder;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.city_item, null);
                holder = new MyHolder();
                holder.tv1 = (TextView) convertView.findViewById(R.id.cityname);
                convertView.setTag(holder);
            } else {
                holder = (MyHolder) convertView.getTag();
            }
            holder.tv1.setText(citynames[position]);
            return convertView;
        }
    }

    //2.减少findviewbyid的次数，通过创建ViewHolder对象保持需要findviewbyid的控件
    class MyHolder {
        TextView tv1;
    }
}