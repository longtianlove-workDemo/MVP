package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.hotest;

import android.content.Context;

import org.json.JSONObject;

/**
 * 获取数据
 * Created by 龙 on 2016/7/11.
 */
public interface HotestDataSource {
    interface ResponseCallback{
        void onResponseOK(Object responseData);
        void onResponseError();
    }
    void getHotestList(Context context, int end, ResponseCallback callback);
}
