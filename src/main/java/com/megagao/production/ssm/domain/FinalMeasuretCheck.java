package com.megagao.production.ssm.domain;

import java.util.Date;

import javax.validation.constraints.Size;

public class FinalMeasuretCheck {
	
	@Size(max=40, message="{id.length.error}")
    private String fMeasureCheckId;

    private String orderId;

    @Size(max=40, message="检验项目的长度限制在40个字符之内")
    private String checkItem;

    private Date cdate;

    @Size(max=2000, message="实际测量数据的长度限制在2000个字符之内")
    private String measureData;

    private String empId;

    @Size(max=2000, message="校验结果的长度限制在2000个字符之内")
    private String result;

    @Size(max=5000, message="{note.length.error}")
    private String note;

    public String getfMeasureCheckId() {
        return fMeasureCheckId;
    }

    public void setfMeasureCheckId(String fMeasureCheckId) {
        this.fMeasureCheckId = fMeasureCheckId == null ? null : fMeasureCheckId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem == null ? null : checkItem.trim();
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getMeasureData() {
        return measureData;
    }

    public void setMeasureData(String measureData) {
        this.measureData = measureData == null ? null : measureData.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}