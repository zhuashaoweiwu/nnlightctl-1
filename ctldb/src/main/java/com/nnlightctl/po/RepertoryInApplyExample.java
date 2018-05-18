package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepertoryInApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepertoryInApplyExample() {
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

        public Criteria andSerialnumberIsNull() {
            addCriterion("serialnumber is null");
            return (Criteria) this;
        }

        public Criteria andSerialnumberIsNotNull() {
            addCriterion("serialnumber is not null");
            return (Criteria) this;
        }

        public Criteria andSerialnumberEqualTo(String value) {
            addCriterion("serialnumber =", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotEqualTo(String value) {
            addCriterion("serialnumber <>", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberGreaterThan(String value) {
            addCriterion("serialnumber >", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberGreaterThanOrEqualTo(String value) {
            addCriterion("serialnumber >=", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberLessThan(String value) {
            addCriterion("serialnumber <", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberLessThanOrEqualTo(String value) {
            addCriterion("serialnumber <=", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberLike(String value) {
            addCriterion("serialnumber like", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotLike(String value) {
            addCriterion("serialnumber not like", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberIn(List<String> values) {
            addCriterion("serialnumber in", values, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotIn(List<String> values) {
            addCriterion("serialnumber not in", values, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberBetween(String value1, String value2) {
            addCriterion("serialnumber between", value1, value2, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotBetween(String value1, String value2) {
            addCriterion("serialnumber not between", value1, value2, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateIsNull() {
            addCriterion("in_repertory_date is null");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateIsNotNull() {
            addCriterion("in_repertory_date is not null");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateEqualTo(Date value) {
            addCriterion("in_repertory_date =", value, "inRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateNotEqualTo(Date value) {
            addCriterion("in_repertory_date <>", value, "inRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateGreaterThan(Date value) {
            addCriterion("in_repertory_date >", value, "inRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("in_repertory_date >=", value, "inRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateLessThan(Date value) {
            addCriterion("in_repertory_date <", value, "inRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateLessThanOrEqualTo(Date value) {
            addCriterion("in_repertory_date <=", value, "inRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateIn(List<Date> values) {
            addCriterion("in_repertory_date in", values, "inRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateNotIn(List<Date> values) {
            addCriterion("in_repertory_date not in", values, "inRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateBetween(Date value1, Date value2) {
            addCriterion("in_repertory_date between", value1, value2, "inRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andInRepertoryDateNotBetween(Date value1, Date value2) {
            addCriterion("in_repertory_date not between", value1, value2, "inRepertoryDate");
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

        public Criteria andNnlightctlSupplierIsNull() {
            addCriterion("nnlightctl_supplier is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIsNotNull() {
            addCriterion("nnlightctl_supplier is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierEqualTo(Long value) {
            addCriterion("nnlightctl_supplier =", value, "nnlightctlSupplier");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierNotEqualTo(Long value) {
            addCriterion("nnlightctl_supplier <>", value, "nnlightctlSupplier");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierGreaterThan(Long value) {
            addCriterion("nnlightctl_supplier >", value, "nnlightctlSupplier");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_supplier >=", value, "nnlightctlSupplier");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierLessThan(Long value) {
            addCriterion("nnlightctl_supplier <", value, "nnlightctlSupplier");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_supplier <=", value, "nnlightctlSupplier");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIn(List<Long> values) {
            addCriterion("nnlightctl_supplier in", values, "nnlightctlSupplier");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierNotIn(List<Long> values) {
            addCriterion("nnlightctl_supplier not in", values, "nnlightctlSupplier");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_supplier between", value1, value2, "nnlightctlSupplier");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_supplier not between", value1, value2, "nnlightctlSupplier");
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

        public Criteria andPropertyUidIsNull() {
            addCriterion("property_uid is null");
            return (Criteria) this;
        }

        public Criteria andPropertyUidIsNotNull() {
            addCriterion("property_uid is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyUidEqualTo(String value) {
            addCriterion("property_uid =", value, "propertyUid");
            return (Criteria) this;
        }

        public Criteria andPropertyUidNotEqualTo(String value) {
            addCriterion("property_uid <>", value, "propertyUid");
            return (Criteria) this;
        }

        public Criteria andPropertyUidGreaterThan(String value) {
            addCriterion("property_uid >", value, "propertyUid");
            return (Criteria) this;
        }

        public Criteria andPropertyUidGreaterThanOrEqualTo(String value) {
            addCriterion("property_uid >=", value, "propertyUid");
            return (Criteria) this;
        }

        public Criteria andPropertyUidLessThan(String value) {
            addCriterion("property_uid <", value, "propertyUid");
            return (Criteria) this;
        }

        public Criteria andPropertyUidLessThanOrEqualTo(String value) {
            addCriterion("property_uid <=", value, "propertyUid");
            return (Criteria) this;
        }

        public Criteria andPropertyUidLike(String value) {
            addCriterion("property_uid like", value, "propertyUid");
            return (Criteria) this;
        }

        public Criteria andPropertyUidNotLike(String value) {
            addCriterion("property_uid not like", value, "propertyUid");
            return (Criteria) this;
        }

        public Criteria andPropertyUidIn(List<String> values) {
            addCriterion("property_uid in", values, "propertyUid");
            return (Criteria) this;
        }

        public Criteria andPropertyUidNotIn(List<String> values) {
            addCriterion("property_uid not in", values, "propertyUid");
            return (Criteria) this;
        }

        public Criteria andPropertyUidBetween(String value1, String value2) {
            addCriterion("property_uid between", value1, value2, "propertyUid");
            return (Criteria) this;
        }

        public Criteria andPropertyUidNotBetween(String value1, String value2) {
            addCriterion("property_uid not between", value1, value2, "propertyUid");
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

        public Criteria andNnlightctlRepertoryInReasonIdIsNull() {
            addCriterion("nnlightctl_repertory_in_reason_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryInReasonIdIsNotNull() {
            addCriterion("nnlightctl_repertory_in_reason_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryInReasonIdEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_in_reason_id =", value, "nnlightctlRepertoryInReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryInReasonIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_in_reason_id <>", value, "nnlightctlRepertoryInReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryInReasonIdGreaterThan(Long value) {
            addCriterion("nnlightctl_repertory_in_reason_id >", value, "nnlightctlRepertoryInReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryInReasonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_in_reason_id >=", value, "nnlightctlRepertoryInReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryInReasonIdLessThan(Long value) {
            addCriterion("nnlightctl_repertory_in_reason_id <", value, "nnlightctlRepertoryInReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryInReasonIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_in_reason_id <=", value, "nnlightctlRepertoryInReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryInReasonIdIn(List<Long> values) {
            addCriterion("nnlightctl_repertory_in_reason_id in", values, "nnlightctlRepertoryInReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryInReasonIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_repertory_in_reason_id not in", values, "nnlightctlRepertoryInReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryInReasonIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_repertory_in_reason_id between", value1, value2, "nnlightctlRepertoryInReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryInReasonIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_repertory_in_reason_id not between", value1, value2, "nnlightctlRepertoryInReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdIsNull() {
            addCriterion("nnlightctl_repertory_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdIsNotNull() {
            addCriterion("nnlightctl_repertory_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_id =", value, "nnlightctlRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_id <>", value, "nnlightctlRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdGreaterThan(Long value) {
            addCriterion("nnlightctl_repertory_id >", value, "nnlightctlRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_id >=", value, "nnlightctlRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdLessThan(Long value) {
            addCriterion("nnlightctl_repertory_id <", value, "nnlightctlRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_id <=", value, "nnlightctlRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdIn(List<Long> values) {
            addCriterion("nnlightctl_repertory_id in", values, "nnlightctlRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_repertory_id not in", values, "nnlightctlRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_repertory_id between", value1, value2, "nnlightctlRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_repertory_id not between", value1, value2, "nnlightctlRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdIsNull() {
            addCriterion("nnlightctl_user_apply_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdIsNotNull() {
            addCriterion("nnlightctl_user_apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdEqualTo(Long value) {
            addCriterion("nnlightctl_user_apply_id =", value, "nnlightctlUserApplyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_user_apply_id <>", value, "nnlightctlUserApplyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdGreaterThan(Long value) {
            addCriterion("nnlightctl_user_apply_id >", value, "nnlightctlUserApplyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_user_apply_id >=", value, "nnlightctlUserApplyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdLessThan(Long value) {
            addCriterion("nnlightctl_user_apply_id <", value, "nnlightctlUserApplyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_user_apply_id <=", value, "nnlightctlUserApplyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdIn(List<Long> values) {
            addCriterion("nnlightctl_user_apply_id in", values, "nnlightctlUserApplyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_user_apply_id not in", values, "nnlightctlUserApplyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_user_apply_id between", value1, value2, "nnlightctlUserApplyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplyIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_user_apply_id not between", value1, value2, "nnlightctlUserApplyId");
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