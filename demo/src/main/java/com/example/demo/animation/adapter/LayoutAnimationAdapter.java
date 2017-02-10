package com.example.demo.animation.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by candy on 2017/2/5.
 */

public class LayoutAnimationAdapter extends BaseAdapter {

    private List<String> data;
    private Context context;

    public LayoutAnimationAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);
        tv.setText(data.get(position));
        tv.setTextColor(Color.parseColor("#333333"));
        tv.setTextSize(32);
        return tv;
    }
}
