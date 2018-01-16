package com.megagao.production.ssm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManufactureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManufactureExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdIsNull() {
            addCriterion("technology_id is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdIsNotNull() {
            addCriterion("technology_id is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdEqualTo(String value) {
            addCriterion("technology_id =", value, "technologyId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdNotEqualTo(String value) {
            addCriterion("technology_id <>", value, "technologyId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdGreaterThan(String value) {
            addCriterion("technology_id >", value, "technologyId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdGreaterThanOrEqualTo(String value) {
            addCriterion("technology_id >=", value, "technologyId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdLessThan(String value) {
            addCriterion("technology_id <", value, "technologyId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdLessThanOrEqualTo(String value) {
            addCriterion("technology_id <=", value, "technologyId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdLike(String value) {
            addCriterion("technology_id like", value, "technologyId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdNotLike(String value) {
            addCriterion("technology_id not like", value, "technologyId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdIn(List<String> values) {
            addCriterion("technology_id in", values, "technologyId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdNotIn(List<String> values) {
            addCriterion("technology_id not in", values, "technologyId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdBetween(String value1, String value2) {
            addCriterion("technology_id between", value1, value2, "technologyId");
            return (Criteria) this;
        }

        public Criteria andTechnologyIdNotBetween(String value1, String value2) {
            addCriterion("technology_id not between", value1, value2, "technologyId");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityIsNull() {
            addCriterion("launch_quantity is null");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityIsNotNull() {
            addCriterion("launch_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityEqualTo(Integer value) {
            addCriterion("launch_quantity =", value, "launchQuantity");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityNotEqualTo(Integer value) {
            addCriterion("launch_quantity <>", value, "launchQuantity");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityGreaterThan(Integer value) {
            addCriterion("launch_quantity >", value, "launchQuantity");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("launch_quantity >=", value, "launchQuantity");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityLessThan(Integer value) {
            addCriterion("launch_quantity <", value, "launchQuantity");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("launch_quantity <=", value, "launchQuantity");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityIn(List<Integer> values) {
            addCriterion("launch_quantity in", values, "launchQuantity");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityNotIn(List<Integer> values) {
            addCriterion("launch_quantity not in", values, "launchQuantity");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityBetween(Integer value1, Integer value2) {
            addCriterion("launch_quantity between", value1, value2, "launchQuantity");
            return (Criteria) this;
        }

        public Criteria andLaunchQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("launch_quantity not between", value1, value2, "launchQuantity");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterion("begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterion("begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterion("begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterion("begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterion("begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterion("begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterion("begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
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