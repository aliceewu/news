package cn.cslg.bus_ZB1018144;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Alice on 2019/12/1.
 */
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);


        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Intent it = new Intent(MainActivity.this,MyActivity.class); //你要转向的Activity
                startActivity(it); //执行
                MainActivity.this.finish();
            }
        };
        timer.schedule(task, 1000*2); //2秒后
    }
}