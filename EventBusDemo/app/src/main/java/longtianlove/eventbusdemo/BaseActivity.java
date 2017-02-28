package longtianlove.eventbusdemo;

import android.app.Activity;
import android.os.Bundle;

import de.greenrobot.event.EventBus;

/**
 * Created by 58 on 2016/12/11.
 */

public class BaseActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }
}
