<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>实践课题管理系统</title>


<script src="assets/js/ajaxfileupload.js" type="text/javascript"></script>

<script type="text/javascript">
	var curindex = null;
	function init(index) {
		curindex = index;
	}

	function submit() {
		var score = $('#score').val();
		var reg = new RegExp("^(0|[1-9][0-9]|100)$");
		if (!reg.test(score)) {
			alert("输入错误! 得分的范围为: 0-100.");
			return;
		}
		if (confirm('确认提交?')) {
			$.ajax({
				type : "post",
				url : "./${sessionScope.pathCode}/updateStudentScore.do",
				data : "score=" + score + "&curindex=" + curindex,
				dataType : 'html',
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				success : function(result) {
					location.reload();
				},
				error : function(request) {
					alert("Connection error!");
				}
			});
		}
	}

	function downloadWithStuInfo() {
		window.open('./${sessionScope.pathCode}/download.do');
		$('#download').modal('hide');
	}

	function submitFile() {
		var file = $("#file").val();

		if (confirm('确认提交?')) {
			$.ajaxFileUpload({
				url : './${sessionScope.pathCode}/upLoad.do',
				secureuri : false, //安全传输
				fileElementId : 'file', //file标签的id  
				dataType : null, //返回数据的类型  
				success : function(result) //服务器成功响应处理函数
				{
					location.reload();
				},
				error : function(request)//服务器响应失败处理函数
				{
					alert("Connection error!");
				}
			});
/* 			$('#upload').modal('hide');
			location.reload(); */
			
		}
	}
</script>
</head>
<body>
	<!-- start: PAGE HEADER -->
	<div class="row">
		<div class="col-sm-12">
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a></li>
				<li class="active">我的学生</li>
			</ol>
			<div class="page-header">
				<h3>我的学生</h3>
			</div>
		</div>
	</div>

	<div class="modal fade" id="download" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">导出学生成绩</h4>
				</div>
				<div class="modal-body">
					<div style="padding: 10px 30px 10px 30px">
						<input type="button" value="导出学生信息"
							onclick="downloadWithStuInfo()" />
					</div>
					<div style="padding: 10px 30px 10px 30px">
						<h4>
							<span class="label label-warning">Warning</span>导出格式:
							导出后在分数栏填写分数,请勿改动表格
						</h4>
						<img src="./img/type.png" class="img-responsive"
							alt="Responsive image">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="upload" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">上传学生成绩</h4>
				</div>
				<div class="modal-body">
					<div style="padding: 10px 30px 10px 30px">
						<input type="file" id="file" name="file"
							accept="application/vnd.ms-excel">
					</div>
					<div style="padding: 10px 30px 10px 30px">
						<h4>
							<span class="label label-warning">Warning</span> 导入格式: 若成绩栏为空,
							则学生成绩为0
						</h4>
						<img src="./img/type.png" class="img-responsive"
							alt="Responsive image">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						onclick="submitFile()">提交</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="updateScore" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">录入成绩</h4>
				</div>
				<div class="modal-body">
					<div style="padding: 10px 50px 10px 30px">
						<input type="text" id="score" name="score" placeholder="分数">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="submit()">提交</button>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="panel-body">

				<table class="table  table-hover">
					<thead>
						<tr>
							<button data-target="#upload" data-toggle="modal" type="button"
								class="btn btn-info"
								style="float: right; margin: 5px 10% 5px 5px;">上传学生成绩</button>
							<button data-target="#download" data-toggle="modal" type="button"
								class="btn btn-info"
								style="float: right; margin: 5px 2% 5px 5px;">导出学生信息</button>
						</tr>
						<tr>
							<th><small>学号</small></th>
							<th><small>姓名</small></th>
							<th><small>课题类型</small></th>
							<th><small>课题名称</small></th>
							<th><small>成绩</small></th>
							<th><small>报告地址</small></th>
							<th><small>录入分数</small></th>
						</tr>

					</thead>
					<c:forEach items="${info}" var="info">
						<tbody>
							<tr>
								<td><small>${info.studentID}</small></td>
								<td><small>${info.studentName}</small></td>
								<td><small>${info.projectName}</small></td>
								<td><small>${info.trueName}</small></td>
								<td><small>${info.totalScore}</small></td>
								<td><small>${info.reportAddress}</small></td>
								<td>
									<div class="visible-md visible-lg hidden-sm hidden-xs"
										data-target="#updateScore" data-toggle="modal">
										<a onclick="init('${info.index}')"> <i
											class="fa fa-info-circle"></i> <small>录入成绩</small>
										</a>
									</div>
								</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>


	<script
		src="assets/plugins/jquery-inputlimiter/jquery.inputlimiter.1.3.1.min.js"></script>
	
	<script src="assets/plugins/autosize/jquery.autosize.min.js"></script>
	
	<script src="assets/plugins/select2/select2.min.js"></script>
	
	<script src="assets/js/form-elements.js"></script>
	
	
	<script>
		jQuery(document).ready(function() {
			FormElements.init();
		});
	</script> 
</body>
</html>
