<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.1.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />
<style type="text/css">
	#matters{
		width:100px;
		height:475px;
		float: right;
		border:3px solid #4891c6;
		position: relative;
		top:-415px;
	}
	#matters a{
		display: block;
		width:80%;
		height:20px;
		margin-bottom: 20px;
		margin-top:20px;
		color:#004779;
		padding-left: 10px;
		background: url("style/blue/images/menu_btn_bg.gif");
		
	}
</style>
</head>
<body>
	<!-- 标题显示 -->
<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="style/images/title_arrow.gif"/> 项目信息展示
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>

<!--显示表单内容-->
<DIV ID=MainArea>
    <FORM ACTION="list.html">
        <DIV CLASS="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="style/blue/images/item_point.gif" /> 部署流程定义 </DIV>  -->
        </DIV>
        
        <!-- 表单内容显示 -->
        <DIV CLASS="ItemBlockBorder">
            <DIV CLASS="ItemBlock">
                <TABLE CELLPADDING="0" CELLSPACING="0" CLASS="mainForm">
                    <TR>
						<TD><DIV CLASS="FuncBtn">
                          
                            <DIV class=FuncBtnMemo>项目信息表</DIV>
 
                        </DIV></TD>
                    </TR>
                </TABLE>
            </DIV>
        </DIV>
		
		<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle" STYLE="width: 90%">
			<THEAD><!-- 表头-->
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD colspan="6" align="left">&nbsp;&nbsp;一、项目基本情况</TD>
				</TR>
			</THEAD>
			<TBODY>
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">项目名称</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
						<c:out value="${project.projectName}"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">项目编号</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
						<c:out value="${project.id}"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">发起人</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
						<c:out value="${project.founder}"></c:out>
					</TD>
				</TR>
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">成立时间</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
						<c:out value="${project.establishedTime}"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">项目状态</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
						<c:out value="${project.status}"/>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">部门经理</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
						<c:out value="${deptManager.name }"></c:out>
					</TD>
				</TR>
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">项目经理</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
						<c:out value="${projectManager.name }"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;"></TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;"></TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;"></TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;"></TD>
				</TR>
			</TBODY>
			
		</TABLE>
		<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle" STYLE="width: 90%">
			<THEAD><!-- 表头-->
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD colspan="6" align="left">&nbsp;&nbsp;二、项目组成员</TD>
				</TR>
			</THEAD>
			<TBODY>
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">项目角色</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">成员姓名</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">性别</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">年龄</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">员工号</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">部门号</TD>
				</TR>
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">项目经理</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
					<c:out value="${projectManager.name }"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
					<c:out value="${projectManager.gender }"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
					<c:out value="${projectManager.age }"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
					<c:out value="${projectManager.userId }"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
					<c:out value="${projectManager.deptNo }"></c:out>
					</TD>
				</TR>
				<c:forEach items="${users}" var="user">
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">项目核心成员</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
					<c:out value="${user.name }"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
					<c:out value="${user.gender }"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
					<c:out value="${user.age }"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
					<c:out value="${user.userId }"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
					<c:out value="${user.deptNo }"></c:out>
					</TD>
				</TR>
				</c:forEach>
				
			</TBODY>
			
		</TABLE>
		<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle" STYLE="width: 90%">
			<THEAD><!-- 表头-->
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD colspan="6" align="left">&nbsp;&nbsp;三、项目查看</TD>
				</TR>
			</THEAD>
			<TBODY>
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD STYLE="border-bottom: 1px solid #94C6E7;"> 
					<img alt="" src="style/images/search.gif">
					<a href="showPlan?projectId=${project.id}">项目计划</a>
					<a href="">日报</a>
					<a href="">周报</a>
					<a href="">重大事项</a>
					<a href="">风险报告</a>
					<a href="">会议记录</a>
                    <a href="">项目花费</a>
                    <a href="showConcluding?projectId=${project.id}">结题报告</a>
					</TD>
				</TR>
			</TBODY>
			
		</TABLE>
		
    </FORM>
</DIV>
<div id="matters">
	<img alt="" src="style/images/forumpage3.gif">
	<c:if test="${'项目经理' eq user.position}">
		<a href="addPlan?projectId=${project.id}"><b>制定项目计划</b></a>
		<a><b>分配任务</b></a>
		<a><b>提交周报</b></a>
		<a><b>财务支出</b></a>
		<a><b>奖惩/绩效</b></a>
		<a><b>风险报告提交</b></a>
		<a><b>会议记录存档</b></a>
		<a href="addConcluding?projectId=${project.id}"><b>结题报告提交</b></a>
	</c:if>
</div>

<DIV CLASS="Description">
	
</DIV>
</body>
</html>