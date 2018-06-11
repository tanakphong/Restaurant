package com.deverdie.restaurant.model;

import android.support.annotation.ArrayRes;

public class MainMenuRes {
    int ico;
    String desc;

    public MainMenuRes(@ArrayRes int ico, String desc) {
        this.ico = ico;
        this.desc = desc;
    }

    public int getIco() {
        return ico;
    }

    public void setIco(int ico) {
        this.ico = ico;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
