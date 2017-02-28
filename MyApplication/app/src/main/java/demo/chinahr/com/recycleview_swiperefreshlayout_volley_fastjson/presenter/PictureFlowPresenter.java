package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.presenter;

import android.content.Context;

import java.util.List;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract.FlowContract;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture.PictureDataSource;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture.PictureLocalDataSource;

/**
 * 展示图片的presenter
 * Created by 龙 on 2016/7/12.
 */
public class PictureFlowPresenter implements FlowContract.Presenter {
    private Context context;
    PictureDataSource pictureDataSource;
    FlowContract.View pictureFlowView;
    List<String> pictureList;

    public PictureFlowPresenter(Context context, FlowContract.View pictureFlowView) {
        this.context = context;
        this.pictureDataSource = new PictureLocalDataSource();
        this.pictureFlowView = pictureFlowView;

    }

    public void getPictureUrls() {
        pictureDataSource.getPictureUrls(new PictureDataSource.ResponseCallback() {
            @Override
            public void onResponseOK(Object responseData) {
                pictureList = (List<String>) responseData;
                pictureFlowView.showPictures();
            }

            @Override
            public void onResponseError() {

            }
        });
    }

    @Override
    public List<String> getList() {
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
