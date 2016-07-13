package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson;

import android.app.Application;
import android.content.Context;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper.ImageLoaderHelper;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper.PatchManagerHelper;

/**
 * Created by 龙 on 2016/7/7.
 */
public class RootApplication extends Application {
    private static Application context;


    public static Application getContext() {
        return context;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        PatchManagerHelper.getInstance().init(this);
        ImageLoaderHelper.getInstance().init(this);
    }
}
