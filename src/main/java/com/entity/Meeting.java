package com.entity;

public class Meeting {
    private String id;

    private String title;

    private String date;

    private String site;

    private String minutedBy;

    private String calledBy;

    private String startTime;

    private String duration;

    private String projectId;

    private String link;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public String getMinutedBy() {
        return minutedBy;
    }

    public void setMinutedBy(String minutedBy) {
        this.minutedBy = minutedBy == null ? null : minutedBy.trim();
    }

    public String getCalledBy() {
        return calledBy;
    }

    public void setCalledBy(String calledBy) {
        this.calledBy = calledBy == null ? null : calledBy.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }
}