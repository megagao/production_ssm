package com.megagao.production.ssm.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TechnologyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TechnologyExample() {
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

        public Criteria andTechnologyNameIsNull() {
            addCriterion("technology_name is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameIsNotNull() {
            addCriterion("technology_name is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameEqualTo(String value) {
            addCriterion("technology_name =", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameNotEqualTo(String value) {
            addCriterion("technology_name <>", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameGreaterThan(String value) {
            addCriterion("technology_name >", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameGreaterThanOrEqualTo(String value) {
            addCriterion("technology_name >=", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameLessThan(String value) {
            addCriterion("technology_name <", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameLessThanOrEqualTo(String value) {
            addCriterion("technology_name <=", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameLike(String value) {
            addCriterion("technology_name like", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameNotLike(String value) {
            addCriterion("technology_name not like", value, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameIn(List<String> values) {
            addCriterion("technology_name in", values, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameNotIn(List<String> values) {
            addCriterion("technology_name not in", values, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameBetween(String value1, String value2) {
            addCriterion("technology_name between", value1, value2, "technologyName");
            return (Criteria) this;
        }

        public Criteria andTechnologyNameNotBetween(String value1, String value2) {
            addCriterion("technology_name not between", value1, value2, "technologyName");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodIsNull() {
            addCriterion("vital_process_period is null");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodIsNotNull() {
            addCriterion("vital_process_period is not null");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodEqualTo(String value) {
            addCriterion("vital_process_period =", value, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodNotEqualTo(String value) {
            addCriterion("vital_process_period <>", value, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodGreaterThan(String value) {
            addCriterion("vital_process_period >", value, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("vital_process_period >=", value, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodLessThan(String value) {
            addCriterion("vital_process_period <", value, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodLessThanOrEqualTo(String value) {
            addCriterion("vital_process_period <=", value, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodLike(String value) {
            addCriterion("vital_process_period like", value, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodNotLike(String value) {
            addCriterion("vital_process_period not like", value, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodIn(List<String> values) {
            addCriterion("vital_process_period in", values, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodNotIn(List<String> values) {
            addCriterion("vital_process_period not in", values, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodBetween(String value1, String value2) {
            addCriterion("vital_process_period between", value1, value2, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andVitalProcessPeriodNotBetween(String value1, String value2) {
            addCriterion("vital_process_period not between", value1, value2, "vitalProcessPeriod");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityIsNull() {
            addCriterion("standard_capacity is null");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityIsNotNull() {
            addCriterion("standard_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityEqualTo(Integer value) {
            addCriterion("standard_capacity =", value, "standardCapacity");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityNotEqualTo(Integer value) {
            addCriterion("standard_capacity <>", value, "standardCapacity");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityGreaterThan(Integer value) {
            addCriterion("standard_capacity >", value, "standardCapacity");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("standard_capacity >=", value, "standardCapacity");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityLessThan(Integer value) {
            addCriterion("standard_capacity <", value, "standardCapacity");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("standard_capacity <=", value, "standardCapacity");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityIn(List<Integer> values) {
            addCriterion("standard_capacity in", values, "standardCapacity");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityNotIn(List<Integer> values) {
            addCriterion("standard_capacity not in", values, "standardCapacity");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityBetween(Integer value1, Integer value2) {
            addCriterion("standard_capacity between", value1, value2, "standardCapacity");
            return (Criteria) this;
        }

        public Criteria andStandardCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("standard_capacity not between", value1, value2, "standardCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityIsNull() {
            addCriterion("overtime_standard_capacity is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityIsNotNull() {
            addCriterion("overtime_standard_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityEqualTo(Integer value) {
            addCriterion("overtime_standard_capacity =", value, "overtimeStandardCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityNotEqualTo(Integer value) {
            addCriterion("overtime_standard_capacity <>", value, "overtimeStandardCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityGreaterThan(Integer value) {
            addCriterion("overtime_standard_capacity >", value, "overtimeStandardCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("overtime_standard_capacity >=", value, "overtimeStandardCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityLessThan(Integer value) {
            addCriterion("overtime_standard_capacity <", value, "overtimeStandardCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("overtime_standard_capacity <=", value, "overtimeStandardCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityIn(List<Integer> values) {
            addCriterion("overtime_standard_capacity in", values, "overtimeStandardCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityNotIn(List<Integer> values) {
            addCriterion("overtime_standard_capacity not in", values, "overtimeStandardCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityBetween(Integer value1, Integer value2) {
            addCriterion("overtime_standard_capacity between", value1, value2, "overtimeStandardCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeStandardCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("overtime_standard_capacity not between", value1, value2, "overtimeStandardCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityIsNull() {
            addCriterion("overtime_overfulfil_capacity is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityIsNotNull() {
            addCriterion("overtime_overfulfil_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityEqualTo(Integer value) {
            addCriterion("overtime_overfulfil_capacity =", value, "overtimeOverfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityNotEqualTo(Integer value) {
            addCriterion("overtime_overfulfil_capacity <>", value, "overtimeOverfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityGreaterThan(Integer value) {
            addCriterion("overtime_overfulfil_capacity >", value, "overtimeOverfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("overtime_overfulfil_capacity >=", value, "overtimeOverfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityLessThan(Integer value) {
            addCriterion("overtime_overfulfil_capacity <", value, "overtimeOverfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("overtime_overfulfil_capacity <=", value, "overtimeOverfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityIn(List<Integer> values) {
            addCriterion("overtime_overfulfil_capacity in", values, "overtimeOverfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityNotIn(List<Integer> values) {
            addCriterion("overtime_overfulfil_capacity not in", values, "overtimeOverfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityBetween(Integer value1, Integer value2) {
            addCriterion("overtime_overfulfil_capacity between", value1, value2, "overtimeOverfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOvertimeOverfulfilCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("overtime_overfulfil_capacity not between", value1, value2, "overtimeOverfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityIsNull() {
            addCriterion("double_capacity is null");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityIsNotNull() {
            addCriterion("double_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityEqualTo(Integer value) {
            addCriterion("double_capacity =", value, "doubleCapacity");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityNotEqualTo(Integer value) {
            addCriterion("double_capacity <>", value, "doubleCapacity");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityGreaterThan(Integer value) {
            addCriterion("double_capacity >", value, "doubleCapacity");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("double_capacity >=", value, "doubleCapacity");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityLessThan(Integer value) {
            addCriterion("double_capacity <", value, "doubleCapacity");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("double_capacity <=", value, "doubleCapacity");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityIn(List<Integer> values) {
            addCriterion("double_capacity in", values, "doubleCapacity");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityNotIn(List<Integer> values) {
            addCriterion("double_capacity not in", values, "doubleCapacity");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityBetween(Integer value1, Integer value2) {
            addCriterion("double_capacity between", value1, value2, "doubleCapacity");
            return (Criteria) this;
        }

        public Criteria andDoubleCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("double_capacity not between", value1, value2, "doubleCapacity");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityIsNull() {
            addCriterion("overfulfil_capacity is null");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityIsNotNull() {
            addCriterion("overfulfil_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityEqualTo(Integer value) {
            addCriterion("overfulfil_capacity =", value, "overfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityNotEqualTo(Integer value) {
            addCriterion("overfulfil_capacity <>", value, "overfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityGreaterThan(Integer value) {
            addCriterion("overfulfil_capacity >", value, "overfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("overfulfil_capacity >=", value, "overfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityLessThan(Integer value) {
            addCriterion("overfulfil_capacity <", value, "overfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityLessThanOrEqualTo(Integer value) {
            addCriterion("overfulfil_capacity <=", value, "overfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityIn(List<Integer> values) {
            addCriterion("overfulfil_capacity in", values, "overfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityNotIn(List<Integer> values) {
            addCriterion("overfulfil_capacity not in", values, "overfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityBetween(Integer value1, Integer value2) {
            addCriterion("overfulfil_capacity between", value1, value2, "overfulfilCapacity");
            return (Criteria) this;
        }

        public Criteria andOverfulfilCapacityNotBetween(Integer value1, Integer value2) {
            addCriterion("overfulfil_capacity not between", value1, value2, "overfulfilCapacity");
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