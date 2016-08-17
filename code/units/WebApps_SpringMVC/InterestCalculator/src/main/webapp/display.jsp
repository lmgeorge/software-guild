<%-- 
    Document   : results
    Created on : May 8, 2014, 11:50:52 AM
    Author     : lmgeorge <lauren.george@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="web/css/bootstrap/united-bootstrap.min.css"/>
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
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container-fluid" id="container-results">
      <h2 class="text-info">Results:</h2>
      <p><span class="text-primary">Years compounded:</span> ${investment.years} year[s]</p>
      <p><span class="text-primary">Principal at beginning of year:</span>
        <fmt:setLocale value="en_US"/>
        <fmt:formatNumber value="${investment.principal}" type="currency" /></p>
      <p><span class="text-primary">Future gross interest:</span> 
        <fmt:setLocale value="en_US"/>
        <fmt:formatNumber value="${investment.interestAccrued}" type="currency" /></p>
      <p><span class="text-primary">Future gross return:</span> 
        <fmt:setLocale value="en_US"/>
        <fmt:formatNumber value="${investment.grossInvestment}" type="currency" /></p>
    </div>
    <!-- Bootstrap core JavaScript-->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="web/jquery-1.11.1.min.js"></script>
    <script src="web/js/bootstrap.min.js"></script>
  </body>
</html>
