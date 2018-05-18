package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlarmConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlarmConfigExample() {
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

        public Criteria andAlarmConfigLevelIsNull() {
            addCriterion("alarm_config_level is null");
            return (Criteria) this;
        }

        public Criteria andAlarmConfigLevelIsNotNull() {
            addCriterion("alarm_config_level is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmConfigLevelEqualTo(Byte value) {
            addCriterion("alarm_config_level =", value, "alarmConfigLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmConfigLevelNotEqualTo(Byte value) {
            addCriterion("alarm_config_level <>", value, "alarmConfigLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmConfigLevelGreaterThan(Byte value) {
            addCriterion("alarm_config_level >", value, "alarmConfigLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmConfigLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("alarm_config_level >=", value, "alarmConfigLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmConfigLevelLessThan(Byte value) {
            addCriterion("alarm_config_level <", value, "alarmConfigLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmConfigLevelLessThanOrEqualTo(Byte value) {
            addCriterion("alarm_config_level <=", value, "alarmConfigLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmConfigLevelIn(List<Byte> values) {
            addCriterion("alarm_config_level in", values, "alarmConfigLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmConfigLevelNotIn(List<Byte> values) {
            addCriterion("alarm_config_level not in", values, "alarmConfigLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmConfigLevelBetween(Byte value1, Byte value2) {
            addCriterion("alarm_config_level between", value1, value2, "alarmConfigLevel");
            return (Criteria) this;
        }

        public Criteria andAlarmConfigLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("alarm_config_level not between", value1, value2, "alarmConfigLevel");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapIsNull() {
            addCriterion("is_notice_map is null");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapIsNotNull() {
            addCriterion("is_notice_map is not null");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapEqualTo(Byte value) {
            addCriterion("is_notice_map =", value, "isNoticeMap");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapNotEqualTo(Byte value) {
            addCriterion("is_notice_map <>", value, "isNoticeMap");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapGreaterThan(Byte value) {
            addCriterion("is_notice_map >", value, "isNoticeMap");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_notice_map >=", value, "isNoticeMap");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapLessThan(Byte value) {
            addCriterion("is_notice_map <", value, "isNoticeMap");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapLessThanOrEqualTo(Byte value) {
            addCriterion("is_notice_map <=", value, "isNoticeMap");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapIn(List<Byte> values) {
            addCriterion("is_notice_map in", values, "isNoticeMap");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapNotIn(List<Byte> values) {
            addCriterion("is_notice_map not in", values, "isNoticeMap");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapBetween(Byte value1, Byte value2) {
            addCriterion("is_notice_map between", value1, value2, "isNoticeMap");
            return (Criteria) this;
        }

        public Criteria andIsNoticeMapNotBetween(Byte value1, Byte value2) {
            addCriterion("is_notice_map not between", value1, value2, "isNoticeMap");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsIsNull() {
            addCriterion("is_notice_sms is null");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsIsNotNull() {
            addCriterion("is_notice_sms is not null");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsEqualTo(Byte value) {
            addCriterion("is_notice_sms =", value, "isNoticeSms");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsNotEqualTo(Byte value) {
            addCriterion("is_notice_sms <>", value, "isNoticeSms");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsGreaterThan(Byte value) {
            addCriterion("is_notice_sms >", value, "isNoticeSms");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_notice_sms >=", value, "isNoticeSms");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsLessThan(Byte value) {
            addCriterion("is_notice_sms <", value, "isNoticeSms");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsLessThanOrEqualTo(Byte value) {
            addCriterion("is_notice_sms <=", value, "isNoticeSms");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsIn(List<Byte> values) {
            addCriterion("is_notice_sms in", values, "isNoticeSms");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsNotIn(List<Byte> values) {
            addCriterion("is_notice_sms not in", values, "isNoticeSms");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsBetween(Byte value1, Byte value2) {
            addCriterion("is_notice_sms between", value1, value2, "isNoticeSms");
            return (Criteria) this;
        }

        public Criteria andIsNoticeSmsNotBetween(Byte value1, Byte value2) {
            addCriterion("is_notice_sms not between", value1, value2, "isNoticeSms");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailIsNull() {
            addCriterion("is_notice_email is null");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailIsNotNull() {
            addCriterion("is_notice_email is not null");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailEqualTo(Byte value) {
            addCriterion("is_notice_email =", value, "isNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailNotEqualTo(Byte value) {
            addCriterion("is_notice_email <>", value, "isNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailGreaterThan(Byte value) {
            addCriterion("is_notice_email >", value, "isNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_notice_email >=", value, "isNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailLessThan(Byte value) {
            addCriterion("is_notice_email <", value, "isNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailLessThanOrEqualTo(Byte value) {
            addCriterion("is_notice_email <=", value, "isNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailIn(List<Byte> values) {
            addCriterion("is_notice_email in", values, "isNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailNotIn(List<Byte> values) {
            addCriterion("is_notice_email not in", values, "isNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailBetween(Byte value1, Byte value2) {
            addCriterion("is_notice_email between", value1, value2, "isNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEmailNotBetween(Byte value1, Byte value2) {
            addCriterion("is_notice_email not between", value1, value2, "isNoticeEmail");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinIsNull() {
            addCriterion("is_notice_weixin is null");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinIsNotNull() {
            addCriterion("is_notice_weixin is not null");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinEqualTo(Byte value) {
            addCriterion("is_notice_weixin =", value, "isNoticeWeixin");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinNotEqualTo(Byte value) {
            addCriterion("is_notice_weixin <>", value, "isNoticeWeixin");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinGreaterThan(Byte value) {
            addCriterion("is_notice_weixin >", value, "isNoticeWeixin");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_notice_weixin >=", value, "isNoticeWeixin");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinLessThan(Byte value) {
            addCriterion("is_notice_weixin <", value, "isNoticeWeixin");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinLessThanOrEqualTo(Byte value) {
            addCriterion("is_notice_weixin <=", value, "isNoticeWeixin");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinIn(List<Byte> values) {
            addCriterion("is_notice_weixin in", values, "isNoticeWeixin");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinNotIn(List<Byte> values) {
            addCriterion("is_notice_weixin not in", values, "isNoticeWeixin");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinBetween(Byte value1, Byte value2) {
            addCriterion("is_notice_weixin between", value1, value2, "isNoticeWeixin");
            return (Criteria) this;
        }

        public Criteria andIsNoticeWeixinNotBetween(Byte value1, Byte value2) {
            addCriterion("is_notice_weixin not between", value1, value2, "isNoticeWeixin");
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