package org.hqu.production_ms.domain.po;

import org.hqu.production_ms.domain.DeviceCheck;

public class DeviceCheckPO extends DeviceCheck{
	
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