package org.hqu.production_ms.domain;

import java.util.Date;

public class UnqualifyApply {
    private String unqualifyApplyId;

    private String unqualifyItem;

    private Integer unqualifyCount;

    private Date assemblyDate;

    private Date applyDate;

    private String comment;
    
    private Product product;
    
    private Equipment equipment;
    
    private Employee employee;

    public String getUnqualifyApplyId() {
        return unqualifyApplyId;
    }

    public void setUnqualifyApplyId(String unqualifyApplyId) {
        this.unqualifyApplyId = unqualifyApplyId == null ? null : unqualifyApplyId.trim();
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

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}