package com.example.matt.soundboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Sound sound = new Sound(R.id.button,this);

        sound.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(sound.mp == null){
                    Intent intent = new Intent(MainActivity.this, Pop.class);
                    startActivity(intent);

                    //Pass audio file into sound
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
}
