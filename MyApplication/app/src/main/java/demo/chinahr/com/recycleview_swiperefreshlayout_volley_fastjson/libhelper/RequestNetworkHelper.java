package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.libhelper;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.constant.Constant;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.listener.ResponseListener;

/**
 * 封装第三方库，方便替换
 * Created by 龙 on 2016/7/8.
 */
public class RequestNetworkHelper {
    private static RequestNetworkHelper ourInstance = new RequestNetworkHelper();
    private static RequestQueue requestQueue;//请求队列

    public static RequestNetworkHelper getInstance(Context context) {
        if(requestQueue==null){
            synchronized(RequestQueue.class){
                if(requestQueue==null){
                    requestQueue=Volley.newRequestQueue(context);
                }
            }
        }
        requestQueue= Volley.newRequestQueue(context);
        return ourInstance;
    }

    private RequestNetworkHelper() {
    }
    public void getHotestList(int end, final ResponseListener responseListener){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Constant.HOTEST_LIST + "?end=" + end + "&from=1&groupid=1", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                responseListener.onResponseOK(jsonObject);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {


            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
