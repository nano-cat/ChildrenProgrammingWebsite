<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>更改密码</title>
	<link rel="stylesheet" href="css/login.css">
	<style type="text/css">
	</style>
</head>
<body>
 		<!--登陆框-->
		<div id="login">
		    <h2>更改 <%=session.getAttribute("username") %> 的密码: </h2>
		    <p id="msg" style="color:red;font-size:12px"> <%=request.getAttribute("msg") %>  | <a href="welcome.jsp">返回首页</a> </p>
		    <form action="changePasswordServlet" method="post">
		    
		        <label for="Password">输入原密码:
		        	<input type="text" id="Password" name="OldPassword" placeholder="请输入原密码..." required="required" autofocus>
				</label>
				
		        <label for="Password">新密码密码:
		            <input type="password" id="NewPassword" name="NewPassword" placeholder="输入新密码..." required="required">
		        </label>
		        
		        <label for="Password">确认密码
		            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="再次输入密码..." required="required" onkeyup="validate()">
		        </label>
		        
		        <span id="checkPwdMsg" style="color:red;font-size:12px"></span>

		        <input type="submit" id="key" value="更改密码" >
		        
		    </form>
		</div>
		
			<script type="text/javascript">
			
			if(<%=request.getAttribute("msg") %> == null){
				document.getElementById('msg').style.display = "none";
			}else{
				document.getElementById('msg').style.display = "inline";
			}
			function validate(){
				var pwd1 = document.getElementById("NewPassword").value;
				var pwd2 = document.getElementById("confirmPassword").value;
				
	              if(pwd1 == pwd2) {
	                  document.getElementById("checkPwdMsg").innerHTML="<font color='green'>密码已确认</font>";
	                  document.getElementById("key").style.display = "inline";
	              }
	              else {
	                  document.getElementById("checkPwdMsg").innerHTML="<font color='red'>输入的密码不相同</font>";
	                document.getElementById("key").style.display = "none";
	              }
	         }
			
			</script>
</body>
</html>