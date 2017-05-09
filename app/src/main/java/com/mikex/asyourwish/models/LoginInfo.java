package com.mikex.asyourwish.models;

/**
 * Created by zhibinw on 5/9/2017.
 */

public class LoginInfo {
    private String mAccount;
    private String mPassWord;

    public LoginInfo() {
    }

    public LoginInfo(String account, String passWord) {
        this.mAccount = account;
        this.mPassWord = passWord;
    }

    public String getAccount() {
        return mAccount;
    }

    public void setAccount(String mAccount) {
        this.mAccount = mAccount;
    }

    public String getPassWord() {
        return mPassWord;
    }

    public void setPassWord(String mPassWord) {
        this.mPassWord = mPassWord;
    }
}
