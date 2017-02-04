package com.example.demo;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by candy on 2017/1/11.
 */

public class DiyToast{

    public static Toast diyToast(Context ctx, String value){
        Toast toast = new Toast(ctx);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        View v = LayoutInflater.from(ctx).inflate(R.layout.view_diy_toast, null);
        TextView showContent = (TextView) v.findViewById(R.id.textView);
        showContent.setText(value);
        toast.setView(v);
        return toast;
    }

}
