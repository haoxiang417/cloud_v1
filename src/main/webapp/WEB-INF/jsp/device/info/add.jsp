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
			新增设备 </small>
	</h1>
</div>
<div class="row">
	<form id="inputForm" class="form-horizontal"
		action="${root}/device/info/doAdd/${menuid }/" method="post"
		style="margin-bottom: 0; padding: 0;">
		<input type="hidden" name="page" value="${page }" />
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
								<input type="text" id="code" name="code" maxlength="11"
									class="input-large required left-map-input-width digits" />
								<span style="color: red">*</span>
								<span id="checkCodeSpan" style="color: red"></span>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">设备名称</div>
							<div class="profile-info-value">
								<input type="text" id="name" name="name" maxlength="50"
									class="input-large required left-map-input-width" /> <span
									style="color: red">*</span>
							</div>
						</div>

						<div class="profile-info-row">
							<div class="profile-info-name">链接协议</div>
							<div class="profile-info-value">
								<select id="agreement" name="agreement"
									class="required left-map-input-width">
									<tags:diccache typeCode="AGREEMENT"></tags:diccache>
								</select> <span style="color: red">*</span>
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">视频地址</div>
							<div class="profile-info-value">
								<input type="text" id="videoUrl" name="videoUrl" maxlength="200"
									class="input-large left-map-input-width" />
							</div>
						</div>
						<div class="profile-info-row">
							<div class="profile-info-name">上报周期</div>
							<div class="profile-info-value">
								<input type="radio" name="cycleType" value="1" onclick="changeRadio(this.value)" />自定义
								<input type="radio" name="cycleType" value="2" onclick="changeRadio(this.value)" checked="checked"/>推荐值
								<div id="cycleDiv2">
									<select id="cycleSelect" name="cycle" style="width: 180px;">
										<option value="60">60（秒）</option>
										<option value="120">120（秒）</option>
										<option value="180">180（秒）</option>
										<option value="240">240（秒）</option>
										<option value="300">300（秒）</option>
										<option value="600">600（秒）</option>
									</select>
								</div>
								<div id="cycleDiv1" style="display: none;">
									<input type="text" id="cycleInput" name="cycle" value="60" disabled="disabled" 
										maxlength="3" class="input-large left-map-input-width digits" />&nbsp;秒
								</div>
							</div>
						</div>

						<div class="profile-info-row">
							<div class="profile-info-name">是否公开</div>
							<div class="profile-info-value">
								<input type="radio" name="isOpen" value="1" />是
								<input type="radio" name="isOpen" value="0" checked="checked"/>否
							</div>
						</div>
						<c:forEach begin="1" end="3" varStatus="vs">
						<div class="profile-info-row">
							<div class="profile-info-name">传感器${vs.count }</div>
							<div class="profile-info-value">
								<input type="checkbox" name='sState' value="1" checked="checked" title="选中启用" />
								<input type='text' name='sName' class='input-large' 
									style='width: 100px;' maxlength='50' placeholder='传感器名称'/>
								<select id='sType_${vs.count }' name='sType' style='margin-left:5px;' onchange='changeType(1)'>
									<option value='1'>数值型</option>
									<option value='2'>定位型</option>
									<option value='3'>档位型</option>
									<option value='4'>开关型（可操作）</option>
									<option value='5'>开关型（不可操作）</option>
								</select>
								<select id='sNum_${vs.count }' name='sNum' style='margin-left:5px;'>
									<option value='0'>0（小数位）</option>
									<option value='1'>1（小数位）</option>
									<option value='2'>2（小数位）</option>
									<option value='3'>3（小数位）</option>
									<option value='4'>4（小数位）</option>
								</select>
								<input id='sUnit_${vs.count }' type='text' name='sUnit' class='input-large' 
    										style='width: 50px;margin-left:5px;' maxlength='5' placeholder='单位'/>
    							<br/>
    							<input id='sRange_${vs.count }' type='text' name='sRange' class='input-large number' 
    										style='width: 100px;margin-left:18px;' maxlength='5' placeholder='量程（m）'/>
    							<span style='margin-left: 5px;'>测量范围</span>
    							<input id='sMin_${vs.count }' type='text' name='sMin' class='input-large number' 
    										style='width: 50px;margin-left:5px;' maxlength='5' />
    							&nbsp;至
    							<input id='sMax_${vs.count }' type='text' name='sMax' class='input-large number' 
    										style='width: 50px;margin-left:5px;' maxlength='5' />
							</div>
						</div>
						</c:forEach>
					</div>
					<input type="hidden" id="longitude" name="longitude" />
					<input type="hidden" id="latitude" name="latitude" />
			        <div class="clearfix form-actions">
			            <div class="col-md-offset-2 col-md-10">
			                <button class="btn btn-primary" type="button" onclick="checkForm()">
			                    <i class="ace-icon fa fa-submit bigger-110"></i> 保存
			                </button>
			                <button class="btn" type="button" onclick="window.location.href='${root}/device/info/list/${menuid }/?page=${page }&isgetsession=1'">
					            <i class="ace-icon fa fa-undo bigger-110"></i> 返回
					        </button>
			            </div>
			        </div>
				</td>
			</tr>

		</table>

	</form>
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
		//单击获取点击的经纬度
		map.addEventListener("click",function(e){
			//清除选点
			map.clearOverlays();
			//增加地图点位
			var point = new BMap.Point(e.point.lng, e.point.lat);
			//隐藏域赋值
			$("#longitude").val(e.point.lng);
			$("#latitude").val(e.point.lat);
			var marker = new BMap.Marker(point);
			map.addOverlay(marker);
		});
	});
