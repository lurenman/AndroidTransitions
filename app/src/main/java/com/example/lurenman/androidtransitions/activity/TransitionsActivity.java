package com.example.lurenman.androidtransitions.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.example.lurenman.androidtransitions.R;

/**
 * @author: baiyang.
 * Created on 2018/1/10.
 * 参考
 * https://github.com/lgvalle/Material-Animations
 * https://github.com/lgvalle/Material-Animations
 * explode(分解) – 从屏幕中间进或出
 * slide(滑动) - 从屏幕边缘进或出地
 * fade(淡出) –通过改变屏幕上视图的不透明度达到添加或者移除视图的效果
 */

public class TransitionsActivity extends BaseActivity {
    private Button bt_Explode_code;
    private Button bt_Explode_xml;
    private Button bt_Slide_code;
    private Button bt_Slide_xml;
    private Button bt_Fade_xml;
    private Button bt_Fade_code;
    private Button bt_Exit;

    @NonNull
    @Override
    protected String getActionBarTitle() {
        return "Transitions";
    }

    @Override
    protected void setupWindowAnimations() {
        super.setupWindowAnimations();
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.RIGHT);
        slideTransition.setDuration(500);
        getWindow().setEnterTransition(slideTransition);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_transitions);
        bt_Explode_code = (Button) findViewById(R.id.bt_Explode_code);
        bt_Explode_xml = (Button) findViewById(R.id.bt_Explode_xml);
        bt_Slide_code = (Button) findViewById(R.id.bt_Slide_code);
        bt_Slide_xml = (Button) findViewById(R.id.bt_Slide_xml);
        bt_Fade_code = (Button) findViewById(R.id.bt_Fade_code);
        bt_Fade_xml = (Button) findViewById(R.id.bt_Fade_xml);
        bt_Exit = (Button) findViewById(R.id.bt_Exit);

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        bt_Explode_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ExplodeActivity.class);
                intent.putExtra(EXTRA_TYPE, TYPE_CODE);
                transitionTo(intent);
            }
        });
        bt_Explode_xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ExplodeActivity.class);
                intent.putExtra(EXTRA_TYPE, TYPE_XML);
                transitionTo(intent);
            }
        });
        bt_Slide_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SlideActivity.class);
                intent.putExtra(EXTRA_TYPE, TYPE_CODE);
                transitionTo(intent);
            }
        });
        bt_Slide_xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SlideActivity.class);
                intent.putExtra(EXTRA_TYPE, TYPE_XML);
                transitionTo(intent);
            }
        });
        bt_Fade_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FadeActivity.class);
                intent.putExtra(EXTRA_TYPE, TYPE_CODE);
                transitionTo(intent);
            }
        });
        bt_Fade_xml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FadeActivity.class);
                intent.putExtra(EXTRA_TYPE, TYPE_XML);
                transitionTo(intent);
            }
        });
        bt_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Slide slide = new Slide();
                slide.setDuration(500);
                slide.setSlideEdge(Gravity.TOP);//不设置是重BOTTOM
                getWindow().setReturnTransition(slide);
                //如果没有上面代码退出就是怎么进来的怎么出去
                finishAfterTransition();
            }
        });
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void loadData() {

    }
}
