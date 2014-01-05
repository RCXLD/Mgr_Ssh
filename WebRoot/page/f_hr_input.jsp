<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<form id="form-addemp" method="post" onsubmit="return addemp();">

	<div class="span8">
		<ul class="nav nav-tabs">
			<li class="active tab-header">
				<a href="#">基本资料</a>
			</li>
		</ul>
	</div>

	<div class="span4">
		<div class="form-horizontal" role="form">
			<div class="control-group">
				<label for="inputEmpid" class="col-lg-5 control-label">
					员工工号
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-empid"
						placeholder="员工工号" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputName" class="col-lg-5 control-label">
					姓名
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-empname"
						placeholder="姓名" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					身份证号
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-icid"
						placeholder="身份证号" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					手机号码
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-empphone"
						placeholder="手机号" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputPassword1" class="col-lg-5 control-label">
					出生日期
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-empbirth"
						onclick="HS_setDate(this)" placeholder="出生日期" />
				</div>
			</div>
		</div>
	</div>
	<!--  span4 -->


	<div class="span4">
		<div class="form-horizontal" role="form">
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					籍贯
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-nplace"
						placeholder="籍贯" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					性别
				</label>
				<div class="controls">
					<div class="radio inline">
						<input id="check-m" type="radio" name="txt-empsex"
							checked="checked" value="0" />
						男
					</div>
					<div class="radio inline">
						<input id="check-w" type="radio" name="txt-empsex" value="1" />
						女
					</div>
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					学历
				</label>
				<div class="controls">
					<select id="select-empedu" name="select-empedu">
						<option value="博士">
							博士
						</option>
						<option value="硕士">
							硕士
						</option>
						<option value="本科">
							本科
						</option>
						<option value="本科以下">
							本科以下
						</option>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label for="inputDept" class="col-lg-5 control-label">
					QQ号码
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-empqq"
						placeholder="QQ号码" />
				</div>
			</div>
			<div class="control-group">
				<label for="inputPassword1" class="col-lg-5 control-label">
					住址
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-empaddr"
						placeholder="住址" />
				</div>
			</div>
		</div>
	</div>
	<!--  span4 -->

	<div class="span8">
		<ul class="nav nav-tabs">
			<li class="active tab-header">
				<a href="#">岗位资料</a>
			</li>
		</ul>
	</div>


	<div class="span4">
		<div class="form-horizontal" role="form">
			<div class="control-group">
				<label for="input" class="col-lg-5 control-label">
					所属部门
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-deptid"
						placeholder="所属部门">
				</div>
			</div>
			<div class="control-group">
				<label for="inputPassword1" class="col-lg-5 control-label">
					紧急联系人
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-elinkman"
						placeholder="紧急联系人">
				</div>
			</div>
			<div class="control-group">
				<label for="inputPassword1" class="col-lg-5 control-label">
					入职日期
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-empin"
						onclick="HS_setDate(this);" placeholder="入职日期" />
				</div>
			</div>
		</div>
	</div>
	<!-- span 4 -->



	<div class="span4">
		<div class="form-horizontal" role="form">
			<div class="control-group">
				<label for="inputPassword1" class="col-lg-5 control-label">
					岗位
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-emppost"
						placeholder="岗位">
				</div>
			</div>
			<div class="control-group">
				<label for="inputPassword1" class="col-lg-5 control-label">
					联系人电话
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-elinkphone"
						placeholder="联系人电话">
				</div>
			</div>
			<div class="control-group">
				<label for="inputPassword1" class="col-lg-5 control-label">
					合同期限
				</label>
				<div class="controls">
					<input type="text" class="form-control" id="txt-empout"
						onclick="HS_setDate(this)" placeholder="合同期限" />
				</div>
			</div>
		</div>

	</div>

	<div class="span8">
		<br></br>
	</div>

	<div class="span3 offset5">
		<button id="btn-empadd" type="submit"
			class="btn btn-primary btn-block">
			添加员工
		</button>
	</div>
</form>