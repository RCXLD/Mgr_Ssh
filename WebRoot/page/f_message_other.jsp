			<div class="main-msg">
				<div class="msg-box">
					<div class="alert alert-info">
						<h4>发送手机短信</h4>
					</div>
					<form id="form-mobmsg" method="post">
						<fieldset>
							<label class="input-label">
								手机号码：
							</label>
							<div class="msg-line">
								<textarea id="txt-mobphones" name="txt-mobphones"
									class="span9" rows=2 onblur="validateMobphones()"></textarea>
								<br />
								<p>
									<span id="info-mobphones" style="color: red"></span>
								</p>
								<p>
									<span>输入格式：多个号码请用英文逗号（,）隔开，比如：<span style="color: red">18665349901,13670174626</span>。</span>
								</p>
							</div>
							<label class="input-label">
								短信内容：
								
							</label>
							<div class="msg-line">
								<textarea id="txt-mobcontent" name="txt-mobcontent"
									class="span9" rows=5 onkeyup="validateMsgContent();"
									onkeydown="validateMsgContent()"
									onblur="validateMsgContent()"></textarea>
								<br />
								<p>
									<span id="info-mobcontent" style="color: red"></span>
								
									还可以输入
									<input id="txt-msgremain" style="width: 28px; color: red"
										name="txt-msgremain" value="105" readonly>
									个字。
									<input id="txt-msgused" name="txt-msgused" type="text" value="0"
										style="display: none" />
									<input id="txt-msgtotal" name="txt-msgtotal" type="text"
										value="105" style="display: none" />
								</p>
								
								<p>
									<span>输入说明：<span style="color: red">中文字符算作两个字</span>。</span>
								</p>
								
							</div>
							<div class="row">
								<button id="btn-sendmobmsg" type="submit" class="btn btn-success span3 pull-right">
									发送
								</button>
								<span id="info-sendmobmsg" style="color: red">${SendStatus}</span>
							</div>
						</fieldset>
					</form>
				</div>
			</div>