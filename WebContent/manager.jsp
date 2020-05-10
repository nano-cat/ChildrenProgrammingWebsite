<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>后台管理</title>
	<link rel="stylesheet" href="css/table.css">
	<style type="text/css">
	</style>
</head>
<body>

	<!-- 选项 -->
	<div id="main">
		<div id="cho_btn">
			<a href="welcome.jsp">
				<div class="cho_opt cho_opt2" style=" background-color: #fcf8e3">
					<span ><img src="img/back.png"></span>
					<div class="describ">返回首页</div>
				</div>
			</a>
			<a href="manager_user.jsp">
				<div class="cho_opt cho_opt2" style=" background-color: #a94442">
					<span ><img src="img/user.png"></span>
					<div class="describ">管理用户</div>
				</div>
			</a>
			<a href="manager_note.jsp">
				<div class="cho_opt cho_opt2">
					<span ><img src="img/mynote.png"></span>
					<div class="describ">管理用户笔记</div>
				</div>
			</a>
			<a href="manager_fankui.jsp">
				<div class="cho_opt cho_opt4">
					<span ><img src="img/notes.png"></span>
					<div class="describ">查看反馈建议</div>
				</div>
			</a>
		</div>
		
		<%			//判断是否登陆
					if(session.getAttribute("username") != null){
						//判断是否是管理员
						if(session.getAttribute("username").equals("nanocat")){
							%>
							<h2> 请选择上面的管理类型 </h2>
							<%
						}else{
							%>
								<h2> 警告: 您不是管理员! 无法操作! <a href="login.jsp">以管理员登陆</a> </h2>
							<%
						}
					}else{
						%>
							<h2> 警告: 非法操作! 未登陆进入后台! <a href="login.jsp">以管理员登陆</a> </h2>
						<%
					}
					%>
		
	</div>

</body>
</html>