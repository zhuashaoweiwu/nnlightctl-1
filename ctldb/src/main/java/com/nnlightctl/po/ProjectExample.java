package com.nnlightctl.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andCodeNumberIsNull() {
            addCriterion("code_number is null");
            return (Criteria) this;
        }

        public Criteria andCodeNumberIsNotNull() {
            addCriterion("code_number is not null");
            return (Criteria) this;
        }

        public Criteria andCodeNumberEqualTo(String value) {
            addCriterion("code_number =", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberNotEqualTo(String value) {
            addCriterion("code_number <>", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberGreaterThan(String value) {
            addCriterion("code_number >", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("code_number >=", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberLessThan(String value) {
            addCriterion("code_number <", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberLessThanOrEqualTo(String value) {
            addCriterion("code_number <=", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberLike(String value) {
            addCriterion("code_number like", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberNotLike(String value) {
            addCriterion("code_number not like", value, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberIn(List<String> values) {
            addCriterion("code_number in", values, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberNotIn(List<String> values) {
            addCriterion("code_number not in", values, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberBetween(String value1, String value2) {
            addCriterion("code_number between", value1, value2, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andCodeNumberNotBetween(String value1, String value2) {
            addCriterion("code_number not between", value1, value2, "codeNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
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

        public Criteria andNnlightctlProjectCountryIdIsNull() {
            addCriterion("nnlightctl_project_country_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCountryIdIsNotNull() {
            addCriterion("nnlightctl_project_country_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCountryIdEqualTo(Long value) {
            addCriterion("nnlightctl_project_country_id =", value, "nnlightctlProjectCountryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCountryIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_project_country_id <>", value, "nnlightctlProjectCountryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCountryIdGreaterThan(Long value) {
            addCriterion("nnlightctl_project_country_id >", value, "nnlightctlProjectCountryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCountryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_project_country_id >=", value, "nnlightctlProjectCountryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCountryIdLessThan(Long value) {
            addCriterion("nnlightctl_project_country_id <", value, "nnlightctlProjectCountryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCountryIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_project_country_id <=", value, "nnlightctlProjectCountryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCountryIdIn(List<Long> values) {
            addCriterion("nnlightctl_project_country_id in", values, "nnlightctlProjectCountryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCountryIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_project_country_id not in", values, "nnlightctlProjectCountryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCountryIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_project_country_id between", value1, value2, "nnlightctlProjectCountryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCountryIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_project_country_id not between", value1, value2, "nnlightctlProjectCountryId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdIsNull() {
            addCriterion("nnlightctl_project_province_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdIsNotNull() {
            addCriterion("nnlightctl_project_province_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdEqualTo(Long value) {
            addCriterion("nnlightctl_project_province_id =", value, "nnlightctlProjectProvinceId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_project_province_id <>", value, "nnlightctlProjectProvinceId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdGreaterThan(Long value) {
            addCriterion("nnlightctl_project_province_id >", value, "nnlightctlProjectProvinceId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_project_province_id >=", value, "nnlightctlProjectProvinceId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdLessThan(Long value) {
            addCriterion("nnlightctl_project_province_id <", value, "nnlightctlProjectProvinceId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_project_province_id <=", value, "nnlightctlProjectProvinceId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdIn(List<Long> values) {
            addCriterion("nnlightctl_project_province_id in", values, "nnlightctlProjectProvinceId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_project_province_id not in", values, "nnlightctlProjectProvinceId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_project_province_id between", value1, value2, "nnlightctlProjectProvinceId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectProvinceIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_project_province_id not between", value1, value2, "nnlightctlProjectProvinceId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdIsNull() {
            addCriterion("nnlightctl_project_city_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdIsNotNull() {
            addCriterion("nnlightctl_project_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdEqualTo(Long value) {
            addCriterion("nnlightctl_project_city_id =", value, "nnlightctlProjectCityId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_project_city_id <>", value, "nnlightctlProjectCityId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdGreaterThan(Long value) {
            addCriterion("nnlightctl_project_city_id >", value, "nnlightctlProjectCityId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_project_city_id >=", value, "nnlightctlProjectCityId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdLessThan(Long value) {
            addCriterion("nnlightctl_project_city_id <", value, "nnlightctlProjectCityId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_project_city_id <=", value, "nnlightctlProjectCityId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdIn(List<Long> values) {
            addCriterion("nnlightctl_project_city_id in", values, "nnlightctlProjectCityId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_project_city_id not in", values, "nnlightctlProjectCityId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_project_city_id between", value1, value2, "nnlightctlProjectCityId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlProjectCityIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_project_city_id not between", value1, value2, "nnlightctlProjectCityId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdIsNull() {
            addCriterion("nnlightctl_institution_id is null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdIsNotNull() {
            addCriterion("nnlightctl_institution_id is not null");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdEqualTo(Long value) {
            addCriterion("nnlightctl_institution_id =", value, "nnlightctlInstitutionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdNotEqualTo(Long value) {
            addCriterion("nnlightctl_institution_id <>", value, "nnlightctlInstitutionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdGreaterThan(Long value) {
            addCriterion("nnlightctl_institution_id >", value, "nnlightctlInstitutionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_institution_id >=", value, "nnlightctlInstitutionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdLessThan(Long value) {
            addCriterion("nnlightctl_institution_id <", value, "nnlightctlInstitutionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdLessThanOrEqualTo(Long value) {
            addCriterion("nnlightctl_institution_id <=", value, "nnlightctlInstitutionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdIn(List<Long> values) {
            addCriterion("nnlightctl_institution_id in", values, "nnlightctlInstitutionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdNotIn(List<Long> values) {
            addCriterion("nnlightctl_institution_id not in", values, "nnlightctlInstitutionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_institution_id between", value1, value2, "nnlightctlInstitutionId");
            return (Criteria) this;
        }

        public Criteria andNnlightctlInstitutionIdNotBetween(Long value1, Long value2) {
            addCriterion("nnlightctl_institution_id not between", value1, value2, "nnlightctlInstitutionId");
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