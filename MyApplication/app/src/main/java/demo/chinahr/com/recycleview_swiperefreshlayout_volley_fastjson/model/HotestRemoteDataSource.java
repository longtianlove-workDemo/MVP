package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model;

import android.content.Context;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper.RequestNetworkHelper;


/**
 * Created by 龙 on 2016/7/11.
 */
public class HotestRemoteDataSource implements HotestDataSource {
    @Override
    public void getHotestList(Context context, int end, ResponseCallback callback) {
        RequestNetworkHelper.getInstance(context).getHotestList(end, callback);
    }
}
