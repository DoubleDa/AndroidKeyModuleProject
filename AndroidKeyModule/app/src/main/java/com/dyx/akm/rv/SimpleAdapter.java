package com.dyx.akm.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Author：dayongxin
 * Function：
 */
public class SimpleAdapter extends BaseAdapter<String> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new SimpleViewHolder(context, parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
