package com.megagao.production.ssm.domain.vo;


import com.megagao.production.ssm.domain.Process;
import com.megagao.production.ssm.domain.Product;
import com.megagao.production.ssm.domain.Device;

public class WorkVO {
	
    private String workId;

    private String processNumber;
    
    private Product product;

    private Process process;

    private Device device;

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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
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

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
}