<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
</head>
<body>



	<form action="" method="post" enctype="multipart/form-data" >

		<input type="text" class="form-control" name="diner_name" maxlength="10" required="required" placeholder="Write dinners name" autocomplete="off">
		<input type="text" class="form-control" name="diner_call" maxlength="10" required="required" placeholder="Write call " autocomplete="off">
		<input type="text" class="form-control" name="rest_day" maxlength="10" required="required" placeholder="Write rest day " autocomplete="off">
		<input type="text" class="form-control" name="intro" maxlength="15" required="required" placeholder="Write intro" autocomplete="off"><br>
		<input type="hidden" name="no" value="${no}">
		input photo main 
		<input type="file" name="photo_main"><br>
		input photo sub 1
		<input type="file" name="photo_sub_1"><br>
		input photo sub 2
		<input type="file" name="photo_sub_2"><br>
		input photo sub 3
		<input type="file" name="photo_sub_3"><br>
		<input type="hidden"    name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		
		<button type="submit" class="btn btn-primary" value="submit">Submit</button>
		<br>
		<a href="<%=request.getContextPath()%>/admin/insert_Menu.do?no=${no}">insert menu</a>
	</form>
</body>
</html>


