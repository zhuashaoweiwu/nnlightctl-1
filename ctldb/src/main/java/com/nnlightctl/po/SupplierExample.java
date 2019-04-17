package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SupplierExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupplierExample() {
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

        public Criteria andApplierNameIsNull() {
            addCriterion("applier_name is null");
            return (Criteria) this;
        }

        public Criteria andApplierNameIsNotNull() {
            addCriterion("applier_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplierNameEqualTo(String value) {
            addCriterion("applier_name =", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotEqualTo(String value) {
            addCriterion("applier_name <>", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameGreaterThan(String value) {
            addCriterion("applier_name >", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameGreaterThanOrEqualTo(String value) {
            addCriterion("applier_name >=", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameLessThan(String value) {
            addCriterion("applier_name <", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameLessThanOrEqualTo(String value) {
            addCriterion("applier_name <=", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameLike(String value) {
            addCriterion("applier_name like", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotLike(String value) {
            addCriterion("applier_name not like", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameIn(List<String> values) {
            addCriterion("applier_name in", values, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotIn(List<String> values) {
            addCriterion("applier_name not in", values, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameBetween(String value1, String value2) {
            addCriterion("applier_name between", value1, value2, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotBetween(String value1, String value2) {
            addCriterion("applier_name not between", value1, value2, "applierName");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andConnectorIsNull() {
            addCriterion("connector is null");
            return (Criteria) this;
        }

        public Criteria andConnectorIsNotNull() {
            addCriterion("connector is not null");
            return (Criteria) this;
        }

        public Criteria andConnectorEqualTo(String value) {
            addCriterion("connector =", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotEqualTo(String value) {
            addCriterion("connector <>", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorGreaterThan(String value) {
            addCriterion("connector >", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorGreaterThanOrEqualTo(String value) {
            addCriterion("connector >=", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorLessThan(String value) {
            addCriterion("connector <", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorLessThanOrEqualTo(String value) {
            addCriterion("connector <=", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorLike(String value) {
            addCriterion("connector like", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotLike(String value) {
            addCriterion("connector not like", value, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorIn(List<String> values) {
            addCriterion("connector in", values, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotIn(List<String> values) {
            addCriterion("connector not in", values, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorBetween(String value1, String value2) {
            addCriterion("connector between", value1, value2, "connector");
            return (Criteria) this;
        }

        public Criteria andConnectorNotBetween(String value1, String value2) {
            addCriterion("connector not between", value1, value2, "connector");
            return (Criteria) this;
        }

        public Criteria andTelephone1IsNull() {
            addCriterion("telephone1 is null");
            return (Criteria) this;
        }

        public Criteria andTelephone1IsNotNull() {
            addCriterion("telephone1 is not null");
            return (Criteria) this;
        }

        public Criteria andTelephone1EqualTo(String value) {
            addCriterion("telephone1 =", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1NotEqualTo(String value) {
            addCriterion("telephone1 <>", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1GreaterThan(String value) {
            addCriterion("telephone1 >", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1GreaterThanOrEqualTo(String value) {
            addCriterion("telephone1 >=", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1LessThan(String value) {
            addCriterion("telephone1 <", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1LessThanOrEqualTo(String value) {
            addCriterion("telephone1 <=", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1Like(String value) {
            addCriterion("telephone1 like", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1NotLike(String value) {
            addCriterion("telephone1 not like", value, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1In(List<String> values) {
            addCriterion("telephone1 in", values, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1NotIn(List<String> values) {
            addCriterion("telephone1 not in", values, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1Between(String value1, String value2) {
            addCriterion("telephone1 between", value1, value2, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone1NotBetween(String value1, String value2) {
            addCriterion("telephone1 not between", value1, value2, "telephone1");
            return (Criteria) this;
        }

        public Criteria andTelephone2IsNull() {
            addCriterion("telephone2 is null");
            return (Criteria) this;
        }

        public Criteria andTelephone2IsNotNull() {
            addCriterion("telephone2 is not null");
            return (Criteria) this;
        }

        public Criteria andTelephone2EqualTo(String value) {
            addCriterion("telephone2 =", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2NotEqualTo(String value) {
            addCriterion("telephone2 <>", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2GreaterThan(String value) {
            addCriterion("telephone2 >", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2GreaterThanOrEqualTo(String value) {
            addCriterion("telephone2 >=", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2LessThan(String value) {
            addCriterion("telephone2 <", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2LessThanOrEqualTo(String value) {
            addCriterion("telephone2 <=", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2Like(String value) {
            addCriterion("telephone2 like", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2NotLike(String value) {
            addCriterion("telephone2 not like", value, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2In(List<String> values) {
            addCriterion("telephone2 in", values, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2NotIn(List<String> values) {
            addCriterion("telephone2 not in", values, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2Between(String value1, String value2) {
            addCriterion("telephone2 between", value1, value2, "telephone2");
            return (Criteria) this;
        }

        public Criteria andTelephone2NotBetween(String value1, String value2) {
            addCriterion("telephone2 not between", value1, value2, "telephone2");
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