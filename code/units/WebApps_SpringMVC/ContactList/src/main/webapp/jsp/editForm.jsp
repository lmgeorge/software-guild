<%-- 
    Document   : results
    Created on : May 8, 2014, 11:50:52 AM
    Author     : lmgeorge <lauren.george@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
            <!--<li><a href="displayContacts.jsp">Display</a></li>-->
            <li><a href="displayNewForm">Add Contact</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>


    <div class="container-fluid">

      <h1 class="row col-md-12 col-sm-12 col-xs-12">Edit Form</h1>
     
      
      <div class="row  col-md-12 col-sm-12 col-xs-12">
        <sf:form method='POST' modelAttribute="contact" action="updateContact"
               role="form" class="form-horizontal">
          <div class="form-group"> 
            <sf:label path="firstName" class="control-label">First Name: </sf:label>
            <sf:input path="firstName" type="text" class="form-control"/>
          </div>

          <div class="form-group">
            <sf:label path="lastName" class="control-label">Last Name: </sf:label>
            <sf:input path="lastName" type="text" class="form-control"/>
          </div>

          <div class="form-group">
            <sf:label path="company" class="control-label">Company: </sf:label>
            <sf:input path="company" type="text" class="form-control"/>
          </div>

          <div class="form-group">
            <sf:label path="phone" class="control-label">Phone: </sf:label>
            <sf:input path="phone" type="tel" class="form-control"/>
          </div>

          <div class="form-group">
            <sf:label path="email" class="control-label">Email: </sf:label>
            <sf:input path="email" type="email" class="form-control"/>
          </div>
            <sf:hidden path="contactId"/>
          <div class="form-group">
            <div class="col-md-offset-11 col-sm-offset-10 col-sm-11">
              <button type="submit" value="Update Contact" class="btn btn-primary btn-lg">Submit</button>
            </div>
          </div>
        </sf:form>
      </div>
    </div>
    <!-- Bootstrap core JavaScript
================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../web/jquery-1.11.1.min.js"></script>
    <script src="../web/js/bootstrap.min.js"></script>
  </body>
</html>
