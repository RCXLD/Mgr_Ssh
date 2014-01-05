$(document).ready(function() {
	oDeptTable.fnDraw();
});

$("#btn-download-dept").click(function() {
	window.location.href = "dept!export";
});

NavBar.setActive("navbar-hr");

$('#left-menu a').click(function(e) {
	e.preventDefault();
	$(this).tab('show');
})

function searchdept() {
	oDeptTable.fnDraw();
	return false;
}

function adddept() {
	var deptid = $("#txt-deptid").val();
	var deptname = $("#txt-deptname").val();
	var deptmgr = $("#txt-deptmgr").val();
	var deptparent = $("#txt-deptparent").val();

	$.post("dept!add", {
		"dept.deptid" : deptid,
		"dept.deptname" : deptname,
		"dept.deptmgr" : deptmgr,
		"dept.deptparent" : deptparent
	}, function(data) {
		var info = data.addInfo;
		if (info == "AddSuccess") {
			alert("添加成功");
			oDeptTable.fnDraw();
			$("#a-client-search").click();
		} else {
			alert("添加失败");
		}
	}, "json");
	// oDeptTable.fnDraw();
	return false;
}

function setdept(dept) {
	var id = $("#edit-did").val(dept.id);
	var deptid = $("#edit-deptid").val(dept.deptid);
	var deptname = $("#edit-deptname").val(dept.deptname);
	var deptmgr = $("#edit-deptmgr").val(dept.deptmgr);
	var deptparent = $("#edit-deptparent").val(dept.deptparent);
}

function clearedit() {
	var id = $("#edit-did").val("");
	var deptid = $("#edit-deptid").val("");
	var deptname = $("#edit-deptname").val("");
	var deptmgr = $("#edit-deptmgr").val("");
	var deptparent = $("#edit-deptparent").val("");
}

function editdept() {
	var id = $("#edit-did").val();
	var deptid = $("#edit-deptid").val();
	var deptname = $("#edit-deptname").val();
	var deptmgr = $("#edit-deptmgr").val();
	var deptparent = $("#edit-deptparent").val();

	$.post("dept!edit", {
		"newDept.id" : id,
		"newDept.deptid" : deptid,
		"newDept.deptname" : deptname,
		"newDept.deptmgr" : deptmgr,
		"newDept.deptparent" : deptparent
	}, function(data) {
		var info = data.editInfo;
		if (info == "EditSuccess") {
			alert("修改成功");
			$("#a-client-search").click();
			oDeptTable.fnDraw();
		} else {
			alert("修改失败");
		}
		clearedit();
	}, "json");
	return false;
}

var oDeptTable = $("#DeptList")
		.dataTable(
				{
					"sAjaxSource" : "dept!list",
					"aoColumns" : [ {
						"mData" : "deptid"
					}, {
						"mData" : "deptname"
					}, {
						"mData" : "deptmgr"
					}, {
						"mData" : "deptparent"
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
						"aTargets" : [ 4 ],
						"fnCreatedCell" : function(nTd, sData, oData, iRow,
								iCol) {
							var btn_edit = $('<button style="margin: 0">详情</button>');
							btn_edit.button();
							btn_edit.on('click', function() {
								setdept(oData);
								$("#a-client-update").click();
								return false;
							});
							var btn_del = $('<button id="btn-del" style="margin: 0">删除</button>');
							btn_del.on('click', function(e) {
								var c = confirm("确认删除么？");
								if (c == true) {
									$.post("dept!delete?index=" + iRow, {},
											function(data) {
												var info = data.deleteInfo;
												if (info == "DeleteSuccess") {
													oDeptTable.fnDraw();
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
		"name" : "searchDeptid",
		"value" : $("#search-deptid").val()
	}, {
		"name" : "searchDeptname",
		"value" : $("#search-deptname").val()
	}, {
		"name" : "searchDeptmgr",
		"value" : $("#search-deptmgr").val()
	}, {
		"name" : "searchDeptparent",
		"value" : $("#search-deptparent").val()
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
