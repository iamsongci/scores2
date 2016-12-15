

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>实践课题管理系统</title>

<script type="text/javascript">

	function lookStu(tutorID, tutorName, proName) {
		var url = "./${sessionScope.pathCode}/tutorStu.do?tutorID=" + tutorID + "&tutorName=" + tutorName + "&proName=" + proName;
		url = encodeURI(url);
		url = encodeURI(url);
		window.location.href = url;

	}

	function AssignStu(tutorID, proID, tutorName) {
		var url = "./${sessionScope.pathCode}/assign.do?proID=" + proID + "&tutorID=" + tutorID + "&tutorName=" + tutorName;
		url = encodeURI(url);
		url = encodeURI(url);
		window.location.href = url;
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
				
			</ol>
			<div class="page-header">
				<h3>教师列表</h3>
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
							<th><small>性别</small></th>
							<th><small>查看</small></th>
							<th><small>分配</small></th>
						</tr>
					</thead>
					<c:forEach items="${tutorList}" var="tutor">
						<tbody>
							<tr>
								<td><small>${tutor.tutorID}</small></td>
								<td><small>${tutor.tutorName}</small></td>
								<c:choose>
									<c:when test="${tutor.tutorSex eq false}">
										<td><small>男</small></td>
									</c:when>
									<c:when test="${tutor.tutorSex eq true}">
										<td><small>女</small></td>
									</c:when>
								</c:choose>
								<th><button type="button" class="btn btn-info"
										onclick="lookStu('${tutor.tutorID}', '${tutor.tutorName }', '${proName }')">查看</button></th>
								<th><button type="button" class="btn btn-info"
										onclick="AssignStu('${tutor.tutorID}', '${proID}', '${tutor.tutorName}')">分配</button></th>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
