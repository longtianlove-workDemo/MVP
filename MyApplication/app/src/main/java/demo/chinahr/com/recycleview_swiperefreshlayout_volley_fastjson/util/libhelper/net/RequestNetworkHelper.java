package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper.net;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.IOException;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.hotest.HotestDataSource;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture.PictureDataSource;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.constant.Constant;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.constant.DataSourceType;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络访问
 * Created by 龙 on 2016/7/8.
 */
public class RequestNetworkHelper {
    private static RequestNetworkHelper ourInstance = new RequestNetworkHelper();
    private static RequestQueue requestQueue;//请求队列

    public static RequestNetworkHelper getInstance(Context context) {
        if (requestQueue == null) {
            synchronized (RequestQueue.class) {
                if (requestQueue == null) {
                    requestQueue = Volley.newRequestQueue(context);
                }
            }
        }
        return ourInstance;
    }

    private RequestNetworkHelper() {
    }

    public void getHotestList(int end, final HotestDataSource.ResponseCallback callback) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Constant.HOTEST_LIST + "hotest?end=" + end + "&from=1&groupid=1", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                callback.onResponseOK(jsonObject.toString(), DataSourceType.REMOTE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {


            }
        });
        requestQueue.add(jsonObjectRequest);
    }


    public void getPictureUrls(int page, final PictureDataSource.ResponseCallback callback) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Constant.PICTURE_URL_LIST + "item2?id=293&count=10&page=" + page, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                callback.onResponseOK(jsonObject, DataSourceType.REMOTE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }


    public void getHotestList(int end, final HotestDataSource.ResponseCallback callback, boolean isRetrofit) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.HOTEST_LIST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HotestURL hotestURL = retrofit.create(HotestURL.class);
        Call<ResponseBody> call = hotestURL.contributors(end);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    callback.onResponseOK(response.body().string(), DataSourceType.REMOTE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void getPictureUrls(int page, final PictureDataSource.ResponseCallback callback, boolean isRetrofit) {
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.PICTURE_URL_LIST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            PictureURL pictureURL = retrofit.create(PictureURL.class);
            Call<ResponseBody> call = pictureURL.contributors(page);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                    try {
                        callback.onResponseOK(response.body().string(), DataSourceType.REMOTE);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }

    }
}
