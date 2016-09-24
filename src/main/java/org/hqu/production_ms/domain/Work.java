package org.hqu.production_ms.domain;

public class Work {
    private String workId;

    private Equipment equipment;

    private String processNumber;

    private Product product;

    private Process process;

    private String equitmentId;

    private Integer rating;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber == null ? null : processNumber.trim();
    }

    public String getEquitmentId() {
        return equitmentId;
    }

    public void setEquitmentId(String equitmentId) {
        this.equitmentId = equitmentId == null ? null : equitmentId.trim();
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}
    
}