<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>在线医疗</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	<div id = "wrapper">
		<div id="header">
        	<p id="intro">
            	无需等待，在线预约
            </p>
             <div id="rl">
           
            <c:if test="${doctor == null && patient == null }"><a href="${pageContext.request.contextPath}/doctorLoginPage.action">登录</a>|<a href="${pageContext.request.contextPath}/doctorRegisterPage.action">医生注册</a>|<a href="${pageContext.request.contextPath}/patientRegisterPage.action">患者注册</a></c:if>
            <c:if test="${doctor != null }"><a href="${pageContext.request.contextPath}/indexToDoctor.action">${doctor.username }的个人中心</a>|<a href="${pageContext.request.contextPath}/doctorLogout.action">注销</a></c:if>
            <c:if test="${patient != null }"><a href="${pageContext.request.contextPath}/indexToPatient.action">${patient.username }的个人中心</a>|<a href="${pageContext.request.contextPath}/patientLogout.action">注销</a></c:if>
            </div>
        </div>
        <div id="content">
        	<div id="img">
            	<img src="${pageContext.request.contextPath}/images/logo.png"/>
            </div>
            <h1>足不出户，在线预约</h1>
            <div id="search">
            	<form action="${pageContext.request.contextPath}/search.action" method="POST">
                	<input id="input" type="text" placeholder="输入医院名称、医生姓名、病情搜索" name="name"/>
                    <input id="submitName" type="submit" value=""/>
                </form>
            </div>
        </div>
        <div id="footer">
        	<div>
                <h2>热门医生</h2>
                <ul>
                    <li><a href="">张三</a></li>
                    <li><a href="">张三</a></li>
                    <li><a href="">张三</a></li>
                    <li><a href="">张三</a></li>
                    <li><a href="">张三</a></li>
                </ul>
            </div>
            <div>
                <h2>热门医院</h2>
                <ul>
                    <li><a href="">浙江省第一医院</a></li>
                    <li><a href="">浙江省第一医院</a></li>
                    <li><a href="">浙江省第一医院</a></li>
                    <li><a href="">浙江省第一医院</a></li>
                    <li><a href="">浙江省第一医院</a></li>
                </ul>
            </div>
            <div>
                <h2>热门疾病</h2>
                <ul>
                    <li><a href="">感冒</a></li>
                    <li><a href="">感冒</a></li>
                    <li><a href="">感冒</a></li>
                    <li><a href="">感冒</a></li>
                    <li><a href="">感冒</a></li>
                </ul>
            </div>
        </div>
	</div>
</body>
</html>
