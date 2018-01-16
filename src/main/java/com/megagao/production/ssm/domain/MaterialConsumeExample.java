package com.megagao.production.ssm.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaterialConsumeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialConsumeExample() {
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

        public Criteria andConsumeIdIsNull() {
            addCriterion("consume_id is null");
            return (Criteria) this;
        }

        public Criteria andConsumeIdIsNotNull() {
            addCriterion("consume_id is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeIdEqualTo(String value) {
            addCriterion("consume_id =", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdNotEqualTo(String value) {
            addCriterion("consume_id <>", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdGreaterThan(String value) {
            addCriterion("consume_id >", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdGreaterThanOrEqualTo(String value) {
            addCriterion("consume_id >=", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdLessThan(String value) {
            addCriterion("consume_id <", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdLessThanOrEqualTo(String value) {
            addCriterion("consume_id <=", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdLike(String value) {
            addCriterion("consume_id like", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdNotLike(String value) {
            addCriterion("consume_id not like", value, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdIn(List<String> values) {
            addCriterion("consume_id in", values, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdNotIn(List<String> values) {
            addCriterion("consume_id not in", values, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdBetween(String value1, String value2) {
            addCriterion("consume_id between", value1, value2, "consumeId");
            return (Criteria) this;
        }

        public Criteria andConsumeIdNotBetween(String value1, String value2) {
            addCriterion("consume_id not between", value1, value2, "consumeId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(String value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(String value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(String value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(String value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(String value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLike(String value) {
            addCriterion("material_id like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotLike(String value) {
            addCriterion("material_id not like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<String> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<String> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(String value1, String value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(String value1, String value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountIsNull() {
            addCriterion("consume_amount is null");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountIsNotNull() {
            addCriterion("consume_amount is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountEqualTo(Integer value) {
            addCriterion("consume_amount =", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotEqualTo(Integer value) {
            addCriterion("consume_amount <>", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountGreaterThan(Integer value) {
            addCriterion("consume_amount >", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("consume_amount >=", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountLessThan(Integer value) {
            addCriterion("consume_amount <", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountLessThanOrEqualTo(Integer value) {
            addCriterion("consume_amount <=", value, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountIn(List<Integer> values) {
            addCriterion("consume_amount in", values, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotIn(List<Integer> values) {
            addCriterion("consume_amount not in", values, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountBetween(Integer value1, Integer value2) {
            addCriterion("consume_amount between", value1, value2, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("consume_amount not between", value1, value2, "consumeAmount");
            return (Criteria) this;
        }

        public Criteria andConsumeDateIsNull() {
            addCriterion("consume_date is null");
            return (Criteria) this;
        }

        public Criteria andConsumeDateIsNotNull() {
            addCriterion("consume_date is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeDateEqualTo(Date value) {
            addCriterion("consume_date =", value, "consumeDate");
            return (Criteria) this;
        }

        public Criteria andConsumeDateNotEqualTo(Date value) {
            addCriterion("consume_date <>", value, "consumeDate");
            return (Criteria) this;
        }

        public Criteria andConsumeDateGreaterThan(Date value) {
            addCriterion("consume_date >", value, "consumeDate");
            return (Criteria) this;
        }

        public Criteria andConsumeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("consume_date >=", value, "consumeDate");
            return (Criteria) this;
        }

        public Criteria andConsumeDateLessThan(Date value) {
            addCriterion("consume_date <", value, "consumeDate");
            return (Criteria) this;
        }

        public Criteria andConsumeDateLessThanOrEqualTo(Date value) {
            addCriterion("consume_date <=", value, "consumeDate");
            return (Criteria) this;
        }

        public Criteria andConsumeDateIn(List<Date> values) {
            addCriterion("consume_date in", values, "consumeDate");
            return (Criteria) this;
        }

        public Criteria andConsumeDateNotIn(List<Date> values) {
            addCriterion("consume_date not in", values, "consumeDate");
            return (Criteria) this;
        }

        public Criteria andConsumeDateBetween(Date value1, Date value2) {
            addCriterion("consume_date between", value1, value2, "consumeDate");
            return (Criteria) this;
        }

        public Criteria andConsumeDateNotBetween(Date value1, Date value2) {
            addCriterion("consume_date not between", value1, value2, "consumeDate");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("sender is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("sender is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("sender =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("sender <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("sender >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("sender >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("sender <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("sender <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("sender like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("sender not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("sender in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("sender not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("sender between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("sender not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<String> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
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