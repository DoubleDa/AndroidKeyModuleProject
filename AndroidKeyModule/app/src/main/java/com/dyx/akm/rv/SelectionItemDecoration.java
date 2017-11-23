package com.dyx.akm.rv;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Author：dayongxin
 * Function：自定义实现选择块的分割线
 */
public class SelectionItemDecoration extends RecyclerView.ItemDecoration {
    public SelectionItemDecoration() {
        super();
    }

    /**
     * @param c
     * @param parent
     * @param state
     * @function 在提供给RecyclerView的Canvas中绘制任何适当的装饰。任何由此方法绘制的内容都将在绘制项目视图之前绘制，并会因此出现在视图的下方。
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }

    /**
     * @param c
     * @param parent
     * @param state
     * @function 在提供给RecyclerView的Canvas中绘制任何适当的装饰。在绘制项目视图之后，将绘制此方法绘制的任何内容，并将因此出现在观点之上。
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    /**
     * @param outRect
     * @param view
     * @param parent
     * @param state
     * @function 检索给定项目的任何偏移量。outRect的每个字段指定项目视图应包含的像素数量，类似于填充或边距。默认实现将outRect的边界设置为0并返回。
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }
}
