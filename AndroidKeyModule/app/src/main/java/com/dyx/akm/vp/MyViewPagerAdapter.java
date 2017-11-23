package com.dyx.akm.vp;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author：dayongxin
 * Function：
 */
public class MyViewPagerAdapter extends PagerAdapter {
    private List<View> mDatas;

    public MyViewPagerAdapter() {
    }

    public MyViewPagerAdapter(List<View> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mDatas.get(position));
        return mDatas.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mDatas.get(position));
    }
}
