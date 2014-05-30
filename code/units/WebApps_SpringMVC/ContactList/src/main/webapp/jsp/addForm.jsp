<%-- 
    Document   : results
    Created on : May 8, 2014, 11:50:52 AM
    Author     : lmgeorge <lauren.george@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../web/css/bootstrap/united-bootstrap.min.css"/>
    <link rel="stylesheet" href="../web/css/style.css"/>
    <title>Add Form</title>
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
          <a class="navbar-brand" href="../index.jsp">Contact List</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="../index.jsp">Home</a></li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="displayNewForm">Add Contact</a></li>
            </sec:authorize>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>


    <div class="container-fluid">

      <h1 class="row col-md-12 col-sm-12 col-xs-12">Contact Form</h1>
      <div class="row  col-md-12 col-sm-12 col-xs-12">
        <form action="addContact" 
              method='post' role="form" class="form-horizontal">
          <div class="form-group"> 
            <label for="firstName" class="control-label">First Name: </label>
            <input type="text" name="firstName" id="firstName"required class="form-control">
          </div>

          <div class="form-group">
            <label class="control-label">Last Name: </label>
            <input type="text" name="lastName" required class="form-control">
          </div>

          <div class="form-group">
            <label class="control-label">Company: </label>
            <input type="text" name="company" required class="form-control">
          </div>

          <div class="form-group">
            <label class="control-label">Phone: </label>
            <input type="tel" name="phone" required class="form-control">
          </div>

          <div class="form-group">
            <label class="control-label">Email: </label>
            <input type="email" name="email" required class="form-control">
          </div>

          <div class="form-group">
            <div class="col-md-offset-11 col-sm-offset-10 col-sm-11">
              <button type="submit" class="btn btn-primary btn-lg">Submit</button>
            </div>
          </div>
        </form>
      </div>
    </div>
    <!-- Bootstrap core JavaScript
================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../web/jquery-1.11.1.min.js"></script>
    <script src="../web/js/bootstrap.min.js"></script>
  </body>
</html>
