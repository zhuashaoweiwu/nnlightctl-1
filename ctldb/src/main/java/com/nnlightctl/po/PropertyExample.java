package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PropertyExample() {
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

        public Criteria andPropertyRecordDatetimeIsNull() {
            addCriterion("property_record_datetime is null");
            return (Criteria) this;
        }

        public Criteria andPropertyRecordDatetimeIsNotNull() {
            addCriterion("property_record_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyRecordDatetimeEqualTo(Date value) {
            addCriterion("property_record_datetime =", value, "propertyRecordDatetime");
            return (Criteria) this;
        }

        public Criteria andPropertyRecordDatetimeNotEqualTo(Date value) {
            addCriterion("property_record_datetime <>", value, "propertyRecordDatetime");
            return (Criteria) this;
        }

        public Criteria andPropertyRecordDatetimeGreaterThan(Date value) {
            addCriterion("property_record_datetime >", value, "propertyRecordDatetime");
            return (Criteria) this;
        }

        public Criteria andPropertyRecordDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("property_record_datetime >=", value, "propertyRecordDatetime");
            return (Criteria) this;
        }

        public Criteria andPropertyRecordDatetimeLessThan(Date value) {
            addCriterion("property_record_datetime <", value, "propertyRecordDatetime");
            return (Criteria) this;
        }

        public Criteria andPropertyRecordDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("property_record_datetime <=", value, "propertyRecordDatetime");
            return (Criteria) this;
        }

        public Criteria andPropertyRecordDatetimeIn(List<Date> values) {
            addCriterion("property_record_datetime in", values, "propertyRecordDatetime");
            return (Criteria) this;
        }

        public Criteria andPropertyRecordDatetimeNotIn(List<Date> values) {
            addCriterion("property_record_datetime not in", values, "propertyRecordDatetime");
            return (Criteria) this;
        }

        public Criteria andPropertyRecordDatetimeBetween(Date value1, Date value2) {
            addCriterion("property_record_datetime between", value1, value2, "propertyRecordDatetime");
            return (Criteria) this;
        }

        public Criteria andPropertyRecordDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("property_record_datetime not between", value1, value2, "propertyRecordDatetime");
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

        public Criteria andLongitudeEqualTo(Long value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(Long value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(Long value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(Long value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(Long value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(Long value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<Long> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<Long> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(Long value1, Long value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(Long value1, Long value2) {
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

        public Criteria andLatitudeEqualTo(Long value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Long value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Long value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Long value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Long value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Long value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Long> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Long> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Long value1, Long value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Long value1, Long value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyIsNull() {
            addCriterion("comman_property is null");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyIsNotNull() {
            addCriterion("comman_property is not null");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyEqualTo(String value) {
            addCriterion("comman_property =", value, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyNotEqualTo(String value) {
            addCriterion("comman_property <>", value, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyGreaterThan(String value) {
            addCriterion("comman_property >", value, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("comman_property >=", value, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyLessThan(String value) {
            addCriterion("comman_property <", value, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyLessThanOrEqualTo(String value) {
            addCriterion("comman_property <=", value, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyLike(String value) {
            addCriterion("comman_property like", value, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyNotLike(String value) {
            addCriterion("comman_property not like", value, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyIn(List<String> values) {
            addCriterion("comman_property in", values, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyNotIn(List<String> values) {
            addCriterion("comman_property not in", values, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyBetween(String value1, String value2) {
            addCriterion("comman_property between", value1, value2, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andCommanPropertyNotBetween(String value1, String value2) {
            addCriterion("comman_property not between", value1, value2, "commanProperty");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdIsNull() {
            addCriterion("property_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdIsNotNull() {
            addCriterion("property_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdEqualTo(Long value) {
            addCriterion("property_manager_id =", value, "propertyManagerId");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdNotEqualTo(Long value) {
            addCriterion("property_manager_id <>", value, "propertyManagerId");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdGreaterThan(Long value) {
            addCriterion("property_manager_id >", value, "propertyManagerId");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("property_manager_id >=", value, "propertyManagerId");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdLessThan(Long value) {
            addCriterion("property_manager_id <", value, "propertyManagerId");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdLessThanOrEqualTo(Long value) {
            addCriterion("property_manager_id <=", value, "propertyManagerId");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdIn(List<Long> values) {
            addCriterion("property_manager_id in", values, "propertyManagerId");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdNotIn(List<Long> values) {
            addCriterion("property_manager_id not in", values, "propertyManagerId");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdBetween(Long value1, Long value2) {
            addCriterion("property_manager_id between", value1, value2, "propertyManagerId");
            return (Criteria) this;
        }

        public Criteria andPropertyManagerIdNotBetween(Long value1, Long value2) {
            addCriterion("property_manager_id not between", value1, value2, "propertyManagerId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdIsNull() {
            addCriterion("nnlightctl_property_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdIsNotNull() {
            addCriterion("nnlightctl_property_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdEqualTo(Long value) {
            addCriterion("nnlightctl_property_id =", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_property_id <>", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdGreaterThan(Long value) {
            addCriterion("nnlightctl_property_id >", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_property_id >=", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdLessThan(Long value) {
            addCriterion("nnlightctl_property_id <", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_property_id <=", value, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdIn(List<Long> values) {
            addCriterion("nnlightctl_property_id in", values, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_property_id not in", values, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_property_id between", value1, value2, "nnlightctlPropertyId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_property_id not between", value1, value2, "nnlightctlPropertyId");
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

        public Criteria andNnlightctlPropertyClassifyCatalogIdIsNull() {
            addCriterion("nnlightctl_property_classify_catalog_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdIsNotNull() {
            addCriterion("nnlightctl_property_classify_catalog_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdEqualTo(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id =", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id <>", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdGreaterThan(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id >", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id >=", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdLessThan(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id <", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_property_classify_catalog_id <=", value, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdIn(List<Long> values) {
            addCriterion("nnlightctl_property_classify_catalog_id in", values, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_property_classify_catalog_id not in", values, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_property_classify_catalog_id between", value1, value2, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlPropertyClassifyCatalogIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_property_classify_catalog_id not between", value1, value2, "nnlightctlPropertyClassifyCatalogId");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescIsNull() {
            addCriterion("property_classify_catalog_desc is null");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescIsNotNull() {
            addCriterion("property_classify_catalog_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescEqualTo(String value) {
            addCriterion("property_classify_catalog_desc =", value, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescNotEqualTo(String value) {
            addCriterion("property_classify_catalog_desc <>", value, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescGreaterThan(String value) {
            addCriterion("property_classify_catalog_desc >", value, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescGreaterThanOrEqualTo(String value) {
            addCriterion("property_classify_catalog_desc >=", value, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescLessThan(String value) {
            addCriterion("property_classify_catalog_desc <", value, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescLessThanOrEqualTo(String value) {
            addCriterion("property_classify_catalog_desc <=", value, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescLike(String value) {
            addCriterion("property_classify_catalog_desc like", value, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescNotLike(String value) {
            addCriterion("property_classify_catalog_desc not like", value, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescIn(List<String> values) {
            addCriterion("property_classify_catalog_desc in", values, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescNotIn(List<String> values) {
            addCriterion("property_classify_catalog_desc not in", values, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescBetween(String value1, String value2) {
            addCriterion("property_classify_catalog_desc between", value1, value2, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogDescNotBetween(String value1, String value2) {
            addCriterion("property_classify_catalog_desc not between", value1, value2, "propertyClassifyCatalogDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameIsNull() {
            addCriterion("property_classify_catalog_name is null");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameIsNotNull() {
            addCriterion("property_classify_catalog_name is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameEqualTo(String value) {
            addCriterion("property_classify_catalog_name =", value, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameNotEqualTo(String value) {
            addCriterion("property_classify_catalog_name <>", value, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameGreaterThan(String value) {
            addCriterion("property_classify_catalog_name >", value, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameGreaterThanOrEqualTo(String value) {
            addCriterion("property_classify_catalog_name >=", value, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameLessThan(String value) {
            addCriterion("property_classify_catalog_name <", value, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameLessThanOrEqualTo(String value) {
            addCriterion("property_classify_catalog_name <=", value, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameLike(String value) {
            addCriterion("property_classify_catalog_name like", value, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameNotLike(String value) {
            addCriterion("property_classify_catalog_name not like", value, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameIn(List<String> values) {
            addCriterion("property_classify_catalog_name in", values, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameNotIn(List<String> values) {
            addCriterion("property_classify_catalog_name not in", values, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameBetween(String value1, String value2) {
            addCriterion("property_classify_catalog_name between", value1, value2, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andPropertyClassifyCatalogNameNotBetween(String value1, String value2) {
            addCriterion("property_classify_catalog_name not between", value1, value2, "propertyClassifyCatalogName");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdIsNull() {
            addCriterion("nnlightctl_user_applier_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdIsNotNull() {
            addCriterion("nnlightctl_user_applier_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdEqualTo(Long value) {
            addCriterion("nnlightctl_user_applier_id =", value, "nnlightctlUserApplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_user_applier_id <>", value, "nnlightctlUserApplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdGreaterThan(Long value) {
            addCriterion("nnlightctl_user_applier_id >", value, "nnlightctlUserApplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_user_applier_id >=", value, "nnlightctlUserApplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdLessThan(Long value) {
            addCriterion("nnlightctl_user_applier_id <", value, "nnlightctlUserApplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_user_applier_id <=", value, "nnlightctlUserApplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdIn(List<Long> values) {
            addCriterion("nnlightctl_user_applier_id in", values, "nnlightctlUserApplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_user_applier_id not in", values, "nnlightctlUserApplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_user_applier_id between", value1, value2, "nnlightctlUserApplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlUserApplierIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_user_applier_id not between", value1, value2, "nnlightctlUserApplierId");
            return (Criteria) this;
        }

        public Criteria andPropertyCountIsNull() {
            addCriterion("property_count is null");
            return (Criteria) this;
        }

        public Criteria andPropertyCountIsNotNull() {
            addCriterion("property_count is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyCountEqualTo(Long value) {
            addCriterion("property_count =", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountNotEqualTo(Long value) {
            addCriterion("property_count <>", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountGreaterThan(Long value) {
            addCriterion("property_count >", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountGreaterThanOrEqualTo(Long value) {
            addCriterion("property_count >=", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountLessThan(Long value) {
            addCriterion("property_count <", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountLessThanOrEqualTo(Long value) {
            addCriterion("property_count <=", value, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountIn(List<Long> values) {
            addCriterion("property_count in", values, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountNotIn(List<Long> values) {
            addCriterion("property_count not in", values, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountBetween(Long value1, Long value2) {
            addCriterion("property_count between", value1, value2, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andPropertyCountNotBetween(Long value1, Long value2) {
            addCriterion("property_count not between", value1, value2, "propertyCount");
            return (Criteria) this;
        }

        public Criteria andApplyStateIsNull() {
            addCriterion("apply_state is null");
            return (Criteria) this;
        }

        public Criteria andApplyStateIsNotNull() {
            addCriterion("apply_state is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStateEqualTo(Byte value) {
            addCriterion("apply_state =", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotEqualTo(Byte value) {
            addCriterion("apply_state <>", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateGreaterThan(Byte value) {
            addCriterion("apply_state >", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("apply_state >=", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLessThan(Byte value) {
            addCriterion("apply_state <", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLessThanOrEqualTo(Byte value) {
            addCriterion("apply_state <=", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateIn(List<Byte> values) {
            addCriterion("apply_state in", values, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotIn(List<Byte> values) {
            addCriterion("apply_state not in", values, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateBetween(Byte value1, Byte value2) {
            addCriterion("apply_state between", value1, value2, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotBetween(Byte value1, Byte value2) {
            addCriterion("apply_state not between", value1, value2, "applyState");
            return (Criteria) this;
        }

        public Criteria andInOutStateIsNull() {
            addCriterion("in_out_state is null");
            return (Criteria) this;
        }

        public Criteria andInOutStateIsNotNull() {
            addCriterion("in_out_state is not null");
            return (Criteria) this;
        }

        public Criteria andInOutStateEqualTo(Byte value) {
            addCriterion("in_out_state =", value, "inOutState");
            return (Criteria) this;
        }

        public Criteria andInOutStateNotEqualTo(Byte value) {
            addCriterion("in_out_state <>", value, "inOutState");
            return (Criteria) this;
        }

        public Criteria andInOutStateGreaterThan(Byte value) {
            addCriterion("in_out_state >", value, "inOutState");
            return (Criteria) this;
        }

        public Criteria andInOutStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("in_out_state >=", value, "inOutState");
            return (Criteria) this;
        }

        public Criteria andInOutStateLessThan(Byte value) {
            addCriterion("in_out_state <", value, "inOutState");
            return (Criteria) this;
        }

        public Criteria andInOutStateLessThanOrEqualTo(Byte value) {
            addCriterion("in_out_state <=", value, "inOutState");
            return (Criteria) this;
        }

        public Criteria andInOutStateIn(List<Byte> values) {
            addCriterion("in_out_state in", values, "inOutState");
            return (Criteria) this;
        }

        public Criteria andInOutStateNotIn(List<Byte> values) {
            addCriterion("in_out_state not in", values, "inOutState");
            return (Criteria) this;
        }

        public Criteria andInOutStateBetween(Byte value1, Byte value2) {
            addCriterion("in_out_state between", value1, value2, "inOutState");
            return (Criteria) this;
        }

        public Criteria andInOutStateNotBetween(Byte value1, Byte value2) {
            addCriterion("in_out_state not between", value1, value2, "inOutState");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonidIsNull() {
            addCriterion("reasonid is null");
            return (Criteria) this;
        }

        public Criteria andReasonidIsNotNull() {
            addCriterion("reasonid is not null");
            return (Criteria) this;
        }

        public Criteria andReasonidEqualTo(Long value) {
            addCriterion("reasonid =", value, "reasonid");
            return (Criteria) this;
        }

        public Criteria andReasonidNotEqualTo(Long value) {
            addCriterion("reasonid <>", value, "reasonid");
            return (Criteria) this;
        }

        public Criteria andReasonidGreaterThan(Long value) {
            addCriterion("reasonid >", value, "reasonid");
            return (Criteria) this;
        }

        public Criteria andReasonidGreaterThanOrEqualTo(Long value) {
            addCriterion("reasonid >=", value, "reasonid");
            return (Criteria) this;
        }

        public Criteria andReasonidLessThan(Long value) {
            addCriterion("reasonid <", value, "reasonid");
            return (Criteria) this;
        }

        public Criteria andReasonidLessThanOrEqualTo(Long value) {
            addCriterion("reasonid <=", value, "reasonid");
            return (Criteria) this;
        }

        public Criteria andReasonidIn(List<Long> values) {
            addCriterion("reasonid in", values, "reasonid");
            return (Criteria) this;
        }

        public Criteria andReasonidNotIn(List<Long> values) {
            addCriterion("reasonid not in", values, "reasonid");
            return (Criteria) this;
        }

        public Criteria andReasonidBetween(Long value1, Long value2) {
            addCriterion("reasonid between", value1, value2, "reasonid");
            return (Criteria) this;
        }

        public Criteria andReasonidNotBetween(Long value1, Long value2) {
            addCriterion("reasonid not between", value1, value2, "reasonid");
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

        public Criteria andNnlightctlSupplierIdIsNull() {
            addCriterion("nnlightctl_supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIdIsNotNull() {
            addCriterion("nnlightctl_supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIdEqualTo(Long value) {
            addCriterion("nnlightctl_supplier_id =", value, "nnlightctlSupplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_supplier_id <>", value, "nnlightctlSupplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIdGreaterThan(Long value) {
            addCriterion("nnlightctl_supplier_id >", value, "nnlightctlSupplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_supplier_id >=", value, "nnlightctlSupplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIdLessThan(Long value) {
            addCriterion("nnlightctl_supplier_id <", value, "nnlightctlSupplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_supplier_id <=", value, "nnlightctlSupplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIdIn(List<Long> values) {
            addCriterion("nnlightctl_supplier_id in", values, "nnlightctlSupplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_supplier_id not in", values, "nnlightctlSupplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_supplier_id between", value1, value2, "nnlightctlSupplierId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlSupplierIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_supplier_id not between", value1, value2, "nnlightctlSupplierId");
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