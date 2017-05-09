package com.mikex.asyourwish.adapter;

import android.content.Context;


import com.mikex.asyourwish.models.AppInfo;

import java.util.List;

/**
 * Created by mike on 16-8-29.
 */

public class InstalledAppAdapter extends AppBaseAdapter {

    public InstalledAppAdapter(Context context, List<AppInfo> appInfoList, int startType) {
        super(context, appInfoList, startType);
    }
}

