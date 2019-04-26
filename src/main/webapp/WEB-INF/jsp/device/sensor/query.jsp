<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/header.jspf" %>
<style type="text/css">
.gj-query-input {
	width: 340px;
}
</style>
<script src="${root}/compnents/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${root}/compnents/layer/layer.js" type="text/javascript"></script>
<div class="alert alert-block pull-top alert-danger" id="alert-div" style="display:none">
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
      设备传感器
        <small><i class="ace-icon fa fa-angle-double-right"></i>
            传感器查询
        </small>
    </h1>
</div>
<div class="row" style="margin-top:1px;">
    <div class="col-xs-12">
        <table id="table" class="table table-striped table-bordered table-hover table-style" style="text-align: center">
            <thead>
            <tr>
            	<th>设备编号</th>
            	<th>设备名称</th>
                <th>传感器编号</th>
                <th>传感器名称</th>
                <th>状态</th>
                <th>是否连接</th>
                <th>数据时间</th>
                <th>数据值</th>
                <th width="120">操作</th>
            </tr>
            </thead>
            <tbody id="tbody">
            <c:forEach items="${pageList.result}" var="item">
                <tr>
                    <td>${item.deviceCode }</td>
                    <td>${item.deviceName }</td>
                    <td>${item.code }</td>
                    <td>${item.name }</td>
                    <td>${item.status eq '1' ? '启用' : '停用' }</td>
                    <td>${item.connect eq '1' ? '已连接' : '已断开' }</td>
                    <td><fmt:formatDate value="${item.dataTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	                <td>${item.data }</td>
                    <td>
                    	<div class="hidden-sm hidden-xs btn-group">
                                <button class="btn btn-xs btn-success" title="实时曲线" onclick="showViewById('${item.id}')">
                                    <i class="ace-icon fa fa-area-chart bigger-120"></i>
                                </button>
                                <button class="btn btn-xs btn-info" title="历史数据" onclick="historyData('${item.deviceCode}', '${item.code }')">
                                    <i class="ace-icon fa fa-history bigger-120"></i>
                                </button>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <c:if test="${pageList.result!=null}">
                <c:forEach begin="1" end="${15-fn:length(pageList.result)}">
                    <tr>
                        <td colspan="68">&nbsp;</td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
        <div class="row">
            <c:if test="${pageList!=null}">
                <tags:pagination page="${pageList}"></tags:pagination>
            </c:if>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">
    function historyData(deviceCode, sensorCode) {
    	if (deviceCode == "" || sensorCode == "") {
    		showMessage("参数不全，不能查看传感器数据。");
    		return;
    	}
    	layer.ready(function(){ 
    		  layer.open({
    		    type: 2,
    		    title: "设备编号：" + deviceCode + " --> 传感器编号：" + sensorCode,
    		    maxmin: true,
    		    area: ['800px', '500px'],
    		    content: "${root}/device/sensor/data/list/"+deviceCode+"/"+sensorCode+"/"
    		  });
    		});
    	
    }
    
    
    $(document).ready(function () {
        $("#alert-div").hide();
    });
</script>
<%@ include file="/WEB-INF/jsp/common/fooltertags.jspf" %>