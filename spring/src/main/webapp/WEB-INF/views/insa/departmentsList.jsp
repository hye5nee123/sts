<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>부서 이름</h3>
	<c:forEach items="${departments}" var="departments">
		<div style="border: 1px solid blue;">
			<span>${departments.departmentId}</span>
			<span>${departments.departmentName}</span> 
			<span>${departments.managerId}</span>
			<span>${departments.locationId}</span>
		</div>
	</c:forEach>
</body>
</html>