package com.example.administrator.allynmvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.allynmvp.R;
import com.example.administrator.allynmvp.adapter.BannerAdapter;

/**
 * Created by apple on 2017/12/17.
 */

public class BannerView extends RelativeLayout {

    private BannerViewPager mBannerViewpager;
    private LinearLayout mlayoutView;
    private TextView mtitle;
    private BannerAdapter mAdapter;

    public BannerView(Context context) {
        super(context);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.banner_layout, this);
        initView();
    }

    public  void initView() {
        mlayoutView = (LinearLayout) findViewById(R.id.ban_line_layout);
        mBannerViewpager = (BannerViewPager) findViewById(R.id.ban_viewpager);
        mtitle = (TextView) findViewById(R.id.ban_title);
    }

    public void setAdapter(BannerAdapter adapter) {
        this.mAdapter = adapter;
        mBannerViewpager.setAdapter(adapter);
    }

    public void setScroll() {
        mBannerViewpager.setScroll();
    }

    public void setScrollerDuration(int scrollerDuration) {
        mBannerViewpager.setScrollerDuration(scrollerDuration);
    }
}
