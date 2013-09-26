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
						<a href="#">订单管理</a>
					</li>
				</ul>
			</div>
			
			
			<div class="row-fluid">
				<div class="box span12">
					<div class="box-header well">
						<h2><i class="icon-info-sign"></i>查看所有订单</h2>
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
								  <th>选择</th>
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
											<input type="checkbox" name="roomid_value"  value="<s:property value="#roomvo.roomId"/>">
										</td>
									</tr>
				    			</s:iterator>
						  	
						  </tbody>
					  </table>            
					
	    	
	    	<s:if test="roomPager.pageCount > 1">
	    	<div class="pagination">
			  <ul>
			  	<li><a href="../reserve!moreRooms?pagenow=1&userId=<s:property value="uservo.userId"/>">第一页</a></li>
			  	<s:if test="roomPager.noPrev == false">
			    	<li><a href="../reserve!moreRooms?pagenow=<s:property value="roomPager.pagenow-1"/>&userId=<s:property value="uservo.userId"/>">前一页</a></li>
			    </s:if>
			    <s:if test="roomPager.pagenow <= 4">
			    	<s:if test="roomPager.pageCount < 7">
			    	   <s:bean name="org.apache.struts2.util.Counter" id="counter">   
					   <s:param name="first" value="1" />
					   <s:param name="last" value="roomPager.pageCount" />					   
					   <s:iterator>   
					    	<s:if test="%{current-1==roomPager.pagenow}">
					    		<li class="active"><a href="../reserve!moreRooms?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../reserve!moreRooms?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
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
					    		<li class="active"><a href="../reserve!moreRooms?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../reserve!moreRooms?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
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
					    		<li class="active"><a href="../reserve!moreRooms?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../reserve!moreRooms?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
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
					    		<li class="active"><a href="../reserve!moreRooms?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../reserve!moreRooms?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
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
					    		<li class="active"><a href="../reserve!moreRooms?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:if> 
					    	<s:else>
					    		<li><a href="../reserve!moreRooms?pagenow=<s:property value="current-1"/>&userId=<s:property value="uservo.userId"/>" ><s:property value="current-1"/></a></li>
					    	</s:else>
					   </s:iterator>   
					   </s:bean>
			   	</s:else>
			    <s:if test="roomPager.noNext == false">
			    	<li><a href="../reserve!moreRooms?pagenow=<s:property value="roomPager.pagenow+1"/>&userId=<s:property value="uservo.userId"/>">后一页</a></li>
			    </s:if>
			    <li><a href="../reserve!moreRooms?pagenow=<s:property value="roomPager.pageCount"/>&userId=<s:property value="uservo.userId"/>">尾页</a></li>
			  </ul>
			</div>
			</s:if>
	    	<!--<s:property value="reservePager"/>-->
	    	<!-- 分页结束 -->
	    	
	    	<div class="well">
			                <ul class="nav nav-tabs">
			                    <li class="active"><a href="#home" data-toggle="tab">基本数据</a></li>
			                </ul>
			                <div id="myTabContent" class="tab-content">
			                    <div class="tab-pane active in" id="home">
			                        <form id="tab" name="reserveform" method="post" action="../roomMgr!addRoom">
			                            <label>订单编号</label>
			                            <input type="text"  class="input-xlarge" id="reserveId" name="reserveId" value="R007" >
			                            
			                            <input type="text"  class="input-xlarge" id="userId" name="userId" value="<s:property value="uservo.userId"/>" Style="display:none" >
			                            <label class="control-label" for="date01">开始时间</label>
										<div class="controls">
											<input type="text" class="input-xlarge datepicker" name="startTime" id="date01" value="02/16/12">
										</div>
										 <label class="control-label" for="date01">结束时间</label>
										<div class="controls">
											<input type="text" class="input-xlarge datepicker" name="overTime" id="date02" value="02/16/12">
										</div>
			                            <br><a href="#" class="btn btn_reserve btn-round" id="btn_reserve"><i class="icon-cog"></i>预定</a>
			                        </form>
			                    </div>
			        <script type="text/javascript">
	    		
	    			$(document).ready(function(){
	
	
	
								$('.datepicker').datepicker({ altFormat: 'yyyy-mm-dd' });
								$('#btn_reserve').click(function(e){
									e.preventDefault();
									
									var url = '../reserve!reserve';
									
												
									//获取表单值，并以json的数据形式保存到params中
									//$(":input[name='roomid_value'][checked]").each(function(){ //由于复选框一般选中的是多个,所以可以循环输出 
									//	alert($(this).val()); 
									//}); 
									alert($("form[name='reserveform'] :input[name='userId']").val());
									var params = {
										userId:$("form[name='reserveform'] :input[name='userId']").val(),
										reserveId:$("form[name='reserveform'] :input[name='reserveId']").val(),
										roomId:$(":input[name='roomid_value'][checked]").val(),
										startTime:$("form[name='reserveform'] :input[name='startTime']").val(),
										overTime:$("form[name='reserveform'] :input[name='overTime']").val(),																																												
									};
									//alert(params);
									//使用$.post方式	
									$.post(
									
										url,		//服务器要接受的url
										
										params,		//传递的参数		
										
										function cbf(data){	//服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
										
											if(data.status == "success")
											{
												var  title = data.title;
												var  msg = data.msg;
												var content='<div class="modal-header">' +
												'<button type="button" class="close" data-dismiss="modal">×</button>'+
												'<h3>'+title+'</h3>' +
												'</div>' +
												'<div class="modal-body">' +
													'<p>'+msg+'</p>' +
												'</div>' +
												'<div class="modal-footer">' +
													'<a href="#" class="btn" data-dismiss="modal">确定</a>' +
													
												'</div>' ;
												$('<div class="modal hide fade" id="myModal"></div>').html(content).modal('show');
												
											}
											else if(data.status == "fail"){
											
												
											    var  title = data.title;
												var  msg = data.msg;
												var content='<div class="modal-header">' +
												'<button type="button" class="close" data-dismiss="modal">×</button>'+
												'<h3>'+title+'</h3>' +
												'</div>' +
												'<div class="modal-body">' +
													'<p>'+msg+'</p>' +
												'</div>' +
												'<div class="modal-footer">' +
													'<a href="#" class="btn" data-dismiss="modal">确定</a>' +
													
												'</div>' ;
												$('<div class="modal hide fade" id="myModal"></div>').html(content).modal('show');
											}else
											{
												var  title = "修改密码";
												var  msg = "网络错误";
												var content='<div class="modal-header">' +
												'<button type="button" class="close" data-dismiss="modal">×</button>'+
												'<h3>'+title+'</h3>' +
												'</div>' +
												'<div class="modal-body">' +
													'<p>'+msg+'</p>' +
												'</div>' +
												'<div class="modal-footer">' +
													'<a href="#" class="btn" data-dismiss="modal">确定</a>' +
													
												'</div>' ;
												$('<div class="modal hide fade" id="myModal"></div>').html(content).modal('show');
											}							
										}, 
										
										'json'	//数据传递的类型  json
										
									);
									
								});
							});
				</script>
					        </div>
					        </div>
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

<jsp:include page="../include/footer.jsp"></jsp:include>