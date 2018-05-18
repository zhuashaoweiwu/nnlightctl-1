package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EleboxModelLoopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EleboxModelLoopExample() {
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

        public Criteria andVoltageIsNull() {
            addCriterion("voltage is null");
            return (Criteria) this;
        }

        public Criteria andVoltageIsNotNull() {
            addCriterion("voltage is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageEqualTo(Long value) {
            addCriterion("voltage =", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotEqualTo(Long value) {
            addCriterion("voltage <>", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThan(Long value) {
            addCriterion("voltage >", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThanOrEqualTo(Long value) {
            addCriterion("voltage >=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThan(Long value) {
            addCriterion("voltage <", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThanOrEqualTo(Long value) {
            addCriterion("voltage <=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageIn(List<Long> values) {
            addCriterion("voltage in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotIn(List<Long> values) {
            addCriterion("voltage not in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageBetween(Long value1, Long value2) {
            addCriterion("voltage between", value1, value2, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotBetween(Long value1, Long value2) {
            addCriterion("voltage not between", value1, value2, "voltage");
            return (Criteria) this;
        }

        public Criteria andElectricityIsNull() {
            addCriterion("electricity is null");
            return (Criteria) this;
        }

        public Criteria andElectricityIsNotNull() {
            addCriterion("electricity is not null");
            return (Criteria) this;
        }

        public Criteria andElectricityEqualTo(Long value) {
            addCriterion("electricity =", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotEqualTo(Long value) {
            addCriterion("electricity <>", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThan(Long value) {
            addCriterion("electricity >", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThanOrEqualTo(Long value) {
            addCriterion("electricity >=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThan(Long value) {
            addCriterion("electricity <", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThanOrEqualTo(Long value) {
            addCriterion("electricity <=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityIn(List<Long> values) {
            addCriterion("electricity in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotIn(List<Long> values) {
            addCriterion("electricity not in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityBetween(Long value1, Long value2) {
            addCriterion("electricity between", value1, value2, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotBetween(Long value1, Long value2) {
            addCriterion("electricity not between", value1, value2, "electricity");
            return (Criteria) this;
        }

        public Criteria andLightCountIsNull() {
            addCriterion("light_count is null");
            return (Criteria) this;
        }

        public Criteria andLightCountIsNotNull() {
            addCriterion("light_count is not null");
            return (Criteria) this;
        }

        public Criteria andLightCountEqualTo(Byte value) {
            addCriterion("light_count =", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountNotEqualTo(Byte value) {
            addCriterion("light_count <>", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountGreaterThan(Byte value) {
            addCriterion("light_count >", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("light_count >=", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountLessThan(Byte value) {
            addCriterion("light_count <", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountLessThanOrEqualTo(Byte value) {
            addCriterion("light_count <=", value, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountIn(List<Byte> values) {
            addCriterion("light_count in", values, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountNotIn(List<Byte> values) {
            addCriterion("light_count not in", values, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountBetween(Byte value1, Byte value2) {
            addCriterion("light_count between", value1, value2, "lightCount");
            return (Criteria) this;
        }

        public Criteria andLightCountNotBetween(Byte value1, Byte value2) {
            addCriterion("light_count not between", value1, value2, "lightCount");
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

        public Criteria andNnlightctlEleboxModelIdIsNull() {
            addCriterion("nnlightctl_elebox_model_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelIdIsNotNull() {
            addCriterion("nnlightctl_elebox_model_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelIdEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_model_id =", value, "nnlightctlEleboxModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_model_id <>", value, "nnlightctlEleboxModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelIdGreaterThan(Long value) {
            addCriterion("nnlightctl_elebox_model_id >", value, "nnlightctlEleboxModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_model_id >=", value, "nnlightctlEleboxModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelIdLessThan(Long value) {
            addCriterion("nnlightctl_elebox_model_id <", value, "nnlightctlEleboxModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_model_id <=", value, "nnlightctlEleboxModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelIdIn(List<Long> values) {
            addCriterion("nnlightctl_elebox_model_id in", values, "nnlightctlEleboxModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_elebox_model_id not in", values, "nnlightctlEleboxModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_elebox_model_id between", value1, value2, "nnlightctlEleboxModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_elebox_model_id not between", value1, value2, "nnlightctlEleboxModelId");
            return (Criteria) this;
        }

        public Criteria andLoopCodeIsNull() {
            addCriterion("loop_code is null");
            return (Criteria) this;
        }

        public Criteria andLoopCodeIsNotNull() {
            addCriterion("loop_code is not null");
            return (Criteria) this;
        }

        public Criteria andLoopCodeEqualTo(String value) {
            addCriterion("loop_code =", value, "loopCode");
            return (Criteria) this;
        }

        public Criteria andLoopCodeNotEqualTo(String value) {
            addCriterion("loop_code <>", value, "loopCode");
            return (Criteria) this;
        }

        public Criteria andLoopCodeGreaterThan(String value) {
            addCriterion("loop_code >", value, "loopCode");
            return (Criteria) this;
        }

        public Criteria andLoopCodeGreaterThanOrEqualTo(String value) {
            addCriterion("loop_code >=", value, "loopCode");
            return (Criteria) this;
        }

        public Criteria andLoopCodeLessThan(String value) {
            addCriterion("loop_code <", value, "loopCode");
            return (Criteria) this;
        }

        public Criteria andLoopCodeLessThanOrEqualTo(String value) {
            addCriterion("loop_code <=", value, "loopCode");
            return (Criteria) this;
        }

        public Criteria andLoopCodeLike(String value) {
            addCriterion("loop_code like", value, "loopCode");
            return (Criteria) this;
        }

        public Criteria andLoopCodeNotLike(String value) {
            addCriterion("loop_code not like", value, "loopCode");
            return (Criteria) this;
        }

        public Criteria andLoopCodeIn(List<String> values) {
            addCriterion("loop_code in", values, "loopCode");
            return (Criteria) this;
        }

        public Criteria andLoopCodeNotIn(List<String> values) {
            addCriterion("loop_code not in", values, "loopCode");
            return (Criteria) this;
        }

        public Criteria andLoopCodeBetween(String value1, String value2) {
            addCriterion("loop_code between", value1, value2, "loopCode");
            return (Criteria) this;
        }

        public Criteria andLoopCodeNotBetween(String value1, String value2) {
            addCriterion("loop_code not between", value1, value2, "loopCode");
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