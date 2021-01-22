package com.bishe.ssm.bean;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CatExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andCatnameIsNull() {
            addCriterion("catname is null");
            return (Criteria) this;
        }

        public Criteria andCatnameIsNotNull() {
            addCriterion("catname is not null");
            return (Criteria) this;
        }

        public Criteria andCatnameEqualTo(String value) {
            addCriterion("catname =", value, "catname");
            return (Criteria) this;
        }

        public Criteria andCatnameNotEqualTo(String value) {
            addCriterion("catname <>", value, "catname");
            return (Criteria) this;
        }

        public Criteria andCatnameGreaterThan(String value) {
            addCriterion("catname >", value, "catname");
            return (Criteria) this;
        }

        public Criteria andCatnameGreaterThanOrEqualTo(String value) {
            addCriterion("catname >=", value, "catname");
            return (Criteria) this;
        }

        public Criteria andCatnameLessThan(String value) {
            addCriterion("catname <", value, "catname");
            return (Criteria) this;
        }

        public Criteria andCatnameLessThanOrEqualTo(String value) {
            addCriterion("catname <=", value, "catname");
            return (Criteria) this;
        }

        public Criteria andCatnameLike(String value) {
            addCriterion("catname like", value, "catname");
            return (Criteria) this;
        }

        public Criteria andCatnameNotLike(String value) {
            addCriterion("catname not like", value, "catname");
            return (Criteria) this;
        }

        public Criteria andCatnameIn(List<String> values) {
            addCriterion("catname in", values, "catname");
            return (Criteria) this;
        }

        public Criteria andCatnameNotIn(List<String> values) {
            addCriterion("catname not in", values, "catname");
            return (Criteria) this;
        }

        public Criteria andCatnameBetween(String value1, String value2) {
            addCriterion("catname between", value1, value2, "catname");
            return (Criteria) this;
        }

        public Criteria andCatnameNotBetween(String value1, String value2) {
            addCriterion("catname not between", value1, value2, "catname");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andComefromIsNull() {
            addCriterion("comefrom is null");
            return (Criteria) this;
        }

        public Criteria andComefromIsNotNull() {
            addCriterion("comefrom is not null");
            return (Criteria) this;
        }

        public Criteria andComefromEqualTo(String value) {
            addCriterion("comefrom =", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromNotEqualTo(String value) {
            addCriterion("comefrom <>", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromGreaterThan(String value) {
            addCriterion("comefrom >", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromGreaterThanOrEqualTo(String value) {
            addCriterion("comefrom >=", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromLessThan(String value) {
            addCriterion("comefrom <", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromLessThanOrEqualTo(String value) {
            addCriterion("comefrom <=", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromLike(String value) {
            addCriterion("comefrom like", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromNotLike(String value) {
            addCriterion("comefrom not like", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromIn(List<String> values) {
            addCriterion("comefrom in", values, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromNotIn(List<String> values) {
            addCriterion("comefrom not in", values, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromBetween(String value1, String value2) {
            addCriterion("comefrom between", value1, value2, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromNotBetween(String value1, String value2) {
            addCriterion("comefrom not between", value1, value2, "comefrom");
            return (Criteria) this;
        }

        public Criteria andTozootimeIsNull() {
            addCriterion("tozootime is null");
            return (Criteria) this;
        }

        public Criteria andTozootimeIsNotNull() {
            addCriterion("tozootime is not null");
            return (Criteria) this;
        }

        public Criteria andTozootimeEqualTo(Date value) {
            addCriterionForJDBCDate("tozootime =", value, "tozootime");
            return (Criteria) this;
        }

        public Criteria andTozootimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("tozootime <>", value, "tozootime");
            return (Criteria) this;
        }

        public Criteria andTozootimeGreaterThan(Date value) {
            addCriterionForJDBCDate("tozootime >", value, "tozootime");
            return (Criteria) this;
        }

        public Criteria andTozootimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tozootime >=", value, "tozootime");
            return (Criteria) this;
        }

        public Criteria andTozootimeLessThan(Date value) {
            addCriterionForJDBCDate("tozootime <", value, "tozootime");
            return (Criteria) this;
        }

        public Criteria andTozootimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tozootime <=", value, "tozootime");
            return (Criteria) this;
        }

        public Criteria andTozootimeIn(List<Date> values) {
            addCriterionForJDBCDate("tozootime in", values, "tozootime");
            return (Criteria) this;
        }

        public Criteria andTozootimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("tozootime not in", values, "tozootime");
            return (Criteria) this;
        }

        public Criteria andTozootimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tozootime between", value1, value2, "tozootime");
            return (Criteria) this;
        }

        public Criteria andTozootimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tozootime not between", value1, value2, "tozootime");
            return (Criteria) this;
        }

        public Criteria andCatdescribeIsNull() {
            addCriterion("catdescribe is null");
            return (Criteria) this;
        }

        public Criteria andCatdescribeIsNotNull() {
            addCriterion("catdescribe is not null");
            return (Criteria) this;
        }

        public Criteria andCatdescribeEqualTo(String value) {
            addCriterion("catdescribe =", value, "catdescribe");
            return (Criteria) this;
        }

        public Criteria andCatdescribeNotEqualTo(String value) {
            addCriterion("catdescribe <>", value, "catdescribe");
            return (Criteria) this;
        }

        public Criteria andCatdescribeGreaterThan(String value) {
            addCriterion("catdescribe >", value, "catdescribe");
            return (Criteria) this;
        }

        public Criteria andCatdescribeGreaterThanOrEqualTo(String value) {
            addCriterion("catdescribe >=", value, "catdescribe");
            return (Criteria) this;
        }

        public Criteria andCatdescribeLessThan(String value) {
            addCriterion("catdescribe <", value, "catdescribe");
            return (Criteria) this;
        }

        public Criteria andCatdescribeLessThanOrEqualTo(String value) {
            addCriterion("catdescribe <=", value, "catdescribe");
            return (Criteria) this;
        }

        public Criteria andCatdescribeLike(String value) {
            addCriterion("catdescribe like", value, "catdescribe");
            return (Criteria) this;
        }

        public Criteria andCatdescribeNotLike(String value) {
            addCriterion("catdescribe not like", value, "catdescribe");
            return (Criteria) this;
        }

        public Criteria andCatdescribeIn(List<String> values) {
            addCriterion("catdescribe in", values, "catdescribe");
            return (Criteria) this;
        }

        public Criteria andCatdescribeNotIn(List<String> values) {
            addCriterion("catdescribe not in", values, "catdescribe");
            return (Criteria) this;
        }

        public Criteria andCatdescribeBetween(String value1, String value2) {
            addCriterion("catdescribe between", value1, value2, "catdescribe");
            return (Criteria) this;
        }

        public Criteria andCatdescribeNotBetween(String value1, String value2) {
            addCriterion("catdescribe not between", value1, value2, "catdescribe");
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