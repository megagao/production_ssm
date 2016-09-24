package org.hqu.production_ms.domain;

public class Process {
    private String processId;

    private String technologyPlanId;

    private Integer sequence;

    private Integer quota;
    
    private Technology technology;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId == null ? null : technologyPlanId.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}
}