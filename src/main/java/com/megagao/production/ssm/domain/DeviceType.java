package com.megagao.production.ssm.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class DeviceType {
	
	@Size(max=40, message="{id.length.error}")
    private String deviceTypeId;

	@Size(max=100, message="{name.length.error}")
    private String deviceTypeName;
	
	@Size(max=200, message="型号的长度限制在200个字符之内")
    private String deviceTypeModel;

	@Size(max=200, message="规格的长度限制在200个字符之内")
    private String deviceTypeSpec;

	@Size(max=100, message="供应商的长度限制在200个字符之内")
    private String deviceTypeSupplier;

	@Size(max=100, message="生产商的长度限制在200个字符之内")
    private String deviceTypeProducer;

	@Max(value=999999999, message="台数的长度限制在10个字符之内")
    private Integer deviceTypeQuantity;

    private Date deviceTypeWarranty;

    public String getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(String deviceTypeId) {
        this.deviceTypeId = deviceTypeId == null ? null : deviceTypeId.trim();
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName == null ? null : deviceTypeName.trim();
    }

    public String getDeviceTypeModel() {
        return deviceTypeModel;
    }

    public void setDeviceTypeModel(String deviceTypeModel) {
        this.deviceTypeModel = deviceTypeModel == null ? null : deviceTypeModel.trim();
    }

    public String getDeviceTypeSpec() {
        return deviceTypeSpec;
    }

    public void setDeviceTypeSpec(String deviceTypeSpec) {
        this.deviceTypeSpec = deviceTypeSpec == null ? null : deviceTypeSpec.trim();
    }

    public String getDeviceTypeSupplier() {
        return deviceTypeSupplier;
    }

    public void setDeviceTypeSupplier(String deviceTypeSupplier) {
        this.deviceTypeSupplier = deviceTypeSupplier == null ? null : deviceTypeSupplier.trim();
    }

    public String getDeviceTypeProducer() {
        return deviceTypeProducer;
    }

    public void setDeviceTypeProducer(String deviceTypeProducer) {
        this.deviceTypeProducer = deviceTypeProducer == null ? null : deviceTypeProducer.trim();
    }

    public Integer getDeviceTypeQuantity() {
        return deviceTypeQuantity;
    }

    public void setDeviceTypeQuantity(Integer deviceTypeQuantity) {
        this.deviceTypeQuantity = deviceTypeQuantity;
    }

    public Date getDeviceTypeWarranty() {
        return deviceTypeWarranty;
    }

    public void setDeviceTypeWarranty(Date deviceTypeWarranty) {
        this.deviceTypeWarranty = deviceTypeWarranty;
    }
}