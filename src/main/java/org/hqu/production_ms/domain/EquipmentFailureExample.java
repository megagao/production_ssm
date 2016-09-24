package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquipmentFailureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentFailureExample() {
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

        public Criteria andFailureIdIsNull() {
            addCriterion("failure_id is null");
            return (Criteria) this;
        }

        public Criteria andFailureIdIsNotNull() {
            addCriterion("failure_id is not null");
            return (Criteria) this;
        }

        public Criteria andFailureIdEqualTo(String value) {
            addCriterion("failure_id =", value, "failureId");
            return (Criteria) this;
        }

        public Criteria andFailureIdNotEqualTo(String value) {
            addCriterion("failure_id <>", value, "failureId");
            return (Criteria) this;
        }

        public Criteria andFailureIdGreaterThan(String value) {
            addCriterion("failure_id >", value, "failureId");
            return (Criteria) this;
        }

        public Criteria andFailureIdGreaterThanOrEqualTo(String value) {
            addCriterion("failure_id >=", value, "failureId");
            return (Criteria) this;
        }

        public Criteria andFailureIdLessThan(String value) {
            addCriterion("failure_id <", value, "failureId");
            return (Criteria) this;
        }

        public Criteria andFailureIdLessThanOrEqualTo(String value) {
            addCriterion("failure_id <=", value, "failureId");
            return (Criteria) this;
        }

        public Criteria andFailureIdLike(String value) {
            addCriterion("failure_id like", value, "failureId");
            return (Criteria) this;
        }

        public Criteria andFailureIdNotLike(String value) {
            addCriterion("failure_id not like", value, "failureId");
            return (Criteria) this;
        }

        public Criteria andFailureIdIn(List<String> values) {
            addCriterion("failure_id in", values, "failureId");
            return (Criteria) this;
        }

        public Criteria andFailureIdNotIn(List<String> values) {
            addCriterion("failure_id not in", values, "failureId");
            return (Criteria) this;
        }

        public Criteria andFailureIdBetween(String value1, String value2) {
            addCriterion("failure_id between", value1, value2, "failureId");
            return (Criteria) this;
        }

        public Criteria andFailureIdNotBetween(String value1, String value2) {
            addCriterion("failure_id not between", value1, value2, "failureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNull() {
            addCriterion("equipment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("equipment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(String value) {
            addCriterion("equipment_id =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(String value) {
            addCriterion("equipment_id <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(String value) {
            addCriterion("equipment_id >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_id >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(String value) {
            addCriterion("equipment_id <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(String value) {
            addCriterion("equipment_id <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLike(String value) {
            addCriterion("equipment_id like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotLike(String value) {
            addCriterion("equipment_id not like", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<String> values) {
            addCriterion("equipment_id in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<String> values) {
            addCriterion("equipment_id not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(String value1, String value2) {
            addCriterion("equipment_id between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(String value1, String value2) {
            addCriterion("equipment_id not between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andFailureDateIsNull() {
            addCriterion("failure_date is null");
            return (Criteria) this;
        }

        public Criteria andFailureDateIsNotNull() {
            addCriterion("failure_date is not null");
            return (Criteria) this;
        }

        public Criteria andFailureDateEqualTo(Date value) {
            addCriterion("failure_date =", value, "failureDate");
            return (Criteria) this;
        }

        public Criteria andFailureDateNotEqualTo(Date value) {
            addCriterion("failure_date <>", value, "failureDate");
            return (Criteria) this;
        }

        public Criteria andFailureDateGreaterThan(Date value) {
            addCriterion("failure_date >", value, "failureDate");
            return (Criteria) this;
        }

        public Criteria andFailureDateGreaterThanOrEqualTo(Date value) {
            addCriterion("failure_date >=", value, "failureDate");
            return (Criteria) this;
        }

        public Criteria andFailureDateLessThan(Date value) {
            addCriterion("failure_date <", value, "failureDate");
            return (Criteria) this;
        }

        public Criteria andFailureDateLessThanOrEqualTo(Date value) {
            addCriterion("failure_date <=", value, "failureDate");
            return (Criteria) this;
        }

        public Criteria andFailureDateIn(List<Date> values) {
            addCriterion("failure_date in", values, "failureDate");
            return (Criteria) this;
        }

        public Criteria andFailureDateNotIn(List<Date> values) {
            addCriterion("failure_date not in", values, "failureDate");
            return (Criteria) this;
        }

        public Criteria andFailureDateBetween(Date value1, Date value2) {
            addCriterion("failure_date between", value1, value2, "failureDate");
            return (Criteria) this;
        }

        public Criteria andFailureDateNotBetween(Date value1, Date value2) {
            addCriterion("failure_date not between", value1, value2, "failureDate");
            return (Criteria) this;
        }

        public Criteria andRepairModeIsNull() {
            addCriterion("repair_mode is null");
            return (Criteria) this;
        }

        public Criteria andRepairModeIsNotNull() {
            addCriterion("repair_mode is not null");
            return (Criteria) this;
        }

        public Criteria andRepairModeEqualTo(String value) {
            addCriterion("repair_mode =", value, "repairMode");
            return (Criteria) this;
        }

        public Criteria andRepairModeNotEqualTo(String value) {
            addCriterion("repair_mode <>", value, "repairMode");
            return (Criteria) this;
        }

        public Criteria andRepairModeGreaterThan(String value) {
            addCriterion("repair_mode >", value, "repairMode");
            return (Criteria) this;
        }

        public Criteria andRepairModeGreaterThanOrEqualTo(String value) {
            addCriterion("repair_mode >=", value, "repairMode");
            return (Criteria) this;
        }

        public Criteria andRepairModeLessThan(String value) {
            addCriterion("repair_mode <", value, "repairMode");
            return (Criteria) this;
        }

        public Criteria andRepairModeLessThanOrEqualTo(String value) {
            addCriterion("repair_mode <=", value, "repairMode");
            return (Criteria) this;
        }

        public Criteria andRepairModeLike(String value) {
            addCriterion("repair_mode like", value, "repairMode");
            return (Criteria) this;
        }

        public Criteria andRepairModeNotLike(String value) {
            addCriterion("repair_mode not like", value, "repairMode");
            return (Criteria) this;
        }

        public Criteria andRepairModeIn(List<String> values) {
            addCriterion("repair_mode in", values, "repairMode");
            return (Criteria) this;
        }

        public Criteria andRepairModeNotIn(List<String> values) {
            addCriterion("repair_mode not in", values, "repairMode");
            return (Criteria) this;
        }

        public Criteria andRepairModeBetween(String value1, String value2) {
            addCriterion("repair_mode between", value1, value2, "repairMode");
            return (Criteria) this;
        }

        public Criteria andRepairModeNotBetween(String value1, String value2) {
            addCriterion("repair_mode not between", value1, value2, "repairMode");
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