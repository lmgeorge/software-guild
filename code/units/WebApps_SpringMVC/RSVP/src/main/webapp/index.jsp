<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>RSVP Page</title>
  </head>
  <body>
    <h3>I'm having a party and you're invited!</h3>

    <form action='RSVPServlet' method='post'>
      <p>Can you come?</p>
      <br>
      <label>No</label> 
      <input type='radio' value='No' name='answer'>

      <label>Yes</label>
      <input type='radio' value='Yes' checked name='answer'>

      <p>Reason (if not attending): </p>
      <select name='reason'>
        <option value='N/A'></option>
        <option value='Out of town'>Out of town</option>
        <option value='Scheduling conflict'>
          Scheduling conflict
        </option>
      </select>
      <br>
      <p>Notes:</p><br> 
      <input type='text' name='notes'>
      <input type='submit' value='RSVP'><br>
    </form>
  </body>
</html>
