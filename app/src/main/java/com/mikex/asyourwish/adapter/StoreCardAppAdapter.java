package com.mikex.asyourwish.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mike.asyourwish.R;
import com.mikex.asyourwish.models.AppInfo;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by mike on 16-8-29.
 */

public class StoreCardAppAdapter extends BaseAdapter {

    private List<AppInfo> mInstalledApps;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public StoreCardAppAdapter(Context context, List<AppInfo> installedApps) {
        this.mContext = context;
        this.mInstalledApps = installedApps;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mInstalledApps.size();
    }

    @Override
    public Object getItem(int position) {
        return mInstalledApps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view = convertView;

        if(view == null) {
            view = mLayoutInflater.inflate(R.layout.item_store_card_app, null);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //start uninstalled apps in sdcard.
                    AppInfo appinfo = (AppInfo) getItem(position);
                    startAppByPackageName(appinfo.getPkgName());
                    Toast.makeText(mContext,"Starting apps without install will coming soon", Toast.LENGTH_LONG).show();

                }
            });
            viewHolder = new ViewHolder();
            viewHolder.mImageViewHolder = (ImageView) view.findViewById(R.id.iv_item_store_card_app);
            viewHolder.mTextViewHolder = (TextView) view.findViewById(R.id.tv_item_store_card_app);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final AppInfo titleData = (AppInfo) getItem(position);
        viewHolder.mTextViewHolder.setText(titleData.getPkgName());
        viewHolder.mImageViewHolder.setImageDrawable(titleData.getAppIcon());

        return view;
    }

    private void startAppByPackageName(String pkgName) {

        //hook ActivityManagerService
        try {
            Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");
            Field gDefaultField = activityManagerNativeClass.getDeclaredField("gDefault");
            gDefaultField.setAccessible(true);
            Object gDefault = gDefaultField.get(null);

            Class<?> singleton = Class.forName("android.util.Singleton");
            Field mInstanceField = singleton.getDeclaredField("mInstance");
            mInstanceField.setAccessible(true);

            // ActivityManagerNative 的gDefault对象里面原始的 IActivityManager对象
            Object rawIActivityManager = mInstanceField.get(gDefault);
            // 创建一个这个对象的代理对象, 然后替换这个字段, 让我们的代理对象帮忙干活
            Class<?> iActivityManagerInterface = Class.forName("android.app.IActivityManager");
//            Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
//                    new Class<?>[] { iActivityManagerInterface }, new IActivityManagerHandler(rawIActivityManager));
//            mInstanceField.set(gDefault, proxy);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    class ViewHolder {
        protected ImageView mImageViewHolder;
        protected TextView mTextViewHolder;
    }


}

