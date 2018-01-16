package com.megagao.production.ssm.domain;

import javax.validation.constraints.Size;

public class Product {
	
	@Size(max=40, message="{id.length.error}")
    private String productId;

	@Size(max=100, message="{name.length.error}")
    private String productName;

	@Size(max=100, message="产品种类的长度限制在100个字符之内")
    private String productType;

    private String image;

    @Size(max=5000, message="{note.length.error}")
    private String note;

    private Integer status;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}