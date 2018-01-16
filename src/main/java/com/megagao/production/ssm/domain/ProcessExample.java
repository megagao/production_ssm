package com.megagao.production.ssm.domain;

import java.util.ArrayList;
import java.util.List;

public class ProcessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcessExample() {
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

        public Criteria andProcessIdIsNull() {
            addCriterion("process_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("process_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(String value) {
            addCriterion("process_id =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(String value) {
            addCriterion("process_id <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(String value) {
            addCriterion("process_id >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_id >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(String value) {
            addCriterion("process_id <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(String value) {
            addCriterion("process_id <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLike(String value) {
            addCriterion("process_id like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotLike(String value) {
            addCriterion("process_id not like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<String> values) {
            addCriterion("process_id in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<String> values) {
            addCriterion("process_id not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(String value1, String value2) {
            addCriterion("process_id between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(String value1, String value2) {
            addCriterion("process_id not between", value1, value2, "processId");
            return (Criteria) this;
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

        public Criteria andSequenceIsNull() {
            addCriterion("sequence is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("sequence is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(Integer value) {
            addCriterion("sequence =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(Integer value) {
            addCriterion("sequence <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(Integer value) {
            addCriterion("sequence >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(Integer value) {
            addCriterion("sequence <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("sequence <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<Integer> values) {
            addCriterion("sequence in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<Integer> values) {
            addCriterion("sequence not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(Integer value1, Integer value2) {
            addCriterion("sequence between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence not between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andQuotaIsNull() {
            addCriterion("quota is null");
            return (Criteria) this;
        }

        public Criteria andQuotaIsNotNull() {
            addCriterion("quota is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaEqualTo(Integer value) {
            addCriterion("quota =", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotEqualTo(Integer value) {
            addCriterion("quota <>", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaGreaterThan(Integer value) {
            addCriterion("quota >", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("quota >=", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaLessThan(Integer value) {
            addCriterion("quota <", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("quota <=", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaIn(List<Integer> values) {
            addCriterion("quota in", values, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotIn(List<Integer> values) {
            addCriterion("quota not in", values, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaBetween(Integer value1, Integer value2) {
            addCriterion("quota between", value1, value2, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("quota not between", value1, value2, "quota");
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