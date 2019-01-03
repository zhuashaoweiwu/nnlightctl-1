package com.nnlightctl.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EleboxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EleboxExample() {
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

        public Criteria andNetworkAddrIsNull() {
            addCriterion("network_addr is null");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrIsNotNull() {
            addCriterion("network_addr is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrEqualTo(String value) {
            addCriterion("network_addr =", value, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrNotEqualTo(String value) {
            addCriterion("network_addr <>", value, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrGreaterThan(String value) {
            addCriterion("network_addr >", value, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrGreaterThanOrEqualTo(String value) {
            addCriterion("network_addr >=", value, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrLessThan(String value) {
            addCriterion("network_addr <", value, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrLessThanOrEqualTo(String value) {
            addCriterion("network_addr <=", value, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrLike(String value) {
            addCriterion("network_addr like", value, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrNotLike(String value) {
            addCriterion("network_addr not like", value, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrIn(List<String> values) {
            addCriterion("network_addr in", values, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrNotIn(List<String> values) {
            addCriterion("network_addr not in", values, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrBetween(String value1, String value2) {
            addCriterion("network_addr between", value1, value2, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andNetworkAddrNotBetween(String value1, String value2) {
            addCriterion("network_addr not between", value1, value2, "networkAddr");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidIsNull() {
            addCriterion("realtime_uid is null");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidIsNotNull() {
            addCriterion("realtime_uid is not null");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidEqualTo(String value) {
            addCriterion("realtime_uid =", value, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidNotEqualTo(String value) {
            addCriterion("realtime_uid <>", value, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidGreaterThan(String value) {
            addCriterion("realtime_uid >", value, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidGreaterThanOrEqualTo(String value) {
            addCriterion("realtime_uid >=", value, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidLessThan(String value) {
            addCriterion("realtime_uid <", value, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidLessThanOrEqualTo(String value) {
            addCriterion("realtime_uid <=", value, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidLike(String value) {
            addCriterion("realtime_uid like", value, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidNotLike(String value) {
            addCriterion("realtime_uid not like", value, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidIn(List<String> values) {
            addCriterion("realtime_uid in", values, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidNotIn(List<String> values) {
            addCriterion("realtime_uid not in", values, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidBetween(String value1, String value2) {
            addCriterion("realtime_uid between", value1, value2, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andRealtimeUidNotBetween(String value1, String value2) {
            addCriterion("realtime_uid not between", value1, value2, "realtimeUid");
            return (Criteria) this;
        }

        public Criteria andCodeNumberIsNull() {
            addCriterion("code_number is null");
            return (Criteria) this;
        }

        public Criteria andCodeNumberIsNotNull() {
            addCriterion("code_number is not null");
            return (Criteria) this;
        }

        public Criteria andCodeNumberEqualTo(String value) {
            addCriterion("code_number =", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberNotEqualTo(String value) {
            addCriterion("code_number <>", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberGreaterThan(String value) {
            addCriterion("code_number >", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("code_number >=", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberLessThan(String value) {
            addCriterion("code_number <", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberLessThanOrEqualTo(String value) {
            addCriterion("code_number <=", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberLike(String value) {
            addCriterion("code_number like", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberNotLike(String value) {
            addCriterion("code_number not like", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberIn(List<String> values) {
            addCriterion("code_number in", values, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberNotIn(List<String> values) {
            addCriterion("code_number not in", values, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberBetween(String value1, String value2) {
            addCriterion("code_number between", value1, value2, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberNotBetween(String value1, String value2) {
            addCriterion("code_number not between", value1, value2, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andManufactureIsNull() {
            addCriterion("manufacture is null");
            return (Criteria) this;
        }

        public Criteria andManufactureIsNotNull() {
            addCriterion("manufacture is not null");
            return (Criteria) this;
        }

        public Criteria andManufactureEqualTo(Date value) {
            addCriterion("manufacture =", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureNotEqualTo(Date value) {
            addCriterion("manufacture <>", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureGreaterThan(Date value) {
            addCriterion("manufacture >", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureGreaterThanOrEqualTo(Date value) {
            addCriterion("manufacture >=", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureLessThan(Date value) {
            addCriterion("manufacture <", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureLessThanOrEqualTo(Date value) {
            addCriterion("manufacture <=", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureIn(List<Date> values) {
            addCriterion("manufacture in", values, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureNotIn(List<Date> values) {
            addCriterion("manufacture not in", values, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureBetween(Date value1, Date value2) {
            addCriterion("manufacture between", value1, value2, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureNotBetween(Date value1, Date value2) {
            addCriterion("manufacture not between", value1, value2, "manufacture");
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

        public Criteria andUseDateIsNull() {
            addCriterion("use_date is null");
            return (Criteria) this;
        }

        public Criteria andUseDateIsNotNull() {
            addCriterion("use_date is not null");
            return (Criteria) this;
        }

        public Criteria andUseDateEqualTo(Date value) {
            addCriterion("use_date =", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateNotEqualTo(Date value) {
            addCriterion("use_date <>", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateGreaterThan(Date value) {
            addCriterion("use_date >", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("use_date >=", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateLessThan(Date value) {
            addCriterion("use_date <", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateLessThanOrEqualTo(Date value) {
            addCriterion("use_date <=", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateIn(List<Date> values) {
            addCriterion("use_date in", values, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateNotIn(List<Date> values) {
            addCriterion("use_date not in", values, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateBetween(Date value1, Date value2) {
            addCriterion("use_date between", value1, value2, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateNotBetween(Date value1, Date value2) {
            addCriterion("use_date not between", value1, value2, "useDate");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageIsNull() {
            addCriterion("rated_voltage is null");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageIsNotNull() {
            addCriterion("rated_voltage is not null");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageEqualTo(BigDecimal value) {
            addCriterion("rated_voltage =", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageNotEqualTo(BigDecimal value) {
            addCriterion("rated_voltage <>", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageGreaterThan(BigDecimal value) {
            addCriterion("rated_voltage >", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rated_voltage >=", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageLessThan(BigDecimal value) {
            addCriterion("rated_voltage <", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rated_voltage <=", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageIn(List<BigDecimal> values) {
            addCriterion("rated_voltage in", values, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageNotIn(List<BigDecimal> values) {
            addCriterion("rated_voltage not in", values, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rated_voltage between", value1, value2, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rated_voltage not between", value1, value2, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyIsNull() {
            addCriterion("rated_electricty is null");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyIsNotNull() {
            addCriterion("rated_electricty is not null");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyEqualTo(BigDecimal value) {
            addCriterion("rated_electricty =", value, "ratedElectricty");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyNotEqualTo(BigDecimal value) {
            addCriterion("rated_electricty <>", value, "ratedElectricty");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyGreaterThan(BigDecimal value) {
            addCriterion("rated_electricty >", value, "ratedElectricty");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rated_electricty >=", value, "ratedElectricty");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyLessThan(BigDecimal value) {
            addCriterion("rated_electricty <", value, "ratedElectricty");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rated_electricty <=", value, "ratedElectricty");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyIn(List<BigDecimal> values) {
            addCriterion("rated_electricty in", values, "ratedElectricty");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyNotIn(List<BigDecimal> values) {
            addCriterion("rated_electricty not in", values, "ratedElectricty");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rated_electricty between", value1, value2, "ratedElectricty");
            return (Criteria) this;
        }

        public Criteria andRatedElectrictyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rated_electricty not between", value1, value2, "ratedElectricty");
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

        public Criteria andMaxUseTimeIsNull() {
            addCriterion("max_use_time is null");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeIsNotNull() {
            addCriterion("max_use_time is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeEqualTo(Long value) {
            addCriterion("max_use_time =", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeNotEqualTo(Long value) {
            addCriterion("max_use_time <>", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeGreaterThan(Long value) {
            addCriterion("max_use_time >", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("max_use_time >=", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeLessThan(Long value) {
            addCriterion("max_use_time <", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeLessThanOrEqualTo(Long value) {
            addCriterion("max_use_time <=", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeIn(List<Long> values) {
            addCriterion("max_use_time in", values, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeNotIn(List<Long> values) {
            addCriterion("max_use_time not in", values, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeBetween(Long value1, Long value2) {
            addCriterion("max_use_time between", value1, value2, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeNotBetween(Long value1, Long value2) {
            addCriterion("max_use_time not between", value1, value2, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andSpdIsNull() {
            addCriterion("spd is null");
            return (Criteria) this;
        }

        public Criteria andSpdIsNotNull() {
            addCriterion("spd is not null");
            return (Criteria) this;
        }

        public Criteria andSpdEqualTo(String value) {
            addCriterion("spd =", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdNotEqualTo(String value) {
            addCriterion("spd <>", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdGreaterThan(String value) {
            addCriterion("spd >", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdGreaterThanOrEqualTo(String value) {
            addCriterion("spd >=", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdLessThan(String value) {
            addCriterion("spd <", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdLessThanOrEqualTo(String value) {
            addCriterion("spd <=", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdLike(String value) {
            addCriterion("spd like", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdNotLike(String value) {
            addCriterion("spd not like", value, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdIn(List<String> values) {
            addCriterion("spd in", values, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdNotIn(List<String> values) {
            addCriterion("spd not in", values, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdBetween(String value1, String value2) {
            addCriterion("spd between", value1, value2, "spd");
            return (Criteria) this;
        }

        public Criteria andSpdNotBetween(String value1, String value2) {
            addCriterion("spd not between", value1, value2, "spd");
            return (Criteria) this;
        }

        public Criteria andModbusEmIsNull() {
            addCriterion("modbus_EM is null");
            return (Criteria) this;
        }

        public Criteria andModbusEmIsNotNull() {
            addCriterion("modbus_EM is not null");
            return (Criteria) this;
        }

        public Criteria andModbusEmEqualTo(String value) {
            addCriterion("modbus_EM =", value, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andModbusEmNotEqualTo(String value) {
            addCriterion("modbus_EM <>", value, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andModbusEmGreaterThan(String value) {
            addCriterion("modbus_EM >", value, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andModbusEmGreaterThanOrEqualTo(String value) {
            addCriterion("modbus_EM >=", value, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andModbusEmLessThan(String value) {
            addCriterion("modbus_EM <", value, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andModbusEmLessThanOrEqualTo(String value) {
            addCriterion("modbus_EM <=", value, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andModbusEmLike(String value) {
            addCriterion("modbus_EM like", value, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andModbusEmNotLike(String value) {
            addCriterion("modbus_EM not like", value, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andModbusEmIn(List<String> values) {
            addCriterion("modbus_EM in", values, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andModbusEmNotIn(List<String> values) {
            addCriterion("modbus_EM not in", values, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andModbusEmBetween(String value1, String value2) {
            addCriterion("modbus_EM between", value1, value2, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andModbusEmNotBetween(String value1, String value2) {
            addCriterion("modbus_EM not between", value1, value2, "modbusEm");
            return (Criteria) this;
        }

        public Criteria andMainSwitchIsNull() {
            addCriterion("main_switch is null");
            return (Criteria) this;
        }

        public Criteria andMainSwitchIsNotNull() {
            addCriterion("main_switch is not null");
            return (Criteria) this;
        }

        public Criteria andMainSwitchEqualTo(String value) {
            addCriterion("main_switch =", value, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andMainSwitchNotEqualTo(String value) {
            addCriterion("main_switch <>", value, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andMainSwitchGreaterThan(String value) {
            addCriterion("main_switch >", value, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andMainSwitchGreaterThanOrEqualTo(String value) {
            addCriterion("main_switch >=", value, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andMainSwitchLessThan(String value) {
            addCriterion("main_switch <", value, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andMainSwitchLessThanOrEqualTo(String value) {
            addCriterion("main_switch <=", value, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andMainSwitchLike(String value) {
            addCriterion("main_switch like", value, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andMainSwitchNotLike(String value) {
            addCriterion("main_switch not like", value, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andMainSwitchIn(List<String> values) {
            addCriterion("main_switch in", values, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andMainSwitchNotIn(List<String> values) {
            addCriterion("main_switch not in", values, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andMainSwitchBetween(String value1, String value2) {
            addCriterion("main_switch between", value1, value2, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andMainSwitchNotBetween(String value1, String value2) {
            addCriterion("main_switch not between", value1, value2, "mainSwitch");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdIsNull() {
            addCriterion("nnlightctl_elebox_gis_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdIsNotNull() {
            addCriterion("nnlightctl_elebox_gis_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_gis_id =", value, "nnlightctlEleboxGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_gis_id <>", value, "nnlightctlEleboxGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdGreaterThan(Long value) {
            addCriterion("nnlightctl_elebox_gis_id >", value, "nnlightctlEleboxGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_gis_id >=", value, "nnlightctlEleboxGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdLessThan(Long value) {
            addCriterion("nnlightctl_elebox_gis_id <", value, "nnlightctlEleboxGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_gis_id <=", value, "nnlightctlEleboxGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdIn(List<Long> values) {
            addCriterion("nnlightctl_elebox_gis_id in", values, "nnlightctlEleboxGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_elebox_gis_id not in", values, "nnlightctlEleboxGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_elebox_gis_id between", value1, value2, "nnlightctlEleboxGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxGisIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_elebox_gis_id not between", value1, value2, "nnlightctlEleboxGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdIsNull() {
            addCriterion("nnlightctl_region_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdIsNotNull() {
            addCriterion("nnlightctl_region_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdEqualTo(Long value) {
            addCriterion("nnlightctl_region_id =", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_region_id <>", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdGreaterThan(Long value) {
            addCriterion("nnlightctl_region_id >", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_region_id >=", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdLessThan(Long value) {
            addCriterion("nnlightctl_region_id <", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_region_id <=", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdIn(List<Long> values) {
            addCriterion("nnlightctl_region_id in", values, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_region_id not in", values, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_region_id between", value1, value2, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_region_id not between", value1, value2, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdIsNull() {
            addCriterion("nnlightctl_project_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdIsNotNull() {
            addCriterion("nnlightctl_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdEqualTo(Long value) {
            addCriterion("nnlightctl_project_id =", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_project_id <>", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdGreaterThan(Long value) {
            addCriterion("nnlightctl_project_id >", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_project_id >=", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdLessThan(Long value) {
            addCriterion("nnlightctl_project_id <", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_project_id <=", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdIn(List<Long> values) {
            addCriterion("nnlightctl_project_id in", values, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_project_id not in", values, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_project_id between", value1, value2, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_project_id not between", value1, value2, "nnlightctlProjectId");
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