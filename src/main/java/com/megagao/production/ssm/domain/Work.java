package com.megagao.production.ssm.domain;

import javax.validation.constraints.Size;


public class Work {

	@Size(max=40, message="{id.length.error}")
    private String workId;

	@Size(max=40, message="工序号的长度限制在40个字符之内")
    private String processNumber;

	@Size(max=40, message="{id.length.error}")
    private String productId;

	@Size(max=40, message="{id.length.error}")
    private String processId;

	@Size(max=40, message="{id.length.error}")
    private String deviceId;

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}