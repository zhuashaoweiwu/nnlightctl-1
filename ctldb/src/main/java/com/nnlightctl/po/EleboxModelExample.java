package com.nnlightctl.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EleboxModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EleboxModelExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedIsNull() {
            addCriterion("gmt_updated is null");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedIsNotNull() {
            addCriterion("gmt_updated is not null");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedEqualTo(Date value) {
            addCriterion("gmt_updated =", value, "gmtUpdated");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedNotEqualTo(Date value) {
            addCriterion("gmt_updated <>", value, "gmtUpdated");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedGreaterThan(Date value) {
            addCriterion("gmt_updated >", value, "gmtUpdated");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_updated >=", value, "gmtUpdated");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedLessThan(Date value) {
            addCriterion("gmt_updated <", value, "gmtUpdated");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_updated <=", value, "gmtUpdated");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedIn(List<Date> values) {
            addCriterion("gmt_updated in", values, "gmtUpdated");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedNotIn(List<Date> values) {
            addCriterion("gmt_updated not in", values, "gmtUpdated");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedBetween(Date value1, Date value2) {
            addCriterion("gmt_updated between", value1, value2, "gmtUpdated");
            return (Criteria) this;
        }

        public Criteria andGmtUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_updated not between", value1, value2, "gmtUpdated");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNull() {
            addCriterion("model_code is null");
            return (Criteria) this;
        }

        public Criteria andModelCodeIsNotNull() {
            addCriterion("model_code is not null");
            return (Criteria) this;
        }

        public Criteria andModelCodeEqualTo(String value) {
            addCriterion("model_code =", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotEqualTo(String value) {
            addCriterion("model_code <>", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThan(String value) {
            addCriterion("model_code >", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("model_code >=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThan(String value) {
            addCriterion("model_code <", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLessThanOrEqualTo(String value) {
            addCriterion("model_code <=", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeLike(String value) {
            addCriterion("model_code like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotLike(String value) {
            addCriterion("model_code not like", value, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeIn(List<String> values) {
            addCriterion("model_code in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotIn(List<String> values) {
            addCriterion("model_code not in", values, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeBetween(String value1, String value2) {
            addCriterion("model_code between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelCodeNotBetween(String value1, String value2) {
            addCriterion("model_code not between", value1, value2, "modelCode");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("model_name is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("model_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("model_name =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("model_name <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("model_name >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_name >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("model_name <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("model_name <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("model_name like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("model_name not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("model_name in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("model_name not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("model_name between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("model_name not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andPowerRatingIsNull() {
            addCriterion("power_rating is null");
            return (Criteria) this;
        }

        public Criteria andPowerRatingIsNotNull() {
            addCriterion("power_rating is not null");
            return (Criteria) this;
        }

        public Criteria andPowerRatingEqualTo(BigDecimal value) {
            addCriterion("power_rating =", value, "powerRating");
            return (Criteria) this;
        }

        public Criteria andPowerRatingNotEqualTo(BigDecimal value) {
            addCriterion("power_rating <>", value, "powerRating");
            return (Criteria) this;
        }

        public Criteria andPowerRatingGreaterThan(BigDecimal value) {
            addCriterion("power_rating >", value, "powerRating");
            return (Criteria) this;
        }

        public Criteria andPowerRatingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("power_rating >=", value, "powerRating");
            return (Criteria) this;
        }

        public Criteria andPowerRatingLessThan(BigDecimal value) {
            addCriterion("power_rating <", value, "powerRating");
            return (Criteria) this;
        }

        public Criteria andPowerRatingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("power_rating <=", value, "powerRating");
            return (Criteria) this;
        }

        public Criteria andPowerRatingIn(List<BigDecimal> values) {
            addCriterion("power_rating in", values, "powerRating");
            return (Criteria) this;
        }

        public Criteria andPowerRatingNotIn(List<BigDecimal> values) {
            addCriterion("power_rating not in", values, "powerRating");
            return (Criteria) this;
        }

        public Criteria andPowerRatingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("power_rating between", value1, value2, "powerRating");
            return (Criteria) this;
        }

        public Criteria andPowerRatingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("power_rating not between", value1, value2, "powerRating");
            return (Criteria) this;
        }

        public Criteria andElectricRatingIsNull() {
            addCriterion("electric_rating is null");
            return (Criteria) this;
        }

        public Criteria andElectricRatingIsNotNull() {
            addCriterion("electric_rating is not null");
            return (Criteria) this;
        }

        public Criteria andElectricRatingEqualTo(BigDecimal value) {
            addCriterion("electric_rating =", value, "electricRating");
            return (Criteria) this;
        }

        public Criteria andElectricRatingNotEqualTo(BigDecimal value) {
            addCriterion("electric_rating <>", value, "electricRating");
            return (Criteria) this;
        }

        public Criteria andElectricRatingGreaterThan(BigDecimal value) {
            addCriterion("electric_rating >", value, "electricRating");
            return (Criteria) this;
        }

        public Criteria andElectricRatingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("electric_rating >=", value, "electricRating");
            return (Criteria) this;
        }

        public Criteria andElectricRatingLessThan(BigDecimal value) {
            addCriterion("electric_rating <", value, "electricRating");
            return (Criteria) this;
        }

        public Criteria andElectricRatingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("electric_rating <=", value, "electricRating");
            return (Criteria) this;
        }

        public Criteria andElectricRatingIn(List<BigDecimal> values) {
            addCriterion("electric_rating in", values, "electricRating");
            return (Criteria) this;
        }

        public Criteria andElectricRatingNotIn(List<BigDecimal> values) {
            addCriterion("electric_rating not in", values, "electricRating");
            return (Criteria) this;
        }

        public Criteria andElectricRatingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electric_rating between", value1, value2, "electricRating");
            return (Criteria) this;
        }

        public Criteria andElectricRatingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electric_rating not between", value1, value2, "electricRating");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingIsNull() {
            addCriterion("voltage_rating is null");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingIsNotNull() {
            addCriterion("voltage_rating is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingEqualTo(BigDecimal value) {
            addCriterion("voltage_rating =", value, "voltageRating");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingNotEqualTo(BigDecimal value) {
            addCriterion("voltage_rating <>", value, "voltageRating");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingGreaterThan(BigDecimal value) {
            addCriterion("voltage_rating >", value, "voltageRating");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("voltage_rating >=", value, "voltageRating");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingLessThan(BigDecimal value) {
            addCriterion("voltage_rating <", value, "voltageRating");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("voltage_rating <=", value, "voltageRating");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingIn(List<BigDecimal> values) {
            addCriterion("voltage_rating in", values, "voltageRating");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingNotIn(List<BigDecimal> values) {
            addCriterion("voltage_rating not in", values, "voltageRating");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("voltage_rating between", value1, value2, "voltageRating");
            return (Criteria) this;
        }

        public Criteria andVoltageRatingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("voltage_rating not between", value1, value2, "voltageRating");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeIsNull() {
            addCriterion("air_switch_type is null");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeIsNotNull() {
            addCriterion("air_switch_type is not null");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeEqualTo(String value) {
            addCriterion("air_switch_type =", value, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeNotEqualTo(String value) {
            addCriterion("air_switch_type <>", value, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeGreaterThan(String value) {
            addCriterion("air_switch_type >", value, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeGreaterThanOrEqualTo(String value) {
            addCriterion("air_switch_type >=", value, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeLessThan(String value) {
            addCriterion("air_switch_type <", value, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeLessThanOrEqualTo(String value) {
            addCriterion("air_switch_type <=", value, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeLike(String value) {
            addCriterion("air_switch_type like", value, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeNotLike(String value) {
            addCriterion("air_switch_type not like", value, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeIn(List<String> values) {
            addCriterion("air_switch_type in", values, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeNotIn(List<String> values) {
            addCriterion("air_switch_type not in", values, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeBetween(String value1, String value2) {
            addCriterion("air_switch_type between", value1, value2, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andAirSwitchTypeNotBetween(String value1, String value2) {
            addCriterion("air_switch_type not between", value1, value2, "airSwitchType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeIsNull() {
            addCriterion("contactor_type is null");
            return (Criteria) this;
        }

        public Criteria andContactorTypeIsNotNull() {
            addCriterion("contactor_type is not null");
            return (Criteria) this;
        }

        public Criteria andContactorTypeEqualTo(String value) {
            addCriterion("contactor_type =", value, "contactorType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeNotEqualTo(String value) {
            addCriterion("contactor_type <>", value, "contactorType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeGreaterThan(String value) {
            addCriterion("contactor_type >", value, "contactorType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("contactor_type >=", value, "contactorType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeLessThan(String value) {
            addCriterion("contactor_type <", value, "contactorType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeLessThanOrEqualTo(String value) {
            addCriterion("contactor_type <=", value, "contactorType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeLike(String value) {
            addCriterion("contactor_type like", value, "contactorType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeNotLike(String value) {
            addCriterion("contactor_type not like", value, "contactorType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeIn(List<String> values) {
            addCriterion("contactor_type in", values, "contactorType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeNotIn(List<String> values) {
            addCriterion("contactor_type not in", values, "contactorType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeBetween(String value1, String value2) {
            addCriterion("contactor_type between", value1, value2, "contactorType");
            return (Criteria) this;
        }

        public Criteria andContactorTypeNotBetween(String value1, String value2) {
            addCriterion("contactor_type not between", value1, value2, "contactorType");
            return (Criteria) this;
        }

        public Criteria andLoopCountIsNull() {
            addCriterion("loop_count is null");
            return (Criteria) this;
        }

        public Criteria andLoopCountIsNotNull() {
            addCriterion("loop_count is not null");
            return (Criteria) this;
        }

        public Criteria andLoopCountEqualTo(Byte value) {
            addCriterion("loop_count =", value, "loopCount");
            return (Criteria) this;
        }

        public Criteria andLoopCountNotEqualTo(Byte value) {
            addCriterion("loop_count <>", value, "loopCount");
            return (Criteria) this;
        }

        public Criteria andLoopCountGreaterThan(Byte value) {
            addCriterion("loop_count >", value, "loopCount");
            return (Criteria) this;
        }

        public Criteria andLoopCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("loop_count >=", value, "loopCount");
            return (Criteria) this;
        }

        public Criteria andLoopCountLessThan(Byte value) {
            addCriterion("loop_count <", value, "loopCount");
            return (Criteria) this;
        }

        public Criteria andLoopCountLessThanOrEqualTo(Byte value) {
            addCriterion("loop_count <=", value, "loopCount");
            return (Criteria) this;
        }

        public Criteria andLoopCountIn(List<Byte> values) {
            addCriterion("loop_count in", values, "loopCount");
            return (Criteria) this;
        }

        public Criteria andLoopCountNotIn(List<Byte> values) {
            addCriterion("loop_count not in", values, "loopCount");
            return (Criteria) this;
        }

        public Criteria andLoopCountBetween(Byte value1, Byte value2) {
            addCriterion("loop_count between", value1, value2, "loopCount");
            return (Criteria) this;
        }

        public Criteria andLoopCountNotBetween(Byte value1, Byte value2) {
            addCriterion("loop_count not between", value1, value2, "loopCount");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdIsNull() {
            addCriterion("nnlightctl_elebox_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdIsNotNull() {
            addCriterion("nnlightctl_elebox_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_id =", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlDeployStatusEqualTo(Byte value) {
            addCriterion("deploy_status =", value, "deployStatus");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_id <>", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdGreaterThan(Long value) {
            addCriterion("nnlightctl_elebox_id >", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_id >=", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdLessThan(Long value) {
            addCriterion("nnlightctl_elebox_id <", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_id <=", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdIn(List<Long> values) {
            addCriterion("nnlightctl_elebox_id in", values, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_elebox_id not in", values, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_elebox_id between", value1, value2, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_elebox_id not between", value1, value2, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andAcIsNull() {
            addCriterion("ac is null");
            return (Criteria) this;
        }

        public Criteria andAcIsNotNull() {
            addCriterion("ac is not null");
            return (Criteria) this;
        }

        public Criteria andAcEqualTo(String value) {
            addCriterion("ac =", value, "ac");
            return (Criteria) this;
        }

        public Criteria andAcNotEqualTo(String value) {
            addCriterion("ac <>", value, "ac");
            return (Criteria) this;
        }

        public Criteria andAcGreaterThan(String value) {
            addCriterion("ac >", value, "ac");
            return (Criteria) this;
        }

        public Criteria andAcGreaterThanOrEqualTo(String value) {
            addCriterion("ac >=", value, "ac");
            return (Criteria) this;
        }

        public Criteria andAcLessThan(String value) {
            addCriterion("ac <", value, "ac");
            return (Criteria) this;
        }

        public Criteria andAcLessThanOrEqualTo(String value) {
            addCriterion("ac <=", value, "ac");
            return (Criteria) this;
        }

        public Criteria andAcLike(String value) {
            addCriterion("ac like", value, "ac");
            return (Criteria) this;
        }

        public Criteria andAcNotLike(String value) {
            addCriterion("ac not like", value, "ac");
            return (Criteria) this;
        }

        public Criteria andAcIn(List<String> values) {
            addCriterion("ac in", values, "ac");
            return (Criteria) this;
        }

        public Criteria andAcNotIn(List<String> values) {
            addCriterion("ac not in", values, "ac");
            return (Criteria) this;
        }

        public Criteria andAcBetween(String value1, String value2) {
            addCriterion("ac between", value1, value2, "ac");
            return (Criteria) this;
        }

        public Criteria andAcNotBetween(String value1, String value2) {
            addCriterion("ac not between", value1, value2, "ac");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityIsNull() {
            addCriterion("loop_electricity is null");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityIsNotNull() {
            addCriterion("loop_electricity is not null");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityEqualTo(BigDecimal value) {
            addCriterion("loop_electricity =", value, "loopElectricity");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityNotEqualTo(BigDecimal value) {
            addCriterion("loop_electricity <>", value, "loopElectricity");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityGreaterThan(BigDecimal value) {
            addCriterion("loop_electricity >", value, "loopElectricity");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loop_electricity >=", value, "loopElectricity");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityLessThan(BigDecimal value) {
            addCriterion("loop_electricity <", value, "loopElectricity");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loop_electricity <=", value, "loopElectricity");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityIn(List<BigDecimal> values) {
            addCriterion("loop_electricity in", values, "loopElectricity");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityNotIn(List<BigDecimal> values) {
            addCriterion("loop_electricity not in", values, "loopElectricity");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loop_electricity between", value1, value2, "loopElectricity");
            return (Criteria) this;
        }

        public Criteria andLoopElectricityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loop_electricity not between", value1, value2, "loopElectricity");
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