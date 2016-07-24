package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.R;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.presenter.HotestPresenter;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.fragment.BaseFragment;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.fragment.HotestFragment;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.fragment.PictureFlowFragment;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.widget.DummyTabFactory;

public class MainActivity extends BaseActivity<HotestPresenter> {
    TabHost tabHost;
    BaseFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main, 1);
        initView();
    }

    public void initView() {
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                if (TextUtils.equals("hotestapp", tabId)) {
                    fragment = new HotestFragment();
                } else if (TextUtils.equals("pictures", tabId)) {
                    fragment = new PictureFlowFragment();
                }
                ft.replace(android.R.id.tabcontent, fragment, "fragment");
                ft.commit();
            }
        });
        tabHost.addTab(tabHost.newTabSpec("hotestapp").setIndicator("头条")
                .setContent(new DummyTabFactory(this)));
        tabHost.addTab(tabHost.newTabSpec("pictures").setIndicator("图片")//setIndicator 设置标签样式
                .setContent(new DummyTabFactory(this))); //setContent 点击标签后触发

    }

}
