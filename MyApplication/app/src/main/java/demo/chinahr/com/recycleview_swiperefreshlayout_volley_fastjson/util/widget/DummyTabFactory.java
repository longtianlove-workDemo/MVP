package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

/**
 * Created by 58 on 2016/7/13.
 */
public class DummyTabFactory implements TabHost.TabContentFactory {
    private Context mcontext;

    public DummyTabFactory(Context context) {
        this.mcontext = context;
    }

    @Override
    public View createTabContent(String tag) {//创建宽高均为0的view
        View v = new ImageView(mcontext);
        v.setMinimumWidth(0);
        v.setMinimumHeight(0);
        return v;
    }
}
