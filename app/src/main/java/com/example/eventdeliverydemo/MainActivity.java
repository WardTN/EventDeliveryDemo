package com.example.eventdeliverydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CHEN";
    private boolean dispatch, touch;
    private RelativeLayoutView group;
    private MyView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group = (RelativeLayoutView) this.findViewById(R.id.group);
        view = (MyView) this.findViewById(R.id.view);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "Activity dispatchTouchEvent -> " + TouchUtils.getTouchAction(ev.getAction()));
        if (dispatch) return true;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"Activity onTouchEvent -> "+ TouchUtils.getTouchAction(event.getAction())) ;
        if(touch) return true ;
        return super.onTouchEvent(event);
    }

    public void onCheckBox(View v){
        CheckBox checkBox = (CheckBox)v ;
        boolean isChecked = checkBox.isChecked() ? true : false ;
        switch (v.getId()){
            case R.id.a_dispatch :
                this.dispatch = isChecked ;
                break;
            case R.id.a_touch :
                this.touch = isChecked ;
                break;
            case R.id.g_dispatch :
                group.setDispatch(isChecked);
                break;
            case R.id.g_intercept :
                group.setIntercept(isChecked);
                break;
            case R.id.g_touch :
                group.setTouch(isChecked);
                break;
            case R.id.v_dispatch :
                view.setDispatch(isChecked);
                break;
            case R.id.v_touch :
                view.setTouch(isChecked);
                break;
        }
    }

    public void setDispatch(boolean dispatch) {
        this.dispatch = dispatch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }
}
