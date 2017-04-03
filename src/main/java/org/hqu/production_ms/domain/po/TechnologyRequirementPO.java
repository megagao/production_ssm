package org.hqu.production_ms.domain.po;


import javax.validation.constraints.Size;

import org.hqu.production_ms.domain.TechnologyRequirement;

public class TechnologyRequirementPO extends TechnologyRequirement{
	
	@Size(max=20, message="工艺名称请限制在20个字符内")
	private String technologyName;

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	
}