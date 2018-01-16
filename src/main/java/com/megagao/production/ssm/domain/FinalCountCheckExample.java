package com.megagao.production.ssm.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FinalCountCheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinalCountCheckExample() {
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

        public Criteria andFCountCheckIdIsNull() {
            addCriterion("f_count_check_id is null");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdIsNotNull() {
            addCriterion("f_count_check_id is not null");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdEqualTo(String value) {
            addCriterion("f_count_check_id =", value, "fCountCheckId");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdNotEqualTo(String value) {
            addCriterion("f_count_check_id <>", value, "fCountCheckId");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdGreaterThan(String value) {
            addCriterion("f_count_check_id >", value, "fCountCheckId");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_count_check_id >=", value, "fCountCheckId");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdLessThan(String value) {
            addCriterion("f_count_check_id <", value, "fCountCheckId");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdLessThanOrEqualTo(String value) {
            addCriterion("f_count_check_id <=", value, "fCountCheckId");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdLike(String value) {
            addCriterion("f_count_check_id like", value, "fCountCheckId");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdNotLike(String value) {
            addCriterion("f_count_check_id not like", value, "fCountCheckId");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdIn(List<String> values) {
            addCriterion("f_count_check_id in", values, "fCountCheckId");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdNotIn(List<String> values) {
            addCriterion("f_count_check_id not in", values, "fCountCheckId");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdBetween(String value1, String value2) {
            addCriterion("f_count_check_id between", value1, value2, "fCountCheckId");
            return (Criteria) this;
        }

        public Criteria andFCountCheckIdNotBetween(String value1, String value2) {
            addCriterion("f_count_check_id not between", value1, value2, "fCountCheckId");
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

        public Criteria andSampleIsNull() {
            addCriterion("sample is null");
            return (Criteria) this;
        }

        public Criteria andSampleIsNotNull() {
            addCriterion("sample is not null");
            return (Criteria) this;
        }

        public Criteria andSampleEqualTo(Integer value) {
            addCriterion("sample =", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleNotEqualTo(Integer value) {
            addCriterion("sample <>", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleGreaterThan(Integer value) {
            addCriterion("sample >", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleGreaterThanOrEqualTo(Integer value) {
            addCriterion("sample >=", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleLessThan(Integer value) {
            addCriterion("sample <", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleLessThanOrEqualTo(Integer value) {
            addCriterion("sample <=", value, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleIn(List<Integer> values) {
            addCriterion("sample in", values, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleNotIn(List<Integer> values) {
            addCriterion("sample not in", values, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleBetween(Integer value1, Integer value2) {
            addCriterion("sample between", value1, value2, "sample");
            return (Criteria) this;
        }

        public Criteria andSampleNotBetween(Integer value1, Integer value2) {
            addCriterion("sample not between", value1, value2, "sample");
            return (Criteria) this;
        }

        public Criteria andCheckNumberIsNull() {
            addCriterion("check_number is null");
            return (Criteria) this;
        }

        public Criteria andCheckNumberIsNotNull() {
            addCriterion("check_number is not null");
            return (Criteria) this;
        }

        public Criteria andCheckNumberEqualTo(Integer value) {
            addCriterion("check_number =", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberNotEqualTo(Integer value) {
            addCriterion("check_number <>", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberGreaterThan(Integer value) {
            addCriterion("check_number >", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_number >=", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberLessThan(Integer value) {
            addCriterion("check_number <", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberLessThanOrEqualTo(Integer value) {
            addCriterion("check_number <=", value, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberIn(List<Integer> values) {
            addCriterion("check_number in", values, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberNotIn(List<Integer> values) {
            addCriterion("check_number not in", values, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberBetween(Integer value1, Integer value2) {
            addCriterion("check_number between", value1, value2, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andCheckNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("check_number not between", value1, value2, "checkNumber");
            return (Criteria) this;
        }

        public Criteria andUnqualifyIsNull() {
            addCriterion("unqualify is null");
            return (Criteria) this;
        }

        public Criteria andUnqualifyIsNotNull() {
            addCriterion("unqualify is not null");
            return (Criteria) this;
        }

        public Criteria andUnqualifyEqualTo(Integer value) {
            addCriterion("unqualify =", value, "unqualify");
            return (Criteria) this;
        }

        public Criteria andUnqualifyNotEqualTo(Integer value) {
            addCriterion("unqualify <>", value, "unqualify");
            return (Criteria) this;
        }

        public Criteria andUnqualifyGreaterThan(Integer value) {
            addCriterion("unqualify >", value, "unqualify");
            return (Criteria) this;
        }

        public Criteria andUnqualifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("unqualify >=", value, "unqualify");
            return (Criteria) this;
        }

        public Criteria andUnqualifyLessThan(Integer value) {
            addCriterion("unqualify <", value, "unqualify");
            return (Criteria) this;
        }

        public Criteria andUnqualifyLessThanOrEqualTo(Integer value) {
            addCriterion("unqualify <=", value, "unqualify");
            return (Criteria) this;
        }

        public Criteria andUnqualifyIn(List<Integer> values) {
            addCriterion("unqualify in", values, "unqualify");
            return (Criteria) this;
        }

        public Criteria andUnqualifyNotIn(List<Integer> values) {
            addCriterion("unqualify not in", values, "unqualify");
            return (Criteria) this;
        }

        public Criteria andUnqualifyBetween(Integer value1, Integer value2) {
            addCriterion("unqualify between", value1, value2, "unqualify");
            return (Criteria) this;
        }

        public Criteria andUnqualifyNotBetween(Integer value1, Integer value2) {
            addCriterion("unqualify not between", value1, value2, "unqualify");
            return (Criteria) this;
        }

        public Criteria andQualifyIsNull() {
            addCriterion("qualify is null");
            return (Criteria) this;
        }

        public Criteria andQualifyIsNotNull() {
            addCriterion("qualify is not null");
            return (Criteria) this;
        }

        public Criteria andQualifyEqualTo(BigDecimal value) {
            addCriterion("qualify =", value, "qualify");
            return (Criteria) this;
        }

        public Criteria andQualifyNotEqualTo(BigDecimal value) {
            addCriterion("qualify <>", value, "qualify");
            return (Criteria) this;
        }

        public Criteria andQualifyGreaterThan(BigDecimal value) {
            addCriterion("qualify >", value, "qualify");
            return (Criteria) this;
        }

        public Criteria andQualifyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("qualify >=", value, "qualify");
            return (Criteria) this;
        }

        public Criteria andQualifyLessThan(BigDecimal value) {
            addCriterion("qualify <", value, "qualify");
            return (Criteria) this;
        }

        public Criteria andQualifyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("qualify <=", value, "qualify");
            return (Criteria) this;
        }

        public Criteria andQualifyIn(List<BigDecimal> values) {
            addCriterion("qualify in", values, "qualify");
            return (Criteria) this;
        }

        public Criteria andQualifyNotIn(List<BigDecimal> values) {
            addCriterion("qualify not in", values, "qualify");
            return (Criteria) this;
        }

        public Criteria andQualifyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qualify between", value1, value2, "qualify");
            return (Criteria) this;
        }

        public Criteria andQualifyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("qualify not between", value1, value2, "qualify");
            return (Criteria) this;
        }

        public Criteria andCdateIsNull() {
            addCriterion("cdate is null");
            return (Criteria) this;
        }

        public Criteria andCdateIsNotNull() {
            addCriterion("cdate is not null");
            return (Criteria) this;
        }

        public Criteria andCdateEqualTo(Date value) {
            addCriterion("cdate =", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateNotEqualTo(Date value) {
            addCriterion("cdate <>", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateGreaterThan(Date value) {
            addCriterion("cdate >", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateGreaterThanOrEqualTo(Date value) {
            addCriterion("cdate >=", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateLessThan(Date value) {
            addCriterion("cdate <", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateLessThanOrEqualTo(Date value) {
            addCriterion("cdate <=", value, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateIn(List<Date> values) {
            addCriterion("cdate in", values, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateNotIn(List<Date> values) {
            addCriterion("cdate not in", values, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateBetween(Date value1, Date value2) {
            addCriterion("cdate between", value1, value2, "cdate");
            return (Criteria) this;
        }

        public Criteria andCdateNotBetween(Date value1, Date value2) {
            addCriterion("cdate not between", value1, value2, "cdate");
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