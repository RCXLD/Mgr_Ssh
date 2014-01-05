<%@ page language="java" pageEncoding="UTF-8"%>
<form id="form-editpost" method="post" onsubmit="return editpost();">

	<div class="span8">
		<ul class="nav nav-tabs">
			<li class="active tab-header">
				<a href="#">岗位信息</a>
			</li>
		</ul>
	</div>

	<input type="hidden" id="edit-pid">
	<div class="span4">
		<div class="form-horizontal" role="form">
			<div class="control-group">
				<label for="inputName" class="col-lg-5 control-label">
					岗位编号
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="edit-postid"
						placeholder="岗位编号" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					岗位名称
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="edit-postname"
						placeholder="岗位名称" />
				</div>
			</div>
		</div>
	</div>
	<!--  span4 -->


	<div class="span4">
		<div class="form-horizontal" role="form">
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					岗位职责
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="edit-postctn"
						placeholder="岗位职责" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					所属部门
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="edit-postdeptid"
						placeholder="所属部门" />
				</div>
			</div>
		</div>
	</div>

	<!--  span4 -->
	<div class="span8">
		<br></br>
	</div>

	<div class="span3 offset5">
		<button type="submit" class="btn btn-primary btn-block">
			更新岗位
		</button>
	</div>

</form>