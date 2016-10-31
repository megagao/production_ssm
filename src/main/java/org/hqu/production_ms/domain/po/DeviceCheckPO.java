package org.hqu.production_ms.domain.po;

import org.hqu.production_ms.domain.DeviceCheck;

public class DeviceCheckPO extends DeviceCheck{
	
	private String deviceIdd;
	
	private String deviceName;
	
	private String deviceCheckEmp;
	
	private String deviceCheckFaultIdd;

	public String getDeviceIdd() {
		return deviceIdd;
	}

	public void setDeviceIdd(String deviceIdd) {
		this.deviceIdd = deviceIdd;
	}

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

	public String getDeviceCheckFaultIdd() {
		return deviceCheckFaultIdd;
	}

	public void setDeviceCheckFaultIdd(String deviceCheckFaultIdd) {
		this.deviceCheckFaultIdd = deviceCheckFaultIdd;
	}
	
	

}