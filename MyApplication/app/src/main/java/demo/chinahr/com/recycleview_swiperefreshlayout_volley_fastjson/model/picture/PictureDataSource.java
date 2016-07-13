package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture;

import android.content.Context;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.constant.DataSourceType;

/**
 * 获取数据
 * Created by 龙 on 2016/7/12.
 */
public interface PictureDataSource {
    interface ResponseCallback{
        void onResponseOK(Object responseData, DataSourceType dataType);
        void onResponseError();
    }
  public  void getPictureUrls(Context context, int page, PictureDataSource.ResponseCallback callback);
}
