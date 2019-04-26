<%@ page import="java.util.Date" %>
<%@ page import="com.lec.framework.util.DateUtil" %>
<%@ page import="com.lec.framework.constant.FORMAT" %>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<%
    java.util.Date date = new java.util.Date();
    Date beginOfMonth = DateUtil.getBeginOfMonth(date, 0);
    Date endOfMonth = DateUtil.getEndOfMonth(date, 0);
    String startDate = DateUtil.formatDate(FORMAT.DATETIME.DEFAULT, beginOfMonth);
    String endDate = DateUtil.formatDate(FORMAT.DATETIME.DEFAULT, endOfMonth);
    request.setAttribute("startDate", startDate);
    request.setAttribute("endDate", endDate);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>云平台</title>
    <meta name="description" content="overview &amp; stats"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${root}/compnents/ace/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${root}/compnents/ace/css/font-awesome.min.css"/>
    <!-- page specific plugin styles -->

    <!-- text fonts -->
    <link rel="stylesheet" href="${root}/compnents/ace/css/ace-fonts.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="${root}/compnents/ace/css/ace.min.css" id="main-ace-style"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${root}/compnents/ace/css/ace-part2.min.css"/>
    <![endif]-->
    <link rel="stylesheet" href="${root}/css/GisStyle/Common.css"/>
    <link rel="stylesheet" href="${root}/compnents/ace/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="${root}/compnents/ace/css/ace-rtl.min.css"/>
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${root}/compnents/ace/css/ace-ie.min.css"/>
    <![endif]-->
    <!-- inline styles related to this page -->
    <!-- ace settings handler -->
    <script src="${root}/compnents/ace/js/jquery-1.7.2.min.js"></script>
    <script src="${root}/compnents/ace/js/ace-extra.min.js"></script>
    <script src="${root}/compnents/ECharts/echarts.min.js" type="text/javascript"></script>
	<script src="${root}/compnents/ECharts/theme/shine.js" type="text/javascript"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=GeamyxbBpgbKlTvOIjdtXKgsyVQphTd2"></script>
    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
    <!--[if lte IE 8]>
    <script src="${root}/compnents/ace/js/html5shiv.min.js"></script>
    <script src="${root}/compnents/ace/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="no-skin" style="overflow-x: hidden">
<tags:top></tags:top>
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container" style="margin-top:76px">
<script type="text/javascript">
    try {
        ace.settings.check('main-container', 'fixed')
    } catch (e) {
    }
</script>
<tags:menu menus="${menus}"></tags:menu>
<div class="main-content">
<div class="page-content" style="padding:2px 2px;">
<div class="ace-settings-container hide" id="ace-settings-container">
    <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
        <i class="ace-icon fa fa-cog bigger-150"></i>
    </div>

    <div class="ace-settings-box clearfix" id="ace-settings-box" style="min-height: 70px;">
        <div class="pull-left width-50">
            <div class="ace-settings-item">
                <div class="pull-left">
                    <select id="skin-colorpicker" class="hide" data-userskin="${skin }">
                        <option data-skin="no-skin" value="#438EB9" selected>
                            #438EB9
                        </option>
                        <option data-skin="skin-1" value="#222A2D">
                            #222A2D
                        </option>
                        <option data-skin="skin-2" value="#C6487E">
                            #C6487E
                        </option>
                        <option data-skin="skin-3" value="#D0D0D0">
                            #D0D0D0
                        </option>
                    </select>
                </div>
                <span>&nbsp; Choose Skin</span>
            </div>
        </div>
        <!-- /.pull-left -->
    </div>
    <!-- /.ace-settings-box -->
</div>
<!-- /.ace-settings-container -->
<div class="page-content-area" id="welcome-page">
<c:if test="${moudelid eq '0'}">
    <div class="row">
        <div id="map" class="col-xs-12" style="position:relative;height:880px;">
        </div>
    </div>
</c:if>
<c:if test="${moudelid ne '0'}">
    <iframe height="100%" width="100%" id="welcomeiframe" src="${welcomeurl}"
            style="min-height:600px;border:0;margin:0;padding:0" scrolling="no"></iframe>
