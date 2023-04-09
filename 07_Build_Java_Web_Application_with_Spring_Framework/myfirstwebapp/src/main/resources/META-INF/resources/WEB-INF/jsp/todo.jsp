<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List Todos Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div>Welcome to ${name}</div>
		<hr>
		<h1>Enter Todo Details:</h1>
		<form method="POST">
		Description: <input type="text" name="description"/>
		<input type="submit" class="btn btn-success"/>
		</form>
	</div>


	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>