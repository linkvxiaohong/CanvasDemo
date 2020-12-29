package com.linkv.canvasdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyCustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomView = findViewById(R.id.mCustomView);

        findViewById(R.id.btn_rotate).setOnClickListener(this);
        findViewById(R.id.btn_restore).setOnClickListener(this);
        findViewById(R.id.btn_scale).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_rotate:
                mCustomView.setSampleType(MyCustomView.SAMPLE_TYPE_ROTATE);
                break;
            case R.id.btn_restore:
                mCustomView.setSampleType(MyCustomView.SAMPLE_TYPE_RESTORE);
                break;
            case R.id.btn_scale:
                mCustomView.setSampleType(MyCustomView.SAMPLE_TYPE_SCALE);
                break;
        }

    }
}
