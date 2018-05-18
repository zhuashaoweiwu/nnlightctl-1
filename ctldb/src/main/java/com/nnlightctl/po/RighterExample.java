package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RighterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RighterExample() {
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

        public Criteria andRighterNameIsNull() {
            addCriterion("righter_name is null");
            return (Criteria) this;
        }

        public Criteria andRighterNameIsNotNull() {
            addCriterion("righter_name is not null");
            return (Criteria) this;
        }

        public Criteria andRighterNameEqualTo(String value) {
            addCriterion("righter_name =", value, "righterName");
            return (Criteria) this;
        }

        public Criteria andRighterNameNotEqualTo(String value) {
            addCriterion("righter_name <>", value, "righterName");
            return (Criteria) this;
        }

        public Criteria andRighterNameGreaterThan(String value) {
            addCriterion("righter_name >", value, "righterName");
            return (Criteria) this;
        }

        public Criteria andRighterNameGreaterThanOrEqualTo(String value) {
            addCriterion("righter_name >=", value, "righterName");
            return (Criteria) this;
        }

        public Criteria andRighterNameLessThan(String value) {
            addCriterion("righter_name <", value, "righterName");
            return (Criteria) this;
        }

        public Criteria andRighterNameLessThanOrEqualTo(String value) {
            addCriterion("righter_name <=", value, "righterName");
            return (Criteria) this;
        }

        public Criteria andRighterNameLike(String value) {
            addCriterion("righter_name like", value, "righterName");
            return (Criteria) this;
        }

        public Criteria andRighterNameNotLike(String value) {
            addCriterion("righter_name not like", value, "righterName");
            return (Criteria) this;
        }

        public Criteria andRighterNameIn(List<String> values) {
            addCriterion("righter_name in", values, "righterName");
            return (Criteria) this;
        }

        public Criteria andRighterNameNotIn(List<String> values) {
            addCriterion("righter_name not in", values, "righterName");
            return (Criteria) this;
        }

        public Criteria andRighterNameBetween(String value1, String value2) {
            addCriterion("righter_name between", value1, value2, "righterName");
            return (Criteria) this;
        }

        public Criteria andRighterNameNotBetween(String value1, String value2) {
            addCriterion("righter_name not between", value1, value2, "righterName");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andRighterLevelIsNull() {
            addCriterion("righter_level is null");
            return (Criteria) this;
        }

        public Criteria andRighterLevelIsNotNull() {
            addCriterion("righter_level is not null");
            return (Criteria) this;
        }

        public Criteria andRighterLevelEqualTo(Byte value) {
            addCriterion("righter_level =", value, "righterLevel");
            return (Criteria) this;
        }

        public Criteria andRighterLevelNotEqualTo(Byte value) {
            addCriterion("righter_level <>", value, "righterLevel");
            return (Criteria) this;
        }

        public Criteria andRighterLevelGreaterThan(Byte value) {
            addCriterion("righter_level >", value, "righterLevel");
            return (Criteria) this;
        }

        public Criteria andRighterLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("righter_level >=", value, "righterLevel");
            return (Criteria) this;
        }

        public Criteria andRighterLevelLessThan(Byte value) {
            addCriterion("righter_level <", value, "righterLevel");
            return (Criteria) this;
        }

        public Criteria andRighterLevelLessThanOrEqualTo(Byte value) {
            addCriterion("righter_level <=", value, "righterLevel");
            return (Criteria) this;
        }

        public Criteria andRighterLevelIn(List<Byte> values) {
            addCriterion("righter_level in", values, "righterLevel");
            return (Criteria) this;
        }

        public Criteria andRighterLevelNotIn(List<Byte> values) {
            addCriterion("righter_level not in", values, "righterLevel");
            return (Criteria) this;
        }

        public Criteria andRighterLevelBetween(Byte value1, Byte value2) {
            addCriterion("righter_level between", value1, value2, "righterLevel");
            return (Criteria) this;
        }

        public Criteria andRighterLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("righter_level not between", value1, value2, "righterLevel");
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