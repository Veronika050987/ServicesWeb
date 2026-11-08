package com.com.servicesweb;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MediaService extends Service {

    MediaPlayer ambientMediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        ambientMediaPlayer = MediaPlayer.create(this, R.raw.rock);
        ambientMediaPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ambientMediaPlayer.start();
        return START_STICKY; //перезапуск при нехватке памяти при её появлении
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ambientMediaPlayer.stop();
        //остановка воспроизведения, но плеер занимает память
        ambientMediaPlayer.release();
        //для выключения плеера
        ambientMediaPlayer=null;
        //плеер идёт гулять
    }
}
