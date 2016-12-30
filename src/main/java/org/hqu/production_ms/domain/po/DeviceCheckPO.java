package org.hqu.production_ms.domain.po;

import javax.validation.constraints.Size;

import org.hqu.production_ms.domain.DeviceCheck;

public class DeviceCheckPO extends DeviceCheck{
	
	@Size(max=20, message="设备名称请限制在20个字符内")
	private String deviceName;
	
	private String deviceCheckEmp;
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceCheckEmp() {
		return deviceCheckEmp;
	}

	public void setDeviceCheckEmp(String deviceCheckEmp) {
		this.deviceCheckEmp = deviceCheckEmp;
	}

}