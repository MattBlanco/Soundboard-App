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

    //used for request codes
    static final int SOUND_1 = 1;
    static final int SOUND_2 = 2;
    static final int SOUND_3 = 3;
    static final int SOUND_4 = 4;
    static final int SOUND_5 = 5;
    static final int SOUND_6 = 6;
    static final int SOUND_7 = 7;
    static final int SOUND_8 = 8;

    //different sounds
    private Sound sound;
    private Sound sound2;
    private Sound sound3;
    private Sound sound4;
    private Sound sound5;
    private Sound sound6;
    private Sound sound7;
    private Sound sound8;

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
                    sound.soundLogic();
                    break;
                case R.id.button2:
                    sound2.soundLogic();
                    break;
                case R.id.button3:
                    sound3.soundLogic();
                    break;
                case R.id.button4:
                    sound4.soundLogic();
                    break;
                case R.id.button5:
                    sound5.soundLogic();
                    break;
                case R.id.button6:
                    sound6.soundLogic();
                    break;
                case R.id.button7:
                    sound7.soundLogic();
                    break;
                case R.id.button8:
                    sound8.soundLogic();
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
                    break;
                case R.id.button3:
                    startActivityForResult(intent, SOUND_3);
                    break;
                case R.id.button4:
                    startActivityForResult(intent, SOUND_4);
                    break;
                case R.id.button5:
                    startActivityForResult(intent, SOUND_5);
                    break;
                case R.id.button6:
                    startActivityForResult(intent, SOUND_6);
                    break;
                case R.id.button7:
                    startActivityForResult(intent, SOUND_7);
                    break;
                case R.id.button8:
                    startActivityForResult(intent, SOUND_8);
                    break;
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
                sound.setSound(resultCode, data);
                break;
            }
            case(SOUND_2) : {
                sound2.setSound(resultCode, data);
                break;
            }
            case(SOUND_3) : {
                sound3.setSound(resultCode, data);
                break;
            }
            case(SOUND_4) : {
                sound4.setSound(resultCode, data);
                break;
            }
            case(SOUND_5) : {
                sound5.setSound(resultCode, data);
                break;
            }
            case(SOUND_6) : {
                sound6.setSound(resultCode, data);
                break;
            }
            case(SOUND_7) : {
                sound7.setSound(resultCode, data);
                break;
            }
            case(SOUND_8) : {
                sound8.setSound(resultCode, data);
                break;
            }
            default:
                break;
        }
    }
}
