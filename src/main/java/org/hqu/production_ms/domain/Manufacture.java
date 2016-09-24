package org.hqu.production_ms.domain;

import java.util.Date;

public class Manufacture {
    private String manufactureSn;

    private Integer launchQuantity;

    private Date beginDate;

    private Date endDate;
    
    private Product product;

    private Technology technology;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}
}