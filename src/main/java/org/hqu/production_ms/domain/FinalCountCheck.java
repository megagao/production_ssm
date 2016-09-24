package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.Date;

public class FinalCountCheck {
    private String fCountCheckId;

    private String checkItem;

    private Integer sample;

    private Integer checkNumber;

    private Integer unqualify;

    private BigDecimal qualify;

    private Date date;

    private String measureData;

    private String result;

    private String comment;
    
    private COrder order;
    
    private Employee employee;

    public String getfCountCheckId() {
        return fCountCheckId;
    }

    public void setfCountCheckId(String fCountCheckId) {
        this.fCountCheckId = fCountCheckId == null ? null : fCountCheckId.trim();
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem == null ? null : checkItem.trim();
    }

    public Integer getSample() {
        return sample;
    }

    public void setSample(Integer sample) {
        this.sample = sample;
    }

    public Integer getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Integer checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Integer getUnqualify() {
        return unqualify;
    }

    public void setUnqualify(Integer unqualify) {
        this.unqualify = unqualify;
    }

    public BigDecimal getQualify() {
        return qualify;
    }

    public void setQualify(BigDecimal qualify) {
        this.qualify = qualify;
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