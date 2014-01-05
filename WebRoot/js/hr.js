$(document).ready(function() {
	oTable.fnDraw();
});

$("#btn-download").click(function() {
	window.location.href = "emp!export";
});

NavBar.setActive("navbar-hr");

$('#left-menu a').click(function(e) {
	e.preventDefault();
	$(this).tab('show');
})

function search() {
	oTable.fnDraw();
	return false;
}

function statistics() {
	countTable.fnDraw();
	return false;
}

function addemp() {
	var empid = $("#txt-empid").val();
	var empname = $("#txt-empname").val();
	var icid = $("#txt-icid").val();
	var empphone = $("#txt-empphone").val();
	var empbirth = $("#txt-empbirth").val();

	var nplace = $("#txt-nplace").val();
	var empsex = $("input[name='txt-empsex']:checked").val() == 0 ? '男' : '女';
	var empedu = $("#select-empedu").val();
	var empqq = $("#txt-empqq").val();
	var empaddr = $("#txt-empaddr").val();

	var deptid = $("#txt-deptid").val();
	var emppost = $("#txt-emppost").val();
	var elinkman = $("#txt-elinkman").val();
	var elinkphone = $("#txt-elinkphone").val();
	var empin = $("#txt-empin").val();
	var empout = $("#txt-empout").val();

	$.post("emp!add", {
		"emp.empid" : empid,
		"emp.empname" : empname,
		"emp.icid" : icid,
		"emp.empphone" : empphone,
		"emp.empbirth" : empbirth,
		"emp.eplace" : nplace,
		"emp.empsex" : empsex,
		"emp.empedu" : empedu,
		"emp.empqq" : empqq,
		"emp.empaddr" : empaddr,

		"emp.deptid" : deptid,
		"emp.emppost" : emppost,
		"emp.elinkman" : elinkman,
		"emp.elinkphone" : elinkphone,
		"emp.empin" : empin,
		"emp.empout" : empout
	}, function(data) {
		var info = data.addInfo;
		if (info == "AddSuccess") {
			alert("添加成功");
			oTable.fnDraw();
			$("#a-worker-search").click();
		} else {
			alert("添加失败");
		}
	}, "json");
	oTable.fnDraw();
	return false;
}

function setemp(emp) {
	$("#edit-id").val(emp.id);
	$("#edit-empid").val(emp.empid);
	$("#edit-empname").val(emp.empname);
	$("#edit-icid").val(emp.icid);
	$("#edit-empphone").val(emp.empphone);
	$("#edit-empbirth").val(emp.empbirth);

	$("#edit-nplace").val(emp.eplace);
	var is = emp.empsex == 'true' ? 0 : 1;
	$("input[name='edit-empsex']").get(is).checked = true;
	$("#edit-empedu").val(emp.empedu);
	$("#edit-empqq").val(emp.empqq);
	$("#edit-empaddr").val(emp.empaddr);

	$("#edit-deptid").val(emp.deptid);
	$("#edit-emppost").val(emp.emppost);
	$("#edit-elinkman").val(emp.elinkman);
	$("#edit-elinkphone").val(emp.elinkphone);
	$("#edit-empin").val(emp.empin);
	$("#edit-empout").val(emp.empout);
}

function clearedit() {
	$("#edit-id").val();
	$("#edit-empid").val();
	$("#edit-empname").val();
	$("#edit-icid").val();
	$("#edit-empphone").val();
	$("#edit-empbirth").val();

	$("#edit-nplace").val();
	var is = emp.empsex == '男' ? 0 : 1;
	$("input[name='edit-empsex']").get(0).checked = true;
	$("#edit-empedu").val();
	$("#edit-empqq").val();
	$("#edit-empaddr").val();

	$("#edit-deptid").val();
	$("#edit-emppost").val();
	$("#edit-elinkman").val();
	$("#edit-elinkphone").val();
	$("#edit-empin").val();
	$("#edit-empout").val();
}

