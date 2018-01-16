package com.megagao.production.ssm.domain;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
public class MaterialReceive {
	
	@Size(max=40, message="{id.length.error}")
    private String receiveId;

    private String materialId;

    @Max(value=999999999, message="收入数量过大")
    private Integer amount;

    private Date receiveDate;

    @Size(max=40, message="发送者的长度限制在40个字符之内")
    private String sender;

    @Size(max=40, message="接收者的长度限制在40个字符之内")
    private String receiver;

    @Size(max=5000, message="{note.length.error}")
    private String note;

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId == null ? null : receiveId.trim();
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getreceiver() {
        return receiver;
    }

    public void setreceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}