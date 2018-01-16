package com.megagao.production.ssm.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class Material {
	
	@Size(max=40, message="{id.length.error}")
    private String materialId;

    private String workId;

    @Size(max=100, message="物料类型的长度限制在100个字符之内")
    private String materialType;

    private String status;

    @Max(value=999999999, message="剩余数量不能超过999999999")
    private Integer remaining;

    @Size(max=5000, message="{note.length.error}")
    private String note;

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}