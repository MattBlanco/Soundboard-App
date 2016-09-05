package com.example.matt.soundboard;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;

/**
 * Created by Matt on 9/4/2016.
 */
public class Sound implements Parcelable{
    private int mData;
    private Activity activity;
    protected MediaPlayer mp;
    protected Button button;

    public Sound(int sound, int buttonID, Activity _activity){
        super();
        this.activity = _activity;
        mp = MediaPlayer.create(activity, sound);
        button = (Button) activity.findViewById(buttonID);
    }

    public Sound(int buttonID, Activity _activity) {
        super();
        this.activity = _activity;
        button = (Button) activity.findViewById(buttonID);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Sound> CREATOR = new Parcelable.Creator<Sound>() {
        public Sound createFromParcel(Parcel in) {
            return new Sound(in);
        }

        public Sound[] newArray(int size) {
            return new Sound[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Sound(Parcel in) {
        mData = in.readInt();
    }
    

}
