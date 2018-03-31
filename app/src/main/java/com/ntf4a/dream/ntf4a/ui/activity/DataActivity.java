package com.ntf4a.dream.ntf4a.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.ntf4a.dream.ntf4a.R;
import com.ntf4a.dream.ntf4a.db.pojo.PasswordInfo;
import com.ntf4a.dream.ntf4a.ui.activity.base.BaseActivity;
import com.ntf4a.dream.ntf4a.ui.adapter.DataAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataActivity extends BaseActivity {
    ListView listView;
    Button addData;
    List<PasswordInfo> dataSource = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        PasswordInfo info;
        for (int i = 0; i < 10; i++) {
            info = new PasswordInfo();
            info.setPwdDescription("nihao "+i);
            dataSource.add(info);
        }
        initView();



    }

    private void initView() {
        addData = findViewById(R.id.add_data);
        listView = findViewById(R.id.listView);
        DataAdapter dataAdapter = new DataAdapter(mActivity,dataSource);
        listView.setAdapter(dataAdapter);
    }
}

