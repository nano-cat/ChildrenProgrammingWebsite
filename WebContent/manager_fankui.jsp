<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,nano.cat.bean.Fankui,nano.cat.dao.fankuidao" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>后台管理-查看反馈建议</title>
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
		
				
		<!-- 列表 -->
		<div id="user_list" style="display:block;">
			<div id="table_title">用户留言与反馈</div>
			<table>
				<thead>
					<tr>
						<td class="table_head" style="width: 8%">留言编号</td>
						<td class="table_head" style="width: 10%">留言者</td>
						<td class="table_head" style="width: 15%">邮箱</td>
						<td class="table_head" style="width: 25%">留言标题</td>
						<td class="table_head" style="width: 30%">留言内容</td>
						<td class="table_head" style="width: 12%">留言时间</td>
				</thead>
				<tbody>

					<%			//判断是否登陆
					if(session.getAttribute("username") != null){
						//判断是否是管理员
						if(session.getAttribute("username").equals("nanocat")){	
	
							List<Fankui> list = new fankuidao().getAllFankui();
							for(Fankui notes: list){
								%>
									<tr>
										<td><%=notes.getLwId() %></td>
										<td><%=notes.getUserName() %></td>
										<td><%=notes.getEmail() %></td>
										<td><%=notes.getTitle() %></td>
										<td><%=notes.getContent() %></td>
										<td><%=notes.getSendTime() %></td>
								<%
							}
						
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
					
				</tbody>
			</table>

		</div>
		
	</div>

</body>
</html>