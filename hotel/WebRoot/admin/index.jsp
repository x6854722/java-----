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
						<a href="#">订单管理</a>
					</li>
				</ul>
			</div>
			
			<!--  统计块 -->
			
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
		 	<!-- 统计块ends -->
			<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i>最新订房信息</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<!-- 用户详细信息 ，分页显示 -->
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
			  	<li><a href="../admin!getPagerReserves?pagenow=1">第一页</a></li>
			  	<s:if test="reservePager.noPrev == false">
			    	<li><a href="../admin!getPagerReserves?pagenow=<s:property value="reservePager.pagenow-1"/>">前一页</a></li>
			    </s:if>
			    <s:if test="reservePager.pagenow <= 4">
			    	<s:if test="reservePager.pageCount < 7">
			    	   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="1" />
					   <s:param name="last" value="reservePager.pageCount" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==reservePager.pagenow}">
					    		<li class="active"><a href="../admin!getPagerReserves?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../admin!getPagerReserves?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
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
					    		<li class="active"><a href="../admin!getPagerReserves?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../admin!getPagerReserves?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
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
					    		<li class="active"><a href="../admin!getPagerReserves?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../admin!getPagerReserves?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
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
					    		<li class="active"><a href="../admin!getPagerReserves?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../admin!getPagerReserves?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
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
					    		<li class="active"><a href="../admin!getPagerReserves?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../admin!getPagerReserves?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
			   	</s:else>
			    <s:if test="reservePager.noNext == false">
			    	<li><a href="../admin!getPagerReserves?pagenow=<s:property value="reservePager.pagenow+1"/>">后一页</a></li>
			    </s:if>
			    <li><a href="../admin!getPagerReserves?pagenow=<s:property value="reservePager.pageCount"/>">尾页</a></li>
			  </ul>
			</div>
			</s:if>
	    	<!--<s:property value="reservePager"/>-->
	    	<!-- 分页结束 -->
						<div class="clearfix"></div>
					</div>
				</div>
			</div>		
			
			<!-- 数据添加 -->
			
			
			       
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