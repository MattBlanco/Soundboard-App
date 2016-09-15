package com.example.matt.soundboard;

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.Button;

/**
 * Created by Matt on 9/4/2016.
 */
public class Sound{
    private Activity activity;
    protected MediaPlayer mp;
    protected Button button;
    protected boolean isPrepared;


    public Sound(int buttonID, Activity _activity) {
        super();
        this.activity = _activity;
        button = (Button) activity.findViewById(buttonID);
        mp = new MediaPlayer();
    }
    

}
