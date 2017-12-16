package com.example.administrator.allynmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.allynmvp.adapter.BannerAdapter;
import com.example.administrator.allynmvp.adapter.MusicAdapter;
import com.example.administrator.allynmvp.bean.MusicItem;
import com.example.administrator.allynmvp.presenter.MusicDataPresenter;
import com.example.administrator.allynmvp.presenter.impl.MusicDataPresenterImpl;
import com.example.administrator.allynmvp.view.BannerViewPager;
import com.example.administrator.allynmvp.view.ViewControl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewControl {

    MusicDataPresenter musicDataPresenter;
    ListView listView;
    ProgressBar progressBar;
    TextView tvError;
    BannerViewPager mBannerVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();
        listener();
        getBannerData();
    }

    public void getBannerData() {
        //这里通过网络加载无效广告轮播的图片
        //初始化控件
        mBannerVp.setAdapter(new BannerAdapter() {
            @Override
            public View getView(int position) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setBackgroundResource(R.mipmap.ic_launcher);
                return imageView;
            }
        });
        mBannerVp.setScroll();
        mBannerVp.setScrollerDuration(3000);
    }

    private void initView() {
        musicDataPresenter = new MusicDataPresenterImpl(this);
        listView = (ListView) findViewById(R.id.listView);
        mBannerVp = (BannerViewPager) findViewById(R.id.banner_vp);
        progressBar = (ProgressBar) findViewById(R.id.pro_loading);
        tvError = (TextView) findViewById(R.id.tv_error);
    }

    public void getData() {
        musicDataPresenter.getMusiclist(0);
    }

    private void listener() {
        tvError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void unshowProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        tvError.setVisibility(View.VISIBLE);
    }

    @Override
    public void setMusicData(final ArrayList<MusicItem> musicData) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, musicData.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        MusicAdapter arrayAdapter = new MusicAdapter(this, R.layout.item_layout, musicData);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void clase() {

    }


}
