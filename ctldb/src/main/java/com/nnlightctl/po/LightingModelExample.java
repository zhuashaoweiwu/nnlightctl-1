package com.nnlightctl.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LightingModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LightingModelExample() {
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

        public Criteria andModelNameIsNull() {
            addCriterion("model_name is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("model_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("model_name =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("model_name <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("model_name >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_name >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("model_name <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("model_name <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("model_name like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNumberLike(String value) {
            addCriterion("equipment_number like", value, "equipmentNumber");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("model_name not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("model_name in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("model_name not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("model_name between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("model_name not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageIsNull() {
            addCriterion("rated_voltage is null");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageIsNotNull() {
            addCriterion("rated_voltage is not null");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageEqualTo(BigDecimal value) {
            addCriterion("rated_voltage =", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageNotEqualTo(BigDecimal value) {
            addCriterion("rated_voltage <>", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageGreaterThan(BigDecimal value) {
            addCriterion("rated_voltage >", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rated_voltage >=", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageLessThan(BigDecimal value) {
            addCriterion("rated_voltage <", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rated_voltage <=", value, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageIn(List<BigDecimal> values) {
            addCriterion("rated_voltage in", values, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageNotIn(List<BigDecimal> values) {
            addCriterion("rated_voltage not in", values, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rated_voltage between", value1, value2, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedVoltageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rated_voltage not between", value1, value2, "ratedVoltage");
            return (Criteria) this;
        }

        public Criteria andRatedElectricIsNull() {
            addCriterion("rated_electric is null");
            return (Criteria) this;
        }

        public Criteria andRatedElectricIsNotNull() {
            addCriterion("rated_electric is not null");
            return (Criteria) this;
        }

        public Criteria andRatedElectricEqualTo(BigDecimal value) {
            addCriterion("rated_electric =", value, "ratedElectric");
            return (Criteria) this;
        }

        public Criteria andRatedElectricNotEqualTo(BigDecimal value) {
            addCriterion("rated_electric <>", value, "ratedElectric");
            return (Criteria) this;
        }

        public Criteria andRatedElectricGreaterThan(BigDecimal value) {
            addCriterion("rated_electric >", value, "ratedElectric");
            return (Criteria) this;
        }

        public Criteria andRatedElectricGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rated_electric >=", value, "ratedElectric");
            return (Criteria) this;
        }

        public Criteria andRatedElectricLessThan(BigDecimal value) {
            addCriterion("rated_electric <", value, "ratedElectric");
            return (Criteria) this;
        }

        public Criteria andRatedElectricLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rated_electric <=", value, "ratedElectric");
            return (Criteria) this;
        }

        public Criteria andRatedElectricIn(List<BigDecimal> values) {
            addCriterion("rated_electric in", values, "ratedElectric");
            return (Criteria) this;
        }

        public Criteria andRatedElectricNotIn(List<BigDecimal> values) {
            addCriterion("rated_electric not in", values, "ratedElectric");
            return (Criteria) this;
        }

        public Criteria andRatedElectricBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rated_electric between", value1, value2, "ratedElectric");
            return (Criteria) this;
        }

        public Criteria andRatedElectricNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rated_electric not between", value1, value2, "ratedElectric");
            return (Criteria) this;
        }

        public Criteria andRatedPowerIsNull() {
            addCriterion("rated_power is null");
            return (Criteria) this;
        }

        public Criteria andRatedPowerIsNotNull() {
            addCriterion("rated_power is not null");
            return (Criteria) this;
        }

        public Criteria andRatedPowerEqualTo(BigDecimal value) {
            addCriterion("rated_power =", value, "ratedPower");
            return (Criteria) this;
        }

        public Criteria andRatedPowerNotEqualTo(BigDecimal value) {
            addCriterion("rated_power <>", value, "ratedPower");
            return (Criteria) this;
        }

        public Criteria andRatedPowerGreaterThan(BigDecimal value) {
            addCriterion("rated_power >", value, "ratedPower");
            return (Criteria) this;
        }

        public Criteria andRatedPowerGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rated_power >=", value, "ratedPower");
            return (Criteria) this;
        }

        public Criteria andRatedPowerLessThan(BigDecimal value) {
            addCriterion("rated_power <", value, "ratedPower");
            return (Criteria) this;
        }

        public Criteria andRatedPowerLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rated_power <=", value, "ratedPower");
            return (Criteria) this;
        }

        public Criteria andRatedPowerIn(List<BigDecimal> values) {
            addCriterion("rated_power in", values, "ratedPower");
            return (Criteria) this;
        }

        public Criteria andRatedPowerNotIn(List<BigDecimal> values) {
            addCriterion("rated_power not in", values, "ratedPower");
            return (Criteria) this;
        }

        public Criteria andRatedPowerBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rated_power between", value1, value2, "ratedPower");
            return (Criteria) this;
        }

        public Criteria andRatedPowerNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rated_power not between", value1, value2, "ratedPower");
            return (Criteria) this;
        }

        public Criteria andLedCountIsNull() {
            addCriterion("led_count is null");
            return (Criteria) this;
        }

        public Criteria andLedCountIsNotNull() {
            addCriterion("led_count is not null");
            return (Criteria) this;
        }

        public Criteria andLedCountEqualTo(Byte value) {
            addCriterion("led_count =", value, "ledCount");
            return (Criteria) this;
        }

        public Criteria andLedCountNotEqualTo(Byte value) {
            addCriterion("led_count <>", value, "ledCount");
            return (Criteria) this;
        }

        public Criteria andLedCountGreaterThan(Byte value) {
            addCriterion("led_count >", value, "ledCount");
            return (Criteria) this;
        }

        public Criteria andLedCountGreaterThanOrEqualTo(Byte value) {
            addCriterion("led_count >=", value, "ledCount");
            return (Criteria) this;
        }

        public Criteria andLedCountLessThan(Byte value) {
            addCriterion("led_count <", value, "ledCount");
            return (Criteria) this;
        }

        public Criteria andLedCountLessThanOrEqualTo(Byte value) {
            addCriterion("led_count <=", value, "ledCount");
            return (Criteria) this;
        }

        public Criteria andLedCountIn(List<Byte> values) {
            addCriterion("led_count in", values, "ledCount");
            return (Criteria) this;
        }

        public Criteria andLedCountNotIn(List<Byte> values) {
            addCriterion("led_count not in", values, "ledCount");
            return (Criteria) this;
        }

        public Criteria andLedCountBetween(Byte value1, Byte value2) {
            addCriterion("led_count between", value1, value2, "ledCount");
            return (Criteria) this;
        }

        public Criteria andLedCountNotBetween(Byte value1, Byte value2) {
            addCriterion("led_count not between", value1, value2, "ledCount");
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

        public Criteria andChipIsNull() {
            addCriterion("chip is null");
            return (Criteria) this;
        }

        public Criteria andChipIsNotNull() {
            addCriterion("chip is not null");
            return (Criteria) this;
        }

        public Criteria andChipEqualTo(String value) {
            addCriterion("chip =", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipNotEqualTo(String value) {
            addCriterion("chip <>", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipGreaterThan(String value) {
            addCriterion("chip >", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipGreaterThanOrEqualTo(String value) {
            addCriterion("chip >=", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipLessThan(String value) {
            addCriterion("chip <", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipLessThanOrEqualTo(String value) {
            addCriterion("chip <=", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipLike(String value) {
            addCriterion("chip like", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipNotLike(String value) {
            addCriterion("chip not like", value, "chip");
            return (Criteria) this;
        }

        public Criteria andChipIn(List<String> values) {
            addCriterion("chip in", values, "chip");
            return (Criteria) this;
        }

        public Criteria andChipNotIn(List<String> values) {
            addCriterion("chip not in", values, "chip");
            return (Criteria) this;
        }

        public Criteria andChipBetween(String value1, String value2) {
            addCriterion("chip between", value1, value2, "chip");
            return (Criteria) this;
        }

        public Criteria andChipNotBetween(String value1, String value2) {
            addCriterion("chip not between", value1, value2, "chip");
            return (Criteria) this;
        }

        public Criteria andFluxIsNull() {
            addCriterion("flux is null");
            return (Criteria) this;
        }

        public Criteria andFluxIsNotNull() {
            addCriterion("flux is not null");
            return (Criteria) this;
        }

        public Criteria andFluxEqualTo(Integer value) {
            addCriterion("flux =", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxNotEqualTo(Integer value) {
            addCriterion("flux <>", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxGreaterThan(Integer value) {
            addCriterion("flux >", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxGreaterThanOrEqualTo(Integer value) {
            addCriterion("flux >=", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxLessThan(Integer value) {
            addCriterion("flux <", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxLessThanOrEqualTo(Integer value) {
            addCriterion("flux <=", value, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxIn(List<Integer> values) {
            addCriterion("flux in", values, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxNotIn(List<Integer> values) {
            addCriterion("flux not in", values, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxBetween(Integer value1, Integer value2) {
            addCriterion("flux between", value1, value2, "flux");
            return (Criteria) this;
        }

        public Criteria andFluxNotBetween(Integer value1, Integer value2) {
            addCriterion("flux not between", value1, value2, "flux");
            return (Criteria) this;
        }

        public Criteria andIndexIsNull() {
            addCriterion("index is null");
            return (Criteria) this;
        }

        public Criteria andIndexIsNotNull() {
            addCriterion("index is not null");
            return (Criteria) this;
        }

        public Criteria andIndexEqualTo(Integer value) {
            addCriterion("index =", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotEqualTo(Integer value) {
            addCriterion("index <>", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThan(Integer value) {
            addCriterion("index >", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("index >=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThan(Integer value) {
            addCriterion("index <", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThanOrEqualTo(Integer value) {
            addCriterion("index <=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexIn(List<Integer> values) {
            addCriterion("index in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotIn(List<Integer> values) {
            addCriterion("index not in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexBetween(Integer value1, Integer value2) {
            addCriterion("index between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("index not between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andControllerModeIsNull() {
            addCriterion("controller_mode is null");
            return (Criteria) this;
        }

        public Criteria andControllerModeIsNotNull() {
            addCriterion("controller_mode is not null");
            return (Criteria) this;
        }

        public Criteria andControllerModeEqualTo(String value) {
            addCriterion("controller_mode =", value, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andControllerModeNotEqualTo(String value) {
            addCriterion("controller_mode <>", value, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andControllerModeGreaterThan(String value) {
            addCriterion("controller_mode >", value, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andControllerModeGreaterThanOrEqualTo(String value) {
            addCriterion("controller_mode >=", value, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andControllerModeLessThan(String value) {
            addCriterion("controller_mode <", value, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andControllerModeLessThanOrEqualTo(String value) {
            addCriterion("controller_mode <=", value, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andControllerModeLike(String value) {
            addCriterion("controller_mode like", value, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andControllerModeNotLike(String value) {
            addCriterion("controller_mode not like", value, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andControllerModeIn(List<String> values) {
            addCriterion("controller_mode in", values, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andControllerModeNotIn(List<String> values) {
            addCriterion("controller_mode not in", values, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andControllerModeBetween(String value1, String value2) {
            addCriterion("controller_mode between", value1, value2, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andControllerModeNotBetween(String value1, String value2) {
            addCriterion("controller_mode not between", value1, value2, "controllerMode");
            return (Criteria) this;
        }

        public Criteria andBeanAngleIsNull() {
            addCriterion("bean_angle is null");
            return (Criteria) this;
        }

        public Criteria andBeanAngleIsNotNull() {
            addCriterion("bean_angle is not null");
            return (Criteria) this;
        }

        public Criteria andBeanAngleEqualTo(String value) {
            addCriterion("bean_angle =", value, "beanAngle");
            return (Criteria) this;
        }

        public Criteria andBeanAngleNotEqualTo(String value) {
            addCriterion("bean_angle <>", value, "beanAngle");
            return (Criteria) this;
        }

        public Criteria andBeanAngleGreaterThan(String value) {
            addCriterion("bean_angle >", value, "beanAngle");
            return (Criteria) this;
        }

        public Criteria andBeanAngleGreaterThanOrEqualTo(String value) {
            addCriterion("bean_angle >=", value, "beanAngle");
            return (Criteria) this;
        }

        public Criteria andBeanAngleLessThan(String value) {
            addCriterion("bean_angle <", value, "beanAngle");
            return (Criteria) this;
        }

        public Criteria andBeanAngleLessThanOrEqualTo(String value) {
            addCriterion("bean_angle <=", value, "beanAngle");
            return (Criteria) this;
        }

        public Criteria andBeanAngleLike(String value) {
            addCriterion("bean_angle like", value, "beanAngle");
            return (Criteria) this;
        }

        public Criteria andBeanAngleNotLike(String value) {
            addCriterion("bean_angle not like", value, "beanAngle");
            return (Criteria) this;
        }

        public Criteria andBeanAngleIn(List<String> values) {
            addCriterion("bean_angle in", values, "beanAngle");
            return (Criteria) this;
        }

        public Criteria andBeanAngleNotIn(List<String> values) {
            addCriterion("bean_angle not in", values, "beanAngle");
            return (Criteria) this;
        }

        public Criteria andBeanAngleBetween(String value1, String value2) {
            addCriterion("bean_angle between", value1, value2, "beanAngle");
            return (Criteria) this;
        }

        public Criteria andBeanAngleNotBetween(String value1, String value2) {
            addCriterion("bean_angle not between", value1, value2, "beanAngle");
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