package com.megagao.production.ssm.domain;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class Technology {
	
	@Size(max=40, message="{id.length.error}")
    private String technologyId;

	@Size(max=100, message="{name.length.error}")
    private String technologyName;

	@Max(value=999999999, message="外协价格不能超过999999999")
    private BigDecimal price;

	@Size(max=10, message="瓶颈工序工期的长度限制在10个字符之内")
    private String vitalProcessPeriod;

	@Max(value=999999999, message="标准加工能力不能超过999999999")
    private Integer standardCapacity;

	@Max(value=999999999, message="加班标准加工能力不能超过999999999")
    private Integer overtimeStandardCapacity;

	@Max(value=999999999, message="加班超额加工能力不能超过999999999")
    private Integer overtimeOverfulfilCapacity;

	@Max(value=999999999, message="二倍工序能力不能超过999999999")
    private Integer doubleCapacity;

	@Max(value=999999999, message="超负荷工序能力不能超过999999999")
    private Integer overfulfilCapacity;

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName == null ? null : technologyName.trim();
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
}