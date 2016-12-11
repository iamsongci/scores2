<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>机房信息</title>
<link rel="stylesheet" href="assets/plugins/select2/select2.css">
<script type="text/javascript">

	function init(id, num) {
	    //向模态框中传值  
	    $('#id').val(id);  
	    $('#num').val(num);  
	    $('#update').modal('show');  
	}
	
	function update() {
		var id = $('#id').val();  
	    var num = $('#num').val();  
	    
	    if(num == 0) {
	    	alert("机位数不能为0!");
	    	return;
	    }
	    
	    $.ajax({  
	        type: "post",  
	        url: "./${sessionScope.pathCode}/updateMrSeatNum.do",  
	        data: "id=" + id + "&num=" + num,  
	        dataType: 'html',  
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",  
	        success: function(result) {  
	            location.reload();  
	        }, 
		    error: function(request) {
	            alert("Connection error!");
	        }
	    });
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
				<li><i class="clip-home-3"></i> <a
					href="./${sessionScope.pathCode}/home.do"> 首页 </a></li>
				<li class="active">个人信息</li>
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
							<th><small>操作</small></th>
						</tr>
					</thead>
					<c:forEach items="${mrInfo}" var="mr">
						<tbody>
							<tr>
								<td><small>${mr.machineRoomID}</small></td>
								<td><small>${mr.machineRoomSeatNums}</small></td>
								<td>
									<div class="visible-md visible-lg hidden-sm hidden-xs">
										<a data-target="#update" data-toggle="modal"
											onclick="init(${mr.machineRoomID}, ${mr.machineRoomSeatNums})">
											<i class="fa fa-info-circle"></i> <small>修改</small>
										</a>
									</div>
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
		<!-- end: TABLE WITH IMAGES PANEL -->
	</div>
	
	<!-- 模态框（Modal） -->  
	<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">  
	    <div class="modal-dialog">  
	        <div class="modal-content">  
	            <div class="modal-header">  
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>  
	                <h4 class="modal-title" id="myModalLabel">修改信息</h4>  
	            </div>  
	            <div class="modal-body">  
	          
				               机房号：<input type="text" name="id" id="id" readonly="readonly" />   
				               机位数：<input type="text" name="num" id="num"/>   
	            </div>  
	            <div class="modal-footer">  
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
	                <button type="button" class="btn btn-primary" onclick="update()">提交更改</button>  
	            </div>  
	        </div>  
	        <!-- /.modal-content -->  
	    </div>  
	    <!-- /.modal -->  
	</div>  
	<!-- 模态框（Modal）end -->  
	
	
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
