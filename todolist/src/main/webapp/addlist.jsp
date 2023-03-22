<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<h2>할일 등록</h2>
		<p>어떤 일인가요?</p>
		<input type="text" name="what" required="required">
		<p>누가 할일인가요?</p>
		<input type="text" name="who" required="required">
		<p>우선순위를 선택하세요</p>
		<input type="radio" value="1" name="priority" required>1순위
		<input type="radio" value="2" name="priority">2순위
		<input type="radio" value="3" name="priority">3순위
		<br>
		<a href="./main.jsp">&lt;이전</a>
		<input type="submit" value="제출" >
		<input type="reset" value="내용지우기">
	</form>
</body>
</html>