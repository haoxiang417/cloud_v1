<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/header.jspf"%>
<script src="${root}/compnents/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=GeamyxbBpgbKlTvOIjdtXKgsyVQphTd2"></script>
<div class="alert alert-block pull-top alert-danger" id="alert-div"
	style="display: none">
	<p id="alert-content" align="center"></p>
</div>
<c:if test="${not empty message}">
	<div id="message" class="alert alert-success">
		<button data-dismiss="alert" class="close">×</button>
		<p align="center">${message}</p>
	</div>
	<script>
        setTimeout('$("#message").hide("slow")', 1200);    </script>
</c:if>
<div class="page-header">
	<h1>
		我的设备 
		<small><i class="ace-icon fa fa-angle-double-right"></i>
			查看设备 </small>
	</h1>
</div>
<div class="row">
		<input type="hidden" name="page" value="${page }" />
		<input type="hidden" name="id" value="${info.id }" />
		<table class="width-100">
			<tr>
				<td valign="top">
					<div id="map" style="width: 100%; min-height: 720px !important; position: relative">
					</div>
				</td>
				<td style="width: 700px; padding-left: 20px; position: relative"
					class="td_h" valign="top">

					<div class="profile-user-info profile-user-info-striped">
						<div class="profile-info-row">
							<div class="profile-info-name">设备编号</div>
							<div class="profile-info-value">
								${info.code }
							</div>
						</div>
						
						<div class="profile-info-row">
							<div class="profile-info-name">设备名称</div>
							<div class="profile-info-value">
								${info.name }
							</div>
						</div>

						<div class="profile-info-row">
							<div class="profile-info-name">链接协议</div>
							<div class="profile-info-value">
								<tags:cache keyName="Dic" typeCode="AGREEMENT" id="${info.agreement }" />
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">视频地址</div>
							<div class="profile-info-value">
								${info.videoUrl }
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">上报周期</div>
							<div class="profile-info-value">
								${info.cycle }&nbsp;秒
							</div>
						</div>

						<div class="profile-info-row">
							<div class="profile-info-name">是否公开</div>
							<div class="profile-info-value">
								${info.isOpen eq '1' ? '是':'否' }
							</div>
						</div>
						
						<c:forEach items="${sensors }" var="item" varStatus="vs">
						<div class="profile-info-row">
							<div class="profile-info-name">传感器${vs.count }</div>
							<div class="profile-info-value">
								<input type="hidden" name="sId" value="${item.id }"/>
								<input type="checkbox" name='sState' value="1" ${item.status eq '1' ? 'checked' : '' } title="选中启用" />
						    	<input type="text" name="sName" class="input-large" style="width: 100px;"
						    	 maxlength="50" value="${item.name }"/>
						    	<select id="sType_${vs.index }" name="sType" style="margin-left:5px;" onchange="changeType('${vs.index }')">
						    		<option value="1" ${item.type eq '1' ? 'selected' : '' }>数值型</option>
						    		<option value="2" ${item.type eq '2' ? 'selected' : '' }>定位型</option>
						    		<option value="3" ${item.type eq '3' ? 'selected' : '' }>档位型</option>
						    		<option value="4" ${item.type eq '4' ? 'selected' : '' }>开关型（可操作）</option>
						    		<option value="5" ${item.type eq '5' ? 'selected' : '' }>开关型（不可操作）</option>
						    	</select>
						    	<select id="sNum_${vs.index }" name="sNum" style="margin-left:5px; ${item.type eq '4' || item.type eq '5' ? 'display:none' : ''}">
						    		<option value="0" ${item.decimalNum eq '0' ? 'selected' : '' }>0（小数位）</option>
						    		<option value="1" ${item.decimalNum eq '1' ? 'selected' : '' }>1（小数位）</option>
						    		<option value="2" ${item.decimalNum eq '2' ? 'selected' : '' }>2（小数位）</option>
						    		<option value="3" ${item.decimalNum eq '3' ? 'selected' : '' }>3（小数位）</option>
						    		<option value="4" ${item.decimalNum eq '4' ? 'selected' : '' }>4（小数位）</option>
						    	</select>
						    	<input id="sUnit_${vs.index }" type="text" name="sUnit" class="input-large" style="width: 50px;margin-left:5px; ${item.type eq '4' || item.type eq '5' ? 'display:none' : ''}"
						    	 maxlength="5" value="${item.unit }"/>
						    	<br/>
								<input id='sRange_${vs.index }' type='text' name='sRange' class='input-large number' value="${item.range }"
											style='width: 100px;margin-left:18px;' maxlength='5' />
								<span style='margin-left: 5px;'>测量范围</span>
								<input id='sMin_${vs.index }' type='text' name='sMin' class='input-large number' value="${item.measureMin }"
											style='width: 50px;margin-left:5px;' maxlength='5' />
								&nbsp;至
								<input id='sMax_${vs.index }' type='text' name='sMax' class='input-large number' value="${item.measureMax }"
											style='width: 50px;margin-left:5px;' maxlength='5' />
							</div>
						</div>
						</c:forEach>
					</div>
					<input type="hidden" id="longitude" name="longitude" />
					<input type="hidden" id="latitude" name="latitude" />
			        <div class="clearfix form-actions">
			            <div class="col-md-offset-2 col-md-10">
			                <button class="btn" type="button" onclick="window.location.href='${root}/device/info/list/${menuid }/?page=${page }&isgetsession=1'">
					            <i class="ace-icon fa fa-undo bigger-110"></i> 返回
					        </button>
			            </div>
			        </div>
				</td>
			</tr>

		</table>

</div>


<script type="text/javascript">
	var _map;
	// 页面加载成功后，初始化页签和地图
	$(document).ready(function() {
		map = new BMap.Map("map");
		// 设置地图默认中心点  
		map.centerAndZoom(new BMap.Point(108.953636, 34.267581), 15);
		// 初始化地图，设置中心点坐标和地图级别  
		map.addControl(new BMap.ScaleControl());//比例尺
		map.addControl(new BMap.NavigationControl());//缩放
		map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
		map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
		
		<c:if test="${not empty info.longitude && not empty info.latitude}">
			var point = new BMap.Point(${info.longitude}, ${info.latitude});
			var marker = new BMap.Marker(point);
			map.addOverlay(marker);
		</c:if>
		
	});
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $("input").each(function(){
        	$(this).attr("disabled", "disabled");
        });
        $("select").each(function(){
        	$(this).attr("disabled", "disabled");
        });
    });
    
</script>

<%@ include file="/WEB-INF/jsp/common/fooltertags.jspf"%>