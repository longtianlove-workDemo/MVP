package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract.HotestContract;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.hotest.HotestDataSource;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.hotest.HotestRemoteDataSource;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.hotest.Root;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.constant.RequestType;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper.ParseJSONHelper;

/**
 * 最热app的presenter
 * Created by 龙 on 2016/7/7.
 */
public class HotestPresenter implements HotestContract.Presenter {
    private Context context;
    private HotestContract.View refreshView;
    private HotestDataSource hotestDataSource;
    Root root;

    public HotestPresenter(Context context, HotestContract.View refreshView) {
        this.context = context;
        this.refreshView = refreshView;
        hotestDataSource=new HotestRemoteDataSource();
    }

    @Override
    public void getHotestList(int end, final RequestType requestType) {
        hotestDataSource.getHotestList(context,end,new HotestDataSource.ResponseCallback(){

            @Override
            public void onResponseOK(Object responseData) {
                JSONObject jsonObject=(JSONObject)responseData;
                String jsonString = jsonObject.toString();
                root = ParseJSONHelper.deserialize(jsonString, Root.class);
                switch (requestType) {
                    case FIRST:
                        refreshView.firstView();
                        break;
                    case LOAD:
                        refreshView.loadView();
                        break;
                    case REFRESH:
                        refreshView.refreshView();
                        break;
                }
            }

            @Override
            public void onResponseError() {
                Toast.makeText(context, "网络失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public Root getRoot() {
        return root;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
