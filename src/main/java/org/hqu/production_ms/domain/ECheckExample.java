package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ECheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ECheckExample() {
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

        public Criteria andCheckIdIsNull() {
            addCriterion("check_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckIdIsNotNull() {
            addCriterion("check_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckIdEqualTo(String value) {
            addCriterion("check_id =", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotEqualTo(String value) {
            addCriterion("check_id <>", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThan(String value) {
            addCriterion("check_id >", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdGreaterThanOrEqualTo(String value) {
            addCriterion("check_id >=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThan(String value) {
            addCriterion("check_id <", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLessThanOrEqualTo(String value) {
            addCriterion("check_id <=", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdLike(String value) {
            addCriterion("check_id like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotLike(String value) {
            addCriterion("check_id not like", value, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdIn(List<String> values) {
            addCriterion("check_id in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotIn(List<String> values) {
            addCriterion("check_id not in", values, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdBetween(String value1, String value2) {
            addCriterion("check_id between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andCheckIdNotBetween(String value1, String value2) {
            addCriterion("check_id not between", value1, value2, "checkId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdIsNull() {
            addCriterion("equitment_id is null");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdIsNotNull() {
            addCriterion("equitment_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdEqualTo(String value) {
            addCriterion("equitment_id =", value, "equitmentId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdNotEqualTo(String value) {
            addCriterion("equitment_id <>", value, "equitmentId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdGreaterThan(String value) {
            addCriterion("equitment_id >", value, "equitmentId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("equitment_id >=", value, "equitmentId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdLessThan(String value) {
            addCriterion("equitment_id <", value, "equitmentId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdLessThanOrEqualTo(String value) {
            addCriterion("equitment_id <=", value, "equitmentId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdLike(String value) {
            addCriterion("equitment_id like", value, "equitmentId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdNotLike(String value) {
            addCriterion("equitment_id not like", value, "equitmentId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdIn(List<String> values) {
            addCriterion("equitment_id in", values, "equitmentId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdNotIn(List<String> values) {
            addCriterion("equitment_id not in", values, "equitmentId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdBetween(String value1, String value2) {
            addCriterion("equitment_id between", value1, value2, "equitmentId");
            return (Criteria) this;
        }

        public Criteria andEquitmentIdNotBetween(String value1, String value2) {
            addCriterion("equitment_id not between", value1, value2, "equitmentId");
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

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdIsNull() {
            addCriterion("equipment_failure_id is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdIsNotNull() {
            addCriterion("equipment_failure_id is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdEqualTo(String value) {
            addCriterion("equipment_failure_id =", value, "equipmentFailureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdNotEqualTo(String value) {
            addCriterion("equipment_failure_id <>", value, "equipmentFailureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdGreaterThan(String value) {
            addCriterion("equipment_failure_id >", value, "equipmentFailureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_failure_id >=", value, "equipmentFailureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdLessThan(String value) {
            addCriterion("equipment_failure_id <", value, "equipmentFailureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdLessThanOrEqualTo(String value) {
            addCriterion("equipment_failure_id <=", value, "equipmentFailureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdLike(String value) {
            addCriterion("equipment_failure_id like", value, "equipmentFailureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdNotLike(String value) {
            addCriterion("equipment_failure_id not like", value, "equipmentFailureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdIn(List<String> values) {
            addCriterion("equipment_failure_id in", values, "equipmentFailureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdNotIn(List<String> values) {
            addCriterion("equipment_failure_id not in", values, "equipmentFailureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdBetween(String value1, String value2) {
            addCriterion("equipment_failure_id between", value1, value2, "equipmentFailureId");
            return (Criteria) this;
        }

        public Criteria andEquipmentFailureIdNotBetween(String value1, String value2) {
            addCriterion("equipment_failure_id not between", value1, value2, "equipmentFailureId");
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