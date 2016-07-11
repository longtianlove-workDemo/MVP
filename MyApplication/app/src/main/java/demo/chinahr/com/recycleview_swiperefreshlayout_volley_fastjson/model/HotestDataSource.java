package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model;

import android.content.Context;

import org.json.JSONObject;

/**
 * Created by 龙 on 2016/7/11.
 */
public interface HotestDataSource {
    interface ResponseCallback{
        void onResponseOK(JSONObject jsonObject);
        void onResponseError();
    }
    void getHotestList(Context context, int end, ResponseCallback callback);
}
