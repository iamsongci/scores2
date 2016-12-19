

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>软件学院实践课题管理系统</title>

<script type="text/javascript">

	function Assign(studentID, tutorID, proID, tutorName) {
		
		$.ajax({
			type : "post",
			url : "./${sessionScope.pathCode}/assignStudent.do?",
			data : "studentID=" + studentID + "&tutorID=" + tutorID  + "&proID=" + proID + "&tutorName=" + tutorName,
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
	
	
</script>
</head>
<body>

	<div class="row">
		<div class="col-sm-12">
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a></li>
				<li class="active">我管理的课题</li>
				<li class="active">教师列表</li>
				<li class="active">为${tutorName }分配学生</li>
			</ol>
			<div class="page-header">
				<h3>分配列表</h3>
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
							<th><small>班级</small></th>
							<th><small>分配</small></th>
						</tr>
					</thead>
					<c:forEach items="${stuList}" var="stu">
						<tbody>
							<tr>
								<td><small>${stu.studentID}</small></td>
								<td><small>${stu.studentName}</small></td>
								<td><small>${stu.className}</small></td>

								<th><button type="button" class="btn btn-info"
										onclick="Assign('${stu.studentID}', '${tutorID}', '${proID}', '${tutorName}')">分配</button></th>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
