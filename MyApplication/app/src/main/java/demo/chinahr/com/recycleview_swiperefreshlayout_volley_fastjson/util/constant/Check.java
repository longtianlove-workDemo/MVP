package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.util.constant;

import java.util.List;

/**
 * 监测工具
 * Created by 龙 on 2016/7/12.
 */
public class Check {
    public static boolean indexOfList(List list, int position) {
        if((list==null||list.get(position)==null)){
            return false;
        }
        return list.size() > position;
    }
}
