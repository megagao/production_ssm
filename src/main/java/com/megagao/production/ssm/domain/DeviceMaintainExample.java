package com.megagao.production.ssm.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceMaintainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceMaintainExample() {
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

        public Criteria andDeviceMaintainIdIsNull() {
            addCriterion("device_maintain_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdIsNotNull() {
            addCriterion("device_maintain_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdEqualTo(String value) {
            addCriterion("device_maintain_id =", value, "deviceMaintainId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdNotEqualTo(String value) {
            addCriterion("device_maintain_id <>", value, "deviceMaintainId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdGreaterThan(String value) {
            addCriterion("device_maintain_id >", value, "deviceMaintainId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_maintain_id >=", value, "deviceMaintainId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdLessThan(String value) {
            addCriterion("device_maintain_id <", value, "deviceMaintainId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdLessThanOrEqualTo(String value) {
            addCriterion("device_maintain_id <=", value, "deviceMaintainId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdLike(String value) {
            addCriterion("device_maintain_id like", value, "deviceMaintainId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdNotLike(String value) {
            addCriterion("device_maintain_id not like", value, "deviceMaintainId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdIn(List<String> values) {
            addCriterion("device_maintain_id in", values, "deviceMaintainId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdNotIn(List<String> values) {
            addCriterion("device_maintain_id not in", values, "deviceMaintainId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdBetween(String value1, String value2) {
            addCriterion("device_maintain_id between", value1, value2, "deviceMaintainId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainIdNotBetween(String value1, String value2) {
            addCriterion("device_maintain_id not between", value1, value2, "deviceMaintainId");
            return (Criteria) this;
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

        public Criteria andDeviceMaintainEmpIdIsNull() {
            addCriterion("device_maintain_emp_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdIsNotNull() {
            addCriterion("device_maintain_emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdEqualTo(String value) {
            addCriterion("device_maintain_emp_id =", value, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdNotEqualTo(String value) {
            addCriterion("device_maintain_emp_id <>", value, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdGreaterThan(String value) {
            addCriterion("device_maintain_emp_id >", value, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_maintain_emp_id >=", value, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdLessThan(String value) {
            addCriterion("device_maintain_emp_id <", value, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdLessThanOrEqualTo(String value) {
            addCriterion("device_maintain_emp_id <=", value, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdLike(String value) {
            addCriterion("device_maintain_emp_id like", value, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdNotLike(String value) {
            addCriterion("device_maintain_emp_id not like", value, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdIn(List<String> values) {
            addCriterion("device_maintain_emp_id in", values, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdNotIn(List<String> values) {
            addCriterion("device_maintain_emp_id not in", values, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdBetween(String value1, String value2) {
            addCriterion("device_maintain_emp_id between", value1, value2, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainEmpIdNotBetween(String value1, String value2) {
            addCriterion("device_maintain_emp_id not between", value1, value2, "deviceMaintainEmpId");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateIsNull() {
            addCriterion("device_maintain_date is null");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateIsNotNull() {
            addCriterion("device_maintain_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateEqualTo(Date value) {
            addCriterion("device_maintain_date =", value, "deviceMaintainDate");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateNotEqualTo(Date value) {
            addCriterion("device_maintain_date <>", value, "deviceMaintainDate");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateGreaterThan(Date value) {
            addCriterion("device_maintain_date >", value, "deviceMaintainDate");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateGreaterThanOrEqualTo(Date value) {
            addCriterion("device_maintain_date >=", value, "deviceMaintainDate");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateLessThan(Date value) {
            addCriterion("device_maintain_date <", value, "deviceMaintainDate");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateLessThanOrEqualTo(Date value) {
            addCriterion("device_maintain_date <=", value, "deviceMaintainDate");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateIn(List<Date> values) {
            addCriterion("device_maintain_date in", values, "deviceMaintainDate");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateNotIn(List<Date> values) {
            addCriterion("device_maintain_date not in", values, "deviceMaintainDate");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateBetween(Date value1, Date value2) {
            addCriterion("device_maintain_date between", value1, value2, "deviceMaintainDate");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainDateNotBetween(Date value1, Date value2) {
            addCriterion("device_maintain_date not between", value1, value2, "deviceMaintainDate");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultIsNull() {
            addCriterion("device_maintain_result is null");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultIsNotNull() {
            addCriterion("device_maintain_result is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultEqualTo(String value) {
            addCriterion("device_maintain_result =", value, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultNotEqualTo(String value) {
            addCriterion("device_maintain_result <>", value, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultGreaterThan(String value) {
            addCriterion("device_maintain_result >", value, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultGreaterThanOrEqualTo(String value) {
            addCriterion("device_maintain_result >=", value, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultLessThan(String value) {
            addCriterion("device_maintain_result <", value, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultLessThanOrEqualTo(String value) {
            addCriterion("device_maintain_result <=", value, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultLike(String value) {
            addCriterion("device_maintain_result like", value, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultNotLike(String value) {
            addCriterion("device_maintain_result not like", value, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultIn(List<String> values) {
            addCriterion("device_maintain_result in", values, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultNotIn(List<String> values) {
            addCriterion("device_maintain_result not in", values, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultBetween(String value1, String value2) {
            addCriterion("device_maintain_result between", value1, value2, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainResultNotBetween(String value1, String value2) {
            addCriterion("device_maintain_result not between", value1, value2, "deviceMaintainResult");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostIsNull() {
            addCriterion("device_maintain_cost is null");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostIsNotNull() {
            addCriterion("device_maintain_cost is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostEqualTo(BigDecimal value) {
            addCriterion("device_maintain_cost =", value, "deviceMaintainCost");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostNotEqualTo(BigDecimal value) {
            addCriterion("device_maintain_cost <>", value, "deviceMaintainCost");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostGreaterThan(BigDecimal value) {
            addCriterion("device_maintain_cost >", value, "deviceMaintainCost");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("device_maintain_cost >=", value, "deviceMaintainCost");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostLessThan(BigDecimal value) {
            addCriterion("device_maintain_cost <", value, "deviceMaintainCost");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("device_maintain_cost <=", value, "deviceMaintainCost");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostIn(List<BigDecimal> values) {
            addCriterion("device_maintain_cost in", values, "deviceMaintainCost");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostNotIn(List<BigDecimal> values) {
            addCriterion("device_maintain_cost not in", values, "deviceMaintainCost");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("device_maintain_cost between", value1, value2, "deviceMaintainCost");
            return (Criteria) this;
        }

        public Criteria andDeviceMaintainCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("device_maintain_cost not between", value1, value2, "deviceMaintainCost");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
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