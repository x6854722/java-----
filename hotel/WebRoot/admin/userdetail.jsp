<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.springframework.web.context.support.*"%> 
<%@page import="org.springframework.context.*" %>
<%@page import="com.hotel.dao.*" %>
<%@page import="com.hotel.daoimpl.*" %>
<%@page import="com.hotel.vo.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="./include/header.jsp"></jsp:include>
<jsp:include page="./include/topbar.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row-fluid">
			<jsp:include page="./include/menu.jsp"></jsp:include>
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
						<a href="#">用户管理</a>
					</li>
				</ul>
			</div>
			<div class="sortable row-fluid">
				<a data-rel="tooltip" title="6 new members." class="well span3 top-block" href="#">
					<span class="icon32 icon-color icon-envelope-closed"></span>
					<div>经济间</div>
					<div>$200</div>
					<span class="notification">6</span>
				</a>

				<a data-rel="tooltip" title="4 new pro members." class="well span3 top-block" href="#">
					<span class="icon32 icon-color icon-cart"></span>
					<div>高等间</div>
					<div>$200</div>
					<span class="notification green">4</span>
				</a>

				<a data-rel="tooltip" title="$34 new sales." class="well span3 top-block" href="#">
					
					<span class="icon32 icon-color icon-star-on"></span>
					<div>桃园套房</div>
					<div>$200</div>
					<span class="notification yellow">34</span>
				</a>
				
				<a data-rel="tooltip" title="12 new messages." class="well span3 top-block" href="#">
					<span class="icon32 icon-red icon-user"></span>
					<div>总统套房</div>
					<div>$200</div>
					<span class="notification red">12</span>
				</a>
			</div>
			
			<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i>注册用户</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<!-- 用户详细信息 ，分页显示 -->
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>用户名</th>
								  <th>注册时间</th>
								  <th>会员类型</th>
								  <th>状态</th>
								  <th>详细操作</th>
							  </tr>
						  </thead>   
						  <tbody>
						  
						  		<s:iterator value="userPager.data" id="uservo">
				    				<tr>
										<td><s:property value="#uservo.userName"/></td>
										<td class="center">2013/01/01</td>
										<td class="center">普通会员</td>
										<td class="center">
											<span class="label label-success">激活</span>
										</td>
										<td class="center">
											<a class="btn btn-success" href="#">
												<i class="icon-zoom-in icon-white"></i>  
												详细信息                                           
											</a>
											<a class="btn btn-info" href="#">
												<i class="icon-edit icon-white"></i>  
												编辑资料                                            
											</a>
											<a class="btn btn-warning" href="#">
												<i class="icon-hand-right icon-white"></i> 
												充值
											</a>
											<a class="btn btn-danger" href="#">
												<i class="icon-trash icon-white"></i> 
												删除用户
											</a>
										</td>
									</tr>
				    			</s:iterator>
						  		
						  </tbody>
					  </table>            
					
	    	
	    	<s:if test="userPager.pageCount > 1">
	    	<div class="pagination">
			  <ul>
			  	<li><a href="../userMgr!getPagerUsers?pagenow=1">第一页</a></li>
			  	<s:if test="userPager.noPrev == false">
			    	<li><a href="../userMgr!getPagerUsers?pagenow=<s:property value="userPager.pagenow-1"/>">前一页</a></li>
			    </s:if>
			    <s:if test="userPager.pagenow <= 4">
			    	<s:if test="userPager.pageCount < 7">
			    	   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="1" />
					   <s:param name="last" value="userPager.pageCount" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==userPager.pagenow}">
					    		<li class="active"><a href="../userMgr!getPagerUsers?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../userMgr!getPagerUsers?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
					</s:if>
					<s:else>
					   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="1" />
					   <s:param name="last" value="7" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==userPager.pagenow}">
					    		<li class="active"><a href="../userMgr!getPagerUsers?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../userMgr!getPagerUsers?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
						</s:bean>
					</s:else> 
			    </s:if>
			   	<s:elseif test="(userPager.pageCount - userPager.pagenow)<=4">
			   		<s:if test="userPager.pageCount<7">
			   		   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="1" />
					   <s:param name="last" value="userPager.pageCount" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==userPager.pagenow}">
					    		<li class="active"><a href="../userMgr!getPagerUsers?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../userMgr!getPagerUsers?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
			   		</s:if>
			   		<s:else>
			   		   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="userPager.pageCount-6" />
					   <s:param name="last" value="userPager.pageCount" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==userPager.pagenow}">
					    		<li class="active"><a href="../userMgr!getPagerUsers?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../userMgr!getPagerUsers?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
			   		</s:else>
			   	</s:elseif>
			   	<s:else>
			   		   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="userPager.pagenow-3" />
					   <s:param name="last" value="userPager.pagenow+3" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==userPager.pagenow}">
					    		<li class="active"><a href="../userMgr!getPagerUsers?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../userMgr!getPagerUsers?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
			   	</s:else>
			    <s:if test="userPager.noNext == false">
			    	<li><a href="../userMgr!getPagerUsers?pagenow=<s:property value="userPager.pagenow+1"/>">后一页</a></li>
			    </s:if>
			    <li><a href="../userMgr!getPagerUsers?pagenow=<s:property value="userPager.pageCount"/>">尾页</a></li>
			  </ul>
			</div>
			</s:if>
	    	<!--<s:property value="userPager"/>-->
	    	<!-- 分页结束 -->
						<div class="clearfix"></div>
					</div>
				</div>
			</div>		
			
			<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i>添加用户</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<!-- 添加账户 -->
						<div class="btn-toolbar">
			                <button class="btn btn-primary"><i class="icon-save"></i> 编辑</button>
			
			                <div class="btn-group">
			                </div>
			            </div>
			            <div class="well">
			                <ul class="nav nav-tabs">
			                    <li class="active"><a href="#home" data-toggle="tab">基本数据</a></li>
			                    <li><a href="#profile" data-toggle="tab">修改密码</a></li>
			                </ul>
			                <div id="myTabContent" class="tab-content">
			                    <div class="tab-pane active in" id="home">
			                        <form id="tab" name="formUserInfo" method="post" action="http://localhost/jddf.com/include/actionUser.php" onsubmit="return checkformUserInfo()">
			                            <label>用户账号（用户名）：</label>
			                            <input type="text"  class="input-xlarge" name="acc" >
			                            <label>姓名：</label>
			                            <input type="text"  class="input-xlarge" name="uNameaa" >
			                            <span class="showMsg" ></span>
			                            <label>密  码：</label>
			                            <input type="password"  class="input-xlarge" name="uPwd">
			                            <span class="showMsg2" ></span>
			                            
		                            	<label class="control-label" for="selectError">性别：</label>
										<select id="sex" name="sex" class="chzn-done" data-rel="chosen">
										<option value="男">男</option>
										<option value="女">女</option>
										</select>
										
										<label>年龄</label>
			                            <input type="text"  class="input-xlarge" name="uPhone">
			                            <label>生日</label>
			                            <input type="text"  class="input-xlarge" name="uPhone">
			                            
			                            <label>联系电话</label>
			                            <input type="text"  class="input-xlarge" name="uPhone">
			                            <span class="showMsg3" ></span>
			                            <label>QQ号码</label>
			                            <input type="text" class="input-xlarge" name="uQQ">
			                            <label>Email邮件</label>
			                            <input type="text"  class="input-xlarge" name="uEmail">
			                            <label>家庭住址:</label>
			                            <textarea value="Smith" rows="3" class="input-xlarge" name="uAddrs" ></textarea>
			                            <label>注册时间</label>
			                            <input type="text" class="input-xlarge datepicker" id="date02" name="uDate">
			                            <br><button class="btn btn-primary" name="ubtn">确定</button>
			                        </form>
			                    </div>
			                    <div class="tab-pane fade" id="profile">
			                           <label>请输入你的新密码:</label>
			                            <input type="password" class="input-xlarge" name="passwordUpdateData">
			                            <div>
			                                <button class="btn btn-primary" name="updateUserPwd" >Update</button>
			                            </div>
			
			                    </div>
					        </div>
					
					    </div>
						
						<!-- 添加账户  ends-->
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

<jsp:include page="./include/footer.jsp"></jsp:include>