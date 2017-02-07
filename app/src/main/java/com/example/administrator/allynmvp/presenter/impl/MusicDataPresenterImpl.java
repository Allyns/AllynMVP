package com.example.administrator.allynmvp.presenter.impl;

import com.example.administrator.allynmvp.bean.MusicItem;
import com.example.administrator.allynmvp.presenter.MusicDataPresenter;
import com.example.administrator.allynmvp.view.ViewControl;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Random;

/**
 * Created by Administrator on 2017/2/6.
 */

public class MusicDataPresenterImpl implements MusicDataPresenter {

    ViewControl control;
    boolean isshowData = false;

    public MusicDataPresenterImpl(ViewControl control) {
        if (control == null) {
            throw new IllegalArgumentException("ViewControl is null");
        }
        this.control = control;
    }

    @Override
    public void getMusiclist(int id) {
        control.showProgress();

        if (new Random().nextInt(3) == 2) {
            control.showError();
            isshowData = true;
        }
        if (isshowData==false) {
            ArrayList<MusicItem> list = new ArrayList<>();
            for (int i = 0; i <= 20; i++) {
                MusicItem bean = new MusicItem("演员" + i, "薛之谦" + i);
                MusicItem bean1 = new MusicItem("飞羽时光" + i, "周笔畅" + i);
                MusicItem bean2 = new MusicItem("逆战" + i, "张杰" + i);
                list.add(bean);
                list.add(bean1);
                list.add(bean2);
            }
            control.setMusicData(list);
        }
        control.unshowProgress();
    }
}
