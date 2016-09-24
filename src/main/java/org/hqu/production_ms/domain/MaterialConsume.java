package org.hqu.production_ms.domain;

public class MaterialConsume {
    private String consumeId;

    private String consumeAmount;

    private String consumeDate;
    
    private String comment;
    
    private Material material;

    private Employee sender;

    private Employee receiver;

    public String getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(String consumeId) {
        this.consumeId = consumeId == null ? null : consumeId.trim();
    }

    public String getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(String consumeAmount) {
        this.consumeAmount = consumeAmount == null ? null : consumeAmount.trim();
    }

    public String getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(String consumeDate) {
        this.consumeDate = consumeDate == null ? null : consumeDate.trim();
    }

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Employee getSender() {
		return sender;
	}

	public void setSender(Employee sender) {
		this.sender = sender;
	}

	public Employee getReceiver() {
		return receiver;
	}

	public void setReceiver(Employee receiver) {
		this.receiver = receiver;
	}

}