<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: cc
  Date: 15/12/10
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>实践课题管理系统</title>
</head>
<body>
	<!-- start: PAGE HEADER -->
	<div class="row">
		<div class="col-sm-12">
			<!-- start: PAGE TITLE & BREADCRUMB -->
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a></li>
				<li class="active">我的学生</li>
			</ol>
			<div class="page-header">
				<h3>我的学生</h3>
			</div>
			<!-- end: PAGE TITLE & BREADCRUMB -->
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
							<th><small>性别</small></th>
							<th><small>电话</small></th>
							<th><small>班级</small></th>
							<th><small>报告地址</small></th>
						</tr>
					</thead>
					<c:forEach items="${info}" var="info">
						<tbody>
							<tr>
								<td>
		                            <small>${info.studentID}</small>
		                        </td>
		                        <td>
		                            <small>${info.studentName}</small>
		                        </td>
		                        <td>
		                        	<c:if test="${info.studentSex eq false}"><small>男</small></c:if>
		                            <c:if test="${info.studentSex eq true}"><small>女</small></c:if>
		                        </td>
		                        <td>
		                            <small>${info.studentPhone}</small>
		                        </td>
		                        <td>
		                            <small>${info.studentClass}</small>
		                        </td>
		                        <td>
		                            <small>${info.studentReportAdress}</small>
		                        </td>
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
		<!-- end: GENERAL PANEL -->
	</div>

</body>
</html>
