<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http//java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.firstRow {
	color: yellowgreen;
}

.oddRow {
	color: cyan;
}

.backColor {
	background-color: #eeeeee
}
</style>
</head>
<body>
	<h1>BoardList</h1>
	<div>
		<table>
			<thead>
				<tr>
					<th>No.</th>
					<th>title</th>
					<th>writer</th>
					<th>write_date</th>
					<th>click_cnt</th>
				</tr>
			</thead>
			<tbody>
				<tr th:each="board, stat: ${boardList}">
					<td th:text="${stat.count}"></td>
					<td th:text="${board.title}"></td>
					<td th:text="${board.writer}"></td>
					<td th:text="${board.writeDate}"></td>
					<td th:text="${board.clickCnt}"></td>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>