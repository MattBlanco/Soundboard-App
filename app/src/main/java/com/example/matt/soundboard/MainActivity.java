package com.example.matt.soundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.io.File;
import java.io.IOException;
//TODO: different images if sound is playing or just use name of file, figure out way to simplify onclicklistener, record audio instead of using user's audiofiles, possible loop

public class MainActivity extends AppCompatActivity {

    //used for result codes
    static final int SOUND_1 = 1;
    static final int SOUND_2 = 2;
    static final int SOUND_3 = 3;
    static final int SOUND_4 = 4;
    static final int SOUND_5 = 5;
    static final int SOUND_6 = 6;
    static final int SOUND_7 = 7;
    static final int SOUND_8 = 8;
    static final int SET_SOUND = 1;
    static final int CLEAR_SOUND = 0;

    //different sounds
    protected Sound sound;
    protected Sound sound2;
    protected Sound sound3;
    protected Sound sound4;
    protected Sound sound5;
    protected Sound sound6;
    protected Sound sound7;
    protected Sound sound8;

    protected String ResultPath;
    protected String path;
    protected String extStorageDirectory = Environment.getExternalStorageDirectory().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sound = new Sound(R.id.button,this);
        sound2 = new Sound(R.id.button2,this);
        sound3 = new Sound(R.id.button3,this);
        sound4 = new Sound(R.id.button4,this);
        sound5 = new Sound(R.id.button5,this);
        sound6 = new Sound(R.id.button6,this);
        sound7 = new Sound(R.id.button7,this);
        sound8 = new Sound(R.id.button8,this);

        sound.button.setOnClickListener(onClickListener);
        sound2.button.setOnClickListener(onClickListener);
        sound3.button.setOnClickListener(onClickListener);
        sound4.button.setOnClickListener(onClickListener);
        sound5.button.setOnClickListener(onClickListener);
        sound6.button.setOnClickListener(onClickListener);
        sound7.button.setOnClickListener(onClickListener);
        sound8.button.setOnClickListener(onClickListener);

