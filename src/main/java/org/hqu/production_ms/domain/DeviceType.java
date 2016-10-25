package org.hqu.production_ms.domain;

import java.util.Date;

public class DeviceType {
    private String deviceTypeId;

    private String deviceTypeName;

    private String deviceTypeModel;

    private String deviceTypeSpec;

    private String deviceTypeSupplier;

    private String deviceTypeProducer;

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