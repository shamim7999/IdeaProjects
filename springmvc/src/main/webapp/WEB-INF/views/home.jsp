<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %> <!-- By setting this we can use JSP Expression Language -->
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <%
        String name = request.getAttribute("name").toString();
    %>

    <h1> Hi, <%= name %> This is home page</h1>
    ${name}
</body>
</html>