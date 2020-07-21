package com.rong.demo.vo;

import com.rong.demo.po.Type;

public class BlogQuery {
    private String title;
    private Long typeId;
    private boolean recommand;

    public BlogQuery() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommand() {
        return recommand;
    }

    public void setRecommand(boolean recommand) {
        this.recommand = recommand;
    }

    @Override
    public String toString() {
        return "BlogQuery{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                ", recommand=" + recommand +
                '}';
    }
}