        sound.button.setOnLongClickListener(onLongClickListener);
        sound2.button.setOnLongClickListener(onLongClickListener);
        sound3.button.setOnLongClickListener(onLongClickListener);
        sound4.button.setOnLongClickListener(onLongClickListener);
        sound5.button.setOnLongClickListener(onLongClickListener);
        sound6.button.setOnLongClickListener(onLongClickListener);
        sound7.button.setOnLongClickListener(onLongClickListener);
        sound8.button.setOnLongClickListener(onLongClickListener);
    }

    //set up button listener for all buttons
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.button:
                    //checks if sound is ready to play
                    sound.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            sound.isPrepared = true;
                        }
                    });

                    if(!sound.isPrepared){
                        //opens popup to set up a new sound or remove a sound
                        Intent intent = new Intent(MainActivity.this, SoundSetup.class);
                        startActivityForResult(intent, SOUND_1);
                    }
                    else if(sound.mp.isPlaying()) {
                        sound.mp.pause();
                    }
                    else{
                        //restarts sound
                        sound.mp.seekTo(0);
                        sound.mp.start();
                    }
                    break;

                case R.id.button2:
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
                    break;

                case R.id.button3:
                    sound3.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            sound3.isPrepared = true;
                        }
                    });
                    if(!sound3.isPrepared){
                        Intent intent2 = new Intent(MainActivity.this, SoundSetup.class);
                        startActivityForResult(intent2, SOUND_3);
                    }
                    else if(sound3.mp.isPlaying()) {
                        sound3.mp.pause();
                    }
                    else{
                        sound3.mp.seekTo(0);
                        sound3.mp.start();
                    }
                    break;

                case R.id.button4:
                    sound4.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            sound4.isPrepared = true;
                        }
                    });
                    if(!sound4.isPrepared){
                        Intent intent2 = new Intent(MainActivity.this, SoundSetup.class);
                        startActivityForResult(intent2, SOUND_4);
                    }
                    else if(sound4.mp.isPlaying()) {
                        sound4.mp.pause();
                    }
                    else{
                        sound4.mp.seekTo(0);
                        sound4.mp.start();
                    }
                    break;

                case R.id.button5:
                    sound5.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            sound5.isPrepared = true;
                        }
                    });
                    if(!sound5.isPrepared){
                        Intent intent2 = new Intent(MainActivity.this, SoundSetup.class);
                        startActivityForResult(intent2, SOUND_5);
                    }
                    else if(sound5.mp.isPlaying()) {
                        sound5.mp.pause();
                    }
                    else{
                        sound5.mp.seekTo(0);
                        sound5.mp.start();
                    }
                    break;

                case R.id.button6:
                    sound6.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            sound6.isPrepared = true;
                        }
                    });
                    if(!sound6.isPrepared){
                        Intent intent2 = new Intent(MainActivity.this, SoundSetup.class);
                        startActivityForResult(intent2, SOUND_6);
                    }
                    else if(sound6.mp.isPlaying()) {
                        sound6.mp.pause();
                    }
                    else{
                        sound6.mp.seekTo(0);
                        sound6.mp.start();
                    }
                    break;

                case R.id.button7:
                    sound7.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            sound7.isPrepared = true;
                        }
                    });
                    if(!sound7.isPrepared){
                        Intent intent2 = new Intent(MainActivity.this, SoundSetup.class);
                        startActivityForResult(intent2, SOUND_7);
                    }
                    else if(sound7.mp.isPlaying()) {
                        sound7.mp.pause();
                    }
                    else{
                        sound7.mp.seekTo(0);
                        sound7.mp.start();
                    }
                    break;

                case R.id.button8:
                    sound8.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            sound8.isPrepared = true;
                        }
                    });
                    if(!sound8.isPrepared){
                        Intent intent2 = new Intent(MainActivity.this, SoundSetup.class);
                        startActivityForResult(intent2, SOUND_8);
                    }
                    else if(sound8.mp.isPlaying()) {
                        sound8.mp.pause();
                    }
                    else{
                        sound8.mp.seekTo(0);
                        sound8.mp.start();
                    }
                    break;


                default:
                    break;
            }
        }
    };

    //set up listener for long clicks for all buttons
    private View.OnLongClickListener onLongClickListener = new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View v) {
            Intent intent = new Intent(MainActivity.this, SoundSetup.class);
            switch(v.getId()){
                case R.id.button:
                    startActivityForResult(intent, SOUND_1); //opens up popup to setup sound
                    break;
                case R.id.button2:
                    startActivityForResult(intent, SOUND_2);
                case R.id.button3:
                    startActivityForResult(intent, SOUND_3);
                case R.id.button4:
                    startActivityForResult(intent, SOUND_4);
                case R.id.button5:
                    startActivityForResult(intent, SOUND_5);
                case R.id.button6:
                    startActivityForResult(intent, SOUND_6);
                case R.id.button7:
                    startActivityForResult(intent, SOUND_7);
                case R.id.button8:
                    startActivityForResult(intent, SOUND_8);
                default:
                    break;

            }
            return true;
        }
    };

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
            case(SOUND_3) : {
                if (resultCode == SET_SOUND) {
                    sound3.mp.reset();
                    ResultPath = data.getStringExtra("audiofile");
                    path = extStorageDirectory + File.separator + ResultPath;
                    try {
                        sound3.mp.setDataSource(path);
                        sound3.mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sound3.button.setText(ResultPath);
                }
                if (resultCode == CLEAR_SOUND) {
                    sound3.button.setText("No sound");
                    sound3.mp.reset();
                    sound3.isPrepared = false;
                }
                break;
            }
            case(SOUND_4) : {
                if (resultCode == SET_SOUND) {
                    sound4.mp.reset();
                    ResultPath = data.getStringExtra("audiofile");
                    path = extStorageDirectory + File.separator + ResultPath;
                    try {
                        sound4.mp.setDataSource(path);
                        sound4.mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sound4.button.setText(ResultPath);
                }
                if (resultCode == CLEAR_SOUND) {
                    sound4.button.setText("No sound");
                    sound4.mp.reset();
                    sound4.isPrepared = false;
                }
                break;
            }
            case(SOUND_5) : {
                if (resultCode == SET_SOUND) {
                    sound5.mp.reset();
                    ResultPath = data.getStringExtra("audiofile");
                    path = extStorageDirectory + File.separator + ResultPath;
                    try {
                        sound5.mp.setDataSource(path);
                        sound5.mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sound5.button.setText(ResultPath);
                }
                if (resultCode == CLEAR_SOUND) {
                    sound5.button.setText("No sound");
                    sound5.mp.reset();
                    sound5.isPrepared = false;
                }
                break;
            }
            case(SOUND_6) : {
                if (resultCode == SET_SOUND) {
                    sound6.mp.reset();
                    ResultPath = data.getStringExtra("audiofile");
                    path = extStorageDirectory + File.separator + ResultPath;
                    try {
                        sound6.mp.setDataSource(path);
                        sound6.mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sound6.button.setText(ResultPath);
                }
                if (resultCode == CLEAR_SOUND) {
                    sound6.button.setText("No sound");
                    sound6.mp.reset();
                    sound6.isPrepared = false;
                }
                break;
            }
            case(SOUND_7) : {
                if (resultCode == SET_SOUND) {
                    sound7.mp.reset();
                    ResultPath = data.getStringExtra("audiofile");
                    path = extStorageDirectory + File.separator + ResultPath;
                    try {
                        sound7.mp.setDataSource(path);
                        sound7.mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sound7.button.setText(ResultPath);
                }
                if (resultCode == CLEAR_SOUND) {
                    sound7.button.setText("No sound");
                    sound7.mp.reset();
                    sound7.isPrepared = false;
                }
                break;
            }
            case(SOUND_8) : {
                if (resultCode == SET_SOUND) {
                    sound8.mp.reset();
                    ResultPath = data.getStringExtra("audiofile");
                    path = extStorageDirectory + File.separator + ResultPath;
                    try {
                        sound8.mp.setDataSource(path);
                        sound8.mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    sound8.button.setText(ResultPath);
                }
                if (resultCode == CLEAR_SOUND) {
                    sound8.button.setText("No sound");
                    sound8.mp.reset();
                    sound8.isPrepared = false;
                }
                break;
            }
            default:
                break;
        }
    }
}
