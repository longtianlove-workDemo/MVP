package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.hotest.Root;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.constant.RequestType;

/**
 * Created by 龙 on 2016/7/7.
 */
public class HotestContract {
    public interface View extends BaseView<Presenter> {
        void firstView();
        void loadView();
        void refreshView();
    }

    public interface Presenter extends BasePresenter {
        void getHotestList(int end, RequestType requestType);
        Root getRoot();
    }
}
