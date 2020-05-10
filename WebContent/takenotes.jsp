<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,nano.cat.bean.Notes,nano.cat.dao.notesdao"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>我的笔记</title>
	<link rel="stylesheet" href="css/table.css">
	<link rel="stylesheet" href="css/takenotes.css">
	<style type="text/css">
	</style>
</head>
<body>

	<!-- 两个选项 -->
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
	</div>
		
	
		<div id="notes">
			<h1>写笔记
				<span>你好<%=session.getAttribute("username") %>! 在这里记录你的笔记</span>
			</h1>
		    
		    <p id="msg" style="color:red;font-size:12px"> <%=request.getAttribute("msg") %> | <a href="welcome.jsp">返回首页</a></p>
		    <form action="takenotesServlet" method="post">

		        <label for="Title">笔记标题:
		        	<input type="text" id="Title" name="Title" placeholder="输入标题..." required="required" >
				</label>
				
		        <label for="Content">笔记内容: 
		            <textarea id="Content" name="Content" placeholder="在此输入内容..." required="required"></textarea>
		        </label>
		
		        <input type="submit" value="提交笔记">
		        
		    </form>
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