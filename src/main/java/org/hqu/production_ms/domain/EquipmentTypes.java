package org.hqu.production_ms.domain;

import java.util.Date;

public class EquipmentTypes {
    private String typesId;

    private String typesName;

    private String typesStandard;

    private String typesVersion;

    private String typesSupplier;

    private String typesProvider;

    private Date typesPeriod;

    private Integer typesCount;

    public String getTypesId() {
        return typesId;
    }

    public void setTypesId(String typesId) {
        this.typesId = typesId == null ? null : typesId.trim();
    }

    public String getTypesName() {
        return typesName;
    }

    public void setTypesName(String typesName) {
        this.typesName = typesName == null ? null : typesName.trim();
    }

    public String getTypesStandard() {
        return typesStandard;
    }

    public void setTypesStandard(String typesStandard) {
        this.typesStandard = typesStandard == null ? null : typesStandard.trim();
    }

    public String getTypesVersion() {
        return typesVersion;
    }

    public void setTypesVersion(String typesVersion) {
        this.typesVersion = typesVersion == null ? null : typesVersion.trim();
    }

    public String getTypesSupplier() {
        return typesSupplier;
    }

    public void setTypesSupplier(String typesSupplier) {
        this.typesSupplier = typesSupplier == null ? null : typesSupplier.trim();
    }

    public String getTypesProvider() {
        return typesProvider;
    }

    public void setTypesProvider(String typesProvider) {
        this.typesProvider = typesProvider == null ? null : typesProvider.trim();
    }

    public Date getTypesPeriod() {
        return typesPeriod;
    }

    public void setTypesPeriod(Date typesPeriod) {
        this.typesPeriod = typesPeriod;
    }

    public Integer getTypesCount() {
        return typesCount;
    }

    public void setTypesCount(Integer typesCount) {
        this.typesCount = typesCount;
    }
}