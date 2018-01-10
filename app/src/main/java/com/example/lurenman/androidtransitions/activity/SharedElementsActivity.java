package com.example.lurenman.androidtransitions.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.lurenman.androidtransitions.R;

/**
 * @author: baiyang.
 * Created on 2018/1/10.
 * Fragment的不展示
 */

public class SharedElementsActivity extends BaseActivity {
    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "SharedElements";
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
       setContentView(R.layout.activity_shared_elements);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void loadData() {

    }
}
