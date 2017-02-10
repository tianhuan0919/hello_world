package com.example.demo.animation.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import com.example.demo.R;
import com.example.demo.animation.adapter.LayoutAnimationAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by candy on 2017/2/5.
 */

public class LayoutAnimationActivity extends Activity {

    private ListView mListView;
    private List<String> data = new ArrayList<>();

    private LayoutAnimationAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ac_layout_animation);

        mListView = (ListView) findViewById(R.id.layout_animation_list);

        for(int i=0; i<10; i++){
            data.add(i+"号学生");
        }

        if(mAdapter == null){
            mAdapter = new LayoutAnimationAdapter(data, LayoutAnimationActivity.this);
        }

        mListView.setAdapter(mAdapter);



    }
}
