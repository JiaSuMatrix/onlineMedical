<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
<link href="css/index.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	<div id = "wrapper">
		<div id="header">
        	<p id="intro">
            	无需等待，在线预约
            </p>
             <div id="rl">
            	<a href="${pageContext.request.contextPath}/doctorRegisterPage.action">医生注册</a>|<a href="${pageContext.request.contextPath}/patientRegisterPage.action">患者注册</a>
            </div>
        </div>
        <div id="logincontent">
        	<div id="login">
                <h2 id="h2">用户登录</h2>
                <a class="forget" href="javascript:;">忘记密码？</a>
                <form action="">
                    <input type="text" placeholder="请输入用户名" id="user" name="user" value="${username }"/>
                    <input type="password" placeholder="请输入密码" id="password" name="password"/>
                    <input type="checkbox" id="checkbox" name="checkbox"/>
                    <span class="remember">下次自动登录</span>
                    <input type="submit" value="登录" id="submit" name="submit"/>
                </form>
    		</div>
        </div>
        <div id="loginfooter">
        	
        </div>
	</div>
</body>
</html>
