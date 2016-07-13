package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture;

import java.util.Arrays;

/**
 * 从本地获取数据
 * Created by 龙 on 2016/7/12.
 */
public class PictureLocalDataSource implements PictureDataSource {
    @Override
    public void getPictureUrls(PictureDataSource.ResponseCallback callback) {
        callback.onResponseOK(Arrays.asList(Images.imageThumbUrls));
    }
}
