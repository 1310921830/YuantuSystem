<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>风险报告列表</title>
 	<script language="javascript" src="js/jquery.js"></script>
    <link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body>
	<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 风险报告列表
        </div>
        <div id="Title_End"></div>
    </div>
	</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td>报告日期</td>
            	<td>报告名称</td>
            	<td>风险等级</td>
            	<td>是否审核</td>
                <td>是否通过</td>
                <td>更多操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="roleList">
			<c:forEach items="${riskReports}" var="report">
			<tr class="TableDetail1 template" align="CENTER">
				<td>${report.date}</td>
				<td>${report.title}</td>
				<td>${report.riskLevel}</td>
				<td>${report.isCheck}</td>
				<td>${report.isPass}</td>
				<td><img src="style/images/ar.gif"><a href="riskReportDetail?id=${report.id}&projectId=${project.id}">
				查看详细</a></td>
			</tr>
			</c:forEach>
        </tbody>
    </table>
    
    <!-- 跳转到创建项目页面 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            
        </div>
    </div>
</div>
	
	
</body>
</html>