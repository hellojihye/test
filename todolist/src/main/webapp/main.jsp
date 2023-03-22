<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.connect.dto.TodoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./mystyle.css">
</head>
<body>
<div id="container">
<ul id="todo">
	<li id="title">TODO</li>
	<c:forEach items="${list }" var="item">
		<c:choose>
		<c:when test="${item.getType().equals('TODO')}">
			<li>
				<h3>${item.getTitle() }</h3>
				<a>등록날짜:${item.getRegDate() }, ${item.getName() }, 우선순위${item.getSequence() }</a>
			</li>
		</c:when>
		</c:choose>
	</c:forEach>
</ul>
<ul id="doing">
	<li id="title">DOING</li>
	<c:forEach items="${list }" var="item">
		<c:choose>
		<c:when test="${item.getType().equals('DOING')}">
			<li>
				<h3>${item.getTitle() }</h3>
				<a>등록날짜:${item.getRegDate() }, ${item.getName() }, 우선순위${item.getSequence() }</a>
			</li>
		</c:when>
		</c:choose>
	</c:forEach>
</ul>
<ul id="done">
	<li id="title">DONE</li>
	<c:forEach items="${list }" var="item">
		<c:choose>
		<c:when test="${item.getType().equals('DONE')}">
			<li>
				<h3>${item.getTitle() }</h3>
				<a>등록날짜:${item.getRegDate() }, ${item.getName() }, 우선순위${item.getSequence() }</a>
			</li>
		</c:when>
		</c:choose>
	</c:forEach>
</ul>
</div>
</body>
</html>