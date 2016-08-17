<%-- 
    Document   : index
    Created on : May 6, 2014, 08:11:34 PM
    Author     : lmgeorge <lauren.george@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="http://bootswatch.com/united/bootstrap.min.css"/>
    <link rel="stylesheet" href="style.css"/>
    <title>Home</title>
  </head>
  <body>
    <div class="container-fluid">

      <h1 class="row col-md-12">Welcome to Lucky Sevens!</h1>
     
      <form action="EngineServlet" method='post' role="form">
        <div class="form-group"> 
            <label class="control-label">
              How much money do you want to bet? 
            </label>

          <div class="input-group">
            <span class="input-group-addon">$</span>
            <input type="number" min="1" name="betLimit" class="form-control input-lg">
            <span class="input-group-btn">
              <input type="submit" value="Bet" class="btn btn-info btn-lg">
            </span>
          </div>
        </div>
      </form>
    </div>
  </body>
</html>