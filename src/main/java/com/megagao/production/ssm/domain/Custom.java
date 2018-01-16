package com.megagao.production.ssm.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class Custom {
	@Size(max=40, message="{id.length.error}")
    private String customId;

	@Size(max=20, message="客户名称请限制在20个字符内")
    private String customName;

	@Size(max=100, message="客户全称请限制在100个字符内")
    private String fullName;

	@Size(max=100, message="地址请限制在100个字符内")
    private String address;

	@Size(max=20, message="传真请限制在20个字符内")
    private String fax;

	@Email(message="请输入正确的邮箱格式")
    private String email;

	@Size(max=20, message="经理姓名请限制在20个字符内")
    private String ownerName;

	@Size(max=20, message="联系电话请限制在20个字符内")
    private String ownerTel;

    private Integer status;

    @Size(max=5000, message="{note.length.error}")
    private String note;

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId == null ? null : customId.trim();
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName == null ? null : customName.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getOwnerTel() {
        return ownerTel;
    }

    public void setOwnerTel(String ownerTel) {
        this.ownerTel = ownerTel == null ? null : ownerTel.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}