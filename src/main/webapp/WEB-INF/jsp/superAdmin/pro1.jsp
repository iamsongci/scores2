

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>软件学院实践课题管理系统</title>

<script type="text/javascript">
	function assign(proID, tutorID) {
		if (confirm('确认分配?')) {
			$.ajax({
				type : "post",
				url : "./${sessionScope.pathCode}/assign1.do",
				data : "proID=" + proID + "&tutorID=" + tutorID,
				dataType : 'html',
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				success : function(result) {
					window.location.href = "./${sessionScope.pathCode}/powerAssign.do";
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
	<div class="row">
		<div class="col-sm-12">
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a></li>
				<li class="active">导师权限分配</li>
				<li class="active">为${proName }分配</li>
			</ol>
			<div class="page-header">
				<h3>导师列表</h3>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="panel-body">
				<table class="table  table-hover">
					<thead>
						<tr>
							<th><small>工号</small></th>
							<th><small>姓名</small></th>
							<th><small>分配管理权限</small></th>
						</tr>
					</thead>
					<c:forEach items="${tutorList}" var="tutor">
						<tbody>
							<tr>
								<c:if test="${tutor.tutorName != '机房' }">
									<td><small>${tutor.tutorID}</small></td>
									<td><small>${tutor.tutorName}</small></td>
									
									<td>
										<button type="button" class="btn btn-info" onclick="assign('${proID}', '${tutor.tutorID}')">分配</button>
									</td>
								</c:if>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
