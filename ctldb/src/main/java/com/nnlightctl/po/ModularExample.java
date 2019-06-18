package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.List;

public class ModularExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModularExample() {
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

        public Criteria andModularModelIsNull() {
            addCriterion("modular_model is null");
            return (Criteria) this;
        }

        public Criteria andModularModelIsNotNull() {
            addCriterion("modular_model is not null");
            return (Criteria) this;
        }

        public Criteria andModularModelEqualTo(String value) {
            addCriterion("modular_model =", value, "modularModel");
            return (Criteria) this;
        }

        public Criteria andModularModelNotEqualTo(String value) {
            addCriterion("modular_model <>", value, "modularModel");
            return (Criteria) this;
        }

        public Criteria andModularModelGreaterThan(String value) {
            addCriterion("modular_model >", value, "modularModel");
            return (Criteria) this;
        }

        public Criteria andModularModelGreaterThanOrEqualTo(String value) {
            addCriterion("modular_model >=", value, "modularModel");
            return (Criteria) this;
        }

        public Criteria andModularModelLessThan(String value) {
            addCriterion("modular_model <", value, "modularModel");
            return (Criteria) this;
        }

        public Criteria andModularModelLessThanOrEqualTo(String value) {
            addCriterion("modular_model <=", value, "modularModel");
            return (Criteria) this;
        }

        public Criteria andModularModelLike(String value) {
            addCriterion("modular_model like", value, "modularModel");
            return (Criteria) this;
        }

