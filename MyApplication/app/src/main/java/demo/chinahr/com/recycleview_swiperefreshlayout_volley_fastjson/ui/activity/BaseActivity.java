package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.R;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract.BasePresenter;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract.BaseView;

/**
 * Created by 58 on 2016/7/11.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView<T>{
    protected T presenter;
    private FrameLayout contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=createPresenter();
    }
    public void setContentView(int layoutResID,int windowType){
      setContentView(R.layout.activity_base);
        contentView= (FrameLayout) findViewById(R.id.activity_base_view_container);
        LayoutInflater.from(this).inflate(layoutResID, contentView);
    }
}
