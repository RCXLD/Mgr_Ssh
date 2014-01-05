﻿<%@ page language="java" pageEncoding="UTF-8"%>
<form id="form-editdept" method="post" onsubmit="return editdept();">
	<div class="span8">
		<ul class="nav nav-tabs">
			<li class="active tab-header">
				<a href="#">部门信息</a>
			</li>
		</ul>
	</div>

	<div class="span4">
		<div class="form-horizontal" role="form">
			<div class="control-group">
				<label for="inputName" class="col-lg-5 control-label">
					部门编号
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="edit-deptid"
						placeholder="部门编号" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					部门名称
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="edit-deptname"
						placeholder="部门名称" />
				</div>
			</div>
		</div>
	</div>
	<!--  span4 -->


	<div class="span4">
		<div class="form-horizontal" role="form">
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					部门经理
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="edit-deptmgr"
						placeholder="部门经理" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					上级部门
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="edit-deptparent"
						placeholder="上级部门" />
				</div>
			</div>
		</div>
	</div>

	<div class="span8">
		<br></br>
	</div>

	<div class="span3 offset5">
		<button type="submit" class="btn btn-primary btn-block">
			更新客户
		</button>
	</div>

</form>