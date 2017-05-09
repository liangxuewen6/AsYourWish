package com.mikex.asyourwish.viewInterface;

import android.view.View;

import com.mikex.asyourwish.models.LoginInfo;

/**
 * Created by zhibinw on 5/9/2017.
 */

public interface IAsYourWishView {
    void updateView();
    View getAccountEditText();
    View getPwdEditText();
    void loginSucceed();
}
