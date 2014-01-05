<%@ page language="java" pageEncoding="UTF-8"%>
<form id="form-searchpost" method="post"
	onsubmit="return searchpost();">

	<div class="span8">
		<ul class="nav nav-tabs">
			<li class="active tab-header">
				<a href="#">岗位信息</a>
			</li>
		</ul>
	</div>


	<div class="span4">
		<div class="form-horizontal" role="form">
			<div class="control-group">
				<label for="inputName" class="col-lg-5 control-label">
					岗位编号
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="search-postid"
						placeholder="岗位编号" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					岗位名称
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="search-postname"
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
					<input type="text" class="form-control" id="search-postctn"
						placeholder="岗位职责" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					所属部门
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="search-postdeptid"
						placeholder="所属部门" />
				</div>
			</div>
		</div>
	</div>

	<!--  span4 -->
	<div class="span8">
		<br></br>
	</div>

	<div class="span8">
		<button id="btn-download-post" type="button"
			class="btn span2 pull-right">
			<i class="icon-arrow-down "></i>导出
		</button>
		<button type="submit" class="btn btn-success span2 pull-right">
			<i class="icon-search icon-white"></i>查询需求
		</button>
	</div>
	<div class="span8">
		<legend>&nbsp;</legend>
	</div>
</form>
