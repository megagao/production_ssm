package com.megagao.production.ssm.domain.vo;

import com.megagao.production.ssm.domain.Device;

public class DeviceVO extends Device{
	
	private String deviceIdd;
	
	private String deviceTypeName;

	private String deviceKeeper;

	public String getDeviceIdd() {
		return deviceIdd;
	}

	public void setDeviceIdd(String deviceIdd) {
		this.deviceIdd = deviceIdd;
	}

	public String getDeviceTypeName() {
		return deviceTypeName;
	}

	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}

	public String getDeviceKeeper() {
		return deviceKeeper;
	}

	public void setDeviceKeeper(String deviceKeeper) {
		this.deviceKeeper = deviceKeeper;
	}

	
	
	
}