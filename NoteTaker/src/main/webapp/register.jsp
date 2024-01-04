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
    <%@ include file="all_js_css.jsp"%>
    <style>
        input {
            margin: 10px;
        }
    </style>
</head>
    <body>
        <div class="container mt-5">
            <h1 class="text-center">Register Now!</h1>
            <form action="RegisterServlet" method="post">
                <div class="mb-3">
                    <label for="user_name" class="form-label">User Name</label>
                    <input type="text" class="form-control" id="user_name" name="user_name">
                </div>
                <div class="mb-3">
                    <label for="user_password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="user_password" name="user_password">
                </div>
                <div class="mb-3">
                    <label for="user_confirm_password" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="user_confirm_password" name="user_confirm_password">
                </div>
                <div class="container text-center">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </form>
        </div>

    </body>
</html>
