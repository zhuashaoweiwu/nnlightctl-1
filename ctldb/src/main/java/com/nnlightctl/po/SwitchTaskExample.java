package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SwitchTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SwitchTaskExample() {
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

        public Criteria andSwitchNameIsNull() {
            addCriterion("switch_name is null");
            return (Criteria) this;
        }

        public Criteria andSwitchNameIsNotNull() {
            addCriterion("switch_name is not null");
            return (Criteria) this;
        }

        public Criteria andSwitchNameEqualTo(String value) {
            addCriterion("switch_name =", value, "switchName");
            return (Criteria) this;
        }

        public Criteria andSwitchNameNotEqualTo(String value) {
            addCriterion("switch_name <>", value, "switchName");
            return (Criteria) this;
        }

        public Criteria andSwitchNameGreaterThan(String value) {
            addCriterion("switch_name >", value, "switchName");
            return (Criteria) this;
        }

        public Criteria andSwitchNameGreaterThanOrEqualTo(String value) {
            addCriterion("switch_name >=", value, "switchName");
            return (Criteria) this;
        }

        public Criteria andSwitchNameLessThan(String value) {
            addCriterion("switch_name <", value, "switchName");
            return (Criteria) this;
        }

        public Criteria andSwitchNameLessThanOrEqualTo(String value) {
            addCriterion("switch_name <=", value, "switchName");
            return (Criteria) this;
        }

        public Criteria andSwitchNameLike(String value) {
            addCriterion("switch_name like", value, "switchName");
            return (Criteria) this;
        }

        public Criteria andSwitchNameNotLike(String value) {
            addCriterion("switch_name not like", value, "switchName");
            return (Criteria) this;
        }

        public Criteria andSwitchNameIn(List<String> values) {
            addCriterion("switch_name in", values, "switchName");
            return (Criteria) this;
        }

        public Criteria andSwitchNameNotIn(List<String> values) {
            addCriterion("switch_name not in", values, "switchName");
            return (Criteria) this;
        }

        public Criteria andSwitchNameBetween(String value1, String value2) {
            addCriterion("switch_name between", value1, value2, "switchName");
            return (Criteria) this;
        }

        public Criteria andSwitchNameNotBetween(String value1, String value2) {
            addCriterion("switch_name not between", value1, value2, "switchName");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andIsLightonIsNull() {
            addCriterion("is_lighton is null");
            return (Criteria) this;
        }

        public Criteria andIsLightonIsNotNull() {
            addCriterion("is_lighton is not null");
            return (Criteria) this;
        }

        public Criteria andIsLightonEqualTo(Byte value) {
            addCriterion("is_lighton =", value, "isLighton");
            return (Criteria) this;
        }

        public Criteria andIsLightonNotEqualTo(Byte value) {
            addCriterion("is_lighton <>", value, "isLighton");
            return (Criteria) this;
        }

        public Criteria andIsLightonGreaterThan(Byte value) {
            addCriterion("is_lighton >", value, "isLighton");
            return (Criteria) this;
        }

        public Criteria andIsLightonGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_lighton >=", value, "isLighton");
            return (Criteria) this;
        }

        public Criteria andIsLightonLessThan(Byte value) {
            addCriterion("is_lighton <", value, "isLighton");
            return (Criteria) this;
        }

        public Criteria andIsLightonLessThanOrEqualTo(Byte value) {
            addCriterion("is_lighton <=", value, "isLighton");
            return (Criteria) this;
        }

        public Criteria andIsLightonIn(List<Byte> values) {
            addCriterion("is_lighton in", values, "isLighton");
            return (Criteria) this;
        }

        public Criteria andIsLightonNotIn(List<Byte> values) {
            addCriterion("is_lighton not in", values, "isLighton");
            return (Criteria) this;
        }

        public Criteria andIsLightonBetween(Byte value1, Byte value2) {
            addCriterion("is_lighton between", value1, value2, "isLighton");
            return (Criteria) this;
        }

        public Criteria andIsLightonNotBetween(Byte value1, Byte value2) {
            addCriterion("is_lighton not between", value1, value2, "isLighton");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamIsNull() {
            addCriterion("is_usebeam is null");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamIsNotNull() {
            addCriterion("is_usebeam is not null");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamEqualTo(Byte value) {
            addCriterion("is_usebeam =", value, "isUsebeam");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamNotEqualTo(Byte value) {
            addCriterion("is_usebeam <>", value, "isUsebeam");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamGreaterThan(Byte value) {
            addCriterion("is_usebeam >", value, "isUsebeam");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_usebeam >=", value, "isUsebeam");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamLessThan(Byte value) {
            addCriterion("is_usebeam <", value, "isUsebeam");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamLessThanOrEqualTo(Byte value) {
            addCriterion("is_usebeam <=", value, "isUsebeam");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamIn(List<Byte> values) {
            addCriterion("is_usebeam in", values, "isUsebeam");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamNotIn(List<Byte> values) {
            addCriterion("is_usebeam not in", values, "isUsebeam");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamBetween(Byte value1, Byte value2) {
            addCriterion("is_usebeam between", value1, value2, "isUsebeam");
            return (Criteria) this;
        }

        public Criteria andIsUsebeamNotBetween(Byte value1, Byte value2) {
            addCriterion("is_usebeam not between", value1, value2, "isUsebeam");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(Byte value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(Byte value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(Byte value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(Byte value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(Byte value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(Byte value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<Byte> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<Byte> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(Byte value1, Byte value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(Byte value1, Byte value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andLightPercentIsNull() {
            addCriterion("light_percent is null");
            return (Criteria) this;
        }

        public Criteria andLightPercentIsNotNull() {
            addCriterion("light_percent is not null");
            return (Criteria) this;
        }

        public Criteria andLightPercentEqualTo(Byte value) {
            addCriterion("light_percent =", value, "lightPercent");
            return (Criteria) this;
        }

        public Criteria andLightPercentNotEqualTo(Byte value) {
            addCriterion("light_percent <>", value, "lightPercent");
            return (Criteria) this;
        }

        public Criteria andLightPercentGreaterThan(Byte value) {
            addCriterion("light_percent >", value, "lightPercent");
            return (Criteria) this;
        }

        public Criteria andLightPercentGreaterThanOrEqualTo(Byte value) {
            addCriterion("light_percent >=", value, "lightPercent");
            return (Criteria) this;
        }

        public Criteria andLightPercentLessThan(Byte value) {
            addCriterion("light_percent <", value, "lightPercent");
            return (Criteria) this;
        }

        public Criteria andLightPercentLessThanOrEqualTo(Byte value) {
            addCriterion("light_percent <=", value, "lightPercent");
            return (Criteria) this;
        }

        public Criteria andLightPercentIn(List<Byte> values) {
            addCriterion("light_percent in", values, "lightPercent");
            return (Criteria) this;
        }

        public Criteria andLightPercentNotIn(List<Byte> values) {
            addCriterion("light_percent not in", values, "lightPercent");
            return (Criteria) this;
        }

        public Criteria andLightPercentBetween(Byte value1, Byte value2) {
            addCriterion("light_percent between", value1, value2, "lightPercent");
            return (Criteria) this;
        }

        public Criteria andLightPercentNotBetween(Byte value1, Byte value2) {
            addCriterion("light_percent not between", value1, value2, "lightPercent");
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