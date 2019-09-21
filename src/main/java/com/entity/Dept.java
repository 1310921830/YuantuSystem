package com.entity;

public class Dept {
    private Integer deptNo;

    private String deptName;

    private String deptSite;

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptSite() {
        return deptSite;
    }

    public void setDeptSite(String deptSite) {
        this.deptSite = deptSite == null ? null : deptSite.trim();
    }
}