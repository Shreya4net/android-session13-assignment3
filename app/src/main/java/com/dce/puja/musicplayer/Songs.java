package com.dce.puja.musicplayer;

/**
 * Created by Devendra on 4/19/2017.
 */

public class Songs {

 private String mSongID;
    private String mSongTitle;
    private long album;

    public Songs(String id, String title, long al){
        mSongID = id;
        mSongTitle = title;
        album = al;
    }

    public long getAlbum() {
        return album;
    }

    public String getSongID(){
        return mSongID;
    }

    public String getSongTitle(){
        return mSongTitle;
    }

    @Override
    public String toString() {
        super.toString();
        return mSongTitle;
    }
}

