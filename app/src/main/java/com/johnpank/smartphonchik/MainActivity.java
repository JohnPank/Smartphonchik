package com.johnpank.smartphonchik;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener{

    MediaPlayer mediaPlayer;
    int songID;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
    }

    public void onOff(View view) {
        Log.d("MyLogs", "in onOff method");
        finish();
    }

    public void setVolume(View view) {
        int maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        switch (view.getId()){
            case R.id.ivVolUp:
                Log.d("MyLogs", "volume up");
                if(currentVol < maxVol)
                    currentVol++;
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,currentVol,0);
                break;
            case R.id.ivVolDown:
                Log.d("MyLogs", "volume down");
                if(currentVol > 0)
                    currentVol--;
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,currentVol,0);
                break;
        }
    }

    public void playSong(View view) {
        switch (view.getId()){

            case R.id.ivKolobok:
                startSong(R.raw.colobok);
                break;
            case R.id.ivRyaba:
                startSong(R.raw.ryaba);
                break;
            case R.id.ivRepka:
                startSong(R.raw.repka);
                break;
            case R.id.ivTeremok:
                startSong(R.raw.teremok);
                break;

            case R.id.ivZainka:
                startSong(R.raw.zainka);
                break;
            case R.id.ivScomoroh:
                startSong(R.raw.kalinka);
                break;
            case R.id.ivKotenok:
                startSong(R.raw.koshkin_dom);
                break;
            case R.id.ivPetushok:
                startSong(R.raw.petushok);
                break;

            case R.id.ivKolibelnaya:
                startSong(R.raw.kolibelnaya);
                break;
            case R.id.ivBelochka:
                startSong(R.raw.belochka);
                break;
            case R.id.ivKasha:
                startSong(R.raw.ladushki);
                break;
            case R.id.ivGusi:
                startSong(R.raw.gusi);
                break;

            case R.id.ivKaravai:
                startSong(R.raw.karavai);
                break;
            case R.id.ivKoza:
                startSong(R.raw.koza);
                break;
            case R.id.ivKot:
                startSong(R.raw.kotik);
                break;
            case R.id.ivAntoshka:
                startSong(R.raw.antoshka);
                break;

            case R.id.ivMedved:
                startSong(R.raw.mishka);
                break;
            case R.id.ivVodichka:
                startSong(R.raw.vodichka);
                break;
            case R.id.ivSoroka:
                startSong(R.raw.soroka);
                break;
            case R.id.ivKozlenok:
                startSong(R.raw.kozlik);
                break;
        }
    }

    private void startSong(int sId){
        if(songID == sId){
            mediaPlayer.stop();
        }else {
            songID = sId;
            if(mediaPlayer!=null)
                mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(this, sId);
            mediaPlayer.start();
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        if(mediaPlayer != null)
            mediaPlayer = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        songID = 0;
        mediaPlayer.release();
        mediaPlayer = null;
    }
}
