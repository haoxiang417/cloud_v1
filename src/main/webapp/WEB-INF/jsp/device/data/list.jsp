<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>云平台</title>
<meta name="description" content="User login page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome-->
<link rel="stylesheet"
	href="${root}/compnents/ace/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${root}/compnents/ace/css/font-awesome.min.css" />
<link rel="stylesheet" href="${root}/compnents/ace/css/validate.css" />
<link rel="stylesheet" href="${root}/css/style.css" />
<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet" href="${root}/compnents/ace/css/ace-fonts.css" />

<!-- ace styles -->
<link rel="stylesheet" href="${root}/compnents/ace/css/ace.min.css"
	id="main-ace-style" />

<!--[if lte IE 9]>
    <link rel="stylesheet" href="${root}/compnents/ace/css/ace-part2.min.css" />
    <![endif]-->
<link rel="stylesheet"
	href="${root}/compnents/ace/css/ace-skins.min.css" />
<link rel="stylesheet" href="${root}/compnents/ace/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
    <link rel="stylesheet" href="${root}/compnents/ace/css/ace-ie.min.css" />
    <![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="${root}/compnents/ace/js/ace-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
    <script src="${root}/compnents/ace/js/html5shiv.min.js"></script>
    <script src="${root}/compnents/ace/js/respond.min.js"></script>
    <![endif]-->

</head>
<body class="no-skin" style="overflow-x: hidden;">
	<!--[if !IE]> -->
	<script type="text/javascript">
    window.jQuery || document.write("<script src='${root}/compnents/ace/js/jquery-3.2.1.min.js'>"+"<"+"/script>");
</script>
	<!--<![endif]-->

	<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${root}/compnents/ace/js/jquery-3.2.1.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script type="text/javascript">
var root = "${root}";
</script>
	<script src="${root}/compnents/ace/js/ace-elements.min.js"></script>
	<script src="${root}/compnents/ace/js/ace.min.js"></script>
	<script src="${root}/compnents/ace/js/jquery.validate.min.js"></script>
	<script src="${root}/compnents/ace/js/messages_bs_zh.js"></script>
	<script src="${root}/js/jquery.placeholder.min.js"></script>
	<script src="${root}/js/common.js"></script>
	<script src="${root}/compnents/ace/js/bootbox.min.js"></script>
	<!-- #section:basics/navbar.layout -->
	<div style="clear: both"></div>
	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<div class="main-content">
			<!-- #section:basics/content.breadcrumbs -->
			<!-- /section:basics/content.breadcrumbs -->
			<div class="page-content">
				<!-- #section:settings.box -->
				<!-- /section:settings.box -->
				<div class="page-content-area">
					<div class="row">
						<div class="col-xs-12" style="background-color: transparent">
							<script src="${root}/compnents/My97DatePicker/WdatePicker.js"
								type="text/javascript"></script>
							<div style="margin: 10px 0">
								<form class="form-search"
									action="${root}/device/sensor/data/list/${deviceCode }/${sensorCode }/"
									method="post">
									<div class="row">
										<div class="col-xs-12">
											<div class="input-group">
												<input id="startDate" name="search_beginTime" type="text"
													value="${beginTime}" class="input-large"
													readonly="readonly" style="width: 160px;"
													placeholder="起始时间"
													onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00',alwaysUseStartDate:true,maxDate:document.getElementById('endDate').value==''?'':document.getElementById('endDate').value})" />
												至 <input id="endDate" name="search_endTime" type="text"
													value="${endTime}" class="input-large" readonly="readonly"
													style="width: 160px;" placeholder="截止时间"
													onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00',alwaysUseStartDate:true,minDate:document.getElementById('startDate').value})" })" />
												<span class="input-group-btn">
													<button type="submit" class="btn btn-purple btn-sm"
														style="margin-left: 1px;">
														查询<i
															class="ace-icon fa fa-search icon-on-right bigger-110"></i>
													</button>
													<button type="button" class="btn btn-info btn-sm"
														onclick="resetSearchValue()" style="margin-left: 5px;">
														重置 <i
															class="ace-icon fa fa-refresh icon-on-right bigger-110"></i>
													</button>
												</span>
											</div>
										</div>
									</div>
								</form>
							</div>
							<div class="row" style="margin-top: 1px;">
								<div class="col-xs-12">
									<table id="table"
										class="table table-striped table-bordered table-hover table-style"
										style="text-align: center">
										<thead>
											<tr>
												<th>数据时间</th>
												<th>数据值</th>
												<th>传输类型</th>
											</tr>
										</thead>
										<tbody id="tbody">
											<c:forEach items="${pageList.result}" var="item">
												<tr>
													<td><fmt:formatDate value="${item.dataTime }"
															pattern="yyyy-MM-dd HH:mm:ss" /></td>
													<td>${item.data }</td>
													<td>${item.sendType }</td>
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
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
