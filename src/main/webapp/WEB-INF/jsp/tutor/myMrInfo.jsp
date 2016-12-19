

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>软件学院实践课题管理系统</title>
<style type="text/css">
body {
	font-size: 14;
}
</style>
</head>
<body>

	<div class="row">
		<div class="col-sm-12">
			<!-- start: PAGE TITLE & BREADCRUMB -->
			<ol class="breadcrumb">
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a></li>
			</ol>
			<div class="page-header">
				<h2>机房信息</h2>
			</div>
			<!-- end: PAGE TITLE & BREADCRUMB -->
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<!-- start: GENERAL PANEL -->
			<div class="panel-body">
				<form id="condition" class="form-horizontal"
					action="./${sessionScope.pathCode}/updateTutorInfo.do"
					method="post">


					<div class="form-group">
						<label class="col-sm-2 control-label" for=machRoomList> 机房列表 </label>
						<div class="col-sm-5">
						<label class="col-sm-20 control-label" for=machRoomList> ${info.machRoomList }  </label>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="machRoomSeatInfo"> 座位列表
						</label>
						<div class="col-sm-5">
						<label class="col-sm-20 control-label" for=machRoomList> ${info.machRoomSeatInfo } </label>

						</div>

					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="machRoomSeatInfo"> 管理员姓名
						</label>
						<div class="col-sm-5">
						<label class="col-sm-20 control-label" for=machRoomList> ${info.machRoomAdmName } </label>
						</div>

					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="machRoomSeatInfo"> 管理员电话
						</label>
						<div class="col-sm-5">
						<label class="col-sm-20 control-label" for=machRoomList> ${info.machRoomAdmPhone } </label>
						</div>

					</div>
					
					<div class="form-group">
						<label class="col-sm-2 control-label" for="machRoomSeatInfo"> 管理员邮箱
						</label>
						<div class="col-sm-5">
						<label class="col-sm-20 control-label" for=machRoomList> ${info.machRoomAdmEmail } </label>
						</div>

					</div>
					

				</form>

			</div>
			<!-- end: GENERAL PANEL -->
		</div>
	</div>
</body>
</html>
