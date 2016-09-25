package com.example.matt.soundboard;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

/**
 * Created by Matt on 9/4/2016.
 */
public class Sound{
    private Activity activity;
    protected MediaPlayer mp;
    protected Button button;
    protected boolean isPrepared;

    private String extStorageDirectory = Environment.getExternalStorageDirectory().toString();

    private static int soundCounter = 1;
    private int requestCode; //keeps track of which button to modify


    static final int SET_SOUND = 1;
    static final int CLEAR_SOUND = 0;


    public Sound(int buttonID, Activity _activity) {
        super();
        this.activity = _activity;
        button = (Button) activity.findViewById(buttonID);
        mp = new MediaPlayer();
        requestCode = soundCounter;
        soundCounter++;

    }


    //determines if a sound is ready to play
    public void soundLogic() {
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                isPrepared = true;
            }
        });

        if (!isPrepared) {
            //opens popup to set up a new sound or remove a sound
            Intent intent = new Intent(activity, SoundSetup.class);
            activity.startActivityForResult(intent, requestCode);
        } else if (mp.isPlaying()) {
            mp.pause();
        } else {
            //restarts sound
            mp.seekTo(0);
            mp.start();
        }
    }


    //based on the result of the popup, bind or remove an audio file from a button
    public void setSound(int resultCode,  Intent data){
        if (resultCode == SET_SOUND) {
            //resets the media player to clear the current song
            mp.reset();
            String ResultPath = data.getStringExtra("audiofile");
            String path = extStorageDirectory + File.separator + ResultPath;
            try {
                mp.setDataSource(path);
                mp.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            button.setText(ResultPath);
        }
        if (resultCode == CLEAR_SOUND) {
            //resets the media player to clear current the sound
            button.setText("No sound");
            mp.reset();
            isPrepared = false;
        }
    }

}
