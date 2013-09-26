<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
						<a href="#">主面板</a>
					</li>
				</ul>
			</div>
			
			
			<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i> 欢迎回来！</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<h1>你好，<s:property value="uservo.userName"/> <small>欢迎回来，欢迎订房。</small></h1>
						<p>由首创集团管理的翠宫饭店1998年开业，于2000年7月重新装修，标准间面积35平米，酒店位于中国著名的高科技园区：中关村科技园区中心，
						周围聚集了众多高科技企业及以清华大学、北京大学为首的著名八大学府，酒店周边的商业及旅游环境非常好，除了临近众多写字楼与公寓外，购物可以到当代中心、
						双安商场，旅游可以到著名旅游胜地颐和园以及圆明园遗址。酒店自身还拥有9000平米的写字间，并且设有游泳池、保龄球、壁球等休闲健身场所，以及粤菜、淮扬菜、
						日式、俄式等众多餐厅，适应了宾客的不同需求，并且为日理万机的商务人士提供全方位INTERNET服务，酒店每间客房内都可以专线高速上网。最大的会议室可容纳300人。</p>
						<p><b>你的满意是我们的追求。.</b></p>
						<div class="clearfix"></div>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i>最近订单</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<!-- 最近订单 表格 -->
						<table class="table table-striped table-bordered bootstrap-datatable">
						  <thead>
							  <tr>
								  <th>房间编号</th>
								  <th>订阅账号</th>
								  <th>预定价格</th>
								  <th>全价</th>
								  <th>开始时间</th>
								  <th>结束时间</th>
								  <th>审核状态</th>
							  </tr>
						  </thead>   
						  <tbody>
						  
						  		<s:iterator value="reservePager.data" id="reserve">
				    				<tr>
										<td><s:property value="#reserve.reserveId"/></td>
										<td class="center"><s:property value="#reserve.userId"/></td>
										<td class="center">
											<span class="label label-success"><s:property value="#reserve.price"/></span>
										</td>
										<td class="center">
											<span class="label label-success"><s:property value="#reserve.total"/></span>
										</td>
										<td class="center"><s:property value="#reserve.startTime"/></td>
										<td class="center"><s:property value="#reserve.overTime"/></td>
										<td class="center"><s:property value="#reserve.needchk"/></td>
										
										
									</tr>
				    			</s:iterator>
						  		
						  </tbody>
					  </table>            
					
	    	
	    	<s:if test="reservePager.pageCount > 1">
	    	<div class="pagination">
			  <ul>
			  
			  	<li><a href="../user!getPagerReserves?pagenow=1&userId=<s:property value="uservo.userId"/>">第一页</a></li>
			  	<s:if test="reservePager.noPrev == false">
			    	<li><a href="../user!getPagerReserves?pagenow=<s:property value="reservePager.pagenow-1"/>&userId=<s:property value="uservo.userId"/>">前一页</a></li>
			    </s:if>
			    <s:if test="reservePager.pagenow <= 4">
			    	<s:if test="reservePager.pageCount < 7">
			    	   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="1" />
					   <s:param name="last" value="reservePager.pageCount" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==reservePager.pagenow}">
					    		<li class="active"><a href="../user!getPagerReserves?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../user!getPagerReserves?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
					</s:if>
					<s:else>
					   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="1" />
					   <s:param name="last" value="7" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==reservePager.pagenow}">
					    		<li class="active"><a href="../user!getPagerReserves?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../user!getPagerReserves?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
						</s:bean>
					</s:else> 
			    </s:if>
			   	<s:elseif test="(reservePager.pageCount - reservePager.pagenow)<=4">
			   		<s:if test="reservePager.pageCount<7">
			   		   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="1" />
					   <s:param name="last" value="reservePager.pageCount" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==reservePager.pagenow}">
					    		<li class="active"><a href="../user!getPagerReserves?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../user!getPagerReserves?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
			   		</s:if>
			   		<s:else>
			   		   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="reservePager.pageCount-6" />
					   <s:param name="last" value="reservePager.pageCount" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==reservePager.pagenow}">
					    		<li class="active"><a href="../user!getPagerReserves?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../user!getPagerReserves?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
			   		</s:else>
			   	</s:elseif>
			   	<s:else>
			   		   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="reservePager.pagenow-3" />
					   <s:param name="last" value="reservePager.pagenow+3" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==reservePager.pagenow}">
					    		<li class="active"><a href="../user!getPagerReserves?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../user!getPagerReserves?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
			   	</s:else>
			    <s:if test="reservePager.noNext == false">
			    	<li><a href="../user!getPagerReserves?pagenow=<s:property value="reservePager.pagenow+1"/>&userId=<s:property value="uservo.userId"/>">后一页</a></li>
			    </s:if>
			    <li><a href="../user!getPagerReserves?pagenow=<s:property value="reservePager.pageCount"/>&userId=<s:property value="uservo.userId"/>">尾页</a></li>
			  </ul>
			</div>
			</s:if>
						<!-- 最近订单 表格 -->
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