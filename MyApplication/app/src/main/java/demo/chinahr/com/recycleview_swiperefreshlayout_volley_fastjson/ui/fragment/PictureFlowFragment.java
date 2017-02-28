package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.R;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract.FlowContract;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.presenter.PictureFlowPresenter;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.apapter.PictureFlowRecyclerViewAdapter;

/**
 * Created by 58 on 2016/7/12.
 */
public class PictureFlowFragment extends BaseFragment<FlowContract.Presenter> implements SwipeRefreshLayout.OnRefreshListener,FlowContract.View {
    SwipeRefreshLayout mSwipeRefreshWidget;
    private Context mcontext;
    RecyclerView mRecyclerView;
    PictureFlowRecyclerViewAdapter adapter;
    List<String> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pictureflowfragment_main, container, false);
        initView(view);
        initData();
        return view;
    }

    void initView(View view) {
        mSwipeRefreshWidget = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mSwipeRefreshWidget.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        mcontext=getActivity();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
//        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    void initData() {
        list = new ArrayList<String>();
        adapter=new PictureFlowRecyclerViewAdapter(list,mcontext);
        mRecyclerView.setAdapter(adapter);
        presenter=createPresenter();
        presenter.getPictureUrls();
    }

    @Override
    public FlowContract.Presenter createPresenter() {
        return new PictureFlowPresenter(mcontext,this);
    }

    @Override
    public void showPictures() {
        adapter.refresh(presenter.getList());
    }

    @Override
    public void onRefresh() {
        presenter.getPictureUrls();
        mSwipeRefreshWidget.setRefreshing(false);
    }
}
