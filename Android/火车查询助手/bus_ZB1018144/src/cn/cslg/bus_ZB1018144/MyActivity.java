package cn.cslg.bus_ZB1018144;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.*;
import android.widget.*;
import org.litepal.LitePal;

import java.io.IOException;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    SoundPool soundPool;
    private int id1;
    int i=0;
    int[]imgs={R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6};
    String[]names={"站站查询","车次查询","余票查询","城市选择","搜索历史","个人中心"};
    int[]backimg = {R.drawable.back1,R.drawable.back2,R.drawable.back3,R.drawable.back4,R.drawable.back5};
    GridView gridView;
    LinearLayout layout;
    MediaPlayer mp;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        soundPool=new SoundPool(1, AudioManager.STREAM_SYSTEM,0);
        id1=soundPool.load(MyActivity.this,R.raw.music_do,1);
        init();
        setLisenter();
        LitePal.getDatabase();//创建数据库


    }

    private void setLisenter() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyActivity.this,"你选择了："+names[position],Toast.LENGTH_SHORT).show();
                if(names[position]=="城市选择"){
                    Intent intent = new Intent(MyActivity.this,CityActivity.class);
                    startActivity(intent);
                    soundPool.play(id1,1,1,1,1,1);
                }
                else if(names[position]=="个人中心"){
                    Intent intent = new Intent(MyActivity.this,LoginActivity.class);
                    startActivity(intent);
                    soundPool.play(id1,1,1,1,1,1);
                }
                else if(names[position]=="站站查询"){//appkey:ffc853aff8ae25f0
                    Intent intent = new Intent(MyActivity.this,StationActivity.class);
                    startActivity(intent);
                    soundPool.play(id1,1,1,1,1,1);
                }
                else if(names[position]=="车次查询"){
                    Intent intent = new Intent(MyActivity.this,TrainNumActivity.class);
                    startActivity(intent);
                    soundPool.play(id1,1,1,1,1,1);
                }
                else if(names[position]=="余票查询"){
                    Intent intent = new Intent(MyActivity.this,TicketActivity.class);
                    startActivity(intent);
                    soundPool.play(id1,1,1,1,1,1);
                }
                else if(names[position]=="搜索历史"){
                    Intent intent = new Intent(MyActivity.this,HistoryActivity.class);
                    startActivity(intent);
                    soundPool.play(id1,1,1,1,1,1);

                }


            }
        });

    }

    private void init() {
        layout = (LinearLayout) findViewById(R.id.backimg);
        gridView= (GridView) findViewById(R.id.gridView);
        //使用BaseAdapter实现适配器
        gridView.setAdapter(new MyAdapter());
        mp=new MediaPlayer();

    }


    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return  names.length;
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
            if(convertView==null){
                convertView=getLayoutInflater().inflate(R.layout.item,null);
                holder=new MyHolder();
                holder.img= (ImageView) convertView.findViewById(R.id.item_img);
                holder.tv1= (TextView) convertView.findViewById(R.id.item_name);
                convertView.setTag(holder);
            }
            else{//存放的是滑出去的条目的view
                holder= (MyHolder) convertView.getTag();
            }

            holder.img.setImageResource(imgs[position]);
            holder.tv1.setText(names[position]);
            return convertView;
        }
    }
    //2.减少findviewbyid的次数，通过创建ViewHolder对象保持需要findviewbyid的控件
    class MyHolder{
        ImageView img;
        TextView tv1;
    }



    public  boolean onCreateOptionsMenu(Menu menu){//加载菜单资源
        getMenuInflater().inflate(R.menu.about,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about_menu://点击关于弹窗
                AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
                builder.setTitle("关于本游戏");
                View view = LayoutInflater.from(MyActivity.this).inflate(R.layout.dialog_layout,null);
                builder.setView(view);
                builder.setPositiveButton("知道了", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();//创建AlertDialog对话框类
                dialog.show();//显示对话框
                break;
            case R.id.changeimg://点击换背景
                    layout.setBackground(getResources().getDrawable(backimg[i++]));
                if(i>4){
                    i=0;
                }

                break;
            case R.id.setmusic://点击开启/关闭音乐
                Intent intent=new Intent(MyActivity.this,MusicService.class);
                startService(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
