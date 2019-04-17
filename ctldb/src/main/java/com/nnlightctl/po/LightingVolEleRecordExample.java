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

        public Criteria andLightimeiIsNull() {
            addCriterion("lightIMEI is null");
            return (Criteria) this;
        }

        public Criteria andLightimeiIsNotNull() {
            addCriterion("lightIMEI is not null");
            return (Criteria) this;
        }

        public Criteria andLightimeiEqualTo(String value) {
            addCriterion("lightIMEI =", value, "lightimei");
            return (Criteria) this;
        }

        public Criteria andLightimeiNotEqualTo(String value) {
            addCriterion("lightIMEI <>", value, "lightimei");
            return (Criteria) this;
        }

        public Criteria andLightimeiGreaterThan(String value) {
            addCriterion("lightIMEI >", value, "lightimei");
            return (Criteria) this;
        }

        public Criteria andLightimeiGreaterThanOrEqualTo(String value) {
            addCriterion("lightIMEI >=", value, "lightimei");
            return (Criteria) this;
        }

        public Criteria andLightimeiLessThan(String value) {
            addCriterion("lightIMEI <", value, "lightimei");
            return (Criteria) this;
        }

        public Criteria andLightimeiLessThanOrEqualTo(String value) {
            addCriterion("lightIMEI <=", value, "lightimei");
            return (Criteria) this;
        }

        public Criteria andLightimeiLike(String value) {
            addCriterion("lightIMEI like", value, "lightimei");
            return (Criteria) this;
        }

        public Criteria andLightimeiNotLike(String value) {
            addCriterion("lightIMEI not like", value, "lightimei");
            return (Criteria) this;
        }

        public Criteria andLightimeiIn(List<String> values) {
            addCriterion("lightIMEI in", values, "lightimei");
            return (Criteria) this;
        }

        public Criteria andLightimeiNotIn(List<String> values) {
            addCriterion("lightIMEI not in", values, "lightimei");
            return (Criteria) this;
        }

        public Criteria andLightimeiBetween(String value1, String value2) {
            addCriterion("lightIMEI between", value1, value2, "lightimei");
            return (Criteria) this;
        }

        public Criteria andLightimeiNotBetween(String value1, String value2) {
            addCriterion("lightIMEI not between", value1, value2, "lightimei");
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

        public Criteria andSignalIntensityIsNull() {
            addCriterion("signal_intensity is null");
            return (Criteria) this;
        }

        public Criteria andSignalIntensityIsNotNull() {
            addCriterion("signal_intensity is not null");
            return (Criteria) this;
        }

        public Criteria andSignalIntensityEqualTo(BigDecimal value) {
            addCriterion("signal_intensity =", value, "signalIntensity");
            return (Criteria) this;
        }

        public Criteria andSignalIntensityNotEqualTo(BigDecimal value) {
            addCriterion("signal_intensity <>", value, "signalIntensity");
            return (Criteria) this;
        }

        public Criteria andSignalIntensityGreaterThan(BigDecimal value) {
            addCriterion("signal_intensity >", value, "signalIntensity");
            return (Criteria) this;
        }

        public Criteria andSignalIntensityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("signal_intensity >=", value, "signalIntensity");
            return (Criteria) this;
        }

        public Criteria andSignalIntensityLessThan(BigDecimal value) {
            addCriterion("signal_intensity <", value, "signalIntensity");
            return (Criteria) this;
        }

        public Criteria andSignalIntensityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("signal_intensity <=", value, "signalIntensity");
            return (Criteria) this;
        }

        public Criteria andSignalIntensityIn(List<BigDecimal> values) {
            addCriterion("signal_intensity in", values, "signalIntensity");
            return (Criteria) this;
        }

        public Criteria andSignalIntensityNotIn(List<BigDecimal> values) {
            addCriterion("signal_intensity not in", values, "signalIntensity");
            return (Criteria) this;
        }

        public Criteria andSignalIntensityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("signal_intensity between", value1, value2, "signalIntensity");
            return (Criteria) this;
        }

        public Criteria andSignalIntensityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("signal_intensity not between", value1, value2, "signalIntensity");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andInElectricityIsNull() {
            addCriterion("in_electricity is null");
            return (Criteria) this;
        }

        public Criteria andInElectricityIsNotNull() {
            addCriterion("in_electricity is not null");
            return (Criteria) this;
        }

        public Criteria andInElectricityEqualTo(String value) {
            addCriterion("in_electricity =", value, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInElectricityNotEqualTo(String value) {
            addCriterion("in_electricity <>", value, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInElectricityGreaterThan(String value) {
            addCriterion("in_electricity >", value, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInElectricityGreaterThanOrEqualTo(String value) {
            addCriterion("in_electricity >=", value, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInElectricityLessThan(String value) {
            addCriterion("in_electricity <", value, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInElectricityLessThanOrEqualTo(String value) {
            addCriterion("in_electricity <=", value, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInElectricityLike(String value) {
            addCriterion("in_electricity like", value, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInElectricityNotLike(String value) {
            addCriterion("in_electricity not like", value, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInElectricityIn(List<String> values) {
            addCriterion("in_electricity in", values, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInElectricityNotIn(List<String> values) {
            addCriterion("in_electricity not in", values, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInElectricityBetween(String value1, String value2) {
            addCriterion("in_electricity between", value1, value2, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInElectricityNotBetween(String value1, String value2) {
            addCriterion("in_electricity not between", value1, value2, "inElectricity");
            return (Criteria) this;
        }

        public Criteria andInVoltageIsNull() {
            addCriterion("in_voltage is null");
            return (Criteria) this;
        }

        public Criteria andInVoltageIsNotNull() {
            addCriterion("in_voltage is not null");
            return (Criteria) this;
        }

        public Criteria andInVoltageEqualTo(String value) {
            addCriterion("in_voltage =", value, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andInVoltageNotEqualTo(String value) {
            addCriterion("in_voltage <>", value, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andInVoltageGreaterThan(String value) {
            addCriterion("in_voltage >", value, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andInVoltageGreaterThanOrEqualTo(String value) {
            addCriterion("in_voltage >=", value, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andInVoltageLessThan(String value) {
            addCriterion("in_voltage <", value, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andInVoltageLessThanOrEqualTo(String value) {
            addCriterion("in_voltage <=", value, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andInVoltageLike(String value) {
            addCriterion("in_voltage like", value, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andInVoltageNotLike(String value) {
            addCriterion("in_voltage not like", value, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andInVoltageIn(List<String> values) {
            addCriterion("in_voltage in", values, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andInVoltageNotIn(List<String> values) {
            addCriterion("in_voltage not in", values, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andInVoltageBetween(String value1, String value2) {
            addCriterion("in_voltage between", value1, value2, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andInVoltageNotBetween(String value1, String value2) {
            addCriterion("in_voltage not between", value1, value2, "inVoltage");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyIsNull() {
            addCriterion("elec_frequency is null");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyIsNotNull() {
            addCriterion("elec_frequency is not null");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyEqualTo(String value) {
            addCriterion("elec_frequency =", value, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyNotEqualTo(String value) {
            addCriterion("elec_frequency <>", value, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyGreaterThan(String value) {
            addCriterion("elec_frequency >", value, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyGreaterThanOrEqualTo(String value) {
            addCriterion("elec_frequency >=", value, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyLessThan(String value) {
            addCriterion("elec_frequency <", value, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyLessThanOrEqualTo(String value) {
            addCriterion("elec_frequency <=", value, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyLike(String value) {
            addCriterion("elec_frequency like", value, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyNotLike(String value) {
            addCriterion("elec_frequency not like", value, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyIn(List<String> values) {
            addCriterion("elec_frequency in", values, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyNotIn(List<String> values) {
            addCriterion("elec_frequency not in", values, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyBetween(String value1, String value2) {
            addCriterion("elec_frequency between", value1, value2, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andElecFrequencyNotBetween(String value1, String value2) {
            addCriterion("elec_frequency not between", value1, value2, "elecFrequency");
            return (Criteria) this;
        }

        public Criteria andInActivePowerIsNull() {
            addCriterion("in_active_power is null");
            return (Criteria) this;
        }

        public Criteria andInActivePowerIsNotNull() {
            addCriterion("in_active_power is not null");
            return (Criteria) this;
        }

        public Criteria andInActivePowerEqualTo(String value) {
            addCriterion("in_active_power =", value, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInActivePowerNotEqualTo(String value) {
            addCriterion("in_active_power <>", value, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInActivePowerGreaterThan(String value) {
            addCriterion("in_active_power >", value, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInActivePowerGreaterThanOrEqualTo(String value) {
            addCriterion("in_active_power >=", value, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInActivePowerLessThan(String value) {
            addCriterion("in_active_power <", value, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInActivePowerLessThanOrEqualTo(String value) {
            addCriterion("in_active_power <=", value, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInActivePowerLike(String value) {
            addCriterion("in_active_power like", value, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInActivePowerNotLike(String value) {
            addCriterion("in_active_power not like", value, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInActivePowerIn(List<String> values) {
            addCriterion("in_active_power in", values, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInActivePowerNotIn(List<String> values) {
            addCriterion("in_active_power not in", values, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInActivePowerBetween(String value1, String value2) {
            addCriterion("in_active_power between", value1, value2, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInActivePowerNotBetween(String value1, String value2) {
            addCriterion("in_active_power not between", value1, value2, "inActivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerIsNull() {
            addCriterion("in_reactive_power is null");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerIsNotNull() {
            addCriterion("in_reactive_power is not null");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerEqualTo(String value) {
            addCriterion("in_reactive_power =", value, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerNotEqualTo(String value) {
            addCriterion("in_reactive_power <>", value, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerGreaterThan(String value) {
            addCriterion("in_reactive_power >", value, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerGreaterThanOrEqualTo(String value) {
            addCriterion("in_reactive_power >=", value, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerLessThan(String value) {
            addCriterion("in_reactive_power <", value, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerLessThanOrEqualTo(String value) {
            addCriterion("in_reactive_power <=", value, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerLike(String value) {
            addCriterion("in_reactive_power like", value, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerNotLike(String value) {
            addCriterion("in_reactive_power not like", value, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerIn(List<String> values) {
            addCriterion("in_reactive_power in", values, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerNotIn(List<String> values) {
            addCriterion("in_reactive_power not in", values, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerBetween(String value1, String value2) {
            addCriterion("in_reactive_power between", value1, value2, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInReactivePowerNotBetween(String value1, String value2) {
            addCriterion("in_reactive_power not between", value1, value2, "inReactivePower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerIsNull() {
            addCriterion("in_seen_power is null");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerIsNotNull() {
            addCriterion("in_seen_power is not null");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerEqualTo(String value) {
            addCriterion("in_seen_power =", value, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerNotEqualTo(String value) {
            addCriterion("in_seen_power <>", value, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerGreaterThan(String value) {
            addCriterion("in_seen_power >", value, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerGreaterThanOrEqualTo(String value) {
            addCriterion("in_seen_power >=", value, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerLessThan(String value) {
            addCriterion("in_seen_power <", value, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerLessThanOrEqualTo(String value) {
            addCriterion("in_seen_power <=", value, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerLike(String value) {
            addCriterion("in_seen_power like", value, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerNotLike(String value) {
            addCriterion("in_seen_power not like", value, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerIn(List<String> values) {
            addCriterion("in_seen_power in", values, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerNotIn(List<String> values) {
            addCriterion("in_seen_power not in", values, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerBetween(String value1, String value2) {
            addCriterion("in_seen_power between", value1, value2, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInSeenPowerNotBetween(String value1, String value2) {
            addCriterion("in_seen_power not between", value1, value2, "inSeenPower");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyIsNull() {
            addCriterion("in_active_energy is null");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyIsNotNull() {
            addCriterion("in_active_energy is not null");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyEqualTo(String value) {
            addCriterion("in_active_energy =", value, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyNotEqualTo(String value) {
            addCriterion("in_active_energy <>", value, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyGreaterThan(String value) {
            addCriterion("in_active_energy >", value, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyGreaterThanOrEqualTo(String value) {
            addCriterion("in_active_energy >=", value, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyLessThan(String value) {
            addCriterion("in_active_energy <", value, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyLessThanOrEqualTo(String value) {
            addCriterion("in_active_energy <=", value, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyLike(String value) {
            addCriterion("in_active_energy like", value, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyNotLike(String value) {
            addCriterion("in_active_energy not like", value, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyIn(List<String> values) {
            addCriterion("in_active_energy in", values, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyNotIn(List<String> values) {
            addCriterion("in_active_energy not in", values, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyBetween(String value1, String value2) {
            addCriterion("in_active_energy between", value1, value2, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInActiveEnergyNotBetween(String value1, String value2) {
            addCriterion("in_active_energy not between", value1, value2, "inActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyIsNull() {
            addCriterion("in_reactive_energy is null");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyIsNotNull() {
            addCriterion("in_reactive_energy is not null");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyEqualTo(String value) {
            addCriterion("in_reactive_energy =", value, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyNotEqualTo(String value) {
            addCriterion("in_reactive_energy <>", value, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyGreaterThan(String value) {
            addCriterion("in_reactive_energy >", value, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyGreaterThanOrEqualTo(String value) {
            addCriterion("in_reactive_energy >=", value, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyLessThan(String value) {
            addCriterion("in_reactive_energy <", value, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyLessThanOrEqualTo(String value) {
            addCriterion("in_reactive_energy <=", value, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyLike(String value) {
            addCriterion("in_reactive_energy like", value, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyNotLike(String value) {
            addCriterion("in_reactive_energy not like", value, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyIn(List<String> values) {
            addCriterion("in_reactive_energy in", values, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyNotIn(List<String> values) {
            addCriterion("in_reactive_energy not in", values, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyBetween(String value1, String value2) {
            addCriterion("in_reactive_energy between", value1, value2, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInReactiveEnergyNotBetween(String value1, String value2) {
            addCriterion("in_reactive_energy not between", value1, value2, "inReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyIsNull() {
            addCriterion("in_seen_energy is null");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyIsNotNull() {
            addCriterion("in_seen_energy is not null");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyEqualTo(String value) {
            addCriterion("in_seen_energy =", value, "inSeenEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyNotEqualTo(String value) {
            addCriterion("in_seen_energy <>", value, "inSeenEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyGreaterThan(String value) {
            addCriterion("in_seen_energy >", value, "inSeenEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyGreaterThanOrEqualTo(String value) {
            addCriterion("in_seen_energy >=", value, "inSeenEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyLessThan(String value) {
            addCriterion("in_seen_energy <", value, "inSeenEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyLessThanOrEqualTo(String value) {
            addCriterion("in_seen_energy <=", value, "inSeenEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyLike(String value) {
            addCriterion("in_seen_energy like", value, "inSeenEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyNotLike(String value) {
            addCriterion("in_seen_energy not like", value, "inSeenEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyIn(List<String> values) {
            addCriterion("in_seen_energy in", values, "inSeenEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyNotIn(List<String> values) {
            addCriterion("in_seen_energy not in", values, "inSeenEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyBetween(String value1, String value2) {
            addCriterion("in_seen_energy between", value1, value2, "inSeenEnergy");
            return (Criteria) this;
        }

        public Criteria andInSeenEnergyNotBetween(String value1, String value2) {
            addCriterion("in_seen_energy not between", value1, value2, "inSeenEnergy");
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