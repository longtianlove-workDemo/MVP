package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model;

/**
 * Created by 58 on 2016/7/7.
 */
public class Root {
    private Status status;

    private Data data;

    public void setStatus(Status status){
        this.status = status;
    }
    public Status getStatus(){
        return this.status;
    }
    public void setData(Data data){
        this.data = data;
    }
    public Data getData(){
        return this.data;
    }
}
