<%-- 
    Document   : response
    Created on : May 6, 2014, 10:25:34 AM
    Author     : lmgeorge <lauren.george@live.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Response</title>
  </head>
  <body>
    <h1>Thank you!</h1>
    <h3>We got you're RSVP!</h3>
   
    <h3>Your answer was: ${param.answer}</h3>
    <p>${message}</p>
    
    <a href="index.jsp">Home</a>
  </body>
</html>
