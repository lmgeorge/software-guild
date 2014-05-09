<%-- 
    Document   : results
    Created on : May 8, 2014, 11:50:52 AM
    Author     : lmgeorge <lauren.george@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="http://bootswatch.com/amelia/bootstrap.css"/>
    <link rel="stylesheet" href="../web/css/style.css"/>
    <title>Display</title>
  </head>
  <body>
    <script src="../web/js/jquery-1.11.1.min.js"></script>
    <script src="../web/js/bootstrap.min.js"></script>

    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="../index.jsp">DVD Library</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="../index.jsp">Home</a></li>
            <li><a href="#">See All</a></li>
            <li><a href="#">Add</a></li>
            <li><a href="#">Edit</a></li>
            <li><a href="#">Delete</a></li>
            <li><a href="#">Find</a></li>
            <li><a href="#">Stats!</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container-fluid" id="container-results">

      <h2>Results:</h2>
      <hr class="row col-md-0">
      <c:forEach var="contact" items="${contacts}">
        <p class="row col-md-6">First Name: ${contact.firstName}        
          <a class="col-md-offset-1 col-md-0"  href="displayEditForm?id=${contact.contactId}"><small>Edit</small></a> | 
          <a class="col-md-offset-0"  href="deleteContact?id=${contact.contactId}"><small>Delete</small></a></p>
        <p class="row col-md-12">Last Name: ${contact.lastName}</p>
        <p class="row col-md-12">Company: ${contact.company}</p>
        <p class="row col-md-12">Phone: ${contact.phone}</p>
        <p class="row col-md-12">Email: ${contact.email}</p>
        <hr class="row col-md-0">
      </c:forEach>

    </div>

</html>
