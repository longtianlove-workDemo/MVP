package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.R;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.presenter.RefreshPresenter;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.fragment.HotestFragment;

public class MainActivity extends BaseActivity<RefreshPresenter> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main,1);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.home_container, new HotestFragment());
        ft.commitAllowingStateLoss();
    }


    @Override
    public RefreshPresenter createPresenter() {
        return null;
    }
}
