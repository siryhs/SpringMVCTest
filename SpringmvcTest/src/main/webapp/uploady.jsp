<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>uploadify</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="uploadify/uploadify.css">
<script type="text/javascript" src="uploadify/jquery.uploadify.min.js"></script>
<style type="text/css">
.uploadify-button {
	background-color: transparent;
	border: none;
	padding: 0;
}

.uploadify:hover .uploadify-button {
	background-color: transparent;
}
</style>
</head>
<body>
	<input type="file" id="picUpload" />
	<script type="text/javascript">
		$(function() {
			$("#picUpload").uploadify({
				'swf' : 'uploadify/uploadify.swf',
				'uploader' : 'upload/pic',
				'buttonText' : '上传',
				'formData' : {
					'someKey1' : 'someValue',
					'someKey2' : 'someValue2'
				},
				"onCancel" : function() {
					// 取消上传事件
					alert("删除上传");
				},
				"onQueueComplete" : function(queueData) {
					console.log(queueData);

					// 所有文件上传成功后触发
					alert("上传成功");
				},
				'onUploadSuccess' : function(file, data, response) {
					//console.log(file);
					//console.log("--------------");
					//console.log(data);
					//console.log("--------------");
					//console.log(response);
				}
			})
		})
	</script>
</body>
</html>