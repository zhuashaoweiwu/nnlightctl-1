package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.List;

public class ElectricityMeterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ElectricityMeterExample() {
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

        public Criteria andElectricityModelIsNull() {
            addCriterion("electricity_model is null");
            return (Criteria) this;
        }

        public Criteria andElectricityModelIsNotNull() {
            addCriterion("electricity_model is not null");
            return (Criteria) this;
        }

        public Criteria andElectricityModelEqualTo(String value) {
            addCriterion("electricity_model =", value, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityModelNotEqualTo(String value) {
            addCriterion("electricity_model <>", value, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityModelGreaterThan(String value) {
            addCriterion("electricity_model >", value, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityModelGreaterThanOrEqualTo(String value) {
            addCriterion("electricity_model >=", value, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityModelLessThan(String value) {
            addCriterion("electricity_model <", value, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityModelLessThanOrEqualTo(String value) {
            addCriterion("electricity_model <=", value, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityModelLike(String value) {
            addCriterion("electricity_model like", value, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityModelNotLike(String value) {
            addCriterion("electricity_model not like", value, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityModelIn(List<String> values) {
            addCriterion("electricity_model in", values, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityModelNotIn(List<String> values) {
            addCriterion("electricity_model not in", values, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityModelBetween(String value1, String value2) {
            addCriterion("electricity_model between", value1, value2, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityModelNotBetween(String value1, String value2) {
            addCriterion("electricity_model not between", value1, value2, "electricityModel");
            return (Criteria) this;
        }

        public Criteria andElectricityNameIsNull() {
            addCriterion("electricity_name is null");
            return (Criteria) this;
        }

        public Criteria andElectricityNameIsNotNull() {
            addCriterion("electricity_name is not null");
            return (Criteria) this;
        }

        public Criteria andElectricityNameEqualTo(String value) {
            addCriterion("electricity_name =", value, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricityNameNotEqualTo(String value) {
            addCriterion("electricity_name <>", value, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricityNameGreaterThan(String value) {
            addCriterion("electricity_name >", value, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricityNameGreaterThanOrEqualTo(String value) {
            addCriterion("electricity_name >=", value, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricityNameLessThan(String value) {
            addCriterion("electricity_name <", value, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricityNameLessThanOrEqualTo(String value) {
            addCriterion("electricity_name <=", value, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricityNameLike(String value) {
            addCriterion("electricity_name like", value, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricityNameNotLike(String value) {
            addCriterion("electricity_name not like", value, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricityNameIn(List<String> values) {
            addCriterion("electricity_name in", values, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricityNameNotIn(List<String> values) {
            addCriterion("electricity_name not in", values, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricityNameBetween(String value1, String value2) {
            addCriterion("electricity_name between", value1, value2, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricityNameNotBetween(String value1, String value2) {
            addCriterion("electricity_name not between", value1, value2, "electricityName");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsIsNull() {
            addCriterion("electric_standards is null");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsIsNotNull() {
            addCriterion("electric_standards is not null");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsEqualTo(String value) {
            addCriterion("electric_standards =", value, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsNotEqualTo(String value) {
            addCriterion("electric_standards <>", value, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsGreaterThan(String value) {
            addCriterion("electric_standards >", value, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsGreaterThanOrEqualTo(String value) {
            addCriterion("electric_standards >=", value, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsLessThan(String value) {
            addCriterion("electric_standards <", value, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsLessThanOrEqualTo(String value) {
            addCriterion("electric_standards <=", value, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsLike(String value) {
            addCriterion("electric_standards like", value, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsNotLike(String value) {
            addCriterion("electric_standards not like", value, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsIn(List<String> values) {
            addCriterion("electric_standards in", values, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsNotIn(List<String> values) {
            addCriterion("electric_standards not in", values, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsBetween(String value1, String value2) {
            addCriterion("electric_standards between", value1, value2, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andElectricStandardsNotBetween(String value1, String value2) {
            addCriterion("electric_standards not between", value1, value2, "electricStandards");
            return (Criteria) this;
        }

        public Criteria andVoltageTestIsNull() {
            addCriterion("voltage_test is null");
            return (Criteria) this;
        }

        public Criteria andVoltageTestIsNotNull() {
            addCriterion("voltage_test is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageTestEqualTo(String value) {
            addCriterion("voltage_test =", value, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andVoltageTestNotEqualTo(String value) {
            addCriterion("voltage_test <>", value, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andVoltageTestGreaterThan(String value) {
            addCriterion("voltage_test >", value, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andVoltageTestGreaterThanOrEqualTo(String value) {
            addCriterion("voltage_test >=", value, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andVoltageTestLessThan(String value) {
            addCriterion("voltage_test <", value, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andVoltageTestLessThanOrEqualTo(String value) {
            addCriterion("voltage_test <=", value, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andVoltageTestLike(String value) {
            addCriterion("voltage_test like", value, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andVoltageTestNotLike(String value) {
            addCriterion("voltage_test not like", value, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andVoltageTestIn(List<String> values) {
            addCriterion("voltage_test in", values, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andVoltageTestNotIn(List<String> values) {
            addCriterion("voltage_test not in", values, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andVoltageTestBetween(String value1, String value2) {
            addCriterion("voltage_test between", value1, value2, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andVoltageTestNotBetween(String value1, String value2) {
            addCriterion("voltage_test not between", value1, value2, "voltageTest");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyIsNull() {
            addCriterion("active_energy is null");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyIsNotNull() {
            addCriterion("active_energy is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyEqualTo(Integer value) {
            addCriterion("active_energy =", value, "activeEnergy");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyNotEqualTo(Integer value) {
            addCriterion("active_energy <>", value, "activeEnergy");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyGreaterThan(Integer value) {
            addCriterion("active_energy >", value, "activeEnergy");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_energy >=", value, "activeEnergy");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyLessThan(Integer value) {
            addCriterion("active_energy <", value, "activeEnergy");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyLessThanOrEqualTo(Integer value) {
            addCriterion("active_energy <=", value, "activeEnergy");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyIn(List<Integer> values) {
            addCriterion("active_energy in", values, "activeEnergy");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyNotIn(List<Integer> values) {
            addCriterion("active_energy not in", values, "activeEnergy");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyBetween(Integer value1, Integer value2) {
            addCriterion("active_energy between", value1, value2, "activeEnergy");
            return (Criteria) this;
        }

        public Criteria andActiveEnergyNotBetween(Integer value1, Integer value2) {
            addCriterion("active_energy not between", value1, value2, "activeEnergy");
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

        public Criteria andCommunityModeIsNull() {
            addCriterion("community_mode is null");
            return (Criteria) this;
        }

        public Criteria andCommunityModeIsNotNull() {
            addCriterion("community_mode is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityModeEqualTo(String value) {
            addCriterion("community_mode =", value, "communityMode");
            return (Criteria) this;
        }

        public Criteria andCommunityModeNotEqualTo(String value) {
            addCriterion("community_mode <>", value, "communityMode");
            return (Criteria) this;
        }

        public Criteria andCommunityModeGreaterThan(String value) {
            addCriterion("community_mode >", value, "communityMode");
            return (Criteria) this;
        }

        public Criteria andCommunityModeGreaterThanOrEqualTo(String value) {
            addCriterion("community_mode >=", value, "communityMode");
            return (Criteria) this;
        }

        public Criteria andCommunityModeLessThan(String value) {
            addCriterion("community_mode <", value, "communityMode");
            return (Criteria) this;
        }

        public Criteria andCommunityModeLessThanOrEqualTo(String value) {
            addCriterion("community_mode <=", value, "communityMode");
            return (Criteria) this;
        }

        public Criteria andCommunityModeLike(String value) {
            addCriterion("community_mode like", value, "communityMode");
            return (Criteria) this;
        }

        public Criteria andCommunityModeNotLike(String value) {
            addCriterion("community_mode not like", value, "communityMode");
            return (Criteria) this;
        }

        public Criteria andCommunityModeIn(List<String> values) {
            addCriterion("community_mode in", values, "communityMode");
            return (Criteria) this;
        }

        public Criteria andCommunityModeNotIn(List<String> values) {
            addCriterion("community_mode not in", values, "communityMode");
            return (Criteria) this;
        }

        public Criteria andCommunityModeBetween(String value1, String value2) {
            addCriterion("community_mode between", value1, value2, "communityMode");
            return (Criteria) this;
        }

        public Criteria andCommunityModeNotBetween(String value1, String value2) {
            addCriterion("community_mode not between", value1, value2, "communityMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeIsNull() {
            addCriterion("measure_mode is null");
            return (Criteria) this;
        }

        public Criteria andMeasureModeIsNotNull() {
            addCriterion("measure_mode is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureModeEqualTo(String value) {
            addCriterion("measure_mode =", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeNotEqualTo(String value) {
            addCriterion("measure_mode <>", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeGreaterThan(String value) {
            addCriterion("measure_mode >", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeGreaterThanOrEqualTo(String value) {
            addCriterion("measure_mode >=", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeLessThan(String value) {
            addCriterion("measure_mode <", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeLessThanOrEqualTo(String value) {
            addCriterion("measure_mode <=", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeLike(String value) {
            addCriterion("measure_mode like", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeNotLike(String value) {
            addCriterion("measure_mode not like", value, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeIn(List<String> values) {
            addCriterion("measure_mode in", values, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeNotIn(List<String> values) {
            addCriterion("measure_mode not in", values, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeBetween(String value1, String value2) {
            addCriterion("measure_mode between", value1, value2, "measureMode");
            return (Criteria) this;
        }

        public Criteria andMeasureModeNotBetween(String value1, String value2) {
            addCriterion("measure_mode not between", value1, value2, "measureMode");
            return (Criteria) this;
        }

        public Criteria andPowerFactorIsNull() {
            addCriterion("power_factor is null");
            return (Criteria) this;
        }

        public Criteria andPowerFactorIsNotNull() {
            addCriterion("power_factor is not null");
            return (Criteria) this;
        }

        public Criteria andPowerFactorEqualTo(String value) {
            addCriterion("power_factor =", value, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerFactorNotEqualTo(String value) {
            addCriterion("power_factor <>", value, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerFactorGreaterThan(String value) {
            addCriterion("power_factor >", value, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerFactorGreaterThanOrEqualTo(String value) {
            addCriterion("power_factor >=", value, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerFactorLessThan(String value) {
            addCriterion("power_factor <", value, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerFactorLessThanOrEqualTo(String value) {
            addCriterion("power_factor <=", value, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerFactorLike(String value) {
            addCriterion("power_factor like", value, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerFactorNotLike(String value) {
            addCriterion("power_factor not like", value, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerFactorIn(List<String> values) {
            addCriterion("power_factor in", values, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerFactorNotIn(List<String> values) {
            addCriterion("power_factor not in", values, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerFactorBetween(String value1, String value2) {
            addCriterion("power_factor between", value1, value2, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerFactorNotBetween(String value1, String value2) {
            addCriterion("power_factor not between", value1, value2, "powerFactor");
            return (Criteria) this;
        }

        public Criteria andPowerWasteIsNull() {
            addCriterion("power_waste is null");
            return (Criteria) this;
        }

        public Criteria andPowerWasteIsNotNull() {
            addCriterion("power_waste is not null");
            return (Criteria) this;
        }

        public Criteria andPowerWasteEqualTo(String value) {
            addCriterion("power_waste =", value, "powerWaste");
            return (Criteria) this;
        }

        public Criteria andPowerWasteNotEqualTo(String value) {
            addCriterion("power_waste <>", value, "powerWaste");
            return (Criteria) this;
        }

        public Criteria andPowerWasteGreaterThan(String value) {
            addCriterion("power_waste >", value, "powerWaste");
            return (Criteria) this;
        }

        public Criteria andPowerWasteGreaterThanOrEqualTo(String value) {
            addCriterion("power_waste >=", value, "powerWaste");
            return (Criteria) this;
        }

        public Criteria andPowerWasteLessThan(String value) {
            addCriterion("power_waste <", value, "powerWaste");
            return (Criteria) this;
        }

        public Criteria andPowerWasteLessThanOrEqualTo(String value) {
            addCriterion("power_waste <=", value, "powerWaste");
            return (Criteria) this;
        }

        public Criteria andPowerWasteLike(String value) {
            addCriterion("power_waste like", value, "powerWaste");
            return (Criteria) this;
        }

        public Criteria andPowerWasteNotLike(String value) {
            addCriterion("power_waste not like", value, "powerWaste");
            return (Criteria) this;
        }

        public Criteria andPowerWasteIn(List<String> values) {
            addCriterion("power_waste in", values, "powerWaste");
            return (Criteria) this;
        }

        public Criteria andPowerWasteNotIn(List<String> values) {
            addCriterion("power_waste not in", values, "powerWaste");
            return (Criteria) this;
        }

        public Criteria andPowerWasteBetween(String value1, String value2) {
            addCriterion("power_waste between", value1, value2, "powerWaste");
            return (Criteria) this;
        }

        public Criteria andPowerWasteNotBetween(String value1, String value2) {
            addCriterion("power_waste not between", value1, value2, "powerWaste");
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