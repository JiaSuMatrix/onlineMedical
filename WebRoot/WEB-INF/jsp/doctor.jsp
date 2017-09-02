<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!Doctype html>
<html>
<head>
<meta charset="utf-8">
<title>个人中心</title>
<link href="${pageContext.request.contextPath}/css/personal.css"rel="stylesheet" type="text/css"/>
</head>

<body>
	<div id = "wrapper">
		<div id="header">
        	<p id="intro">
            	无需等待，在线预约
            </p>
            <div id="message">
            	<a href="javascript:;">预约消息</a>
            </div>
        </div>
        <div id="content">
        	<h2 id="h2">个人信息</h2>
            <div id="personalMessage">  
                <form action="">
                   <table id="personalTable">
                    <tr>
                        <td class="td">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
                        <td class="td1">${ doctor.username}</td>
                    </tr>
                    <tr>
                        <td class="td">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:</td>
                        <td class="td1">${doctor.age }</td>
                    </tr>
                    <tr>
                        <td class="td">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机:</td>
                        <td class="td1">${doctor.phone }</td>
                    </tr>
                    <tr>
                        <td class="td">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</td>
                        <td class="td1">${doctor.mail }</td>
                    </tr>
                    <tr>
                        <td class="td">所属医院:</td>
                        <td class="td1">${doctor.hospital.name }</td>
                    </tr>
                    <tr>
                        <td class="td">个人简介:</td>
                        <td></td>
                    </tr>
                   </table>
                </form>
                <div id="edit">
            		<a href="">编辑完善信息>></a>
            	</div>
            </div>
        </div>
        <div id="footer">
        	
        </div>
	</div>
</body>
</html>
