<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ১০/১/২৪
  Time: ১১:২৩ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
    <%@ include file="validate.jsp" %>
    <form action="welcomePerson" method="post">
        <input type="text" name="person_name"> &nbsp; &nbsp; <input type="submit" value="Submit">
    </form>
    </body>
</html>
