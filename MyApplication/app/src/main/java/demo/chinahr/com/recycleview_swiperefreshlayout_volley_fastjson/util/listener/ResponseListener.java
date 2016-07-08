package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.listener;

import org.json.JSONObject;

/**
 * Created by 龙 on 2016/7/8.
 */
public interface ResponseListener {
   void onResponseOK(JSONObject jsonObject);
    void onResponseError();
}
