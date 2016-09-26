package org.hqu.production_ms.domain;

import java.util.Date;

public class ECheck {
    private String checkId;

    private String equipmentId;

    private String empId;

    private Date cdate;

    private String result;

    private String equipmentFailureId;

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getEquipmentFailureId() {
        return equipmentFailureId;
    }

    public void setEquipmentFailureId(String equipmentFailureId) {
        this.equipmentFailureId = equipmentFailureId == null ? null : equipmentFailureId.trim();
    }
}