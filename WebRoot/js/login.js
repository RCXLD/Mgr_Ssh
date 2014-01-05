function validateUserid(){
	var validate = false;
	var userid = $("#txt-userid").val();
	if(userid == "") {
		$("#info-login").css("color", "red").text("账户不能为空");
	} else {
		$("#info-login").css("color", "green").text("");
		validate = true;
	}
	return validate;
}

function validateUserpwd() {
	var validate = false;
	var userpwd = $("#txt-userpwd").val();
	if(userpwd == "") {
		$("#info-login").css("color", "red").text("密码不能为空");
	} else {
		$("#info-login").css("color", "green").text("");
		validate = true;
	}
	return validate;
}

function login() {
	var validate_userid = validateUserid();
	if(!validate_userid) {
		return false;
	}
	var validate_userpwd = validateUserpwd();
	if(!validate_userpwd) {
		return false;
	}
	$("#info-login").text("");
	var userid = $("#txt-userid").val();
	var userpwd = $("#txt-userpwd").val();
	$.post("user!login", {
		"user.userid" : userid,
		"user.userpwd" : userpwd
	},function(data) {
		var info = data.loginInfo;
		if(info == "LoginSuccess") {
			window.location.href = "hr";
		} else if(info == "Error") {
			$("#info-login").css("color", "red").text("系统出错");
		} else {
			$("#info-login").css("color", "red").text(info);
		}
	}, "json");
	return false;
}