package com.entity;

public class RiskReport {
    private String id;

    private String title;
    
    private String date;

    private String describe;

    private String probability;

    private String influence;

    private String level;

    private String plan;

    private String owner;

    private String projectId;

    private String isCheck;

    private String isPass;

    private String opinion;

    private String link;

    private String preparedName;

    private String reviewedName;

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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability == null ? null : probability.trim();
    }

    public String getInfluence() {
        return influence;
    }

    public void setInfluence(String influence) {
        this.influence = influence == null ? null : influence.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan == null ? null : plan.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(String isCheck) {
        this.isCheck = isCheck == null ? null : isCheck.trim();
    }

    public String getIsPass() {
        return isPass;
    }

    public void setIsPass(String isPass) {
        this.isPass = isPass == null ? null : isPass.trim();
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getPreparedName() {
        return preparedName;
    }

    public void setPreparedName(String preparedName) {
        this.preparedName = preparedName == null ? null : preparedName.trim();
    }

    public String getReviewedName() {
        return reviewedName;
    }

    public void setReviewedName(String reviewedName) {
        this.reviewedName = reviewedName == null ? null : reviewedName.trim();
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}