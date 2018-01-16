package com.megagao.production.ssm.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class ProcessCountCheck {
	
	@Size(max=40, message="{id.length.error}")
    private String pCountCheckId;

    private String processId;

    @Size(max=40, message="检验项目的长度限制在40个字符之内")
    private String checkItem;

    @Max(value=999999999, message="样本总数不能超过999999999")
    private Integer sample;

    @Max(value=999999999, message="抽检数不能超过999999999")
    private Integer checkNumber;

    @Max(value=999999999, message="不合格数不能超过999999999")
    private Integer unqualify;

    @Digits(integer=1, fraction=2, message="数据不合法，请输入类似“0.80”")
    private BigDecimal qualify;

    private Date cdate;

    @Size(max=2000, message="实际测量数据的长度限制在2000个字符之内")
    private String measureData;

    private String empId;

    @Size(max=2000, message="校验结果的长度限制在2000个字符之内")
    private String result;

    @Size(max=5000, message="{note.length.error}")
    private String note;

    public String getpCountCheckId() {
        return pCountCheckId;
    }

    public void setpCountCheckId(String pCountCheckId) {
        this.pCountCheckId = pCountCheckId == null ? null : pCountCheckId.trim();
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
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