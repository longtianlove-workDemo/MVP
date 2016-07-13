package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture;

import java.util.List;

/**
 * Created by 58 on 2016/7/13.
 */
public class Root {
    private int status;

    private String msg;

    private String title;

    private List<Pics> pics;

    private String totalcount;

    private int totalpage;

    private int pageno;

    private int pagesize;

    private int rowstart;

    private int rowend;

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPics(List<Pics> pics) {
        this.pics = pics;
    }

    public List<Pics> getPics() {
        return this.pics;
    }

    public void setTotalcount(String totalcount) {
        this.totalcount = totalcount;
    }

    public String getTotalcount() {
        return this.totalcount;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getTotalpage() {
        return this.totalpage;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getPageno() {
        return this.pageno;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPagesize() {
        return this.pagesize;
    }

    public void setRowstart(int rowstart) {
        this.rowstart = rowstart;
    }

    public int getRowstart() {
        return this.rowstart;
    }

    public void setRowend(int rowend) {
        this.rowend = rowend;
    }

    public int getRowend() {
        return this.rowend;
    }
}
