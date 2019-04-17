package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepertoryOutRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepertoryOutRecordExample() {
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

        public Criteria andOutRepertoryDateIsNull() {
            addCriterion("out_repertory_date is null");
            return (Criteria) this;
        }

        public Criteria andOutRepertoryDateIsNotNull() {
            addCriterion("out_repertory_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutRepertoryDateEqualTo(Date value) {
            addCriterion("out_repertory_date =", value, "outRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andOutRepertoryDateNotEqualTo(Date value) {
            addCriterion("out_repertory_date <>", value, "outRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andOutRepertoryDateGreaterThan(Date value) {
            addCriterion("out_repertory_date >", value, "outRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andOutRepertoryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("out_repertory_date >=", value, "outRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andOutRepertoryDateLessThan(Date value) {
            addCriterion("out_repertory_date <", value, "outRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andOutRepertoryDateLessThanOrEqualTo(Date value) {
            addCriterion("out_repertory_date <=", value, "outRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andOutRepertoryDateIn(List<Date> values) {
            addCriterion("out_repertory_date in", values, "outRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andOutRepertoryDateNotIn(List<Date> values) {
            addCriterion("out_repertory_date not in", values, "outRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andOutRepertoryDateBetween(Date value1, Date value2) {
            addCriterion("out_repertory_date between", value1, value2, "outRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andOutRepertoryDateNotBetween(Date value1, Date value2) {
            addCriterion("out_repertory_date not between", value1, value2, "outRepertoryDate");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdIsNull() {
            addCriterion("nnlightctl_material_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdIsNotNull() {
            addCriterion("nnlightctl_material_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdEqualTo(Long value) {
            addCriterion("nnlightctl_material_id =", value, "nnlightctlMaterialId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_material_id <>", value, "nnlightctlMaterialId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdGreaterThan(Long value) {
            addCriterion("nnlightctl_material_id >", value, "nnlightctlMaterialId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_material_id >=", value, "nnlightctlMaterialId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdLessThan(Long value) {
            addCriterion("nnlightctl_material_id <", value, "nnlightctlMaterialId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_material_id <=", value, "nnlightctlMaterialId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdIn(List<Long> values) {
            addCriterion("nnlightctl_material_id in", values, "nnlightctlMaterialId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_material_id not in", values, "nnlightctlMaterialId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_material_id between", value1, value2, "nnlightctlMaterialId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlMaterialIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_material_id not between", value1, value2, "nnlightctlMaterialId");
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