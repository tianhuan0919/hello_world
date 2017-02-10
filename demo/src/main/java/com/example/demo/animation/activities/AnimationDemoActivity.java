package com.example.demo.animation.activities;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.demo.R;

/**
 * Created by candy on 2017/2/5.
 */

public class AnimationDemoActivity extends Activity implements View.OnClickListener{

    private View showAttributeAnimView;
    private View showAnimSetView;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ac_animation_demo);

        findViews();
        setViewListener();
    }

    private void findViews() {
        showAttributeAnimView = findViewById(R.id.attribute_anim_show);
        showAnimSetView = findViewById(R.id.show_anim_set);
        mImageView = (ImageView) findViewById(R.id.anim_img);
    }

    private void setViewListener() {
        findViewById(R.id.test_layout_anim).setOnClickListener(this);
        findViewById(R.id.attribute_anim).setOnClickListener(this);
        mImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.test_layout_anim:
                startActivity(new Intent(AnimationDemoActivity.this, LayoutAnimationActivity.class));
                break;
            case R.id.attribute_anim:
               /* ValueAnimator colorAnim = ObjectAnimator.ofInt(showAttributeAnimView, "backgroundColor", 0xFFFF8080, 0xFF8080FF);
                colorAnim.setDuration(3000);
                colorAnim.setEvaluator(new ArgbEvaluator());
                colorAnim.setRepeatCount(ValueAnimator.INFINITE);
                colorAnim.setRepeatMode(ValueAnimator.REVERSE);
                colorAnim.start();*/
                ObjectAnimator translationUp = ObjectAnimator.ofInt(showAttributeAnimView,
                        "backgroundColor", Color.RED, Color.BLUE, Color.GRAY,
                        Color.GREEN);
                translationUp.setInterpolator(new LinearInterpolator());
                translationUp.setDuration(1500);
                translationUp.setRepeatCount(3);
                translationUp.setRepeatMode(ValueAnimator.REVERSE);
        /*
         * ArgbEvaluator：这种评估者可以用来执行类型之间的插值整数值代表ARGB颜色。
         * FloatEvaluator：这种评估者可以用来执行浮点值之间的插值。
         * IntEvaluator：这种评估者可以用来执行类型int值之间的插值。
         * RectEvaluator：这种评估者可以用来执行类型之间的插值矩形值。
         *
         * 由于本例是改变View的backgroundColor属性的背景颜色所以此处使用ArgbEvaluator
         */

                translationUp.setEvaluator(new ArgbEvaluator());
                translationUp.start();
                AnimatorSet set = new AnimatorSet();

                set.playTogether(
                        ObjectAnimator.ofFloat(showAnimSetView, "rotationX", 0, 360),
                        ObjectAnimator.ofFloat(showAnimSetView, "rotationY", 0, 180),
                        ObjectAnimator.ofFloat(showAnimSetView, "rotation", 0, 360),
                        ObjectAnimator.ofFloat(showAnimSetView, "translationX", 0, 90),
                        ObjectAnimator.ofFloat(showAnimSetView, "translationY", 0, 90),
                        ObjectAnimator.ofFloat(showAnimSetView, "scaleX", 1, 1.5f),
                        ObjectAnimator.ofFloat(showAnimSetView, "scaleY", 1, 1.5f),
                        ObjectAnimator.ofFloat(showAnimSetView, "alpha", 1, .25f, 1)
                );

                set.setDuration(5000).start();

                break;
            case R.id.anim_img:
                AnimatorSet set1 = new AnimatorSet();
                set1.playTogether(
                        ObjectAnimator.ofFloat(mImageView, "rotationY", 0.0F, 180F),
                        ObjectAnimator.ofFloat(mImageView, "rotationX", 0.0F, 360F),
                        ObjectAnimator.ofFloat(mImageView, "rotation", 0, 360),
                        ObjectAnimator.ofFloat(mImageView, "alpha", 1, .25f, 1)
                );
                set1.setDuration(3000).start();
                break;
        }
    }
}
