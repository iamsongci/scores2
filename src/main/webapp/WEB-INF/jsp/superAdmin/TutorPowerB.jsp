<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>教师基本信息</title>
    <link rel="stylesheet" href="assets/plugins/select2/select2.css">
    <script type="text/javascript">
        function tutorId(id){
                         $.ajax({
                          type: "post",
                         url: "./${sessionScope.pathCode}/resetPassword.do",
             data: {TutorId:id},
             dataType: "json",
             
         });
        }
    </script>
</head>
<body>
<!-- start: PAGE HEADER -->
<div class="row">
    <div class="col-sm-12">
        <!-- start: PAGE TITLE & BREADCRUMB -->
        <ol class="breadcrumb">
            <li><i class="clip-home-3"></i> <a href="./${sessionScope.pathCode}/home.do"> 首页 </a></li>
            <li class="active">导师成绩汇总权限</li>
        </ol>
        <div class="page-header">
            <h3>导师成绩汇总权限/<a href="./${sessionScope.pathCode}/selectTutorPower1.do">分配权限管理</a></h3>
        </div>
        <!-- end: PAGE TITLE & BREADCRUMB -->
    </div>
</div>


<!-- end: PAGE HEADER 頭部結束-->
<div class="row">
    <div class="col-md-12">
        <div class="panel-body">
            <table class="table  table-hover">
                <thead>
                <tr>
                    <th>
                        <small>教师工号</small>
                    </th>
                    <th>
                        <small>姓名</small>
                    </th>
                    <th>
                        <small>性别</small>
                    </th>
                    <th>
                        <small>联系方式</small>
                    </th>
                    <th>
                        <small>成绩汇总权限管理</small>
                    </th>
                    <th>
                        <small>操作</small>
                    </th>
                </tr>
                </thead>
                <c:forEach items="${tutorInfoList}" var="tutor">
                    <tbody>
                    <tr>
                        <td>
                            <small>${tutor.tutorID}</small>
                        </td>
                        <td>
                            <small>${tutor.tutorName}</small>
                        </td>
                        <c:choose>
                            <c:when test="${tutor.tutorSex eq false}">
                                <td>
                                    <small>男</small>
                                </td>
                            </c:when>
                            <c:when test="${tutor.tutorSex eq true}">
                                <td>
                                    <small>女</small>
                                </td>
                            </c:when>
                        </c:choose>
                        
                        <td>
                            <small>${tutor.tutorPhone }</small>
                        </td>
                        <td>
                            <c:if test="${tutor.projectName eq null }">
                            <small>无</small></c:if>
                            <c:if test="${tutor.projectName ne null }">
                            <small>${tutor.projectName}</small>
                            </c:if>
                            
                        </td>
                       <td>
                            <div class="visible-md visible-lg hidden-sm hidden-xs">
                                <a href="./${sessionScope.pathCode}/updateTutorInfoA.do?tutorID=${tutor.tutorID}">
                                    <i class="fa fa-info-circle"></i>
                                    <small>修改权限</small>
                                </a>
                                <a href="javaScript:void(0);" data-toggle="modal" data-target="#pwdM">
                                    <i class="fa fa-info-circle"></i>
                                    <small onclick="tutorId(${tutor.tutorID})">重置权限</small>
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
                <page:createPager pageSize="${pageSize}" totalPage="${totalPage}" totalCount="${totalCount}"
                                  curPage="${pageNum}" formId="condition"/>
            </div>
</div>
            
        </div>
        
    </div>
    <!-- end: TABLE WITH IMAGES PANEL -->
</div>


<!-- Modal    重置密码提示 -->
<div class="modal fade" id="pwdM" tabindex="-1"  aria-labelledby="pwdT">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="pwdT">重置密码</h4>
            </div>
            <div class="modal-body">
              密码已重置为:123456<br/>
                <p></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>

</div>

<script src="assets/plugins/jquery-inputlimiter/jquery.inputlimiter.1.3.1.min.js"></script><!-- 3 -->
<script src="assets/plugins/autosize/jquery.autosize.min.js"></script><!-- 1 -->
<script src="assets/plugins/select2/select2.min.js"></script><!-- 2 -->
<script src="assets/js/form-elements.js"></script><!-- 4 -->
<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script>


</script>

</body>
</html>
