<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ include file="/WEB-INF/jsp/view/main/search.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserList</title>
</head>
<body>
	<table id="box-table-a" class="table table-hover">
		<thead>
			<tr>
				<th scope="col">No</th>
				<th scope="col">Name</th>
				<th scope="col">Created_Date</th>
			</tr>
		</thead>
		<tbody>

	<c:forEach var="post" items="${posts}">
		<tr>
			<th scope="row">${post.no }</th>
			<td><a href="<%=request.getContextPath()%>/diners/dinersDetail.do?diners_no=${post.no }">${post.diner_name}</a></td>
			<td>${post.posting_date}</td>
			
			
		</tr>
	</c:forEach>
		</tbody>
	
</body>
</html>