package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.R;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract.RefreshContract;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.DataList;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.presenter.RefreshPresenter;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.apapter.RecyclerViewAdapter;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.constant.RequestType;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.listener.NativeItemClickListener;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.listener.NativeItemLongClickListener;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.selfview.LeftSlideDeleteRecyclerView;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.selfview.RecyclerViewDivider;

/**
 * Created by 龙 on 2016/7/11.
 */
public class HotestFragment extends BaseFragment<RefreshContract.Presenter> implements SwipeRefreshLayout.OnRefreshListener,RefreshContract.View{
    private Context mcontext;
    SwipeRefreshLayout mSwipeRefreshWidget;
    LeftSlideDeleteRecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    RecyclerViewAdapter adapter;
    int lastVisibleItem;
    List<DataList> list;
    int end = 20;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        initView(view);
        initData();
        initListener();
        return view;
    }

    public void initView(View view) {
        mcontext=getActivity();
        mSwipeRefreshWidget = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh_widget);
        mRecyclerView = (LeftSlideDeleteRecyclerView) view.findViewById(android.R.id.list);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mSwipeRefreshWidget.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(mcontext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new RecyclerViewDivider(mcontext));
    }

    public void initData() {
        list = new ArrayList<DataList>();
        adapter = new RecyclerViewAdapter(list, mcontext);
        mRecyclerView.setAdapter(adapter);
        presenter=createPresenter();
        presenter.getHotestList(end = 20, RequestType.FIRST);
    }

    public void initListener() {
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,
                                             int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == adapter.getItemCount()) {
                    boolean isRefreshing = mSwipeRefreshWidget.isRefreshing();
                    if (isRefreshing) {
                        adapter.notifyItemRemoved(adapter.getItemCount());
                        return;
                    }
                    presenter.getHotestList(end += 10, RequestType.LOAD);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });
        mRecyclerView.setRemoveListener(new LeftSlideDeleteRecyclerView.RemoveListener() {

            @Override
            public void removeItem(LeftSlideDeleteRecyclerView.RemoveDirection direction, int position) {
                switch (direction) {
                    case LEFT:
                        Toast.makeText(mcontext, "左滑动删除" + adapter.list.get(position - 1).getName(), Toast.LENGTH_SHORT).show();
                        adapter.list.remove(position - 1);
                        adapter.notifyDataSetChanged();
                        break;
                    case RIGHT:
                        Toast.makeText(mcontext, "右滑" + adapter.list.get(position - 1).getName(), Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
        adapter.setOnItemClickListener(new NativeItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(mcontext, "点击条目" + postion, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemLongClickListener(new NativeItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int postion) {
                Toast.makeText(mcontext, "长按条目" + postion, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onRefresh() {
        presenter.getHotestList(end = 20, RequestType.REFRESH);
        mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public RefreshPresenter createPresenter() {
        return new RefreshPresenter(mcontext, this);
    }
    @Override
    public void firstView() {
        adapter.refresh(presenter.getRoot());
    }

    @Override
    public void loadView() {
        adapter.refresh(presenter.getRoot());
    }

    @Override
    public void refreshView() {
        adapter.refresh(presenter.getRoot());
    }
}
