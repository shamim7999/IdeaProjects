<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
    <body>
        <h1><%= "Hello World!" %>
        </h1>
        <br/>

        <%
            List<Integer> nums = new ArrayList<>();
            nums.add(1);
            nums.add(2);
            nums.add(3);

            int sum = nums.stream()
                    .mapToInt(value -> value)
                                    .sum();
            out.print("Sum of the List is: "+sum);
        %>

        <a href="form.jsp">Hello Servlet</a> <br> <br>
        <a href="form2.jsp">Register</a> <br> <br>
        <a href="login.jsp">Login</a> <br> <br>
        <a href="formC3.jsp">Form for C3</a> <br> <br>
        <a href="formC4.jsp">Form for C4</a> <br> <br>
        <a href="jspJDBC1.jsp"> JSP JDBC </a>
    </body>
</html>