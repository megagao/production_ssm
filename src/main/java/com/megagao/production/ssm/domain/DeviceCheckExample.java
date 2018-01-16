package com.megagao.production.ssm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceCheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceCheckExample() {
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

        public Criteria andDeviceCheckIdIsNull() {
            addCriterion("device_check_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdIsNotNull() {
            addCriterion("device_check_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdEqualTo(String value) {
            addCriterion("device_check_id =", value, "deviceCheckId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdNotEqualTo(String value) {
            addCriterion("device_check_id <>", value, "deviceCheckId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdGreaterThan(String value) {
            addCriterion("device_check_id >", value, "deviceCheckId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_check_id >=", value, "deviceCheckId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdLessThan(String value) {
            addCriterion("device_check_id <", value, "deviceCheckId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdLessThanOrEqualTo(String value) {
            addCriterion("device_check_id <=", value, "deviceCheckId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdLike(String value) {
            addCriterion("device_check_id like", value, "deviceCheckId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdNotLike(String value) {
            addCriterion("device_check_id not like", value, "deviceCheckId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdIn(List<String> values) {
            addCriterion("device_check_id in", values, "deviceCheckId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdNotIn(List<String> values) {
            addCriterion("device_check_id not in", values, "deviceCheckId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdBetween(String value1, String value2) {
            addCriterion("device_check_id between", value1, value2, "deviceCheckId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckIdNotBetween(String value1, String value2) {
            addCriterion("device_check_id not between", value1, value2, "deviceCheckId");
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

        public Criteria andDeviceCheckEmpIdIsNull() {
            addCriterion("device_check_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdIsNotNull() {
            addCriterion("device_check_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdEqualTo(String value) {
            addCriterion("device_check_emp_id =", value, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdNotEqualTo(String value) {
            addCriterion("device_check_emp_id <>", value, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdGreaterThan(String value) {
            addCriterion("device_check_emp_id >", value, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_check_emp_id >=", value, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdLessThan(String value) {
            addCriterion("device_check_emp_id <", value, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdLessThanOrEqualTo(String value) {
            addCriterion("device_check_emp_id <=", value, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdLike(String value) {
            addCriterion("device_check_emp_id like", value, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdNotLike(String value) {
            addCriterion("device_check_emp_id not like", value, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdIn(List<String> values) {
            addCriterion("device_check_emp_id in", values, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdNotIn(List<String> values) {
            addCriterion("device_check_emp_id not in", values, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdBetween(String value1, String value2) {
            addCriterion("device_check_emp_id between", value1, value2, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckEmpIdNotBetween(String value1, String value2) {
            addCriterion("device_check_emp_id not between", value1, value2, "deviceCheckEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateIsNull() {
            addCriterion("device_check_date is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateIsNotNull() {
            addCriterion("device_check_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateEqualTo(Date value) {
            addCriterion("device_check_date =", value, "deviceCheckDate");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateNotEqualTo(Date value) {
            addCriterion("device_check_date <>", value, "deviceCheckDate");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateGreaterThan(Date value) {
            addCriterion("device_check_date >", value, "deviceCheckDate");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateGreaterThanOrEqualTo(Date value) {
            addCriterion("device_check_date >=", value, "deviceCheckDate");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateLessThan(Date value) {
            addCriterion("device_check_date <", value, "deviceCheckDate");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateLessThanOrEqualTo(Date value) {
            addCriterion("device_check_date <=", value, "deviceCheckDate");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateIn(List<Date> values) {
            addCriterion("device_check_date in", values, "deviceCheckDate");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateNotIn(List<Date> values) {
            addCriterion("device_check_date not in", values, "deviceCheckDate");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateBetween(Date value1, Date value2) {
            addCriterion("device_check_date between", value1, value2, "deviceCheckDate");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckDateNotBetween(Date value1, Date value2) {
            addCriterion("device_check_date not between", value1, value2, "deviceCheckDate");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultIsNull() {
            addCriterion("device_check_result is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultIsNotNull() {
            addCriterion("device_check_result is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultEqualTo(String value) {
            addCriterion("device_check_result =", value, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultNotEqualTo(String value) {
            addCriterion("device_check_result <>", value, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultGreaterThan(String value) {
            addCriterion("device_check_result >", value, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultGreaterThanOrEqualTo(String value) {
            addCriterion("device_check_result >=", value, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultLessThan(String value) {
            addCriterion("device_check_result <", value, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultLessThanOrEqualTo(String value) {
            addCriterion("device_check_result <=", value, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultLike(String value) {
            addCriterion("device_check_result like", value, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultNotLike(String value) {
            addCriterion("device_check_result not like", value, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultIn(List<String> values) {
            addCriterion("device_check_result in", values, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultNotIn(List<String> values) {
            addCriterion("device_check_result not in", values, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultBetween(String value1, String value2) {
            addCriterion("device_check_result between", value1, value2, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckResultNotBetween(String value1, String value2) {
            addCriterion("device_check_result not between", value1, value2, "deviceCheckResult");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdIsNull() {
            addCriterion("device_check_fault_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdIsNotNull() {
            addCriterion("device_check_fault_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdEqualTo(String value) {
            addCriterion("device_check_fault_id =", value, "deviceCheckFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdNotEqualTo(String value) {
            addCriterion("device_check_fault_id <>", value, "deviceCheckFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdGreaterThan(String value) {
            addCriterion("device_check_fault_id >", value, "deviceCheckFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_check_fault_id >=", value, "deviceCheckFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdLessThan(String value) {
            addCriterion("device_check_fault_id <", value, "deviceCheckFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdLessThanOrEqualTo(String value) {
            addCriterion("device_check_fault_id <=", value, "deviceCheckFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdLike(String value) {
            addCriterion("device_check_fault_id like", value, "deviceCheckFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdNotLike(String value) {
            addCriterion("device_check_fault_id not like", value, "deviceCheckFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdIn(List<String> values) {
            addCriterion("device_check_fault_id in", values, "deviceCheckFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdNotIn(List<String> values) {
            addCriterion("device_check_fault_id not in", values, "deviceCheckFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdBetween(String value1, String value2) {
            addCriterion("device_check_fault_id between", value1, value2, "deviceCheckFaultId");
            return (Criteria) this;
        }

        public Criteria andDeviceCheckFaultIdNotBetween(String value1, String value2) {
            addCriterion("device_check_fault_id not between", value1, value2, "deviceCheckFaultId");
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