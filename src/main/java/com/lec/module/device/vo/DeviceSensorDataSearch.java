package com.lec.module.device.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceSensorDataSearch {
	protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;

	public DeviceSensorDataSearch() {
		this.oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return this.orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return this.distinct;
	}

	public List<Criteria> getOredCriteria() {
		return this.oredCriteria;
	}

	public void or(Criteria criteria) {
		this.oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		this.oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (this.oredCriteria.size() == 0) {
			this.oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		this.oredCriteria.clear();
		this.orderByClause = null;
		this.distinct = false;
	}

	public static class Criteria extends DeviceSensorDataSearch.GeneratedCriteria {
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
			return this.condition;
		}

		public Object getValue() {
			return this.value;
		}

		public Object getSecondValue() {
			return this.secondValue;
		}

		public boolean isNoValue() {
			return this.noValue;
		}

		public boolean isSingleValue() {
			return this.singleValue;
		}

		public boolean isBetweenValue() {
			return this.betweenValue;
		}

		public boolean isListValue() {
			return this.listValue;
		}

		public String getTypeHandler() {
			return this.typeHandler;
		}

		protected Criterion(String condition) {
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if ((value instanceof List))
				this.listValue = true;
			else
				this.singleValue = true;
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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

	protected static abstract class GeneratedCriteria {
		protected List<DeviceSensorDataSearch.Criterion> criteria;

		protected GeneratedCriteria() {
			this.criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return this.criteria.size() > 0;
		}

		public List<DeviceSensorDataSearch.Criterion> getAllCriteria() {
			return this.criteria;
		}

		public List<DeviceSensorDataSearch.Criterion> getCriteria() {
			return this.criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			this.criteria.add(new DeviceSensorDataSearch.Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			this.criteria.add(new DeviceSensorDataSearch.Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if ((value1 == null) || (value2 == null)) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			this.criteria.add(new DeviceSensorDataSearch.Criterion(condition, value1, value2));
		}

		public DeviceSensorDataSearch.Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdEqualTo(String value) {
			addCriterion("ID =", value, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdNotEqualTo(String value) {
			addCriterion("ID <>", value, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdGreaterThan(String value) {
			addCriterion("ID >", value, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("ID >=", value, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdLessThan(String value) {
			addCriterion("ID <", value, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("ID <=", value, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdLike(String value) {
			addCriterion("ID like", value, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdNotLike(String value) {
			addCriterion("ID not like", value, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdIn(List<String> values) {
			addCriterion("ID in", values, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdNotIn(List<String> values) {
			addCriterion("ID not in", values, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdBetween(String value1, String value2) {
			addCriterion("ID between", value1, value2, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeIsNull() {
			addCriterion("DEVICE_CODE is null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeIsNotNull() {
			addCriterion("DEVICE_CODE is not null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeEqualTo(String value) {
			addCriterion("DEVICE_CODE =", value, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeNotEqualTo(String value) {
			addCriterion("DEVICE_CODE <>", value, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeGreaterThan(String value) {
			addCriterion("DEVICE_CODE >", value, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeGreaterThanOrEqualTo(String value) {
			addCriterion("DEVICE_CODE >=", value, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeLessThan(String value) {
			addCriterion("DEVICE_CODE <", value, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeLessThanOrEqualTo(String value) {
			addCriterion("DEVICE_CODE <=", value, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeLike(String value) {
			addCriterion("DEVICE_CODE like", value, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeNotLike(String value) {
			addCriterion("DEVICE_CODE not like", value, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeIn(List<String> values) {
			addCriterion("DEVICE_CODE in", values, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeNotIn(List<String> values) {
			addCriterion("DEVICE_CODE not in", values, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeBetween(String value1, String value2) {
			addCriterion("DEVICE_CODE between", value1, value2, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDeviceCodeNotBetween(String value1, String value2) {
			addCriterion("DEVICE_CODE not between", value1, value2, "deviceCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeIsNull() {
			addCriterion("DATA_TIME is null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeIsNotNull() {
			addCriterion("DATA_TIME is not null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeEqualTo(Date value) {
			addCriterion("DATA_TIME =", value, "dataTime");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeNotEqualTo(Date value) {
			addCriterion("DATA_TIME <>", value, "dataTime");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeGreaterThan(Date value) {
			addCriterion("DATA_TIME >", value, "dataTime");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("DATA_TIME >=", value, "dataTime");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeLessThan(Date value) {
			addCriterion("DATA_TIME <", value, "dataTime");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeLessThanOrEqualTo(Date value) {
			addCriterion("DATA_TIME <=", value, "dataTime");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeIn(List<Date> values) {
			addCriterion("DATA_TIME in", values, "dataTime");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeNotIn(List<Date> values) {
			addCriterion("DATA_TIME not in", values, "dataTime");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeBetween(Date value1, Date value2) {
			addCriterion("DATA_TIME between", value1, value2, "dataTime");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataTimeNotBetween(Date value1, Date value2) {
			addCriterion("DATA_TIME not between", value1, value2, "dataTime");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataIsNull() {
			addCriterion("DATA is null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataIsNotNull() {
			addCriterion("DATA is not null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataEqualTo(String value) {
			addCriterion("DATA =", value, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataNotEqualTo(String value) {
			addCriterion("DATA <>", value, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataGreaterThan(String value) {
			addCriterion("DATA >", value, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataGreaterThanOrEqualTo(String value) {
			addCriterion("DATA >=", value, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataLessThan(String value) {
			addCriterion("DATA <", value, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataLessThanOrEqualTo(String value) {
			addCriterion("DATA <=", value, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataLike(String value) {
			addCriterion("DATA like", value, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataNotLike(String value) {
			addCriterion("DATA not like", value, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataIn(List<String> values) {
			addCriterion("DATA in", values, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataNotIn(List<String> values) {
			addCriterion("DATA not in", values, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataBetween(String value1, String value2) {
			addCriterion("DATA between", value1, value2, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andDataNotBetween(String value1, String value2) {
			addCriterion("DATA not between", value1, value2, "data");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeIsNull() {
			addCriterion("SENSOR_CODE is null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeIsNotNull() {
			addCriterion("SENSOR_CODE is not null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeEqualTo(String value) {
			addCriterion("SENSOR_CODE =", value, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeNotEqualTo(String value) {
			addCriterion("SENSOR_CODE <>", value, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeGreaterThan(String value) {
			addCriterion("SENSOR_CODE >", value, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeGreaterThanOrEqualTo(String value) {
			addCriterion("SENSOR_CODE >=", value, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeLessThan(String value) {
			addCriterion("SENSOR_CODE <", value, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeLessThanOrEqualTo(String value) {
			addCriterion("SENSOR_CODE <=", value, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeLike(String value) {
			addCriterion("SENSOR_CODE like", value, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeNotLike(String value) {
			addCriterion("SENSOR_CODE not like", value, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeIn(List<String> values) {
			addCriterion("SENSOR_CODE in", values, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeNotIn(List<String> values) {
			addCriterion("SENSOR_CODE not in", values, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeBetween(String value1, String value2) {
			addCriterion("SENSOR_CODE between", value1, value2, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSensorCodeNotBetween(String value1, String value2) {
			addCriterion("SENSOR_CODE not between", value1, value2, "sensorCode");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeIsNull() {
			addCriterion("SEND_TYPE is null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeIsNotNull() {
			addCriterion("SEND_TYPE is not null");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeEqualTo(String value) {
			addCriterion("SEND_TYPE =", value, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeNotEqualTo(String value) {
			addCriterion("SEND_TYPE <>", value, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeGreaterThan(String value) {
			addCriterion("SEND_TYPE >", value, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeGreaterThanOrEqualTo(String value) {
			addCriterion("SEND_TYPE >=", value, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeLessThan(String value) {
			addCriterion("SEND_TYPE <", value, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeLessThanOrEqualTo(String value) {
			addCriterion("SEND_TYPE <=", value, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeLike(String value) {
			addCriterion("SEND_TYPE like", value, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeNotLike(String value) {
			addCriterion("SEND_TYPE not like", value, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeIn(List<String> values) {
			addCriterion("SEND_TYPE in", values, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeNotIn(List<String> values) {
			addCriterion("SEND_TYPE not in", values, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeBetween(String value1, String value2) {
			addCriterion("SEND_TYPE between", value1, value2, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}

		public DeviceSensorDataSearch.Criteria andSendTypeNotBetween(String value1, String value2) {
			addCriterion("SEND_TYPE not between", value1, value2, "sendType");
			return (DeviceSensorDataSearch.Criteria) this;
		}
	}
}