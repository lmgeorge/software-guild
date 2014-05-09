
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="web/css/bootstrap/united-bootstrap.min.css"/>
    <link rel="stylesheet" href="web/css/style.css"/>
    <title>Home</title>
  </head>
  <body>
    <!-- Bootstrap core JavaScript-->

    <script src="web/js/bootstrap.min.js"></script>
    <script src="web/js/jquery-1.11.1.min.js"></script>
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp">Flooring Calculator</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Home</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container-fluid">
      <div class="col-md-12 col-sm-12">
        <h1>Flooring Calculator</h1>
        <form action="CalcServlet" method="post" role="form" class="form-horizontal">

          <div class="form-group">
            <label class="control-label 
                   col-md-offset-2 col-sm-offset-2 
                   col-sm-2 col-md-2">Width:</label>

            <div class="col-md-4 col-sm-4">
              <div class="input-group">
                
                <input 
                  name="width" 
                  type="number" min="1" step="any"
                  placeholder="e.g., 7.5"
                  required 
                  class="form-control">
                <span class="input-group-addon">units</span>
              </div>
            </div>
          </div>

          <div class="form-group">
            <label class="control-label 
                   col-md-offset-2 col-sm-offset-2 
                   col-sm-2 col-md-2">Length:</label>
            <div class="col-md-4 col-sm-4">
              <div class="input-group">
                <input 
                  name="length" 
                  type="number" min="1" step="any"
                  placeholder="e.g., 4.3"
                  required 
                  class="form-control">
                <span class="input-group-addon">units</span>
              </div>
            </div>
          </div>


          <div class="form-group">
            <label class="control-label 
                   col-md-offset-2 col-sm-offset-2 
                   col-sm-2 col-md-2">Cost per unit:</label>
            <div class="col-md-4 col-sm-4">
              <div class="input-group">
                <span class="input-group-addon">$</span>
                <input 
                  name="costPerSqft" 
                  type="number" min="0" step="any"
                  placeholder="e.g., 3.50"
                  required 
                  class="form-control">
              </div>
            </div>
          </div>

<!--          <div class="form-group">
            <label class="control-label 
                   col-md-offset-2 col-sm-offset-2 
                   col-sm-2 col-md-2">Measurement system:</label>
            <div class="col-md-4 col-sm-4">
              <input type="radio" name="measure" class="form-control" required>

            </div>
          </div>-->

          <div class="form-group">
            <div class="control-label col-md-8">
              <button type="submit" value="calc" class="btn btn-primary btn-lg">Calculate</button>
            </div>
          </div>

        </form>
      </div>
    </div>
  </body>
</html>