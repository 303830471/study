<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="/study/js/jqGrid5.2.1/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="/study/js/common.js" type="text/javascript"></script>
<title>solr</title>

</head>
<body>
	<div style="text-align:center"><img src="/study/static/index1.png">
	</div>
	
	<form id="loginForm" action="#" method="post">
     	<div>&nbsp;</div>
     	<div class="input-group">
          <div class="input-row">
              <label for="username">账号</label>
              <input type="text" name="username" id="username" placeholder="请填写登录账号">
          </div>
          <div class="input-row">
              <label for="password">密码</label>
              <input type="password" name="password" id="password" placeholder="请填写登录密码">
          </div>
      </div>
     	<div>&nbsp;</div>
        <button id="btn" class="submit block" data-icon="key" onclick="login()">登录</button>
        <button id="createbtn" class="submit block" data-icon="key" onclick="register()">注册</button>
        <div id="showMsg">
		</div>
     </form>
</body>
</html>