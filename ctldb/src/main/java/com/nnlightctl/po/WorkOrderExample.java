package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkOrderExample() {
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

        public Criteria andSerialNumberIsNull() {
            addCriterion("serial_number is null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNumberEqualTo(String value) {
            addCriterion("serial_number =", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotEqualTo(String value) {
            addCriterion("serial_number <>", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThan(String value) {
            addCriterion("serial_number >", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("serial_number >=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThan(String value) {
            addCriterion("serial_number <", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("serial_number <=", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberLike(String value) {
            addCriterion("serial_number like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotLike(String value) {
            addCriterion("serial_number not like", value, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberIn(List<String> values) {
            addCriterion("serial_number in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotIn(List<String> values) {
            addCriterion("serial_number not in", values, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberBetween(String value1, String value2) {
            addCriterion("serial_number between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andSerialNumberNotBetween(String value1, String value2) {
            addCriterion("serial_number not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNull() {
            addCriterion("classify is null");
            return (Criteria) this;
        }

        public Criteria andClassifyIsNotNull() {
            addCriterion("classify is not null");
            return (Criteria) this;
        }

        public Criteria andClassifyEqualTo(Byte value) {
            addCriterion("classify =", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotEqualTo(Byte value) {
            addCriterion("classify <>", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThan(Byte value) {
            addCriterion("classify >", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyGreaterThanOrEqualTo(Byte value) {
            addCriterion("classify >=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThan(Byte value) {
            addCriterion("classify <", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyLessThanOrEqualTo(Byte value) {
            addCriterion("classify <=", value, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyIn(List<Byte> values) {
            addCriterion("classify in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotIn(List<Byte> values) {
            addCriterion("classify not in", values, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyBetween(Byte value1, Byte value2) {
            addCriterion("classify between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andClassifyNotBetween(Byte value1, Byte value2) {
            addCriterion("classify not between", value1, value2, "classify");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdIsNull() {
            addCriterion("nnlightctl_workflower_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdIsNotNull() {
            addCriterion("nnlightctl_workflower_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_id =", value, "nnlightctlWorkflowerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_id <>", value, "nnlightctlWorkflowerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdGreaterThan(Long value) {
            addCriterion("nnlightctl_workflower_id >", value, "nnlightctlWorkflowerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_id >=", value, "nnlightctlWorkflowerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdLessThan(Long value) {
            addCriterion("nnlightctl_workflower_id <", value, "nnlightctlWorkflowerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_id <=", value, "nnlightctlWorkflowerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdIn(List<Long> values) {
            addCriterion("nnlightctl_workflower_id in", values, "nnlightctlWorkflowerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_workflower_id not in", values, "nnlightctlWorkflowerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_workflower_id between", value1, value2, "nnlightctlWorkflowerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_workflower_id not between", value1, value2, "nnlightctlWorkflowerId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Byte value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Byte value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Byte value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Byte value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Byte value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Byte value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Byte> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Byte> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Byte value1, Byte value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Byte value1, Byte value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdIsNull() {
            addCriterion("nnlightctl_region_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdIsNotNull() {
            addCriterion("nnlightctl_region_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdEqualTo(Long value) {
            addCriterion("nnlightctl_region_id =", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_region_id <>", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdGreaterThan(Long value) {
            addCriterion("nnlightctl_region_id >", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_region_id >=", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdLessThan(Long value) {
            addCriterion("nnlightctl_region_id <", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_region_id <=", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdIn(List<Long> values) {
            addCriterion("nnlightctl_region_id in", values, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_region_id not in", values, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_region_id between", value1, value2, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_region_id not between", value1, value2, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdIsNull() {
            addCriterion("nnlightctl_workflower_move_record_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdIsNotNull() {
            addCriterion("nnlightctl_workflower_move_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_move_record_id =", value, "nnlightctlWorkflowerMoveRecordId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_move_record_id <>", value, "nnlightctlWorkflowerMoveRecordId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdGreaterThan(Long value) {
            addCriterion("nnlightctl_workflower_move_record_id >", value, "nnlightctlWorkflowerMoveRecordId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_move_record_id >=", value, "nnlightctlWorkflowerMoveRecordId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdLessThan(Long value) {
            addCriterion("nnlightctl_workflower_move_record_id <", value, "nnlightctlWorkflowerMoveRecordId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_move_record_id <=", value, "nnlightctlWorkflowerMoveRecordId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdIn(List<Long> values) {
            addCriterion("nnlightctl_workflower_move_record_id in", values, "nnlightctlWorkflowerMoveRecordId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_workflower_move_record_id not in", values, "nnlightctlWorkflowerMoveRecordId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_workflower_move_record_id between", value1, value2, "nnlightctlWorkflowerMoveRecordId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerMoveRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_workflower_move_record_id not between", value1, value2, "nnlightctlWorkflowerMoveRecordId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdIsNull() {
            addCriterion("nnlightctl_masker_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdIsNotNull() {
            addCriterion("nnlightctl_masker_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdEqualTo(Long value) {
            addCriterion("nnlightctl_masker_id =", value, "nnlightctlMaskerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_masker_id <>", value, "nnlightctlMaskerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdGreaterThan(Long value) {
            addCriterion("nnlightctl_masker_id >", value, "nnlightctlMaskerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_masker_id >=", value, "nnlightctlMaskerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdLessThan(Long value) {
            addCriterion("nnlightctl_masker_id <", value, "nnlightctlMaskerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_masker_id <=", value, "nnlightctlMaskerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdIn(List<Long> values) {
            addCriterion("nnlightctl_masker_id in", values, "nnlightctlMaskerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_masker_id not in", values, "nnlightctlMaskerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_masker_id between", value1, value2, "nnlightctlMaskerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaskerIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_masker_id not between", value1, value2, "nnlightctlMaskerId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathIsNull() {
            addCriterion("attach_file_path is null");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathIsNotNull() {
            addCriterion("attach_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathEqualTo(String value) {
            addCriterion("attach_file_path =", value, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathNotEqualTo(String value) {
            addCriterion("attach_file_path <>", value, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathGreaterThan(String value) {
            addCriterion("attach_file_path >", value, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("attach_file_path >=", value, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathLessThan(String value) {
            addCriterion("attach_file_path <", value, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathLessThanOrEqualTo(String value) {
            addCriterion("attach_file_path <=", value, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathLike(String value) {
            addCriterion("attach_file_path like", value, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathNotLike(String value) {
            addCriterion("attach_file_path not like", value, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathIn(List<String> values) {
            addCriterion("attach_file_path in", values, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathNotIn(List<String> values) {
            addCriterion("attach_file_path not in", values, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathBetween(String value1, String value2) {
            addCriterion("attach_file_path between", value1, value2, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andAttachFilePathNotBetween(String value1, String value2) {
            addCriterion("attach_file_path not between", value1, value2, "attachFilePath");
            return (Criteria) this;
        }

        public Criteria andWorkSourceIsNull() {
            addCriterion("work_source is null");
            return (Criteria) this;
        }

        public Criteria andWorkSourceIsNotNull() {
            addCriterion("work_source is not null");
            return (Criteria) this;
        }

        public Criteria andWorkSourceEqualTo(Byte value) {
            addCriterion("work_source =", value, "workSource");
            return (Criteria) this;
        }

        public Criteria andWorkSourceNotEqualTo(Byte value) {
            addCriterion("work_source <>", value, "workSource");
            return (Criteria) this;
        }

        public Criteria andWorkSourceGreaterThan(Byte value) {
            addCriterion("work_source >", value, "workSource");
            return (Criteria) this;
        }

        public Criteria andWorkSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("work_source >=", value, "workSource");
            return (Criteria) this;
        }

        public Criteria andWorkSourceLessThan(Byte value) {
            addCriterion("work_source <", value, "workSource");
            return (Criteria) this;
        }

        public Criteria andWorkSourceLessThanOrEqualTo(Byte value) {
            addCriterion("work_source <=", value, "workSource");
            return (Criteria) this;
        }

        public Criteria andWorkSourceIn(List<Byte> values) {
            addCriterion("work_source in", values, "workSource");
            return (Criteria) this;
        }

        public Criteria andWorkSourceNotIn(List<Byte> values) {
            addCriterion("work_source not in", values, "workSource");
            return (Criteria) this;
        }

        public Criteria andWorkSourceBetween(Byte value1, Byte value2) {
            addCriterion("work_source between", value1, value2, "workSource");
            return (Criteria) this;
        }

        public Criteria andWorkSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("work_source not between", value1, value2, "workSource");
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