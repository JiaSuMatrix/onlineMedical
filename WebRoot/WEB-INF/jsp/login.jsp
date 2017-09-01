<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        		<c:if test="${isPatient==null }">
                	<h2 id="h2">医生登录</h2>
	                <a class="forget" href="${pageContext.request.contextPath}/patientLoginPage.action?isPatient=isPatient">不是医生？患者登录</a>
	                <form action="${pageContext.request.contextPath}/doctorLogin.action" method="POST">
	                    <input type="text" placeholder="请输入用户名" id="user" name="doctor.username" value="${username }"/>
	                    <input type="password" placeholder="请输入密码" id="password" name="doctor.password"/>
	                    <input type="checkbox" id="checkbox" name="checkbox"/>
	                    <span class="remember">下次自动登录</span>
	                    <input type="submit" value="登录" id="submit" name="submit"/>
	                </form>
                </c:if>
                
                <c:if test="${isPatient!=null }">
                	<h2 id="h2">患者登录</h2>
                	<a class="forget" href="${pageContext.request.contextPath}/doctorLoginPage.action">不是患者？医生登录</a>
	                <form action="${pageContext.request.contextPath}/patientLogin.action" method="POST">
	                    <input type="text" placeholder="请输入用户名" id="user" name="patient.username" value="${username }"/>
	                    <input type="password" placeholder="请输入密码" id="password" name="patient.password"/>
	                    <input type="checkbox" id="checkbox" name="checkbox"/>
	                    <span class="remember">下次自动登录</span>
	                    <input type="submit" value="登录" id="submit" name="submit"/>
	                </form>
                </c:if>
    		</div>
        </div>
        <div id="loginfooter">
        	
        </div>
	</div>
</body>
</html>
