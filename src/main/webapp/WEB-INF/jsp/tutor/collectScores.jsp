

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>实践课题管理系统</title>

<script type="text/javascript">
	function look(proID) {
		var url="./${sessionScope.pathCode}/lookProject.do?proID=" + proID;
		url=encodeURI(url);
		url=encodeURI(url); 
		window.location.href =url;
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
			</ol>
			<div class="page-header">
				<h3>我管理的课题</h3>
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
							<th><small>课题名称</small></th>
							<th><small>操作</small></th>
						</tr>
					</thead>
					<c:forEach items="${proList}" var="pro">
						<tbody>
							<tr>
								<td><small>${pro.projectID}</small></td>
								<td><small>${pro.projectName}</small></td>
								<th><button type="button" class="btn btn-info" onclick="look('${pro.projectID}')">进入 </button></th>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
