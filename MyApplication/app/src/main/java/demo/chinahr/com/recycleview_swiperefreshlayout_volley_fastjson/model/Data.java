package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model;

/**
 * Created by 58 on 2016/7/7.
 */
public class Data {
    private java.util.List<DataList> list ;

    private int from;

    private int end;

    private int listnum;

    private int sum;

    public void setList(java.util.List<DataList> list){
        this.list = list;
    }
    public java.util.List<DataList> getList(){
        return this.list;
    }
    public void setFrom(int from){
        this.from = from;
    }
    public int getFrom(){
        return this.from;
    }
    public void setEnd(int end){
        this.end = end;
    }
    public int getEnd(){
        return this.end;
    }
    public void setListnum(int listnum){
        this.listnum = listnum;
    }
    public int getListnum(){
        return this.listnum;
    }
    public void setSum(int sum){
        this.sum = sum;
    }
    public int getSum(){
        return this.sum;
    }
}
