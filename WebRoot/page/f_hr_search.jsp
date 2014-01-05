<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="row">
	<div class="span8">
		<ul class="nav nav-tabs">
			<li class="active tab-header">
				<a href="#">查询选项</a>
			</li>
		</ul>
	</div>
	<form id="form-search" class="form-horizontal" method="post"
		onsubmit="return search();">
		<div class="span4">
			<div class="control-group">
				<label class="control-label" for="search-empid">
					员工工号
				</label>
				<div class="controls">
					<input type="text" id="search-empid" name="search-empid" />
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="search-empid">
					员工姓名
				</label>
				<div class="controls">
					<input type="text" id="search-empname" name="search-empname" />
				</div>
			</div>

		</div>
		<!--  span4 -->

		<div class="span4">
			<div class="control-group">
				<label class="control-label" for="search-deptid">
					所属部门
				</label>
				<div class="controls">
					<input type="text" id="search-deptid" name="search-deptid" />
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="search-icid">
					身份证号
				</label>
				<div class="controls">
					<input type="text" id="search-icid" name="search-icid" />
				</div>
			</div>
		</div>
		<!--  span4 -->

		<div class="span8">
			<button id="btn-search" type="submit"
				class="btn btn-success span2 pull-right">
				<i class="icon-search icon-white"></i> 查询
			</button>
			<button id="btn-download" class="btn span2 pull-right">
				<i class="icon-arrow-down "></i> 导出
			</button>
		</div>
	</form>
</div>
<!--  row  -->
<legend>
	&nbsp;
</legend>

<table id="EmpList"
	class="table table-condensed table-hover table-striped">
	<thead>
		<tr>
			<th>
				员工工号
			</th>
			<th>
				员工姓名
			</th>
			<th>
				身份证号
			</th>
			<th>
				所属部门
			</th>
			<th>
				岗位
			</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>