</c:if>
<div class="footer" style="padding-top:0;margin:0;z-index: 1999999">
    <div class="footer-inner">
        <!-- #section:basics/footer -->
        <div class="footer-content" style="position: fixed;border-top:0px double #E5E5E5;bottom: -8px;">
                        <span class="bigger-120"> <span class="blue bolder"><a
                                href="#">LEC</a></span>&copy; 2017-2020 </span>
        </div>
        <!-- /section:basics/footer -->
    </div>
</div>
<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> <i
        class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i> </a>
</div>
</div>

</div>
</div>
<textarea id="chart-xml" style="display: none"></textarea>
<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${root}/compnents/ace/js/jquery1x.min.js'>" + "<" + "/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='${root}/compnents/ace/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
</script>
<script src="${root}/compnents/ace/js/bootstrap.min.js"></script>
<!-- page specific plugin scripts -->
<!--[if lte IE 8]>
<script src="${root}/compnents/ace/js/excanvas.min.js"></script>
<![endif]-->
<script src="${root}/compnents/ace/js/jquery-ui.custom.min.js"></script>
<script src="${root}/compnents/ace/js/jquery.ui.touch-punch.min.js"></script>
<!-- ace scripts -->
<script src="${root}/compnents/ace/js/ace-elements.min.js"></script>
<script src="${root}/compnents/ace/js/ace.min.js"></script>
<!-- inline scripts related to this page -->
<script type="text/javascript">
/**/
jQuery(function ($) {
    var moudle = '${moudelid}';
    if (moudle == '0') {
        $("#sidebar").remove();
    }
});
var _map;
// 页面加载成功后，初始化页签和地图
$(document).ready(function () {
    $("#welcomeiframe").css("height", $(window).height() - 120 + "px");

    // 页面加载成功后，初始化页签和地图
    var isMapInit = false;
    if (!isMapInit) {
        // 初始化地图
        initMap("map");
        isMapInit = true;
        
        getDeviceInfo();
    }
});

//初始化地图
function initMap(mapDiv) {
	_map = new BMap.Map(mapDiv);
	// 设置地图默认中心点  
	_map.centerAndZoom(new BMap.Point(108.953636, 34.267581), 15);
	// 初始化地图，设置中心点坐标和地图级别  
	_map.addControl(new BMap.ScaleControl());//比例尺
	_map.addControl(new BMap.NavigationControl());//缩放
	_map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
	_map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
}

function getDeviceInfo() {
	$.post(
		"${root}/device/info/getDeviceByIndexMap/",
		function(data) {
			if (data) {
				for (i = 0; i < data.length; i++) {
					var marker_ = new BMap.Marker(new BMap.Point(data[i].longitude, data[i].latitude));
					_map.addOverlay(marker_);
					addClickHandler(data[i], marker_);
				}
			}
		}
	);
}
function addClickHandler(dataObj, marker) {
	marker.addEventListener("click",function(e){
		openInfo(dataObj, e);
	});
}
function openInfo(dataObj, e){
	var p = e.target;
	var infoWindowPoint = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
	
	var opts = {
			width : 250,     // 信息窗口宽度
			height: 80,     // 信息窗口高度
			title : "设备【" + dataObj.name + "】属性：" , // 信息窗口标题
			enableMessage:true//设置允许信息窗发送短息
		   };
	
	var infoWindow = new BMap.InfoWindow("设备编号：" + dataObj.code, opts);  // 创建信息窗口对象 
	_map.openInfoWindow(infoWindow, infoWindowPoint); //开启信息窗口
}
</script>
<!-- the following scripts are used in demo only for onpage help and you don't need them -->
<form style="display: none" id="farword-form" action="${root}/forward/page/" method="post">
    <input name="farurl" id="far-url">
</form>
<script>
    var pageWidth = window.innerWidth,
            pageHeight = window.innerHeight;
    if (typeof pageWidth != "number"){
        if (document.compatMode == "CSS1Compat"){
            pageWidth = document.documentElement.clientWidth;
            pageHeight = document.documentElement.clientHeight;
        } else {
            pageWidth = document.body.clientWidth;
            pageHeight = document.body.clientHeight;
        }
    };
</script>
</body>
</html>

