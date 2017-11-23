package com.dyx.akm.rv;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.util.SparseBooleanArray;

/**
 * Author：dayongxin
 * Function：
 */
public class MyLayoutManager extends RecyclerView.LayoutManager {
    /**
     * 保存item的位置信息
     */
    private SparseArray<Rect> allItemRects = new SparseArray<>();
    /**
     * 保存item是否处于可见状态的信息
     */
    private SparseBooleanArray itemStates = new SparseBooleanArray();

    /**
     * @return
     * @function 1、构造方法
     */
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    /**
     * @param recycler
     * @param state
     * @function 2、计算每个ItemView的位置
     */
    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        //先把所有的View先从RecyclerView中detach掉，然后标记为"Scrap"状态，表示这些View处于可被重用状态(非显示中)。实际就是把View放到了Recycler中的一个集合中。
        detachAndScrapAttachedViews(recycler);
        //计算子视图的位置
        calculateChildrenPosition(recycler);
    }

    private void calculateChildrenPosition(RecyclerView.Recycler recycler) {

    }

    /**
     * 3、处理滑动
     */
    /**
     * @return
     * @function 是否可以水平滑动
     */
    @Override
    public boolean canScrollHorizontally() {
        return super.canScrollHorizontally();
    }

    /**
     * @return
     * @function 是否可以垂直滑动
     */
    @Override
    public boolean canScrollVertically() {
        return super.canScrollVertically();
    }

    /**
     * @param dx
     * @param recycler
     * @param state
     * @return
     * @function 水平滑动距离
     */
    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollHorizontallyBy(dx, recycler, state);
    }

    /**
     * @param dy
     * @param recycler
     * @param state
     * @return
     * @function 垂直滑动距离
     */
    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollVerticallyBy(dy, recycler, state);
    }

    @Override
    public void onAdapterChanged(RecyclerView.Adapter oldAdapter, RecyclerView.Adapter newAdapter) {
        super.onAdapterChanged(oldAdapter, newAdapter);
    }

    @Override
    public void scrollToPosition(int position) {
        super.scrollToPosition(position);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        super.smoothScrollToPosition(recyclerView, state, position);
    }


    @Override
    public boolean supportsPredictiveItemAnimations() {
        return super.supportsPredictiveItemAnimations();
    }

    @Override
    public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsRemoved(recyclerView, positionStart, itemCount);
    }
}
