package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepertoryOutApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepertoryOutApplyExample() {
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

        public Criteria andNnlightctlPropertyIdIsNull() {
            addCriterion("nnlightctl_property_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdIsNotNull() {
            addCriterion("nnlightctl_property_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdEqualTo(Long value) {
            addCriterion("nnlightctl_property_id =", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_property_id <>", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdGreaterThan(Long value) {
            addCriterion("nnlightctl_property_id >", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_property_id >=", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdLessThan(Long value) {
            addCriterion("nnlightctl_property_id <", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_property_id <=", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdIn(List<Long> values) {
            addCriterion("nnlightctl_property_id in", values, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_property_id not in", values, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_property_id between", value1, value2, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_property_id not between", value1, value2, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andOutCounteIsNull() {
            addCriterion("out_counte is null");
            return (Criteria) this;
        }

        public Criteria andOutCounteIsNotNull() {
            addCriterion("out_counte is not null");
            return (Criteria) this;
        }

        public Criteria andOutCounteEqualTo(Long value) {
            addCriterion("out_counte =", value, "outCounte");
            return (Criteria) this;
        }

        public Criteria andOutCounteNotEqualTo(Long value) {
            addCriterion("out_counte <>", value, "outCounte");
            return (Criteria) this;
        }

        public Criteria andOutCounteGreaterThan(Long value) {
            addCriterion("out_counte >", value, "outCounte");
            return (Criteria) this;
        }

        public Criteria andOutCounteGreaterThanOrEqualTo(Long value) {
            addCriterion("out_counte >=", value, "outCounte");
            return (Criteria) this;
        }

        public Criteria andOutCounteLessThan(Long value) {
            addCriterion("out_counte <", value, "outCounte");
            return (Criteria) this;
        }

        public Criteria andOutCounteLessThanOrEqualTo(Long value) {
            addCriterion("out_counte <=", value, "outCounte");
            return (Criteria) this;
        }

        public Criteria andOutCounteIn(List<Long> values) {
            addCriterion("out_counte in", values, "outCounte");
            return (Criteria) this;
        }

        public Criteria andOutCounteNotIn(List<Long> values) {
            addCriterion("out_counte not in", values, "outCounte");
            return (Criteria) this;
        }

        public Criteria andOutCounteBetween(Long value1, Long value2) {
            addCriterion("out_counte between", value1, value2, "outCounte");
            return (Criteria) this;
        }

        public Criteria andOutCounteNotBetween(Long value1, Long value2) {
            addCriterion("out_counte not between", value1, value2, "outCounte");
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

        public Criteria andNnlightctlOutRepertoryIdIsNull() {
            addCriterion("nnlightctl_out_repertory_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlOutRepertoryIdIsNotNull() {
            addCriterion("nnlightctl_out_repertory_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlOutRepertoryIdEqualTo(Long value) {
            addCriterion("nnlightctl_out_repertory_id =", value, "nnlightctlOutRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlOutRepertoryIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_out_repertory_id <>", value, "nnlightctlOutRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlOutRepertoryIdGreaterThan(Long value) {
            addCriterion("nnlightctl_out_repertory_id >", value, "nnlightctlOutRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlOutRepertoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_out_repertory_id >=", value, "nnlightctlOutRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlOutRepertoryIdLessThan(Long value) {
            addCriterion("nnlightctl_out_repertory_id <", value, "nnlightctlOutRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlOutRepertoryIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_out_repertory_id <=", value, "nnlightctlOutRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlOutRepertoryIdIn(List<Long> values) {
            addCriterion("nnlightctl_out_repertory_id in", values, "nnlightctlOutRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlOutRepertoryIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_out_repertory_id not in", values, "nnlightctlOutRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlOutRepertoryIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_out_repertory_id between", value1, value2, "nnlightctlOutRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlOutRepertoryIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_out_repertory_id not between", value1, value2, "nnlightctlOutRepertoryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdIsNull() {
            addCriterion("nnlightctl_repertory_out_reason_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdIsNotNull() {
            addCriterion("nnlightctl_repertory_out_reason_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_out_reason_id =", value, "nnlightctlRepertoryOutReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_out_reason_id <>", value, "nnlightctlRepertoryOutReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdGreaterThan(Long value) {
            addCriterion("nnlightctl_repertory_out_reason_id >", value, "nnlightctlRepertoryOutReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_out_reason_id >=", value, "nnlightctlRepertoryOutReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdLessThan(Long value) {
            addCriterion("nnlightctl_repertory_out_reason_id <", value, "nnlightctlRepertoryOutReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_repertory_out_reason_id <=", value, "nnlightctlRepertoryOutReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdIn(List<Long> values) {
            addCriterion("nnlightctl_repertory_out_reason_id in", values, "nnlightctlRepertoryOutReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_repertory_out_reason_id not in", values, "nnlightctlRepertoryOutReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_repertory_out_reason_id between", value1, value2, "nnlightctlRepertoryOutReasonId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRepertoryOutReasonIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_repertory_out_reason_id not between", value1, value2, "nnlightctlRepertoryOutReasonId");
            return (Criteria) this;
        }

        public Criteria andApplyStateIsNull() {
            addCriterion("apply_state is null");
            return (Criteria) this;
        }

        public Criteria andApplyStateIsNotNull() {
            addCriterion("apply_state is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStateEqualTo(Byte value) {
            addCriterion("apply_state =", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotEqualTo(Byte value) {
            addCriterion("apply_state <>", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateGreaterThan(Byte value) {
            addCriterion("apply_state >", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("apply_state >=", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLessThan(Byte value) {
            addCriterion("apply_state <", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLessThanOrEqualTo(Byte value) {
            addCriterion("apply_state <=", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateIn(List<Byte> values) {
            addCriterion("apply_state in", values, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotIn(List<Byte> values) {
            addCriterion("apply_state not in", values, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateBetween(Byte value1, Byte value2) {
            addCriterion("apply_state between", value1, value2, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotBetween(Byte value1, Byte value2) {
            addCriterion("apply_state not between", value1, value2, "applyState");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonIsNull() {
            addCriterion("refuse_reason is null");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonIsNotNull() {
            addCriterion("refuse_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonEqualTo(String value) {
            addCriterion("refuse_reason =", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonNotEqualTo(String value) {
            addCriterion("refuse_reason <>", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonGreaterThan(String value) {
            addCriterion("refuse_reason >", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonGreaterThanOrEqualTo(String value) {
            addCriterion("refuse_reason >=", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonLessThan(String value) {
            addCriterion("refuse_reason <", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonLessThanOrEqualTo(String value) {
            addCriterion("refuse_reason <=", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonLike(String value) {
            addCriterion("refuse_reason like", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonNotLike(String value) {
            addCriterion("refuse_reason not like", value, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonIn(List<String> values) {
            addCriterion("refuse_reason in", values, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonNotIn(List<String> values) {
            addCriterion("refuse_reason not in", values, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonBetween(String value1, String value2) {
            addCriterion("refuse_reason between", value1, value2, "refuseReason");
            return (Criteria) this;
        }

        public Criteria andRefuseReasonNotBetween(String value1, String value2) {
            addCriterion("refuse_reason not between", value1, value2, "refuseReason");
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