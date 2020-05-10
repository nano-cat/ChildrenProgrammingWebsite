<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,nano.cat.bean.Notes,nano.cat.dao.notesdao"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>我的笔记</title>
	<link rel="stylesheet" href="css/table.css">
	<style type="text/css">
	</style>
</head>
<body>

	<!-- 选项 -->
	<div id="main">
		<div id="cho_btn">
			<a href="welcome.jsp">
				<div class="cho_opt cho_opt2" style="background-color: #fcf8e3">
					<span ><img src="img/back.png"></span>
					<div class="describ">返回首页</div>
				</div>
			</a>
			<a href="usernote.jsp">
				<div class="cho_opt cho_opt2">
					<span ><img src="img/mynote.png"></span>
					<div class="describ">我的笔记</div>
				</div>
			</a>
			<a href="takenotes.jsp">
				<div class="cho_opt cho_opt4">
					<span ><img src="img/notes.png"></span>
					<div class="describ">写笔记</div>
				</div>
			</a>
		</div>
		
		<!-- 列表 -->
		<div id="user_list" style="display:block;">
			<div id="table_title">我的笔记</div>
			<table>
				<thead>
					<tr>
						<td class="table_head">笔记ID</td>
						<td class="table_head">用户名</td>
						<td class="table_head">标题</td>
						<td class="table_head">内容</td>
						<td class="table_head">创建时间</td>
						<!-- <td class="table_head">操作</td> -->
					</tr>
				</thead>
				<tbody>
					<%	

						List<Notes> list = new notesdao().getNotes((String)session.getAttribute("username"));
						for(Notes notes: list){
							%>
								<tr>
									<td><%=notes.getNoteId() %></td>
									<td><%=notes.getUserName() %></td>
									<td><%=notes.getTitle() %></td>
									<td><%=notes.getContent() %></td>
									<td><%=notes.getCreateDate() %></td>
							<%
						}
					%>
					
				</tbody>
			</table>

		</div>
	</div>

</body>
</html>