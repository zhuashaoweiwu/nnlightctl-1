package com.nnlightctl.po;

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

        public Criteria andVoltageEqualTo(Long value) {
            addCriterion("voltage =", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotEqualTo(Long value) {
            addCriterion("voltage <>", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThan(Long value) {
            addCriterion("voltage >", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThanOrEqualTo(Long value) {
            addCriterion("voltage >=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThan(Long value) {
            addCriterion("voltage <", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThanOrEqualTo(Long value) {
            addCriterion("voltage <=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageIn(List<Long> values) {
            addCriterion("voltage in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotIn(List<Long> values) {
            addCriterion("voltage not in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageBetween(Long value1, Long value2) {
            addCriterion("voltage between", value1, value2, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotBetween(Long value1, Long value2) {
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

        public Criteria andElectricityEqualTo(Long value) {
            addCriterion("electricity =", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotEqualTo(Long value) {
            addCriterion("electricity <>", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThan(Long value) {
            addCriterion("electricity >", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThanOrEqualTo(Long value) {
            addCriterion("electricity >=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThan(Long value) {
            addCriterion("electricity <", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThanOrEqualTo(Long value) {
            addCriterion("electricity <=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityIn(List<Long> values) {
            addCriterion("electricity in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotIn(List<Long> values) {
            addCriterion("electricity not in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityBetween(Long value1, Long value2) {
            addCriterion("electricity between", value1, value2, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotBetween(Long value1, Long value2) {
            addCriterion("electricity not between", value1, value2, "electricity");
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

        public Criteria andEleboxPowerEqualTo(Long value) {
            addCriterion("elebox_power =", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerNotEqualTo(Long value) {
            addCriterion("elebox_power <>", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerGreaterThan(Long value) {
            addCriterion("elebox_power >", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerGreaterThanOrEqualTo(Long value) {
            addCriterion("elebox_power >=", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerLessThan(Long value) {
            addCriterion("elebox_power <", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerLessThanOrEqualTo(Long value) {
            addCriterion("elebox_power <=", value, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerIn(List<Long> values) {
            addCriterion("elebox_power in", values, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerNotIn(List<Long> values) {
            addCriterion("elebox_power not in", values, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerBetween(Long value1, Long value2) {
            addCriterion("elebox_power between", value1, value2, "eleboxPower");
            return (Criteria) this;
        }

        public Criteria andEleboxPowerNotBetween(Long value1, Long value2) {
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