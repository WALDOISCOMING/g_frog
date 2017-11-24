<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <script type="text/javascript"
     src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
    </script> 
    <script type="text/javascript"
     src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
    </script>
    <script type="text/javascript"
     src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
</head>
<body>


	<form action="" method="post" enctype="multipart/form-data" >
		<input type="hidden" name="no" value="${no}">
		<input type="text" class="form-control" name="menu_name" maxlength="10" required="required" placeholder="name" autocomplete="off"/>
		<input type="text" class="form-control" name="menu_main" maxlength="40" required="required" placeholder="main" autocomplete="off"/>
		<input type="text" class="form-control" name="menu_original_price" maxlength="10" required="required" placeholder="price " autocomplete="off"/>
		<input type="text" class="form-control" name="menu_sale" maxlength="15" required="required" placeholder="sale" autocomplete="off"/><br>
		input photo main 
		<input type="file" name="menu_photo"><br>
		<input type="hidden"    name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		
		<div class="well">
  <div id="datetimepicker1" class="input-append date">
    <input name="menu_start_date"data-format="dd/MM/yyyy hh:mm:ss" type="text"></input>
    <span class="add-on">
      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
      </i>
    </span>
  </div>
</div>
<script type="text/javascript">
  $(function() {
    $('#datetimepicker1').datetimepicker({
      language: 'ko'
    });
  });
</script>
		 <div id="datetimepicker2" class="input-append date">
    <input name="menu_end_date"data-format="dd/MM/yyyy hh:mm:ss" type="text"></input>
    <span class="add-on">
      <i data-time-icon="icon-time" data-date-icon="icon-calendar">
      </i>
    </span>
  </div>
<div>
<script type="text/javascript">
  $(function() {
    $('#datetimepicker2').datetimepicker({
      language: 'ko'
    });
  });
</script>
		
		
		<button type="submit" class="btn btn-primary" value="submit">Submit</button>
		<br>
		
	</form>
</body>
</html>


