package com.megagao.production.ssm.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class MaterialConsume {
	
	@Size(max=40, message="{id.length.error}")
    private String consumeId;

    private String workId;

    private String materialId;

    @Max(value=999999999, message="消耗数量过大")
    private Integer consumeAmount;

    private Date consumeDate;

    @Size(max=40, message="发送者的长度限制在40个字符之内")
    private String sender;

    @Size(max=40, message="接收者的长度限制在40个字符之内")
    private String receiver;

    @Size(max=5000, message="{note.length.error}")
    private String note;

    public String getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(String consumeId) {
        this.consumeId = consumeId == null ? null : consumeId.trim();
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public Integer getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(Integer consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public Date getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}