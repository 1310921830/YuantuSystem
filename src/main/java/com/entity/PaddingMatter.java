package com.entity;

public class PaddingMatter {
    private String id;
   
    private String date;
    
    private String title;

    private String type;

    private String linkId;

    private String checkById;
    
    private String projectId;
    
    private Integer status;
    
    public PaddingMatter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaddingMatter(String id, String date,String title, String type, String linkId, String checkById,String projectId,Integer status) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.type = type;
		this.linkId = linkId;
		this.checkById = checkById;
		this.projectId = projectId;
		this.status = status;
	}

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}