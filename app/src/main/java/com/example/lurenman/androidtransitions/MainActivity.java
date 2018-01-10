package com.example.lurenman.androidtransitions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lurenman.androidtransitions.activity.SharedElementsActivity;
import com.example.lurenman.androidtransitions.activity.TransitionsActivity;

/**
 * (1)setExitTransition() - 当A startB时，使A中的View退出场景的transition    在A中设置
 * (2)setEnterTransition() - 当A startB时，使B中的View进入场景的transition    在B中设置
 * (3)setReturnTransition() - 当B 返回A时，使B中的View退出场景的transition  在B中设置
 * (4)setReenterTransition() - 当B 返回A时，使A中的View进入场景的transition   在A中设置
 */
public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private Button bt_Transitions;
    private Button bt_Shared_Elements;
    private Button bt_View_animations;
    private Button bt_CircularRevealAnimation;
    private ImageView iv_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setupWindowAnimations();
        mContext = this;
        bt_Transitions = (Button) findViewById(R.id.bt_Transitions);
        bt_Shared_Elements = (Button) findViewById(R.id.bt_Shared_Elements);
        iv_share = (ImageView) findViewById(R.id.iv_share);//共享View
        bt_View_animations = (Button) findViewById(R.id.bt_View_animations);
        bt_CircularRevealAnimation = (Button) findViewById(R.id.bt_CircularRevealAnimation);
        initEvents();


    }

    private void setupWindowAnimations() {
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(500);
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
    }

    private void initEvents() {
        bt_Transitions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TransitionsActivity.class);
                //startActivity(intent);
                //将原先的跳转改成如下方式
                // startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(MainActivity.this, true);
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent, transitionActivityOptions.toBundle());

            }
        });
        //共享动画
        bt_Shared_Elements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, SharedElementsActivity.class);
                intent.putExtra("transition", "share");
                //将原先的跳转改成如下方式，注意这里面的第三个参数决定了ActivityTwo 布局中的android:transitionName的值，它们要保持一致
                //要展示多个共享元素动画的用 Pair<View, String>[] pairs这个
                startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, iv_share, "shareTransition").toBundle());
            }
        });
    }
}
