<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edit</title>
</head>
<body>
	<form action="" method="post" >
		<input type="hidden" class="form-control" name="board_no" value=${title }>
		<input type="text" class="form-control" name="title" maxlength="10" required="required" value=${title } autocomplete="off"><br>
		 <textarea rows="5" cols="20"  class="form-control" name="contents" required="required"  autocomplete="off" ></textarea>
		
		<input type="hidden"    name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		
		<button type="submit" class="btn btn-primary" value="submit">Submit</button>
	</form>
</body>
</html>
