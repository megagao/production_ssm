package org.hqu.production_ms.domain.po;

import org.hqu.production_ms.domain.UnqualifyApply;

public class UnqualifyApplyPO extends UnqualifyApply{
	private String productName;

	private String empName;
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
}