function editemp() {
	var id = $("#edit-id").val();
	var empid = $("#edit-empid").val();
	var empname = $("#edit-empname").val();
	var icid = $("#edit-icid").val();
	var empphone = $("#edit-empphone").val();
	var empbirth = $("#edit-empbirth").val();

	var nplace = $("#edit-nplace").val();
	var empsex = $("input[name='edit-empsex']").get(0).checked;
	var empedu = $("#edit-empedu").val();
	var empqq = $("#edit-empqq").val();
	var empaddr = $("#edit-empaddr").val();

	var deptid = $("#edit-deptid").val();
	var emppost = $("#edit-emppost").val();
	var elinkman = $("#edit-elinkman").val();
	var elinkphone = $("#edit-elinkphone").val();
	var empin = $("#edit-empin").val();
	var empout = $("#edit-empout").val();

	$.post("emp!edit", {
		"newEmp.id" : id,
		"newEmp.empid" : empid,
		"newEmp.empname" : empname,
		"newEmp.icid" : icid,
		"newEmp.empphone" : empphone,
		"newEmp.empbirth" : empbirth,
		
		"newEmp.eplace" : nplace,
		"newEmp.empsex" : empsex,
		"newEmp.empedu" : empedu,
		"newEmp.empqq" : empqq,
		"newEmp.empaddr" : empaddr,

		"newEmp.deptid" : deptid,
		"newEmp.emppost" : emppost,
		"newEmp.elinkman" : elinkman,
		"newEmp.elinkphone" : elinkphone,
		"newEmp.empin" : empin,
		"newEmp.empout" : empout,

	}, function(data) {
		var info = data.editInfo;
		if (info == "EditSuccess") {
			alert("修改成功");
			$("#a-worker-search").click();
			oTable.fnDraw();
		} else {
			alert("修改失败");
		}
		clearedit();
	}, "json");
	return false;
}

var oTable = $("#EmpList")
		.dataTable(
				{
					"sAjaxSource" : "emp!list",
					"aoColumns" : [ {
						"mData" : "empid"
					}, {
						"mData" : "empname"
					}, {
						"mData" : "icid"
					}, {
						"mData" : "deptid"
					}, {
						"mData" : "emppost"
					}, {
						"mData" : "id"
					} ],
					"bProcessing" : true,
					"bServerSide" : true,
					"fnServerData" : retrieveData,
					"bFilter" : true,
					"bSort" : true,
					"bStateSave" : false,
					"sPaginationType" : "full_numbers",
					"oLanguage" : {
						"sLengthMenu" : "每页显示 _MENU_ 条记录",
						"sZeroRecords" : "抱歉， 没有记录",
						"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
						"sInfoEmpty" : "没有数据",
						"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
						"oPaginate" : {
							"sFirst" : "首页",
							"sPrevious" : "前一页",
							"sNext" : "后一页",
							"sLast" : "尾页"
						},
						"sSearch" : "搜索：",
						"sProcessing" : "正在加载数据..."
					},
					"aoColumnDefs" : [ {
						"aTargets" : [ 5 ],
						"fnCreatedCell" : function(nTd, sData, oData, iRow,
								iCol) {
							var btn_edit = $('<button style="margin: 0">详情</button>');
							btn_edit.button();
							btn_edit.on('click', function() {
								setemp(oData);
								$("#a-worker-modify").click();
								return false;
							});
							var btn_del = $('<button id="btn-del" style="margin: 0">删除</button>');
							btn_del.on('click', function(e) {
								var c = confirm("确认删除么？");
								if (c == true) {
									$.post("emp!delete?index=" + iRow, {},
											function(data) {
												var info = data.deleteInfo;
												if (info == "DeleteSuccess") {
													oTable.fnDraw();
													alert("删除成功");
												} else {
													alert("删除失败");
												}
											}, "json");
								} else {
								}
								return false;
							});
							$(nTd).empty();
							$(nTd).prepend(btn_edit);
							$(nTd).prepend(btn_del);
						}
					} ]
				});

function retrieveData(sSource, aoData, fnCallback) {
	aoData.push( {
		"name" : "searchEmpid",
		"value" : $("#search-empid").val()
	}, {
		"name" : "searchEmpname",
		"value" : $("#search-empname").val()
	}, {
		"name" : "searchDeptid",
		"value" : $("#search-deptid").val()
	}, {
		"name" : "searchIcid",
		"value" : $("#search-icid").val()
	});
	$.ajax( {
		type : "POST",
		url : sSource,
		dataType : "json",
		data : "jsonparam=" + JSON.stringify(aoData),
		success : function(data) {
			fnCallback(data);
		}
	});
}
