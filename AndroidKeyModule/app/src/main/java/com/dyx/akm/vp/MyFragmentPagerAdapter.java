package com.dyx.akm.vp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * Author：dayongxin
 * Function：
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGER_SIZE = 4;
    private static final int PAGER_INDEX_ONE = 1;
    private static final int PAGER_INDEX_TWO = 2;
    private static final int PAGER_INDEX_THREE = 3;
    private static final int PAGER_INDEX_FOUR = 4;
    private VpFragment1 mVpFragment1 = null;
    private VpFragment2 mVpFragment2 = null;
    private VpFragment3 mVpFragment3 = null;
    private VpFragment4 mVpFragment4 = null;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mVpFragment1 = new VpFragment1();
        mVpFragment2 = new VpFragment2();
        mVpFragment3 = new VpFragment3();
        mVpFragment4 = new VpFragment4();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case PAGER_INDEX_ONE:
                fragment = new VpFragment1();
                break;
            case PAGER_INDEX_TWO:
                fragment = new VpFragment2();
                break;
            case PAGER_INDEX_THREE:
                fragment = new VpFragment3();
                break;
            case PAGER_INDEX_FOUR:
                fragment = new VpFragment4();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_SIZE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
