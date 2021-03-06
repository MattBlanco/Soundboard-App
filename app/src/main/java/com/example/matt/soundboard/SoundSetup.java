package com.example.matt.soundboard;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.database.Cursor;

/**
 * Created by Matt on 9/4/2016.
 * Popup to setup sounds
 * uri content://media/external/audio/media
 */
public class SoundSetup extends Activity{

    private String[] mAudioPath;
    private MediaPlayer mMediaPlayer;
    private String[] mMusicList;
    static final double PERCENT_OF_SCREEN_HEIGHT = 0.6;
    static final double PERCENT_OF_SCREEN_WIDTH = 0.8;
    static final int SET_SOUND = 1;
    static final int CLEAR_SOUND = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_setup);
        Button removeSound = (Button) this.findViewById(R.id.remove_sound);
        final Intent resultIntent = new Intent();

        //make sure new activity acts as a popup
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*PERCENT_OF_SCREEN_WIDTH), (int)(height*PERCENT_OF_SCREEN_HEIGHT));


        //create a list view so a user can see all the audio files
        ListView mListView = (ListView) findViewById(R.id.song_list);
        mMusicList = getAudioList();
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mMusicList);
        mListView.setAdapter(mAdapter);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                resultIntent.putExtra("audiofile", mMusicList[arg2]);
                setResult(SET_SOUND, resultIntent);
                finish();
            }
        });

        removeSound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(CLEAR_SOUND, resultIntent);
                finish();
            }
        });

    }


    //Creates a list of audio files from user's sdcard
    private String[] getAudioList() {
        final Cursor mCursor = getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                new String[] { MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.DATA }, null, null,
                "LOWER(" + MediaStore.Audio.Media.TITLE + ") ASC");

        int count = mCursor.getCount();

        String[] songs = new String[count];
        String[] mAudioPath = new String[count];
        int i = 0;
        if (mCursor.moveToFirst()) {
            do {
                songs[i] = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                mAudioPath[i] = mCursor.getString(mCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                i++;
            } while (mCursor.moveToNext());
        }

        mCursor.close();

        return songs;
    }

}