package com.example.administrator.allynmvp.view;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * on 2017/12/16.
 * 2.自定义Scroller  重写startScroll方法改变duration的值  从而实现自定义持续时间
 */

public class BannerScroller extends Scroller {


    //设置自定义持续时间的默认值为1000
    private int mScrollerDuration = 1000;

    public BannerScroller(Context context) {
        super(context);
    }

    public BannerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public BannerScroller(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mScrollerDuration);
    }

    public int getScrollerDuration() {
        return mScrollerDuration;
    }

    public void setScrollerDuration(int mScrollerDuration) {
        this.mScrollerDuration = mScrollerDuration;
    }

}
