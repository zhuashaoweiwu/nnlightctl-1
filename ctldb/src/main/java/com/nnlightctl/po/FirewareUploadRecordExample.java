package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FirewareUploadRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FirewareUploadRecordExample() {
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

        public Criteria andFirewareVersionIsNull() {
            addCriterion("fireware_version is null");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionIsNotNull() {
            addCriterion("fireware_version is not null");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionEqualTo(String value) {
            addCriterion("fireware_version =", value, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionNotEqualTo(String value) {
            addCriterion("fireware_version <>", value, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionGreaterThan(String value) {
            addCriterion("fireware_version >", value, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionGreaterThanOrEqualTo(String value) {
            addCriterion("fireware_version >=", value, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionLessThan(String value) {
            addCriterion("fireware_version <", value, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionLessThanOrEqualTo(String value) {
            addCriterion("fireware_version <=", value, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionLike(String value) {
            addCriterion("fireware_version like", value, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionNotLike(String value) {
            addCriterion("fireware_version not like", value, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionIn(List<String> values) {
            addCriterion("fireware_version in", values, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionNotIn(List<String> values) {
            addCriterion("fireware_version not in", values, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionBetween(String value1, String value2) {
            addCriterion("fireware_version between", value1, value2, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andFirewareVersionNotBetween(String value1, String value2) {
            addCriterion("fireware_version not between", value1, value2, "firewareVersion");
            return (Criteria) this;
        }

        public Criteria andPackageNumberIsNull() {
            addCriterion("package_number is null");
            return (Criteria) this;
        }

        public Criteria andPackageNumberIsNotNull() {
            addCriterion("package_number is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNumberEqualTo(Short value) {
            addCriterion("package_number =", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberNotEqualTo(Short value) {
            addCriterion("package_number <>", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberGreaterThan(Short value) {
            addCriterion("package_number >", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("package_number >=", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberLessThan(Short value) {
            addCriterion("package_number <", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberLessThanOrEqualTo(Short value) {
            addCriterion("package_number <=", value, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberIn(List<Short> values) {
            addCriterion("package_number in", values, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberNotIn(List<Short> values) {
            addCriterion("package_number not in", values, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberBetween(Short value1, Short value2) {
            addCriterion("package_number between", value1, value2, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andPackageNumberNotBetween(Short value1, Short value2) {
            addCriterion("package_number not between", value1, value2, "packageNumber");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeIsNull() {
            addCriterion("last_package_size is null");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeIsNotNull() {
            addCriterion("last_package_size is not null");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeEqualTo(Byte value) {
            addCriterion("last_package_size =", value, "lastPackageSize");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeNotEqualTo(Byte value) {
            addCriterion("last_package_size <>", value, "lastPackageSize");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeGreaterThan(Byte value) {
            addCriterion("last_package_size >", value, "lastPackageSize");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeGreaterThanOrEqualTo(Byte value) {
            addCriterion("last_package_size >=", value, "lastPackageSize");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeLessThan(Byte value) {
            addCriterion("last_package_size <", value, "lastPackageSize");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeLessThanOrEqualTo(Byte value) {
            addCriterion("last_package_size <=", value, "lastPackageSize");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeIn(List<Byte> values) {
            addCriterion("last_package_size in", values, "lastPackageSize");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeNotIn(List<Byte> values) {
            addCriterion("last_package_size not in", values, "lastPackageSize");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeBetween(Byte value1, Byte value2) {
            addCriterion("last_package_size between", value1, value2, "lastPackageSize");
            return (Criteria) this;
        }

        public Criteria andLastPackageSizeNotBetween(Byte value1, Byte value2) {
            addCriterion("last_package_size not between", value1, value2, "lastPackageSize");
            return (Criteria) this;
        }

        public Criteria andPersist1IsNull() {
            addCriterion("persist1 is null");
            return (Criteria) this;
        }

        public Criteria andPersist1IsNotNull() {
            addCriterion("persist1 is not null");
            return (Criteria) this;
        }

        public Criteria andPersist1EqualTo(String value) {
            addCriterion("persist1 =", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1NotEqualTo(String value) {
            addCriterion("persist1 <>", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1GreaterThan(String value) {
            addCriterion("persist1 >", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1GreaterThanOrEqualTo(String value) {
            addCriterion("persist1 >=", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1LessThan(String value) {
            addCriterion("persist1 <", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1LessThanOrEqualTo(String value) {
            addCriterion("persist1 <=", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1Like(String value) {
            addCriterion("persist1 like", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1NotLike(String value) {
            addCriterion("persist1 not like", value, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1In(List<String> values) {
            addCriterion("persist1 in", values, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1NotIn(List<String> values) {
            addCriterion("persist1 not in", values, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1Between(String value1, String value2) {
            addCriterion("persist1 between", value1, value2, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist1NotBetween(String value1, String value2) {
            addCriterion("persist1 not between", value1, value2, "persist1");
            return (Criteria) this;
        }

        public Criteria andPersist2IsNull() {
            addCriterion("persist2 is null");
            return (Criteria) this;
        }

        public Criteria andPersist2IsNotNull() {
            addCriterion("persist2 is not null");
            return (Criteria) this;
        }

        public Criteria andPersist2EqualTo(String value) {
            addCriterion("persist2 =", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2NotEqualTo(String value) {
            addCriterion("persist2 <>", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2GreaterThan(String value) {
            addCriterion("persist2 >", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2GreaterThanOrEqualTo(String value) {
            addCriterion("persist2 >=", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2LessThan(String value) {
            addCriterion("persist2 <", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2LessThanOrEqualTo(String value) {
            addCriterion("persist2 <=", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2Like(String value) {
            addCriterion("persist2 like", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2NotLike(String value) {
            addCriterion("persist2 not like", value, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2In(List<String> values) {
            addCriterion("persist2 in", values, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2NotIn(List<String> values) {
            addCriterion("persist2 not in", values, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2Between(String value1, String value2) {
            addCriterion("persist2 between", value1, value2, "persist2");
            return (Criteria) this;
        }

        public Criteria andPersist2NotBetween(String value1, String value2) {
            addCriterion("persist2 not between", value1, value2, "persist2");
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