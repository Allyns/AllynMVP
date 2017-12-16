package com.example.administrator.allynmvp.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.allynmvp.adapter.BannerAdapter;

import java.lang.reflect.Field;

/**
 * 无线循环ViewPager
 */

public class BannerViewPager extends ViewPager {

    private BannerAdapter mAdapter;

    //消息ID
    private int SCROLL_MSG_ID = 0x0111;
    //消息发送间隔时间
    private int time = 3000;

    public BannerScroller scroller;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == SCROLL_MSG_ID) {
                //切换到下一页
                setCurrentItem(getCurrentItem() + 1);
                //不断轮训 重新发送
                setScroll();
            }
        }
    };

    public BannerViewPager(Context context) {
        super(context);
    }

    public BannerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        //要改变动画持续时间必须改变ViewPager中   mScroller.startScroll(sx, sy, dx, dy, duration);的值
        //但是ViewPager中 mScroller的私有的无法直接获取进行设置 duration又是一个局部变量
        try {
            // 1.通过ViewPager类发射获取到 mScroller 属性
            Field field = ViewPager.class.getDeclaredField("mScroller");
            scroller = new BannerScroller(context);
            //强制转换
            field.setAccessible(true);
            //第一个参数是属性赋值到此类  第二个是替换着
            field.set(this, scroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * //改变ViewPager的切换动画持续时间
     * @param scrollerDuration
     */
    public void setScrollerDuration(int scrollerDuration) {
        scroller.setScrollerDuration(scrollerDuration);
    }

    public void setAdapter(BannerAdapter adapter) {
        this.mAdapter = adapter;
        setAdapter(new BannerPagerAdapter());
    }

    //关闭Activity的时候结束Handler的消息发送  由于Handler的生命周期比Activity长
    // 所以即使Activity关闭了Handler还是会继续发送消息 导致内存泄露
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeMessages(SCROLL_MSG_ID);
        handler = null;
    }

    public void setScroll() {
        //清除当前消息 避免多次发送
        handler.removeMessages(SCROLL_MSG_ID);
        //发送handler消息 实现轮播
        handler.sendEmptyMessageDelayed(SCROLL_MSG_ID, time);
    }

    //ViewPager在滑动的时候会一直不断的创建和销毁子View  所以它不会有内存泄露的情况出现
    class BannerPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            //为了实现无线循环ViewPager  这里设置ViewPager的最大值为Int的最大类型
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            //官方推荐 这么写
            return view == object;
        }

        //加载viewPager的子view
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mAdapter.getView(position);
            container.addView(itemView);
            return itemView;
        }


        //销毁ViewPager的只View
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            object = null;
        }
    }
}
