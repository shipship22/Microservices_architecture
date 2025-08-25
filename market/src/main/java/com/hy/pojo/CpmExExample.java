package com.hy.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CpmExExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CpmExExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCpmIsNull() {
            addCriterion("cpm is null");
            return (Criteria) this;
        }

        public Criteria andCpmIsNotNull() {
            addCriterion("cpm is not null");
            return (Criteria) this;
        }

        public Criteria andCpmEqualTo(BigDecimal value) {
            addCriterion("cpm =", value, "cpm");
            return (Criteria) this;
        }

        public Criteria andCpmNotEqualTo(BigDecimal value) {
            addCriterion("cpm <>", value, "cpm");
            return (Criteria) this;
        }

        public Criteria andCpmGreaterThan(BigDecimal value) {
            addCriterion("cpm >", value, "cpm");
            return (Criteria) this;
        }

        public Criteria andCpmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cpm >=", value, "cpm");
            return (Criteria) this;
        }

        public Criteria andCpmLessThan(BigDecimal value) {
            addCriterion("cpm <", value, "cpm");
            return (Criteria) this;
        }

        public Criteria andCpmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cpm <=", value, "cpm");
            return (Criteria) this;
        }

        public Criteria andCpmIn(List<BigDecimal> values) {
            addCriterion("cpm in", values, "cpm");
            return (Criteria) this;
        }

        public Criteria andCpmNotIn(List<BigDecimal> values) {
            addCriterion("cpm not in", values, "cpm");
            return (Criteria) this;
        }

        public Criteria andCpmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cpm between", value1, value2, "cpm");
            return (Criteria) this;
        }

        public Criteria andCpmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cpm not between", value1, value2, "cpm");
            return (Criteria) this;
        }

        public Criteria andCpmDateIsNull() {
            addCriterion("cpm_date is null");
            return (Criteria) this;
        }

        public Criteria andCpmDateIsNotNull() {
            addCriterion("cpm_date is not null");
            return (Criteria) this;
        }

        public Criteria andCpmDateEqualTo(Date value) {
            addCriterion("cpm_date =", value, "cpmDate");
            return (Criteria) this;
        }

        public Criteria andCpmDateNotEqualTo(Date value) {
            addCriterion("cpm_date <>", value, "cpmDate");
            return (Criteria) this;
        }

        public Criteria andCpmDateGreaterThan(Date value) {
            addCriterion("cpm_date >", value, "cpmDate");
            return (Criteria) this;
        }

        public Criteria andCpmDateGreaterThanOrEqualTo(Date value) {
            addCriterion("cpm_date >=", value, "cpmDate");
            return (Criteria) this;
        }

        public Criteria andCpmDateLessThan(Date value) {
            addCriterion("cpm_date <", value, "cpmDate");
            return (Criteria) this;
        }

        public Criteria andCpmDateLessThanOrEqualTo(Date value) {
            addCriterion("cpm_date <=", value, "cpmDate");
            return (Criteria) this;
        }

        public Criteria andCpmDateIn(List<Date> values) {
            addCriterion("cpm_date in", values, "cpmDate");
            return (Criteria) this;
        }

        public Criteria andCpmDateNotIn(List<Date> values) {
            addCriterion("cpm_date not in", values, "cpmDate");
            return (Criteria) this;
        }

        public Criteria andCpmDateBetween(Date value1, Date value2) {
            addCriterion("cpm_date between", value1, value2, "cpmDate");
            return (Criteria) this;
        }

        public Criteria andCpmDateNotBetween(Date value1, Date value2) {
            addCriterion("cpm_date not between", value1, value2, "cpmDate");
            return (Criteria) this;
        }

        public Criteria andStautsIsNull() {
            addCriterion("stauts is null");
            return (Criteria) this;
        }

        public Criteria andStautsIsNotNull() {
            addCriterion("stauts is not null");
            return (Criteria) this;
        }

        public Criteria andStautsEqualTo(String value) {
            addCriterion("stauts =", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsNotEqualTo(String value) {
            addCriterion("stauts <>", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsGreaterThan(String value) {
            addCriterion("stauts >", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsGreaterThanOrEqualTo(String value) {
            addCriterion("stauts >=", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsLessThan(String value) {
            addCriterion("stauts <", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsLessThanOrEqualTo(String value) {
            addCriterion("stauts <=", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsLike(String value) {
            addCriterion("stauts like", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsNotLike(String value) {
            addCriterion("stauts not like", value, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsIn(List<String> values) {
            addCriterion("stauts in", values, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsNotIn(List<String> values) {
            addCriterion("stauts not in", values, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsBetween(String value1, String value2) {
            addCriterion("stauts between", value1, value2, "stauts");
            return (Criteria) this;
        }

        public Criteria andStautsNotBetween(String value1, String value2) {
            addCriterion("stauts not between", value1, value2, "stauts");
            return (Criteria) this;
        }

        public Criteria andCpmDiffIsNull() {
            addCriterion("cpm_diff is null");
            return (Criteria) this;
        }

        public Criteria andCpmDiffIsNotNull() {
            addCriterion("cpm_diff is not null");
            return (Criteria) this;
        }

        public Criteria andCpmDiffEqualTo(Long value) {
            addCriterion("cpm_diff =", value, "cpmDiff");
            return (Criteria) this;
        }

        public Criteria andCpmDiffNotEqualTo(Long value) {
            addCriterion("cpm_diff <>", value, "cpmDiff");
            return (Criteria) this;
        }

        public Criteria andCpmDiffGreaterThan(Long value) {
            addCriterion("cpm_diff >", value, "cpmDiff");
            return (Criteria) this;
        }

        public Criteria andCpmDiffGreaterThanOrEqualTo(Long value) {
            addCriterion("cpm_diff >=", value, "cpmDiff");
            return (Criteria) this;
        }

        public Criteria andCpmDiffLessThan(Long value) {
            addCriterion("cpm_diff <", value, "cpmDiff");
            return (Criteria) this;
        }

        public Criteria andCpmDiffLessThanOrEqualTo(Long value) {
            addCriterion("cpm_diff <=", value, "cpmDiff");
            return (Criteria) this;
        }

        public Criteria andCpmDiffIn(List<Long> values) {
            addCriterion("cpm_diff in", values, "cpmDiff");
            return (Criteria) this;
        }

        public Criteria andCpmDiffNotIn(List<Long> values) {
            addCriterion("cpm_diff not in", values, "cpmDiff");
            return (Criteria) this;
        }

        public Criteria andCpmDiffBetween(Long value1, Long value2) {
            addCriterion("cpm_diff between", value1, value2, "cpmDiff");
            return (Criteria) this;
        }

        public Criteria andCpmDiffNotBetween(Long value1, Long value2) {
            addCriterion("cpm_diff not between", value1, value2, "cpmDiff");
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