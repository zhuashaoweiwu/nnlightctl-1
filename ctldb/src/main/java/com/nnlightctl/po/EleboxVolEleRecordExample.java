package com.nnlightctl.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EleboxVolEleRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EleboxVolEleRecordExample() {
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

        public Criteria andRealtimeDateIsNull() {
            addCriterion("realtime_date is null");
            return (Criteria) this;
        }

        public Criteria andRealtimeDateIsNotNull() {
            addCriterion("realtime_date is not null");
            return (Criteria) this;
        }

        public Criteria andRealtimeDateEqualTo(Date value) {
            addCriterion("realtime_date =", value, "realtimeDate");
            return (Criteria) this;
        }

        public Criteria andRealtimeDateNotEqualTo(Date value) {
            addCriterion("realtime_date <>", value, "realtimeDate");
            return (Criteria) this;
        }

        public Criteria andRealtimeDateGreaterThan(Date value) {
            addCriterion("realtime_date >", value, "realtimeDate");
            return (Criteria) this;
        }

        public Criteria andRealtimeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("realtime_date >=", value, "realtimeDate");
            return (Criteria) this;
        }

        public Criteria andRealtimeDateLessThan(Date value) {
            addCriterion("realtime_date <", value, "realtimeDate");
            return (Criteria) this;
        }

        public Criteria andRealtimeDateLessThanOrEqualTo(Date value) {
            addCriterion("realtime_date <=", value, "realtimeDate");
            return (Criteria) this;
        }

        public Criteria andRealtimeDateIn(List<Date> values) {
            addCriterion("realtime_date in", values, "realtimeDate");
            return (Criteria) this;
        }

        public Criteria andRealtimeDateNotIn(List<Date> values) {
            addCriterion("realtime_date not in", values, "realtimeDate");
            return (Criteria) this;
        }

        public Criteria andRealtimeDateBetween(Date value1, Date value2) {
            addCriterion("realtime_date between", value1, value2, "realtimeDate");
            return (Criteria) this;
        }

        public Criteria andRealtimeDateNotBetween(Date value1, Date value2) {
            addCriterion("realtime_date not between", value1, value2, "realtimeDate");
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

        public Criteria andElectricityIsNull() {
            addCriterion("electricity is null");
            return (Criteria) this;
        }

        public Criteria andElectricityIsNotNull() {
            addCriterion("electricity is not null");
            return (Criteria) this;
        }

        public Criteria andElectricityEqualTo(BigDecimal value) {
            addCriterion("electricity =", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotEqualTo(BigDecimal value) {
            addCriterion("electricity <>", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThan(BigDecimal value) {
            addCriterion("electricity >", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("electricity >=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThan(BigDecimal value) {
            addCriterion("electricity <", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("electricity <=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityIn(List<BigDecimal> values) {
            addCriterion("electricity in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotIn(List<BigDecimal> values) {
            addCriterion("electricity not in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electricity between", value1, value2, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electricity not between", value1, value2, "electricity");
            return (Criteria) this;
        }

        public Criteria andAVoltageIsNull() {
            addCriterion("a_voltage is null");
            return (Criteria) this;
        }

        public Criteria andAVoltageIsNotNull() {
            addCriterion("a_voltage is not null");
            return (Criteria) this;
        }

        public Criteria andAVoltageEqualTo(String value) {
            addCriterion("a_voltage =", value, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andAVoltageNotEqualTo(String value) {
            addCriterion("a_voltage <>", value, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andAVoltageGreaterThan(String value) {
            addCriterion("a_voltage >", value, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andAVoltageGreaterThanOrEqualTo(String value) {
            addCriterion("a_voltage >=", value, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andAVoltageLessThan(String value) {
            addCriterion("a_voltage <", value, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andAVoltageLessThanOrEqualTo(String value) {
            addCriterion("a_voltage <=", value, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andAVoltageLike(String value) {
            addCriterion("a_voltage like", value, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andAVoltageNotLike(String value) {
            addCriterion("a_voltage not like", value, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andAVoltageIn(List<String> values) {
            addCriterion("a_voltage in", values, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andAVoltageNotIn(List<String> values) {
            addCriterion("a_voltage not in", values, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andAVoltageBetween(String value1, String value2) {
            addCriterion("a_voltage between", value1, value2, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andAVoltageNotBetween(String value1, String value2) {
            addCriterion("a_voltage not between", value1, value2, "aVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageIsNull() {
            addCriterion("b_voltage is null");
            return (Criteria) this;
        }

        public Criteria andBVoltageIsNotNull() {
            addCriterion("b_voltage is not null");
            return (Criteria) this;
        }

        public Criteria andBVoltageEqualTo(String value) {
            addCriterion("b_voltage =", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageNotEqualTo(String value) {
            addCriterion("b_voltage <>", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageGreaterThan(String value) {
            addCriterion("b_voltage >", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageGreaterThanOrEqualTo(String value) {
            addCriterion("b_voltage >=", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageLessThan(String value) {
            addCriterion("b_voltage <", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageLessThanOrEqualTo(String value) {
            addCriterion("b_voltage <=", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageLike(String value) {
            addCriterion("b_voltage like", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageNotLike(String value) {
            addCriterion("b_voltage not like", value, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageIn(List<String> values) {
            addCriterion("b_voltage in", values, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageNotIn(List<String> values) {
            addCriterion("b_voltage not in", values, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageBetween(String value1, String value2) {
            addCriterion("b_voltage between", value1, value2, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andBVoltageNotBetween(String value1, String value2) {
            addCriterion("b_voltage not between", value1, value2, "bVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageIsNull() {
            addCriterion("c_voltage is null");
            return (Criteria) this;
        }

        public Criteria andCVoltageIsNotNull() {
            addCriterion("c_voltage is not null");
            return (Criteria) this;
        }

        public Criteria andCVoltageEqualTo(String value) {
            addCriterion("c_voltage =", value, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageNotEqualTo(String value) {
            addCriterion("c_voltage <>", value, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageGreaterThan(String value) {
            addCriterion("c_voltage >", value, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageGreaterThanOrEqualTo(String value) {
            addCriterion("c_voltage >=", value, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageLessThan(String value) {
            addCriterion("c_voltage <", value, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageLessThanOrEqualTo(String value) {
            addCriterion("c_voltage <=", value, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageLike(String value) {
            addCriterion("c_voltage like", value, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageNotLike(String value) {
            addCriterion("c_voltage not like", value, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageIn(List<String> values) {
            addCriterion("c_voltage in", values, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageNotIn(List<String> values) {
            addCriterion("c_voltage not in", values, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageBetween(String value1, String value2) {
            addCriterion("c_voltage between", value1, value2, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andCVoltageNotBetween(String value1, String value2) {
            addCriterion("c_voltage not between", value1, value2, "cVoltage");
            return (Criteria) this;
        }

        public Criteria andAElectricityIsNull() {
            addCriterion("a_electricity is null");
            return (Criteria) this;
        }

        public Criteria andAElectricityIsNotNull() {
            addCriterion("a_electricity is not null");
            return (Criteria) this;
        }

        public Criteria andAElectricityEqualTo(String value) {
            addCriterion("a_electricity =", value, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andAElectricityNotEqualTo(String value) {
            addCriterion("a_electricity <>", value, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andAElectricityGreaterThan(String value) {
            addCriterion("a_electricity >", value, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andAElectricityGreaterThanOrEqualTo(String value) {
            addCriterion("a_electricity >=", value, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andAElectricityLessThan(String value) {
            addCriterion("a_electricity <", value, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andAElectricityLessThanOrEqualTo(String value) {
            addCriterion("a_electricity <=", value, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andAElectricityLike(String value) {
            addCriterion("a_electricity like", value, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andAElectricityNotLike(String value) {
            addCriterion("a_electricity not like", value, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andAElectricityIn(List<String> values) {
            addCriterion("a_electricity in", values, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andAElectricityNotIn(List<String> values) {
            addCriterion("a_electricity not in", values, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andAElectricityBetween(String value1, String value2) {
            addCriterion("a_electricity between", value1, value2, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andAElectricityNotBetween(String value1, String value2) {
            addCriterion("a_electricity not between", value1, value2, "aElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityIsNull() {
            addCriterion("b_electricity is null");
            return (Criteria) this;
        }

        public Criteria andBElectricityIsNotNull() {
            addCriterion("b_electricity is not null");
            return (Criteria) this;
        }

        public Criteria andBElectricityEqualTo(String value) {
            addCriterion("b_electricity =", value, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityNotEqualTo(String value) {
            addCriterion("b_electricity <>", value, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityGreaterThan(String value) {
            addCriterion("b_electricity >", value, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityGreaterThanOrEqualTo(String value) {
            addCriterion("b_electricity >=", value, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityLessThan(String value) {
            addCriterion("b_electricity <", value, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityLessThanOrEqualTo(String value) {
            addCriterion("b_electricity <=", value, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityLike(String value) {
            addCriterion("b_electricity like", value, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityNotLike(String value) {
            addCriterion("b_electricity not like", value, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityIn(List<String> values) {
            addCriterion("b_electricity in", values, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityNotIn(List<String> values) {
            addCriterion("b_electricity not in", values, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityBetween(String value1, String value2) {
            addCriterion("b_electricity between", value1, value2, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andBElectricityNotBetween(String value1, String value2) {
            addCriterion("b_electricity not between", value1, value2, "bElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityIsNull() {
            addCriterion("c_electricity is null");
            return (Criteria) this;
        }

        public Criteria andCElectricityIsNotNull() {
            addCriterion("c_electricity is not null");
            return (Criteria) this;
        }

        public Criteria andCElectricityEqualTo(String value) {
            addCriterion("c_electricity =", value, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityNotEqualTo(String value) {
            addCriterion("c_electricity <>", value, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityGreaterThan(String value) {
            addCriterion("c_electricity >", value, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityGreaterThanOrEqualTo(String value) {
            addCriterion("c_electricity >=", value, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityLessThan(String value) {
            addCriterion("c_electricity <", value, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityLessThanOrEqualTo(String value) {
            addCriterion("c_electricity <=", value, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityLike(String value) {
            addCriterion("c_electricity like", value, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityNotLike(String value) {
            addCriterion("c_electricity not like", value, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityIn(List<String> values) {
            addCriterion("c_electricity in", values, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityNotIn(List<String> values) {
            addCriterion("c_electricity not in", values, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityBetween(String value1, String value2) {
            addCriterion("c_electricity between", value1, value2, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andCElectricityNotBetween(String value1, String value2) {
            addCriterion("c_electricity not between", value1, value2, "cElectricity");
            return (Criteria) this;
        }

        public Criteria andAActivePowerIsNull() {
            addCriterion("a_active_power is null");
            return (Criteria) this;
        }

        public Criteria andAActivePowerIsNotNull() {
            addCriterion("a_active_power is not null");
            return (Criteria) this;
        }

        public Criteria andAActivePowerEqualTo(String value) {
            addCriterion("a_active_power =", value, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andAActivePowerNotEqualTo(String value) {
            addCriterion("a_active_power <>", value, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andAActivePowerGreaterThan(String value) {
            addCriterion("a_active_power >", value, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andAActivePowerGreaterThanOrEqualTo(String value) {
            addCriterion("a_active_power >=", value, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andAActivePowerLessThan(String value) {
            addCriterion("a_active_power <", value, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andAActivePowerLessThanOrEqualTo(String value) {
            addCriterion("a_active_power <=", value, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andAActivePowerLike(String value) {
            addCriterion("a_active_power like", value, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andAActivePowerNotLike(String value) {
            addCriterion("a_active_power not like", value, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andAActivePowerIn(List<String> values) {
            addCriterion("a_active_power in", values, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andAActivePowerNotIn(List<String> values) {
            addCriterion("a_active_power not in", values, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andAActivePowerBetween(String value1, String value2) {
            addCriterion("a_active_power between", value1, value2, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andAActivePowerNotBetween(String value1, String value2) {
            addCriterion("a_active_power not between", value1, value2, "aActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerIsNull() {
            addCriterion("b_active_power is null");
            return (Criteria) this;
        }

        public Criteria andBActivePowerIsNotNull() {
            addCriterion("b_active_power is not null");
            return (Criteria) this;
        }

        public Criteria andBActivePowerEqualTo(String value) {
            addCriterion("b_active_power =", value, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerNotEqualTo(String value) {
            addCriterion("b_active_power <>", value, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerGreaterThan(String value) {
            addCriterion("b_active_power >", value, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerGreaterThanOrEqualTo(String value) {
            addCriterion("b_active_power >=", value, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerLessThan(String value) {
            addCriterion("b_active_power <", value, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerLessThanOrEqualTo(String value) {
            addCriterion("b_active_power <=", value, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerLike(String value) {
            addCriterion("b_active_power like", value, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerNotLike(String value) {
            addCriterion("b_active_power not like", value, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerIn(List<String> values) {
            addCriterion("b_active_power in", values, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerNotIn(List<String> values) {
            addCriterion("b_active_power not in", values, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerBetween(String value1, String value2) {
            addCriterion("b_active_power between", value1, value2, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andBActivePowerNotBetween(String value1, String value2) {
            addCriterion("b_active_power not between", value1, value2, "bActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerIsNull() {
            addCriterion("c_active_power is null");
            return (Criteria) this;
        }

        public Criteria andCActivePowerIsNotNull() {
            addCriterion("c_active_power is not null");
            return (Criteria) this;
        }

        public Criteria andCActivePowerEqualTo(String value) {
            addCriterion("c_active_power =", value, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerNotEqualTo(String value) {
            addCriterion("c_active_power <>", value, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerGreaterThan(String value) {
            addCriterion("c_active_power >", value, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerGreaterThanOrEqualTo(String value) {
            addCriterion("c_active_power >=", value, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerLessThan(String value) {
            addCriterion("c_active_power <", value, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerLessThanOrEqualTo(String value) {
            addCriterion("c_active_power <=", value, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerLike(String value) {
            addCriterion("c_active_power like", value, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerNotLike(String value) {
            addCriterion("c_active_power not like", value, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerIn(List<String> values) {
            addCriterion("c_active_power in", values, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerNotIn(List<String> values) {
            addCriterion("c_active_power not in", values, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerBetween(String value1, String value2) {
            addCriterion("c_active_power between", value1, value2, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andCActivePowerNotBetween(String value1, String value2) {
            addCriterion("c_active_power not between", value1, value2, "cActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerIsNull() {
            addCriterion("total_active_power is null");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerIsNotNull() {
            addCriterion("total_active_power is not null");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerEqualTo(String value) {
            addCriterion("total_active_power =", value, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerNotEqualTo(String value) {
            addCriterion("total_active_power <>", value, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerGreaterThan(String value) {
            addCriterion("total_active_power >", value, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerGreaterThanOrEqualTo(String value) {
            addCriterion("total_active_power >=", value, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerLessThan(String value) {
            addCriterion("total_active_power <", value, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerLessThanOrEqualTo(String value) {
            addCriterion("total_active_power <=", value, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerLike(String value) {
            addCriterion("total_active_power like", value, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerNotLike(String value) {
            addCriterion("total_active_power not like", value, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerIn(List<String> values) {
            addCriterion("total_active_power in", values, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerNotIn(List<String> values) {
            addCriterion("total_active_power not in", values, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerBetween(String value1, String value2) {
            addCriterion("total_active_power between", value1, value2, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActivePowerNotBetween(String value1, String value2) {
            addCriterion("total_active_power not between", value1, value2, "totalActivePower");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyIsNull() {
            addCriterion("total_active_energy is null");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyIsNotNull() {
            addCriterion("total_active_energy is not null");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyEqualTo(String value) {
            addCriterion("total_active_energy =", value, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyNotEqualTo(String value) {
            addCriterion("total_active_energy <>", value, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyGreaterThan(String value) {
            addCriterion("total_active_energy >", value, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyGreaterThanOrEqualTo(String value) {
            addCriterion("total_active_energy >=", value, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyLessThan(String value) {
            addCriterion("total_active_energy <", value, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyLessThanOrEqualTo(String value) {
            addCriterion("total_active_energy <=", value, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyLike(String value) {
            addCriterion("total_active_energy like", value, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyNotLike(String value) {
            addCriterion("total_active_energy not like", value, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyIn(List<String> values) {
            addCriterion("total_active_energy in", values, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyNotIn(List<String> values) {
            addCriterion("total_active_energy not in", values, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyBetween(String value1, String value2) {
            addCriterion("total_active_energy between", value1, value2, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalActiveEnergyNotBetween(String value1, String value2) {
            addCriterion("total_active_energy not between", value1, value2, "totalActiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyIsNull() {
            addCriterion("total_reactive_energy is null");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyIsNotNull() {
            addCriterion("total_reactive_energy is not null");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyEqualTo(String value) {
            addCriterion("total_reactive_energy =", value, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyNotEqualTo(String value) {
            addCriterion("total_reactive_energy <>", value, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyGreaterThan(String value) {
            addCriterion("total_reactive_energy >", value, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyGreaterThanOrEqualTo(String value) {
            addCriterion("total_reactive_energy >=", value, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyLessThan(String value) {
            addCriterion("total_reactive_energy <", value, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyLessThanOrEqualTo(String value) {
            addCriterion("total_reactive_energy <=", value, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyLike(String value) {
            addCriterion("total_reactive_energy like", value, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyNotLike(String value) {
            addCriterion("total_reactive_energy not like", value, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyIn(List<String> values) {
            addCriterion("total_reactive_energy in", values, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyNotIn(List<String> values) {
            addCriterion("total_reactive_energy not in", values, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyBetween(String value1, String value2) {
            addCriterion("total_reactive_energy between", value1, value2, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andTotalReactiveEnergyNotBetween(String value1, String value2) {
            addCriterion("total_reactive_energy not between", value1, value2, "totalReactiveEnergy");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorIsNull() {
            addCriterion("a_power_factor is null");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorIsNotNull() {
            addCriterion("a_power_factor is not null");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorEqualTo(String value) {
            addCriterion("a_power_factor =", value, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorNotEqualTo(String value) {
            addCriterion("a_power_factor <>", value, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorGreaterThan(String value) {
            addCriterion("a_power_factor >", value, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorGreaterThanOrEqualTo(String value) {
            addCriterion("a_power_factor >=", value, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorLessThan(String value) {
            addCriterion("a_power_factor <", value, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorLessThanOrEqualTo(String value) {
            addCriterion("a_power_factor <=", value, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorLike(String value) {
            addCriterion("a_power_factor like", value, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorNotLike(String value) {
            addCriterion("a_power_factor not like", value, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorIn(List<String> values) {
            addCriterion("a_power_factor in", values, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorNotIn(List<String> values) {
            addCriterion("a_power_factor not in", values, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorBetween(String value1, String value2) {
            addCriterion("a_power_factor between", value1, value2, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andAPowerFactorNotBetween(String value1, String value2) {
            addCriterion("a_power_factor not between", value1, value2, "aPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorIsNull() {
            addCriterion("b_power_factor is null");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorIsNotNull() {
            addCriterion("b_power_factor is not null");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorEqualTo(String value) {
            addCriterion("b_power_factor =", value, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorNotEqualTo(String value) {
            addCriterion("b_power_factor <>", value, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorGreaterThan(String value) {
            addCriterion("b_power_factor >", value, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorGreaterThanOrEqualTo(String value) {
            addCriterion("b_power_factor >=", value, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorLessThan(String value) {
            addCriterion("b_power_factor <", value, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorLessThanOrEqualTo(String value) {
            addCriterion("b_power_factor <=", value, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorLike(String value) {
            addCriterion("b_power_factor like", value, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorNotLike(String value) {
            addCriterion("b_power_factor not like", value, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorIn(List<String> values) {
            addCriterion("b_power_factor in", values, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorNotIn(List<String> values) {
            addCriterion("b_power_factor not in", values, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorBetween(String value1, String value2) {
            addCriterion("b_power_factor between", value1, value2, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andBPowerFactorNotBetween(String value1, String value2) {
            addCriterion("b_power_factor not between", value1, value2, "bPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorIsNull() {
            addCriterion("c_power_factor is null");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorIsNotNull() {
            addCriterion("c_power_factor is not null");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorEqualTo(String value) {
            addCriterion("c_power_factor =", value, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorNotEqualTo(String value) {
            addCriterion("c_power_factor <>", value, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorGreaterThan(String value) {
            addCriterion("c_power_factor >", value, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorGreaterThanOrEqualTo(String value) {
            addCriterion("c_power_factor >=", value, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorLessThan(String value) {
            addCriterion("c_power_factor <", value, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorLessThanOrEqualTo(String value) {
            addCriterion("c_power_factor <=", value, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorLike(String value) {
            addCriterion("c_power_factor like", value, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorNotLike(String value) {
            addCriterion("c_power_factor not like", value, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorIn(List<String> values) {
            addCriterion("c_power_factor in", values, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorNotIn(List<String> values) {
            addCriterion("c_power_factor not in", values, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorBetween(String value1, String value2) {
            addCriterion("c_power_factor between", value1, value2, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andCPowerFactorNotBetween(String value1, String value2) {
            addCriterion("c_power_factor not between", value1, value2, "cPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorIsNull() {
            addCriterion("total_power_factor is null");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorIsNotNull() {
            addCriterion("total_power_factor is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorEqualTo(String value) {
            addCriterion("total_power_factor =", value, "totalPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorNotEqualTo(String value) {
            addCriterion("total_power_factor <>", value, "totalPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorGreaterThan(String value) {
            addCriterion("total_power_factor >", value, "totalPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorGreaterThanOrEqualTo(String value) {
            addCriterion("total_power_factor >=", value, "totalPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorLessThan(String value) {
            addCriterion("total_power_factor <", value, "totalPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorLessThanOrEqualTo(String value) {
            addCriterion("total_power_factor <=", value, "totalPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorLike(String value) {
            addCriterion("total_power_factor like", value, "totalPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorNotLike(String value) {
            addCriterion("total_power_factor not like", value, "totalPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorIn(List<String> values) {
            addCriterion("total_power_factor in", values, "totalPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorNotIn(List<String> values) {
            addCriterion("total_power_factor not in", values, "totalPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorBetween(String value1, String value2) {
            addCriterion("total_power_factor between", value1, value2, "totalPowerFactor");
            return (Criteria) this;
        }

        public Criteria andTotalPowerFactorNotBetween(String value1, String value2) {
            addCriterion("total_power_factor not between", value1, value2, "totalPowerFactor");
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

        public Criteria andEleboxPowerIsNull() {
            addCriterion("elebox_power is null");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerIsNotNull() {
            addCriterion("elebox_power is not null");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerEqualTo(BigDecimal value) {
            addCriterion("elebox_power =", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerNotEqualTo(BigDecimal value) {
            addCriterion("elebox_power <>", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerGreaterThan(BigDecimal value) {
            addCriterion("elebox_power >", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("elebox_power >=", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerLessThan(BigDecimal value) {
            addCriterion("elebox_power <", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerLessThanOrEqualTo(BigDecimal value) {
            addCriterion("elebox_power <=", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerIn(List<BigDecimal> values) {
            addCriterion("elebox_power in", values, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerNotIn(List<BigDecimal> values) {
            addCriterion("elebox_power not in", values, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("elebox_power between", value1, value2, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("elebox_power not between", value1, value2, "eleboxPower");
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