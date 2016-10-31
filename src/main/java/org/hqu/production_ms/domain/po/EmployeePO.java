package org.hqu.production_ms.domain.po;

import org.hqu.production_ms.domain.Device;

public class EmployeePO extends Device{
	
	private String deviceKeeperId;
	
	private String deviceKeeper;
	
	private String deviceMaintainEmpId;
	
	private String deviceMaintainEmp;

	public String getDeviceKeeperId() {
		return deviceKeeperId;
	}

	public void setDeviceKeeperId(String deviceKeeperId) {
		this.deviceKeeperId = deviceKeeperId;
	}

	public String getDeviceKeeper() {
		return deviceKeeper;
	}

	public void setDeviceKeeper(String deviceKeeper) {
		this.deviceKeeper = deviceKeeper;
	}

	public String getDeviceMaintainEmpId() {
		return deviceMaintainEmpId;
	}

	public void setDeviceMaintainEmpId(String deviceMaintainEmpId) {
		this.deviceMaintainEmpId = deviceMaintainEmpId;
	}

	public String getDeviceMaintainEmp() {
		return deviceMaintainEmp;
	}

	public void setDeviceMaintainEmp(String deviceMaintainEmp) {
		this.deviceMaintainEmp = deviceMaintainEmp;
	}

	
}