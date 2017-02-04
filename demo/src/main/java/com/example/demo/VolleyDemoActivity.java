package com.example.demo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by candy on 2017/1/11.
 */

public class VolleyDemoActivity extends Activity implements View.OnClickListener {

    private ImageView mImgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ac_volley_demo);

        mImgView = (ImageView) findViewById(R.id.volley_img);

        findViewById(R.id.get_req).setOnClickListener(this);
        findViewById(R.id.post_req).setOnClickListener(this);
        findViewById(R.id.img_req).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_req:
                volleyGet(VolleyDemoActivity.this, "http://weather.51wnl.com/weatherinfo/GetMoreWeather?cityCode=101020100&weatherType=0");
                break;
            case R.id.post_req:
                volleyPost(VolleyDemoActivity.this, "http://weather.51wnl.com/weatherinfo/GetMoreWeather?cityCode=101020100&weatherType=0");
                break;
            case R.id.img_req:
                VolleyImg(VolleyDemoActivity.this, "http://img.my.csdn.net/uploads/201308/31/1377949454_6367.jpg");
                break;
        }
    }

    private static final String TAG = "VolleyDemoActivity#";

    private void volleyGet(Context ctx, String url) {
        RequestQueue mQueue = Volley.newRequestQueue(ctx);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.d(TAG, jsonObject.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d(TAG, volleyError.getMessage(), volleyError);
            }
        });
        mQueue.add(jsonObjectRequest);
    }

    private void volleyPost(Context ctx, String url){
        RequestQueue mQueue = Volley.newRequestQueue(ctx);
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        JSONObject jsonParams = new JSONObject(map);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonParams, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.d("VolleyPost##", jsonObject.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("VolleyPost##", volleyError.toString(), volleyError);
            }
        });

        mQueue.add(jsonObjectRequest);
    }

    private void VolleyImg(Context ctx, String imgUrl){
        RequestQueue mQueue = Volley.newRequestQueue(ctx);
        ImageRequest imgRequest = new ImageRequest(imgUrl, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                mImgView.setImageBitmap(bitmap);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mImgView.setImageResource(R.mipmap.ic_launcher);
            }
        });
        mQueue.add(imgRequest);
    }

}
