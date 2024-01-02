<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ২/১/২৪
  Time: ২:৫৬ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        input {
            margin: 10px;
        }
    </style>
</head>
    <body>

        <form action="RegisterServlet" method="post">
            Enter User Name: <input type="text" name="user_name" placeholder="User Name" required/>
            Enter Password: <input type="password" name="user_password" placeholder="User Password" required/>
            Confirm Password: <input type="password" name="user_confirm_password" placeholder="Confirm Password" required/>
            <button type="submit">Register</button>
        </form>
    </body>
</html>
