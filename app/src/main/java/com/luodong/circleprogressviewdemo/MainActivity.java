package com.luodong.circleprogressviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.luodong.circleprogressview.CircleProgressView;

public class MainActivity extends AppCompatActivity {

    private CircleProgressView v_cpv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v_cpv = findViewById(R.id.v_cpv);
//        v_cpv.setProgress();
    }
}
