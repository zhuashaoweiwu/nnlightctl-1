package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LightingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LightingExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andManufactureIsNull() {
            addCriterion("manufacture is null");
            return (Criteria) this;
        }

        public Criteria andManufactureIsNotNull() {
            addCriterion("manufacture is not null");
            return (Criteria) this;
        }

        public Criteria andManufactureEqualTo(Date value) {
            addCriterion("manufacture =", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureNotEqualTo(Date value) {
            addCriterion("manufacture <>", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureGreaterThan(Date value) {
            addCriterion("manufacture >", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureGreaterThanOrEqualTo(Date value) {
            addCriterion("manufacture >=", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureLessThan(Date value) {
            addCriterion("manufacture <", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureLessThanOrEqualTo(Date value) {
            addCriterion("manufacture <=", value, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureIn(List<Date> values) {
            addCriterion("manufacture in", values, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureNotIn(List<Date> values) {
            addCriterion("manufacture not in", values, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureBetween(Date value1, Date value2) {
            addCriterion("manufacture between", value1, value2, "manufacture");
            return (Criteria) this;
        }

        public Criteria andManufactureNotBetween(Date value1, Date value2) {
            addCriterion("manufacture not between", value1, value2, "manufacture");
            return (Criteria) this;
        }

        public Criteria andUseDateIsNull() {
            addCriterion("use_date is null");
            return (Criteria) this;
        }

        public Criteria andUseDateIsNotNull() {
            addCriterion("use_date is not null");
            return (Criteria) this;
        }

        public Criteria andUseDateEqualTo(Date value) {
            addCriterion("use_date =", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateNotEqualTo(Date value) {
            addCriterion("use_date <>", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateGreaterThan(Date value) {
            addCriterion("use_date >", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateGreaterThanOrEqualTo(Date value) {
            addCriterion("use_date >=", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateLessThan(Date value) {
            addCriterion("use_date <", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateLessThanOrEqualTo(Date value) {
            addCriterion("use_date <=", value, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateIn(List<Date> values) {
            addCriterion("use_date in", values, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateNotIn(List<Date> values) {
            addCriterion("use_date not in", values, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateBetween(Date value1, Date value2) {
            addCriterion("use_date between", value1, value2, "useDate");
            return (Criteria) this;
        }

        public Criteria andUseDateNotBetween(Date value1, Date value2) {
            addCriterion("use_date not between", value1, value2, "useDate");
            return (Criteria) this;
        }

        public Criteria andLamppostIsNull() {
            addCriterion("lamppost is null");
            return (Criteria) this;
        }

        public Criteria andLamppostIsNotNull() {
            addCriterion("lamppost is not null");
            return (Criteria) this;
        }

        public Criteria andLamppostEqualTo(String value) {
            addCriterion("lamppost =", value, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLamppostNotEqualTo(String value) {
            addCriterion("lamppost <>", value, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLamppostGreaterThan(String value) {
            addCriterion("lamppost >", value, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLamppostGreaterThanOrEqualTo(String value) {
            addCriterion("lamppost >=", value, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLamppostLessThan(String value) {
            addCriterion("lamppost <", value, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLamppostLessThanOrEqualTo(String value) {
            addCriterion("lamppost <=", value, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLamppostLike(String value) {
            addCriterion("lamppost like", value, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLamppostNotLike(String value) {
            addCriterion("lamppost not like", value, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLamppostIn(List<String> values) {
            addCriterion("lamppost in", values, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLamppostNotIn(List<String> values) {
            addCriterion("lamppost not in", values, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLamppostBetween(String value1, String value2) {
            addCriterion("lamppost between", value1, value2, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLamppostNotBetween(String value1, String value2) {
            addCriterion("lamppost not between", value1, value2, "lamppost");
            return (Criteria) this;
        }

        public Criteria andLampheadIsNull() {
            addCriterion("lamphead is null");
            return (Criteria) this;
        }

        public Criteria andLampheadIsNotNull() {
            addCriterion("lamphead is not null");
            return (Criteria) this;
        }

        public Criteria andLampheadEqualTo(String value) {
            addCriterion("lamphead =", value, "lamphead");
            return (Criteria) this;
        }

        public Criteria andLampheadNotEqualTo(String value) {
            addCriterion("lamphead <>", value, "lamphead");
            return (Criteria) this;
        }

        public Criteria andLampheadGreaterThan(String value) {
            addCriterion("lamphead >", value, "lamphead");
            return (Criteria) this;
        }

        public Criteria andLampheadGreaterThanOrEqualTo(String value) {
            addCriterion("lamphead >=", value, "lamphead");
            return (Criteria) this;
        }

        public Criteria andLampheadLessThan(String value) {
            addCriterion("lamphead <", value, "lamphead");
            return (Criteria) this;
        }

        public Criteria andLampheadLessThanOrEqualTo(String value) {
            addCriterion("lamphead <=", value, "lamphead");
            return (Criteria) this;
        }

        public Criteria andLampheadLike(String value) {
            addCriterion("lamphead like", value, "lamphead");
            return (Criteria) this;
        }

        public Criteria andLampheadNotLike(String value) {
            addCriterion("lamphead not like", value, "lamphead");
            return (Criteria) this;
        }

        public Criteria andLampheadIn(List<String> values) {
            addCriterion("lamphead in", values, "lamphead");
            return (Criteria) this;
        }

        public Criteria andLampheadNotIn(List<String> values) {
            addCriterion("lamphead not in", values, "lamphead");
            return (Criteria) this;
        }

        public Criteria andLampheadBetween(String value1, String value2) {
            addCriterion("lamphead between", value1, value2, "lamphead");
            return (Criteria) this;
        }

        public Criteria andLampheadNotBetween(String value1, String value2) {
            addCriterion("lamphead not between", value1, value2, "lamphead");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdIsNull() {
            addCriterion("nnlightctl_lighting_model_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdIsNotNull() {
            addCriterion("nnlightctl_lighting_model_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdEqualTo(Long value) {
            addCriterion("nnlightctl_lighting_model_id =", value, "nnlightctlLightingModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_lighting_model_id <>", value, "nnlightctlLightingModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdGreaterThan(Long value) {
            addCriterion("nnlightctl_lighting_model_id >", value, "nnlightctlLightingModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_lighting_model_id >=", value, "nnlightctlLightingModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdLessThan(Long value) {
            addCriterion("nnlightctl_lighting_model_id <", value, "nnlightctlLightingModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_lighting_model_id <=", value, "nnlightctlLightingModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdIn(List<Long> values) {
            addCriterion("nnlightctl_lighting_model_id in", values, "nnlightctlLightingModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_lighting_model_id not in", values, "nnlightctlLightingModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_lighting_model_id between", value1, value2, "nnlightctlLightingModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingModelIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_lighting_model_id not between", value1, value2, "nnlightctlLightingModelId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdIsNull() {
            addCriterion("nnlightctl_lighting_gis_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdIsNotNull() {
            addCriterion("nnlightctl_lighting_gis_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdEqualTo(Long value) {
            addCriterion("nnlightctl_lighting_gis_id =", value, "nnlightctlLightingGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_lighting_gis_id <>", value, "nnlightctlLightingGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdGreaterThan(Long value) {
            addCriterion("nnlightctl_lighting_gis_id >", value, "nnlightctlLightingGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_lighting_gis_id >=", value, "nnlightctlLightingGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdLessThan(Long value) {
            addCriterion("nnlightctl_lighting_gis_id <", value, "nnlightctlLightingGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_lighting_gis_id <=", value, "nnlightctlLightingGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdIn(List<Long> values) {
            addCriterion("nnlightctl_lighting_gis_id in", values, "nnlightctlLightingGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_lighting_gis_id not in", values, "nnlightctlLightingGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_lighting_gis_id between", value1, value2, "nnlightctlLightingGisId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlLightingGisIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_lighting_gis_id not between", value1, value2, "nnlightctlLightingGisId");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberIsNull() {
            addCriterion("property_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberIsNotNull() {
            addCriterion("property_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberEqualTo(String value) {
            addCriterion("property_serial_number =", value, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberNotEqualTo(String value) {
            addCriterion("property_serial_number <>", value, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberGreaterThan(String value) {
            addCriterion("property_serial_number >", value, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("property_serial_number >=", value, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberLessThan(String value) {
            addCriterion("property_serial_number <", value, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberLessThanOrEqualTo(String value) {
            addCriterion("property_serial_number <=", value, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberLike(String value) {
            addCriterion("property_serial_number like", value, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberNotLike(String value) {
            addCriterion("property_serial_number not like", value, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberIn(List<String> values) {
            addCriterion("property_serial_number in", values, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberNotIn(List<String> values) {
            addCriterion("property_serial_number not in", values, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberBetween(String value1, String value2) {
            addCriterion("property_serial_number between", value1, value2, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andPropertySerialNumberNotBetween(String value1, String value2) {
            addCriterion("property_serial_number not between", value1, value2, "propertySerialNumber");
            return (Criteria) this;
        }

        public Criteria andDecayIsNull() {
            addCriterion("decay is null");
            return (Criteria) this;
        }

        public Criteria andDecayIsNotNull() {
            addCriterion("decay is not null");
            return (Criteria) this;
        }

        public Criteria andDecayEqualTo(Long value) {
            addCriterion("decay =", value, "decay");
            return (Criteria) this;
        }

        public Criteria andDecayNotEqualTo(Long value) {
            addCriterion("decay <>", value, "decay");
            return (Criteria) this;
        }

        public Criteria andDecayGreaterThan(Long value) {
            addCriterion("decay >", value, "decay");
            return (Criteria) this;
        }

        public Criteria andDecayGreaterThanOrEqualTo(Long value) {
            addCriterion("decay >=", value, "decay");
            return (Criteria) this;
        }

        public Criteria andDecayLessThan(Long value) {
            addCriterion("decay <", value, "decay");
            return (Criteria) this;
        }

        public Criteria andDecayLessThanOrEqualTo(Long value) {
            addCriterion("decay <=", value, "decay");
            return (Criteria) this;
        }

        public Criteria andDecayIn(List<Long> values) {
            addCriterion("decay in", values, "decay");
            return (Criteria) this;
        }

        public Criteria andDecayNotIn(List<Long> values) {
            addCriterion("decay not in", values, "decay");
            return (Criteria) this;
        }

        public Criteria andDecayBetween(Long value1, Long value2) {
            addCriterion("decay between", value1, value2, "decay");
            return (Criteria) this;
        }

        public Criteria andDecayNotBetween(Long value1, Long value2) {
            addCriterion("decay not between", value1, value2, "decay");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeIsNull() {
            addCriterion("max_use_time is null");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeIsNotNull() {
            addCriterion("max_use_time is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeEqualTo(Long value) {
            addCriterion("max_use_time =", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeNotEqualTo(Long value) {
            addCriterion("max_use_time <>", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeGreaterThan(Long value) {
            addCriterion("max_use_time >", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("max_use_time >=", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeLessThan(Long value) {
            addCriterion("max_use_time <", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeLessThanOrEqualTo(Long value) {
            addCriterion("max_use_time <=", value, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeIn(List<Long> values) {
            addCriterion("max_use_time in", values, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeNotIn(List<Long> values) {
            addCriterion("max_use_time not in", values, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeBetween(Long value1, Long value2) {
            addCriterion("max_use_time between", value1, value2, "maxUseTime");
            return (Criteria) this;
        }

        public Criteria andMaxUseTimeNotBetween(Long value1, Long value2) {
            addCriterion("max_use_time not between", value1, value2, "maxUseTime");
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

        public Criteria andNnlightctlEleboxModelLoopIdIsNull() {
            addCriterion("nnlightctl_elebox_model_loop_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelLoopIdIsNotNull() {
            addCriterion("nnlightctl_elebox_model_loop_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelLoopIdEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_model_loop_id =", value, "nnlightctlEleboxModelLoopId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelLoopIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_model_loop_id <>", value, "nnlightctlEleboxModelLoopId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelLoopIdGreaterThan(Long value) {
            addCriterion("nnlightctl_elebox_model_loop_id >", value, "nnlightctlEleboxModelLoopId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelLoopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_model_loop_id >=", value, "nnlightctlEleboxModelLoopId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelLoopIdLessThan(Long value) {
            addCriterion("nnlightctl_elebox_model_loop_id <", value, "nnlightctlEleboxModelLoopId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelLoopIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_elebox_model_loop_id <=", value, "nnlightctlEleboxModelLoopId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelLoopIdIn(List<Long> values) {
            addCriterion("nnlightctl_elebox_model_loop_id in", values, "nnlightctlEleboxModelLoopId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelLoopIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_elebox_model_loop_id not in", values, "nnlightctlEleboxModelLoopId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelLoopIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_elebox_model_loop_id between", value1, value2, "nnlightctlEleboxModelLoopId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlEleboxModelLoopIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_elebox_model_loop_id not between", value1, value2, "nnlightctlEleboxModelLoopId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdIsNull() {
            addCriterion("nnlightctl_region_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdIsNotNull() {
            addCriterion("nnlightctl_region_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdEqualTo(Long value) {
            addCriterion("nnlightctl_region_id =", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_region_id <>", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdGreaterThan(Long value) {
            addCriterion("nnlightctl_region_id >", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_region_id >=", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdLessThan(Long value) {
            addCriterion("nnlightctl_region_id <", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_region_id <=", value, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdIn(List<Long> values) {
            addCriterion("nnlightctl_region_id in", values, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_region_id not in", values, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_region_id between", value1, value2, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_region_id not between", value1, value2, "nnlightctlRegionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdIsNull() {
            addCriterion("nnlightctl_project_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdIsNotNull() {
            addCriterion("nnlightctl_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdEqualTo(Long value) {
            addCriterion("nnlightctl_project_id =", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_project_id <>", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdGreaterThan(Long value) {
            addCriterion("nnlightctl_project_id >", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_project_id >=", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdLessThan(Long value) {
            addCriterion("nnlightctl_project_id <", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_project_id <=", value, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdIn(List<Long> values) {
            addCriterion("nnlightctl_project_id in", values, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_project_id not in", values, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_project_id between", value1, value2, "nnlightctlProjectId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_project_id not between", value1, value2, "nnlightctlProjectId");
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