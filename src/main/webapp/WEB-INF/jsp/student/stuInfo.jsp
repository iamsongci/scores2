<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>软件学院实践课题管理系统</title>
<link rel="stylesheet" href="assets/plugins/select2/select2.css">
</head>

<body>

<c:if test="${message != null }">

</c:if>
	<!-- start: PAGE HEADER -->
	<div class="row">
		<div class="col-sm-12">
			<!-- start: PAGE TITLE & BREADCRUMB -->
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a>
				</li>
				<li class="active">个人信息</li>
			</ol>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>
	<!-- end: PAGE HEADER 頭部結束-->
	<c:if test="${message == '1'}">
	<div class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert">
        &times;
    </a>
    <strong>成功！</strong>信息保存成功
    </div>
	</c:if>
	<div class="row">
		<div class="col-md-12">
			<!-- start: GENERAL PANEL -->
			<div class="panel-body">
				<form id="condition" class="form-horizontal"
					action="./${sessionScope.pathCode}/updateStuPhone.do" method="post">

					<div class="form-group">
						<label
							class="col-sm-2 control-label" for="stuStudentId"> 学号 </label>
						<div class="col-sm-5">
							<input type="text" value="${studentInfo.studentID }"
								name="stuStudentId" id="stuStudentId" class="form-control"
								readonly="readonly">

						</div>
						<span class="help-inline col-sm-2"> <i
							class="fa fa-info-circle"></i><font color="red"> 不可修改</font> </span>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="stuName"> 姓名 </label>
						<div class="col-sm-5">
							<input type="text" value="${studentInfo.studentName }"
								id="stuName" name="stuName" class="form-control"
								readonly="readonly">
						</div>
						<span class="help-inline col-sm-2"> <i
							class="fa fa-info-circle"></i> <font color="red">不可修改 </font></span>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="stuSex"> 性别 </label>
						<div class="col-sm-5">
							<select class="form-control search-select" id="stuSex"
								name="stuSex">
								<option value="false"
									<c:if test="${studentInfo.studentSex eq false }">
										 selected="selected"</c:if>>男</option>
								<option value="true"
									<c:if test="${studentInfo.studentSex eq true}">
										 selected="selected"</c:if>>女</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="stuClass"> 班级 </label>
						<div class="col-sm-5">
							<input type="text" value="${studentInfo.studentClass }"
								placeholder="班级" id="stuClass" class="form-control"
								name="stuClass" readonly="readonly">
						</div>
						<span class="help-inline col-sm-2"> <i
							class="fa fa-info-circle"></i> <font color="red">不可修改 </font></span>

					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="stuTell"> 联系方式
						</label>
						<div class="col-sm-5">
							<input type="text" value="${studentInfo.studentPhone }"
								id="stuTell" name="stuPhone" class="form-control" maxlength='13'>
						</div>
					</div>
					<div class="from-group">
						<label class="col-sm-2 control-label"></label>
						<div class="col-sm-2" style="text-align:right;">
							<button type="submit" class="btn btn-blue btn-block">
								<i class="clip-checkmark-2"></i> 确认
							</button>
						</div>
						<div class="col-sm-2" style="text-align:right;">
							<button type="button" class="btn btn-blue btn-block"
								onclick="javascript:history.go(-1);">
								<i class="clip-arrow-right-2 "></i> 返回
							</button>
						</div>
					</div>
				</form>

			</div>
			<!-- end: GENERAL PANEL -->
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
		jQuery(document).ready(function() {
			FormElements.init();
		});

	</script>
	
</body>
</html>
