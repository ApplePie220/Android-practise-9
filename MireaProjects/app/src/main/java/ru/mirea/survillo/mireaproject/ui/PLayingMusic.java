package ru.mirea.survillo.mireaproject.ui;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import ru.mirea.survillo.mireaproject.R;

public class PLayingMusic extends Service {
    private MediaPlayer mediaPlayer;

    public PLayingMusic() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate(){
        mediaPlayer = MediaPlayer.create(this, R.raw.valeriimeladze_salutvera);
        mediaPlayer.setLooping(true);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mediaPlayer.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() { mediaPlayer.stop(); }
}
