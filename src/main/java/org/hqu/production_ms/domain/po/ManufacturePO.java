package org.hqu.production_ms.domain.po;

import java.util.Date;

public class ManufacturePO {
    private String manufactureSn;

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