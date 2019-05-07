//上传图片插件
  $("#uploadify").uploadify({
    //FLash按钮文件的相对路径
    	'swf': '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
//前台请求后台的url 不可忽略的参数  //后台的 上传地址 必写
  	'uploader': '<%=request.getContextPath()%>/demo/addimg.do',
      //文件队列的元素的id(传输文件的中间容器ID)
      'queueID': 'fileQueue',
      //上传文件文件名  后台用这个名字来接收值
      'fileObjName' : 'file', 
      //提交方式Post 或Get 默认为Post
      'method'  : 'post',
      //给上传按钮设置文字
      'buttonText': '上传图片',
      //设置文件是否自动上传
      'auto': true,
      //可以同时选择多个文件 默认为true  不可忽略
      'multi': false,
     //'percentage''speed''all' 三个参数，队列中显示文件上传进度的方式：all-上传速度+百分比，percentage-百分比，speed-上传速度								
	'progressData' :'all',
 
   /*  'fileSizeLimit': 0, //文件上传的大小，以字节为单位，0为不限制。1MB:1*1024*1024
	'buttonCursor': 'head', // 上传光标的样子
	'fileTypeDesc' : 'mp4/avi/kux', //在弹出的文件选择框里提示上传的文件类型的描述
   */
   
    //允许上传的文件后缀   可替换成 fileTypeDesc
      'fileExt': '*.jpg;*.gif;*.png', 
     //上传文件的关闭按钮图标（取消上传）
      'cancelImg': '<%=request.getContextPath()%>/js/uploadify/uploadify-cancel.png',  
      //队列消失时间
      'removeTimeout' : 1,
      //上传文件的个数，项目中一共可以上传文件的个数
      'uploadLimit':  -1,
      'fileTypeExts': '*.jpg;*.png',
      //开始执行上传
      'onUploadStart':function(files){
      	//$.messager.progress({ title:'提示',msg:'上传中...' });
      },
      //上传失败
      'onUploadError':function(){
      	//$.messager.progress('close');
      	//$.messager.alert('提示','上传失败');
      	alert("上传失败");
      },
	//成功回调函数 file：文件对象。data:后台输出数据(数据库的信息)
      'onUploadSuccess':function(file,data,response){
      	//$.messager.progress('close');
  	  	//  alert(data+file.name)																				//eval(data)
  	  	var imgurl = "http://<%= request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"+data
//这个是展示的(上传成功后的展示)
  	  	$("#showimg").attr("src",imgurl);//注意修改 这个是回显上传图片    ID选择器的ID和 imgde ID一致
//这个是真实上传的值，一般隐藏 	  	
  	  	$('#hidimg').val(imgurl);
      }
  });