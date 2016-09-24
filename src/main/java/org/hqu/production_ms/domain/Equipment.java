package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Equipment {
    private String equitmentId;

    private Date outDate;

    private BigDecimal price;

    private Integer buyDate;

    private Date lifetime;

    private String state;

    private String comment;

    private String empId;

    private EquipmentTypes types;

    public String getEquitmentId() {
        return equitmentId;
    }

    public void setEquitmentId(String equitmentId) {
        this.equitmentId = equitmentId == null ? null : equitmentId.trim();
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Integer buyDate) {
        this.buyDate = buyDate;
    }

    public Date getLifetime() {
        return lifetime;
    }

    public void setLifetime(Date lifetime) {
        this.lifetime = lifetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

	public EquipmentTypes getTypes() {
		return types;
	}

	public void setTypes(EquipmentTypes types) {
		this.types = types;
	}

}