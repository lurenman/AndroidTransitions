package com.example.lurenman.androidtransitions.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.lurenman.androidtransitions.TransitionHelper;

/**
 * Created by Administrator on 2017/7/27 0027.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    protected int mType = -1;
    protected static final String EXTRA_TYPE = "type";
    protected final int TYPE_CODE = 0;
    protected final int TYPE_XML = 1;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle(getActionBarTitle());
        initAdvanceVariables();
        setupWindowAnimations();
        initViews(savedInstanceState);
        initVariables();
        initEnvent();
        loadData();
    }

    /**
     * 在setLayout之前加载的数据
     */
    protected void initAdvanceVariables() {
    }

    /**
     * 初始转场动画调用
     */
    protected void setupWindowAnimations() {

    }

    protected abstract @NonNull
    String getActionBarTitle();

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract void initVariables();

    protected abstract void loadData();

    protected void initEnvent() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // finish();
                //https://www.jianshu.com/p/78de93f71965
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }

    /**
     * 子类调用的通用转场开启activity
     *
     * @param intent
     */
    protected void transitionTo(Intent intent) {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(intent, transitionActivityOptions.toBundle());
    }

}
