package org.hqu.production_ms.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepairExample() {
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

        public Criteria andRepairIdIsNull() {
            addCriterion("repair_id is null");
            return (Criteria) this;
        }

        public Criteria andRepairIdIsNotNull() {
            addCriterion("repair_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepairIdEqualTo(String value) {
            addCriterion("repair_id =", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotEqualTo(String value) {
            addCriterion("repair_id <>", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdGreaterThan(String value) {
            addCriterion("repair_id >", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdGreaterThanOrEqualTo(String value) {
            addCriterion("repair_id >=", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdLessThan(String value) {
            addCriterion("repair_id <", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdLessThanOrEqualTo(String value) {
            addCriterion("repair_id <=", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdLike(String value) {
            addCriterion("repair_id like", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotLike(String value) {
            addCriterion("repair_id not like", value, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdIn(List<String> values) {
            addCriterion("repair_id in", values, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotIn(List<String> values) {
            addCriterion("repair_id not in", values, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdBetween(String value1, String value2) {
            addCriterion("repair_id between", value1, value2, "repairId");
            return (Criteria) this;
        }

        public Criteria andRepairIdNotBetween(String value1, String value2) {
            addCriterion("repair_id not between", value1, value2, "repairId");
            return (Criteria) this;
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

        public Criteria andRepairDateIsNull() {
            addCriterion("repair_date is null");
            return (Criteria) this;
        }

        public Criteria andRepairDateIsNotNull() {
            addCriterion("repair_date is not null");
            return (Criteria) this;
        }

        public Criteria andRepairDateEqualTo(Date value) {
            addCriterion("repair_date =", value, "repairDate");
            return (Criteria) this;
        }

        public Criteria andRepairDateNotEqualTo(Date value) {
            addCriterion("repair_date <>", value, "repairDate");
            return (Criteria) this;
        }

        public Criteria andRepairDateGreaterThan(Date value) {
            addCriterion("repair_date >", value, "repairDate");
            return (Criteria) this;
        }

        public Criteria andRepairDateGreaterThanOrEqualTo(Date value) {
            addCriterion("repair_date >=", value, "repairDate");
            return (Criteria) this;
        }

        public Criteria andRepairDateLessThan(Date value) {
            addCriterion("repair_date <", value, "repairDate");
            return (Criteria) this;
        }

        public Criteria andRepairDateLessThanOrEqualTo(Date value) {
            addCriterion("repair_date <=", value, "repairDate");
            return (Criteria) this;
        }

        public Criteria andRepairDateIn(List<Date> values) {
            addCriterion("repair_date in", values, "repairDate");
            return (Criteria) this;
        }

        public Criteria andRepairDateNotIn(List<Date> values) {
            addCriterion("repair_date not in", values, "repairDate");
            return (Criteria) this;
        }

        public Criteria andRepairDateBetween(Date value1, Date value2) {
            addCriterion("repair_date between", value1, value2, "repairDate");
            return (Criteria) this;
        }

        public Criteria andRepairDateNotBetween(Date value1, Date value2) {
            addCriterion("repair_date not between", value1, value2, "repairDate");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(String value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(String value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(String value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(String value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(String value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(String value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLike(String value) {
            addCriterion("emp_id like", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotLike(String value) {
            addCriterion("emp_id not like", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<String> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<String> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(String value1, String value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(String value1, String value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andRepairCostIsNull() {
            addCriterion("repair_cost is null");
            return (Criteria) this;
        }

        public Criteria andRepairCostIsNotNull() {
            addCriterion("repair_cost is not null");
            return (Criteria) this;
        }

        public Criteria andRepairCostEqualTo(BigDecimal value) {
            addCriterion("repair_cost =", value, "repairCost");
            return (Criteria) this;
        }

        public Criteria andRepairCostNotEqualTo(BigDecimal value) {
            addCriterion("repair_cost <>", value, "repairCost");
            return (Criteria) this;
        }

        public Criteria andRepairCostGreaterThan(BigDecimal value) {
            addCriterion("repair_cost >", value, "repairCost");
            return (Criteria) this;
        }

        public Criteria andRepairCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repair_cost >=", value, "repairCost");
            return (Criteria) this;
        }

        public Criteria andRepairCostLessThan(BigDecimal value) {
            addCriterion("repair_cost <", value, "repairCost");
            return (Criteria) this;
        }

        public Criteria andRepairCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repair_cost <=", value, "repairCost");
            return (Criteria) this;
        }

        public Criteria andRepairCostIn(List<BigDecimal> values) {
            addCriterion("repair_cost in", values, "repairCost");
            return (Criteria) this;
        }

        public Criteria andRepairCostNotIn(List<BigDecimal> values) {
            addCriterion("repair_cost not in", values, "repairCost");
            return (Criteria) this;
        }

        public Criteria andRepairCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repair_cost between", value1, value2, "repairCost");
            return (Criteria) this;
        }

        public Criteria andRepairCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repair_cost not between", value1, value2, "repairCost");
            return (Criteria) this;
        }

        public Criteria andRepairResultIsNull() {
            addCriterion("repair_result is null");
            return (Criteria) this;
        }

        public Criteria andRepairResultIsNotNull() {
            addCriterion("repair_result is not null");
            return (Criteria) this;
        }

        public Criteria andRepairResultEqualTo(String value) {
            addCriterion("repair_result =", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotEqualTo(String value) {
            addCriterion("repair_result <>", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultGreaterThan(String value) {
            addCriterion("repair_result >", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultGreaterThanOrEqualTo(String value) {
            addCriterion("repair_result >=", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultLessThan(String value) {
            addCriterion("repair_result <", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultLessThanOrEqualTo(String value) {
            addCriterion("repair_result <=", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultLike(String value) {
            addCriterion("repair_result like", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotLike(String value) {
            addCriterion("repair_result not like", value, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultIn(List<String> values) {
            addCriterion("repair_result in", values, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotIn(List<String> values) {
            addCriterion("repair_result not in", values, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultBetween(String value1, String value2) {
            addCriterion("repair_result between", value1, value2, "repairResult");
            return (Criteria) this;
        }

        public Criteria andRepairResultNotBetween(String value1, String value2) {
            addCriterion("repair_result not between", value1, value2, "repairResult");
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