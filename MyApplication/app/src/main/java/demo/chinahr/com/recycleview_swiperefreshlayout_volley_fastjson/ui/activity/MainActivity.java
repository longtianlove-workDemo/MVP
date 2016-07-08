package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.R;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.contract.RefreshContract;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.DataList;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.Root;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.presenter.RefreshPresenter;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.ui.apapter.RecyclerViewAdapter;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.listener.NativeItemClickListener;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.listener.NativeItemLongClickListener;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.constant.RequestType;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.selfview.RecycleViewDivider;

public class MainActivity extends AppCompatActivity implements OnRefreshListener, RefreshContract.View {
    SwipeRefreshLayout mSwipeRefreshWidget;
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    RecyclerViewAdapter adapter;
    int lastVisibleItem;
    List<DataList> list;
    int end = 20;
    RefreshPresenter presenter;
    Root root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();
        initListener();
    }

    public void initView() {
        mSwipeRefreshWidget = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);
        mRecyclerView = (RecyclerView) findViewById(android.R.id.list);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        mSwipeRefreshWidget.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new RecycleViewDivider(this));
    }
    public void initData() {
        list = new ArrayList<DataList>();
        adapter = new RecyclerViewAdapter(list, this);
        mRecyclerView.setAdapter(adapter);
        presenter = createPresenter();
        presenter.getHotestList(end=20, RequestType.FIRST);
    }
    public void initListener() {
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,
                                             int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem +1== adapter.getItemCount()) {
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
        adapter.setOnItemClickListener(new NativeItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(MainActivity.this, "点击条目" + postion, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemLongClickListener(new NativeItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int postion) {
                Toast.makeText(MainActivity.this, "长按条目" + postion, Toast.LENGTH_SHORT).show();
            }
        });
    }




    @Override
    public void onRefresh() {
        presenter.getHotestList(end=20, RequestType.REFRESH);
        mSwipeRefreshWidget.setRefreshing(false);
    }

    @Override
    public RefreshPresenter createPresenter() {
        return new RefreshPresenter(this, this);
    }

    @Override
    public void firstView() {
        root = presenter.getRoot();
        if(root!=null&&root.getData()!=null) {
            adapter.list = root.getData().getList();
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void loadView() {
        root = presenter.getRoot();
        if(root!=null&&root.getData()!=null) {
            adapter.notifyItemRemoved(adapter.getItemCount());
            adapter.list = root.getData().getList();
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void refreshView() {
        root = presenter.getRoot();
        if(root!=null&&root.getData()!=null) {
            adapter.list = root.getData().getList();
            adapter.notifyDataSetChanged();
        }
    }
}