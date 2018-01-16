package com.megagao.production.ssm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TechnologyPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TechnologyPlanExample() {
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

        public Criteria andTechnologyPlanIdIsNull() {
            addCriterion("technology_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdIsNotNull() {
            addCriterion("technology_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdEqualTo(String value) {
            addCriterion("technology_plan_id =", value, "technologyPlanId");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdNotEqualTo(String value) {
            addCriterion("technology_plan_id <>", value, "technologyPlanId");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdGreaterThan(String value) {
            addCriterion("technology_plan_id >", value, "technologyPlanId");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdGreaterThanOrEqualTo(String value) {
            addCriterion("technology_plan_id >=", value, "technologyPlanId");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdLessThan(String value) {
            addCriterion("technology_plan_id <", value, "technologyPlanId");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdLessThanOrEqualTo(String value) {
            addCriterion("technology_plan_id <=", value, "technologyPlanId");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdLike(String value) {
            addCriterion("technology_plan_id like", value, "technologyPlanId");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdNotLike(String value) {
            addCriterion("technology_plan_id not like", value, "technologyPlanId");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdIn(List<String> values) {
            addCriterion("technology_plan_id in", values, "technologyPlanId");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdNotIn(List<String> values) {
            addCriterion("technology_plan_id not in", values, "technologyPlanId");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdBetween(String value1, String value2) {
            addCriterion("technology_plan_id between", value1, value2, "technologyPlanId");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanIdNotBetween(String value1, String value2) {
            addCriterion("technology_plan_id not between", value1, value2, "technologyPlanId");
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

        public Criteria andBatchAmountIsNull() {
            addCriterion("batch_amount is null");
            return (Criteria) this;
        }

        public Criteria andBatchAmountIsNotNull() {
            addCriterion("batch_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBatchAmountEqualTo(Integer value) {
            addCriterion("batch_amount =", value, "batchAmount");
            return (Criteria) this;
        }

        public Criteria andBatchAmountNotEqualTo(Integer value) {
            addCriterion("batch_amount <>", value, "batchAmount");
            return (Criteria) this;
        }

        public Criteria andBatchAmountGreaterThan(Integer value) {
            addCriterion("batch_amount >", value, "batchAmount");
            return (Criteria) this;
        }

        public Criteria andBatchAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("batch_amount >=", value, "batchAmount");
            return (Criteria) this;
        }

        public Criteria andBatchAmountLessThan(Integer value) {
            addCriterion("batch_amount <", value, "batchAmount");
            return (Criteria) this;
        }

        public Criteria andBatchAmountLessThanOrEqualTo(Integer value) {
            addCriterion("batch_amount <=", value, "batchAmount");
            return (Criteria) this;
        }

        public Criteria andBatchAmountIn(List<Integer> values) {
            addCriterion("batch_amount in", values, "batchAmount");
            return (Criteria) this;
        }

        public Criteria andBatchAmountNotIn(List<Integer> values) {
            addCriterion("batch_amount not in", values, "batchAmount");
            return (Criteria) this;
        }

        public Criteria andBatchAmountBetween(Integer value1, Integer value2) {
            addCriterion("batch_amount between", value1, value2, "batchAmount");
            return (Criteria) this;
        }

        public Criteria andBatchAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("batch_amount not between", value1, value2, "batchAmount");
            return (Criteria) this;
        }

        public Criteria andStartPlanIsNull() {
            addCriterion("start_plan is null");
            return (Criteria) this;
        }

        public Criteria andStartPlanIsNotNull() {
            addCriterion("start_plan is not null");
            return (Criteria) this;
        }

        public Criteria andStartPlanEqualTo(Date value) {
            addCriterion("start_plan =", value, "startPlan");
            return (Criteria) this;
        }

        public Criteria andStartPlanNotEqualTo(Date value) {
            addCriterion("start_plan <>", value, "startPlan");
            return (Criteria) this;
        }

        public Criteria andStartPlanGreaterThan(Date value) {
            addCriterion("start_plan >", value, "startPlan");
            return (Criteria) this;
        }

        public Criteria andStartPlanGreaterThanOrEqualTo(Date value) {
            addCriterion("start_plan >=", value, "startPlan");
            return (Criteria) this;
        }

        public Criteria andStartPlanLessThan(Date value) {
            addCriterion("start_plan <", value, "startPlan");
            return (Criteria) this;
        }

        public Criteria andStartPlanLessThanOrEqualTo(Date value) {
            addCriterion("start_plan <=", value, "startPlan");
            return (Criteria) this;
        }

        public Criteria andStartPlanIn(List<Date> values) {
            addCriterion("start_plan in", values, "startPlan");
            return (Criteria) this;
        }

        public Criteria andStartPlanNotIn(List<Date> values) {
            addCriterion("start_plan not in", values, "startPlan");
            return (Criteria) this;
        }

        public Criteria andStartPlanBetween(Date value1, Date value2) {
            addCriterion("start_plan between", value1, value2, "startPlan");
            return (Criteria) this;
        }

        public Criteria andStartPlanNotBetween(Date value1, Date value2) {
            addCriterion("start_plan not between", value1, value2, "startPlan");
            return (Criteria) this;
        }

        public Criteria andEndPlanIsNull() {
            addCriterion("end_plan is null");
            return (Criteria) this;
        }

        public Criteria andEndPlanIsNotNull() {
            addCriterion("end_plan is not null");
            return (Criteria) this;
        }

        public Criteria andEndPlanEqualTo(Date value) {
            addCriterion("end_plan =", value, "endPlan");
            return (Criteria) this;
        }

        public Criteria andEndPlanNotEqualTo(Date value) {
            addCriterion("end_plan <>", value, "endPlan");
            return (Criteria) this;
        }

        public Criteria andEndPlanGreaterThan(Date value) {
            addCriterion("end_plan >", value, "endPlan");
            return (Criteria) this;
        }

        public Criteria andEndPlanGreaterThanOrEqualTo(Date value) {
            addCriterion("end_plan >=", value, "endPlan");
            return (Criteria) this;
        }

        public Criteria andEndPlanLessThan(Date value) {
            addCriterion("end_plan <", value, "endPlan");
            return (Criteria) this;
        }

        public Criteria andEndPlanLessThanOrEqualTo(Date value) {
            addCriterion("end_plan <=", value, "endPlan");
            return (Criteria) this;
        }

        public Criteria andEndPlanIn(List<Date> values) {
            addCriterion("end_plan in", values, "endPlan");
            return (Criteria) this;
        }

        public Criteria andEndPlanNotIn(List<Date> values) {
            addCriterion("end_plan not in", values, "endPlan");
            return (Criteria) this;
        }

        public Criteria andEndPlanBetween(Date value1, Date value2) {
            addCriterion("end_plan between", value1, value2, "endPlan");
            return (Criteria) this;
        }

        public Criteria andEndPlanNotBetween(Date value1, Date value2) {
            addCriterion("end_plan not between", value1, value2, "endPlan");
            return (Criteria) this;
        }

        public Criteria andCommitPlanIsNull() {
            addCriterion("commit_plan is null");
            return (Criteria) this;
        }

        public Criteria andCommitPlanIsNotNull() {
            addCriterion("commit_plan is not null");
            return (Criteria) this;
        }

        public Criteria andCommitPlanEqualTo(Date value) {
            addCriterion("commit_plan =", value, "commitPlan");
            return (Criteria) this;
        }

        public Criteria andCommitPlanNotEqualTo(Date value) {
            addCriterion("commit_plan <>", value, "commitPlan");
            return (Criteria) this;
        }

        public Criteria andCommitPlanGreaterThan(Date value) {
            addCriterion("commit_plan >", value, "commitPlan");
            return (Criteria) this;
        }

        public Criteria andCommitPlanGreaterThanOrEqualTo(Date value) {
            addCriterion("commit_plan >=", value, "commitPlan");
            return (Criteria) this;
        }

        public Criteria andCommitPlanLessThan(Date value) {
            addCriterion("commit_plan <", value, "commitPlan");
            return (Criteria) this;
        }

        public Criteria andCommitPlanLessThanOrEqualTo(Date value) {
            addCriterion("commit_plan <=", value, "commitPlan");
            return (Criteria) this;
        }

        public Criteria andCommitPlanIn(List<Date> values) {
            addCriterion("commit_plan in", values, "commitPlan");
            return (Criteria) this;
        }

        public Criteria andCommitPlanNotIn(List<Date> values) {
            addCriterion("commit_plan not in", values, "commitPlan");
            return (Criteria) this;
        }

        public Criteria andCommitPlanBetween(Date value1, Date value2) {
            addCriterion("commit_plan between", value1, value2, "commitPlan");
            return (Criteria) this;
        }

        public Criteria andCommitPlanNotBetween(Date value1, Date value2) {
            addCriterion("commit_plan not between", value1, value2, "commitPlan");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartIsNull() {
            addCriterion("technology_plan_start is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartIsNotNull() {
            addCriterion("technology_plan_start is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartEqualTo(Date value) {
            addCriterion("technology_plan_start =", value, "technologyPlanStart");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartNotEqualTo(Date value) {
            addCriterion("technology_plan_start <>", value, "technologyPlanStart");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartGreaterThan(Date value) {
            addCriterion("technology_plan_start >", value, "technologyPlanStart");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartGreaterThanOrEqualTo(Date value) {
            addCriterion("technology_plan_start >=", value, "technologyPlanStart");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartLessThan(Date value) {
            addCriterion("technology_plan_start <", value, "technologyPlanStart");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartLessThanOrEqualTo(Date value) {
            addCriterion("technology_plan_start <=", value, "technologyPlanStart");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartIn(List<Date> values) {
            addCriterion("technology_plan_start in", values, "technologyPlanStart");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartNotIn(List<Date> values) {
            addCriterion("technology_plan_start not in", values, "technologyPlanStart");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartBetween(Date value1, Date value2) {
            addCriterion("technology_plan_start between", value1, value2, "technologyPlanStart");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanStartNotBetween(Date value1, Date value2) {
            addCriterion("technology_plan_start not between", value1, value2, "technologyPlanStart");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndIsNull() {
            addCriterion("technology_plan_end is null");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndIsNotNull() {
            addCriterion("technology_plan_end is not null");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndEqualTo(Date value) {
            addCriterion("technology_plan_end =", value, "technologyPlanEnd");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndNotEqualTo(Date value) {
            addCriterion("technology_plan_end <>", value, "technologyPlanEnd");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndGreaterThan(Date value) {
            addCriterion("technology_plan_end >", value, "technologyPlanEnd");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndGreaterThanOrEqualTo(Date value) {
            addCriterion("technology_plan_end >=", value, "technologyPlanEnd");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndLessThan(Date value) {
            addCriterion("technology_plan_end <", value, "technologyPlanEnd");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndLessThanOrEqualTo(Date value) {
            addCriterion("technology_plan_end <=", value, "technologyPlanEnd");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndIn(List<Date> values) {
            addCriterion("technology_plan_end in", values, "technologyPlanEnd");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndNotIn(List<Date> values) {
            addCriterion("technology_plan_end not in", values, "technologyPlanEnd");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndBetween(Date value1, Date value2) {
            addCriterion("technology_plan_end between", value1, value2, "technologyPlanEnd");
            return (Criteria) this;
        }

        public Criteria andTechnologyPlanEndNotBetween(Date value1, Date value2) {
            addCriterion("technology_plan_end not between", value1, value2, "technologyPlanEnd");
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