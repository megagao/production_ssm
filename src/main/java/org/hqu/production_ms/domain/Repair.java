package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Repair {
    private String repairId;

    private Date repairDate;

    private BigDecimal repairCost;

    private String repairResult;

    private String comment;
    
    private EquipmentFailure failure;
    
    private Employee employee;
    
    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId == null ? null : repairId.trim();
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public BigDecimal getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(BigDecimal repairCost) {
        this.repairCost = repairCost;
    }

    public String getRepairResult() {
        return repairResult;
    }

    public void setRepairResult(String repairResult) {
        this.repairResult = repairResult == null ? null : repairResult.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

	public EquipmentFailure getFailure() {
		return failure;
	}

	public void setFailure(EquipmentFailure failure) {
		this.failure = failure;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}