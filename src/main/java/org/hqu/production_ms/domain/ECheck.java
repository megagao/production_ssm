package org.hqu.production_ms.domain;

import java.util.Date;

public class ECheck {
    private String checkId;

    private Date date;

    private String result;

    private String equipmentFailureId;
    
    private Equipment equipment;

    private Employee employee;

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
}