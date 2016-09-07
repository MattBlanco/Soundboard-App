package com.example.matt.soundboard;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.File;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    static final int PICK_AUDIO_REQUEST = 1;
    Sound sound;
    String ResultPath;
    String path;
    String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
    boolean isPrepared = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sound = new Sound(R.id.button,this);

        sound.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        isPrepared = true;
                    }
                });

                if(!isPrepared){
                    Intent intent = new Intent(MainActivity.this, Pop.class);
                    startActivityForResult(intent, PICK_AUDIO_REQUEST);
                }
                else if(sound.mp.isPlaying()) {
                    sound.mp.pause();
                }
                else{
                    sound.mp.seekTo(0);
                    sound.mp.start();
                }
            }


        });



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (PICK_AUDIO_REQUEST) : {
                if (resultCode == Activity.RESULT_OK) {

                    ResultPath = data.getStringExtra("song path");
                    path = extStorageDirectory + File.separator + ResultPath;
                    sound.button.setText(path);
                    try {
                        sound.mp.setDataSource(path);
                        sound.mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                break;
            }
        }
    }

}
