
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="http://bootswatch.com/amelia/bootstrap.css"/>
    <link rel="stylesheet" href="web/css/style.css"/>
    <title>Home</title>
  </head>
  <body>
    <script src="web/js/jquery-1.11.1.min.js"></script>
    <script src="web/js/bootstrap.min.js"></script>

    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp">DVD Library</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Home</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container-fluid">
      <div class="page-header text-center">
        <h2>Welcome to DVD Library</h2>
      </div>
      <div class="list-group">
        <a class=" list-group-item list-group-item-info">
          <h4 class="list-group-item-heading">Please choose one: </h4>
        </a>
        <a href="/displayDvds"class="list-group-item-danger list-group-item">
          See all DVDs</a>
        <a href="/add"class="list-group-item-danger list-group-item">
          Add a DVD
        </a>
        <a href="/delete" class="list-group-item-danger list-group-item">
          Delete a DVD
        </a>
        <a href="/edit" class="list-group-item-danger list-group-item">
          Edit a DVD
        </a>
        <a href="/find" class="list-group-item-danger list-group-item">
          Find a DVD
        </a>
        <a href="/stats" class="list-group-item-danger list-group-item">
          See the Library Stats
        </a>
      </div>

    </div>

  </body>
</html>