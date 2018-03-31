package com.ntf4a.dream.ntf4a.ui.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {
    protected BaseActivity mActivity;


    protected void startActivityAndFinish(Class<? extends Activity> cls){
        Intent intent = new Intent(mActivity,cls);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
    }
}
