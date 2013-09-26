
$(document).ready(function(){
	
	$('#ubtnn').click(function(e){
		e.preventDefault();
		
		var url = '../userMgr!addUser';
		//alert(url);
					
		//获取表单值，并以json的数据形式保存到params中
		var params = {
			userId:$("form[name='formUserInfo'] :input[name='userId']").val(),
			userPwd:$("form[name='formUserInfo'] :input[name='userPwd']").val(),
			userName:$("form[name='formUserInfo'] :input[name='userName']").val(),
			userSex:$("form[name='formUserInfo'] :input[name='userSex'][@checked]").val(),
			userAge:$("form[name='formUserInfo'] :input[name='userAge']").val(),
			CertiType:$("form[name='formUserInfo'] :input[name='CertiType']").val(),
			CertiNum:$("form[name='formUserInfo'] :input[name='CertiNum']").val(),
			userBirthday:$("form[name='formUserInfo'] :input[name='userBirthday']").val(),
			userPhone:$("form[name='formUserInfo'] :input[name='userPhone']").val(),
			userQQ:$("form[name='formUserInfo'] :input[name='userQQ']").val(),
			userEmail:$("form[name='formUserInfo'] :input[name='userEmail']").val(),
			userAddr:$("form[name='formUserInfo'] :input[name='userAddrs']").val(),
			userRegtime:$("form[name='formUserInfo'] :input[name='userRegtime']").val()																																													
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

		//$("div").html('<p>Hello Again</p>');
		//alert(content);
		
	});
});
	////																					
	$('.btn-update').click(function(e){
		e.preventDefault();
		
		var url = '../userMgr!chkpwdDeal';
		//alert(url);
					
		//获取表单值，并以json的数据形式保存到params中
		var params = {
			passwordUpdateData:$(":input[name='passwordUpdateData']").val(),
			userId:'admin'																				
		};
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

	
//roommgr
	$(document).ready( function() {
		
		//使用 Ajax 的方式 判断登录
		$("#ubtn_room").click( function() {
			
			var url = '../roomMgr!addRoom';
			//alert(url);
						
			//获取表单值，并以json的数据形式保存到params中
			var params = {
				roomId:$("form[name='roomform'] :input[name='roomId']").val(),
				roomName:$("form[name='roomform'] :input[name='roomName']").val(),
				roomState:$("form[name='roomform'] :input[name='roomState'][@checked]").val(),
				roomAvailable:$("form[name='roomform'] :input[name='roomAvailable'][@checked]").val(),
				price:$("form[name='roomform'] :input[name='price']").val(),
				discountPrice:$("form[name='roomform'] :input[name='discountPrice']").val()								
			};
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
