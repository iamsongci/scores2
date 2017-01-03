

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>软件学院实践课题管理系统</title>

<script type="text/javascript">

	function Assign(studentID, tutorID, proID, tutorName, className) {
		$.ajax({
			type : "post",
			url : "./${sessionScope.pathCode}/assignStudent.do?",
			data : "studentID=" + studentID + "&tutorID=" + tutorID  + "&proID=" + proID + "&tutorName=" + tutorName + "&className=" + className,
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
	
	
	function sumbit(tutorID, proID, tutorName, className) {
		var studentID = "";
		var cb= document.getElementsByName('a');
		var stuID = document.getElementsByName("stuID");
        for(var i = 0; i < cb.length; i++){
            if(cb[i].checked) {
            	studentID = studentID + stuID[i].innerHTML + ",";
            }
        }
        if(studentID == "") {
        	alert("请选择学生!");
        	return;
        }
        Assign(studentID, tutorID, proID, tutorName, className);
	}
	

	function selectAll() {
        var cb= document.getElementsByName('a');
        for(var i = 0; i < cb.length; i++){
            cb[i].checked = !cb[i].checked;
        }
	}
	
	function find(tutorID, proID, tutorName) {
		
		var name = $("#contactsName").find("option:selected").val();
		if(name == "请选择") {
			alert("请选择查询班级！");
			return;
		}
		
		var url = "./${sessionScope.pathCode}/assign.do?proID=" + proID + "&tutorID=" + tutorID + "&tutorName=" + tutorName + "&className=" + name;
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
							<select name="contactsName" id="contactsName" class="form-control" style=" width: 30%; float : left; margin-bottom: 25px">
	                        	<option value="请选择">请选择</option>
	                        	<c:forEach items="${nameList }" var="name" varStatus="i">
	                                <option value="${name.str}">${name.str}</option>
	                            </c:forEach>
	                        </select> 
	                        <button type="button" class="btn btn-info" onclick="find('${tutorID}', '${proID}', '${tutorName}')" style="margin-left: 15px; margin-bottom: 25px">查询</button>
	                        
	                    </tr>
	                    
						<tr>
							<th>
								<input type="button" class="btn btn-info" id="all" value="反选" onclick="selectAll()"/>
								<button type="button" class="btn btn-info" onclick="sumbit('${tutorID}', '${proID}', '${tutorName}', '${className}')" style="margin-left: 20px" >提交</button>
							</th>
							<th><small>学号</small></th>
							<th><small>姓名</small></th>
							<th><small>班级</small></th>
							<th><small>分配</small></th>
						</tr>
					</thead>
					<c:forEach items="${stuList}" var="stu">
						<tbody>
							<tr>
								<td><input type="checkbox" name="a" style="margin-left: 50px"></td>
								<td><small name="stuID">${stu.studentID}</small></td>
								<td><small>${stu.studentName}</small></td>
								<td><small>${stu.className}</small></td>

								<th><button type="button" class="btn btn-info"
										onclick="Assign('${stu.studentID}', '${tutorID}', '${proID}', '${tutorName}', '${className}')">分配</button></th>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
