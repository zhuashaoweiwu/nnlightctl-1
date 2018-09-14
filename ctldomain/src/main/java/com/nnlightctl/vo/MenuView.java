package com.nnlightctl.vo;

import java.util.List;

public class MenuView {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuView> getSubMenuViewList() {
        return subMenuViewList;
    }

    public void setSubMenuViewList(List<MenuView> subMenuViewList) {
        this.subMenuViewList = subMenuViewList;
    }

    private String name;
    private String url;
    private List<MenuView> subMenuViewList;
}
