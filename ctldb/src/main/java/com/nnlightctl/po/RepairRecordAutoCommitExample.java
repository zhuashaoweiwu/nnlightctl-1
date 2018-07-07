package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairRecordAutoCommitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepairRecordAutoCommitExample() {
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

        public Criteria andAutoCommitTimeIsNull() {
            addCriterion("auto_commit_time is null");
            return (Criteria) this;
        }

        public Criteria andAutoCommitTimeIsNotNull() {
            addCriterion("auto_commit_time is not null");
            return (Criteria) this;
        }

        public Criteria andAutoCommitTimeEqualTo(Date value) {
            addCriterion("auto_commit_time =", value, "autoCommitTime");
            return (Criteria) this;
        }

        public Criteria andAutoCommitTimeNotEqualTo(Date value) {
            addCriterion("auto_commit_time <>", value, "autoCommitTime");
            return (Criteria) this;
        }

        public Criteria andAutoCommitTimeGreaterThan(Date value) {
            addCriterion("auto_commit_time >", value, "autoCommitTime");
            return (Criteria) this;
        }

        public Criteria andAutoCommitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("auto_commit_time >=", value, "autoCommitTime");
            return (Criteria) this;
        }

        public Criteria andAutoCommitTimeLessThan(Date value) {
            addCriterion("auto_commit_time <", value, "autoCommitTime");
            return (Criteria) this;
        }

        public Criteria andAutoCommitTimeLessThanOrEqualTo(Date value) {
            addCriterion("auto_commit_time <=", value, "autoCommitTime");
            return (Criteria) this;
        }

        public Criteria andAutoCommitTimeIn(List<Date> values) {
            addCriterion("auto_commit_time in", values, "autoCommitTime");
            return (Criteria) this;
        }

        public Criteria andAutoCommitTimeNotIn(List<Date> values) {
            addCriterion("auto_commit_time not in", values, "autoCommitTime");
            return (Criteria) this;
        }

        public Criteria andAutoCommitTimeBetween(Date value1, Date value2) {
            addCriterion("auto_commit_time between", value1, value2, "autoCommitTime");
            return (Criteria) this;
        }

        public Criteria andAutoCommitTimeNotBetween(Date value1, Date value2) {
            addCriterion("auto_commit_time not between", value1, value2, "autoCommitTime");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdIsNull() {
            addCriterion("repair_record_id is null");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdIsNotNull() {
            addCriterion("repair_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdEqualTo(Long value) {
            addCriterion("repair_record_id =", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdNotEqualTo(Long value) {
            addCriterion("repair_record_id <>", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdGreaterThan(Long value) {
            addCriterion("repair_record_id >", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("repair_record_id >=", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdLessThan(Long value) {
            addCriterion("repair_record_id <", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("repair_record_id <=", value, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdIn(List<Long> values) {
            addCriterion("repair_record_id in", values, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdNotIn(List<Long> values) {
            addCriterion("repair_record_id not in", values, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdBetween(Long value1, Long value2) {
            addCriterion("repair_record_id between", value1, value2, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andRepairRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("repair_record_id not between", value1, value2, "repairRecordId");
            return (Criteria) this;
        }

        public Criteria andCommitStateIsNull() {
            addCriterion("commit_state is null");
            return (Criteria) this;
        }

        public Criteria andCommitStateIsNotNull() {
            addCriterion("commit_state is not null");
            return (Criteria) this;
        }

        public Criteria andCommitStateEqualTo(Byte value) {
            addCriterion("commit_state =", value, "commitState");
            return (Criteria) this;
        }

        public Criteria andCommitStateNotEqualTo(Byte value) {
            addCriterion("commit_state <>", value, "commitState");
            return (Criteria) this;
        }

        public Criteria andCommitStateGreaterThan(Byte value) {
            addCriterion("commit_state >", value, "commitState");
            return (Criteria) this;
        }

        public Criteria andCommitStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("commit_state >=", value, "commitState");
            return (Criteria) this;
        }

        public Criteria andCommitStateLessThan(Byte value) {
            addCriterion("commit_state <", value, "commitState");
            return (Criteria) this;
        }

        public Criteria andCommitStateLessThanOrEqualTo(Byte value) {
            addCriterion("commit_state <=", value, "commitState");
            return (Criteria) this;
        }

        public Criteria andCommitStateIn(List<Byte> values) {
            addCriterion("commit_state in", values, "commitState");
            return (Criteria) this;
        }

        public Criteria andCommitStateNotIn(List<Byte> values) {
            addCriterion("commit_state not in", values, "commitState");
            return (Criteria) this;
        }

        public Criteria andCommitStateBetween(Byte value1, Byte value2) {
            addCriterion("commit_state between", value1, value2, "commitState");
            return (Criteria) this;
        }

        public Criteria andCommitStateNotBetween(Byte value1, Byte value2) {
            addCriterion("commit_state not between", value1, value2, "commitState");
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