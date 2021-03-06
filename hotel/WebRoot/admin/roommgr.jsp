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
						<a href="#">客房管理</a>
					</li>
				</ul>
			</div>
			
			
			<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i>客房维护</h2>
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
								  <th>房间类型</th>
								  <th>是否可用</th>
								  <th>单价</th>
								  <th>折扣价</th>
								  <th>详细操作</th>
							  </tr>
						  </thead>   
						  <tbody>
						  
						  		<s:iterator value="roomPager.data" id="roomvo">
				    				<tr>
										<td><s:property value="#roomvo.roomId"/></td>
										<td class="center"><s:property value="#roomvo.roomName"/></td>
										<td class="center"><s:property value="#roomvo.available"/></td>
										<td class="center">
											<span class="label label-success"><s:property value="#roomvo.price"/></span>
										</td>
										<td class="center">
											<span class="label label-success"><s:property value="#roomvo.discountPrice"/></span>
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
											<a class="btn btn-danger" href="#">
												<i class="icon-trash icon-white"></i> 
												删除房间
											</a>
										</td>
									</tr>
				    			</s:iterator>
						  		
						  </tbody>
					  </table>            
					
	    	
	    	<s:if test="roomPager.pageCount > 1">
	    	<div class="pagination">
			  <ul>
			  	<li><a href="../roomMgr!getPagerRooms?pagenow=1">第一页</a></li>
			  	<s:if test="roomPager.noPrev == false">
			    	<li><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="roomPager.pagenow-1"/>">前一页</a></li>
			    </s:if>
			    <s:if test="roomPager.pagenow <= 4">
			    	<s:if test="roomPager.pageCount < 7">
			    	   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="1" />
					   <s:param name="last" value="roomPager.pageCount" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==roomPager.pagenow}">
					    		<li class="active"><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
					</s:if>
					<s:else>
					   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="1" />
					   <s:param name="last" value="7" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==roomPager.pagenow}">
					    		<li class="active"><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
						</s:bean>
					</s:else> 
			    </s:if>
			   	<s:elseif test="(roomPager.pageCount - roomPager.pagenow)<=4">
			   		<s:if test="roomPager.pageCount<7">
			   		   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="1" />
					   <s:param name="last" value="roomPager.pageCount" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==roomPager.pagenow}">
					    		<li class="active"><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
			   		</s:if>
			   		<s:else>
			   		   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="roomPager.pageCount-6" />
					   <s:param name="last" value="roomPager.pageCount" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==roomPager.pagenow}">
					    		<li class="active"><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
			   		</s:else>
			   	</s:elseif>
			   	<s:else>
			   		   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="roomPager.pagenow-3" />
					   <s:param name="last" value="roomPager.pagenow+3" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==roomPager.pagenow}">
					    		<li class="active"><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="current-1"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
			   	</s:else>
			    <s:if test="roomPager.noNext == false">
			    	<li><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="roomPager.pagenow+1"/>">后一页</a></li>
			    </s:if>
			    <li><a href="../roomMgr!getPagerRooms?pagenow=<s:property value="roomPager.pageCount"/>">尾页</a></li>
			  </ul>
			</div>
			</s:if>
	    	<!--<s:property value="roomPager"/>-->
	    	<!-- 分页结束 -->
						<div class="clearfix"></div>
					</div>
				</div>
			</div>		
			
			<!-- 数据添加 -->
			
			<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i>添加客房</h2>
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
			                </ul>
			                <div id="myTabContent" class="tab-content">
			                    <div class="tab-pane active in" id="home">
			                        <form id="tab" name="roomform" method="post" action="../roomMgr!addRoom">
			                            <label>房间编号</label>
			                            <input type="text"  class="input-xlarge" id="roomId" name="roomId" value="B007" >
			                            <label>房间类型</label>
			                            <input type="text"  class="input-xlarge" name="roomName" >
			                            <label>房间状态</label>			                            
			                            <label class="radio">
										<input type="radio" name="roomState" value="预定" checked="">
										预定
									 	</label>									 	
									  	<label class="radio">
										<input type="radio" name="roomState"  value="固定">
										固定
									  	</label>
									  	<div style="clear:both"></div>
									  	<label>房间状态</label>
									  	<label class="radio">
										<input type="radio" name="roomAvailable" value="Y" checked="">
										Y
									 	</label>									 	
									  	<label class="radio">
										<input type="radio" name="roomAvailable"  value="N">
										N
									  	</label>
									 
			                            <label>单价</label>
			                            <input type="text"  class="input-xlarge" name="price" value="300.00">
			                            <label>折扣价</label>
			                            <input type="text"  class="input-xlarge" name="discountPrice" value="230.00" >
			                            <br><input type="button" class="btn btn-primary" name="ubtn" id="ubtn_room" value="确定添加"/>
			                        </form>
			                    </div>
			        <script type="text/javascript">
	    		
	    			
				// --></script>
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