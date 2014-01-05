<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<legend>
<form id="form-statistics" class="form-inline" method="post" onsubmit="return statistics()">
	<label>部门名称</label>
	<input type="text" id="statistics-deptid" name="statistics-deptid" />
	<button id="btn-statistics" type="submit" class="btn btn-success">
		<i class="icon-search icon-white"></i> 统计查询
	</button>
</form>
</legend>

<!--  span4 -->
<table id="StatisticsList"
	class="table table-condensed table-hover table-striped">
	<thead>
		<tr>
			<th>
				部门名称
			</th>
			<th>
				正式员工
			</th>
			<th>
				派遣员工
			</th>
			<th>
				男
			</th>
			<th>
				女
			</th>
			<th>
				本科及以上
			</th>
			<th>
				大专
			</th>
			<th>
				大专以下
			</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>