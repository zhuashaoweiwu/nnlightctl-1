package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlarmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlarmExample() {
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

        public Criteria andAlarmSourceIsNull() {
            addCriterion("alarm_source is null");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceIsNotNull() {
            addCriterion("alarm_source is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceEqualTo(String value) {
            addCriterion("alarm_source =", value, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceNotEqualTo(String value) {
            addCriterion("alarm_source <>", value, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceGreaterThan(String value) {
            addCriterion("alarm_source >", value, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_source >=", value, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceLessThan(String value) {
            addCriterion("alarm_source <", value, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceLessThanOrEqualTo(String value) {
            addCriterion("alarm_source <=", value, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceLike(String value) {
            addCriterion("alarm_source like", value, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceNotLike(String value) {
            addCriterion("alarm_source not like", value, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceIn(List<String> values) {
            addCriterion("alarm_source in", values, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceNotIn(List<String> values) {
            addCriterion("alarm_source not in", values, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceBetween(String value1, String value2) {
            addCriterion("alarm_source between", value1, value2, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmSourceNotBetween(String value1, String value2) {
            addCriterion("alarm_source not between", value1, value2, "alarmSource");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIsNull() {
            addCriterion("alarm_level is null");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIsNotNull() {
            addCriterion("alarm_level is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelEqualTo(Byte value) {
            addCriterion("alarm_level =", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotEqualTo(Byte value) {
            addCriterion("alarm_level <>", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelGreaterThan(Byte value) {
            addCriterion("alarm_level >", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("alarm_level >=", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelLessThan(Byte value) {
            addCriterion("alarm_level <", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelLessThanOrEqualTo(Byte value) {
            addCriterion("alarm_level <=", value, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelIn(List<Byte> values) {
            addCriterion("alarm_level in", values, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotIn(List<Byte> values) {
            addCriterion("alarm_level not in", values, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelBetween(Byte value1, Byte value2) {
            addCriterion("alarm_level between", value1, value2, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("alarm_level not between", value1, value2, "alarmLevel");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCtypeIsNull() {
            addCriterion("ctype is null");
            return (Criteria) this;
        }

        public Criteria andCtypeIsNotNull() {
            addCriterion("ctype is not null");
            return (Criteria) this;
        }

        public Criteria andCtypeEqualTo(Byte value) {
            addCriterion("ctype =", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotEqualTo(Byte value) {
            addCriterion("ctype <>", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeGreaterThan(Byte value) {
            addCriterion("ctype >", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("ctype >=", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLessThan(Byte value) {
            addCriterion("ctype <", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeLessThanOrEqualTo(Byte value) {
            addCriterion("ctype <=", value, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeIn(List<Byte> values) {
            addCriterion("ctype in", values, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotIn(List<Byte> values) {
            addCriterion("ctype not in", values, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeBetween(Byte value1, Byte value2) {
            addCriterion("ctype between", value1, value2, "ctype");
            return (Criteria) this;
        }

        public Criteria andCtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("ctype not between", value1, value2, "ctype");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIsNull() {
            addCriterion("alarm_time is null");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIsNotNull() {
            addCriterion("alarm_time is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeEqualTo(Date value) {
            addCriterion("alarm_time =", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotEqualTo(Date value) {
            addCriterion("alarm_time <>", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeGreaterThan(Date value) {
            addCriterion("alarm_time >", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("alarm_time >=", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeLessThan(Date value) {
            addCriterion("alarm_time <", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeLessThanOrEqualTo(Date value) {
            addCriterion("alarm_time <=", value, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeIn(List<Date> values) {
            addCriterion("alarm_time in", values, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotIn(List<Date> values) {
            addCriterion("alarm_time not in", values, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeBetween(Date value1, Date value2) {
            addCriterion("alarm_time between", value1, value2, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andAlarmTimeNotBetween(Date value1, Date value2) {
            addCriterion("alarm_time not between", value1, value2, "alarmTime");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeIsNull() {
            addCriterion("remove_alarm_time is null");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeIsNotNull() {
            addCriterion("remove_alarm_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeEqualTo(Date value) {
            addCriterion("remove_alarm_time =", value, "removeAlarmTime");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeNotEqualTo(Date value) {
            addCriterion("remove_alarm_time <>", value, "removeAlarmTime");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeGreaterThan(Date value) {
            addCriterion("remove_alarm_time >", value, "removeAlarmTime");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("remove_alarm_time >=", value, "removeAlarmTime");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeLessThan(Date value) {
            addCriterion("remove_alarm_time <", value, "removeAlarmTime");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeLessThanOrEqualTo(Date value) {
            addCriterion("remove_alarm_time <=", value, "removeAlarmTime");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeIn(List<Date> values) {
            addCriterion("remove_alarm_time in", values, "removeAlarmTime");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeNotIn(List<Date> values) {
            addCriterion("remove_alarm_time not in", values, "removeAlarmTime");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeBetween(Date value1, Date value2) {
            addCriterion("remove_alarm_time between", value1, value2, "removeAlarmTime");
            return (Criteria) this;
        }

        public Criteria andRemoveAlarmTimeNotBetween(Date value1, Date value2) {
            addCriterion("remove_alarm_time not between", value1, value2, "removeAlarmTime");
            return (Criteria) this;
        }

        public Criteria andMsgIsNull() {
            addCriterion("msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("msg not between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andAlarmCountIsNull() {
            addCriterion("alarm_count is null");
            return (Criteria) this;
        }

        public Criteria andAlarmCountIsNotNull() {
            addCriterion("alarm_count is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmCountEqualTo(Long value) {
            addCriterion("alarm_count =", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountNotEqualTo(Long value) {
            addCriterion("alarm_count <>", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountGreaterThan(Long value) {
            addCriterion("alarm_count >", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountGreaterThanOrEqualTo(Long value) {
            addCriterion("alarm_count >=", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountLessThan(Long value) {
            addCriterion("alarm_count <", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountLessThanOrEqualTo(Long value) {
            addCriterion("alarm_count <=", value, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountIn(List<Long> values) {
            addCriterion("alarm_count in", values, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountNotIn(List<Long> values) {
            addCriterion("alarm_count not in", values, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountBetween(Long value1, Long value2) {
            addCriterion("alarm_count between", value1, value2, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andAlarmCountNotBetween(Long value1, Long value2) {
            addCriterion("alarm_count not between", value1, value2, "alarmCount");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdIsNull() {
            addCriterion("nnlightctl_alarm_config_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdIsNotNull() {
            addCriterion("nnlightctl_alarm_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdEqualTo(Long value) {
            addCriterion("nnlightctl_alarm_config_id =", value, "nnlightctlAlarmConfigId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_alarm_config_id <>", value, "nnlightctlAlarmConfigId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdGreaterThan(Long value) {
            addCriterion("nnlightctl_alarm_config_id >", value, "nnlightctlAlarmConfigId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_alarm_config_id >=", value, "nnlightctlAlarmConfigId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdLessThan(Long value) {
            addCriterion("nnlightctl_alarm_config_id <", value, "nnlightctlAlarmConfigId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_alarm_config_id <=", value, "nnlightctlAlarmConfigId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdIn(List<Long> values) {
            addCriterion("nnlightctl_alarm_config_id in", values, "nnlightctlAlarmConfigId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_alarm_config_id not in", values, "nnlightctlAlarmConfigId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_alarm_config_id between", value1, value2, "nnlightctlAlarmConfigId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmConfigIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_alarm_config_id not between", value1, value2, "nnlightctlAlarmConfigId");
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