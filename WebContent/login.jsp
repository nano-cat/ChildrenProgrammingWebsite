<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户登陆</title>
	<link rel="stylesheet" href="css/login.css">
	<style type="text/css">
	</style>
</head>
<body>
 		<!--登陆框-->
		<div id="login">
		    <h2>少儿编程 - 用户登入</h2>
		    
		    <p id="msg" style="color:red;font-size:12px"> <%=request.getAttribute("msg") %>  | <a href="regist.jsp">注册一个账号</a> </p>
		    
		    <form action="LoginServlet" method="post">
		    
		        <label for="UserName">用户名
		        	<input type="text" id="UserName" name="UserName" placeholder="请输入用户名..." required="required" autofocus>
				</label>
				
		        <label for="Password">密码
		            <input type="password" id="Password" name="Password" placeholder="密码..." required="required">
		        </label>
		
		        <label for="UserType">用户类型
		            <select id="UserType" name="UserType">
		                <option value="user">普通用户</option>
		                <option value="admin">管理员</option>
		            </select>
		        </label>
		
		        <input type="submit" value="登入">
		        
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