<%@ page language="java" pageEncoding="UTF-8"%>
<form id="form-searchdept" method="post" onsubmit="return searchdept();">

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
					<input type="text" class="form-control" id="search-deptid"
						placeholder="部门编号" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					部门名称
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="search-deptname"
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
					<input type="text" class="form-control" id="search-deptmgr"
						placeholder="部门经理" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					上级部门
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="search-deptparent"
						placeholder="上级部门" />
				</div>
			</div>
		</div>
	</div>

	<div class="span8">
		
		<button type="submit" class="btn btn-success span2 pull-right">
			<i class="icon-search icon-white"></i> 查询部门
		</button>
		<button id="btn-download-dept" type="button" class="btn span2 pull-right">
			<i class="icon-arrow-down "></i> 导出
		</button>
	</div>
	
	<div class="span8">
		<legend>&nbsp;</legend>
	</div>

</form>