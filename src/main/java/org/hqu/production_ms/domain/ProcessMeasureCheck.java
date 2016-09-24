package org.hqu.production_ms.domain;

import java.util.Date;

public class ProcessMeasureCheck {
    private String pMeasureCheckId;

    private String checkItem;

    private Date date;

    private String measureData;

    private String result;

    private String comment;
    
    private Employee employee;
    
    private Process process;

    public String getpMeasureCheckId() {
        return pMeasureCheckId;
    }

    public void setpMeasureCheckId(String pMeasureCheckId) {
        this.pMeasureCheckId = pMeasureCheckId == null ? null : pMeasureCheckId.trim();
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}
}