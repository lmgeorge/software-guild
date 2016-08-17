<%-- 
    Document   : results
    Created on : May 8, 2014, 11:50:52 AM
    Author     : lmgeorge <lauren.george@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <li><a href="dvds">See All</a></li>
            <li><a href="displayAddForm">Add</a></li>
            <li><a href="dvds">Edit</a></li>
            <li><a href="dvds">Delete</a></li>
            <li><a href="stats">Stats!</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>


    <div class="container-fluid" id="keyword-bar">
      <div class="col-lg-12">
        <form action="findDvd" method='POST' role="form">
          <div class="input-group">
            <input name="keyword" type="text" class="form-control">
            <span class="input-group-btn">
              <button class="btn btn-default" type="submit">Search!</button>
            </span>
          </div><!-- /input-group -->
        </form>
      </div><!-- /.col-lg-6 -->
    </div><!-- /.row -->
  </div>

  <div class="container-fluid" id="container-results">

    <h1 class="text-center" style="font-size: 5em; margin-bottom: 2%">Results:</h1>
    <hr class="row col-md-12">
    <c:forEach var="dvd" items="${results}">
      
      <div class="row col-md-offset-3">
        
        <div class="row">
          <p class="col-md-5">Title: ${dvd.title}  </p>      
          <a class="col-md-1 text-right" 
             href="displayEditForm?id=${dvd.dvdID}">
            Edit</a>  
          <a class="col-md-1"  
             href="deleteDvd?id=${dvd.dvdID}">  Delete</a>
        </div>
        
        <p class="row col-md-12">Director: ${dvd.director}</p>
        <p class="row col-md-12">Studio: ${dvd.studio}</p>
        
        <c:set var="month" value="${dvd.releaseDate.getMonthValue()}"/>
        <c:set var="day" value="${dvd.releaseDate.getDayOfMonth()}"/>
        <c:set var="year" value="${dvd.releaseDate.getYear()}"/>
        <c:set var="date" value="${month}/${day}/${year}"/>
        <p class="row col-md-12">Release Date: ${date}</p>
        
        <p class="row col-md-12">Rating: ${dvd.mpaaRating}</p>
        <p class="row col-md-12">Note: ${dvd.note}</p> 
        
      </div>
      <hr class="row col-md-12">  
    </c:forEach>
  </div>

</html>
