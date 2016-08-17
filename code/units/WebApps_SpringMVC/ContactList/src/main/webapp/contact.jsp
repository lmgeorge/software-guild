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

    <link rel="stylesheet" href="web/css/bootstrap/united-bootstrap.min.css"/>
    <link rel="stylesheet" href="web/css/style.css"/>
    <title>Contacts</title>
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
      <div class="row">
        <div class="col-lg-6">

          <h1 class="row col-md-12 col-sm-12 col-xs-12">Add Contact Form</h1>

          <div class="row  col-md-12 col-sm-12 col-xs-12">
            <form method="POST" class="form-horizontal" id="add-form">
              <div class="form-group"> 
                <label for="firstName" class="control-label">First Name: </label>
                <input type="text" id="add-firstName"required class="form-control"/>
              </div>

              <div class="form-group">
                <label class="control-label">Last Name: </label>
                <input type="text" id="add-lastName" required class="form-control"/>
              </div>

              <div class="form-group">
                <label class="control-label">Company: </label>
                <input type="text" id="add-company" required class="form-control"/>
              </div>

              <div class="form-group">
                <label class="control-label">Phone: </label>
                <input type="tel" id="add-phone" required class="form-control"/>
              </div>

              <div class="form-group">
                <label class="control-label">Email: </label>
                <input type="email" id="add-email" required class="form-control"/>
              </div>

              <div class="form-group">
                <div class="col-md-0">
                  <input id="addButton" type="submit" value="Add" class="btn btn-primary btn-lg"/>
                </div>
              </div>

          </form>
        </div>

        <div class="row col-md-12 col-sm-12 col-xs-12">
          <hr>
        </div>
        <h1 class="row col-md-12 col-sm-12 col-xs-12">Edit Contact Form</h1>

        <div class="row  col-md-12 col-sm-12 col-xs-12">
          <form method='POST' role="form" class="form-horizontal" id="edit-form">
            <div class="form-group"> 
              <label for="firstName" class="control-label">First Name: </label>
              <input type="text" name="firstName" id="edit-firstName"required class="form-control"/>
            </div>

            <div class="form-group">
              <label class="control-label">Last Name: </label>
              <input type="text" name="lastName" id="edit-lastName" required class="form-control"/>
            </div>

            <div class="form-group">
              <label class="control-label">Company: </label>
              <input type="text" name="company" id="edit-company" required class="form-control"/>
            </div>

            <div class="form-group">
              <label class="control-label">Phone: </label>
              <input type="tel" name="phone" id="edit-phone" required class="form-control"/>
            </div>

            <div class="form-group">
              <label class="control-label">Email: </label>
              <input type="email" name="email" id="edit-email" required class="form-control"/>
            </div>

            <div class="form-group">
              <div class="col-md-0">
                <button id="editButton" type="submit" class="btn btn-primary btn-lg">Submit</button>
              </div>
            </div>
            <input id="edit-contactId" type="hidden"/>
          </form>
        </div>



      </div>


      <div class="col-lg-offset-1 col-lg-5">
        <br>
        <h1>Contacts:</h1>
        <hr>
        <div id="contact-list"></div>
        <hr class="row col-md-12">
      </div>
      <div class="col-lg-offset-1 col-lg-5">  
          <h2>Contact Details:</h2>
          <p id="detail-firstName" class="row col-md-6">First Name:</p>        
          <p id="detail-lastName" class="row col-md-12">Last Name: </p>
          <p id="detail-company" class="row col-md-12">Company: </p>
          <p id="detail-phone" class="row col-md-12">Phone: </p>
          <p id="detail-email" class="row col-md-12">Email: </p>
          <hr class="row col-md-0">
        </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript
================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="web/js/jquery-1.11.1.min.js"></script>
  <script src="web/js/bootstrap.min.js"></script>
  <script src="web/js/contact.js"></script>
</body>
</html>
