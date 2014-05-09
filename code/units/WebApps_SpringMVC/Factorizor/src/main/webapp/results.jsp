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
    <title>Results</title>
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
    
    <div class="container-fluid" id="container-results">
      <h2>Results:</h2>
      <c:choose>
        <c:when test="${isPrime}">
          <p>${param.initial} is a prime number.</p>
        </c:when>
        <c:otherwise>
          <p>${param.initial} is not a prime number.</p>
        </c:otherwise>
      </c:choose>    
      <c:choose>    
        <c:when test="${isPerfect}">
          <p>${param.initial} is a perfect number.</p>
        </c:when>
        <c:otherwise>
          <p>${param.initial} is not a perfect number.</p>
        </c:otherwise>
      </c:choose>    

      <c:if test="${size > 1}"> 
        <h3>Factors of ${param.initial}:</h3>
        <c:forEach var="factor" items="${factors}">
          <p><c:out value="${factor}"/></p>
        </c:forEach>
      </c:if>

    </div>
    <!-- Bootstrap core JavaScript
================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="web/jquery-1.11.1.min.js"></script>
    <script src="web/js/bootstrap.min.js"></script>
  </body>
</html>
