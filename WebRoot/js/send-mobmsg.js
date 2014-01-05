var phonesRegex = /^(1[0-9]{10})(,(1[0-9]{10}))*$/;

function validateMobphones() {
	var phones = $("#txt-mobphones").val();
	if (phones == "") {
		$("#info-mobphones").css("color", "red").text("手机号码不能为空");
	} else if (!phonesRegex.test(phones)) {
		$("#info-mobphones").css("color", "red").text("号码输入格式错误");
	} else {
		$("#info-mobphones").css("color", "green").text("您的输入格式正确");
		return true;
	}
	return false;
}

function validateMsgContent() {
	var msgused = calculate_char($("#txt-mobcontent").val());
	$("#txt-msgused").val(msgused);
	var msgtotal = $("#txt-msgtotal").val();
	var msgremain = msgtotal - msgused;
	if (msgremain == msgtotal) {
		$("#info-mobcontent").css("color", "red").text("短信内容不能为空");
		$("#txt-msgremain").val(msgtotal);
	} else if (msgremain < 0) {
		$("#txt-msgremain").val(0);
		$("#info-mobcontent").css("color", "red").text(
				"您已经超出" + (-remain) + "字，请适当删减。");
	} else {
		$("#txt-msgremain").val(msgremain);
		$("#info-mobcontent").css("color", "green").text(
				"您已经输入" + msgused + "字符");
		return true;
	}
	return false;
}

function sendBdMsg() {
	var check = checkContent();
	if (check) {
		$.post("/bnss/msg/msg!sendBDMsg", {
			"bdcard" : $("#bdcard").val(),
			"msgcontent" : $("#msgcontent").val()
		}, function(data) {
			if (!data.sendBDResult) {
				$("#info-status").css("color", "red").text("发送失败，请检查您的输入。");
			} else {
				$("#info-status").css("color", "green").text("发送成功");
				res = true;
			}
		}, "json");
	}
	return false;
}

$(function() {
	$("#form-mobmsg").submit(
			function() {
				var validate_phones = validateMobphones();
				var validate_content = validateMsgContent();
				var validate = validate_phones && validate_content;
				if (validate) {
					$("#info-sendmobmsg").css("color", "green");
					$("#info-sendmobmsg").text("正在发送...");
					$("#btn-sendmobmsg").attr({"disabled":"disabled"});
					var msgrecvers = $("#txt-mobphones").val();
					var msgcontent = $("#txt-mobcontent").val();
					$.post("/bnss/msg/msg!sendMobMsg", {
						"msgrecvers" : msgrecvers,
						"msgcontent" : msgcontent
					}, function(data) {
						var result = data.sendMobResult;
						if (!result) {
							$("#info-sendmobmsg").css("color", "red").text(
									"发送失败，请检查您的输入。");
						} else {
							$("#info-sendmobmsg").css("color", "green").text(
									"发送成功");
						}
						$("#btn-sendmobmsg").removeAttr("disabled");
					}, "json");
				}
				return false;
			});
});

function calculate_char(sTargetStr) {
	var sTmpStr, sTmpChar;
	var nOriginLen = 0;
	var nStrLength = 0;

	sTmpStr = new String(sTargetStr);
	nOriginLen = sTmpStr.length;

	for ( var i = 0; i < nOriginLen; i += 1) {
		sTmpChar = sTmpStr.charAt(i);
		if (escape(sTmpChar).length > 4) {
			nStrLength += 2;
		} else if (sTmpChar != '\r') {
			nStrLength += 1;
		}
	}
	return nStrLength;
}