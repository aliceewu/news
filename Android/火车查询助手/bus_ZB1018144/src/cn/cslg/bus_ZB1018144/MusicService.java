package cn.cslg.bus_ZB1018144;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by Alice on 2019/12/15.
 */
public class MusicService extends Service {
    MediaPlayer mediaPlayer;
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(mediaPlayer!=null&&mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.reset();

        }else {

            mediaPlayer = MediaPlayer.create(this, R.raw.music0);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }

    }


    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if( mediaPlayer!=null&& mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer.release();
        mediaPlayer=null;

    }

}


