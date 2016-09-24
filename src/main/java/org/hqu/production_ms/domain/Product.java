package org.hqu.production_ms.domain;

public class Product {
    private String productId;

    private String productName;

    private String productType;

    private String drawing;

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

    public String getDrawing() {
        return drawing;
    }

    public void setDrawing(String drawing) {
        this.drawing = drawing == null ? null : drawing.trim();
    }
}