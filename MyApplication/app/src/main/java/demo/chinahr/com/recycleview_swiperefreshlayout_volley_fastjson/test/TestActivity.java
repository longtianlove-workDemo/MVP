package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.R;
import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.widget.dialog.LoginStateDialog;

/**
 * Created by 58 on 2016/9/19.
 */
public class TestActivity extends Activity {
    TextView tv_dialog;
    TextView tv_eventbus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_list);
        initView();
        initListener();

    }

    private void initListener() {
        tv_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginStateDialog.showErrorMessage(TestActivity.this, "显示信息", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(TestActivity.this, "前去登录", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        tv_eventbus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this, EventBusActivity.class));
            }
        });
    }

    private void initView() {
        tv_dialog = (TextView) this.findViewById(R.id.tv_dialog);
        tv_eventbus = (TextView) this.findViewById(R.id.tv_eventbus);
    }
}
