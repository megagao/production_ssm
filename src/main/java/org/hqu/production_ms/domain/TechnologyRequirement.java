package org.hqu.production_ms.domain;

import java.util.Date;

public class TechnologyRequirement {
    private String technologyRequirementId;

    private String requirement;

    private Date addTime;

    private Date reviseTime;
    
    private Technology technology;

    public String getTechnologyRequirementId() {
        return technologyRequirementId;
    }

    public void setTechnologyRequirementId(String technologyRequirementId) {
        this.technologyRequirementId = technologyRequirementId == null ? null : technologyRequirementId.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getReviseTime() {
        return reviseTime;
    }

    public void setReviseTime(Date reviseTime) {
        this.reviseTime = reviseTime;
    }

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}
}