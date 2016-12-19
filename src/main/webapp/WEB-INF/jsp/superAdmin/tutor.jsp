
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>软件学院实践课题管理系统</title>

<script src="assets/js/ajaxfileupload.js" type="text/javascript"></script>

<link rel="stylesheet" href="assets/plugins/select2/select2.css">
<script type="text/javascript">
function del(tutorID) {
	if (confirm('确认删除?')) {
		$.ajax({
			type : "post",
			url : "./${sessionScope.pathCode}/delTutor.do",
			data : "tutorID=" + tutorID,
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


function downloadWithAssignInfo() {
	window.open('./${sessionScope.pathCode}/download.do');
	$('#download').modal('hide');
}

function submitFile() {
	var file = $("#file").val();

	if (confirm('确认提交?')) {
		$.ajaxFileUpload({
			url : './${sessionScope.pathCode}/upLoadTutor.do',
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
	}
}
</script>
</head>
<body>
	<!-- start: PAGE HEADER -->
	<div class="row">
		<div class="col-sm-12">
			<!-- start: PAGE TITLE & BREADCRUMB -->
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a></li>
				<li class="active">导师</li>
			</ol>
			<div class="page-header">
				<h3>导师信息</h3>
			</div>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>


<div class="modal fade" id="download" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">导出导师基本信息</h4>
				</div>
				<div class="modal-body">
					<div style="padding: 10px 30px 10px 30px">
						<input type="button" value="导出导师基本信息"
							onclick="downloadWithAssignInfo()" />
					</div>
					<div style="padding: 10px 30px 10px 30px">
						<h4>
							<span class="label label-warning">Warning</span>导出格式:
							
						</h4>
						<img src="./img/type-tutor-out.png" class="img-responsive"
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
					<h4 class="modal-title">导入导师基本信息</h4>
				</div>
				<div class="modal-body">
					<div style="padding: 10px 30px 10px 30px">
						<input type="file" id="file" name="file"
							accept="application/vnd.ms-excel">
					</div>
					<div style="padding: 10px 30px 10px 30px">
						<h4>
							<span class="label label-warning">Warning</span> 导入格式: 
						</h4>
						<img src="./img/type-tutor-up.png" class="img-responsive"
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


	<!-- end: PAGE HEADER 頭部結束-->
	<div class="row">
		<div class="col-md-12">
			<div class="panel-body">
				<table class="table  table-hover">
					<thead>
						<tr>
							<button data-target="#download" data-toggle="modal" type="button"
								class="btn btn-info"
								style="float: right; margin: 5px 10% 5px 5px;">导出导师基本信息</button>
							<button data-target="#upload" data-toggle="modal" type="button"
								class="btn btn-info"
								style="float: right; margin: 5px 2% 5px 5px;">导入导师基本信息</button>
							
						</tr>
						<tr>
							<th><small>工号</small></th>
							<th><small>姓名</small></th>
							<th><small>性别</small></th>
							<th><small>管理课题ID</small></th>
							<th><small>汇总分数课题ID</small></th>
							<th><small>删除</small></th>
						</tr>
					</thead>
					<c:forEach items="${tutorList}" var="tutor">
						<tbody>
							<tr>
								<td><small>${tutor.tutorID}</small></td>
								<td><small>${tutor.tutorName}</small></td>
								<td><small>
									<c:if test="${tutor.tutorSex eq true}">
										女
									</c:if>
									<c:if test="${tutor.tutorSex eq false}">
										男
									</c:if>
								</small></td>
								<td><small>${tutor.tutorPower1 }</small></td>
								<td><small>${tutor.tutorPower2 }</small></td>
								
								<td><small>
									<c:if test="${empty tutor.tutorPower1 && empty tutor.tutorPower2}">
										<button type="button" class="btn btn-danger" onclick="del('${tutor.tutorID}')">删除</button>
									</c:if>
								</small></td>
								
							</tr>
						</tbody>
					</c:forEach>
				</table>
				<div class="form-group">
					<label class="col-sm-8 "> </label>
					<div class="col-sm-4" style="text-align: right; height: 40px">
						<page:createPager pageSize="${pageSize}" totalPage="${totalPage}"
							totalCount="${totalCount}" curPage="${pageNum}"
							formId="condition" />
					</div>
				</div>

			</div>

		</div>
		<!-- end: TABLE WITH IMAGES PANEL -->
	</div>


	<!-- Modal    重置密码提示 -->
	<div class="modal fade" id="pwdM" tabindex="-1" aria-labelledby="pwdT">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="pwdT">重置密码</h4>
				</div>
				<div class="modal-body">
					密码已重置为:123456<br />
					<p></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>

	</div>

	<script
		src="assets/plugins/jquery-inputlimiter/jquery.inputlimiter.1.3.1.min.js"></script>
	<!-- 3 -->
	<script src="assets/plugins/autosize/jquery.autosize.min.js"></script>
	<!-- 1 -->
	<script src="assets/plugins/select2/select2.min.js"></script>
	<!-- 2 -->
	<script src="assets/js/form-elements.js"></script>
	<!-- 4 -->
	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<script>


</script>

</body>
</html>
