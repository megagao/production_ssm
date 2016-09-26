package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Equipment {
    private String equipmentId;

    private Date outDate;

    private BigDecimal price;

    private Integer buyDate;

    private Date lifetime;

    private String status;

    private String note;

    private String empId;

    private String typesId;

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public String getTypesId() {
        return typesId;
    }

    public void setTypesId(String typesId) {
        this.typesId = typesId == null ? null : typesId.trim();
    }
}