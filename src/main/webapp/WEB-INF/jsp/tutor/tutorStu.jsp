<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>实践课题管理系统</title>


<script src="assets/js/ajaxfileupload.js" type="text/javascript"></script>

<script type="text/javascript">
	function del(index) {
		if (confirm('确认删除?')) {
			$.ajax({
				type : "post",
				url : "./${sessionScope.pathCode}/deleteStu.do",
				data : "index=" + index,
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

</script>
</head>
<body>
	<!-- start: PAGE HEADER -->
	<div class="row">
		<div class="col-sm-12">
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a></li>
				<li class="active">我管理的课题</li>
				<li class="active">教师列表</li>
				<li class="active">${tutorName.str}的学生</li>
				
				
			</ol>
			<div class="page-header">
				<h3>学生列表</h3>
			</div>
		</div>
	</div>

	
	<div class="row">
		<div class="col-md-12">
			<div class="panel-body">

				<table class="table  table-hover">
					<thead>

						<tr>
							<th><small>学号</small></th>
							<th><small>姓名</small></th>
							<th><small>课题类型</small></th>
							<th><small>删除</small></th>
							
						</tr>

					</thead>
					<c:forEach items="${stuList}" var="stu">
						<tbody>
							<tr>
								<td><small>${stu.studentID}</small></td>
								<td><small>${stu.studentName}</small></td>
								<td><small>${stu.projectName}</small></td>
								
								<td>
									
									<div class="visible-md visible-lg hidden-sm hidden-xs"
										data-target="#updateScore" data-toggle="modal">

										<c:if test="${stu.projectName eq proName.str }">
										
											<a onclick="del('${stu.index}')"> <i
												class="fa fa-info-circle"></i> <small>删除</small>
											</a>
										</c:if>
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
