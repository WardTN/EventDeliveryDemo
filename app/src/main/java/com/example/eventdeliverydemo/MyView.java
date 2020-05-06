package com.example.eventdeliverydemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyView extends androidx.appcompat.widget.AppCompatTextView {
    private static final String TAG = "CHEN";
    private boolean dispatch, touch;

    public MyView(Context context) {
        super(context);
    }
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "View dispatchTouchEvent  -> " + TouchUtils.getTouchAction(event.getAction()));
        if (dispatch) return true;
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.w(TAG, "View onTouchEvent -> " + TouchUtils.getTouchAction(event.getAction()));
        if (touch) return true;
        return super.onTouchEvent(event);
    }

    public boolean isDispatch() {
        return dispatch;
    }

    public void setDispatch(boolean dispatch) {
        this.dispatch = dispatch;
    }

    public boolean isTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }
}
