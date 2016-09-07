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

    static final int SOUND_1 = 1;
    static final int SOUND_2 = 2;
    Sound sound;
    Sound sound2;
    String ResultPath;
    String path;
    String extStorageDirectory = Environment.getExternalStorageDirectory().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sound = new Sound(R.id.button,this);
        sound2 = new Sound(R.id.button2,this);


        sound.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        sound.isPrepared = true;
                    }
                });

                if(!sound.isPrepared){
                    Intent intent = new Intent(MainActivity.this, Pop.class);
                    startActivityForResult(intent, SOUND_1);
                    sound.button.setText(path);
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

        sound2.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sound2.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        sound2.isPrepared = true;
                    }
                });

                if(!sound2.isPrepared){
                    Intent intent2 = new Intent(MainActivity.this, Pop.class);
                    startActivityForResult(intent2, SOUND_2);
                    sound2.button.setText(path);
                }
                else if(sound2.mp.isPlaying()) {
                    sound2.mp.pause();
                }
                else{
                    sound2.mp.seekTo(0);
                    sound2.mp.start();
                }
            }
        });



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (SOUND_1) : {
                if (resultCode == Activity.RESULT_OK) {

                    ResultPath = data.getStringExtra("song path");
                    path = extStorageDirectory + File.separator + ResultPath;
                    try {
                        sound.mp.setDataSource(path);
                        sound.mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                break;
            }
            case(SOUND_2) : {
                if (resultCode == Activity.RESULT_OK) {
                    ResultPath = data.getStringExtra("song path");
                    path = extStorageDirectory + File.separator + ResultPath;
                    try {
                        sound2.mp.setDataSource(path);
                        sound2.mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                break;
            }
        }
    }

}
