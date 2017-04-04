package org.hqu.production_ms.domain.vo;

import org.hqu.production_ms.domain.ProcessCountCheck;

public class ProcessCountCheckVO extends ProcessCountCheck{
	private String empName;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
}
