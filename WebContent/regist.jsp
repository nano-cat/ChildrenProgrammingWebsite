<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户注册</title>
	<link rel="stylesheet" href="css/regist.css">
	<style type="text/css">
	</style>
</head>
<body >
 		<!--注册框-->
		<div id="regist">
		    <h2>少儿编程 - 用户注册</h2>
		    <p id="msg" style="color:red;font-size:12px" > <%=request.getAttribute("msg") %>  | <a href="login.jsp">返回登陆</a> </p>
		    
		    <form action="RegistServlet" method="post">
		    
		        <label for="UserName">用户名
		        	<input type="text" id="UserName" name="UserName" placeholder="请输入注册用户名..." required="required" autofocus>
				</label>
				
		        <label for="Password">密码
		            <input type="password" id="Password" name="Password" placeholder="请输入密码..." required="required">
		        </label>
		        
		        <label for="Password">确认密码
		            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="再次输入密码..." required="required" onkeyup="validate()">
		        </label>
		        <span id="checkPwdMsg" style="color:red;font-size:12px"></span>

		        <input type="submit" id="key" value="点我注册" >
		        
		    </form>
		</div>
		
			<script type="text/javascript">

			if(<%=request.getAttribute("msg") %> == null){
				document.getElementById('msg').style.display = "none";
			}else{
				document.getElementById('msg').style.display = "inline";
			}
			
			
			function validate(){
				var pwd1 = document.getElementById("Password").value;
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