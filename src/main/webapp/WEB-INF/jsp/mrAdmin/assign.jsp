<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>

		<title>机房分配</title>
		<link rel="stylesheet" href="assets/plugins/select2/select2.css">
		<script type="text/javascript">
		   var data=new Array();
		   function getmrInfo(ass,id) {
		   var mrInfo = $("#scope");
		   mrInfo.empty();
		   mrInfo.append(ass);
		   var sa = ass.split(",");
		   var n;
		   for(var i=0;i<sa.length;i++){
	           if(sa[i].length>1){
	              data.push(sa[i].split("-"));
	              }
	           }
                alert(data.length);
		}
		</script>
	</head>

	<body>

		<c:if test="${message != null }">

		</c:if>
		<!-- start: PAGE HEADER -->
		<div class="row">
			<div class="col-sm-12">
				<!-- start: PAGE TITLE & BREADCRUMB -->
				<ol class="breadcrumb">
					<li><i class="clip-home-3"></i>
						<a href="./${sessionScope.pathCode}/home.do"> 首页 </a>
					</li>
					<li class="active">为<strong>${tutorName}</strong>分配机房</li>
				</ol>
				<!-- end: PAGE TITLE & BREADCRUMB -->
			</div>
		</div>
		<!-- end: PAGE HEADER 頭部結束-->
		<c:if test="${message == '1'}">
			<div class="alert alert-success">
				<a href="#" class="close" data-dismiss="alert"> &times; </a> <strong>成功！</strong>信息保存成功
			</div>
		</c:if>
		<div class="row">
			<div class="col-md-12">
				<div class="panel-body">
					<table class="table  table-hover">
						<thead>
							<tr>
								<th><small>机房号</small></th>
								<th><small>机位数</small></th>
								<th><small>已分配机位</small></th>
								<th><small>未分配机位</small></th>
								<th><small>已分配导师名单</small></th>
								<th><small>操作</small></th>
							</tr>
						</thead>
						<c:forEach items="${mrInfo}" var="mr">
							<tbody>
								<tr>
									<td><small>${mr.machineRoomID}</small></td>
									<td><small>${mr.machineRoomSeatNums}</small></td>
									<td><small>${mr.machineRoomAssignSeatNums}</small></td>
									<td><small>${mr.machineRoomUnAssignSeatNums }</small></td>
									<td><small>${mr.machineRoomAssignTutorName }</small></td>
									<td>
										<li style="list-style-type:none;" data-toggle="modal" data-target="#AdminChoucha">
											<a data-target="#AdminChoucha" onclick="getmrInfo('${mr.machineRoomUnAssignSeatNums }','${mr.machineRoomID}')"><i class="fa fa-info-circle"></i> <small>分配</small>
											</a>
										</li>
									</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>

			</div>
			<!-- end: TABLE WITH IMAGES PANEL -->
		</div>

		<div class="modal fade" id="AdminChoucha" tabindex="-1" role="dialog" aria-labelledby="alterModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
						<h4 class="modal-title" id="alterModalLabel">机房座位号分配</h4>
					</div>

					<div class="modal-body">
						剩余可选范围：<label id="scope"></label> </br>
					</div>

					<div>
						<form class="form-inline" role="form">
							<div class="form-group" style="margin-left: 100px;">
								<input type="email" class="form-control" id="exampleInputEmail2" placeholder="起始座位号">
							</div>
							<div class="form-group">
								<input type="email" class="form-control" id="exampleInputEmail2" placeholder="结束座位号">
							</div>
							<button type="button" class="btn btn-default btn-primary" onclick="check()">确定</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- 消息提示框 -->

		<script src="assets/plugins/jquery-inputlimiter/jquery.inputlimiter.1.3.1.min.js"></script>
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