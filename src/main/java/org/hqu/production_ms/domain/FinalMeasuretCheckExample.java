package org.hqu.production_ms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinalMeasuretCheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinalMeasuretCheckExample() {
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

        public Criteria andFMeasureCheckIdIsNull() {
            addCriterion("f_measure_check_id is null");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdIsNotNull() {
            addCriterion("f_measure_check_id is not null");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdEqualTo(String value) {
            addCriterion("f_measure_check_id =", value, "fMeasureCheckId");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdNotEqualTo(String value) {
            addCriterion("f_measure_check_id <>", value, "fMeasureCheckId");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdGreaterThan(String value) {
            addCriterion("f_measure_check_id >", value, "fMeasureCheckId");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_measure_check_id >=", value, "fMeasureCheckId");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdLessThan(String value) {
            addCriterion("f_measure_check_id <", value, "fMeasureCheckId");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdLessThanOrEqualTo(String value) {
            addCriterion("f_measure_check_id <=", value, "fMeasureCheckId");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdLike(String value) {
            addCriterion("f_measure_check_id like", value, "fMeasureCheckId");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdNotLike(String value) {
            addCriterion("f_measure_check_id not like", value, "fMeasureCheckId");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdIn(List<String> values) {
            addCriterion("f_measure_check_id in", values, "fMeasureCheckId");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdNotIn(List<String> values) {
            addCriterion("f_measure_check_id not in", values, "fMeasureCheckId");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdBetween(String value1, String value2) {
            addCriterion("f_measure_check_id between", value1, value2, "fMeasureCheckId");
            return (Criteria) this;
        }

        public Criteria andFMeasureCheckIdNotBetween(String value1, String value2) {
            addCriterion("f_measure_check_id not between", value1, value2, "fMeasureCheckId");
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

        public Criteria andCheckItemIsNull() {
            addCriterion("check_item is null");
            return (Criteria) this;
        }

        public Criteria andCheckItemIsNotNull() {
            addCriterion("check_item is not null");
            return (Criteria) this;
        }

        public Criteria andCheckItemEqualTo(String value) {
            addCriterion("check_item =", value, "checkItem");
            return (Criteria) this;
        }

        public Criteria andCheckItemNotEqualTo(String value) {
            addCriterion("check_item <>", value, "checkItem");
            return (Criteria) this;
        }

        public Criteria andCheckItemGreaterThan(String value) {
            addCriterion("check_item >", value, "checkItem");
            return (Criteria) this;
        }

        public Criteria andCheckItemGreaterThanOrEqualTo(String value) {
            addCriterion("check_item >=", value, "checkItem");
            return (Criteria) this;
        }

        public Criteria andCheckItemLessThan(String value) {
            addCriterion("check_item <", value, "checkItem");
            return (Criteria) this;
        }

        public Criteria andCheckItemLessThanOrEqualTo(String value) {
            addCriterion("check_item <=", value, "checkItem");
            return (Criteria) this;
        }

        public Criteria andCheckItemLike(String value) {
            addCriterion("check_item like", value, "checkItem");
            return (Criteria) this;
        }

        public Criteria andCheckItemNotLike(String value) {
            addCriterion("check_item not like", value, "checkItem");
            return (Criteria) this;
        }

        public Criteria andCheckItemIn(List<String> values) {
            addCriterion("check_item in", values, "checkItem");
            return (Criteria) this;
        }

        public Criteria andCheckItemNotIn(List<String> values) {
            addCriterion("check_item not in", values, "checkItem");
            return (Criteria) this;
        }

        public Criteria andCheckItemBetween(String value1, String value2) {
            addCriterion("check_item between", value1, value2, "checkItem");
            return (Criteria) this;
        }

        public Criteria andCheckItemNotBetween(String value1, String value2) {
            addCriterion("check_item not between", value1, value2, "checkItem");
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

        public Criteria andMeasureDataIsNull() {
            addCriterion("measure_data is null");
            return (Criteria) this;
        }

        public Criteria andMeasureDataIsNotNull() {
            addCriterion("measure_data is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureDataEqualTo(String value) {
            addCriterion("measure_data =", value, "measureData");
            return (Criteria) this;
        }

        public Criteria andMeasureDataNotEqualTo(String value) {
            addCriterion("measure_data <>", value, "measureData");
            return (Criteria) this;
        }

        public Criteria andMeasureDataGreaterThan(String value) {
            addCriterion("measure_data >", value, "measureData");
            return (Criteria) this;
        }

        public Criteria andMeasureDataGreaterThanOrEqualTo(String value) {
            addCriterion("measure_data >=", value, "measureData");
            return (Criteria) this;
        }

        public Criteria andMeasureDataLessThan(String value) {
            addCriterion("measure_data <", value, "measureData");
            return (Criteria) this;
        }

        public Criteria andMeasureDataLessThanOrEqualTo(String value) {
            addCriterion("measure_data <=", value, "measureData");
            return (Criteria) this;
        }

        public Criteria andMeasureDataLike(String value) {
            addCriterion("measure_data like", value, "measureData");
            return (Criteria) this;
        }

        public Criteria andMeasureDataNotLike(String value) {
            addCriterion("measure_data not like", value, "measureData");
            return (Criteria) this;
        }

        public Criteria andMeasureDataIn(List<String> values) {
            addCriterion("measure_data in", values, "measureData");
            return (Criteria) this;
        }

        public Criteria andMeasureDataNotIn(List<String> values) {
            addCriterion("measure_data not in", values, "measureData");
            return (Criteria) this;
        }

        public Criteria andMeasureDataBetween(String value1, String value2) {
            addCriterion("measure_data between", value1, value2, "measureData");
            return (Criteria) this;
        }

        public Criteria andMeasureDataNotBetween(String value1, String value2) {
            addCriterion("measure_data not between", value1, value2, "measureData");
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

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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