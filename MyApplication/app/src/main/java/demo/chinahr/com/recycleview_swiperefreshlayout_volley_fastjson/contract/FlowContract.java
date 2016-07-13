package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract;

import java.util.List;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture.Pics;

/**
 * Created by 龙 on 2016/7/12.
 */
public class FlowContract {
    public interface View extends BaseView<Presenter> {
        public void showPictures();
    }

    public interface Presenter extends BasePresenter {
        public void getPictureUrls(int page);
        public List<Pics> getList();
    }
}
