

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>个人信息</title>
    <link rel="stylesheet" href="assets/plugins/select2/select2.css">
</head>
<body>
	<!-- start: PAGE HEADER -->
	<div class="row">
		<div class="col-sm-12">
			<!-- start: PAGE TITLE & BREADCRUMB -->
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a>
				</li>
				<li class="active">${tutor.tutorName}信息修改</li>
				</li>
			</ol>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>
	<!-- end: PAGE HEADER 頭部結束-->
	<div class="row">
		<div class="col-md-12">
			<div class="panel-body">
				<div class="row">
					<form id="updateTeaInfo" role="form" class="form-horizontal" action="./${sessionScope.pathCode}/updateTutorInfoB.do"
						method="post">
						<input type="hidden" value="${tutor.tutorID}"name="teaId">
						<div class="form-group">
							<label class="col-sm-2 control-label" for="teaTeacherId">
								教师工号 </label>
							<div class="col-sm-5">
								<input value="${tutor.tutorID }" type="text"
									placeholder="教师工号" id="tutorId" name="tutorId" class="form-control"  readonly="readonly">
							</div>
							<span class="help-inline col-sm-2"> <i
								class="fa fa-info-circle"></i> 不可修改 </span>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="teaName">
								教师姓名 </label>
							<div class="col-sm-5">
								<input value="${tutor.tutorName}" type="text" id="tutorName" name="tutorName" class="form-control">
							</div>
							
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="stuSex"> 性别 </label>
						<div class="col-sm-5">
							<select class="form-control search-select" id="tutorSex"
								name="tutorSex">
								<option value="false"
									<c:if test="${tutor.tutorSex eq false }">
										 selected="selected"</c:if>>男</option>
								<option value="true"
									<c:if test="${tutor.tutorSex eq true}">
										 selected="selected"</c:if>>女</option>
							</select>
						</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="teaTell">
								联系方式 </label>
							<div class="col-sm-5">
								<input value="${tutor.tutorPhone }" type="text"
									id="tutorPhone"  name="tutorPhone" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" for="teaEmail">
								电子邮箱 </label>
							<div class="col-sm-5">
								<input type="text" value="${tutor.tutorEmail }"
									id="tutorEmail" name="tutorEmail" class="form-control">
							</div>

						</div>
						<div class="from-group">
						<label class="col-sm-2 control-label"></label>
							<div class="col-sm-2" style="text-align:right;">
								<button type="submit" class="btn btn-blue btn-block" ><i class="clip-checkmark-2"></i> 确认</button>
							</div>
							<div class="col-sm-2" style="text-align:right;">
								<button type="reset" class="btn btn-blue btn-block" onclick="javascript:history.go(-1);"><i class="clip-arrow-right-2 "></i>  返回</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script
		src="assets/plugins/jquery-inputlimiter/jquery.inputlimiter.1.3.1.min.js"></script><!-- 3 -->
	<script src="assets/plugins/autosize/jquery.autosize.min.js"></script><!-- 1 -->
	<script src="assets/plugins/select2/select2.min.js"></script><!-- 2 -->
	<script src="assets/js/form-elements.js"></script><!-- 4 -->
	<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
	<script>
		jQuery(document).ready(function() {
			FormElements.init();
		});
	</script>
</body>
</html>
