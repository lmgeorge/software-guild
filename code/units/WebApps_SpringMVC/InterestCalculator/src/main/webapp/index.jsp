
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
          <a class="navbar-brand" href="#">Interest Calculator</a>
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
        <h1>Interest Calculator</h1>
        <form action="CalcServlet" method="post" role="form" class="form-horizontal">

          <div class="form-group">
            <label class="control-label 
                   col-md-offset-2 col-sm-offset-2 
                   col-sm-2 col-md-2">Principal Balance:</label>

            <div class="col-md-4 col-sm-4">
              <div class="input-group">
                <span class="input-group-addon">$</span>
                <input 
                  name="principal" 
                  type="number" min="0"
                  placeholder="e.g., 1000"
                  required 
                  class="form-control">
              </div>
            </div>
          </div>

          <div class="form-group">
            <label class="control-label 
                   col-md-offset-2 col-sm-offset-2 
                   col-sm-2 col-md-2">Annual Rate:</label>
            <div class="col-md-4 col-sm-4">
              <div class="input-group">
                <input 
                  name="annualRate" 
                  type="number" min="0" step="any"
                  placeholder="e.g., 4.3"
                  required 
                  class="form-control">
                <span class="input-group-addon">%</span>
              </div>
            </div>
          </div>


          <div class="form-group">
            <label class="control-label 
                   col-md-offset-2 col-sm-offset-2 
                   col-sm-2 col-md-2">Years to invest:</label>
            <div class="col-md-4 col-sm-4">
              <div class="input-group">
                <input 
                  name="years" 
                  type="number" min="1"
                  placeholder="e.g., 25"
                  required 
                  class="form-control">
                <span class="input-group-addon">years</span>
              </div>
            </div>
          </div>

          <div class="form-group">
            <label class="control-label 
                   col-md-offset-2 col-sm-offset-2 
                   col-sm-2 col-md-2">Compound Rate:</label>
            <div class="col-md-4 col-sm-4">
              <select name="compoundRate" class="form-control" role="menu">
                <option value="365">Daily</option>
                <option value='12'>Monthly</option>
                <option value='4'>Quarterly</option>
                <option value='1'>Annually</option>
              </select>
            </div>
          </div>

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