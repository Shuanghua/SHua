package com.shuanghua.shua.model.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by ShuangHua on 2016/3/13.
 */
public class MainListBean extends BmobObject {

    /**
     * content : 我：桂林电子科技大学职业技术学院计算机系13级学生
     * label : 介绍
     * title : 关于我
     */

    private String content;//内容
    private String label;//标签
    private String title;//标题
    private String date;
    private String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
