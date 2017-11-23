package com.dyx.akm.rv;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyx.akm.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author：dayongxin
 * Function：
 */
public class SimpleAdapterActivity extends Activity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private SimpleAdapter mSimpleAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        ButterKnife.bind(this);
        mSimpleAdapter = new SimpleAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mSimpleAdapter);
        mSimpleAdapter.refreshData(getDatas());
    }

    private List<String> getDatas() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        return list;
    }
}
