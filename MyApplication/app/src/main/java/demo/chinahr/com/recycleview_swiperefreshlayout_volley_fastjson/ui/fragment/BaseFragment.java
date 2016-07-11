package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.fragment;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract.BasePresenter;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract.BaseView;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.activity.BaseActivity;

/**
 * Created by 58 on 2016/7/11.
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView<T> {
    protected T presenter;
    public BaseActivity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (BaseActivity) activity;

    }


    public void finish() {
        activity.finish();
    }
}
