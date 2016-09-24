package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquipmentTypesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentTypesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTypesIdIsNull() {
            addCriterion("types_id is null");
            return (Criteria) this;
        }

        public Criteria andTypesIdIsNotNull() {
            addCriterion("types_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypesIdEqualTo(String value) {
            addCriterion("types_id =", value, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesIdNotEqualTo(String value) {
            addCriterion("types_id <>", value, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesIdGreaterThan(String value) {
            addCriterion("types_id >", value, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesIdGreaterThanOrEqualTo(String value) {
            addCriterion("types_id >=", value, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesIdLessThan(String value) {
            addCriterion("types_id <", value, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesIdLessThanOrEqualTo(String value) {
            addCriterion("types_id <=", value, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesIdLike(String value) {
            addCriterion("types_id like", value, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesIdNotLike(String value) {
            addCriterion("types_id not like", value, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesIdIn(List<String> values) {
            addCriterion("types_id in", values, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesIdNotIn(List<String> values) {
            addCriterion("types_id not in", values, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesIdBetween(String value1, String value2) {
            addCriterion("types_id between", value1, value2, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesIdNotBetween(String value1, String value2) {
            addCriterion("types_id not between", value1, value2, "typesId");
            return (Criteria) this;
        }

        public Criteria andTypesNameIsNull() {
            addCriterion("types_name is null");
            return (Criteria) this;
        }

        public Criteria andTypesNameIsNotNull() {
            addCriterion("types_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypesNameEqualTo(String value) {
            addCriterion("types_name =", value, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesNameNotEqualTo(String value) {
            addCriterion("types_name <>", value, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesNameGreaterThan(String value) {
            addCriterion("types_name >", value, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesNameGreaterThanOrEqualTo(String value) {
            addCriterion("types_name >=", value, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesNameLessThan(String value) {
            addCriterion("types_name <", value, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesNameLessThanOrEqualTo(String value) {
            addCriterion("types_name <=", value, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesNameLike(String value) {
            addCriterion("types_name like", value, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesNameNotLike(String value) {
            addCriterion("types_name not like", value, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesNameIn(List<String> values) {
            addCriterion("types_name in", values, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesNameNotIn(List<String> values) {
            addCriterion("types_name not in", values, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesNameBetween(String value1, String value2) {
            addCriterion("types_name between", value1, value2, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesNameNotBetween(String value1, String value2) {
            addCriterion("types_name not between", value1, value2, "typesName");
            return (Criteria) this;
        }

        public Criteria andTypesStandardIsNull() {
            addCriterion("types_standard is null");
            return (Criteria) this;
        }

        public Criteria andTypesStandardIsNotNull() {
            addCriterion("types_standard is not null");
            return (Criteria) this;
        }

        public Criteria andTypesStandardEqualTo(String value) {
            addCriterion("types_standard =", value, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesStandardNotEqualTo(String value) {
            addCriterion("types_standard <>", value, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesStandardGreaterThan(String value) {
            addCriterion("types_standard >", value, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesStandardGreaterThanOrEqualTo(String value) {
            addCriterion("types_standard >=", value, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesStandardLessThan(String value) {
            addCriterion("types_standard <", value, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesStandardLessThanOrEqualTo(String value) {
            addCriterion("types_standard <=", value, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesStandardLike(String value) {
            addCriterion("types_standard like", value, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesStandardNotLike(String value) {
            addCriterion("types_standard not like", value, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesStandardIn(List<String> values) {
            addCriterion("types_standard in", values, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesStandardNotIn(List<String> values) {
            addCriterion("types_standard not in", values, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesStandardBetween(String value1, String value2) {
            addCriterion("types_standard between", value1, value2, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesStandardNotBetween(String value1, String value2) {
            addCriterion("types_standard not between", value1, value2, "typesStandard");
            return (Criteria) this;
        }

        public Criteria andTypesVersionIsNull() {
            addCriterion("types_version is null");
            return (Criteria) this;
        }

        public Criteria andTypesVersionIsNotNull() {
            addCriterion("types_version is not null");
            return (Criteria) this;
        }

        public Criteria andTypesVersionEqualTo(String value) {
            addCriterion("types_version =", value, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesVersionNotEqualTo(String value) {
            addCriterion("types_version <>", value, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesVersionGreaterThan(String value) {
            addCriterion("types_version >", value, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesVersionGreaterThanOrEqualTo(String value) {
            addCriterion("types_version >=", value, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesVersionLessThan(String value) {
            addCriterion("types_version <", value, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesVersionLessThanOrEqualTo(String value) {
            addCriterion("types_version <=", value, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesVersionLike(String value) {
            addCriterion("types_version like", value, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesVersionNotLike(String value) {
            addCriterion("types_version not like", value, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesVersionIn(List<String> values) {
            addCriterion("types_version in", values, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesVersionNotIn(List<String> values) {
            addCriterion("types_version not in", values, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesVersionBetween(String value1, String value2) {
            addCriterion("types_version between", value1, value2, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesVersionNotBetween(String value1, String value2) {
            addCriterion("types_version not between", value1, value2, "typesVersion");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierIsNull() {
            addCriterion("types_supplier is null");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierIsNotNull() {
            addCriterion("types_supplier is not null");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierEqualTo(String value) {
            addCriterion("types_supplier =", value, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierNotEqualTo(String value) {
            addCriterion("types_supplier <>", value, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierGreaterThan(String value) {
            addCriterion("types_supplier >", value, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("types_supplier >=", value, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierLessThan(String value) {
            addCriterion("types_supplier <", value, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierLessThanOrEqualTo(String value) {
            addCriterion("types_supplier <=", value, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierLike(String value) {
            addCriterion("types_supplier like", value, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierNotLike(String value) {
            addCriterion("types_supplier not like", value, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierIn(List<String> values) {
            addCriterion("types_supplier in", values, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierNotIn(List<String> values) {
            addCriterion("types_supplier not in", values, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierBetween(String value1, String value2) {
            addCriterion("types_supplier between", value1, value2, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesSupplierNotBetween(String value1, String value2) {
            addCriterion("types_supplier not between", value1, value2, "typesSupplier");
            return (Criteria) this;
        }

        public Criteria andTypesProviderIsNull() {
            addCriterion("types_provider is null");
            return (Criteria) this;
        }

        public Criteria andTypesProviderIsNotNull() {
            addCriterion("types_provider is not null");
            return (Criteria) this;
        }

        public Criteria andTypesProviderEqualTo(String value) {
            addCriterion("types_provider =", value, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesProviderNotEqualTo(String value) {
            addCriterion("types_provider <>", value, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesProviderGreaterThan(String value) {
            addCriterion("types_provider >", value, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesProviderGreaterThanOrEqualTo(String value) {
            addCriterion("types_provider >=", value, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesProviderLessThan(String value) {
            addCriterion("types_provider <", value, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesProviderLessThanOrEqualTo(String value) {
            addCriterion("types_provider <=", value, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesProviderLike(String value) {
            addCriterion("types_provider like", value, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesProviderNotLike(String value) {
            addCriterion("types_provider not like", value, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesProviderIn(List<String> values) {
            addCriterion("types_provider in", values, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesProviderNotIn(List<String> values) {
            addCriterion("types_provider not in", values, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesProviderBetween(String value1, String value2) {
            addCriterion("types_provider between", value1, value2, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesProviderNotBetween(String value1, String value2) {
            addCriterion("types_provider not between", value1, value2, "typesProvider");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodIsNull() {
            addCriterion("types_period is null");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodIsNotNull() {
            addCriterion("types_period is not null");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodEqualTo(Date value) {
            addCriterion("types_period =", value, "typesPeriod");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodNotEqualTo(Date value) {
            addCriterion("types_period <>", value, "typesPeriod");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodGreaterThan(Date value) {
            addCriterion("types_period >", value, "typesPeriod");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodGreaterThanOrEqualTo(Date value) {
            addCriterion("types_period >=", value, "typesPeriod");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodLessThan(Date value) {
            addCriterion("types_period <", value, "typesPeriod");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodLessThanOrEqualTo(Date value) {
            addCriterion("types_period <=", value, "typesPeriod");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodIn(List<Date> values) {
            addCriterion("types_period in", values, "typesPeriod");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodNotIn(List<Date> values) {
            addCriterion("types_period not in", values, "typesPeriod");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodBetween(Date value1, Date value2) {
            addCriterion("types_period between", value1, value2, "typesPeriod");
            return (Criteria) this;
        }

        public Criteria andTypesPeriodNotBetween(Date value1, Date value2) {
            addCriterion("types_period not between", value1, value2, "typesPeriod");
            return (Criteria) this;
        }

        public Criteria andTypesCountIsNull() {
            addCriterion("types_count is null");
            return (Criteria) this;
        }

        public Criteria andTypesCountIsNotNull() {
            addCriterion("types_count is not null");
            return (Criteria) this;
        }

        public Criteria andTypesCountEqualTo(Integer value) {
            addCriterion("types_count =", value, "typesCount");
            return (Criteria) this;
        }

        public Criteria andTypesCountNotEqualTo(Integer value) {
            addCriterion("types_count <>", value, "typesCount");
            return (Criteria) this;
        }

        public Criteria andTypesCountGreaterThan(Integer value) {
            addCriterion("types_count >", value, "typesCount");
            return (Criteria) this;
        }

        public Criteria andTypesCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("types_count >=", value, "typesCount");
            return (Criteria) this;
        }

        public Criteria andTypesCountLessThan(Integer value) {
            addCriterion("types_count <", value, "typesCount");
            return (Criteria) this;
        }

        public Criteria andTypesCountLessThanOrEqualTo(Integer value) {
            addCriterion("types_count <=", value, "typesCount");
            return (Criteria) this;
        }

        public Criteria andTypesCountIn(List<Integer> values) {
            addCriterion("types_count in", values, "typesCount");
            return (Criteria) this;
        }

        public Criteria andTypesCountNotIn(List<Integer> values) {
            addCriterion("types_count not in", values, "typesCount");
            return (Criteria) this;
        }

        public Criteria andTypesCountBetween(Integer value1, Integer value2) {
            addCriterion("types_count between", value1, value2, "typesCount");
            return (Criteria) this;
        }

        public Criteria andTypesCountNotBetween(Integer value1, Integer value2) {
            addCriterion("types_count not between", value1, value2, "typesCount");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("type_id like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("type_id not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}