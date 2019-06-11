package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.List;

public class CentralizeControllerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CentralizeControllerExample() {
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

        public Criteria andCentralizeModelIsNull() {
            addCriterion("centralize_model is null");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelIsNotNull() {
            addCriterion("centralize_model is not null");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelEqualTo(String value) {
            addCriterion("centralize_model =", value, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelNotEqualTo(String value) {
            addCriterion("centralize_model <>", value, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelGreaterThan(String value) {
            addCriterion("centralize_model >", value, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelGreaterThanOrEqualTo(String value) {
            addCriterion("centralize_model >=", value, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelLessThan(String value) {
            addCriterion("centralize_model <", value, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelLessThanOrEqualTo(String value) {
            addCriterion("centralize_model <=", value, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelLike(String value) {
            addCriterion("centralize_model like", value, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelNotLike(String value) {
            addCriterion("centralize_model not like", value, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelIn(List<String> values) {
            addCriterion("centralize_model in", values, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelNotIn(List<String> values) {
            addCriterion("centralize_model not in", values, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelBetween(String value1, String value2) {
            addCriterion("centralize_model between", value1, value2, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeModelNotBetween(String value1, String value2) {
            addCriterion("centralize_model not between", value1, value2, "centralizeModel");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameIsNull() {
            addCriterion("centralize_name is null");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameIsNotNull() {
            addCriterion("centralize_name is not null");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameEqualTo(String value) {
            addCriterion("centralize_name =", value, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameNotEqualTo(String value) {
            addCriterion("centralize_name <>", value, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameGreaterThan(String value) {
            addCriterion("centralize_name >", value, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("centralize_name >=", value, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameLessThan(String value) {
            addCriterion("centralize_name <", value, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameLessThanOrEqualTo(String value) {
            addCriterion("centralize_name <=", value, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameLike(String value) {
            addCriterion("centralize_name like", value, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameNotLike(String value) {
            addCriterion("centralize_name not like", value, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameIn(List<String> values) {
            addCriterion("centralize_name in", values, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameNotIn(List<String> values) {
            addCriterion("centralize_name not in", values, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameBetween(String value1, String value2) {
            addCriterion("centralize_name between", value1, value2, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andCentralizeNameNotBetween(String value1, String value2) {
            addCriterion("centralize_name not between", value1, value2, "centralizeName");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andDoChannelIsNull() {
            addCriterion("do_channel is null");
            return (Criteria) this;
        }

        public Criteria andDoChannelIsNotNull() {
            addCriterion("do_channel is not null");
            return (Criteria) this;
        }

        public Criteria andDoChannelEqualTo(Long value) {
            addCriterion("do_channel =", value, "doChannel");
            return (Criteria) this;
        }

        public Criteria andDoChannelNotEqualTo(Long value) {
            addCriterion("do_channel <>", value, "doChannel");
            return (Criteria) this;
        }

        public Criteria andDoChannelGreaterThan(Long value) {
            addCriterion("do_channel >", value, "doChannel");
            return (Criteria) this;
        }

        public Criteria andDoChannelGreaterThanOrEqualTo(Long value) {
            addCriterion("do_channel >=", value, "doChannel");
            return (Criteria) this;
        }

        public Criteria andDoChannelLessThan(Long value) {
            addCriterion("do_channel <", value, "doChannel");
            return (Criteria) this;
        }

        public Criteria andDoChannelLessThanOrEqualTo(Long value) {
            addCriterion("do_channel <=", value, "doChannel");
            return (Criteria) this;
        }

        public Criteria andDoChannelIn(List<Long> values) {
            addCriterion("do_channel in", values, "doChannel");
            return (Criteria) this;
        }

        public Criteria andDoChannelNotIn(List<Long> values) {
            addCriterion("do_channel not in", values, "doChannel");
            return (Criteria) this;
        }

        public Criteria andDoChannelBetween(Long value1, Long value2) {
            addCriterion("do_channel between", value1, value2, "doChannel");
            return (Criteria) this;
        }

        public Criteria andDoChannelNotBetween(Long value1, Long value2) {
            addCriterion("do_channel not between", value1, value2, "doChannel");
            return (Criteria) this;
        }

        public Criteria andDiChannelIsNull() {
            addCriterion("di_channel is null");
            return (Criteria) this;
        }

        public Criteria andDiChannelIsNotNull() {
            addCriterion("di_channel is not null");
            return (Criteria) this;
        }

        public Criteria andDiChannelEqualTo(Long value) {
            addCriterion("di_channel =", value, "diChannel");
            return (Criteria) this;
        }

        public Criteria andDiChannelNotEqualTo(Long value) {
            addCriterion("di_channel <>", value, "diChannel");
            return (Criteria) this;
        }

        public Criteria andDiChannelGreaterThan(Long value) {
            addCriterion("di_channel >", value, "diChannel");
            return (Criteria) this;
        }

        public Criteria andDiChannelGreaterThanOrEqualTo(Long value) {
            addCriterion("di_channel >=", value, "diChannel");
            return (Criteria) this;
        }

        public Criteria andDiChannelLessThan(Long value) {
            addCriterion("di_channel <", value, "diChannel");
            return (Criteria) this;
        }

        public Criteria andDiChannelLessThanOrEqualTo(Long value) {
            addCriterion("di_channel <=", value, "diChannel");
            return (Criteria) this;
        }

        public Criteria andDiChannelIn(List<Long> values) {
            addCriterion("di_channel in", values, "diChannel");
            return (Criteria) this;
        }

        public Criteria andDiChannelNotIn(List<Long> values) {
            addCriterion("di_channel not in", values, "diChannel");
            return (Criteria) this;
        }

        public Criteria andDiChannelBetween(Long value1, Long value2) {
            addCriterion("di_channel between", value1, value2, "diChannel");
            return (Criteria) this;
        }

        public Criteria andDiChannelNotBetween(Long value1, Long value2) {
            addCriterion("di_channel not between", value1, value2, "diChannel");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelIsNull() {
            addCriterion("switch_channel is null");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelIsNotNull() {
            addCriterion("switch_channel is not null");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelEqualTo(Long value) {
            addCriterion("switch_channel =", value, "switchChannel");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelNotEqualTo(Long value) {
            addCriterion("switch_channel <>", value, "switchChannel");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelGreaterThan(Long value) {
            addCriterion("switch_channel >", value, "switchChannel");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelGreaterThanOrEqualTo(Long value) {
            addCriterion("switch_channel >=", value, "switchChannel");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelLessThan(Long value) {
            addCriterion("switch_channel <", value, "switchChannel");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelLessThanOrEqualTo(Long value) {
            addCriterion("switch_channel <=", value, "switchChannel");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelIn(List<Long> values) {
            addCriterion("switch_channel in", values, "switchChannel");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelNotIn(List<Long> values) {
            addCriterion("switch_channel not in", values, "switchChannel");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelBetween(Long value1, Long value2) {
            addCriterion("switch_channel between", value1, value2, "switchChannel");
            return (Criteria) this;
        }

        public Criteria andSwitchChannelNotBetween(Long value1, Long value2) {
            addCriterion("switch_channel not between", value1, value2, "switchChannel");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelIsNull() {
            addCriterion("voltage_channel is null");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelIsNotNull() {
            addCriterion("voltage_channel is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelEqualTo(Long value) {
            addCriterion("voltage_channel =", value, "voltageChannel");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelNotEqualTo(Long value) {
            addCriterion("voltage_channel <>", value, "voltageChannel");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelGreaterThan(Long value) {
            addCriterion("voltage_channel >", value, "voltageChannel");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelGreaterThanOrEqualTo(Long value) {
            addCriterion("voltage_channel >=", value, "voltageChannel");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelLessThan(Long value) {
            addCriterion("voltage_channel <", value, "voltageChannel");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelLessThanOrEqualTo(Long value) {
            addCriterion("voltage_channel <=", value, "voltageChannel");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelIn(List<Long> values) {
            addCriterion("voltage_channel in", values, "voltageChannel");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelNotIn(List<Long> values) {
            addCriterion("voltage_channel not in", values, "voltageChannel");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelBetween(Long value1, Long value2) {
            addCriterion("voltage_channel between", value1, value2, "voltageChannel");
            return (Criteria) this;
        }

        public Criteria andVoltageChannelNotBetween(Long value1, Long value2) {
            addCriterion("voltage_channel not between", value1, value2, "voltageChannel");
            return (Criteria) this;
        }

        public Criteria andElectricChannelIsNull() {
            addCriterion("electric_channel is null");
            return (Criteria) this;
        }

        public Criteria andElectricChannelIsNotNull() {
            addCriterion("electric_channel is not null");
            return (Criteria) this;
        }

        public Criteria andElectricChannelEqualTo(Long value) {
            addCriterion("electric_channel =", value, "electricChannel");
            return (Criteria) this;
        }

        public Criteria andElectricChannelNotEqualTo(Long value) {
            addCriterion("electric_channel <>", value, "electricChannel");
            return (Criteria) this;
        }

        public Criteria andElectricChannelGreaterThan(Long value) {
            addCriterion("electric_channel >", value, "electricChannel");
            return (Criteria) this;
        }

        public Criteria andElectricChannelGreaterThanOrEqualTo(Long value) {
            addCriterion("electric_channel >=", value, "electricChannel");
            return (Criteria) this;
        }

        public Criteria andElectricChannelLessThan(Long value) {
            addCriterion("electric_channel <", value, "electricChannel");
            return (Criteria) this;
        }

        public Criteria andElectricChannelLessThanOrEqualTo(Long value) {
            addCriterion("electric_channel <=", value, "electricChannel");
            return (Criteria) this;
        }

        public Criteria andElectricChannelIn(List<Long> values) {
            addCriterion("electric_channel in", values, "electricChannel");
            return (Criteria) this;
        }

        public Criteria andElectricChannelNotIn(List<Long> values) {
            addCriterion("electric_channel not in", values, "electricChannel");
            return (Criteria) this;
        }

        public Criteria andElectricChannelBetween(Long value1, Long value2) {
            addCriterion("electric_channel between", value1, value2, "electricChannel");
            return (Criteria) this;
        }

        public Criteria andElectricChannelNotBetween(Long value1, Long value2) {
            addCriterion("electric_channel not between", value1, value2, "electricChannel");
            return (Criteria) this;
        }

        public Criteria andTestChannelIsNull() {
            addCriterion("test_channel is null");
            return (Criteria) this;
        }

        public Criteria andTestChannelIsNotNull() {
            addCriterion("test_channel is not null");
            return (Criteria) this;
        }

        public Criteria andTestChannelEqualTo(Long value) {
            addCriterion("test_channel =", value, "testChannel");
            return (Criteria) this;
        }

        public Criteria andTestChannelNotEqualTo(Long value) {
            addCriterion("test_channel <>", value, "testChannel");
            return (Criteria) this;
        }

        public Criteria andTestChannelGreaterThan(Long value) {
            addCriterion("test_channel >", value, "testChannel");
            return (Criteria) this;
        }

        public Criteria andTestChannelGreaterThanOrEqualTo(Long value) {
            addCriterion("test_channel >=", value, "testChannel");
            return (Criteria) this;
        }

        public Criteria andTestChannelLessThan(Long value) {
            addCriterion("test_channel <", value, "testChannel");
            return (Criteria) this;
        }

        public Criteria andTestChannelLessThanOrEqualTo(Long value) {
            addCriterion("test_channel <=", value, "testChannel");
            return (Criteria) this;
        }

        public Criteria andTestChannelIn(List<Long> values) {
            addCriterion("test_channel in", values, "testChannel");
            return (Criteria) this;
        }

        public Criteria andTestChannelNotIn(List<Long> values) {
            addCriterion("test_channel not in", values, "testChannel");
            return (Criteria) this;
        }

        public Criteria andTestChannelBetween(Long value1, Long value2) {
            addCriterion("test_channel between", value1, value2, "testChannel");
            return (Criteria) this;
        }

        public Criteria andTestChannelNotBetween(Long value1, Long value2) {
            addCriterion("test_channel not between", value1, value2, "testChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelIsNull() {
            addCriterion("up_channel is null");
            return (Criteria) this;
        }

        public Criteria andUpChannelIsNotNull() {
            addCriterion("up_channel is not null");
            return (Criteria) this;
        }

        public Criteria andUpChannelEqualTo(String value) {
            addCriterion("up_channel =", value, "upChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelNotEqualTo(String value) {
            addCriterion("up_channel <>", value, "upChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelGreaterThan(String value) {
            addCriterion("up_channel >", value, "upChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelGreaterThanOrEqualTo(String value) {
            addCriterion("up_channel >=", value, "upChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelLessThan(String value) {
            addCriterion("up_channel <", value, "upChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelLessThanOrEqualTo(String value) {
            addCriterion("up_channel <=", value, "upChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelLike(String value) {
            addCriterion("up_channel like", value, "upChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelNotLike(String value) {
            addCriterion("up_channel not like", value, "upChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelIn(List<String> values) {
            addCriterion("up_channel in", values, "upChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelNotIn(List<String> values) {
            addCriterion("up_channel not in", values, "upChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelBetween(String value1, String value2) {
            addCriterion("up_channel between", value1, value2, "upChannel");
            return (Criteria) this;
        }

        public Criteria andUpChannelNotBetween(String value1, String value2) {
            addCriterion("up_channel not between", value1, value2, "upChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelIsNull() {
            addCriterion("down_channel is null");
            return (Criteria) this;
        }

        public Criteria andDownChannelIsNotNull() {
            addCriterion("down_channel is not null");
            return (Criteria) this;
        }

        public Criteria andDownChannelEqualTo(String value) {
            addCriterion("down_channel =", value, "downChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelNotEqualTo(String value) {
            addCriterion("down_channel <>", value, "downChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelGreaterThan(String value) {
            addCriterion("down_channel >", value, "downChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelGreaterThanOrEqualTo(String value) {
            addCriterion("down_channel >=", value, "downChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelLessThan(String value) {
            addCriterion("down_channel <", value, "downChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelLessThanOrEqualTo(String value) {
            addCriterion("down_channel <=", value, "downChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelLike(String value) {
            addCriterion("down_channel like", value, "downChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelNotLike(String value) {
            addCriterion("down_channel not like", value, "downChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelIn(List<String> values) {
            addCriterion("down_channel in", values, "downChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelNotIn(List<String> values) {
            addCriterion("down_channel not in", values, "downChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelBetween(String value1, String value2) {
            addCriterion("down_channel between", value1, value2, "downChannel");
            return (Criteria) this;
        }

        public Criteria andDownChannelNotBetween(String value1, String value2) {
            addCriterion("down_channel not between", value1, value2, "downChannel");
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