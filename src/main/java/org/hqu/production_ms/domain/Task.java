package org.hqu.production_ms.domain;

public class Task {
    private String taskId;

    private Integer taskQuantity;

    private Long workingHours;
    
    private Manufacture manufacture;

    private Work work;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public Integer getTaskQuantity() {
        return taskQuantity;
    }

    public void setTaskQuantity(Integer taskQuantity) {
        this.taskQuantity = taskQuantity;
    }

    public Long getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Long workingHours) {
        this.workingHours = workingHours;
    }

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}
}