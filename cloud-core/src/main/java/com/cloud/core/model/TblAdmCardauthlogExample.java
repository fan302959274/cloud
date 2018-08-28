package com.cloud.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TblAdmCardauthlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblAdmCardauthlogExample() {
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

        public Criteria andCalAuthBankNameIsNull() {
            addCriterion("CAL_AUTH_BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameIsNotNull() {
            addCriterion("CAL_AUTH_BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameEqualTo(String value) {
            addCriterion("CAL_AUTH_BANK_NAME =", value, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameNotEqualTo(String value) {
            addCriterion("CAL_AUTH_BANK_NAME <>", value, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameGreaterThan(String value) {
            addCriterion("CAL_AUTH_BANK_NAME >", value, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_BANK_NAME >=", value, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameLessThan(String value) {
            addCriterion("CAL_AUTH_BANK_NAME <", value, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameLessThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_BANK_NAME <=", value, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameLike(String value) {
            addCriterion("CAL_AUTH_BANK_NAME like", value, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameNotLike(String value) {
            addCriterion("CAL_AUTH_BANK_NAME not like", value, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameIn(List<String> values) {
            addCriterion("CAL_AUTH_BANK_NAME in", values, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameNotIn(List<String> values) {
            addCriterion("CAL_AUTH_BANK_NAME not in", values, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_BANK_NAME between", value1, value2, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankNameNotBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_BANK_NAME not between", value1, value2, "calAuthBankName");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardIsNull() {
            addCriterion("CAL_AUTH_BANK_CARD is null");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardIsNotNull() {
            addCriterion("CAL_AUTH_BANK_CARD is not null");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardEqualTo(String value) {
            addCriterion("CAL_AUTH_BANK_CARD =", value, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardNotEqualTo(String value) {
            addCriterion("CAL_AUTH_BANK_CARD <>", value, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardGreaterThan(String value) {
            addCriterion("CAL_AUTH_BANK_CARD >", value, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardGreaterThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_BANK_CARD >=", value, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardLessThan(String value) {
            addCriterion("CAL_AUTH_BANK_CARD <", value, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardLessThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_BANK_CARD <=", value, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardLike(String value) {
            addCriterion("CAL_AUTH_BANK_CARD like", value, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardNotLike(String value) {
            addCriterion("CAL_AUTH_BANK_CARD not like", value, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardIn(List<String> values) {
            addCriterion("CAL_AUTH_BANK_CARD in", values, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardNotIn(List<String> values) {
            addCriterion("CAL_AUTH_BANK_CARD not in", values, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_BANK_CARD between", value1, value2, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthBankCardNotBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_BANK_CARD not between", value1, value2, "calAuthBankCard");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameIsNull() {
            addCriterion("CAL_AUTH_CUST_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameIsNotNull() {
            addCriterion("CAL_AUTH_CUST_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameEqualTo(String value) {
            addCriterion("CAL_AUTH_CUST_NAME =", value, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameNotEqualTo(String value) {
            addCriterion("CAL_AUTH_CUST_NAME <>", value, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameGreaterThan(String value) {
            addCriterion("CAL_AUTH_CUST_NAME >", value, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_CUST_NAME >=", value, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameLessThan(String value) {
            addCriterion("CAL_AUTH_CUST_NAME <", value, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameLessThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_CUST_NAME <=", value, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameLike(String value) {
            addCriterion("CAL_AUTH_CUST_NAME like", value, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameNotLike(String value) {
            addCriterion("CAL_AUTH_CUST_NAME not like", value, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameIn(List<String> values) {
            addCriterion("CAL_AUTH_CUST_NAME in", values, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameNotIn(List<String> values) {
            addCriterion("CAL_AUTH_CUST_NAME not in", values, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_CUST_NAME between", value1, value2, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthCustNameNotBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_CUST_NAME not between", value1, value2, "calAuthCustName");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoIsNull() {
            addCriterion("CAL_AUTH_IDNO is null");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoIsNotNull() {
            addCriterion("CAL_AUTH_IDNO is not null");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoEqualTo(String value) {
            addCriterion("CAL_AUTH_IDNO =", value, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoNotEqualTo(String value) {
            addCriterion("CAL_AUTH_IDNO <>", value, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoGreaterThan(String value) {
            addCriterion("CAL_AUTH_IDNO >", value, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoGreaterThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_IDNO >=", value, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoLessThan(String value) {
            addCriterion("CAL_AUTH_IDNO <", value, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoLessThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_IDNO <=", value, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoLike(String value) {
            addCriterion("CAL_AUTH_IDNO like", value, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoNotLike(String value) {
            addCriterion("CAL_AUTH_IDNO not like", value, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoIn(List<String> values) {
            addCriterion("CAL_AUTH_IDNO in", values, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoNotIn(List<String> values) {
            addCriterion("CAL_AUTH_IDNO not in", values, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_IDNO between", value1, value2, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthIdnoNotBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_IDNO not between", value1, value2, "calAuthIdno");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileIsNull() {
            addCriterion("CAL_AUTH_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileIsNotNull() {
            addCriterion("CAL_AUTH_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileEqualTo(String value) {
            addCriterion("CAL_AUTH_MOBILE =", value, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileNotEqualTo(String value) {
            addCriterion("CAL_AUTH_MOBILE <>", value, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileGreaterThan(String value) {
            addCriterion("CAL_AUTH_MOBILE >", value, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileGreaterThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_MOBILE >=", value, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileLessThan(String value) {
            addCriterion("CAL_AUTH_MOBILE <", value, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileLessThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_MOBILE <=", value, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileLike(String value) {
            addCriterion("CAL_AUTH_MOBILE like", value, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileNotLike(String value) {
            addCriterion("CAL_AUTH_MOBILE not like", value, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileIn(List<String> values) {
            addCriterion("CAL_AUTH_MOBILE in", values, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileNotIn(List<String> values) {
            addCriterion("CAL_AUTH_MOBILE not in", values, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_MOBILE between", value1, value2, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthMobileNotBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_MOBILE not between", value1, value2, "calAuthMobile");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeIsNull() {
            addCriterion("CAL_AUTH_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeIsNotNull() {
            addCriterion("CAL_AUTH_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeEqualTo(String value) {
            addCriterion("CAL_AUTH_TYPE =", value, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeNotEqualTo(String value) {
            addCriterion("CAL_AUTH_TYPE <>", value, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeGreaterThan(String value) {
            addCriterion("CAL_AUTH_TYPE >", value, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_TYPE >=", value, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeLessThan(String value) {
            addCriterion("CAL_AUTH_TYPE <", value, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeLessThanOrEqualTo(String value) {
            addCriterion("CAL_AUTH_TYPE <=", value, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeLike(String value) {
            addCriterion("CAL_AUTH_TYPE like", value, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeNotLike(String value) {
            addCriterion("CAL_AUTH_TYPE not like", value, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeIn(List<String> values) {
            addCriterion("CAL_AUTH_TYPE in", values, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeNotIn(List<String> values) {
            addCriterion("CAL_AUTH_TYPE not in", values, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_TYPE between", value1, value2, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCalAuthTypeNotBetween(String value1, String value2) {
            addCriterion("CAL_AUTH_TYPE not between", value1, value2, "calAuthType");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNull() {
            addCriterion("updator is null");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNotNull() {
            addCriterion("updator is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatorEqualTo(String value) {
            addCriterion("updator =", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotEqualTo(String value) {
            addCriterion("updator <>", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThan(String value) {
            addCriterion("updator >", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThanOrEqualTo(String value) {
            addCriterion("updator >=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThan(String value) {
            addCriterion("updator <", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThanOrEqualTo(String value) {
            addCriterion("updator <=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLike(String value) {
            addCriterion("updator like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotLike(String value) {
            addCriterion("updator not like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIn(List<String> values) {
            addCriterion("updator in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotIn(List<String> values) {
            addCriterion("updator not in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorBetween(String value1, String value2) {
            addCriterion("updator between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotBetween(String value1, String value2) {
            addCriterion("updator not between", value1, value2, "updator");
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