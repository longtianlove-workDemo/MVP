package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.R;


/**
 * 登录状态改变
 * Created by long on 2016/9/19.
 */
public class LoginStateDialog {
    public static void showErrorMessage(Context context,String message,final View.OnClickListener onConfirmClickListener){
        if(!canShowDialog(context))return;
        final Dialog dialog = new AppDialog(context, R.layout.dialog_loginstate, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, R.style.mystyle, Gravity.CENTER);
        dialog.getWindow().setWindowAnimations(0);
        TextView tv_login_state_msg= (TextView) dialog.findViewById(R.id.tv_login_state_msg);
        Button btn_toLogin= (Button) dialog.findViewById(R.id.btn_toLogin);
        tv_login_state_msg.setText(message);
        btn_toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                if (onConfirmClickListener != null) {
                    onConfirmClickListener.onClick(v);
                }
            }
        });
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

    }
    public static boolean canShowDialog(Context context){
        if(context==null)return false;
//        if(context instanceof BaseAppUpdateActivity){
//            BaseAppUpdateActivity act = (BaseAppUpdateActivity)context;
//            if(act.isDestroy()){
//                return false;
//            }
//        }
        return true;
    }
}
