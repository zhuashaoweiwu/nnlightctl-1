package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InstitutionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InstitutionExample() {
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

        public Criteria andInstitutionNameIsNull() {
            addCriterion("institution_name is null");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameIsNotNull() {
            addCriterion("institution_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameEqualTo(String value) {
            addCriterion("institution_name =", value, "institutionName");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameNotEqualTo(String value) {
            addCriterion("institution_name <>", value, "institutionName");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameGreaterThan(String value) {
            addCriterion("institution_name >", value, "institutionName");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameGreaterThanOrEqualTo(String value) {
            addCriterion("institution_name >=", value, "institutionName");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameLessThan(String value) {
            addCriterion("institution_name <", value, "institutionName");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameLessThanOrEqualTo(String value) {
            addCriterion("institution_name <=", value, "institutionName");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameLike(String value) {
            addCriterion("institution_name like", value, "institutionName");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameNotLike(String value) {
            addCriterion("institution_name not like", value, "institutionName");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameIn(List<String> values) {
            addCriterion("institution_name in", values, "institutionName");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameNotIn(List<String> values) {
            addCriterion("institution_name not in", values, "institutionName");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameBetween(String value1, String value2) {
            addCriterion("institution_name between", value1, value2, "institutionName");
            return (Criteria) this;
        }

        public Criteria andInstitutionNameNotBetween(String value1, String value2) {
            addCriterion("institution_name not between", value1, value2, "institutionName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andNnlightctlInstitutionIdParentIsNull() {
            addCriterion("nnlightctl_institution_id_parent is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdParentIsNotNull() {
            addCriterion("nnlightctl_institution_id_parent is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdParentEqualTo(Long value) {
            addCriterion("nnlightctl_institution_id_parent =", value, "nnlightctlInstitutionIdParent");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdParentNotEqualTo(Long value) {
            addCriterion("nnlightctl_institution_id_parent <>", value, "nnlightctlInstitutionIdParent");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdParentGreaterThan(Long value) {
            addCriterion("nnlightctl_institution_id_parent >", value, "nnlightctlInstitutionIdParent");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdParentGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_institution_id_parent >=", value, "nnlightctlInstitutionIdParent");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdParentLessThan(Long value) {
            addCriterion("nnlightctl_institution_id_parent <", value, "nnlightctlInstitutionIdParent");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdParentLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_institution_id_parent <=", value, "nnlightctlInstitutionIdParent");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdParentIn(List<Long> values) {
            addCriterion("nnlightctl_institution_id_parent in", values, "nnlightctlInstitutionIdParent");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdParentNotIn(List<Long> values) {
            addCriterion("nnlightctl_institution_id_parent not in", values, "nnlightctlInstitutionIdParent");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdParentBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_institution_id_parent between", value1, value2, "nnlightctlInstitutionIdParent");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdParentNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_institution_id_parent not between", value1, value2, "nnlightctlInstitutionIdParent");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelIsNull() {
            addCriterion("institution_level is null");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelIsNotNull() {
            addCriterion("institution_level is not null");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelEqualTo(Byte value) {
            addCriterion("institution_level =", value, "institutionLevel");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelNotEqualTo(Byte value) {
            addCriterion("institution_level <>", value, "institutionLevel");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelGreaterThan(Byte value) {
            addCriterion("institution_level >", value, "institutionLevel");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("institution_level >=", value, "institutionLevel");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelLessThan(Byte value) {
            addCriterion("institution_level <", value, "institutionLevel");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelLessThanOrEqualTo(Byte value) {
            addCriterion("institution_level <=", value, "institutionLevel");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelIn(List<Byte> values) {
            addCriterion("institution_level in", values, "institutionLevel");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelNotIn(List<Byte> values) {
            addCriterion("institution_level not in", values, "institutionLevel");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelBetween(Byte value1, Byte value2) {
            addCriterion("institution_level between", value1, value2, "institutionLevel");
            return (Criteria) this;
        }

        public Criteria andInstitutionLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("institution_level not between", value1, value2, "institutionLevel");
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