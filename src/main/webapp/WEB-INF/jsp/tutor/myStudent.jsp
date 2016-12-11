<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cc
  Date: 15/12/10
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    href="./${sessionScope.pathCode}/home.do"> 首页 </a>
            </li>
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
        <!-- start: TABLE WITH IMAGES PANEL -->
        <div class="panel-body">
        	<div class="tabbable">
                <table class="table table-hover"
                       style="TABLE-LAYOUT:fixed;WORD-BREAK:break-all">
                    <thead>
                    <tr>
                        <th width="5%"><small>编号</small></th>
                        <th width="12%">
                            <small>学号</small>
                        </th>
                        <th width="8%">
                            <small>学生姓名</small>
                        </th>
                        <th width="5%">
                            <small>性别</small>
                        </th>
                        <th width="12%">
                            <small>班级</small>
                        </th>
                        <th width="13%">
                            <small>联系方式</small>
                        </th>
                       
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="s" varStatus="i">
                        <tr>
                           
                            <td><small>${i.index + 1}</small></td>
                            <td>
                                <small>${s.stuStudentId}</small>
                            </td>
                            <td>
                                <small>${s.stuName}</small>
                            </td>
                            <td>
                                <small>${s.stuSex ? "女" : "男"}</small>
                            </td>
                            <td>
                                <small>${s.stuClass}</small>
                            </td>
                            <td>
                                <small>${s.stuTell}</small>
                            </td>
                          
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                  </div>
               </div>
            </div>
    </div>
</div>
</body>
</html>
