package com.mikex.asyourwish.presenter;

import android.content.Context;
import android.text.Editable;
import android.widget.EditText;

import com.mikex.asyourwish.models.LoginInfo;
import com.mikex.asyourwish.viewInterface.IAsYourWishView;

/**
 * Created by zhibinw on 5/9/2017.
 */

public class AsYourWishPresenter {
    private Context mContext;
    private IAsYourWishView mAsYourWishView;
    private LoginInfo mLoginInfo;

    public AsYourWishPresenter(Context context, IAsYourWishView view) {
        this.mContext = context;
        this.mAsYourWishView = view;
        mLoginInfo = new LoginInfo();
    }

    public void login() {
        EditText etAccount = (EditText) mAsYourWishView.getAccountEditText();
        EditText etPwd = (EditText) mAsYourWishView.getPwdEditText();

        if(etAccount != null && etPwd != null){
            Editable tmp = etAccount.getText();
            if(tmp != null) {
                mLoginInfo.setAccount(tmp.toString());
            }else {
                mLoginInfo.setAccount(null);
            }
            tmp = etPwd.getText();
            if(tmp != null) {
                mLoginInfo.setPassWord(tmp.toString());
            }else {
                mLoginInfo.setPassWord(null);
            }
        }else {
            mLoginInfo.setAccount(null);
            mLoginInfo.setPassWord(null);
        }
        //start to login.and the reponse is true.
        if(true){
            mAsYourWishView.loginSucceed();
        }
    }
}
