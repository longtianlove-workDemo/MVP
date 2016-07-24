package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper.net;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 获取图片URL
 * Created by 龙 on 2016/7/13.
 */
public interface PictureURL {
    @POST("item2?id=293&count=10")
    Call<ResponseBody> contributors(@Query("page") int page);

}
