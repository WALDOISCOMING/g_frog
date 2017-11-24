<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>


		<tr>
			<th scope="row">diners</th><br>
			<td>${dinersVO_no}</td><br>
			<td>${dinersVO_name}</td><br>
			<td>${dinersVO_intro}</td><br>
		
			
		</tr>
  
====================diners===============================<br>

<a href="<%=request.getContextPath()%>/admin/delete_diners.do?diners_no=${dinersVO_no}">delete this Hell yea</a><br>

<c:forEach var="dinersPhotopathVO_lists" items="${dinersPhotopath}">
		<tr>
			<th scope="row">photo</th>
			<td>${dinersPhotopathVO_lists}</td><br>
			<td><img src="${dinersPhotopathVO_lists}"></td><br>
		</tr>
	</c:forEach>


====================MENU===============================<br>
<table id="box-table-a" class="table table-hover">
		<thead>
			<tr>
				<th scope="col">No</th>
				<th scope="col">user_show_name</th>
				<th scope="col">content</th>
				<th scope="col">posting_date</th>
				<th scope="col">grade</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach var="menulist" items="${menulists}">
		<tr>
			<th scope="row">${menulist.no }</th>
			<td><img src="${menulist.menu_photo}"></td>
			<td><a href="<%=request.getContextPath()%>/admin/delete_Menu.do?no=${menulist.no}" class="btn btn-success">Delete</a></td>
			<td><a href="<%=request.getContextPath()%>/admin/edit_Menu.do?no=${menulist.no }" class="btn btn-success">Edit</a></td>
		</tr>
	</c:forEach>
		</tbody>
		<tfoot>
		</tfoot>
	</table>





====================reply===============================<br>


<a>식당 평균점수: ${grade }</a>
	<form action="<%=request.getContextPath()%>/reply/replyAdd.do" method="post" >
		<input type="hidden" class="form-control" name="s_diners_no" maxlength="10" required="required" value="${dinersVO_no}">
		<input type="textarea" class="form-control" name="content" maxlength="10" required="required" placeholder="Write content " autocomplete="off">
		<select name="s_grade" required="required">
            <OPTION VALUE='1'>1</OPTION>
            <OPTION VALUE='2'>2</OPTION>
            <OPTION VALUE='3'>3</OPTION>
            <OPTION VALUE='4'>4</OPTION>
            <OPTION VALUE='5'>5</OPTION>
        </select>  
		<input type="hidden"    name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		
		<button type="submit" class="btn btn-primary" value="submit">Submit</button>
	</form>



	<table id="box-table-a" class="table table-hover">
		<thead>
			<tr>
				<th scope="col">No</th>
				<th scope="col">user_show_name</th>
				<th scope="col">content</th>
				<th scope="col">posting_date</th>
				<th scope="col">grade</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach var="list" items="${lists}">
		<tr>
			<th scope="row">${list.no }</th>
			<td>${list.user_show_name }</td>
			<td>${list.content }</td>
			<td>${list.posting_date }</td>
			<td>${list.grade }</td>
			<td><a href="<%=request.getContextPath()%>/reply/replyDelete.do?no=${list.no }" class="btn btn-success">Delete</a></td>
			<td><a href="<%=request.getContextPath()%>/reply/replyEdit.do?no=${list.no }" class="btn btn-success">Edit</a></td>
		</tr>
	</c:forEach>
		</tbody>
		<tfoot>
		</tfoot>
	</table>




</body>
</html>