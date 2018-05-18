package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SceneShotcutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SceneShotcutExample() {
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

        public Criteria andShotcutNameIsNull() {
            addCriterion("shotcut_name is null");
            return (Criteria) this;
        }

        public Criteria andShotcutNameIsNotNull() {
            addCriterion("shotcut_name is not null");
            return (Criteria) this;
        }

        public Criteria andShotcutNameEqualTo(String value) {
            addCriterion("shotcut_name =", value, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andShotcutNameNotEqualTo(String value) {
            addCriterion("shotcut_name <>", value, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andShotcutNameGreaterThan(String value) {
            addCriterion("shotcut_name >", value, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andShotcutNameGreaterThanOrEqualTo(String value) {
            addCriterion("shotcut_name >=", value, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andShotcutNameLessThan(String value) {
            addCriterion("shotcut_name <", value, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andShotcutNameLessThanOrEqualTo(String value) {
            addCriterion("shotcut_name <=", value, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andShotcutNameLike(String value) {
            addCriterion("shotcut_name like", value, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andShotcutNameNotLike(String value) {
            addCriterion("shotcut_name not like", value, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andShotcutNameIn(List<String> values) {
            addCriterion("shotcut_name in", values, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andShotcutNameNotIn(List<String> values) {
            addCriterion("shotcut_name not in", values, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andShotcutNameBetween(String value1, String value2) {
            addCriterion("shotcut_name between", value1, value2, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andShotcutNameNotBetween(String value1, String value2) {
            addCriterion("shotcut_name not between", value1, value2, "shotcutName");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdIsNull() {
            addCriterion("nnlightctl_scene_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdIsNotNull() {
            addCriterion("nnlightctl_scene_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdEqualTo(Long value) {
            addCriterion("nnlightctl_scene_id =", value, "nnlightctlSceneId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_scene_id <>", value, "nnlightctlSceneId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdGreaterThan(Long value) {
            addCriterion("nnlightctl_scene_id >", value, "nnlightctlSceneId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_scene_id >=", value, "nnlightctlSceneId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdLessThan(Long value) {
            addCriterion("nnlightctl_scene_id <", value, "nnlightctlSceneId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_scene_id <=", value, "nnlightctlSceneId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdIn(List<Long> values) {
            addCriterion("nnlightctl_scene_id in", values, "nnlightctlSceneId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_scene_id not in", values, "nnlightctlSceneId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_scene_id between", value1, value2, "nnlightctlSceneId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSceneIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_scene_id not between", value1, value2, "nnlightctlSceneId");
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