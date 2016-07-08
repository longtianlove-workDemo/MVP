package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract;

/**
 * Created by 龙 on 2016/7/7.
 */
public interface BaseView<T extends BasePresenter> {
    T createPresenter();
}
