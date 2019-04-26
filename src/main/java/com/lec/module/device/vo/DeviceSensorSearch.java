package com.lec.module.device.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DeviceSensorSearch {
	protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;

	public DeviceSensorSearch() {
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

	public static class Criteria extends DeviceSensorSearch.GeneratedCriteria {
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
		protected List<DeviceSensorSearch.Criterion> criteria;

		protected GeneratedCriteria() {
			this.criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return this.criteria.size() > 0;
		}

		public List<DeviceSensorSearch.Criterion> getAllCriteria() {
			return this.criteria;
		}

		public List<DeviceSensorSearch.Criterion> getCriteria() {
			return this.criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			this.criteria.add(new DeviceSensorSearch.Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			this.criteria.add(new DeviceSensorSearch.Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if ((value1 == null) || (value2 == null)) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			this.criteria.add(new DeviceSensorSearch.Criterion(condition, value1, value2));
		}

		public DeviceSensorSearch.Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdEqualTo(String value) {
			addCriterion("ID =", value, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdNotEqualTo(String value) {
			addCriterion("ID <>", value, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdGreaterThan(String value) {
			addCriterion("ID >", value, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("ID >=", value, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdLessThan(String value) {
			addCriterion("ID <", value, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("ID <=", value, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdLike(String value) {
			addCriterion("ID like", value, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdNotLike(String value) {
			addCriterion("ID not like", value, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdIn(List<String> values) {
			addCriterion("ID in", values, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdNotIn(List<String> values) {
			addCriterion("ID not in", values, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdBetween(String value1, String value2) {
			addCriterion("ID between", value1, value2, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdIsNull() {
			addCriterion("DEVICE_ID is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdIsNotNull() {
			addCriterion("DEVICE_ID is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdEqualTo(String value) {
			addCriterion("DEVICE_ID =", value, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdNotEqualTo(String value) {
			addCriterion("DEVICE_ID <>", value, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdGreaterThan(String value) {
			addCriterion("DEVICE_ID >", value, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdGreaterThanOrEqualTo(String value) {
			addCriterion("DEVICE_ID >=", value, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdLessThan(String value) {
			addCriterion("DEVICE_ID <", value, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdLessThanOrEqualTo(String value) {
			addCriterion("DEVICE_ID <=", value, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdLike(String value) {
			addCriterion("DEVICE_ID like", value, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdNotLike(String value) {
			addCriterion("DEVICE_ID not like", value, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdIn(List<String> values) {
			addCriterion("DEVICE_ID in", values, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdNotIn(List<String> values) {
			addCriterion("DEVICE_ID not in", values, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdBetween(String value1, String value2) {
			addCriterion("DEVICE_ID between", value1, value2, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDeviceIdNotBetween(String value1, String value2) {
			addCriterion("DEVICE_ID not between", value1, value2, "deviceId");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeIsNull() {
			addCriterion("CODE is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeIsNotNull() {
			addCriterion("CODE is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeEqualTo(String value) {
			addCriterion("CODE =", value, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeNotEqualTo(String value) {
			addCriterion("CODE <>", value, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeGreaterThan(String value) {
			addCriterion("CODE >", value, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeGreaterThanOrEqualTo(String value) {
			addCriterion("CODE >=", value, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeLessThan(String value) {
			addCriterion("CODE <", value, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeLessThanOrEqualTo(String value) {
			addCriterion("CODE <=", value, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeLike(String value) {
			addCriterion("CODE like", value, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeNotLike(String value) {
			addCriterion("CODE not like", value, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeIn(List<String> values) {
			addCriterion("CODE in", values, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeNotIn(List<String> values) {
			addCriterion("CODE not in", values, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeBetween(String value1, String value2) {
			addCriterion("CODE between", value1, value2, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andCodeNotBetween(String value1, String value2) {
			addCriterion("CODE not between", value1, value2, "code");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeIsNull() {
			addCriterion("TYPE is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeIsNotNull() {
			addCriterion("TYPE is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeEqualTo(String value) {
			addCriterion("TYPE =", value, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeNotEqualTo(String value) {
			addCriterion("TYPE <>", value, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeGreaterThan(String value) {
			addCriterion("TYPE >", value, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("TYPE >=", value, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeLessThan(String value) {
			addCriterion("TYPE <", value, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("TYPE <=", value, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeLike(String value) {
			addCriterion("TYPE like", value, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeNotLike(String value) {
			addCriterion("TYPE not like", value, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeIn(List<String> values) {
			addCriterion("TYPE in", values, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeNotIn(List<String> values) {
			addCriterion("TYPE not in", values, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeBetween(String value1, String value2) {
			addCriterion("TYPE between", value1, value2, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("TYPE not between", value1, value2, "type");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumIsNull() {
			addCriterion("DECIMAL_NUM is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumIsNotNull() {
			addCriterion("DECIMAL_NUM is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumEqualTo(String value) {
			addCriterion("DECIMAL_NUM =", value, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumNotEqualTo(String value) {
			addCriterion("DECIMAL_NUM <>", value, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumGreaterThan(String value) {
			addCriterion("DECIMAL_NUM >", value, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumGreaterThanOrEqualTo(String value) {
			addCriterion("DECIMAL_NUM >=", value, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumLessThan(String value) {
			addCriterion("DECIMAL_NUM <", value, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumLessThanOrEqualTo(String value) {
			addCriterion("DECIMAL_NUM <=", value, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumLike(String value) {
			addCriterion("DECIMAL_NUM like", value, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumNotLike(String value) {
			addCriterion("DECIMAL_NUM not like", value, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumIn(List<String> values) {
			addCriterion("DECIMAL_NUM in", values, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumNotIn(List<String> values) {
			addCriterion("DECIMAL_NUM not in", values, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumBetween(String value1, String value2) {
			addCriterion("DECIMAL_NUM between", value1, value2, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andDecimalNumNotBetween(String value1, String value2) {
			addCriterion("DECIMAL_NUM not between", value1, value2, "decimalNum");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitIsNull() {
			addCriterion("UNIT is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitIsNotNull() {
			addCriterion("UNIT is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitEqualTo(String value) {
			addCriterion("UNIT =", value, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitNotEqualTo(String value) {
			addCriterion("UNIT <>", value, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitGreaterThan(String value) {
			addCriterion("UNIT >", value, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitGreaterThanOrEqualTo(String value) {
			addCriterion("UNIT >=", value, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitLessThan(String value) {
			addCriterion("UNIT <", value, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitLessThanOrEqualTo(String value) {
			addCriterion("UNIT <=", value, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitLike(String value) {
			addCriterion("UNIT like", value, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitNotLike(String value) {
			addCriterion("UNIT not like", value, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitIn(List<String> values) {
			addCriterion("UNIT in", values, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitNotIn(List<String> values) {
			addCriterion("UNIT not in", values, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitBetween(String value1, String value2) {
			addCriterion("UNIT between", value1, value2, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andUnitNotBetween(String value1, String value2) {
			addCriterion("UNIT not between", value1, value2, "unit");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconIsNull() {
			addCriterion("ICON is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconIsNotNull() {
			addCriterion("ICON is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconEqualTo(String value) {
			addCriterion("ICON =", value, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconNotEqualTo(String value) {
			addCriterion("ICON <>", value, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconGreaterThan(String value) {
			addCriterion("ICON >", value, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconGreaterThanOrEqualTo(String value) {
			addCriterion("ICON >=", value, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconLessThan(String value) {
			addCriterion("ICON <", value, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconLessThanOrEqualTo(String value) {
			addCriterion("ICON <=", value, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconLike(String value) {
			addCriterion("ICON like", value, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconNotLike(String value) {
			addCriterion("ICON not like", value, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconIn(List<String> values) {
			addCriterion("ICON in", values, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconNotIn(List<String> values) {
			addCriterion("ICON not in", values, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconBetween(String value1, String value2) {
			addCriterion("ICON between", value1, value2, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andIconNotBetween(String value1, String value2) {
			addCriterion("ICON not between", value1, value2, "icon");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusIsNull() {
			addCriterion("STATUS is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusIsNotNull() {
			addCriterion("STATUS is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusEqualTo(String value) {
			addCriterion("STATUS =", value, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusNotEqualTo(String value) {
			addCriterion("STATUS <>", value, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusGreaterThan(String value) {
			addCriterion("STATUS >", value, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("STATUS >=", value, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusLessThan(String value) {
			addCriterion("STATUS <", value, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("STATUS <=", value, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusLike(String value) {
			addCriterion("STATUS like", value, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusNotLike(String value) {
			addCriterion("STATUS not like", value, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusIn(List<String> values) {
			addCriterion("STATUS in", values, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusNotIn(List<String> values) {
			addCriterion("STATUS not in", values, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusBetween(String value1, String value2) {
			addCriterion("STATUS between", value1, value2, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("STATUS not between", value1, value2, "status");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectIsNull() {
			addCriterion("CONNECT_ is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectIsNotNull() {
			addCriterion("CONNECT_ is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectEqualTo(String value) {
			addCriterion("CONNECT_ =", value, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectNotEqualTo(String value) {
			addCriterion("CONNECT_ <>", value, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectGreaterThan(String value) {
			addCriterion("CONNECT_ >", value, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectGreaterThanOrEqualTo(String value) {
			addCriterion("CONNECT_ >=", value, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectLessThan(String value) {
			addCriterion("CONNECT_ <", value, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectLessThanOrEqualTo(String value) {
			addCriterion("CONNECT_ <=", value, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectLike(String value) {
			addCriterion("CONNECT_ like", value, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectNotLike(String value) {
			addCriterion("CONNECT_ not like", value, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectIn(List<String> values) {
			addCriterion("CONNECT_ in", values, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectNotIn(List<String> values) {
			addCriterion("CONNECT_ not in", values, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectBetween(String value1, String value2) {
			addCriterion("CONNECT_ between", value1, value2, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andConnectNotBetween(String value1, String value2) {
			addCriterion("CONNECT_ not between", value1, value2, "connect");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeIsNull() {
			addCriterion("RANGE_ is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeIsNotNull() {
			addCriterion("RANGE_ is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeEqualTo(BigDecimal value) {
			addCriterion("RANGE_ =", value, "range");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeNotEqualTo(BigDecimal value) {
			addCriterion("RANGE_ <>", value, "range");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeGreaterThan(BigDecimal value) {
			addCriterion("RANGE_ >", value, "range");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("RANGE_ >=", value, "range");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeLessThan(BigDecimal value) {
			addCriterion("RANGE_ <", value, "range");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("RANGE_ <=", value, "range");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeIn(List<BigDecimal> values) {
			addCriterion("RANGE_ in", values, "range");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeNotIn(List<BigDecimal> values) {
			addCriterion("RANGE_ not in", values, "range");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RANGE_ between", value1, value2, "range");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andRangeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("RANGE_ not between", value1, value2, "range");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinIsNull() {
			addCriterion("MEASURE_MIN is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinIsNotNull() {
			addCriterion("MEASURE_MIN is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinEqualTo(BigDecimal value) {
			addCriterion("MEASURE_MIN =", value, "measureMin");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinNotEqualTo(BigDecimal value) {
			addCriterion("MEASURE_MIN <>", value, "measureMin");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinGreaterThan(BigDecimal value) {
			addCriterion("MEASURE_MIN >", value, "measureMin");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MEASURE_MIN >=", value, "measureMin");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinLessThan(BigDecimal value) {
			addCriterion("MEASURE_MIN <", value, "measureMin");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MEASURE_MIN <=", value, "measureMin");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinIn(List<BigDecimal> values) {
			addCriterion("MEASURE_MIN in", values, "measureMin");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinNotIn(List<BigDecimal> values) {
			addCriterion("MEASURE_MIN not in", values, "measureMin");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MEASURE_MIN between", value1, value2, "measureMin");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMinNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MEASURE_MIN not between", value1, value2, "measureMin");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxIsNull() {
			addCriterion("MEASURE_MAX is null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxIsNotNull() {
			addCriterion("MEASURE_MAX is not null");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxEqualTo(BigDecimal value) {
			addCriterion("MEASURE_MAX =", value, "measureMax");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxNotEqualTo(BigDecimal value) {
			addCriterion("MEASURE_MAX <>", value, "measureMax");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxGreaterThan(BigDecimal value) {
			addCriterion("MEASURE_MAX >", value, "measureMax");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MEASURE_MAX >=", value, "measureMax");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxLessThan(BigDecimal value) {
			addCriterion("MEASURE_MAX <", value, "measureMax");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MEASURE_MAX <=", value, "measureMax");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxIn(List<BigDecimal> values) {
			addCriterion("MEASURE_MAX in", values, "measureMax");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxNotIn(List<BigDecimal> values) {
			addCriterion("MEASURE_MAX not in", values, "measureMax");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MEASURE_MAX between", value1, value2, "measureMax");
			return (DeviceSensorSearch.Criteria) this;
		}

		public DeviceSensorSearch.Criteria andMeasureMaxNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MEASURE_MAX not between", value1, value2, "measureMax");
			return (DeviceSensorSearch.Criteria) this;
		}
	}
}