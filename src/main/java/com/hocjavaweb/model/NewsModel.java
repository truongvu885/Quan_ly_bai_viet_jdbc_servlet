package com.hocjavaweb.model;

public class NewsModel extends AbstractModel {
    private String title;
    private String thumbnail;
    private String sort_descri;
    private String content;
    private long category_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSort_descri() {
        return sort_descri;
    }

    public void setSort_descri(String sort_descri) {
        this.sort_descri = sort_descri;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }
}
