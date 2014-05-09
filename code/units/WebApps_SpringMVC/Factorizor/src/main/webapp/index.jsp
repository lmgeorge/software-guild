
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="web/css/bootstrap/united-bootstrap.min.css"/>
    <link rel="stylesheet" href="web/css/style.css"/>
    <title>Home</title>
  </head>
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Factorizor</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Home</a></li>
            <!--<li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>-->
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container-fluid">

      <h1 class="row col-md-12">Welcome to Factorizor!</h1>

      <form action="MachineServlet" method='post' role="form">
        <div class="form-group"> 
          <label class="control-label">
            What number would you like to factor? 
          </label>

          <div class="input-group">
            <input type="number" min="1" name="initial" required class="form-control input-lg">
            <span class="input-group-btn">
                <input type="submit" value="Factor" class="btn btn-info btn-lg">
            </span>

          </div>
        </div>
      </form>
    </div>
    <!-- Bootstrap core JavaScript
================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="web/js/bootstrap.min.js"></script>
    <script src="web/jquery-1.11.1.min.js"></script>
  </body>
</html>