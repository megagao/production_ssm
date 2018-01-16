package com.megagao.production.ssm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceTypeExample() {
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

        public Criteria andDeviceTypeIdIsNull() {
            addCriterion("device_type_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdIsNotNull() {
            addCriterion("device_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdEqualTo(String value) {
            addCriterion("device_type_id =", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotEqualTo(String value) {
            addCriterion("device_type_id <>", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdGreaterThan(String value) {
            addCriterion("device_type_id >", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_type_id >=", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdLessThan(String value) {
            addCriterion("device_type_id <", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdLessThanOrEqualTo(String value) {
            addCriterion("device_type_id <=", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdLike(String value) {
            addCriterion("device_type_id like", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotLike(String value) {
            addCriterion("device_type_id not like", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdIn(List<String> values) {
            addCriterion("device_type_id in", values, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotIn(List<String> values) {
            addCriterion("device_type_id not in", values, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdBetween(String value1, String value2) {
            addCriterion("device_type_id between", value1, value2, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotBetween(String value1, String value2) {
            addCriterion("device_type_id not between", value1, value2, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameIsNull() {
            addCriterion("device_type_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameIsNotNull() {
            addCriterion("device_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameEqualTo(String value) {
            addCriterion("device_type_name =", value, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameNotEqualTo(String value) {
            addCriterion("device_type_name <>", value, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameGreaterThan(String value) {
            addCriterion("device_type_name >", value, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_type_name >=", value, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameLessThan(String value) {
            addCriterion("device_type_name <", value, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameLessThanOrEqualTo(String value) {
            addCriterion("device_type_name <=", value, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameLike(String value) {
            addCriterion("device_type_name like", value, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameNotLike(String value) {
            addCriterion("device_type_name not like", value, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameIn(List<String> values) {
            addCriterion("device_type_name in", values, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameNotIn(List<String> values) {
            addCriterion("device_type_name not in", values, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameBetween(String value1, String value2) {
            addCriterion("device_type_name between", value1, value2, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeNameNotBetween(String value1, String value2) {
            addCriterion("device_type_name not between", value1, value2, "deviceTypeName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelIsNull() {
            addCriterion("device_type_model is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelIsNotNull() {
            addCriterion("device_type_model is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelEqualTo(String value) {
            addCriterion("device_type_model =", value, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelNotEqualTo(String value) {
            addCriterion("device_type_model <>", value, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelGreaterThan(String value) {
            addCriterion("device_type_model >", value, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelGreaterThanOrEqualTo(String value) {
            addCriterion("device_type_model >=", value, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelLessThan(String value) {
            addCriterion("device_type_model <", value, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelLessThanOrEqualTo(String value) {
            addCriterion("device_type_model <=", value, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelLike(String value) {
            addCriterion("device_type_model like", value, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelNotLike(String value) {
            addCriterion("device_type_model not like", value, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelIn(List<String> values) {
            addCriterion("device_type_model in", values, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelNotIn(List<String> values) {
            addCriterion("device_type_model not in", values, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelBetween(String value1, String value2) {
            addCriterion("device_type_model between", value1, value2, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeModelNotBetween(String value1, String value2) {
            addCriterion("device_type_model not between", value1, value2, "deviceTypeModel");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecIsNull() {
            addCriterion("device_type_spec is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecIsNotNull() {
            addCriterion("device_type_spec is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecEqualTo(String value) {
            addCriterion("device_type_spec =", value, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecNotEqualTo(String value) {
            addCriterion("device_type_spec <>", value, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecGreaterThan(String value) {
            addCriterion("device_type_spec >", value, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecGreaterThanOrEqualTo(String value) {
            addCriterion("device_type_spec >=", value, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecLessThan(String value) {
            addCriterion("device_type_spec <", value, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecLessThanOrEqualTo(String value) {
            addCriterion("device_type_spec <=", value, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecLike(String value) {
            addCriterion("device_type_spec like", value, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecNotLike(String value) {
            addCriterion("device_type_spec not like", value, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecIn(List<String> values) {
            addCriterion("device_type_spec in", values, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecNotIn(List<String> values) {
            addCriterion("device_type_spec not in", values, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecBetween(String value1, String value2) {
            addCriterion("device_type_spec between", value1, value2, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSpecNotBetween(String value1, String value2) {
            addCriterion("device_type_spec not between", value1, value2, "deviceTypeSpec");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierIsNull() {
            addCriterion("device_type_supplier is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierIsNotNull() {
            addCriterion("device_type_supplier is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierEqualTo(String value) {
            addCriterion("device_type_supplier =", value, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierNotEqualTo(String value) {
            addCriterion("device_type_supplier <>", value, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierGreaterThan(String value) {
            addCriterion("device_type_supplier >", value, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("device_type_supplier >=", value, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierLessThan(String value) {
            addCriterion("device_type_supplier <", value, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierLessThanOrEqualTo(String value) {
            addCriterion("device_type_supplier <=", value, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierLike(String value) {
            addCriterion("device_type_supplier like", value, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierNotLike(String value) {
            addCriterion("device_type_supplier not like", value, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierIn(List<String> values) {
            addCriterion("device_type_supplier in", values, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierNotIn(List<String> values) {
            addCriterion("device_type_supplier not in", values, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierBetween(String value1, String value2) {
            addCriterion("device_type_supplier between", value1, value2, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeSupplierNotBetween(String value1, String value2) {
            addCriterion("device_type_supplier not between", value1, value2, "deviceTypeSupplier");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerIsNull() {
            addCriterion("device_type_producer is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerIsNotNull() {
            addCriterion("device_type_producer is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerEqualTo(String value) {
            addCriterion("device_type_producer =", value, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerNotEqualTo(String value) {
            addCriterion("device_type_producer <>", value, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerGreaterThan(String value) {
            addCriterion("device_type_producer >", value, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerGreaterThanOrEqualTo(String value) {
            addCriterion("device_type_producer >=", value, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerLessThan(String value) {
            addCriterion("device_type_producer <", value, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerLessThanOrEqualTo(String value) {
            addCriterion("device_type_producer <=", value, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerLike(String value) {
            addCriterion("device_type_producer like", value, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerNotLike(String value) {
            addCriterion("device_type_producer not like", value, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerIn(List<String> values) {
            addCriterion("device_type_producer in", values, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerNotIn(List<String> values) {
            addCriterion("device_type_producer not in", values, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerBetween(String value1, String value2) {
            addCriterion("device_type_producer between", value1, value2, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeProducerNotBetween(String value1, String value2) {
            addCriterion("device_type_producer not between", value1, value2, "deviceTypeProducer");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityIsNull() {
            addCriterion("device_type_quantity is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityIsNotNull() {
            addCriterion("device_type_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityEqualTo(Integer value) {
            addCriterion("device_type_quantity =", value, "deviceTypeQuantity");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityNotEqualTo(Integer value) {
            addCriterion("device_type_quantity <>", value, "deviceTypeQuantity");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityGreaterThan(Integer value) {
            addCriterion("device_type_quantity >", value, "deviceTypeQuantity");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("device_type_quantity >=", value, "deviceTypeQuantity");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityLessThan(Integer value) {
            addCriterion("device_type_quantity <", value, "deviceTypeQuantity");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("device_type_quantity <=", value, "deviceTypeQuantity");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityIn(List<Integer> values) {
            addCriterion("device_type_quantity in", values, "deviceTypeQuantity");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityNotIn(List<Integer> values) {
            addCriterion("device_type_quantity not in", values, "deviceTypeQuantity");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityBetween(Integer value1, Integer value2) {
            addCriterion("device_type_quantity between", value1, value2, "deviceTypeQuantity");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("device_type_quantity not between", value1, value2, "deviceTypeQuantity");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyIsNull() {
            addCriterion("device_type_warranty is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyIsNotNull() {
            addCriterion("device_type_warranty is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyEqualTo(Date value) {
            addCriterion("device_type_warranty =", value, "deviceTypeWarranty");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyNotEqualTo(Date value) {
            addCriterion("device_type_warranty <>", value, "deviceTypeWarranty");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyGreaterThan(Date value) {
            addCriterion("device_type_warranty >", value, "deviceTypeWarranty");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyGreaterThanOrEqualTo(Date value) {
            addCriterion("device_type_warranty >=", value, "deviceTypeWarranty");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyLessThan(Date value) {
            addCriterion("device_type_warranty <", value, "deviceTypeWarranty");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyLessThanOrEqualTo(Date value) {
            addCriterion("device_type_warranty <=", value, "deviceTypeWarranty");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyIn(List<Date> values) {
            addCriterion("device_type_warranty in", values, "deviceTypeWarranty");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyNotIn(List<Date> values) {
            addCriterion("device_type_warranty not in", values, "deviceTypeWarranty");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyBetween(Date value1, Date value2) {
            addCriterion("device_type_warranty between", value1, value2, "deviceTypeWarranty");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeWarrantyNotBetween(Date value1, Date value2) {
            addCriterion("device_type_warranty not between", value1, value2, "deviceTypeWarranty");
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