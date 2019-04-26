<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=GeamyxbBpgbKlTvOIjdtXKgsyVQphTd2"></script>
<body>
<div id="container" style="width: 100%; height: 800px;"></div> 
<script type="text/javascript"> 
var map = new BMap.Map("container");
// 设置地图默认中心点  
map.centerAndZoom("杨凌区", 15);
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
	var marker = new BMap.Marker(point);
	map.addOverlay(marker);
});
</script> 
</body>
</html>