</script>
<script type="text/javascript">
	var v;
	var uiindex = 1;
	var isCheck = false;
    $(document).ready(function () {
        //聚焦第一个输入框
        //为inputForm注册validate函数
        v = $("#inputForm").validate();
        $("#code").focus();
    });
    function checkForm() {
    	checkCode();
    	if (v.checkForm() && isCheck) {
    		$("#inputForm").submit();
    	}else{
    		v.showErrors();
    	}
    }
    function changeRadio(val) {
    	if (val == "1") 
    	{
    		$("#cycleDiv1").css("display", "block");
    		$("#cycleDiv2").css("display", "none");
    		$("#cycleInput").removeAttr("disabled");
    		$("#cycleSelect").attr("disabled", true);
    	} 
    	else if (val == "2") 
    	{
    		$("#cycleDiv2").css("display", "block");
    		$("#cycleDiv1").css("display", "none");
    		$("#cycleSelect").removeAttr("disabled");
    		$("#cycleInput").attr("disabled", true);
    	}
    }
    function changeType(index) {
    	var t = $("#sType_"+index+" option:selected").val();
    	var s = $("#sNum_"+index);
    	var u = $("#sUnit_"+index);
    	if (t == "4" || t == "5") {
    		s.attr("disabled", "disabled");
    		s.css("display", "none");
    		u.attr("disabled", "disabled");
    		u.css("display", "none");
    	} else{
    		s.removeAttr("disabled");
    		s.css("display", "block");
    		u.removeAttr("disabled");
    		u.css("display", "block");
    	}
    }
    function checkCode() {
    	var codeObj = $("#code");
    	if (codeObj.val() != "") {
    		$.ajax({
    			async:false,
    			type:"post",
    			url:"${root}/device/info/checkCode/"+codeObj.val()+"/",
    			success:function(data) {
    				if (data.result == "ok") {
    					isCheck = true;
    					$("#checkCodeSpan").empty();
    				}else if (data.result == "repeat") {
    					$("#checkCodeSpan").empty().html("设备编号重复");
    				}
    			}
    		});
    	}
    }
</script>

<%@ include file="/WEB-INF/jsp/common/fooltertags.jspf"%>