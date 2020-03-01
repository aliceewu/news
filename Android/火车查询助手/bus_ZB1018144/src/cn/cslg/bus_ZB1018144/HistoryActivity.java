package cn.cslg.bus_ZB1018144;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.litepal.LitePal;

import java.util.List;

/**
 * Created by Alice on 2019/12/21.
 */
public class HistoryActivity extends Activity {

    private List<History> lists;
    private MyAdapter adapter;
    private RecyclerView recyclerview;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_layout);
        init();

        adapter=new MyAdapter();
        recyclerview.setLayoutManager(new LinearLayoutManager(HistoryActivity.this));
        recyclerview.setAdapter(adapter);
        refreshRecyclerView();
        getActionBar().setDisplayHomeAsUpEnabled(true);//启用向上返回按钮

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
    }

    //查询数据库中对应到表中的数据
    private void refreshRecyclerView() {
        lists = LitePal.findAll(History.class);
        adapter.notifyDataSetChanged();
    }

    //创建适配器
    private class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View vv = getLayoutInflater().inflate(R.layout.history_item,null);
            final MyHolder holder = new MyHolder(vv);
            //RecyclerView中条目的单击事件,单击删除信息
            vv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //删除当前记录
                    int id = lists.get(holder.getPosition()).getId();
                    LitePal.delete(History.class, id);
                    refreshRecyclerView();
                }
            });
            //RecyclerView中条目的长按事件，清空记录
            vv.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //删除全部记录
                    LitePal.deleteAll(History.class);
                    refreshRecyclerView();
                    return true;//将页面显示在屏幕上
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(MyHolder myHolder, int i) {
            myHolder.start.setText(lists.get(i).getStart());
            myHolder.end.setText(lists.get(i).getEnd());
        }

        @Override
        public int getItemCount() {
            return lists.size();
        }
    }

    //历史记录的页面
    private class MyHolder extends RecyclerView.ViewHolder {
        private TextView start,end;
        public MyHolder(View itemView) {
            super(itemView);
            start = (TextView) itemView.findViewById(R.id.start);
            end = (TextView) itemView.findViewById(R.id.end);

        }


    }
}