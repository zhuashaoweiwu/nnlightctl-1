package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkflowerMoveRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkflowerMoveRecordExample() {
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

        public Criteria andNnlightctlWorkOrderIdIsNull() {
            addCriterion("nnlightctl_work_order_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkOrderIdIsNotNull() {
            addCriterion("nnlightctl_work_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkOrderIdEqualTo(Long value) {
            addCriterion("nnlightctl_work_order_id =", value, "nnlightctlWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkOrderIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_work_order_id <>", value, "nnlightctlWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkOrderIdGreaterThan(Long value) {
            addCriterion("nnlightctl_work_order_id >", value, "nnlightctlWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_work_order_id >=", value, "nnlightctlWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkOrderIdLessThan(Long value) {
            addCriterion("nnlightctl_work_order_id <", value, "nnlightctlWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_work_order_id <=", value, "nnlightctlWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkOrderIdIn(List<Long> values) {
            addCriterion("nnlightctl_work_order_id in", values, "nnlightctlWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkOrderIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_work_order_id not in", values, "nnlightctlWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkOrderIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_work_order_id between", value1, value2, "nnlightctlWorkOrderId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_work_order_id not between", value1, value2, "nnlightctlWorkOrderId");
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

        public Criteria andNnlightctlWorkflowerNodeIdIsNull() {
            addCriterion("nnlightctl_workflower_node_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerNodeIdIsNotNull() {
            addCriterion("nnlightctl_workflower_node_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerNodeIdEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_node_id =", value, "nnlightctlWorkflowerNodeId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerNodeIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_node_id <>", value, "nnlightctlWorkflowerNodeId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerNodeIdGreaterThan(Long value) {
            addCriterion("nnlightctl_workflower_node_id >", value, "nnlightctlWorkflowerNodeId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerNodeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_node_id >=", value, "nnlightctlWorkflowerNodeId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerNodeIdLessThan(Long value) {
            addCriterion("nnlightctl_workflower_node_id <", value, "nnlightctlWorkflowerNodeId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerNodeIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_workflower_node_id <=", value, "nnlightctlWorkflowerNodeId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerNodeIdIn(List<Long> values) {
            addCriterion("nnlightctl_workflower_node_id in", values, "nnlightctlWorkflowerNodeId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerNodeIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_workflower_node_id not in", values, "nnlightctlWorkflowerNodeId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerNodeIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_workflower_node_id between", value1, value2, "nnlightctlWorkflowerNodeId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlWorkflowerNodeIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_workflower_node_id not between", value1, value2, "nnlightctlWorkflowerNodeId");
            return (Criteria) this;
        }

        public Criteria andPassStateIsNull() {
            addCriterion("pass_state is null");
            return (Criteria) this;
        }

        public Criteria andPassStateIsNotNull() {
            addCriterion("pass_state is not null");
            return (Criteria) this;
        }

        public Criteria andPassStateEqualTo(Byte value) {
            addCriterion("pass_state =", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateNotEqualTo(Byte value) {
            addCriterion("pass_state <>", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateGreaterThan(Byte value) {
            addCriterion("pass_state >", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("pass_state >=", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateLessThan(Byte value) {
            addCriterion("pass_state <", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateLessThanOrEqualTo(Byte value) {
            addCriterion("pass_state <=", value, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateIn(List<Byte> values) {
            addCriterion("pass_state in", values, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateNotIn(List<Byte> values) {
            addCriterion("pass_state not in", values, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateBetween(Byte value1, Byte value2) {
            addCriterion("pass_state between", value1, value2, "passState");
            return (Criteria) this;
        }

        public Criteria andPassStateNotBetween(Byte value1, Byte value2) {
            addCriterion("pass_state not between", value1, value2, "passState");
            return (Criteria) this;
        }

        public Criteria andDeniedResonIsNull() {
            addCriterion("denied_reson is null");
            return (Criteria) this;
        }

        public Criteria andDeniedResonIsNotNull() {
            addCriterion("denied_reson is not null");
            return (Criteria) this;
        }

        public Criteria andDeniedResonEqualTo(String value) {
            addCriterion("denied_reson =", value, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andDeniedResonNotEqualTo(String value) {
            addCriterion("denied_reson <>", value, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andDeniedResonGreaterThan(String value) {
            addCriterion("denied_reson >", value, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andDeniedResonGreaterThanOrEqualTo(String value) {
            addCriterion("denied_reson >=", value, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andDeniedResonLessThan(String value) {
            addCriterion("denied_reson <", value, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andDeniedResonLessThanOrEqualTo(String value) {
            addCriterion("denied_reson <=", value, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andDeniedResonLike(String value) {
            addCriterion("denied_reson like", value, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andDeniedResonNotLike(String value) {
            addCriterion("denied_reson not like", value, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andDeniedResonIn(List<String> values) {
            addCriterion("denied_reson in", values, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andDeniedResonNotIn(List<String> values) {
            addCriterion("denied_reson not in", values, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andDeniedResonBetween(String value1, String value2) {
            addCriterion("denied_reson between", value1, value2, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andDeniedResonNotBetween(String value1, String value2) {
            addCriterion("denied_reson not between", value1, value2, "deniedReson");
            return (Criteria) this;
        }

        public Criteria andMoveStateIsNull() {
            addCriterion("move_state is null");
            return (Criteria) this;
        }

        public Criteria andMoveStateIsNotNull() {
            addCriterion("move_state is not null");
            return (Criteria) this;
        }

        public Criteria andMoveStateEqualTo(Byte value) {
            addCriterion("move_state =", value, "moveState");
            return (Criteria) this;
        }

        public Criteria andMoveStateNotEqualTo(Byte value) {
            addCriterion("move_state <>", value, "moveState");
            return (Criteria) this;
        }

        public Criteria andMoveStateGreaterThan(Byte value) {
            addCriterion("move_state >", value, "moveState");
            return (Criteria) this;
        }

        public Criteria andMoveStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("move_state >=", value, "moveState");
            return (Criteria) this;
        }

        public Criteria andMoveStateLessThan(Byte value) {
            addCriterion("move_state <", value, "moveState");
            return (Criteria) this;
        }

        public Criteria andMoveStateLessThanOrEqualTo(Byte value) {
            addCriterion("move_state <=", value, "moveState");
            return (Criteria) this;
        }

        public Criteria andMoveStateIn(List<Byte> values) {
            addCriterion("move_state in", values, "moveState");
            return (Criteria) this;
        }

        public Criteria andMoveStateNotIn(List<Byte> values) {
            addCriterion("move_state not in", values, "moveState");
            return (Criteria) this;
        }

        public Criteria andMoveStateBetween(Byte value1, Byte value2) {
            addCriterion("move_state between", value1, value2, "moveState");
            return (Criteria) this;
        }

        public Criteria andMoveStateNotBetween(Byte value1, Byte value2) {
            addCriterion("move_state not between", value1, value2, "moveState");
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