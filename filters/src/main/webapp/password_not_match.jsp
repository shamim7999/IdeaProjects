<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ১/১/২৪
  Time: ৩:১৮ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> Hey,  <%= request.getAttribute("userName") %>  Password don't match.</h1>
    <%
        response.sendRedirect("register.jsp");
    %>
</body>
</html>
