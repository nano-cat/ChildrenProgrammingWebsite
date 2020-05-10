<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/index.css">
		<title>少儿编程</title>
		<style type="text/css">
		</style>
	</head>
	<body>
	
	<!-- 导航栏: 导航 查询(3) 登陆 注册(4)-->
	<div id="nav">
		<div id="daohang">
			<span style="background: rgb(34, 52, 72);"></span>
			<span style="background: rgb(34, 52, 72);"></span>
			<span style="background: rgb(34, 52, 72);"></span>
			  <div class="dropdown-content">
				<a href="usernote.jsp" >用户笔记</a>
				<a href="changepassword.jsp" >更改密码</a>
				<a href="#content">查看文章</a>
				<a href="#shenming">查看声明</a>
				<a href="manager.jsp" >后台管理</a>
			  </div>
		</div>
		<div id="user">
			<a href="#"><%=session.getAttribute("username") %></a>
			<span>|</span>
			<a href="quitServlet">退出</a>
		</div>
		<!--搜索-->
		<div id="search">
			<form>
				<input id="search-input" type="text" style="background-image: url('img/searchicon.png');background-size:20px 20px;" value="搜索..." onblur="if(this.value=='') value='搜索...';" onclick="if(this.value=='搜索...')value='';"/>
			</form>
		</div>	
	</div>
	
	<!--头部-->
	<div id="head">
		<div class="buju">
			<div class="key_img">
				<img src="img/key_1.png">
				<img src="img/key_2.png">
				<img src="img/key_3.png">
				<img src="img/key_4.png">
			</div>
		</div>
	</div>
	
	<!--内容显示-->
	<div id="content">
		<p class="title">编程让孩子引领数字时代</p>
		<div class="content_course">
			<!--内容-->
			
			<a href="#">
				<div class="card">
					<h2>图形化编程语言Scratch</h2>
					<br />
					<div class="card-img" style="width:60%">
						<img src="img/img1.png" width=100% height=100%>
					</div>
					<p>Scratch是一款由麻省理工学院(MIT) 设计开发的一款面向少年的简易编程工具。</p>
					<p>该工具不仅易于孩子们使用，又能寓教于乐，让孩子们获得创作中的乐趣。</p>
					<p>Scratch 的下载和使用是完全免费的，开发了Windows系统，苹果系统，Linux系统下运行的版本。 </p>
				</div>
			</a>
			
			<a href="#">
				<div class="card">
					<h2>学习少儿编程有哪些好处</h2>
					<br />
					<div class="card-img" style="width:60%">
						<img src="img/img2.png" width=100% height=100%>
					</div>
					<p>少儿编程可以强化孩子的思维能力, 培养孩子的专注力和细心度, 能够提高孩子的耐心. </p>
					<p>增加孩子的抽象思考能力, 提升孩子整理信息, 融会贯通的能力.</p>
					<p>让孩子学会团结合作和共同学习的能力, 训练孩子空间思考能力, 增强孩子解决问题的能力.</p>
				</div>
			</a>
			
			
		</div>
		
	</div>
	
	<!--尾部-->
	<div class="foot-shenming" id="shenming">
		本网页为我的毕业设计内容,着重于代码的实现,网页内所用部分图片非本人制作,图片来源于网络,仅用于学习用途,我尊重图片作者的劳动成果并在此表达感谢!
	</div>
	
	<!--反馈与建议 (7)-->
	<div class="xuanfu">
		<a class="fankui" href="fankui.jsp" >
		反馈与建议
		</a>
	</div>
	
	<!--友情链接 (6)-->
	<div id="footer">
		<div id="footer_contain">
			<div id="footer_yqlj">
				友情链接：
                <a href="https://www.icourse163.org/">中国大学MOOC</a>
                <a href="https://github.com/">GitHub</a>
				<a href="https://gitee.com/">Gitee</a>
			</div>
		</div>
	</div>
	
	
	<!-- js脚本 -->
	<script type="text/javascript">
	
	</script>
	
	
	</body>

</html>