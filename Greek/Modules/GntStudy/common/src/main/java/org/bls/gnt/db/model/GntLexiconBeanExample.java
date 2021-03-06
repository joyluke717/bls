package org.bls.gnt.db.model;

import java.util.ArrayList;
import java.util.List;

public class GntLexiconBeanExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public GntLexiconBeanExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
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

        public Criteria andWordIsNull() {
            addCriterion("word is null");
            return (Criteria) this;
        }

        public Criteria andWordIsNotNull() {
            addCriterion("word is not null");
            return (Criteria) this;
        }

        public Criteria andWordEqualTo(String value) {
            addCriterion("word =", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotEqualTo(String value) {
            addCriterion("word <>", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordGreaterThan(String value) {
            addCriterion("word >", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordGreaterThanOrEqualTo(String value) {
            addCriterion("word >=", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLessThan(String value) {
            addCriterion("word <", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLessThanOrEqualTo(String value) {
            addCriterion("word <=", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLike(String value) {
            addCriterion("word like", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotLike(String value) {
            addCriterion("word not like", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordIn(List<String> values) {
            addCriterion("word in", values, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotIn(List<String> values) {
            addCriterion("word not in", values, "word");
            return (Criteria) this;
        }

        public Criteria andWordBetween(String value1, String value2) {
            addCriterion("word between", value1, value2, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotBetween(String value1, String value2) {
            addCriterion("word not between", value1, value2, "word");
            return (Criteria) this;
        }

        public Criteria andFullWordIsNull() {
            addCriterion("full_word is null");
            return (Criteria) this;
        }

        public Criteria andFullWordIsNotNull() {
            addCriterion("full_word is not null");
            return (Criteria) this;
        }

        public Criteria andFullWordEqualTo(String value) {
            addCriterion("full_word =", value, "fullWord");
            return (Criteria) this;
        }

        public Criteria andFullWordNotEqualTo(String value) {
            addCriterion("full_word <>", value, "fullWord");
            return (Criteria) this;
        }

        public Criteria andFullWordGreaterThan(String value) {
            addCriterion("full_word >", value, "fullWord");
            return (Criteria) this;
        }

        public Criteria andFullWordGreaterThanOrEqualTo(String value) {
            addCriterion("full_word >=", value, "fullWord");
            return (Criteria) this;
        }

        public Criteria andFullWordLessThan(String value) {
            addCriterion("full_word <", value, "fullWord");
            return (Criteria) this;
        }

        public Criteria andFullWordLessThanOrEqualTo(String value) {
            addCriterion("full_word <=", value, "fullWord");
            return (Criteria) this;
        }

        public Criteria andFullWordLike(String value) {
            addCriterion("full_word like", value, "fullWord");
            return (Criteria) this;
        }

        public Criteria andFullWordNotLike(String value) {
            addCriterion("full_word not like", value, "fullWord");
            return (Criteria) this;
        }

        public Criteria andFullWordIn(List<String> values) {
            addCriterion("full_word in", values, "fullWord");
            return (Criteria) this;
        }

        public Criteria andFullWordNotIn(List<String> values) {
            addCriterion("full_word not in", values, "fullWord");
            return (Criteria) this;
        }

        public Criteria andFullWordBetween(String value1, String value2) {
            addCriterion("full_word between", value1, value2, "fullWord");
            return (Criteria) this;
        }

        public Criteria andFullWordNotBetween(String value1, String value2) {
            addCriterion("full_word not between", value1, value2, "fullWord");
            return (Criteria) this;
        }

        public Criteria andMeaningIsNull() {
            addCriterion("meaning is null");
            return (Criteria) this;
        }

        public Criteria andMeaningIsNotNull() {
            addCriterion("meaning is not null");
            return (Criteria) this;
        }

        public Criteria andMeaningEqualTo(String value) {
            addCriterion("meaning =", value, "meaning");
            return (Criteria) this;
        }

        public Criteria andMeaningNotEqualTo(String value) {
            addCriterion("meaning <>", value, "meaning");
            return (Criteria) this;
        }

        public Criteria andMeaningGreaterThan(String value) {
            addCriterion("meaning >", value, "meaning");
            return (Criteria) this;
        }

        public Criteria andMeaningGreaterThanOrEqualTo(String value) {
            addCriterion("meaning >=", value, "meaning");
            return (Criteria) this;
        }

        public Criteria andMeaningLessThan(String value) {
            addCriterion("meaning <", value, "meaning");
            return (Criteria) this;
        }

        public Criteria andMeaningLessThanOrEqualTo(String value) {
            addCriterion("meaning <=", value, "meaning");
            return (Criteria) this;
        }

        public Criteria andMeaningLike(String value) {
            addCriterion("meaning like", value, "meaning");
            return (Criteria) this;
        }

        public Criteria andMeaningNotLike(String value) {
            addCriterion("meaning not like", value, "meaning");
            return (Criteria) this;
        }

        public Criteria andMeaningIn(List<String> values) {
            addCriterion("meaning in", values, "meaning");
            return (Criteria) this;
        }

        public Criteria andMeaningNotIn(List<String> values) {
            addCriterion("meaning not in", values, "meaning");
            return (Criteria) this;
        }

        public Criteria andMeaningBetween(String value1, String value2) {
            addCriterion("meaning between", value1, value2, "meaning");
            return (Criteria) this;
        }

        public Criteria andMeaningNotBetween(String value1, String value2) {
            addCriterion("meaning not between", value1, value2, "meaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningIsNull() {
            addCriterion("full_meaning is null");
            return (Criteria) this;
        }

        public Criteria andFullMeaningIsNotNull() {
            addCriterion("full_meaning is not null");
            return (Criteria) this;
        }

        public Criteria andFullMeaningEqualTo(String value) {
            addCriterion("full_meaning =", value, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningNotEqualTo(String value) {
            addCriterion("full_meaning <>", value, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningGreaterThan(String value) {
            addCriterion("full_meaning >", value, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningGreaterThanOrEqualTo(String value) {
            addCriterion("full_meaning >=", value, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningLessThan(String value) {
            addCriterion("full_meaning <", value, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningLessThanOrEqualTo(String value) {
            addCriterion("full_meaning <=", value, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningLike(String value) {
            addCriterion("full_meaning like", value, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningNotLike(String value) {
            addCriterion("full_meaning not like", value, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningIn(List<String> values) {
            addCriterion("full_meaning in", values, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningNotIn(List<String> values) {
            addCriterion("full_meaning not in", values, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningBetween(String value1, String value2) {
            addCriterion("full_meaning between", value1, value2, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andFullMeaningNotBetween(String value1, String value2) {
            addCriterion("full_meaning not between", value1, value2, "fullMeaning");
            return (Criteria) this;
        }

        public Criteria andWordTypeIsNull() {
            addCriterion("word_type is null");
            return (Criteria) this;
        }

        public Criteria andWordTypeIsNotNull() {
            addCriterion("word_type is not null");
            return (Criteria) this;
        }

        public Criteria andWordTypeEqualTo(String value) {
            addCriterion("word_type =", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeNotEqualTo(String value) {
            addCriterion("word_type <>", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeGreaterThan(String value) {
            addCriterion("word_type >", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeGreaterThanOrEqualTo(String value) {
            addCriterion("word_type >=", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeLessThan(String value) {
            addCriterion("word_type <", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeLessThanOrEqualTo(String value) {
            addCriterion("word_type <=", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeLike(String value) {
            addCriterion("word_type like", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeNotLike(String value) {
            addCriterion("word_type not like", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeIn(List<String> values) {
            addCriterion("word_type in", values, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeNotIn(List<String> values) {
            addCriterion("word_type not in", values, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeBetween(String value1, String value2) {
            addCriterion("word_type between", value1, value2, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeNotBetween(String value1, String value2) {
            addCriterion("word_type not between", value1, value2, "wordType");
            return (Criteria) this;
        }

        public Criteria andStrongNumberIsNull() {
            addCriterion("strong_number is null");
            return (Criteria) this;
        }

        public Criteria andStrongNumberIsNotNull() {
            addCriterion("strong_number is not null");
            return (Criteria) this;
        }

        public Criteria andStrongNumberEqualTo(Integer value) {
            addCriterion("strong_number =", value, "strongNumber");
            return (Criteria) this;
        }

        public Criteria andStrongNumberNotEqualTo(Integer value) {
            addCriterion("strong_number <>", value, "strongNumber");
            return (Criteria) this;
        }

        public Criteria andStrongNumberGreaterThan(Integer value) {
            addCriterion("strong_number >", value, "strongNumber");
            return (Criteria) this;
        }

        public Criteria andStrongNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("strong_number >=", value, "strongNumber");
            return (Criteria) this;
        }

        public Criteria andStrongNumberLessThan(Integer value) {
            addCriterion("strong_number <", value, "strongNumber");
            return (Criteria) this;
        }

        public Criteria andStrongNumberLessThanOrEqualTo(Integer value) {
            addCriterion("strong_number <=", value, "strongNumber");
            return (Criteria) this;
        }

        public Criteria andStrongNumberIn(List<Integer> values) {
            addCriterion("strong_number in", values, "strongNumber");
            return (Criteria) this;
        }

        public Criteria andStrongNumberNotIn(List<Integer> values) {
            addCriterion("strong_number not in", values, "strongNumber");
            return (Criteria) this;
        }

        public Criteria andStrongNumberBetween(Integer value1, Integer value2) {
            addCriterion("strong_number between", value1, value2, "strongNumber");
            return (Criteria) this;
        }

        public Criteria andStrongNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("strong_number not between", value1, value2, "strongNumber");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNull() {
            addCriterion("frequency is null");
            return (Criteria) this;
        }

        public Criteria andFrequencyIsNotNull() {
            addCriterion("frequency is not null");
            return (Criteria) this;
        }

        public Criteria andFrequencyEqualTo(Integer value) {
            addCriterion("frequency =", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotEqualTo(Integer value) {
            addCriterion("frequency <>", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThan(Integer value) {
            addCriterion("frequency >", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("frequency >=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThan(Integer value) {
            addCriterion("frequency <", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyLessThanOrEqualTo(Integer value) {
            addCriterion("frequency <=", value, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyIn(List<Integer> values) {
            addCriterion("frequency in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotIn(List<Integer> values) {
            addCriterion("frequency not in", values, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyBetween(Integer value1, Integer value2) {
            addCriterion("frequency between", value1, value2, "frequency");
            return (Criteria) this;
        }

        public Criteria andFrequencyNotBetween(Integer value1, Integer value2) {
            addCriterion("frequency not between", value1, value2, "frequency");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gnt_lexicon
     *
     * @mbg.generated do_not_delete_during_merge Fri Nov 02 19:59:08 CDT 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table gnt_lexicon
     *
     * @mbg.generated Fri Nov 02 19:59:08 CDT 2018
     */
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