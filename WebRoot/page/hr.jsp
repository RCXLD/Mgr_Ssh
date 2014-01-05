<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="mgr.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>飞翔人力资源信息管理系统</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
		<link href="css/datatables/demo_page.css" rel="stylesheet" />
		<link href="css/datatables/demo_table.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
	</head>
	<body>
		<%
			User user = (User) session.getAttribute("user");
			if (user == null) {
				response.sendRedirect("/mgr");
			}
		%>
		<%@ include file="topnav.jsp"%>
		<div id="content" class="container">
			<div class="row">
				<div id="left-menu" class="span2">
					<ul class="nav nav-pills nav-stacked">
						<li class="nav-header">
							员工管理
						</li>
						<li class="active">
							<a href="#worker-input">员工信息录入</a>
						</li>
						<li>
							<a id="a-worker-search" href="#worker-search">员工信息查询</a>
						</li>
						<li>
							<a id="a-worker-modify" href="#worker-modify">员工信息修改</a>
						</li>
					</ul>
				</div>

				<div class="span9 lm-main-content">
					<div id="hr-tab-content" class="tab-content">
						<div class="tab-pane active" id="worker-input">
							<%@ include file="f_hr_input.jsp"%>
						</div>
					
						<div class="tab-pane" id="worker-search">
							<%@ include file="f_hr_search.jsp"%>
						</div>
					
						<div class="tab-pane" id="worker-modify">
							<%@ include file="f_hr_update.jsp"%>
						</div>
						
					</div>
					<!--  tab-content  -->
				</div>
				<!--  lm-main-content  -->
			</div>
			<!-- row -->
		</div>
		<!-- content -->

		<script src="js/jquery-2.0.3.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/datatables/jquery.dataTables.js"></script>
		<script src="js/main.js"></script>
		<script src="js/hr.js"></script>
		<script src="js/date-picker.js"></script>

	</body>
	<!-- InstanceEnd -->
</html>
