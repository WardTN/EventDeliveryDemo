package com.example.eventdeliverydemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class RelativeLayoutView extends RelativeLayout {
    private static final String TAG = "CHEN" ;
    private boolean dispatch,touch,intercept ;
    public RelativeLayoutView(Context context) {
        super(context);
    }

    public RelativeLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RelativeLayoutView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.w(TAG,"Group dispatchTouchEvent -> "+ TouchUtils.getTouchAction(ev.getAction())) ;
        if(dispatch)return true;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.w(TAG,"Group onInterceptTouchEvent -> "+ TouchUtils.getTouchAction(ev.getAction())) ;
        if(intercept)return true;
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.w(TAG,"Group onTouchEvent -> "+ TouchUtils.getTouchAction(event.getAction())) ;
        if(touch)return true;
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

    public boolean isIntercept() {
        return intercept;
    }

    public void setIntercept(boolean intercept) {
        this.intercept = intercept;
    }
}