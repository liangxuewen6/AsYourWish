package com.mikex.asyourwish.interfaces;

import android.content.Context;


import com.mikex.asyourwish.models.AppInfo;

import java.util.List;

/**
 * Created by mike on 16-9-4.
 */

public interface IAppListBasePresenter {

    Context mContext = null;

    FragmentViewInterface mFragmentViewInterface = null;

    void getAppsList();

    List<AppInfo> achieveAppList();

    void startApp(int startType, AppInfo appInfo);
}
