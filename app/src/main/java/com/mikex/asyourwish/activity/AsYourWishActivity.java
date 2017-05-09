package com.mikex.asyourwish.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mike.asyourwish.R;
import com.mikex.asyourwish.models.LoginInfo;
import com.mikex.asyourwish.presenter.AsYourWishPresenter;
import com.mikex.asyourwish.viewInterface.IAsYourWishView;

public class AsYourWishActivity extends AppCompatActivity implements View.OnClickListener,IAsYourWishView{

    private EditText mEtAccount;
    private EditText mEtPwd;
    private Button mBtnLogin;
    private Button mBtnForgotPwd;
    private Button mBtnWeChat;
    private Button mBtnWeibo;
    private Button mBtnNewAccount;

    private AsYourWishPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_your_wish);
        initView();
        mPresenter = new AsYourWishPresenter(this,this);
    }

    private void initView(){
        mEtAccount = (EditText)findViewById(R.id.et_ayw_account);
        mEtPwd = (EditText)findViewById(R.id.et_ayw_pwd);
        mBtnLogin = (Button)findViewById(R.id.btn_asy_login);
        mBtnLogin.setOnClickListener(this);
        mBtnForgotPwd = (Button)findViewById(R.id.btn_ayw_forgot_pwd);
        mBtnForgotPwd.setOnClickListener(this);
        mBtnWeChat = (Button)findViewById(R.id.btn_ayw_wechat);
        mBtnWeChat.setOnClickListener(this);
        mBtnWeibo = (Button)findViewById(R.id.btn_ayw_weibo);
        mBtnWeibo.setOnClickListener(this);
        mBtnNewAccount = (Button) findViewById(R.id.btn_ayw_new_account);
        mBtnNewAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_asy_login:
                mPresenter.login();
                break;
            case R.id.btn_ayw_forgot_pwd:
                break;
            case R.id.btn_ayw_wechat:
                break;
            case R.id.btn_ayw_weibo:
                break;
            case R.id.btn_ayw_new_account:
                break;
        }
    }

    @Override
    public void updateView() {

    }

    @Override
    public View getAccountEditText() {
        return mEtAccount;
    }

    @Override
    public View getPwdEditText() {
        return mEtPwd;
    }

    @Override
    public void loginSucceed() {
        Intent intent = new Intent();
        intent.setClass(this,AywMainActivity.class);
        startActivity(intent);
    }

}