        public Criteria andequipmentNumberLike(String value) {
            addCriterion("equipment_number like", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andModularModelNotLike(String value) {
            addCriterion("modular_model not like", value, "modularModel");
            return (Criteria) this;
        }

        public Criteria andModularModelIn(List<String> values) {
            addCriterion("modular_model in", values, "modularModel");
            return (Criteria) this;
        }

        public Criteria andModularModelNotIn(List<String> values) {
            addCriterion("modular_model not in", values, "modularModel");
            return (Criteria) this;
        }

        public Criteria andModularModelBetween(String value1, String value2) {
            addCriterion("modular_model between", value1, value2, "modularModel");
            return (Criteria) this;
        }

        public Criteria andModularModelNotBetween(String value1, String value2) {
            addCriterion("modular_model not between", value1, value2, "modularModel");
            return (Criteria) this;
        }

        public Criteria andModularNameIsNull() {
            addCriterion("modular_name is null");
            return (Criteria) this;
        }

        public Criteria andModularNameIsNotNull() {
            addCriterion("modular_name is not null");
            return (Criteria) this;
        }

        public Criteria andModularNameEqualTo(String value) {
            addCriterion("modular_name =", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotEqualTo(String value) {
            addCriterion("modular_name <>", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameGreaterThan(String value) {
            addCriterion("modular_name >", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameGreaterThanOrEqualTo(String value) {
            addCriterion("modular_name >=", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameLessThan(String value) {
            addCriterion("modular_name <", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameLessThanOrEqualTo(String value) {
            addCriterion("modular_name <=", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameLike(String value) {
            addCriterion("modular_name like", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotLike(String value) {
            addCriterion("modular_name not like", value, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameIn(List<String> values) {
            addCriterion("modular_name in", values, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotIn(List<String> values) {
            addCriterion("modular_name not in", values, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameBetween(String value1, String value2) {
            addCriterion("modular_name between", value1, value2, "modularName");
            return (Criteria) this;
        }

        public Criteria andModularNameNotBetween(String value1, String value2) {
            addCriterion("modular_name not between", value1, value2, "modularName");
            return (Criteria) this;
        }

        public Criteria andLoopNumberIsNull() {
            addCriterion("loop_number is null");
            return (Criteria) this;
        }

        public Criteria andLoopNumberIsNotNull() {
            addCriterion("loop_number is not null");
            return (Criteria) this;
        }

        public Criteria andLoopNumberEqualTo(Integer value) {
            addCriterion("loop_number =", value, "loopNumber");
            return (Criteria) this;
        }

        public Criteria andLoopNumberNotEqualTo(Integer value) {
            addCriterion("loop_number <>", value, "loopNumber");
            return (Criteria) this;
        }

        public Criteria andLoopNumberGreaterThan(Integer value) {
            addCriterion("loop_number >", value, "loopNumber");
            return (Criteria) this;
        }

        public Criteria andLoopNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("loop_number >=", value, "loopNumber");
            return (Criteria) this;
        }

        public Criteria andLoopNumberLessThan(Integer value) {
            addCriterion("loop_number <", value, "loopNumber");
            return (Criteria) this;
        }

        public Criteria andLoopNumberLessThanOrEqualTo(Integer value) {
            addCriterion("loop_number <=", value, "loopNumber");
            return (Criteria) this;
        }

        public Criteria andLoopNumberIn(List<Integer> values) {
            addCriterion("loop_number in", values, "loopNumber");
            return (Criteria) this;
        }

        public Criteria andLoopNumberNotIn(List<Integer> values) {
            addCriterion("loop_number not in", values, "loopNumber");
            return (Criteria) this;
        }

        public Criteria andLoopNumberBetween(Integer value1, Integer value2) {
            addCriterion("loop_number between", value1, value2, "loopNumber");
            return (Criteria) this;
        }

        public Criteria andLoopNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("loop_number not between", value1, value2, "loopNumber");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeIsNull() {
            addCriterion("communication_mode is null");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeIsNotNull() {
            addCriterion("communication_mode is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeEqualTo(String value) {
            addCriterion("communication_mode =", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeNotEqualTo(String value) {
            addCriterion("communication_mode <>", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeGreaterThan(String value) {
            addCriterion("communication_mode >", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeGreaterThanOrEqualTo(String value) {
            addCriterion("communication_mode >=", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeLessThan(String value) {
            addCriterion("communication_mode <", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeLessThanOrEqualTo(String value) {
            addCriterion("communication_mode <=", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeLike(String value) {
            addCriterion("communication_mode like", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeNotLike(String value) {
            addCriterion("communication_mode not like", value, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeIn(List<String> values) {
            addCriterion("communication_mode in", values, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeNotIn(List<String> values) {
            addCriterion("communication_mode not in", values, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeBetween(String value1, String value2) {
            addCriterion("communication_mode between", value1, value2, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andCommunicationModeNotBetween(String value1, String value2) {
            addCriterion("communication_mode not between", value1, value2, "communicationMode");
            return (Criteria) this;
        }

        public Criteria andMaxElectricIsNull() {
            addCriterion("max_electric is null");
            return (Criteria) this;
        }

        public Criteria andMaxElectricIsNotNull() {
            addCriterion("max_electric is not null");
            return (Criteria) this;
        }

        public Criteria andMaxElectricEqualTo(Integer value) {
            addCriterion("max_electric =", value, "maxElectric");
            return (Criteria) this;
        }

        public Criteria andMaxElectricNotEqualTo(Integer value) {
            addCriterion("max_electric <>", value, "maxElectric");
            return (Criteria) this;
        }

        public Criteria andMaxElectricGreaterThan(Integer value) {
            addCriterion("max_electric >", value, "maxElectric");
            return (Criteria) this;
        }

        public Criteria andMaxElectricGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_electric >=", value, "maxElectric");
            return (Criteria) this;
        }

        public Criteria andMaxElectricLessThan(Integer value) {
            addCriterion("max_electric <", value, "maxElectric");
            return (Criteria) this;
        }

        public Criteria andMaxElectricLessThanOrEqualTo(Integer value) {
            addCriterion("max_electric <=", value, "maxElectric");
            return (Criteria) this;
        }

        public Criteria andMaxElectricIn(List<Integer> values) {
            addCriterion("max_electric in", values, "maxElectric");
            return (Criteria) this;
        }

        public Criteria andMaxElectricNotIn(List<Integer> values) {
            addCriterion("max_electric not in", values, "maxElectric");
            return (Criteria) this;
        }

        public Criteria andMaxElectricBetween(Integer value1, Integer value2) {
            addCriterion("max_electric between", value1, value2, "maxElectric");
            return (Criteria) this;
        }

        public Criteria andMaxElectricNotBetween(Integer value1, Integer value2) {
            addCriterion("max_electric not between", value1, value2, "maxElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricIsNull() {
            addCriterion("load_electric is null");
            return (Criteria) this;
        }

        public Criteria andLoadElectricIsNotNull() {
            addCriterion("load_electric is not null");
            return (Criteria) this;
        }

        public Criteria andLoadElectricEqualTo(String value) {
            addCriterion("load_electric =", value, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricNotEqualTo(String value) {
            addCriterion("load_electric <>", value, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricGreaterThan(String value) {
            addCriterion("load_electric >", value, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricGreaterThanOrEqualTo(String value) {
            addCriterion("load_electric >=", value, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricLessThan(String value) {
            addCriterion("load_electric <", value, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricLessThanOrEqualTo(String value) {
            addCriterion("load_electric <=", value, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricLike(String value) {
            addCriterion("load_electric like", value, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricNotLike(String value) {
            addCriterion("load_electric not like", value, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricIn(List<String> values) {
            addCriterion("load_electric in", values, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricNotIn(List<String> values) {
            addCriterion("load_electric not in", values, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricBetween(String value1, String value2) {
            addCriterion("load_electric between", value1, value2, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andLoadElectricNotBetween(String value1, String value2) {
            addCriterion("load_electric not between", value1, value2, "loadElectric");
            return (Criteria) this;
        }

        public Criteria andInstallationModeIsNull() {
            addCriterion("Installation_mode is null");
            return (Criteria) this;
        }

        public Criteria andInstallationModeIsNotNull() {
            addCriterion("Installation_mode is not null");
            return (Criteria) this;
        }

        public Criteria andInstallationModeEqualTo(String value) {
            addCriterion("Installation_mode =", value, "installationMode");
            return (Criteria) this;
        }

        public Criteria andInstallationModeNotEqualTo(String value) {
            addCriterion("Installation_mode <>", value, "installationMode");
            return (Criteria) this;
        }

        public Criteria andInstallationModeGreaterThan(String value) {
            addCriterion("Installation_mode >", value, "installationMode");
            return (Criteria) this;
        }

        public Criteria andInstallationModeGreaterThanOrEqualTo(String value) {
            addCriterion("Installation_mode >=", value, "installationMode");
            return (Criteria) this;
        }

        public Criteria andInstallationModeLessThan(String value) {
            addCriterion("Installation_mode <", value, "installationMode");
            return (Criteria) this;
        }

        public Criteria andInstallationModeLessThanOrEqualTo(String value) {
            addCriterion("Installation_mode <=", value, "installationMode");
            return (Criteria) this;
        }

        public Criteria andInstallationModeLike(String value) {
            addCriterion("Installation_mode like", value, "installationMode");
            return (Criteria) this;
        }

        public Criteria andInstallationModeNotLike(String value) {
            addCriterion("Installation_mode not like", value, "installationMode");
            return (Criteria) this;
        }

        public Criteria andInstallationModeIn(List<String> values) {
            addCriterion("Installation_mode in", values, "installationMode");
            return (Criteria) this;
        }

        public Criteria andInstallationModeNotIn(List<String> values) {
            addCriterion("Installation_mode not in", values, "installationMode");
            return (Criteria) this;
        }

        public Criteria andInstallationModeBetween(String value1, String value2) {
            addCriterion("Installation_mode between", value1, value2, "installationMode");
            return (Criteria) this;
        }

        public Criteria andInstallationModeNotBetween(String value1, String value2) {
            addCriterion("Installation_mode not between", value1, value2, "installationMode");
            return (Criteria) this;
        }

        public Criteria andMemIsNull() {
            addCriterion("mem is null");
            return (Criteria) this;
        }

        public Criteria andMemIsNotNull() {
            addCriterion("mem is not null");
            return (Criteria) this;
        }

        public Criteria andMemEqualTo(String value) {
            addCriterion("mem =", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotEqualTo(String value) {
            addCriterion("mem <>", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThan(String value) {
            addCriterion("mem >", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemGreaterThanOrEqualTo(String value) {
            addCriterion("mem >=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThan(String value) {
            addCriterion("mem <", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLessThanOrEqualTo(String value) {
            addCriterion("mem <=", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemLike(String value) {
            addCriterion("mem like", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotLike(String value) {
            addCriterion("mem not like", value, "mem");
            return (Criteria) this;
        }

        public Criteria andMemIn(List<String> values) {
            addCriterion("mem in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotIn(List<String> values) {
            addCriterion("mem not in", values, "mem");
            return (Criteria) this;
        }

        public Criteria andMemBetween(String value1, String value2) {
            addCriterion("mem between", value1, value2, "mem");
            return (Criteria) this;
        }

        public Criteria andMemNotBetween(String value1, String value2) {
            addCriterion("mem not between", value1, value2, "mem");
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