package com.example.matt.soundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.File;
import java.io.IOException;
//TODO: support for rotating the screen, record audio instead of using user's audiofiles, possible loop

public class MainActivity extends AppCompatActivity {

    static final int SOUND_1 = 1;
    static final int SOUND_2 = 2;
    static final int SET_SOUND = 1;
    static final int CLEAR_SOUND = 0;
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
                //checks if sound has been assigned to button
                sound.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        sound.isPrepared = true;
                    }
                });

                if(!sound.isPrepared){
                    //opens popup to set up a new sound
                    Intent intent = new Intent(MainActivity.this, SoundSetup.class);
                    startActivityForResult(intent, SOUND_1);
                }
                else if(sound.mp.isPlaying()) {
                    sound.mp.pause();
                }
                else{
                    sound.mp.seekTo(0);
                    sound.mp.setLooping(true);
                    sound.mp.start();
                }
            }
        });

        //long click behavior to always set up a new sound
        sound.button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, SoundSetup.class);
                startActivityForResult(intent, SOUND_1);
                return true;
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
                    Intent intent2 = new Intent(MainActivity.this, SoundSetup.class);
                    startActivityForResult(intent2, SOUND_2);
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

        sound2.button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, SoundSetup.class);
                startActivityForResult(intent, SOUND_2);
                return true;
            }
        });

    }


    //returns result of a popup and either sets the button with the new sound or clears sound on the current button
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (SOUND_1) : {
                if (resultCode == SET_SOUND) {
                    //resets the media player to clear the current song
                    sound.mp.reset();
                    ResultPath = data.getStringExtra("audiofile");
                    path = extStorageDirectory + File.separator + ResultPath;
                    try {
                        sound.mp.setDataSource(path);
                        sound.mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sound.button.setText(ResultPath);
                }
                if (resultCode == CLEAR_SOUND) {
                    //resets the media player to clear current the sound
                    sound.button.setText("No sound");
                    sound.mp.reset();
                    sound.isPrepared = false;
                }
                break;
            }
            case(SOUND_2) : {
                if (resultCode == SET_SOUND) {
                    sound2.mp.reset();
                    ResultPath = data.getStringExtra("audiofile");
                    path = extStorageDirectory + File.separator + ResultPath;
                    try {
                        sound2.mp.setDataSource(path);
                        sound2.mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sound2.button.setText(ResultPath);
                }
                if (resultCode == CLEAR_SOUND) {
                    sound2.button.setText("No sound");
                    sound2.mp.reset();
                    sound2.isPrepared = false;
                }
                break;
            }
        }
    }

}
