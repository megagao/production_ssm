package com.megagao.production.ssm.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class Manufacture {

	@Size(max=40, message="{id.length.error}")
    private String manufactureSn;

	@Max(value=999999999, message="投产数量过大")
    private Integer launchQuantity;
	
    private Date beginDate;

    private Date endDate;

    private String orderId;

    private String technologyId;
    
    public String getManufactureSn() {
        return manufactureSn;
    }

    public void setManufactureSn(String manufactureSn) {
        this.manufactureSn = manufactureSn == null ? null : manufactureSn.trim();
    }

    public Integer getLaunchQuantity() {
        return launchQuantity;
    }

    public void setLaunchQuantity(Integer launchQuantity) {
        this.launchQuantity = launchQuantity;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(String technologyId) {
		this.technologyId = technologyId;
	}
    
}