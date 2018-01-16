package com.megagao.production.ssm.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class Process {
	
	@Size(max=40, message="{id.length.error}")
    private String processId;
	
    private String technologyPlanId;

	@Max(value=999999999, message="工序顺序不能超过999999999")
    private Integer sequence;

	@Max(value=999999999, message="单件定额工时不能超过999999999")
    private Integer quota;

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
}