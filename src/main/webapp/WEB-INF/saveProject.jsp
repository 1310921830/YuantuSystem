<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			if ($("#i1").val().length == 0) {
				alert("项目名称不能为空");
			} else if ($("#i2").val().length == 0) {
				alert("发起人不能为空");
			} else if ($("input:checkbox:checked").length == 0) {
				alert("项目成员不能为空");
			} else {

				$.ajax({
					type : "post",
					url : "saveProject",
					data : $('#form').serialize(),
					success : function(data) {
						if (data == 1) {
							alert("立项成功!");
							$('#form')[0].reset();
						} else {
							alert("立项失败!");
							$('#form')[0].reset();
						}

					},
					error : function() {
						//提交失败的提示词或者其他反馈代码

					}
				});
			};
			
		});
	})
</script>
</head>
<body>
	<form action="saveProject" method="post" id="form">
		<table align="center">
			<tr>
				<td>项目名称</td>
				<td><input type="text" name="projectName" id="i1"></td>
			</tr>
			<tr>
				<td>发起人</td>
				<td><input type="text" name="founder" id="i2"></td>
			</tr>
			<tr>
				<td>部门经理</td>
				<td><select name="deptManagerId">
						<c:forEach items="${deptManagers}" var="user">
							<option value="${user.userId}">${user.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>项目经理</td>
				<td><select name="projectManagerId">
						<c:forEach items="${projectManagers}" var="user">
							<option value="${user.userId}">${user.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>项目成员</td>
				<td><c:forEach items="${emps}" var="user">
						${user.name}<input type="checkbox" name="staffs"
							value="${user.userId}">
					</c:forEach></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="确认" id="btn">
				</td>

			</tr>
		</table>
	</form>
</body>
</html>