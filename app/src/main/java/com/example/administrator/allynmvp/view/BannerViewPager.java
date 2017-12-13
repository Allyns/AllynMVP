package com.example.administrator.allynmvp.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.allynmvp.adapter.BannerAdapter;

/**
 *无线循环ViewPager
 */

public class BannerViewPager extends ViewPager {

    private BannerAdapter mAdapter;

    public BannerViewPager(Context context) {
        super(context);
    }

    public BannerViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAdapter(BannerAdapter adapter) {
        this.mAdapter = adapter;
        setAdapter(new  BannerPagerAdapter());
    }

    //ViewPager在滑动的时候会一直不断的创建和销毁子View  所以它不会有内存泄露的情况出现
    class  BannerPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            //为了实现无线循环ViewPager  这里设置ViewPager的最大值为Int的最大类型
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            //官方推荐 这么写
            return view==object;
        }

        //加载viewPager的子view
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
           View itemView= mAdapter.getView(position);
           container.addView(itemView);
          return  itemView;
        }


        //销毁ViewPager的只View
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
          container.removeView((View) object);
            object=null;
        }
    }
}
