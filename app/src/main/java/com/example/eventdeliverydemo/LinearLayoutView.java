package com.example.eventdeliverydemo;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class LinearLayoutView extends LinearLayout {
    private static final String TAG = "CHEN";

    public LinearLayoutView(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent -> " + TouchUtils.getTouchAction(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent: " + TouchUtils.getTouchAction(ev.getAction()));
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent -> " + TouchUtils.getTouchAction(event.getAction()));
        return super.onTouchEvent(event);
    }
}
