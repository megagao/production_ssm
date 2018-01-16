package com.megagao.production.ssm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceFaultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceFaultExample() {
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

        public Criteria andDeviceFaultIdIsNull() {
            addCriterion("device_fault_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdIsNotNull() {
            addCriterion("device_fault_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdEqualTo(String value) {
            addCriterion("device_fault_id =", value, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdNotEqualTo(String value) {
            addCriterion("device_fault_id <>", value, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdGreaterThan(String value) {
            addCriterion("device_fault_id >", value, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_fault_id >=", value, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdLessThan(String value) {
            addCriterion("device_fault_id <", value, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdLessThanOrEqualTo(String value) {
            addCriterion("device_fault_id <=", value, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdLike(String value) {
            addCriterion("device_fault_id like", value, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdNotLike(String value) {
            addCriterion("device_fault_id not like", value, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdIn(List<String> values) {
            addCriterion("device_fault_id in", values, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdNotIn(List<String> values) {
            addCriterion("device_fault_id not in", values, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdBetween(String value1, String value2) {
            addCriterion("device_fault_id between", value1, value2, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultIdNotBetween(String value1, String value2) {
            addCriterion("device_fault_id not between", value1, value2, "deviceFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseIsNull() {
            addCriterion("device_fault_cause is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseIsNotNull() {
            addCriterion("device_fault_cause is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseEqualTo(String value) {
            addCriterion("device_fault_cause =", value, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseNotEqualTo(String value) {
            addCriterion("device_fault_cause <>", value, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseGreaterThan(String value) {
            addCriterion("device_fault_cause >", value, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseGreaterThanOrEqualTo(String value) {
            addCriterion("device_fault_cause >=", value, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseLessThan(String value) {
            addCriterion("device_fault_cause <", value, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseLessThanOrEqualTo(String value) {
            addCriterion("device_fault_cause <=", value, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseLike(String value) {
            addCriterion("device_fault_cause like", value, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseNotLike(String value) {
            addCriterion("device_fault_cause not like", value, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseIn(List<String> values) {
            addCriterion("device_fault_cause in", values, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseNotIn(List<String> values) {
            addCriterion("device_fault_cause not in", values, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseBetween(String value1, String value2) {
            addCriterion("device_fault_cause between", value1, value2, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultCauseNotBetween(String value1, String value2) {
            addCriterion("device_fault_cause not between", value1, value2, "deviceFaultCause");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailIsNull() {
            addCriterion("device_fault_detail is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailIsNotNull() {
            addCriterion("device_fault_detail is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailEqualTo(String value) {
            addCriterion("device_fault_detail =", value, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailNotEqualTo(String value) {
            addCriterion("device_fault_detail <>", value, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailGreaterThan(String value) {
            addCriterion("device_fault_detail >", value, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailGreaterThanOrEqualTo(String value) {
            addCriterion("device_fault_detail >=", value, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailLessThan(String value) {
            addCriterion("device_fault_detail <", value, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailLessThanOrEqualTo(String value) {
            addCriterion("device_fault_detail <=", value, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailLike(String value) {
            addCriterion("device_fault_detail like", value, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailNotLike(String value) {
            addCriterion("device_fault_detail not like", value, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailIn(List<String> values) {
            addCriterion("device_fault_detail in", values, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailNotIn(List<String> values) {
            addCriterion("device_fault_detail not in", values, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailBetween(String value1, String value2) {
            addCriterion("device_fault_detail between", value1, value2, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDetailNotBetween(String value1, String value2) {
            addCriterion("device_fault_detail not between", value1, value2, "deviceFaultDetail");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateIsNull() {
            addCriterion("device_fault_date is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateIsNotNull() {
            addCriterion("device_fault_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateEqualTo(Date value) {
            addCriterion("device_fault_date =", value, "deviceFaultDate");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateNotEqualTo(Date value) {
            addCriterion("device_fault_date <>", value, "deviceFaultDate");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateGreaterThan(Date value) {
            addCriterion("device_fault_date >", value, "deviceFaultDate");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateGreaterThanOrEqualTo(Date value) {
            addCriterion("device_fault_date >=", value, "deviceFaultDate");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateLessThan(Date value) {
            addCriterion("device_fault_date <", value, "deviceFaultDate");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateLessThanOrEqualTo(Date value) {
            addCriterion("device_fault_date <=", value, "deviceFaultDate");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateIn(List<Date> values) {
            addCriterion("device_fault_date in", values, "deviceFaultDate");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateNotIn(List<Date> values) {
            addCriterion("device_fault_date not in", values, "deviceFaultDate");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateBetween(Date value1, Date value2) {
            addCriterion("device_fault_date between", value1, value2, "deviceFaultDate");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultDateNotBetween(Date value1, Date value2) {
            addCriterion("device_fault_date not between", value1, value2, "deviceFaultDate");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceIsNull() {
            addCriterion("device_fault_maintenance is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceIsNotNull() {
            addCriterion("device_fault_maintenance is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceEqualTo(String value) {
            addCriterion("device_fault_maintenance =", value, "deviceFaultMaintenance");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceNotEqualTo(String value) {
            addCriterion("device_fault_maintenance <>", value, "deviceFaultMaintenance");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceGreaterThan(String value) {
            addCriterion("device_fault_maintenance >", value, "deviceFaultMaintenance");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceGreaterThanOrEqualTo(String value) {
            addCriterion("device_fault_maintenance >=", value, "deviceFaultMaintenance");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceLessThan(String value) {
            addCriterion("device_fault_maintenance <", value, "deviceFaultMaintenance");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceLessThanOrEqualTo(String value) {
            addCriterion("device_fault_maintenance <=", value, "deviceFaultMaintenance");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceLike(String value) {
            addCriterion("device_fault_maintenance like", value, "deviceFaultMaintenance");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceNotLike(String value) {
            addCriterion("device_fault_maintenance not like", value, "deviceFaultMaintenance");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceIn(List<String> values) {
            addCriterion("device_fault_maintenance in", values, "deviceFaultMaintenance");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceNotIn(List<String> values) {
            addCriterion("device_fault_maintenance not in", values, "deviceFaultMaintenance");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceBetween(String value1, String value2) {
            addCriterion("device_fault_maintenance between", value1, value2, "deviceFaultMaintenance");
            return (Criteria) this;
        }

        public Criteria andDeviceFaultMaintenanceNotBetween(String value1, String value2) {
            addCriterion("device_fault_maintenance not between", value1, value2, "deviceFaultMaintenance");
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