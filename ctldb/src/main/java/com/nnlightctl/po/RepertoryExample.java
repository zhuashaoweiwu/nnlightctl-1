package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepertoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepertoryExample() {
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

        public Criteria andRepertoryNameIsNull() {
            addCriterion("repertory_name is null");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameIsNotNull() {
            addCriterion("repertory_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameEqualTo(String value) {
            addCriterion("repertory_name =", value, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameNotEqualTo(String value) {
            addCriterion("repertory_name <>", value, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameGreaterThan(String value) {
            addCriterion("repertory_name >", value, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("repertory_name >=", value, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameLessThan(String value) {
            addCriterion("repertory_name <", value, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameLessThanOrEqualTo(String value) {
            addCriterion("repertory_name <=", value, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameLike(String value) {
            addCriterion("repertory_name like", value, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameNotLike(String value) {
            addCriterion("repertory_name not like", value, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameIn(List<String> values) {
            addCriterion("repertory_name in", values, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameNotIn(List<String> values) {
            addCriterion("repertory_name not in", values, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameBetween(String value1, String value2) {
            addCriterion("repertory_name between", value1, value2, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryNameNotBetween(String value1, String value2) {
            addCriterion("repertory_name not between", value1, value2, "repertoryName");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressIsNull() {
            addCriterion("repertory_address is null");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressIsNotNull() {
            addCriterion("repertory_address is not null");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressEqualTo(String value) {
            addCriterion("repertory_address =", value, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressNotEqualTo(String value) {
            addCriterion("repertory_address <>", value, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressGreaterThan(String value) {
            addCriterion("repertory_address >", value, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("repertory_address >=", value, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressLessThan(String value) {
            addCriterion("repertory_address <", value, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressLessThanOrEqualTo(String value) {
            addCriterion("repertory_address <=", value, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressLike(String value) {
            addCriterion("repertory_address like", value, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressNotLike(String value) {
            addCriterion("repertory_address not like", value, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressIn(List<String> values) {
            addCriterion("repertory_address in", values, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressNotIn(List<String> values) {
            addCriterion("repertory_address not in", values, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressBetween(String value1, String value2) {
            addCriterion("repertory_address between", value1, value2, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryAddressNotBetween(String value1, String value2) {
            addCriterion("repertory_address not between", value1, value2, "repertoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneIsNull() {
            addCriterion("repertory_phone is null");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneIsNotNull() {
            addCriterion("repertory_phone is not null");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneEqualTo(String value) {
            addCriterion("repertory_phone =", value, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneNotEqualTo(String value) {
            addCriterion("repertory_phone <>", value, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneGreaterThan(String value) {
            addCriterion("repertory_phone >", value, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("repertory_phone >=", value, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneLessThan(String value) {
            addCriterion("repertory_phone <", value, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneLessThanOrEqualTo(String value) {
            addCriterion("repertory_phone <=", value, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneLike(String value) {
            addCriterion("repertory_phone like", value, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneNotLike(String value) {
            addCriterion("repertory_phone not like", value, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneIn(List<String> values) {
            addCriterion("repertory_phone in", values, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneNotIn(List<String> values) {
            addCriterion("repertory_phone not in", values, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneBetween(String value1, String value2) {
            addCriterion("repertory_phone between", value1, value2, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryPhoneNotBetween(String value1, String value2) {
            addCriterion("repertory_phone not between", value1, value2, "repertoryPhone");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeIsNull() {
            addCriterion("repertory_zip_code is null");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeIsNotNull() {
            addCriterion("repertory_zip_code is not null");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeEqualTo(String value) {
            addCriterion("repertory_zip_code =", value, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeNotEqualTo(String value) {
            addCriterion("repertory_zip_code <>", value, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeGreaterThan(String value) {
            addCriterion("repertory_zip_code >", value, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("repertory_zip_code >=", value, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeLessThan(String value) {
            addCriterion("repertory_zip_code <", value, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeLessThanOrEqualTo(String value) {
            addCriterion("repertory_zip_code <=", value, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeLike(String value) {
            addCriterion("repertory_zip_code like", value, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeNotLike(String value) {
            addCriterion("repertory_zip_code not like", value, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeIn(List<String> values) {
            addCriterion("repertory_zip_code in", values, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeNotIn(List<String> values) {
            addCriterion("repertory_zip_code not in", values, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeBetween(String value1, String value2) {
            addCriterion("repertory_zip_code between", value1, value2, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andRepertoryZipCodeNotBetween(String value1, String value2) {
            addCriterion("repertory_zip_code not between", value1, value2, "repertoryZipCode");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdIsNull() {
            addCriterion("nnlightctl_user_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdIsNotNull() {
            addCriterion("nnlightctl_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdEqualTo(Long value) {
            addCriterion("nnlightctl_user_id =", value, "nnlightctlUserId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_user_id <>", value, "nnlightctlUserId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdGreaterThan(Long value) {
            addCriterion("nnlightctl_user_id >", value, "nnlightctlUserId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_user_id >=", value, "nnlightctlUserId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdLessThan(Long value) {
            addCriterion("nnlightctl_user_id <", value, "nnlightctlUserId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_user_id <=", value, "nnlightctlUserId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdIn(List<Long> values) {
            addCriterion("nnlightctl_user_id in", values, "nnlightctlUserId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_user_id not in", values, "nnlightctlUserId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_user_id between", value1, value2, "nnlightctlUserId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_user_id not between", value1, value2, "nnlightctlUserId");
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