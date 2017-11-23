package com.dyx.akm.rv;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyx.akm.R;

import butterknife.BindView;

/**
 * Author：dayongxin
 * Function：
 */
public class SimpleViewHolder extends BaseViewHolder<String> {
    @BindView(R.id.tv_simple)
    TextView tvSimple;

    public SimpleViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.rv_item_layout);
    }

    @Override
    protected void bindData(String s, int position, OnItemClickListener<String> onItemClickListener) {
        if (!s.equals("")) {
            tvSimple.setText(s);
        }
    }
}
