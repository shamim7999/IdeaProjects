<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ১/১/২৪
  Time: ১০:৪৪ AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <form action="Login" method="post">
            Enter Name: <input type="text" placeholder="Enter Name" name="name"/> <br>
            Enter Password: <input type="password" placeholder="Enter Password"  name="password"/> <br>
            <button type="submit">Login</button> <br>
<%--            <button type="submit" value="logout">Logout</button>--%>
        </form>
        <form action="Logout" method="get">
            <button type="submit">Logout</button>
        </form>
    </body>
</html>
