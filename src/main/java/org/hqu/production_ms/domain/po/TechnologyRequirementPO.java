package org.hqu.production_ms.domain.po;


import org.hqu.production_ms.domain.TechnologyRequirement;

public class TechnologyRequirementPO extends TechnologyRequirement{
	
	private String technologyName;

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	
}