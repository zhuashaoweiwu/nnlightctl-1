package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepairRecordExample() {
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

        public Criteria andNnlightctlEleboxIdIsNull() {
            addCriterion("nnlightctl_elebox_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdIsNotNull() {
            addCriterion("nnlightctl_elebox_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_id =", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_id <>", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdGreaterThan(Long value) {
            addCriterion("nnlightctl_elebox_id >", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_id >=", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdLessThan(Long value) {
            addCriterion("nnlightctl_elebox_id <", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_id <=", value, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdIn(List<Long> values) {
            addCriterion("nnlightctl_elebox_id in", values, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_elebox_id not in", values, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_elebox_id between", value1, value2, "nnlightctlEleboxId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_elebox_id not between", value1, value2, "nnlightctlEleboxId");
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

        public Criteria andPropertyNameIsNull() {
            addCriterion("property_name is null");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIsNotNull() {
            addCriterion("property_name is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyNameEqualTo(String value) {
            addCriterion("property_name =", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotEqualTo(String value) {
            addCriterion("property_name <>", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThan(String value) {
            addCriterion("property_name >", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThanOrEqualTo(String value) {
            addCriterion("property_name >=", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThan(String value) {
            addCriterion("property_name <", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThanOrEqualTo(String value) {
            addCriterion("property_name <=", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLike(String value) {
            addCriterion("property_name like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotLike(String value) {
            addCriterion("property_name not like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIn(List<String> values) {
            addCriterion("property_name in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotIn(List<String> values) {
            addCriterion("property_name not in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameBetween(String value1, String value2) {
            addCriterion("property_name between", value1, value2, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotBetween(String value1, String value2) {
            addCriterion("property_name not between", value1, value2, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyCountIsNull() {
            addCriterion("property_count is null");
            return (Criteria) this;
        }

        public Criteria andPropertyCountIsNotNull() {
            addCriterion("property_count is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyCountEqualTo(Long value) {
            addCriterion("property_count =", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountNotEqualTo(Long value) {
            addCriterion("property_count <>", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountGreaterThan(Long value) {
            addCriterion("property_count >", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountGreaterThanOrEqualTo(Long value) {
            addCriterion("property_count >=", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountLessThan(Long value) {
            addCriterion("property_count <", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountLessThanOrEqualTo(Long value) {
            addCriterion("property_count <=", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountIn(List<Long> values) {
            addCriterion("property_count in", values, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountNotIn(List<Long> values) {
            addCriterion("property_count not in", values, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountBetween(Long value1, Long value2) {
            addCriterion("property_count between", value1, value2, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountNotBetween(Long value1, Long value2) {
            addCriterion("property_count not between", value1, value2, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andFaultDateIsNull() {
            addCriterion("fault_date is null");
            return (Criteria) this;
        }

        public Criteria andFaultDateIsNotNull() {
            addCriterion("fault_date is not null");
            return (Criteria) this;
        }

        public Criteria andFaultDateEqualTo(Date value) {
            addCriterion("fault_date =", value, "faultDate");
            return (Criteria) this;
        }

        public Criteria andFaultDateNotEqualTo(Date value) {
            addCriterion("fault_date <>", value, "faultDate");
            return (Criteria) this;
        }

        public Criteria andFaultDateGreaterThan(Date value) {
            addCriterion("fault_date >", value, "faultDate");
            return (Criteria) this;
        }

        public Criteria andFaultDateGreaterThanOrEqualTo(Date value) {
            addCriterion("fault_date >=", value, "faultDate");
            return (Criteria) this;
        }

        public Criteria andFaultDateLessThan(Date value) {
            addCriterion("fault_date <", value, "faultDate");
            return (Criteria) this;
        }

        public Criteria andFaultDateLessThanOrEqualTo(Date value) {
            addCriterion("fault_date <=", value, "faultDate");
            return (Criteria) this;
        }

        public Criteria andFaultDateIn(List<Date> values) {
            addCriterion("fault_date in", values, "faultDate");
            return (Criteria) this;
        }

        public Criteria andFaultDateNotIn(List<Date> values) {
            addCriterion("fault_date not in", values, "faultDate");
            return (Criteria) this;
        }

        public Criteria andFaultDateBetween(Date value1, Date value2) {
            addCriterion("fault_date between", value1, value2, "faultDate");
            return (Criteria) this;
        }

        public Criteria andFaultDateNotBetween(Date value1, Date value2) {
            addCriterion("fault_date not between", value1, value2, "faultDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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

        public Criteria andIsCommitIsNull() {
            addCriterion("is_commit is null");
            return (Criteria) this;
        }

        public Criteria andIsCommitIsNotNull() {
            addCriterion("is_commit is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommitEqualTo(Byte value) {
            addCriterion("is_commit =", value, "isCommit");
            return (Criteria) this;
        }

        public Criteria andIsCommitNotEqualTo(Byte value) {
            addCriterion("is_commit <>", value, "isCommit");
            return (Criteria) this;
        }

        public Criteria andIsCommitGreaterThan(Byte value) {
            addCriterion("is_commit >", value, "isCommit");
            return (Criteria) this;
        }

        public Criteria andIsCommitGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_commit >=", value, "isCommit");
            return (Criteria) this;
        }

        public Criteria andIsCommitLessThan(Byte value) {
            addCriterion("is_commit <", value, "isCommit");
            return (Criteria) this;
        }

        public Criteria andIsCommitLessThanOrEqualTo(Byte value) {
            addCriterion("is_commit <=", value, "isCommit");
            return (Criteria) this;
        }

        public Criteria andIsCommitIn(List<Byte> values) {
            addCriterion("is_commit in", values, "isCommit");
            return (Criteria) this;
        }

        public Criteria andIsCommitNotIn(List<Byte> values) {
            addCriterion("is_commit not in", values, "isCommit");
            return (Criteria) this;
        }

        public Criteria andIsCommitBetween(Byte value1, Byte value2) {
            addCriterion("is_commit between", value1, value2, "isCommit");
            return (Criteria) this;
        }

        public Criteria andIsCommitNotBetween(Byte value1, Byte value2) {
            addCriterion("is_commit not between", value1, value2, "isCommit");
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