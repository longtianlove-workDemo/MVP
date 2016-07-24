package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.presenter;

import android.content.Context;

import java.util.List;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract.FlowContract;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture.Pics;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture.PictureDataSource;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture.PictureRemoteDataSource;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture.Root;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.constant.DataSourceType;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper.ParseJSONHelper;

/**
 * 展示图片的presenter
 * Created by 龙 on 2016/7/12.
 */
public class PictureFlowPresenter implements FlowContract.Presenter {
    private Context context;
    PictureDataSource pictureDataSource;
    FlowContract.View pictureFlowView;
    List<Pics> pictureList;

    public PictureFlowPresenter(Context context, FlowContract.View pictureFlowView) {
        this.context = context;
        this.pictureDataSource = new PictureRemoteDataSource();
        this.pictureFlowView = pictureFlowView;

    }

    public void getPictureUrls(int page) {
        pictureDataSource.getPictureUrls(context, page, new PictureDataSource.ResponseCallback() {
            @Override
            public void onResponseOK(Object responseData, DataSourceType dataType) {
                switch (dataType) {
                    case LOCAL://本地加载数据
//                        pictureList = (List<String>) responseData;
                        break;
                    case REMOTE://网络
                        try {
                            Root root = ParseJSONHelper.deserialize((String) responseData, Root.class);
                            pictureList = root.getPics();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                }

                pictureFlowView.showPictures();
            }

            @Override
            public void onResponseError() {

            }
        });
    }

    @Override
    public List<Pics> getList() {
        return pictureList;
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
