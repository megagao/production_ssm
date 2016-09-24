package org.hqu.production_ms.domain;

import java.util.Date;

public class EquipmentFailure {
    private String failureId;

    private String equitmentId;

    private String equipmentId;

    private String reason;

    private Date failureDate;

    private String repairMode;

    public String getFailureId() {
        return failureId;
    }

    public void setFailureId(String failureId) {
        this.failureId = failureId == null ? null : failureId.trim();
    }

    public String getEquitmentId() {
        return equitmentId;
    }

    public void setEquitmentId(String equitmentId) {
        this.equitmentId = equitmentId == null ? null : equitmentId.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getFailureDate() {
        return failureDate;
    }

    public void setFailureDate(Date failureDate) {
        this.failureDate = failureDate;
    }

    public String getRepairMode() {
        return repairMode;
    }

    public void setRepairMode(String repairMode) {
        this.repairMode = repairMode == null ? null : repairMode.trim();
    }
}