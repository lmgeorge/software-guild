<%-- 
    Document   : contactList
    Created on : May 6, 2014, 11:18:31 AM
    Author     : lmgeorge <lauren.george@live.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Contact List</title>
  </head>
  <body>
    <h1>Contact List</h1>
    
    <c:forEach var="contact" items="${contactList}">
      <c:out value="${contact.name}"/><br/>
      <c:out value="${contact.phone}"/><br/>
      <c:out value="${contact.email}"/><br/><br/>
    </c:forEach>
  </body>
</html>
