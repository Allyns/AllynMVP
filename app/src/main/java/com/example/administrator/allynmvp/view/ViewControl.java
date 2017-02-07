package com.example.administrator.allynmvp.view;

import com.example.administrator.allynmvp.bean.MusicItem;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/6.
 */

public interface ViewControl {
    void showProgress();
    void unshowProgress();
    void showError();
    void setMusicData(ArrayList<MusicItem> musicData);
    void clase();
}
