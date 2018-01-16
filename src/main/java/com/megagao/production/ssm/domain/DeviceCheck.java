package com.megagao.production.ssm.domain;

import java.util.Date;

import javax.validation.constraints.Size;

public class DeviceCheck {
	
	@Size(max=40, message="{id.length.error}")
    private String deviceCheckId;

    private String deviceId;

    private String deviceCheckEmpId;

    private Date deviceCheckDate;

    @Size(max=5000, message="例检结果长度请限制在5000个字符内")
    private String deviceCheckResult;

    private String deviceCheckFaultId;

    public String getDeviceCheckId() {
        return deviceCheckId;
    }

    public void setDeviceCheckId(String deviceCheckId) {
        this.deviceCheckId = deviceCheckId == null ? null : deviceCheckId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceCheckEmpId() {
        return deviceCheckEmpId;
    }

    public void setDeviceCheckEmpId(String deviceCheckEmpId) {
        this.deviceCheckEmpId = deviceCheckEmpId == null ? null : deviceCheckEmpId.trim();
    }

    public Date getDeviceCheckDate() {
        return deviceCheckDate;
    }

    public void setDeviceCheckDate(Date deviceCheckDate) {
        this.deviceCheckDate = deviceCheckDate;
    }

    public String getDeviceCheckResult() {
        return deviceCheckResult;
    }

    public void setDeviceCheckResult(String deviceCheckResult) {
        this.deviceCheckResult = deviceCheckResult == null ? null : deviceCheckResult.trim();
    }

    public String getDeviceCheckFaultId() {
        return deviceCheckFaultId;
    }

    public void setDeviceCheckFaultId(String deviceCheckFaultId) {
        this.deviceCheckFaultId = deviceCheckFaultId == null ? null : deviceCheckFaultId.trim();
    }
}