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
    <link rel="stylesheet" href="http://bootswatch.com/united/bootstrap.min.css"/>
    <link rel="stylesheet" href="web/css/style.css"/>
    <title>Display</title>
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
          <a class="navbar-brand" href="#">Contact List</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Home</a></li>
            <!--<li><a href="displayContacts.jsp">Display</a></li>
            <li><a href="#contact">Contact</a></li>-->
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container-fluid" id="container-results">
      <h2>Contact List:</h2>
      <c:forEach var="contact" items="${contacts}">
        <p>First Name: ${contact.firstName}        
          <a class="col-md-offset-1"  href="DeleteServlet?id=${contact.contactId}">Delete</a></p>
        <p>Last Name: ${contact.lastName}</p>
        <p>Company: ${contact.company}</p>
        <p>Phone: ${contact.phone}</p>
        <p>Email: ${contact.email}</p>

        <hr>
      </c:forEach>
    </div>
    <!-- Bootstrap core JavaScript
================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="web/jquery-1.11.1.min.js"></script>
    <script src="web/js/bootstrap.min.js"></script>
  </body>
</html>
