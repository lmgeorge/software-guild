<%-- 
    Document   : results
    Created on : May 8, 2014, 11:50:52 AM
    Author     : lmgeorge <lauren.george@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="http://bootswatch.com/amelia/bootstrap.css"/>
    <link rel="stylesheet" href="../web/css/style.css"/>
    <title>Edit</title>
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


    <div class="container-fluid">

      <h1 class="row col-md-12 col-sm-12 col-xs-12">Edit Form</h1>


      <div class="row  col-md-12 col-sm-12 col-xs-12">
        <sf:form method='POST' modelAttribute="contact" action="updateContact"
                 role="form" class="form-horizontal">
          <div class="form-group"> 
            <sf:label path="title" class="control-label">Title: </sf:label>
            <sf:input path="title" type="text" class="form-control"/>
          </div>

          <div class="form-group">
            <sf:label path="director" class="control-label">Director: </sf:label>
            <sf:input path="director" type="text" class="form-control"/>
          </div>

          <div class="form-group">
            <sf:label path="studio" class="control-label">Studio: </sf:label>
            <sf:input path="studio" type="text" class="form-control"/>
          </div>

          <div class="form-group">
            <sf:label path="releaseDate" class="control-label">Release Date: </sf:label>
            <sf:input path="releaseDate" type="date" class="form-control"/>
          </div>

          <div class="form-group">
            <sf:label path="rating" class="control-label">MPAA Rating: </sf:label>
            <sf:input path="rating" type="text" class="form-control"/>
          </div>
          
          <div class="form-group">
            <div class="col-md-offset-11 col-sm-offset-10 col-sm-11">
              <button type="submit" value="Update Contact" class="btn btn-primary btn-lg">Submit</button>
            </div>
          </div>
        </sf:form>
      </div>
    </div>
  </body>
</html>
