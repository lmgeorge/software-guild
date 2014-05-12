<%-- 
    Document   : results
    Created on : May 8, 2014, 11:50:52 AM
    Author     : lmgeorge <lauren.george@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <li><a href="dvds">See All</a></li>
            <li><a href="displayAddForm">Add</a></li>
            <li><a href="dvds">Delete</a></li>
            <li><a href="dvds">Find</a></li>
            <li><a href="displayStats">Stats!</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>


    <div class="container-fluid">

      <h1 class="text-center row col-md-12 col-sm-12 col-xs-12">Edit Form</h1>


      <div class="row  col-md-12 col-sm-12 col-xs-12">
        <sf:form method='POST' modelAttribute="dvd" action="updateDvd"
                 role="form" class="form-horizontal">
          <div class="form-group"> 
            <sf:label path="title" class="control-label">Title: </sf:label>
            <sf:input path="title" type="text" class="form-control"/>
          </div>

          <div class="form-group">
            <sf:label path="director" class="control-label">Director: </sf:label>
            <sf:input path="director" type="text" class="form-control"/>
          </div>

          <div class="form-group ">
            <sf:label path="studio" class="control-label">Studio: </sf:label>
            <sf:input path="studio" type="text" class="form-control"/>
          </div>

          <div class="form-group">
            <sf:label path="releaseDate" class="control-label">
              Release Date: </sf:label>
            <c:set var="month" value="${dvd.releaseDate.getMonthValue()}-"/>
            <c:set var="day" value="${dvd.releaseDate.getDayOfMonth()}"/>
            <c:set var="year" value="${dvd.releaseDate.getYear()}-"/>
            <c:set var="date" value="${year}${month}${day}"/>
            <sf:input path="releaseDate" type="text" class="form-control" />
          </div>

          <div class="form-group">
            <sf:label path="mpaaRating" class="control-label">MPAA Rating: </sf:label>
            <sf:input path="mpaaRating" type="text" class="form-control"/>
          </div>

          <div class="form-group">
            <sf:label path="note" class="control-label">Note: </sf:label>
            <sf:input path="note" type="text" class="form-control"/>
          </div>

          <div class="form-group">
            <div class="col-md-0 col-sm-0">
              <button type="submit" value="Update DVD" class="btn btn-primary btn-lg">Submit</button>
            </div>
          </div>
        </sf:form>
      </div>
    </div>
  </body>
</html>
