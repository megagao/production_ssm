package org.hqu.production_ms.domain.po;

import org.hqu.production_ms.domain.ProcessCountCheck;

public class ProcessCountCheckPO extends ProcessCountCheck{
	private String empName;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
}
