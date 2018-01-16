package com.megagao.production.ssm.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class UnqualifyApply {
	@Size(max=40, message="{id.length.error}")
    private String unqualifyApplyId;
	
    private String productId;

	@Size(max=200, message="不合格项目长度限制在200个字符之内")
    private String unqualifyItem;

	@Max(value=999999999, message="不合格数量不能超过999999999")
    private Integer unqualifyCount;

    private Date assemblyDate;

    private String empId;

    private Date applyDate;

    @Size(max=5000, message="{note.length.error}")
    private String note;

    public String getUnqualifyApplyId() {
        return unqualifyApplyId;
    }

    public void setUnqualifyApplyId(String unqualifyApplyId) {
        this.unqualifyApplyId = unqualifyApplyId == null ? null : unqualifyApplyId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getUnqualifyItem() {
        return unqualifyItem;
    }

    public void setUnqualifyItem(String unqualifyItem) {
        this.unqualifyItem = unqualifyItem == null ? null : unqualifyItem.trim();
    }

    public Integer getUnqualifyCount() {
        return unqualifyCount;
    }

    public void setUnqualifyCount(Integer unqualifyCount) {
        this.unqualifyCount = unqualifyCount;
    }

    public Date getAssemblyDate() {
        return assemblyDate;
    }

    public void setAssemblyDate(Date assemblyDate) {
        this.assemblyDate = assemblyDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}