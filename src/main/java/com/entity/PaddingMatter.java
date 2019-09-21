package com.entity;

public class PaddingMatter {
    private String id;

    private String title;

    private String type;

    private String linkId;

    private String checkById;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId == null ? null : linkId.trim();
    }

    public String getCheckById() {
        return checkById;
    }

    public void setCheckById(String checkById) {
        this.checkById = checkById == null ? null : checkById.trim();
    }
}