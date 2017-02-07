package com.example.administrator.allynmvp.bean;

/**
 * Created by Administrator on 2017/2/6.
 */

public class MusicItem {

    /***
     * name 名称
     * singer 歌手
     */
    private String name;
    private String singer;

    public MusicItem() {
    }

    public MusicItem(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
