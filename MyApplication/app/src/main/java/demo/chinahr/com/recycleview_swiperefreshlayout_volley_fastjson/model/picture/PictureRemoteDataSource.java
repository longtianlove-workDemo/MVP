package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture;

import android.content.Context;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper.RequestNetworkHelper;

/**
 * Created by 58 on 2016/7/13.
 */
public class PictureRemoteDataSource implements PictureDataSource {
    @Override
    public void getPictureUrls(Context context, int page, ResponseCallback callback) {
        RequestNetworkHelper.getInstance(context).getPictureUrls(page = 1, callback);
    }
}
