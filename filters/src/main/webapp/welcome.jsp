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

    <%@ include file="validator.jsp"%>

    Welcome ${userName}

    <a href="videos.jsp">Videos Here</a>

<form action="Logout" method="get">
    <button type="submit">Logout</button>
</form>

</body>
</html>
