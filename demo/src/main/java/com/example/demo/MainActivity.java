package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.demo.animation.activities.AnimationDemoActivity;
import com.example.demo.diyview.DiyToast;
import com.example.demo.volley.VolleyDemoActivity;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        findViewById(R.id.diy_toast).setOnClickListener(this);
        findViewById(R.id.animation_demo).setOnClickListener(this);
        findViewById(R.id.volley_demo).setOnClickListener(this);
        findViewById(R.id.android_studio_template).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.diy_toast:
                new DiyToast().diyToast(MainActivity.this, "孙悟空大闹天宫").show();
                break;
            case R.id.animation_demo:
                startActivity(new Intent(MainActivity.this, AnimationDemoActivity.class));
                break;
            case R.id.volley_demo:
                startActivity(new Intent(MainActivity.this, VolleyDemoActivity.class));
                break;
            case R.id.android_studio_template:
                break;
        }
    }
}
