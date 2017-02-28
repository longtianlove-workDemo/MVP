package longtianlove.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class MainActivity extends BaseActivity {
TextView test1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test1= (TextView) this.findViewById(R.id.test1);
        test1.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new EventManger.EventTest1());
            }
        });
//        setOnclicklister(new View.OnClickListener(){
//            @Subscribe
//            public void otherMethod(EventManger.EventTest1 eventTest1){
//                Toast.makeText(MainActivity.this,"TANCHULAI",Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onClick(View v) {
//
//            }
//        });




    }
//    void setOnclicklister(View.OnClickListener listener){
//        EventBus.getDefault().register(listener);
//        Class<?> clasz=listener.getClass();
//        Method[] methods = class.getDeclaredMethods();
//        EventBus.getDefault().post(new EventManger.EventTest1());
//
//    }
    @Subscribe(threadMode=ThreadMode.MainThread)
    public void tas(EventManger.EventTest1 eventTest1){
        Toast.makeText(MainActivity.this,"能传过来",Toast.LENGTH_LONG).show();
    }


}
