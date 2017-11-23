package com.dyx.akm.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Author：dayongxin
 * Function：
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(Context context, ViewGroup root, int layoutRes) {
        super(LayoutInflater.from(context).inflate(layoutRes, root, false));
        ButterKnife.bind(this, itemView);
    }

    public void setData(T t, int position, OnItemClickListener<T> onItemClickListener) {
        bindData(t, position, onItemClickListener);
    }

    protected abstract void bindData(T t, int position, OnItemClickListener<T> onItemClickListener);
}
