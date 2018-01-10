package com.example.lurenman.androidtransitions.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;

import com.example.lurenman.androidtransitions.R;

/**
 * @author: baiyang.
 * Created on 2018/1/10.
 */

public class ExplodeActivity extends BaseActivity {
    private Button bt_exit;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "Explode";
    }

    @Override
    protected void initAdvanceVariables() {
        int type = getIntent().getIntExtra(EXTRA_TYPE, TYPE_CODE);
        mType = type;
    }

    @Override
    protected void setupWindowAnimations() {
        Transition transition = null;
        if (mType == TYPE_CODE) {
            transition = new Explode();
            transition.setDuration(500);
        } else {
            //这种强制转换还不行用这个Transition父类就好了
            transition  = TransitionInflater.from(mContext).inflateTransition(R.transition.explode);
        }
        getWindow().setEnterTransition(transition);

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_explode);
        bt_exit = (Button) findViewById(R.id.bt_exit);
    }


    @Override
    protected void initVariables() {

    }

    @Override
    protected void initEnvent() {
        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
