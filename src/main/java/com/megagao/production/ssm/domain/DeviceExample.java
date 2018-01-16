package com.megagao.production.ssm.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(String value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(String value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(String value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(String value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLike(String value) {
            addCriterion("device_id like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotLike(String value) {
            addCriterion("device_id not like", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<String> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<String> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(String value1, String value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(String value1, String value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdIsNull() {
            addCriterion("device_type_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdIsNotNull() {
            addCriterion("device_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdEqualTo(String value) {
            addCriterion("device_type_id =", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotEqualTo(String value) {
            addCriterion("device_type_id <>", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdGreaterThan(String value) {
            addCriterion("device_type_id >", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_type_id >=", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdLessThan(String value) {
            addCriterion("device_type_id <", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdLessThanOrEqualTo(String value) {
            addCriterion("device_type_id <=", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdLike(String value) {
            addCriterion("device_type_id like", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotLike(String value) {
            addCriterion("device_type_id not like", value, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdIn(List<String> values) {
            addCriterion("device_type_id in", values, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotIn(List<String> values) {
            addCriterion("device_type_id not in", values, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdBetween(String value1, String value2) {
            addCriterion("device_type_id between", value1, value2, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeIdNotBetween(String value1, String value2) {
            addCriterion("device_type_id not between", value1, value2, "deviceTypeId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdIsNull() {
            addCriterion("device_status_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdIsNotNull() {
            addCriterion("device_status_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdEqualTo(String value) {
            addCriterion("device_status_id =", value, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdNotEqualTo(String value) {
            addCriterion("device_status_id <>", value, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdGreaterThan(String value) {
            addCriterion("device_status_id >", value, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_status_id >=", value, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdLessThan(String value) {
            addCriterion("device_status_id <", value, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdLessThanOrEqualTo(String value) {
            addCriterion("device_status_id <=", value, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdLike(String value) {
            addCriterion("device_status_id like", value, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdNotLike(String value) {
            addCriterion("device_status_id not like", value, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdIn(List<String> values) {
            addCriterion("device_status_id in", values, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdNotIn(List<String> values) {
            addCriterion("device_status_id not in", values, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdBetween(String value1, String value2) {
            addCriterion("device_status_id between", value1, value2, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIdNotBetween(String value1, String value2) {
            addCriterion("device_status_id not between", value1, value2, "deviceStatusId");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNull() {
            addCriterion("device_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNotNull() {
            addCriterion("device_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusEqualTo(String value) {
            addCriterion("device_status =", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotEqualTo(String value) {
            addCriterion("device_status <>", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThan(String value) {
            addCriterion("device_status >", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("device_status >=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThan(String value) {
            addCriterion("device_status <", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThanOrEqualTo(String value) {
            addCriterion("device_status <=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLike(String value) {
            addCriterion("device_status like", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotLike(String value) {
            addCriterion("device_status not like", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIn(List<String> values) {
            addCriterion("device_status in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotIn(List<String> values) {
            addCriterion("device_status not in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusBetween(String value1, String value2) {
            addCriterion("device_status between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotBetween(String value1, String value2) {
            addCriterion("device_status not between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateIsNull() {
            addCriterion("device_purchase_date is null");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateIsNotNull() {
            addCriterion("device_purchase_date is not null");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateEqualTo(Date value) {
            addCriterion("device_purchase_date =", value, "devicePurchaseDate");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateNotEqualTo(Date value) {
            addCriterion("device_purchase_date <>", value, "devicePurchaseDate");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateGreaterThan(Date value) {
            addCriterion("device_purchase_date >", value, "devicePurchaseDate");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("device_purchase_date >=", value, "devicePurchaseDate");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateLessThan(Date value) {
            addCriterion("device_purchase_date <", value, "devicePurchaseDate");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateLessThanOrEqualTo(Date value) {
            addCriterion("device_purchase_date <=", value, "devicePurchaseDate");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateIn(List<Date> values) {
            addCriterion("device_purchase_date in", values, "devicePurchaseDate");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateNotIn(List<Date> values) {
            addCriterion("device_purchase_date not in", values, "devicePurchaseDate");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateBetween(Date value1, Date value2) {
            addCriterion("device_purchase_date between", value1, value2, "devicePurchaseDate");
            return (Criteria) this;
        }

        public Criteria andDevicePurchaseDateNotBetween(Date value1, Date value2) {
            addCriterion("device_purchase_date not between", value1, value2, "devicePurchaseDate");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceIsNull() {
            addCriterion("device_purchase_price is null");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceIsNotNull() {
            addCriterion("device_purchase_price is not null");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceEqualTo(BigDecimal value) {
            addCriterion("device_purchase_price =", value, "devicePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceNotEqualTo(BigDecimal value) {
            addCriterion("device_purchase_price <>", value, "devicePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceGreaterThan(BigDecimal value) {
            addCriterion("device_purchase_price >", value, "devicePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("device_purchase_price >=", value, "devicePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceLessThan(BigDecimal value) {
            addCriterion("device_purchase_price <", value, "devicePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("device_purchase_price <=", value, "devicePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceIn(List<BigDecimal> values) {
            addCriterion("device_purchase_price in", values, "devicePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceNotIn(List<BigDecimal> values) {
            addCriterion("device_purchase_price not in", values, "devicePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("device_purchase_price between", value1, value2, "devicePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andDevicePurchasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("device_purchase_price not between", value1, value2, "devicePurchasePrice");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateIsNull() {
            addCriterion("device_manufacture_date is null");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateIsNotNull() {
            addCriterion("device_manufacture_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateEqualTo(Date value) {
            addCriterion("device_manufacture_date =", value, "deviceManufactureDate");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateNotEqualTo(Date value) {
            addCriterion("device_manufacture_date <>", value, "deviceManufactureDate");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateGreaterThan(Date value) {
            addCriterion("device_manufacture_date >", value, "deviceManufactureDate");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateGreaterThanOrEqualTo(Date value) {
            addCriterion("device_manufacture_date >=", value, "deviceManufactureDate");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateLessThan(Date value) {
            addCriterion("device_manufacture_date <", value, "deviceManufactureDate");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateLessThanOrEqualTo(Date value) {
            addCriterion("device_manufacture_date <=", value, "deviceManufactureDate");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateIn(List<Date> values) {
            addCriterion("device_manufacture_date in", values, "deviceManufactureDate");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateNotIn(List<Date> values) {
            addCriterion("device_manufacture_date not in", values, "deviceManufactureDate");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateBetween(Date value1, Date value2) {
            addCriterion("device_manufacture_date between", value1, value2, "deviceManufactureDate");
            return (Criteria) this;
        }

        public Criteria andDeviceManufactureDateNotBetween(Date value1, Date value2) {
            addCriterion("device_manufacture_date not between", value1, value2, "deviceManufactureDate");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeIsNull() {
            addCriterion("device_service_life is null");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeIsNotNull() {
            addCriterion("device_service_life is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeEqualTo(Date value) {
            addCriterion("device_service_life =", value, "deviceServiceLife");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeNotEqualTo(Date value) {
            addCriterion("device_service_life <>", value, "deviceServiceLife");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeGreaterThan(Date value) {
            addCriterion("device_service_life >", value, "deviceServiceLife");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeGreaterThanOrEqualTo(Date value) {
            addCriterion("device_service_life >=", value, "deviceServiceLife");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeLessThan(Date value) {
            addCriterion("device_service_life <", value, "deviceServiceLife");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeLessThanOrEqualTo(Date value) {
            addCriterion("device_service_life <=", value, "deviceServiceLife");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeIn(List<Date> values) {
            addCriterion("device_service_life in", values, "deviceServiceLife");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeNotIn(List<Date> values) {
            addCriterion("device_service_life not in", values, "deviceServiceLife");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeBetween(Date value1, Date value2) {
            addCriterion("device_service_life between", value1, value2, "deviceServiceLife");
            return (Criteria) this;
        }

        public Criteria andDeviceServiceLifeNotBetween(Date value1, Date value2) {
            addCriterion("device_service_life not between", value1, value2, "deviceServiceLife");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdIsNull() {
            addCriterion("device_keeper_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdIsNotNull() {
            addCriterion("device_keeper_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdEqualTo(String value) {
            addCriterion("device_keeper_id =", value, "deviceKeeperId");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdNotEqualTo(String value) {
            addCriterion("device_keeper_id <>", value, "deviceKeeperId");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdGreaterThan(String value) {
            addCriterion("device_keeper_id >", value, "deviceKeeperId");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_keeper_id >=", value, "deviceKeeperId");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdLessThan(String value) {
            addCriterion("device_keeper_id <", value, "deviceKeeperId");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdLessThanOrEqualTo(String value) {
            addCriterion("device_keeper_id <=", value, "deviceKeeperId");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdLike(String value) {
            addCriterion("device_keeper_id like", value, "deviceKeeperId");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdNotLike(String value) {
            addCriterion("device_keeper_id not like", value, "deviceKeeperId");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdIn(List<String> values) {
            addCriterion("device_keeper_id in", values, "deviceKeeperId");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdNotIn(List<String> values) {
            addCriterion("device_keeper_id not in", values, "deviceKeeperId");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdBetween(String value1, String value2) {
            addCriterion("device_keeper_id between", value1, value2, "deviceKeeperId");
            return (Criteria) this;
        }

        public Criteria andDeviceKeeperIdNotBetween(String value1, String value2) {
            addCriterion("device_keeper_id not between", value1, value2, "deviceKeeperId");
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