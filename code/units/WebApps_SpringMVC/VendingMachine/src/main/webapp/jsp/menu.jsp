
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
      <div class="row col-md-12">
        <sf:form action="returnSelection" method='POST' modelAttribute="choice" 
                 class="form-inline" role="form">
          <c:forEach var="item" items="${menuList}">
            <div class="row col-md-offset-3 col-md-9">

              <div class="col-md-6">
                <div class="input-group">
                  <div class="radio">

                    <sf:radiobutton path="name" value="${item.name}"/>
                    <sf:label path="name">
                      <span class="text-info">${item.name}</span>
                    </sf:label>
                  </div>
                </div>
              </div>
              <div class="col-md-2">
                <fmt:formatNumber type="currency" var="price" value="${item.cost}"/>
                ${price}
              </div>

            </div>
          </c:forEach>

          <div class="row col-md-offset-6 form-group">
            <div>
              <br>
              <input type="submit" value="Make Selection" 
                     class="btn btn-primary col-sm-offset-11"/>
            </div>
          </div>
          <hr class="row col-md-12"/>
        </sf:form>
      </div>
    </div> <!--.container-fluid-->

  </body>
</html>