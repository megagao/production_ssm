package org.hqu.production_ms.domain;

import java.math.BigDecimal;

public class Technology {
    private String technologyId;

    private BigDecimal price;

    private String vitalProcessPeriod;

    private Integer standardCapacity;

    private Integer overtimeStandardCapacity;

    private Integer overtimeOverfulfilCapacity;

    private Integer doubleCapacity;

    private Integer overfulfilCapacity;

    private byte[] technologyName;

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getVitalProcessPeriod() {
        return vitalProcessPeriod;
    }

    public void setVitalProcessPeriod(String vitalProcessPeriod) {
        this.vitalProcessPeriod = vitalProcessPeriod == null ? null : vitalProcessPeriod.trim();
    }

    public Integer getStandardCapacity() {
        return standardCapacity;
    }

    public void setStandardCapacity(Integer standardCapacity) {
        this.standardCapacity = standardCapacity;
    }

    public Integer getOvertimeStandardCapacity() {
        return overtimeStandardCapacity;
    }

    public void setOvertimeStandardCapacity(Integer overtimeStandardCapacity) {
        this.overtimeStandardCapacity = overtimeStandardCapacity;
    }

    public Integer getOvertimeOverfulfilCapacity() {
        return overtimeOverfulfilCapacity;
    }

    public void setOvertimeOverfulfilCapacity(Integer overtimeOverfulfilCapacity) {
        this.overtimeOverfulfilCapacity = overtimeOverfulfilCapacity;
    }

    public Integer getDoubleCapacity() {
        return doubleCapacity;
    }

    public void setDoubleCapacity(Integer doubleCapacity) {
        this.doubleCapacity = doubleCapacity;
    }

    public Integer getOverfulfilCapacity() {
        return overfulfilCapacity;
    }

    public void setOverfulfilCapacity(Integer overfulfilCapacity) {
        this.overfulfilCapacity = overfulfilCapacity;
    }

    public byte[] getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(byte[] technologyName) {
        this.technologyName = technologyName;
    }
}