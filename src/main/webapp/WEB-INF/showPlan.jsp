<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />
<script src="js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<!-- 标题显示 -->
<DIV ID="Title_bar">
    <DIV ID="Title_bar_Head">
        <DIV ID="Title_Head"></DIV>
        <DIV ID="Title"><!--页面标题-->
            <IMG BORDER="0" WIDTH="13" HEIGHT="13" SRC="style/images/title_arrow.gif"/> 项目计划展示
        </DIV>
        <DIV ID="Title_End"></DIV>
    </DIV>
</DIV>

<!--显示表单内容-->
<DIV ID=MainArea>
    	<form>
        <DIV CLASS="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="style/blue/images/item_point.gif" /> 部署流程定义 </DIV>  -->
        </DIV>
        
        <!-- 表单内容显示 -->
        <DIV CLASS="ItemBlockBorder">
            <DIV CLASS="ItemBlock">
                <TABLE CELLPADDING="0" CELLSPACING="0" CLASS="mainForm">
                    <TR>
						<TD><DIV CLASS="FuncBtn">
                          
                            <DIV class=FuncBtnMemo>项目计划表</DIV>
 
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
					<TD STYLE="border-bottom: 1px solid #94C6E7;" width="100">项目名称</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;" width="100">
						<c:out value="${project.projectName}"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;" width="100">项目编号</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;" width="100">
						<c:out value="${project.id}"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;" width="100">制作人</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;" width="100">
						<c:out value="${prepared.name}"></c:out>
					</TD>
				</TR>
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">审核人</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
						<c:out value="${checked.name}"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">项目经理</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
						<c:out value="${prepared.name}"></c:out>
					</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">制作日期</TD>
					<TD STYLE="border-bottom: 1px solid #94C6E7;">
						<c:out value="${plan.date}"></c:out>
					</TD>
				</TR>
			</TBODY>
			
		</TABLE>
		<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle" STYLE="width: 90%">
			<THEAD><!-- 表头-->
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD colspan="6" align="left">&nbsp;&nbsp;二、项目描述</TD>
				</TR>
			</THEAD>
			<TBODY>
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
				    <TD colspan="6" align="left" STYLE="border-bottom: 1px solid #94C6E7;">&nbsp;&nbsp;1.项目背景与目的(所有项目均起源于某个商业问题，简要描述这些问题)</TD>
				</TR>
				<tr ALIGN=center VALIGN=middle ID=TableTitle>
				<td colspan="6" rowspan="10" align="left" STYLE="border-bottom: 1px solid #94C6E7;">
				<textarea name="intro" rows="8" cols="125" readonly="readonly"><c:out value="${plan.bgTarget }"></c:out>
				</textarea> 
				</td>
				</tr>
			</TBODY>
			
		</TABLE>
		<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle" STYLE="width: 90%">
			<THEAD><!-- 表头-->
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD colspan="6" align="left">&nbsp;&nbsp;2.项目目标(包含质量目标，工期目标，费用目标和交付产品特征与特征的主要描述)</TD>
				</TR>
			</THEAD>
			<TBODY>
				<tr ALIGN=center VALIGN=middle ID=TableTitle>
				<td colspan="6" rowspan="10" align="left" STYLE="border-bottom: 1px solid #94C6E7;">
				<textarea name="intro" rows="4" cols="125" readonly="readonly"><c:out value="${plan.aim}"></c:out>
				</textarea> 
				</td>
				</tr>
			</TBODY>
			
		</TABLE>
		<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle" STYLE="width: 90%">
			<THEAD><!-- 表头-->
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD colspan="6" align="left">&nbsp;&nbsp;三、项目里程碑计划(包含里程碑的时间和结果)</TD>
				</TR>
			</THEAD>
			<TBODY>
				<tr ALIGN=center VALIGN=middle ID=TableTitle>
				<td colspan="6" rowspan="10" align="left" STYLE="border-bottom: 1px solid #94C6E7;">
				<textarea name="intro" rows="5" cols="125" readonly="readonly"><c:out value="${plan.milestones }"></c:out>
				</textarea> 
				</td>
				</tr>
			</TBODY>
			
		</TABLE>
		<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle" STYLE="width: 90%">
			<THEAD><!-- 表头-->
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD colspan="6" align="left">&nbsp;&nbsp;四、评价标准(说明项目成果在何种情况下将被接受)</TD>
				</TR>
			</THEAD>
			<TBODY>
				<tr ALIGN=center VALIGN=middle ID=TableTitle>
				<td colspan="6" rowspan="10" align="left" STYLE="border-bottom: 1px solid #94C6E7;">
				<textarea name="intro" rows="8" cols="125" readonly="readonly"><c:out value="${plan.standard }"></c:out>
				</textarea> 
				</td>
				</tr>
			</TBODY>
			
		</TABLE>
		<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle" STYLE="width: 90%">
			<THEAD><!-- 表头-->
				<TR ALIGN=center VALIGN=middle ID=TableTitle>
					<TD colspan="6" align="left">&nbsp;&nbsp;五、项目假定与约束条件(说明项目的主要假设条件和限制条件)</TD>
				</TR>
			</THEAD>
			<TBODY>
				<tr ALIGN=center VALIGN=middle ID=TableTitle>
				<td colspan="6" rowspan="10" align="left" STYLE="border-bottom: 1px solid #94C6E7;">
				<textarea name="intro" rows="5" cols="125" readonly="readonly"><c:out value="${plan.requirement}"></c:out>
				</textarea> 
				</td>
				</tr>
			</TBODY>
			
		</TABLE>
    </form>
</DIV>
<DIV ID="InputDetailBar">
<c:if test="${plan.preparedName eq user.userId}">
	是否审核：<c:out value="${plan.isCheck }"></c:out>
	是否通过：<c:out value="${plan.isPass }"></c:out>
	批注意见：<c:out value="${plan.opinion }"></c:out>
</c:if>
<c:if test="${plan.reviewedName eq user.userId}">
	<c:if test="${'是' eq plan.isCheck }">
		是否审核：<c:out value="${plan.isCheck }"></c:out>
		是否通过：<c:out value="${plan.isPass }"></c:out>
		批注意见：<c:out value="${plan.opinion }"></c:out>
	</c:if>
	<c:if test="${'否' eq plan.isCheck }">
		是否通过：<c:out value="${plan.isPass }"></c:out>
		批注意见：<c:out value="${plan.opinion }"></c:out>
		<input type="button" value="审核">
	</c:if>
</c:if>

<a href="download?path=${plan.link}">附件下载</a>
</DIV>
<DIV CLASS="Description">

</DIV>
</body>
</html>