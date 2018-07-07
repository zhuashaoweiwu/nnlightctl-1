package com.nnlightctl.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LightingVolEleRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LightingVolEleRecordExample() {
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

        public Criteria andRecordDatetimeIsNull() {
            addCriterion("record_datetime is null");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeIsNotNull() {
            addCriterion("record_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeEqualTo(Date value) {
            addCriterion("record_datetime =", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeNotEqualTo(Date value) {
            addCriterion("record_datetime <>", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeGreaterThan(Date value) {
            addCriterion("record_datetime >", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("record_datetime >=", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeLessThan(Date value) {
            addCriterion("record_datetime <", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("record_datetime <=", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeIn(List<Date> values) {
            addCriterion("record_datetime in", values, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeNotIn(List<Date> values) {
            addCriterion("record_datetime not in", values, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeBetween(Date value1, Date value2) {
            addCriterion("record_datetime between", value1, value2, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("record_datetime not between", value1, value2, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andVoltageIsNull() {
            addCriterion("voltage is null");
            return (Criteria) this;
        }

        public Criteria andVoltageIsNotNull() {
            addCriterion("voltage is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageEqualTo(BigDecimal value) {
            addCriterion("voltage =", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotEqualTo(BigDecimal value) {
            addCriterion("voltage <>", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThan(BigDecimal value) {
            addCriterion("voltage >", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("voltage >=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThan(BigDecimal value) {
            addCriterion("voltage <", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("voltage <=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageIn(List<BigDecimal> values) {
            addCriterion("voltage in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotIn(List<BigDecimal> values) {
            addCriterion("voltage not in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("voltage between", value1, value2, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("voltage not between", value1, value2, "voltage");
            return (Criteria) this;
        }

        public Criteria andElectrictyIsNull() {
            addCriterion("electricty is null");
            return (Criteria) this;
        }

        public Criteria andElectrictyIsNotNull() {
            addCriterion("electricty is not null");
            return (Criteria) this;
        }

        public Criteria andElectrictyEqualTo(BigDecimal value) {
            addCriterion("electricty =", value, "electricty");
            return (Criteria) this;
        }

        public Criteria andElectrictyNotEqualTo(BigDecimal value) {
            addCriterion("electricty <>", value, "electricty");
            return (Criteria) this;
        }

        public Criteria andElectrictyGreaterThan(BigDecimal value) {
            addCriterion("electricty >", value, "electricty");
            return (Criteria) this;
        }

        public Criteria andElectrictyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("electricty >=", value, "electricty");
            return (Criteria) this;
        }

        public Criteria andElectrictyLessThan(BigDecimal value) {
            addCriterion("electricty <", value, "electricty");
            return (Criteria) this;
        }

        public Criteria andElectrictyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("electricty <=", value, "electricty");
            return (Criteria) this;
        }

        public Criteria andElectrictyIn(List<BigDecimal> values) {
            addCriterion("electricty in", values, "electricty");
            return (Criteria) this;
        }

        public Criteria andElectrictyNotIn(List<BigDecimal> values) {
            addCriterion("electricty not in", values, "electricty");
            return (Criteria) this;
        }

        public Criteria andElectrictyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electricty between", value1, value2, "electricty");
            return (Criteria) this;
        }

        public Criteria andElectrictyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electricty not between", value1, value2, "electricty");
            return (Criteria) this;
        }

        public Criteria andEnergyIsNull() {
            addCriterion("energy is null");
            return (Criteria) this;
        }

        public Criteria andEnergyIsNotNull() {
            addCriterion("energy is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyEqualTo(BigDecimal value) {
            addCriterion("energy =", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotEqualTo(BigDecimal value) {
            addCriterion("energy <>", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThan(BigDecimal value) {
            addCriterion("energy >", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("energy >=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThan(BigDecimal value) {
            addCriterion("energy <", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("energy <=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyIn(List<BigDecimal> values) {
            addCriterion("energy in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotIn(List<BigDecimal> values) {
            addCriterion("energy not in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("energy between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("energy not between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andDampnessIsNull() {
            addCriterion("dampness is null");
            return (Criteria) this;
        }

        public Criteria andDampnessIsNotNull() {
            addCriterion("dampness is not null");
            return (Criteria) this;
        }

        public Criteria andDampnessEqualTo(BigDecimal value) {
            addCriterion("dampness =", value, "dampness");
            return (Criteria) this;
        }

        public Criteria andDampnessNotEqualTo(BigDecimal value) {
            addCriterion("dampness <>", value, "dampness");
            return (Criteria) this;
        }

        public Criteria andDampnessGreaterThan(BigDecimal value) {
            addCriterion("dampness >", value, "dampness");
            return (Criteria) this;
        }

        public Criteria andDampnessGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dampness >=", value, "dampness");
            return (Criteria) this;
        }

        public Criteria andDampnessLessThan(BigDecimal value) {
            addCriterion("dampness <", value, "dampness");
            return (Criteria) this;
        }

        public Criteria andDampnessLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dampness <=", value, "dampness");
            return (Criteria) this;
        }

        public Criteria andDampnessIn(List<BigDecimal> values) {
            addCriterion("dampness in", values, "dampness");
            return (Criteria) this;
        }

        public Criteria andDampnessNotIn(List<BigDecimal> values) {
            addCriterion("dampness not in", values, "dampness");
            return (Criteria) this;
        }

        public Criteria andDampnessBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dampness between", value1, value2, "dampness");
            return (Criteria) this;
        }

        public Criteria andDampnessNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dampness not between", value1, value2, "dampness");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(BigDecimal value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(BigDecimal value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(BigDecimal value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(BigDecimal value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(BigDecimal value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<BigDecimal> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<BigDecimal> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andBeamIsNull() {
            addCriterion("beam is null");
            return (Criteria) this;
        }

        public Criteria andBeamIsNotNull() {
            addCriterion("beam is not null");
            return (Criteria) this;
        }

        public Criteria andBeamEqualTo(BigDecimal value) {
            addCriterion("beam =", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamNotEqualTo(BigDecimal value) {
            addCriterion("beam <>", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamGreaterThan(BigDecimal value) {
            addCriterion("beam >", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("beam >=", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamLessThan(BigDecimal value) {
            addCriterion("beam <", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamLessThanOrEqualTo(BigDecimal value) {
            addCriterion("beam <=", value, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamIn(List<BigDecimal> values) {
            addCriterion("beam in", values, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamNotIn(List<BigDecimal> values) {
            addCriterion("beam not in", values, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("beam between", value1, value2, "beam");
            return (Criteria) this;
        }

        public Criteria andBeamNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("beam not between", value1, value2, "beam");
            return (Criteria) this;
        }

        public Criteria andPersist1IsNull() {
            addCriterion("persist1 is null");
            return (Criteria) this;
        }

        public Criteria andPersist1IsNotNull() {
            addCriterion("persist1 is not null");
            return (Criteria) this;
        }

        public Criteria andPersist1EqualTo(BigDecimal value) {
            addCriterion("persist1 =", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1NotEqualTo(BigDecimal value) {
            addCriterion("persist1 <>", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1GreaterThan(BigDecimal value) {
            addCriterion("persist1 >", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("persist1 >=", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1LessThan(BigDecimal value) {
            addCriterion("persist1 <", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("persist1 <=", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1In(List<BigDecimal> values) {
            addCriterion("persist1 in", values, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1NotIn(List<BigDecimal> values) {
            addCriterion("persist1 not in", values, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("persist1 between", value1, value2, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("persist1 not between", value1, value2, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist2IsNull() {
            addCriterion("persist2 is null");
            return (Criteria) this;
        }

        public Criteria andPersist2IsNotNull() {
            addCriterion("persist2 is not null");
            return (Criteria) this;
        }

        public Criteria andPersist2EqualTo(BigDecimal value) {
            addCriterion("persist2 =", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2NotEqualTo(BigDecimal value) {
            addCriterion("persist2 <>", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2GreaterThan(BigDecimal value) {
            addCriterion("persist2 >", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("persist2 >=", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2LessThan(BigDecimal value) {
            addCriterion("persist2 <", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("persist2 <=", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2In(List<BigDecimal> values) {
            addCriterion("persist2 in", values, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2NotIn(List<BigDecimal> values) {
            addCriterion("persist2 not in", values, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("persist2 between", value1, value2, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("persist2 not between", value1, value2, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist3IsNull() {
            addCriterion("persist3 is null");
            return (Criteria) this;
        }

        public Criteria andPersist3IsNotNull() {
            addCriterion("persist3 is not null");
            return (Criteria) this;
        }

        public Criteria andPersist3EqualTo(BigDecimal value) {
            addCriterion("persist3 =", value, "persist3");
            return (Criteria) this;
        }

        public Criteria andPersist3NotEqualTo(BigDecimal value) {
            addCriterion("persist3 <>", value, "persist3");
            return (Criteria) this;
        }

        public Criteria andPersist3GreaterThan(BigDecimal value) {
            addCriterion("persist3 >", value, "persist3");
            return (Criteria) this;
        }

        public Criteria andPersist3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("persist3 >=", value, "persist3");
            return (Criteria) this;
        }

        public Criteria andPersist3LessThan(BigDecimal value) {
            addCriterion("persist3 <", value, "persist3");
            return (Criteria) this;
        }

        public Criteria andPersist3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("persist3 <=", value, "persist3");
            return (Criteria) this;
        }

        public Criteria andPersist3In(List<BigDecimal> values) {
            addCriterion("persist3 in", values, "persist3");
            return (Criteria) this;
        }

        public Criteria andPersist3NotIn(List<BigDecimal> values) {
            addCriterion("persist3 not in", values, "persist3");
            return (Criteria) this;
        }

        public Criteria andPersist3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("persist3 between", value1, value2, "persist3");
            return (Criteria) this;
        }

        public Criteria andPersist3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("persist3 not between", value1, value2, "persist3");
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