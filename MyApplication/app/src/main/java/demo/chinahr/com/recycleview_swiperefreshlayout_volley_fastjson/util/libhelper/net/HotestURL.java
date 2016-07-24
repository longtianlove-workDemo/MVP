package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 获取HotestURL
 * Created by 龙 on 2016/7/13.
 */
public interface HotestURL {
    @POST("hotest?from=1&groupid=1")
    Call<ResponseBody> contributors(@Query("end") int end);
}
