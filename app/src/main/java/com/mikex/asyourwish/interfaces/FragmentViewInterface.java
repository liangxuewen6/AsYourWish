package com.mikex.asyourwish.interfaces;


import com.mikex.asyourwish.models.AppInfo;

import java.util.List;

/**
 * Created by mike on 16-9-4.
 */

public interface FragmentViewInterface {

    public void startLoadAppsList();
    public void FinishedLoadAppsList(List<AppInfo> appInfoList);
    public void refreshFragment();

}
