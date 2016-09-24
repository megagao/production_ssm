package org.hqu.production_ms.domain;

import java.util.Date;

public class FinalMeasuretCheck {
    private String fMeasureCheckId;

    private String checkItem;

    private Date date;

    private String measureData;

    private String result;

    private String comment;
    
    private COrder order;
    
    private Employee employee;

    public String getfMeasureCheckId() {
        return fMeasureCheckId;
    }

    public void setfMeasureCheckId(String fMeasureCheckId) {
        this.fMeasureCheckId = fMeasureCheckId == null ? null : fMeasureCheckId.trim();
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem == null ? null : checkItem.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMeasureData() {
        return measureData;
    }

    public void setMeasureData(String measureData) {
        this.measureData = measureData == null ? null : measureData.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

	public COrder getOrder() {
		return order;
	}

	public void setOrder(COrder order) {
		this.order = order;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}