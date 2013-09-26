<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="../include/header.jsp"></jsp:include>
<jsp:include page="../include/topbar.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row-fluid">
			<jsp:include page="../include/menu.jsp"></jsp:include>
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<div id="content" class="span10">
			<!-- content starts -->
			

			<div>
				<ul class="breadcrumb">
					<li>
						<a href="#">酒店订房</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="#">主面板</a>
					</li>
				</ul>
			</div>
			
			
			<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i> 修改个人信息</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<h1>你好，<s:property value="uservo.userName"/> <small>欢迎回来，欢迎订房。</small></h1>
						
						<h3>账户名  <small><s:property value="uservo.userId"/></small></h3>
						<h3>姓名 <small><s:property value="uservo.userName"/></small></h3>
						<h3>性别  <small><s:property value="uservo.sex"/></small></h3>
						<h3>电话  <small><s:property value="uservo.mobile"/></small></h3>
						<h3>电子邮箱  <small><s:property value="uservo.email"/></small></h3>
						<h3>证件类型  <small><s:property value="uservo.certiType"/></small></h3>
						<h3>证件号码  <small><s:property value="uservo.certiNum"/></small></h3>
						<h3>地址  <small><s:property value="uservo.address"/></small></h3>
						<h3>生日  <small><s:property value="uservo.birthday"/></small></h3>
						<h3>年龄  <small><s:property value="uservo.age"/></small></h3>
						
						
						<p><b>你的满意是我们的追求。.</b></p>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			
			
					
				
       
					<!-- content ends -->
			</div><!--/#content.span10-->
				</div><!--/fluid-row-->
				
		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Close</a>
				<a href="#" class="btn btn-primary">Save changes</a>
			</div>
		</div>

		<footer>
			<p class="pull-left">&copy; <a href="https://github.com/oneDayoneDot" target="_blank">John Mrzhou</a> 2013</p>
			<p class="pull-right">Powered by: <a href="https://github.com/oneDayoneDot">onedayonedot</a></p>
		</footer>
		
	</div><!--/.fluid-container-->

<jsp:include page="../include/footer.jsp"></jsp:include>