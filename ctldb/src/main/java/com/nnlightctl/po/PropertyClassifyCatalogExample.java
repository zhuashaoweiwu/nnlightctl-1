package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PropertyClassifyCatalogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PropertyClassifyCatalogExample() {
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

        public Criteria andMyCatalogNameIsNull() {
            addCriterion("my_catalog_name is null");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameIsNotNull() {
            addCriterion("my_catalog_name is not null");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameEqualTo(String value) {
            addCriterion("my_catalog_name =", value, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameNotEqualTo(String value) {
            addCriterion("my_catalog_name <>", value, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameGreaterThan(String value) {
            addCriterion("my_catalog_name >", value, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameGreaterThanOrEqualTo(String value) {
            addCriterion("my_catalog_name >=", value, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameLessThan(String value) {
            addCriterion("my_catalog_name <", value, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameLessThanOrEqualTo(String value) {
            addCriterion("my_catalog_name <=", value, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameLike(String value) {
            addCriterion("my_catalog_name like", value, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameNotLike(String value) {
            addCriterion("my_catalog_name not like", value, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameIn(List<String> values) {
            addCriterion("my_catalog_name in", values, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameNotIn(List<String> values) {
            addCriterion("my_catalog_name not in", values, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameBetween(String value1, String value2) {
            addCriterion("my_catalog_name between", value1, value2, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andMyCatalogNameNotBetween(String value1, String value2) {
            addCriterion("my_catalog_name not between", value1, value2, "myCatalogName");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelIsNull() {
            addCriterion("catalog_level is null");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelIsNotNull() {
            addCriterion("catalog_level is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelEqualTo(Byte value) {
            addCriterion("catalog_level =", value, "catalogLevel");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelNotEqualTo(Byte value) {
            addCriterion("catalog_level <>", value, "catalogLevel");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelGreaterThan(Byte value) {
            addCriterion("catalog_level >", value, "catalogLevel");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("catalog_level >=", value, "catalogLevel");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelLessThan(Byte value) {
            addCriterion("catalog_level <", value, "catalogLevel");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelLessThanOrEqualTo(Byte value) {
            addCriterion("catalog_level <=", value, "catalogLevel");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelIn(List<Byte> values) {
            addCriterion("catalog_level in", values, "catalogLevel");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelNotIn(List<Byte> values) {
            addCriterion("catalog_level not in", values, "catalogLevel");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelBetween(Byte value1, Byte value2) {
            addCriterion("catalog_level between", value1, value2, "catalogLevel");
            return (Criteria) this;
        }

        public Criteria andCatalogLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("catalog_level not between", value1, value2, "catalogLevel");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdIsNull() {
            addCriterion("nnlightctl_property_classify_catalog_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdIsNotNull() {
            addCriterion("nnlightctl_property_classify_catalog_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdEqualTo(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id =", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id <>", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdGreaterThan(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id >", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id >=", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdLessThan(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id <", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id <=", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdIn(List<Long> values) {
            addCriterion("nnlightctl_property_classify_catalog_id in", values, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_property_classify_catalog_id not in", values, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_property_classify_catalog_id between", value1, value2, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_property_classify_catalog_id not between", value1, value2, "nnlightctlPropertyClassifyCatalogId");
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