<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<input type="hidden" id="dsCount" value="${fn:length(dsList) }" />
<c:forEach items="${dsList }" var="item" varStatus="vs">
	<p style="overflow: hidden" id="p${vs.index}">
		<input type="hidden" name="sId" value="${item.id }"/>
    	<input type="text" name="sName" class="input-large" style="float: left; width: 100px;"
    	 maxlength="50" title="传感器名称" value="${item.name }" readonly="readonly"/>
    	<select id="sType_${vs.index }" name="sType" style="float: left; margin-left:5px;" disabled="disabled">
    		<option value="1" ${item.type eq '1' ? 'selected' : '' }>数值型</option>
    		<option value="2" ${item.type eq '2' ? 'selected' : '' }>定位型</option>
    		<option value="3" ${item.type eq '3' ? 'selected' : '' }>档位型</option>
    		<option value="4" ${item.type eq '4' ? 'selected' : '' }>开关型（可操作）</option>
    		<option value="5" ${item.type eq '5' ? 'selected' : '' }>开关型（不可操作）</option>
    	</select>
    	<select id="sNum_${vs.index }" name="sNum" style="float: left; margin-left:5px; ${item.type eq '4' || item.type eq '5' ? 'display:none' : ''}" disabled="disabled">
    		<option value="0" ${item.decimalNum eq '0' ? 'selected' : '' }>0（小数位）</option>
    		<option value="1" ${item.decimalNum eq '1' ? 'selected' : '' }>1（小数位）</option>
    		<option value="2" ${item.decimalNum eq '2' ? 'selected' : '' }>2（小数位）</option>
    		<option value="3" ${item.decimalNum eq '3' ? 'selected' : '' }>3（小数位）</option>
    		<option value="4" ${item.decimalNum eq '4' ? 'selected' : '' }>4（小数位）</option>
    	</select>
    	<input id="sUnit_${vs.index }" type="text" name="sUnit" class="input-large" style="float: left; width: 50px;margin-left:5px; ${item.type eq '4' || item.type eq '5' ? 'display:none' : ''}"
    	 maxlength="5" title="小数位数" value="${item.unit }" readonly="readonly"/>
    </p>
</c:forEach>