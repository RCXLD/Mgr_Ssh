<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="mgr.entity.User"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<!-- InstanceBegin template="/Templates/left-menu.dwt" codeOutsideHTMLIsLocked="false" -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>天马劳务派遣信息管理系统</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
		<link href="css/datatables/demo_page.css" rel="stylesheet" />
		<link href="css/datatables/demo_table.css" rel="stylesheet" />
		<!-- InstanceParam name="left-menu" type="boolean" value="true" -->
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
		<div class="container">
			<div class="row">
				<div id="left-menu" class="span2">
					<ul class="nav nav-pills nav-stacked">
						<li class="nav-header">
							部门管理
						</li>
						<li class="active">
							<a id="a-client-input" href="#client-input">部门信息录入</a>
						</li>
						<li>
							<a id="a-client-search" href="#client-search">部门信息查询</a>
						</li>
						<li>
							<a id="a-client-update" href="#client-update">部门信息修改</a>
						</li>
						<li>
							<a id="a-post-input" href="#client-demamd-input">岗位信息录入</a>
						</li>
						<li>
							<a id="a-post-search" href="#client-demamd-search">岗位信息查询</a>
						</li>
						<li>
							<a id="a-post-update" href="#client-demamd-update">岗位信息修改</a>
						</li>
					</ul>

				</div>
				<!--  left-menu -->

				<div class="span9 lm-main-content">
					<div id="client-tab-content" class="tab-content">
						<div class="tab-pane active" id="client-input">
							<%@ include file="f_client_input.jsp"%>

						</div>
						<!-- client-input -->


						<div class="tab-pane " id="client-search">
							<%@ include file="f_client_search.jsp"%>
							<%@ include file="f_client_searchresult.jsp"%>
						</div>
						<!-- client-search -->


						<div class="tab-pane " id="client-update">
							<%@ include file="f_client_modify.jsp"%>
						</div>
						<!-- client-update -->


						<div class="tab-pane " id="client-demamd-input">
							<%@ include file="f_client_demamd_input.jsp"%>
						</div>
						<!-- client-demamd-input -->

						<div class="tab-pane " id="client-demamd-search">
							<%@ include file="f_client_demamd_search.jsp"%>
							<%@ include file="f_client_demamd_searchresult.jsp"%>
						</div>
						<!-- client-demamd-search -->

						<div class="tab-pane " id="client-demamd-update">
							<%@ include file="f_client_demamd_update.jsp"%>
						</div>
						<!-- client-demamd-update -->


					</div>
					<!--  "client-tab-content -->
				</div>
				<!--  lm-main-content  -->


			</div>
			<!-- row -->



		</div>
		<!-- container -->
		<script src="js/jquery-1.7.2.min.js"></script>
		<script src="js/datatables/jquery.dataTables.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/main.js"></script>
		<script src="js/date-picker.js"></script>
		<script src="js/dept.js"></script>
		<script src="js/post.js"></script>


	</body>
	<!-- InstanceEnd -->
</html>
