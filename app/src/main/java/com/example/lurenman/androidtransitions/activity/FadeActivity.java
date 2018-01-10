package com.example.lurenman.androidtransitions.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lurenman.androidtransitions.R;

/**
 * @author: baiyang.
 * Created on 2018/1/10.
 */

public class FadeActivity extends BaseActivity {

    private ImageView iv_img;
    private Button bt_exit;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "Fade";
    }

    @Override
    protected void initAdvanceVariables() {
        super.initAdvanceVariables();
        int type = getIntent().getIntExtra(EXTRA_TYPE, TYPE_CODE);
        mType = type;
    }

    @Override
    protected void setupWindowAnimations() {
        Transition transition = null;
        if (mType == TYPE_CODE) {
            transition = buildEnterTransition();
        } else {
            //这种强制转换还不行用这个Transition父类就好了
            transition = TransitionInflater.from(mContext).inflateTransition(R.transition.fade);
        }
        getWindow().setEnterTransition(transition);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_fade);
        iv_img = (ImageView) findViewById(R.id.iv_img);
        bt_exit = (Button) findViewById(R.id.bt_exit);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
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
    private Transition buildEnterTransition(){
        Fade fade = new Fade();
        fade.setDuration(2000);
        //意思就是之低昂这个View没有转场动画
       // fade.excludeTarget(R.id.iv_img,true);
        return fade;
    }
}
