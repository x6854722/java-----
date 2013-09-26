<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!-- left menu starts -->
			<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li class="nav-header hidden-tablet">基本数据管理</li>
						<li><a class="ajax-link" href="../admin!index"><i class="icon-home"></i><span class="hidden-tablet"> 主面板</span></a></li>
						<li><a class="ajax-link" href="../userMgr!usermgr"><i class="icon-eye-open"></i><span class="hidden-tablet"> 用户管理</span></a></li>
						<li><a class="ajax-link" href="../roomMgr!index"><i class="icon-edit"></i><span class="hidden-tablet"> 客房管理</span></a></li>
						<li><a class="ajax-link" href="../roomMgr!price"><i class="icon-list-alt"></i><span class="hidden-tablet"> 客房单价管理</span></a></li>
						<li class="nav-header hidden-tablet">订房管理</li>
						<li><a class="ajax-link" href="../reserveMgr!index"><i class="icon-align-justify"></i><span class="hidden-tablet"> 查看所有订单</span></a></li>
						<li><a class="ajax-link" href="../reserveMgr!chk"><i class="icon-calendar"></i><span class="hidden-tablet"> 订单审核</span></a></li>
						<li><a class="ajax-link" href="../reserveMgr!success"><i class="icon-th"></i><span class="hidden-tablet"> 成功订单</span></a></li>
						<li><a class="ajax-link" href="../reserveMgr!serch"><i class="icon-folder-open"></i><span class="hidden-tablet"> 订单查询</span></a></li>
						
					</ul>
					<label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input id="is-ajax" type="checkbox" checked="checked"> Ajax on menu</label>
				</div><!--/.well -->
			</div><!--/span-->
			<!-- left menu ends -->