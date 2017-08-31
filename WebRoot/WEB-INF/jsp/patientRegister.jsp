<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>患者注册页面</title>
<link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	<div id = "wrapper">
		<div id="header">
        	<p id="intro">
            	无需等待，在线预约
            </p>
             <div id="rl">
            	<a href="${pageContext.request.contextPath}/doctorRegisterPage.action">医生注册</a>
            </div>
        </div>
        <div id="content">
        	<div id="login">
                <h2 id="h2">患者注册</h2>
                <form action="${pageContext.request.contextPath}/patientRegister.action" method="POST">
                    <input type="text" placeholder="请输入用户名" id="user" name="username"/>
                    <input type="password" placeholder="请输入密码" id="password" name="password"/>
                    <input type="password" placeholder="确认密码" id="repassword" name="repassword"/>
                    <input type="text" placeholder="请输入手机号" id="phone" name="phone"/>
                    <input type="submit" value="注册" id="submit" name="submit"/>
                </form>
    		</div>
        </div>
        <div id="footer">
        	
        </div>
	</div>
</body>
</html>
