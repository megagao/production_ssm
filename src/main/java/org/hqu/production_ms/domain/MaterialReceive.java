package org.hqu.production_ms.domain;

import java.util.Date;

public class MaterialReceive {
    private String receiveId;

    private Material material;

    private Integer ammount;

    private Date receiveDate;

    private String sender;

    private String receiver;

    private String note;

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
       this.receiveId = receiveId == null ? null : receiveId.trim();
    	//this.receiveId=receiveId;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
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
