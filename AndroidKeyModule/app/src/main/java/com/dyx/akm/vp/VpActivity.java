package com.dyx.akm.vp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.dyx.akm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author：dayongxin
 * Function：
 */
public class VpActivity extends Activity {
    private static final String TAG = VpActivity.class.getName();
    private ViewPager mViewPager;
    private List<View> mList;
    private MyViewPagerAdapter mMyViewPagerAdapter;
    private int itemIndex = -1;
    private int currentPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vp);
        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.view_pager);
        /**
         * 1、制造数据源
         */
        mList = new ArrayList<>();
        LayoutInflater inflater = getLayoutInflater();
        mList.add(inflater.inflate(R.layout.vp_layout4, null, false));
        mList.add(inflater.inflate(R.layout.vp_layout1, null, false));
        mList.add(inflater.inflate(R.layout.vp_layout2, null, false));
        mList.add(inflater.inflate(R.layout.vp_layout3, null, false));
        mList.add(inflater.inflate(R.layout.vp_layout4, null, false));
        mList.add(inflater.inflate(R.layout.vp_layout1, null, false));
        /**
         * 2、添加适配器
         */
        mMyViewPagerAdapter = new MyViewPagerAdapter(mList);
        mViewPager.setAdapter(mMyViewPagerAdapter);
        //初始位置
        mViewPager.setCurrentItem(1);
        /**
         * 3、为ViewPager添加监听事件
         */
        //添加一个侦听器，只要此ViewPager的适配器发生更改，就会调用该侦听器
        mViewPager.addOnAdapterChangeListener(adapterChangeListener);
        //添加一个监听器，每当页面发生变化或增量滚动时，都将被调用
        mViewPager.addOnPageChangeListener(pageChangeListener);
        /**
         * 4、实现定时器
         */
        mMyHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }
        }, 3000);
    }

    private MyHandler mMyHandler = new MyHandler();

    private static class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }

    ViewPager.OnAdapterChangeListener adapterChangeListener = new ViewPager.OnAdapterChangeListener() {
        @Override
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter oldAdapter, @Nullable PagerAdapter newAdapter) {
            Log.i(TAG, "***onAdapterChanged***");
        }
    };

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Log.i(TAG, "***onPageScrolled***");
        }

        @Override
        public void onPageSelected(int position) {
            Log.i(TAG, "***onPageSelected***");
            currentPosition = position;
            mMyHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mViewPager.setCurrentItem((mViewPager.getCurrentItem() + 1) % mList.size());
                }
            }, 3000);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            Log.i(TAG, "***onPageScrollStateChanged***");
            switch (state) {
                case ViewPager.SCROLL_STATE_DRAGGING:
                    /**
                     * 手指滑动状态
                     */
                    mMyHandler.removeCallbacksAndMessages(null);
                    itemIndex = mViewPager.getCurrentItem();
                    break;
                case ViewPager.SCROLL_STATE_IDLE:
                    /**
                     * 停止状态
                     */
                    if (itemIndex == mViewPager.getCurrentItem()) {
                        mMyHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mViewPager.setCurrentItem((mViewPager.getCurrentItem() + 1) % mList.size());
                            }
                        }, 3000);
                    }
                    itemIndex = -1;
                    break;
                case ViewPager.SCROLL_STATE_SETTLING:
                    /**
                     * 自动滑动状态
                     */
                    break;
            }

            if (currentPosition == 0) {
                mViewPager.setCurrentItem(mList.size() - 2, false);
            } else if (currentPosition == mList.size() - 1) {
                mViewPager.setCurrentItem(1, false);
            }
        }
    };
}
