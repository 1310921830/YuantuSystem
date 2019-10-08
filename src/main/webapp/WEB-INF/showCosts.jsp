<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>财务支出列表</title>
 	<script src="js/jquery-3.1.1.min.js"></script>
	<link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />
	<link rel="stylesheet" type="text/css" href="style/easyui.css">
	<link rel="stylesheet" type="text/css" href="style/icon.css">
	<link rel="stylesheet" type="text/css" href="style/demo.css">
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
    	$(function() {
    		
		})
    </script>
</head>
<body>
	<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 财务支出列表
        </div>
        <div id="Title_End"></div>
    </div>
	</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td>支出日期</td>
            	<td>支出类型</td>
            	<td>金额</td>
            	<td>项目阶段</td>
            	<td>备注</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="roleList">
			<c:forEach items="${costs}" var="cost">
			<tr class="TableDetail1 template" align="CENTER">
				<td>${cost.date}</td>
				<td>${cost.type}</td>
				<td>￥${cost.money}</td>
				<td>
					第${cost.week }周
				</td>
				<td>
					<textarea cols="26" rows="2"><c:out value="${cost.remark}"></c:out> 
					</textarea>
				</td>
			</tr>
			</c:forEach>
        </tbody>
    </table>
    
    <!-- 跳转到创建项目页面 -->
    <div id="TableTail">
        <div id="pp" class="easyui-pagination" style="background:#efefef;border:1px solid #ccc;"
    		data-options="total:2000,pageSize:10">
		</div>
    </div>
</div>

	
</body>
</html>