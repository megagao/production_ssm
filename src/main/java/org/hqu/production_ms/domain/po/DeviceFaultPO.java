package org.hqu.production_ms.domain.po;

import org.hqu.production_ms.domain.DeviceFault;

public class DeviceFaultPO extends DeviceFault{
	
	private String deviceIdd;
	
	private String deviceName;
	
	private String deviceCheckFaultId;
	
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

	public String getDeviceCheckFaultId() {
		return deviceCheckFaultId;
	}

	public void setDeviceCheckFaultId(String deviceCheckFaultId) {
		this.deviceCheckFaultId = deviceCheckFaultId;
	}

	public String getDeviceCheckFaultIdd() {
		return deviceCheckFaultIdd;
	}

	public void setDeviceCheckFaultIdd(String deviceCheckFaultIdd) {
		this.deviceCheckFaultIdd = deviceCheckFaultIdd;
	}

	
}