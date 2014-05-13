
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="http://bootswatch.com/united/bootstrap.css"/>
    <link rel="stylesheet" href="../web/css/style.css"/>
    <title>Home</title>
  </head>
  <body>
    <script src="../web/js/jquery-1.11.1.min.js"></script>
    <script src="../web/js/bootstrap.min.js"></script>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="../index.jsp">Vending Machine</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="../index.jsp">Home</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container-fluid">

      <div class="page-header text-center">
        <h1>Vending Machine</h1>
      </div>
      <div class="row col-md-offset-4 col-lg-6">
        <sf:form modelAttribute="calc"
                 action="buyItem" method='POST' 
                 class="form-inline" role="form">
          <fmt:formatNumber type="currency" var="price" value="${choice.cost}"/>
          <div class="row col-md-12">
            <h3 class="row col-md-12">Selection: ${choice.name}</h3>
            <h3 class="row col-md-12">Price: ${price}

            </h3>
          </div>
          <fmt:formatNumber type="currency" var="money" value="${calc.money}"/>
          <h3 class="row col-md-12">You entered: ${money}</h3>
          <h3 class="row col-md-12">Your change: 
            ${calc.quarters} quarter(s), 
            ${calc.dimes} dime(s), 
            ${calc.nickels} nickel(s), 
            ${calc.pennies} pennie(s)
          </h3>
          <a class="row col-md-12" href="menu.jsp">Make Another Selection</a>

        </div>
      </sf:form>
    </div>
  </div> <!--.container-fluid-->

</body>
</html>