package demo.chinahr.com.recycleview_swiperefreshlayout_volley_fastjson.model.picture;

import java.util.List;

/**
 * Created by 58 on 2016/7/13.
 */
public class Pics {
    private String cid;

    private String id;

    private String small;

    private String big;

    private String viewcount;

    private String support;

    private boolean hadsupport;

    private String desc;

    private int imgwidth;

    private int imgheight;

    private String topicid;

    private List<String> tag ;

    private Author author;

    private String orgname;

    public void setCid(String cid){
        this.cid = cid;
    }
    public String getCid(){
        return this.cid;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setSmall(String small){
        this.small = small;
    }
    public String getSmall(){
        return this.small;
    }
    public void setBig(String big){
        this.big = big;
    }
    public String getBig(){
        return this.big;
    }
    public void setViewcount(String viewcount){
        this.viewcount = viewcount;
    }
    public String getViewcount(){
        return this.viewcount;
    }
    public void setSupport(String support){
        this.support = support;
    }
    public String getSupport(){
        return this.support;
    }
    public void setHadsupport(boolean hadsupport){
        this.hadsupport = hadsupport;
    }
    public boolean getHadsupport(){
        return this.hadsupport;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public String getDesc(){
        return this.desc;
    }
    public void setImgwidth(int imgwidth){
        this.imgwidth = imgwidth;
    }
    public int getImgwidth(){
        return this.imgwidth;
    }
    public void setImgheight(int imgheight){
        this.imgheight = imgheight;
    }
    public int getImgheight(){
        return this.imgheight;
    }
    public void setTopicid(String topicid){
        this.topicid = topicid;
    }
    public String getTopicid(){
        return this.topicid;
    }
    public void setTag(List<String> tag){
        this.tag = tag;
    }
    public List<String> getTag(){
        return this.tag;
    }
    public void setAuthor(Author author){
        this.author = author;
    }
    public Author getAuthor(){
        return this.author;
    }
    public void setOrgname(String orgname){
        this.orgname = orgname;
    }
    public String getOrgname(){
        return this.orgname;
    }
}
