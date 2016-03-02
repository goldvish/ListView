package com.umr.nick.listview;

/**
 * Created by Nick on 2016/3/1.
 */
public class JavaBean
{
    public String name;
    public String content;

    public JavaBean() {
    }

    public JavaBean(String name, String content) {
        this.name = name;
        this.content = content;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
