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
			<DIV ID="Title">
				<!--页面标题-->
				<IMG BORDER="0" WIDTH="13" HEIGHT="13"
					SRC="style/images/title_arrow.gif" /> 项目总结
			</DIV>
			<DIV ID="Title_End"></DIV>
		</DIV>
	</DIV>

	<!--显示表单内容-->
	<DIV ID=MainArea>
		<FORM id="form" action="addPlan" method="post">
			<DIV CLASS="ItemBlock_Title1">
				<!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="style/blue/images/item_point.gif" /> 部署流程定义 </DIV>  -->
			</DIV>

			<!-- 表单内容显示 -->
			<DIV CLASS="ItemBlockBorder">
				<DIV CLASS="ItemBlock">
					<TABLE CELLPADDING="0" CELLSPACING="0" CLASS="mainForm">
						<TR>
							<TD><DIV CLASS="FuncBtn">

									<DIV class=FuncBtnMemo>项目总结表</DIV>

								</DIV></TD>
						</TR>
					</TABLE>
				</DIV>
			</DIV>

			<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle"
				STYLE="width: 90%">
				<THEAD>
					<!-- 表头-->
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
						<c:out value="${concluding.date}"></c:out>
					</TD>
				</TR>

				</TBODY>

			</TABLE>
			<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle"
				STYLE="width: 90%">
				<THEAD>
					<!-- 表头-->
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD colspan="6" align="left">&nbsp;&nbsp;二、项目完成情况总结</TD>
					</TR>
				</THEAD>
				<TBODY>
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD colspan="6" align="left"
							STYLE="border-bottom: 1px solid #94C6E7;">&nbsp;&nbsp;1.时间总结</TD>
					</TR>
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD STYLE="border-bottom: 1px solid #94C6E7;">开始时间</TD>
						<TD STYLE="border-bottom: 1px solid #94C6E7;">
							<c:out value="${concluding.startTime}"></c:out></TD>
						<TD STYLE="border-bottom: 1px solid #94C6E7;">计划完成日期</TD>
						<TD STYLE="border-bottom: 1px solid #94C6E7;">
							<c:out value="${concluding.exceptedFinishDate}"></c:out>
							</TD>
						<TD STYLE="border-bottom: 1px solid #94C6E7;">实际完成日期</TD>
						<TD STYLE="border-bottom: 1px solid #94C6E7;">
							<c:out value="${concluding.actualFinishDate}"></c:out>
							</TD>
					</TR>
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD colspan="6" align="left"
							STYLE="border-bottom: 1px solid #94C6E7;">&nbsp;&nbsp;时间（差异）分析 </TD>
					</TR>
					<tr ALIGN=center VALIGN=middle ID=TableTitle>
						<td colspan="6" rowspan="10" align="left"
							STYLE="border-bottom: 1px solid #94C6E7;"><textarea
								name="timeAnalysis" rows="4" cols="125" class="i1"><c:out value="${concluding.timeAnalysis}"></c:out></textarea></td>
					</tr>
				</TBODY>

			</TABLE>
			<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle"
				STYLE="width: 90%">
				<THEAD>
					<!-- 表头-->
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD colspan="4" align="left">&nbsp;&nbsp;2.成本总结</TD>
					</TR>
				</THEAD>
				<TBODY>
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD STYLE="border-bottom: 1px solid #94C6E7;">计划费用</TD>
						<TD STYLE="border-bottom: 1px solid #94C6E7;">
							<c:out value="${concluding.expectedExpense}"></c:out></TD>
						<TD STYLE="border-bottom: 1px solid #94C6E7;">实际费用</TD>
						<TD STYLE="border-bottom: 1px solid #94C6E7;">
							<c:out value="${concluding.actualExpense}"></c:out>
							</TD>
						
					</TR>
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD colspan="4" align="left"
							STYLE="border-bottom: 1px solid #94C6E7;">&nbsp;&nbsp;成本（差异）分析 </TD>
					</TR>
					<tr ALIGN=center VALIGN=middle ID=TableTitle>
						<td colspan="4" rowspan="10" align="left"
							STYLE="border-bottom: 1px solid #94C6E7;"><textarea
								name="costAnalysis" rows="4" cols="125" class="i1"><c:out value="${concluding.costAnalysis}"></c:out></textarea></td>
					</tr>
				</TBODY>

			</TABLE>
			<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle"
				STYLE="width: 90%">
				<THEAD>
					<!-- 表头-->
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD colspan="6" align="left">&nbsp;&nbsp;2.交付结果总结</TD>
					</TR>
				</THEAD>
				<TBODY>
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD colspan="6" align="left"
							STYLE="border-bottom: 1px solid #94C6E7;">&nbsp;&nbsp;计划交付结果 </TD>
					</TR>
					<tr ALIGN=center VALIGN=middle ID=TableTitle>
						<td colspan="6" rowspan="10" align="left"
							STYLE="border-bottom: 1px solid #94C6E7;"><textarea
								name="exceptDeliverables" rows="4" cols="125" class="i1"><c:out value="${concluding.exceptDeliverables}"></c:out></textarea></td>
					</tr>
					
				</TBODY>

			</TABLE>
			<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle"
				STYLE="width: 90%">
				<THEAD>
					<!-- 表头-->
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD colspan="6" align="left">&nbsp;&nbsp;实际交付结果</TD>
					</TR>
				</THEAD>
				<TBODY>
					
					<tr ALIGN=center VALIGN=middle ID=TableTitle>
						<td colspan="6" rowspan="10" align="left"
							STYLE="border-bottom: 1px solid #94C6E7;"><textarea
								name="actualDeliverables" rows="4" cols="125" class="i1"><c:out value="${concluding.actualDeliverables}"></c:out></textarea></td>
					</tr>
				</TBODY>

			</TABLE>
			<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle"
				STYLE="width: 90%">
				<THEAD>
					<!-- 表头-->
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD colspan="6" align="left">&nbsp;&nbsp;未交付结果</TD>
					</TR>
				</THEAD>
				<TBODY>
					
					<tr ALIGN=center VALIGN=middle ID=TableTitle>
						<td colspan="6" rowspan="10" align="left"
							STYLE="border-bottom: 1px solid #94C6E7;"><textarea
								name="undeliverables" rows="4" cols="125" class="i1"><c:out value="${concluding.undeliverables}"></c:out></textarea></td>
					</tr>
				</TBODY>

			</TABLE>
			<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle"
				STYLE="width: 90%">
				<THEAD>
					<!-- 表头-->
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD colspan="6" align="left">&nbsp;&nbsp;交付结果（差异）分析</TD>
					</TR>
				</THEAD>
				<TBODY>
					
					<tr ALIGN=center VALIGN=middle ID=TableTitle>
						<td colspan="6" rowspan="10" align="left"
							STYLE="border-bottom: 1px solid #94C6E7;"><textarea
								name="deliverablesAnalysis" rows="4" cols="125" class="i1"><c:out value="${concluding.deliverablesAnalysis}"></c:out></textarea></td>
					</tr>
				</TBODY>

			</TABLE>
			<TABLE CELLSPACING="0" CELLPADDING="0" CLASS="TableStyle"
				STYLE="width: 90%">
				<THEAD>
					<!-- 表头-->
					<TR ALIGN=center VALIGN=middle ID=TableTitle>
						<TD colspan="6" align="left">&nbsp;&nbsp;三、项目经验、教训总结</TD>
					</TR>
				</THEAD>
				<TBODY>
					
					<tr ALIGN=center VALIGN=middle ID=TableTitle>
						<td colspan="6" rowspan="10" align="left"
							STYLE="border-bottom: 1px solid #94C6E7;"><textarea
								name="experience" rows="4" cols="125" class="i1"><c:out value="${concluding.experience}"></c:out></textarea></td>
					</tr>
				</TBODY>

			</TABLE>
			
		</FORM>

		

	</DIV>
	<DIV ID="InputDetailBar">
		<c:if test="${concluding.preparedName eq user.userId}">
	是否审核：<c:out value="${concluding.isCheck }"></c:out>
	是否通过：<c:out value="${concluding.isPass }"></c:out>
	批注意见：<c:out value="${concluding.opinion }"></c:out>
</c:if>
<c:if test="${concluding.reviewedName eq user.userId}">
	<c:if test="${'是' eq concluding.isCheck }">
		是否审核：<c:out value="${concluding.isCheck }"></c:out>
		是否通过：<c:out value="${concluding.isPass }"></c:out>
		批注意见：<c:out value="${concluding.opinion }"></c:out>
	</c:if>
	<c:if test="${'否' eq concluding.isCheck }">
		是否通过：<c:out value="${concluding.isPass }"></c:out>
		批注意见：<c:out value="${concluding.opinion }"></c:out>
		<input type="button" value="审核">
	</c:if>
</c:if>

<a href="download?path=${concluding.link}">附件下载</a>
	</DIV>
	<DIV CLASS="Description"></DIV>
</body>
</html>