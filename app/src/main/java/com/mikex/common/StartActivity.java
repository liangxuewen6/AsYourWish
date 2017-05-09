package com.mikex.common;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mike.asyourwish.R;
import com.mikex.asyourwish.activity.AsYourWishActivity;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnAsYourWish;
    private Button mBtnMapUsage;
    private Button mBtnOpenGl;
    private Button mBtnAi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initView();
    }

    private void initView(){
        mBtnAsYourWish = (Button) findViewById(R.id.btn_as_your_wish);
        mBtnAsYourWish.setOnClickListener(this);
        mBtnMapUsage = (Button) findViewById(R.id.btn_map_usage);
        mBtnMapUsage.setOnClickListener(this);
        mBtnOpenGl = (Button)findViewById(R.id.btn_open_gl);
        mBtnOpenGl.setOnClickListener(this);
        mBtnAi = (Button) findViewById(R.id.btn_ai);
        mBtnAi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_as_your_wish:
                Intent intent = new Intent();
                intent.setClass(this,AsYourWishActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_map_usage:
                break;
            case R.id.btn_open_gl:
                break;
            case R.id.btn_ai:
                break;
        }
    }
}
