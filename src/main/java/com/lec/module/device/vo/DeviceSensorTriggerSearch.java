package com.lec.module.device.vo;

import java.util.ArrayList;
import java.util.List;

public class DeviceSensorTriggerSearch {
    /**
    
     */
    protected String orderByClause;

    /**
    
     */
    protected boolean distinct;

    /**
    
     */
    protected List<Criteria> oredCriteria;

    /**
    
     */
    public DeviceSensorTriggerSearch() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
    
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
    
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
    
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
    
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
    
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
    
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
    
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
    
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
    
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
    
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
    
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSensorIdIsNull() {
            addCriterion("SENSOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andSensorIdIsNotNull() {
            addCriterion("SENSOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSensorIdEqualTo(String value) {
            addCriterion("SENSOR_ID =", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotEqualTo(String value) {
            addCriterion("SENSOR_ID <>", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThan(String value) {
            addCriterion("SENSOR_ID >", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdGreaterThanOrEqualTo(String value) {
            addCriterion("SENSOR_ID >=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThan(String value) {
            addCriterion("SENSOR_ID <", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLessThanOrEqualTo(String value) {
            addCriterion("SENSOR_ID <=", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdLike(String value) {
            addCriterion("SENSOR_ID like", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotLike(String value) {
            addCriterion("SENSOR_ID not like", value, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdIn(List<String> values) {
            addCriterion("SENSOR_ID in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotIn(List<String> values) {
            addCriterion("SENSOR_ID not in", values, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdBetween(String value1, String value2) {
            addCriterion("SENSOR_ID between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andSensorIdNotBetween(String value1, String value2) {
            addCriterion("SENSOR_ID not between", value1, value2, "sensorId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1IsNull() {
            addCriterion("TRIGGER_VAL1 is null");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1IsNotNull() {
            addCriterion("TRIGGER_VAL1 is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1EqualTo(String value) {
            addCriterion("TRIGGER_VAL1 =", value, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1NotEqualTo(String value) {
            addCriterion("TRIGGER_VAL1 <>", value, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1GreaterThan(String value) {
            addCriterion("TRIGGER_VAL1 >", value, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1GreaterThanOrEqualTo(String value) {
            addCriterion("TRIGGER_VAL1 >=", value, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1LessThan(String value) {
            addCriterion("TRIGGER_VAL1 <", value, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1LessThanOrEqualTo(String value) {
            addCriterion("TRIGGER_VAL1 <=", value, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1Like(String value) {
            addCriterion("TRIGGER_VAL1 like", value, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1NotLike(String value) {
            addCriterion("TRIGGER_VAL1 not like", value, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1In(List<String> values) {
            addCriterion("TRIGGER_VAL1 in", values, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1NotIn(List<String> values) {
            addCriterion("TRIGGER_VAL1 not in", values, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1Between(String value1, String value2) {
            addCriterion("TRIGGER_VAL1 between", value1, value2, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal1NotBetween(String value1, String value2) {
            addCriterion("TRIGGER_VAL1 not between", value1, value2, "triggerVal1");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2IsNull() {
            addCriterion("TRIGGER_VAL2 is null");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2IsNotNull() {
            addCriterion("TRIGGER_VAL2 is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2EqualTo(String value) {
            addCriterion("TRIGGER_VAL2 =", value, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2NotEqualTo(String value) {
            addCriterion("TRIGGER_VAL2 <>", value, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2GreaterThan(String value) {
            addCriterion("TRIGGER_VAL2 >", value, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2GreaterThanOrEqualTo(String value) {
            addCriterion("TRIGGER_VAL2 >=", value, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2LessThan(String value) {
            addCriterion("TRIGGER_VAL2 <", value, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2LessThanOrEqualTo(String value) {
            addCriterion("TRIGGER_VAL2 <=", value, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2Like(String value) {
            addCriterion("TRIGGER_VAL2 like", value, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2NotLike(String value) {
            addCriterion("TRIGGER_VAL2 not like", value, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2In(List<String> values) {
            addCriterion("TRIGGER_VAL2 in", values, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2NotIn(List<String> values) {
            addCriterion("TRIGGER_VAL2 not in", values, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2Between(String value1, String value2) {
            addCriterion("TRIGGER_VAL2 between", value1, value2, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andTriggerVal2NotBetween(String value1, String value2) {
            addCriterion("TRIGGER_VAL2 not between", value1, value2, "triggerVal2");
            return (Criteria) this;
        }

        public Criteria andIsForwardIsNull() {
            addCriterion("IS_FORWARD is null");
            return (Criteria) this;
        }

        public Criteria andIsForwardIsNotNull() {
            addCriterion("IS_FORWARD is not null");
            return (Criteria) this;
        }

        public Criteria andIsForwardEqualTo(String value) {
            addCriterion("IS_FORWARD =", value, "isForward");
            return (Criteria) this;
        }

        public Criteria andIsForwardNotEqualTo(String value) {
            addCriterion("IS_FORWARD <>", value, "isForward");
            return (Criteria) this;
        }

        public Criteria andIsForwardGreaterThan(String value) {
            addCriterion("IS_FORWARD >", value, "isForward");
            return (Criteria) this;
        }

        public Criteria andIsForwardGreaterThanOrEqualTo(String value) {
            addCriterion("IS_FORWARD >=", value, "isForward");
            return (Criteria) this;
        }

        public Criteria andIsForwardLessThan(String value) {
            addCriterion("IS_FORWARD <", value, "isForward");
            return (Criteria) this;
        }

        public Criteria andIsForwardLessThanOrEqualTo(String value) {
            addCriterion("IS_FORWARD <=", value, "isForward");
            return (Criteria) this;
        }

        public Criteria andIsForwardLike(String value) {
            addCriterion("IS_FORWARD like", value, "isForward");
            return (Criteria) this;
        }

        public Criteria andIsForwardNotLike(String value) {
            addCriterion("IS_FORWARD not like", value, "isForward");
            return (Criteria) this;
        }

        public Criteria andIsForwardIn(List<String> values) {
            addCriterion("IS_FORWARD in", values, "isForward");
            return (Criteria) this;
        }

        public Criteria andIsForwardNotIn(List<String> values) {
            addCriterion("IS_FORWARD not in", values, "isForward");
            return (Criteria) this;
        }

        public Criteria andIsForwardBetween(String value1, String value2) {
            addCriterion("IS_FORWARD between", value1, value2, "isForward");
            return (Criteria) this;
        }

        public Criteria andIsForwardNotBetween(String value1, String value2) {
            addCriterion("IS_FORWARD not between", value1, value2, "isForward");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdIsNull() {
            addCriterion("FORWARD_SENSOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdIsNotNull() {
            addCriterion("FORWARD_SENSOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdEqualTo(String value) {
            addCriterion("FORWARD_SENSOR_ID =", value, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdNotEqualTo(String value) {
            addCriterion("FORWARD_SENSOR_ID <>", value, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdGreaterThan(String value) {
            addCriterion("FORWARD_SENSOR_ID >", value, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdGreaterThanOrEqualTo(String value) {
            addCriterion("FORWARD_SENSOR_ID >=", value, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdLessThan(String value) {
            addCriterion("FORWARD_SENSOR_ID <", value, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdLessThanOrEqualTo(String value) {
            addCriterion("FORWARD_SENSOR_ID <=", value, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdLike(String value) {
            addCriterion("FORWARD_SENSOR_ID like", value, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdNotLike(String value) {
            addCriterion("FORWARD_SENSOR_ID not like", value, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdIn(List<String> values) {
            addCriterion("FORWARD_SENSOR_ID in", values, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdNotIn(List<String> values) {
            addCriterion("FORWARD_SENSOR_ID not in", values, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdBetween(String value1, String value2) {
            addCriterion("FORWARD_SENSOR_ID between", value1, value2, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andForwardSensorIdNotBetween(String value1, String value2) {
            addCriterion("FORWARD_SENSOR_ID not between", value1, value2, "forwardSensorId");
            return (Criteria) this;
        }

        public Criteria andDataFormatIsNull() {
            addCriterion("DATA_FORMAT is null");
            return (Criteria) this;
        }

        public Criteria andDataFormatIsNotNull() {
            addCriterion("DATA_FORMAT is not null");
            return (Criteria) this;
        }

        public Criteria andDataFormatEqualTo(String value) {
            addCriterion("DATA_FORMAT =", value, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andDataFormatNotEqualTo(String value) {
            addCriterion("DATA_FORMAT <>", value, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andDataFormatGreaterThan(String value) {
            addCriterion("DATA_FORMAT >", value, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andDataFormatGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_FORMAT >=", value, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andDataFormatLessThan(String value) {
            addCriterion("DATA_FORMAT <", value, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andDataFormatLessThanOrEqualTo(String value) {
            addCriterion("DATA_FORMAT <=", value, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andDataFormatLike(String value) {
            addCriterion("DATA_FORMAT like", value, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andDataFormatNotLike(String value) {
            addCriterion("DATA_FORMAT not like", value, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andDataFormatIn(List<String> values) {
            addCriterion("DATA_FORMAT in", values, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andDataFormatNotIn(List<String> values) {
            addCriterion("DATA_FORMAT not in", values, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andDataFormatBetween(String value1, String value2) {
            addCriterion("DATA_FORMAT between", value1, value2, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andDataFormatNotBetween(String value1, String value2) {
            addCriterion("DATA_FORMAT not between", value1, value2, "dataFormat");
            return (Criteria) this;
        }

        public Criteria andForwardDataIsNull() {
            addCriterion("FORWARD_DATA is null");
            return (Criteria) this;
        }

        public Criteria andForwardDataIsNotNull() {
            addCriterion("FORWARD_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andForwardDataEqualTo(String value) {
            addCriterion("FORWARD_DATA =", value, "forwardData");
            return (Criteria) this;
        }

        public Criteria andForwardDataNotEqualTo(String value) {
            addCriterion("FORWARD_DATA <>", value, "forwardData");
            return (Criteria) this;
        }

        public Criteria andForwardDataGreaterThan(String value) {
            addCriterion("FORWARD_DATA >", value, "forwardData");
            return (Criteria) this;
        }

        public Criteria andForwardDataGreaterThanOrEqualTo(String value) {
            addCriterion("FORWARD_DATA >=", value, "forwardData");
            return (Criteria) this;
        }

        public Criteria andForwardDataLessThan(String value) {
            addCriterion("FORWARD_DATA <", value, "forwardData");
            return (Criteria) this;
        }

        public Criteria andForwardDataLessThanOrEqualTo(String value) {
            addCriterion("FORWARD_DATA <=", value, "forwardData");
            return (Criteria) this;
        }

        public Criteria andForwardDataLike(String value) {
            addCriterion("FORWARD_DATA like", value, "forwardData");
            return (Criteria) this;
        }

        public Criteria andForwardDataNotLike(String value) {
            addCriterion("FORWARD_DATA not like", value, "forwardData");
            return (Criteria) this;
        }

        public Criteria andForwardDataIn(List<String> values) {
            addCriterion("FORWARD_DATA in", values, "forwardData");
            return (Criteria) this;
        }

        public Criteria andForwardDataNotIn(List<String> values) {
            addCriterion("FORWARD_DATA not in", values, "forwardData");
            return (Criteria) this;
        }

        public Criteria andForwardDataBetween(String value1, String value2) {
            addCriterion("FORWARD_DATA between", value1, value2, "forwardData");
            return (Criteria) this;
        }

        public Criteria andForwardDataNotBetween(String value1, String value2) {
            addCriterion("FORWARD_DATA not between", value1, value2, "forwardData");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

    }

    /**
    T_DEVICE_SENSOR_TRIGGER
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
    
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