package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Device {
    private String deviceId;

    private String deviceName;

    private String deviceStatus;

    private Date devicePurchaseDate;

    private BigDecimal devicePurchasePrice;

    private Date deviceManufactureDate;

    private Date deviceServiceLife;

    private String note;

    private Employee employee;

    private DeviceType deviceType;
    
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus == null ? null : deviceStatus.trim();
    }

    public Date getDevicePurchaseDate() {
        return devicePurchaseDate;
    }

    public void setDevicePurchaseDate(Date devicePurchaseDate) {
        this.devicePurchaseDate = devicePurchaseDate;
    }

    public BigDecimal getDevicePurchasePrice() {
        return devicePurchasePrice;
    }

    public void setDevicePurchasePrice(BigDecimal devicePurchasePrice) {
        this.devicePurchasePrice = devicePurchasePrice;
    }

    public Date getDeviceManufactureDate() {
        return deviceManufactureDate;
    }

    public void setDeviceManufactureDate(Date deviceManufactureDate) {
        this.deviceManufactureDate = deviceManufactureDate;
    }

    public Date getDeviceServiceLife() {
        return deviceServiceLife;
    }

    public void setDeviceServiceLife(Date deviceServiceLife) {
        this.deviceServiceLife = deviceServiceLife;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
}