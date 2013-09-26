<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- left menu starts -->
			<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li class="nav-header hidden-tablet">账号设置</li>
						
						<li><a class="ajax-link" href="../user!info?userId=<s:property value="uservo.userId"/>"><i class="icon-eye-open"></i><span class="hidden-tablet"> 个人信息</span></a></li>
						<li><a class="ajax-link" href="../user!chginfo?userId=<s:property value="uservo.userId"/>"><i class="icon-edit"></i><span class="hidden-tablet"> 修改资料</span></a></li>
						<li><a class="ajax-link" href="../user!chgpwd?userId=<s:property value="uservo.userId"/>"><i class="icon-list-alt"></i><span class="hidden-tablet"> 修改密码</span></a></li>
						<li class="nav-header hidden-tablet">订单管理</li>
						<li><a class="ajax-link" href="../reserve!index?userId=<s:property value="uservo.userId"/>"><i class="icon-eye-open"></i><span class="hidden-tablet"> 我要订房</span></a></li>
						<li><a class="ajax-link" href="../reserve!all?userId=<s:property value="uservo.userId"/>"><i class="icon-edit"></i><span class="hidden-tablet"> 所有订单</span></a></li>
						<li><a class="ajax-link" href="../reserve!suc?userId=<s:property value="uservo.userId"/>"><i class="icon-list-alt"></i><span class="hidden-tablet"> 成功订单</span></a></li>
						<li><a class="ajax-link" href="../reserve!needchk?userId=<s:property value="uservo.userId"/>"><i class="icon-font"></i><span class="hidden-tablet"> 待审订单</span></a></li>
						
					</ul>
					<label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input id="is-ajax" type="checkbox" checked="checked"> Ajax on menu</label>
				</div><!--/.well -->
			</div><!--/span-->
			<!-- left menu ends -->