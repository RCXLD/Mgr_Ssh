<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>飞翔人力资源信息管理系统</title>
		<link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
		<link href="css/style.css" rel="stylesheet" />
	</head>

	<body>


		<nav class="navbar navbar-inverse navbar-fixed-top" >
		  <div class="navbar-inner">
		  	<div class="container">
		        <a class="brand" href="#">飞翔人力资源信息管理系统</a>
		        <ul class="nav navbar-nav">      
		        </ul>
		    </div>
		  </div>

		</nav>

		<section id="idx-content" class="">
			<div class="container">
				<div class="row login-row">
					<form id="form-login" method="post" onsubmit="return login();">
						<div class="row">
							<div id="idx-login" class="form-horizontal span4 offset8">
								<h4>飞翔人力资源信息管理系统</h4>
								<div class="idx-control-group control-group">
									<label for="inputUserame" class="col-lg-3 control-label">
										用户名:
									</label>
									<div class="">
										<input type="text" class="span4" id="txt-userid" />
									</div>
								</div>
								<div class="idx-control-group control-group">
									<label for="inputPassword" class="control-label">
										密码:
									</label>
									<div class="">
										<input type="password" class="span4" id="txt-userpwd" />
									</div>
								</div>
								<button id="btn-login" type="submit"
									class="idx-control-group btn btn-block btn-primary">
									登录
								</button>
								<span id="info-login" style=""></span>
							</div>
						</div>
					</form>
				</div>

			</div> <!-- container -->
		</section><!-- content -->

		<footer id="idx-footer">
			<div class="container">
				
				<div class="footer-content offset2">
					<p></p>
					<h4>开发者：邹翔</h4>
				</div>
			</div>
		</footer>

		<script src="js/login.js"></script>
		<script src="js/jquery-2.0.3.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/login.js"></script>
	</body>
</html>
