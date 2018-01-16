package com.megagao.production.ssm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UnqualifyApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UnqualifyApplyExample() {
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

        public Criteria andUnqualifyApplyIdIsNull() {
            addCriterion("unqualify_apply_id is null");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdIsNotNull() {
            addCriterion("unqualify_apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdEqualTo(String value) {
            addCriterion("unqualify_apply_id =", value, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdNotEqualTo(String value) {
            addCriterion("unqualify_apply_id <>", value, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdGreaterThan(String value) {
            addCriterion("unqualify_apply_id >", value, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("unqualify_apply_id >=", value, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdLessThan(String value) {
            addCriterion("unqualify_apply_id <", value, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdLessThanOrEqualTo(String value) {
            addCriterion("unqualify_apply_id <=", value, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdLike(String value) {
            addCriterion("unqualify_apply_id like", value, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdNotLike(String value) {
            addCriterion("unqualify_apply_id not like", value, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdIn(List<String> values) {
            addCriterion("unqualify_apply_id in", values, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdNotIn(List<String> values) {
            addCriterion("unqualify_apply_id not in", values, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdBetween(String value1, String value2) {
            addCriterion("unqualify_apply_id between", value1, value2, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyApplyIdNotBetween(String value1, String value2) {
            addCriterion("unqualify_apply_id not between", value1, value2, "unqualifyApplyId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemIsNull() {
            addCriterion("unqualify_item is null");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemIsNotNull() {
            addCriterion("unqualify_item is not null");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemEqualTo(String value) {
            addCriterion("unqualify_item =", value, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemNotEqualTo(String value) {
            addCriterion("unqualify_item <>", value, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemGreaterThan(String value) {
            addCriterion("unqualify_item >", value, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemGreaterThanOrEqualTo(String value) {
            addCriterion("unqualify_item >=", value, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemLessThan(String value) {
            addCriterion("unqualify_item <", value, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemLessThanOrEqualTo(String value) {
            addCriterion("unqualify_item <=", value, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemLike(String value) {
            addCriterion("unqualify_item like", value, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemNotLike(String value) {
            addCriterion("unqualify_item not like", value, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemIn(List<String> values) {
            addCriterion("unqualify_item in", values, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemNotIn(List<String> values) {
            addCriterion("unqualify_item not in", values, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemBetween(String value1, String value2) {
            addCriterion("unqualify_item between", value1, value2, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyItemNotBetween(String value1, String value2) {
            addCriterion("unqualify_item not between", value1, value2, "unqualifyItem");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountIsNull() {
            addCriterion("unqualify_count is null");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountIsNotNull() {
            addCriterion("unqualify_count is not null");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountEqualTo(Integer value) {
            addCriterion("unqualify_count =", value, "unqualifyCount");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountNotEqualTo(Integer value) {
            addCriterion("unqualify_count <>", value, "unqualifyCount");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountGreaterThan(Integer value) {
            addCriterion("unqualify_count >", value, "unqualifyCount");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("unqualify_count >=", value, "unqualifyCount");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountLessThan(Integer value) {
            addCriterion("unqualify_count <", value, "unqualifyCount");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountLessThanOrEqualTo(Integer value) {
            addCriterion("unqualify_count <=", value, "unqualifyCount");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountIn(List<Integer> values) {
            addCriterion("unqualify_count in", values, "unqualifyCount");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountNotIn(List<Integer> values) {
            addCriterion("unqualify_count not in", values, "unqualifyCount");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountBetween(Integer value1, Integer value2) {
            addCriterion("unqualify_count between", value1, value2, "unqualifyCount");
            return (Criteria) this;
        }

        public Criteria andUnqualifyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("unqualify_count not between", value1, value2, "unqualifyCount");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateIsNull() {
            addCriterion("assembly_date is null");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateIsNotNull() {
            addCriterion("assembly_date is not null");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateEqualTo(Date value) {
            addCriterion("assembly_date =", value, "assemblyDate");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateNotEqualTo(Date value) {
            addCriterion("assembly_date <>", value, "assemblyDate");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateGreaterThan(Date value) {
            addCriterion("assembly_date >", value, "assemblyDate");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("assembly_date >=", value, "assemblyDate");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateLessThan(Date value) {
            addCriterion("assembly_date <", value, "assemblyDate");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateLessThanOrEqualTo(Date value) {
            addCriterion("assembly_date <=", value, "assemblyDate");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateIn(List<Date> values) {
            addCriterion("assembly_date in", values, "assemblyDate");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateNotIn(List<Date> values) {
            addCriterion("assembly_date not in", values, "assemblyDate");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateBetween(Date value1, Date value2) {
            addCriterion("assembly_date between", value1, value2, "assemblyDate");
            return (Criteria) this;
        }

        public Criteria andAssemblyDateNotBetween(Date value1, Date value2) {
            addCriterion("assembly_date not between", value1, value2, "assemblyDate");
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

        public Criteria andApplyDateIsNull() {
            addCriterion("apply_date is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(Date value) {
            addCriterion("apply_date =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(Date value) {
            addCriterion("apply_date <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(Date value) {
            addCriterion("apply_date >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_date >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(Date value) {
            addCriterion("apply_date <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("apply_date <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<Date> values) {
            addCriterion("apply_date in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<Date> values) {
            addCriterion("apply_date not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(Date value1, Date value2) {
            addCriterion("apply_date between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("apply_date not between", value1, value2, "applyDate");
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