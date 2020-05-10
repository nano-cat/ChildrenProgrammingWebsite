<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户建议与反馈</title>
	<link rel="stylesheet" href="css/fankui.css">
	<style type="text/css">

	</style>

</head>
<body>
	
	
		<div id="fankui">
			<h1>用户反馈与建议
				<span>你好<%=session.getAttribute("username") %>! 向管理员反馈您遇到的问题或者您的想法</span>
			</h1>
		    
		    <p id="msg" style="color:red;font-size:12px"> <%=request.getAttribute("msg") %> | <a href="welcome.jsp">返回首页</a></p>
		    <form action="fankuiServlet" method="post">
		    
		    	<label for="email">您的邮箱:
		        	<input type="text" id="Email" name="Email" placeholder="输入邮箱..." required="required" autofocus>
				</label>
				
		        <label for="Title">标题:
		        	<input type="text" id="Title" name="Title" placeholder="输入标题..." required="required" >
				</label>
				
		        <label for="Content">内容: 
		            <textarea id="Content" name="Content" placeholder="在此输入内容..." required="required"></textarea>
		        </label>
		
		        <input type="submit" value="提交反馈建议">
		        
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