package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.libhelper;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;

/**
 * 热修复
 * Created by 龙 on 2016/7/8.
 */
public class PatchManagerHelper {
    private static PatchManagerHelper ourInstance = new PatchManagerHelper();
    public static PatchManager mPatchManager;

    public static PatchManagerHelper getInstance() {
        return ourInstance;
    }

    private PatchManagerHelper() {
    }

    public void init(Context context) {
        // 初始化patch管理类
        mPatchManager = new PatchManager(context);
        // 初始化patch版本
        mPatchManager.init("1.0");
        // 加载已经添加到PatchManager中的patch
        mPatchManager.loadPatch();
    }
}
