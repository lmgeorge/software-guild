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
    <title>Add</title>
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
            <li><a href="displayEditForm">Edit</a></li>
            <li><a href="dvds">Delete</a></li>
            <li><a href="dvds">Find</a></li>
            <li><a href="displayStats">Stats!</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>


    <div class="container-fluid">

      <h1 class="row col-md-12 col-sm-12 col-xs-12">Add DVD</h1>
      <div class="row  col-md-12 col-sm-12 col-xs-12">
        <form action="addDvd" 
              method='post' role="form" class="form-horizontal">
          <div class="form-group"> 
            <label for="title" class="control-label">Title: </label>
            <input type="text" name="title" id="firstName"required class="form-control">
          </div>

          <div class="form-group">
            <label class="control-label">Director: </label>
            <input type="text" name="director" required class="form-control">
          </div>

          <div class="form-group">
            <label class="control-label">Studio: </label>
            <input type="text" name="studio" required class="form-control">
          </div>

          <div class="form-group">
            <label class="control-label">Release Date: </label>
            <input type="date" name="releaseDate" required class="form-control">
          </div>

          <div class="form-group">
            <label for="select" class="control-label">MPAA Rating: </label>  
            
            <select name="mpaaRating" class="form-control">
              <option value="G">G</option>
              <option value="PG">PG</option>
              <option value="PG-13">PG-13</option>
              <option value="R">R</option>
              <option value="NC-17">NC-17</option>
              <option value="NR">Not Rated</option>
            </select>
          </div>

          <div class="form-group">
            <label class="control-label">Note: </label>
            <input type="text" name="note" required class="form-control">
          </div>

          <div class="form-group">
            <div class="col-md-0 col-sm-0">
              <button type="submit" class="btn btn-primary btn-lg">Submit</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </body>
</html>
