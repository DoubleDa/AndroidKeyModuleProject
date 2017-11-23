package com.dyx.akm.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author：dayongxin
 * Function：
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<T> mDatas;
    private OnItemClickListener<T> OnItemClickListener;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        ((BaseViewHolder) holder).setData(mDatas.get(position), position, OnItemClickListener);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createViewHolder(parent.getContext(), parent);
    }

    protected abstract BaseViewHolder createViewHolder(Context context, ViewGroup parent);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        OnItemClickListener = onItemClickListener;
    }

    public void refreshData(List<T> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }
}
