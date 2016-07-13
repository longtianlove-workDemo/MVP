package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture;

import org.json.JSONObject;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.hotest.HotestDataSource;

/**
 * 获取数据
 * Created by 龙 on 2016/7/12.
 */
public interface PictureDataSource {
    interface ResponseCallback{
        void onResponseOK(Object responseData);
        void onResponseError();
    }
  public  void getPictureUrls(PictureDataSource.ResponseCallback callback);
}
