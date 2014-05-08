<%-- 
    Document   : results
    Created on : May 8, 2014, 8:53:13 AM
    Author     : lmgeorge <lauren.george@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://bootswatch.com/united/bootstrap.min.css"/>
    <link rel="stylesheet" href="style.css"/>
    <title>Results</title>
  </head>
  <body>
    <div class="container-fluid" id="container-results">
      <h2 class="text-danger">Too bad...</h2>
      <h3>${losses}</h3>
      <h3>You are broke after ${rolls} rolls.</h3>
      <h3>
        You should have quit after ${maxRoll} rolls, 
        when you had $${maxBet}.
      </h3>
      <br>
      <h4><a href="index.jsp" class="">Try Again</a></h4>
    </div>
  </body>
</html>
