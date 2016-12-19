

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>软件学院实践课题管理系统</title>

<script type="text/javascript">

	function lookPro1(proID, proName) {
		var url="./${sessionScope.pathCode}/pro1.do?proID=" + proID + "&proName=" + proName;
		url=encodeURI(url);
		url=encodeURI(url); 
		window.location.href = url;
	}
	
	function lookPro2(proID, proName) {
		var url="./${sessionScope.pathCode}/pro2.do?proID=" + proID + "&proName=" + proName;
		url=encodeURI(url);
		url=encodeURI(url); 
		window.location.href = url;
	}
	
	function delPro1(proID, tutorID) {
		if (confirm('确认删除?')) {
			$.ajax({
				type : "post",
				url : "./${sessionScope.pathCode}/del1.do",
				data : "proID=" + proID + "&tutorID=" + tutorID,
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
	
	function delPro2(proID, tutorID) {
		if (confirm('确认删除?')) {
			$.ajax({
				type : "post",
				url : "./${sessionScope.pathCode}/del2.do",
				data : "proID=" + proID + "&tutorID=" + tutorID,
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
	<div class="row">
		<div class="col-sm-12">
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a></li>
				<li class="active">导师权限分配</li>
			</ol>
			<div class="page-header">
				<h3>导师权限分配</h3>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="panel-body">
				<table class="table  table-hover">
					<thead>
						<tr>
							<th><small>课题号</small></th>
							<th><small>课题名</small></th>
							<th><small>分配管理</small></th>
							<th><small>删除</small></th>
							<th><small>分数汇总</small></th>
							<th><small>删除</small></th>
							
						</tr>
					</thead>
					<c:forEach items="${proList}" var="pro">
						<tbody>
							<tr>
								<td><small>${pro.projectID}</small></td>
								<td><small>${pro.projectName}</small></td>
								<td>
									<c:if test="${pro.power1 == null}">
										<button type="button" class="btn btn-info" onclick="lookPro1('${pro.projectID}', '${pro.projectName }')">分配</button>
									</c:if>
									<c:if test="${pro.power1 != null}">
										<small>${pro.power1}</small>
									</c:if>
								</td>
								<td>
									<c:if test="${pro.power1 != null}">
										<button type="button" class="btn btn-danger" onclick="delPro1('${pro.projectID}', '${pro.power1TutorID }')">删除</button>
									</c:if>
								</td>
								
								<td>
									<c:if test="${pro.power2 == null}">
										<button type="button" class="btn btn-info" onclick="lookPro2('${pro.projectID}', '${pro.projectName }')">分配</button>
									</c:if>
									<c:if test="${pro.power2 != null}">
										<small>${pro.power2}</small>
									</c:if>
								</td>
								<td>
									<c:if test="${pro.power2 != null}">
										<button type="button" class="btn btn-danger" onclick="delPro2('${pro.projectID}', '${pro.power2TutorID }')">删除</button>
									</c:if>
								</td>
								
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
