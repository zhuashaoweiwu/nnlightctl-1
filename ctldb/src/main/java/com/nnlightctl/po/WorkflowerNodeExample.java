package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkflowerNodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkflowerNodeExample() {
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

        public Criteria andWorkflowerNodeNameIsNull() {
            addCriterion("workflower_node_name is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameIsNotNull() {
            addCriterion("workflower_node_name is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameEqualTo(String value) {
            addCriterion("workflower_node_name =", value, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameNotEqualTo(String value) {
            addCriterion("workflower_node_name <>", value, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameGreaterThan(String value) {
            addCriterion("workflower_node_name >", value, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("workflower_node_name >=", value, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameLessThan(String value) {
            addCriterion("workflower_node_name <", value, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameLessThanOrEqualTo(String value) {
            addCriterion("workflower_node_name <=", value, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameLike(String value) {
            addCriterion("workflower_node_name like", value, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameNotLike(String value) {
            addCriterion("workflower_node_name not like", value, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameIn(List<String> values) {
            addCriterion("workflower_node_name in", values, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameNotIn(List<String> values) {
            addCriterion("workflower_node_name not in", values, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameBetween(String value1, String value2) {
            addCriterion("workflower_node_name between", value1, value2, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeNameNotBetween(String value1, String value2) {
            addCriterion("workflower_node_name not between", value1, value2, "workflowerNodeName");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeIsNull() {
            addCriterion("workflower_node_code is null");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeIsNotNull() {
            addCriterion("workflower_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeEqualTo(String value) {
            addCriterion("workflower_node_code =", value, "workflowerNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeNotEqualTo(String value) {
            addCriterion("workflower_node_code <>", value, "workflowerNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeGreaterThan(String value) {
            addCriterion("workflower_node_code >", value, "workflowerNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("workflower_node_code >=", value, "workflowerNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeLessThan(String value) {
            addCriterion("workflower_node_code <", value, "workflowerNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("workflower_node_code <=", value, "workflowerNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeLike(String value) {
            addCriterion("workflower_node_code like", value, "workflowerNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeNotLike(String value) {
            addCriterion("workflower_node_code not like", value, "workflowerNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeIn(List<String> values) {
            addCriterion("workflower_node_code in", values, "workflowerNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeNotIn(List<String> values) {
            addCriterion("workflower_node_code not in", values, "workflowerNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeBetween(String value1, String value2) {
            addCriterion("workflower_node_code between", value1, value2, "workflowerNodeCode");
            return (Criteria) this;
        }

        public Criteria andWorkflowerNodeCodeNotBetween(String value1, String value2) {
            addCriterion("workflower_node_code not between", value1, value2, "workflowerNodeCode");
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