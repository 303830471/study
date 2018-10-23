<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>易说课堂</title>

</head>
<body>
	<div style="text-align:center"><img src="/study/static/index.png">
	</div>
	
	<form id="loginForm" action="OperateUser" method="post">
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
        <button id="btn" class="submit block" data-icon="key">登录</button>
        <button id="createbtn" class="submit block" data-icon="key">注册</button>
     </form>
</body>
</html>