package com.megagao.production.ssm.domain;

import java.util.ArrayList;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andManufactureSnIsNull() {
            addCriterion("manufacture_sn is null");
            return (Criteria) this;
        }

        public Criteria andManufactureSnIsNotNull() {
            addCriterion("manufacture_sn is not null");
            return (Criteria) this;
        }

        public Criteria andManufactureSnEqualTo(String value) {
            addCriterion("manufacture_sn =", value, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andManufactureSnNotEqualTo(String value) {
            addCriterion("manufacture_sn <>", value, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andManufactureSnGreaterThan(String value) {
            addCriterion("manufacture_sn >", value, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andManufactureSnGreaterThanOrEqualTo(String value) {
            addCriterion("manufacture_sn >=", value, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andManufactureSnLessThan(String value) {
            addCriterion("manufacture_sn <", value, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andManufactureSnLessThanOrEqualTo(String value) {
            addCriterion("manufacture_sn <=", value, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andManufactureSnLike(String value) {
            addCriterion("manufacture_sn like", value, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andManufactureSnNotLike(String value) {
            addCriterion("manufacture_sn not like", value, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andManufactureSnIn(List<String> values) {
            addCriterion("manufacture_sn in", values, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andManufactureSnNotIn(List<String> values) {
            addCriterion("manufacture_sn not in", values, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andManufactureSnBetween(String value1, String value2) {
            addCriterion("manufacture_sn between", value1, value2, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andManufactureSnNotBetween(String value1, String value2) {
            addCriterion("manufacture_sn not between", value1, value2, "manufactureSn");
            return (Criteria) this;
        }

        public Criteria andWorkIdIsNull() {
            addCriterion("work_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkIdIsNotNull() {
            addCriterion("work_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkIdEqualTo(String value) {
            addCriterion("work_id =", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotEqualTo(String value) {
            addCriterion("work_id <>", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThan(String value) {
            addCriterion("work_id >", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThanOrEqualTo(String value) {
            addCriterion("work_id >=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThan(String value) {
            addCriterion("work_id <", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThanOrEqualTo(String value) {
            addCriterion("work_id <=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLike(String value) {
            addCriterion("work_id like", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotLike(String value) {
            addCriterion("work_id not like", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdIn(List<String> values) {
            addCriterion("work_id in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotIn(List<String> values) {
            addCriterion("work_id not in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdBetween(String value1, String value2) {
            addCriterion("work_id between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotBetween(String value1, String value2) {
            addCriterion("work_id not between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityIsNull() {
            addCriterion("task_quantity is null");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityIsNotNull() {
            addCriterion("task_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityEqualTo(Integer value) {
            addCriterion("task_quantity =", value, "taskQuantity");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityNotEqualTo(Integer value) {
            addCriterion("task_quantity <>", value, "taskQuantity");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityGreaterThan(Integer value) {
            addCriterion("task_quantity >", value, "taskQuantity");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_quantity >=", value, "taskQuantity");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityLessThan(Integer value) {
            addCriterion("task_quantity <", value, "taskQuantity");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("task_quantity <=", value, "taskQuantity");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityIn(List<Integer> values) {
            addCriterion("task_quantity in", values, "taskQuantity");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityNotIn(List<Integer> values) {
            addCriterion("task_quantity not in", values, "taskQuantity");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityBetween(Integer value1, Integer value2) {
            addCriterion("task_quantity between", value1, value2, "taskQuantity");
            return (Criteria) this;
        }

        public Criteria andTaskQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("task_quantity not between", value1, value2, "taskQuantity");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursIsNull() {
            addCriterion("working_hours is null");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursIsNotNull() {
            addCriterion("working_hours is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursEqualTo(Long value) {
            addCriterion("working_hours =", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursNotEqualTo(Long value) {
            addCriterion("working_hours <>", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursGreaterThan(Long value) {
            addCriterion("working_hours >", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursGreaterThanOrEqualTo(Long value) {
            addCriterion("working_hours >=", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursLessThan(Long value) {
            addCriterion("working_hours <", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursLessThanOrEqualTo(Long value) {
            addCriterion("working_hours <=", value, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursIn(List<Long> values) {
            addCriterion("working_hours in", values, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursNotIn(List<Long> values) {
            addCriterion("working_hours not in", values, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursBetween(Long value1, Long value2) {
            addCriterion("working_hours between", value1, value2, "workingHours");
            return (Criteria) this;
        }

        public Criteria andWorkingHoursNotBetween(Long value1, Long value2) {
            addCriterion("working_hours not between", value1, value2, "workingHours");
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