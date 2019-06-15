<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina di Accesso</title>

<!-- Bootstrap -->
<link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<%= request.getContextPath() %>/css/signin.css" rel="stylesheet">
</head>
<body class="text-center">
    <form class="form-signin" action="LoginServlet" method="post">
<!--       <img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> -->
      <h1 class="h3 mb-3 font-weight-normal">Accedi al Sistema</h1>
      <label for="inputUsername" class="sr-only">Username</label>
      <input type="text" name="inputUsername" id="inputUsername" class="form-control" placeholder="Login" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" name="inputPassword" id="inputPassword" class="form-control" placeholder="Password" required>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Accedi</button>
      <br>
      <a href="<%= request.getContextPath() %>/signUp.jsp">Registrati</a>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
<!--       <form class="form-signin" action="SignUpServlet" method="post"> -->
<!-- 	    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button> -->
<!-- 	        </form> -->
  </body>
</html>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<%= request.getContextPath() %>/js/jquery-1.10.2.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() %>/js/bootstrap.bundle.js"></script>