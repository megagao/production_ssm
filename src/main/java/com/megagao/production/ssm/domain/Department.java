package com.megagao.production.ssm.domain;

import javax.validation.constraints.Size;

public class Department {
	
	@Size(max=40, message="{id.length.error}")
    private String departmentId;

	@Size(max=100, message="{name.length.error}")
    private String departmentName;

	@Size(max=5000, message="{note.length.error}")
    private String note;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}