package com.megagao.production.ssm.domain;

import java.util.Date;

import javax.validation.constraints.Size;

public class DeviceFault {
	@Size(max=40, message="{id.length.error}")
    private String deviceFaultId;

    private String deviceId;

    @Size(max=100, message="故障原因长度请限制在100个字符内")
    private String deviceFaultCause;

    @Size(max=5000, message="故障描述长度请限制在5000个字符内")
    private String deviceFaultDetail;

    private Date deviceFaultDate;

    @Size(max=500, message="维修方式长度请限制在500个字符内")
    private String deviceFaultMaintenance;

    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId == null ? null : deviceFaultId.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceFaultCause() {
        return deviceFaultCause;
    }

    public void setDeviceFaultCause(String deviceFaultCause) {
        this.deviceFaultCause = deviceFaultCause == null ? null : deviceFaultCause.trim();
    }

    public String getDeviceFaultDetail() {
        return deviceFaultDetail;
    }

    public void setDeviceFaultDetail(String deviceFaultDetail) {
        this.deviceFaultDetail = deviceFaultDetail == null ? null : deviceFaultDetail.trim();
    }

    public Date getDeviceFaultDate() {
        return deviceFaultDate;
    }

    public void setDeviceFaultDate(Date deviceFaultDate) {
        this.deviceFaultDate = deviceFaultDate;
    }

    public String getDeviceFaultMaintenance() {
        return deviceFaultMaintenance;
    }

    public void setDeviceFaultMaintenance(String deviceFaultMaintenance) {
        this.deviceFaultMaintenance = deviceFaultMaintenance == null ? null : deviceFaultMaintenance.trim();
    }
}