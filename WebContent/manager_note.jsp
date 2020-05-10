<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,nano.cat.bean.Notes,nano.cat.dao.notesdao"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>后台管理-管理笔记</title>
	<link rel="stylesheet" href="css/table.css">
	<link rel="stylesheet" href="css/button.css">
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
			<div id="table_title">用户笔记</div>
			<p id="msg" style="color:red;font-size:12px"> <%=request.getAttribute("msg") %> </p>
			<table>
				<thead>
					<tr>
						<td class="table_head">笔记ID</td>
						<td class="table_head">用户名</td>
						<td class="table_head">标题</td>
						<td class="table_head">内容</td>
						<td class="table_head">创建时间</td>
						<td class="table_head">操作</td>
					</tr>
				</thead>
				<tbody>
					
					<%			//判断是否登陆
					if(session.getAttribute("username") != null){
						//判断是否是管理员
						if(session.getAttribute("username").equals("nanocat")){	
	
							List<Notes> list = new notesdao().getAllNotes();
							for(Notes notes: list){
								%>
									<tr>
										<td><%=notes.getNoteId() %></td>
										<td><%=notes.getUserName() %></td>
										<td><%=notes.getTitle() %></td>
										<td><%=notes.getContent() %></td>
										<td><%=notes.getCreateDate() %></td>
										<td>
											<form action="deleteNoteServlet" method="post">
												<button class="button" name="Delete" type="submit" value="<%=notes.getNoteId() %>">删除笔记</button>
											</form>	
										</td>
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
	<script type="text/javascript">
			
			if(<%=request.getAttribute("msg") %> == null){
				document.getElementById('msg').style.display = "none";
			}else{
				document.getElementById('msg').style.display = "inline";
			}
			
			
	</script>
</body>
</html>