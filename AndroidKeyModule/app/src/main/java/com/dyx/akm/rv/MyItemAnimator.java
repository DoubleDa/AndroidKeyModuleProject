package com.dyx.akm.rv;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.animation.BounceInterpolator;

import com.dyx.akm.R;

/**
 * Author：dayongxin
 * Function：
 */
public class MyItemAnimator extends SimpleItemAnimator {
    private Context mContext;

    public MyItemAnimator(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        return false;
    }

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        //1、获取Animator对象
        Animator animator = AnimatorInflater.loadAnimator(mContext, R.animator.zoom_in);
        //2、用于计算动画已用部分的时间插值器
        animator.setInterpolator(new BounceInterpolator());
        //3、设置添加动画目标对象
        animator.setTarget(holder.itemView);
        //4、动画开始
        animator.start();
        return true;
    }

    @Override
    public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        return false;
    }

    @Override
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromLeft, int fromTop, int toLeft, int toTop) {
        return false;
    }

    @Override
    public void runPendingAnimations() {

    }

    @Override
    public void endAnimation(RecyclerView.ViewHolder item) {

    }

    @Override
    public void endAnimations() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
