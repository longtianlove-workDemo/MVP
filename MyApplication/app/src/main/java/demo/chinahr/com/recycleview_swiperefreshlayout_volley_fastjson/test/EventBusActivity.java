package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.R;

/**
 * Created by 58 on 2016/9/19.
 */
public class EventBusActivity extends Activity {
    TextView tv_sendMsg;
    TextView tv_showMsg;
    static int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        initView();
        initListener();
        initData();
    }
    private void initData() {
        EventBus.getDefault().register(this);
    }
    private void initView() {
        tv_sendMsg= (TextView) this.findViewById(R.id.tv_sendMsg);
        tv_showMsg= (TextView) this.findViewById(R.id.tv_showMsg);
    }
    private void initListener() {
        tv_sendMsg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new Event.clickEvent("哈哈哈"+i++));
            }
        });
    }
    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onEventMainThread(Event.clickEvent event)
    {
        tv_showMsg.setText(event.msg);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
