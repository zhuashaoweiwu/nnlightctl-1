package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlarmHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlarmHistoryExample() {
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

        public Criteria andNnlightctlAlarmIdIsNull() {
            addCriterion("nnlightctl_alarm_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmIdIsNotNull() {
            addCriterion("nnlightctl_alarm_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmIdEqualTo(Long value) {
            addCriterion("nnlightctl_alarm_id =", value, "nnlightctlAlarmId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_alarm_id <>", value, "nnlightctlAlarmId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmIdGreaterThan(Long value) {
            addCriterion("nnlightctl_alarm_id >", value, "nnlightctlAlarmId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_alarm_id >=", value, "nnlightctlAlarmId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmIdLessThan(Long value) {
            addCriterion("nnlightctl_alarm_id <", value, "nnlightctlAlarmId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_alarm_id <=", value, "nnlightctlAlarmId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmIdIn(List<Long> values) {
            addCriterion("nnlightctl_alarm_id in", values, "nnlightctlAlarmId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_alarm_id not in", values, "nnlightctlAlarmId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_alarm_id between", value1, value2, "nnlightctlAlarmId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlAlarmIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_alarm_id not between", value1, value2, "nnlightctlAlarmId");
            return (Criteria) this;
        }

        public Criteria andTerminalIsNull() {
            addCriterion("terminal is null");
            return (Criteria) this;
        }

        public Criteria andTerminalIsNotNull() {
            addCriterion("terminal is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalEqualTo(String value) {
            addCriterion("terminal =", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotEqualTo(String value) {
            addCriterion("terminal <>", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalGreaterThan(String value) {
            addCriterion("terminal >", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalGreaterThanOrEqualTo(String value) {
            addCriterion("terminal >=", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalLessThan(String value) {
            addCriterion("terminal <", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalLessThanOrEqualTo(String value) {
            addCriterion("terminal <=", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalLike(String value) {
            addCriterion("terminal like", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotLike(String value) {
            addCriterion("terminal not like", value, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalIn(List<String> values) {
            addCriterion("terminal in", values, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotIn(List<String> values) {
            addCriterion("terminal not in", values, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalBetween(String value1, String value2) {
            addCriterion("terminal between", value1, value2, "terminal");
            return (Criteria) this;
        }

        public Criteria andTerminalNotBetween(String value1, String value2) {
            addCriterion("terminal not between", value1, value2, "terminal");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelIsNull() {
            addCriterion("alarm_history_channel is null");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelIsNotNull() {
            addCriterion("alarm_history_channel is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelEqualTo(String value) {
            addCriterion("alarm_history_channel =", value, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelNotEqualTo(String value) {
            addCriterion("alarm_history_channel <>", value, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelGreaterThan(String value) {
            addCriterion("alarm_history_channel >", value, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelGreaterThanOrEqualTo(String value) {
            addCriterion("alarm_history_channel >=", value, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelLessThan(String value) {
            addCriterion("alarm_history_channel <", value, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelLessThanOrEqualTo(String value) {
            addCriterion("alarm_history_channel <=", value, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelLike(String value) {
            addCriterion("alarm_history_channel like", value, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelNotLike(String value) {
            addCriterion("alarm_history_channel not like", value, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelIn(List<String> values) {
            addCriterion("alarm_history_channel in", values, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelNotIn(List<String> values) {
            addCriterion("alarm_history_channel not in", values, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelBetween(String value1, String value2) {
            addCriterion("alarm_history_channel between", value1, value2, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andAlarmHistoryChannelNotBetween(String value1, String value2) {
            addCriterion("alarm_history_channel not between", value1, value2, "alarmHistoryChannel");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNull() {
            addCriterion("record_time is null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIsNotNull() {
            addCriterion("record_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTimeEqualTo(Date value) {
            addCriterion("record_time =", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotEqualTo(Date value) {
            addCriterion("record_time <>", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThan(Date value) {
            addCriterion("record_time >", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("record_time >=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThan(Date value) {
            addCriterion("record_time <", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeLessThanOrEqualTo(Date value) {
            addCriterion("record_time <=", value, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeIn(List<Date> values) {
            addCriterion("record_time in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotIn(List<Date> values) {
            addCriterion("record_time not in", values, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeBetween(Date value1, Date value2) {
            addCriterion("record_time between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andRecordTimeNotBetween(Date value1, Date value2) {
            addCriterion("record_time not between", value1, value2, "recordTime");
            return (Criteria) this;
        }

        public Criteria andMemIsNull() {
            addCriterion("mem is null");
            return (Criteria) this;
        }

        public Criteria andMemIsNotNull() {
            addCriterion("mem is not null");
            return (Criteria) this;
        }

        public Criteria andMemEqualTo(String value) {
            addCriterion("mem =", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotEqualTo(String value) {
            addCriterion("mem <>", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThan(String value) {
            addCriterion("mem >", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThanOrEqualTo(String value) {
            addCriterion("mem >=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThan(String value) {
            addCriterion("mem <", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThanOrEqualTo(String value) {
            addCriterion("mem <=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLike(String value) {
            addCriterion("mem like", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotLike(String value) {
            addCriterion("mem not like", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemIn(List<String> values) {
            addCriterion("mem in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotIn(List<String> values) {
            addCriterion("mem not in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemBetween(String value1, String value2) {
            addCriterion("mem between", value1, value2, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotBetween(String value1, String value2) {
            addCriterion("mem not between", value1, value2, "mem");
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