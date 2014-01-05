$(document).ready(function() {
	oDeptTable.fnDraw();
});

$("#btn-download-post").click(function() {
	window.location.href = "post!export";
});

NavBar.setActive("navbar-hr");

$('#left-menu a').click(function(e) {
	e.preventDefault();
	$(this).tab('show');
})

function searchpost() {
	oPostTable.fnDraw();
	return false;
}

function addpost() {
	var postid = $("#txt-postid").val();
	var postname = $("#txt-postname").val();
	var postctn = $("#txt-postctn").val();
	var postdeptid = $("#txt-postdeptid").val();
	$.post("post!add", {
		"post.postid" : postid,
		"post.postname" : postname,
		"post.postctn" : postctn,
		"post.deptid" : postdeptid
	}, function(data) {
		var info = data.addInfo;
		if (info == "AddSuccess") {
			alert("添加成功");
			oPostTable.fnDraw();
			$("#a-post-search").click();
		} else {
			alert("添加失败");
		}
	}, "json");
	// oPostTable.fnDraw();
	return false;
}

function setpost(post) {
	var id = $("#edit-pid").val(post.id);
	var postid = $("#edit-postid").val(post.postid);
	var postname = $("#edit-postname").val(post.postname);
	var postctn = $("#edit-postctn").val(post.postctn);
	var postdeptid = $("#edit-postdeptid").val(post.postdeptid);
}

function clearpost() {
	var id = $("#edit-pid").val("");
	var postid = $("#edit-postid").val("");
	var postname = $("#edit-postname").val("");
	var postctn = $("#edit-postctn").val("");
	var postdeptid = $("#edit-postdeptid").val("");
}

function editpost() {
	var id = $("#edit-pid").val();
	var postid = $("#edit-postid").val();
	var postname = $("#edit-postname").val();
	var postctn = $("#edit-postctn").val();
	var postdeptid = $("#edit-postdeptid").val();

	$.post("post!edit", {
		"newPost.id" : id,
		"newPost.postid" : postid,
		"newPost.postname" : postname,
		"newPost.postctn" : postctn,
		"newPost.deptid" : postdeptid
	}, function(data) {
		var info = data.editInfo;
		if (info == "EditSuccess") {
			alert("修改成功");
			$("#a-post-search").click();
			oPostTable.fnDraw();
		} else {
			alert("修改失败");
		}
		clearpost();
	}, "json");
	return false;
}

var oPostTable = $("#PostList")
		.dataTable(
				{
					"sAjaxSource" : "post!list",
					"aoColumns" : [ {
						"mData" : "postid"
					}, {
						"mData" : "postname"
					}, {
						"mData" : "postctn"
					}, {
						"mData" : "postdeptid"
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
								setpost(oData);
								$("#a-post-update").click();
								return false;
							});
							var btn_del = $('<button id="btn-del" style="margin: 0">删除</button>');
							btn_del.on('click', function(e) {
								var c = confirm("确认删除么？");
								if (c == true) {
									$.post("post!delete?index=" + iRow, {},
											function(data) {
												var info = data.deleteInfo;
												if (info == "DeleteSuccess") {
													oPostTable.fnDraw();
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
		"name" : "searchPostid",
		"value" : $("#search-postid").val()
	}, {
		"name" : "searchPostname",
		"value" : $("#search-postname").val()
	}, {
		"name" : "searchPostctn",
		"value" : $("#search-postctn").val()
	}, {
		"name" : "searchPostdeptid",
		"value" : $("#search-postdeptid").val()
	});
	$.ajax( {
		type : "POST",
		url : sSource,
		dataType : "json",
		data : "jsonpost=" + JSON.stringify(aoData),
		success : function(data) {
			fnCallback(data);
		}
	});
}
