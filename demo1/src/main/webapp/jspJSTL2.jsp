<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ২৭/১২/২৩
  Time: ১১:৩৯ AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ২৬/১২/২৩
  Time: ১১:৫২ AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>

        <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/shamim" user="root" password=""/>

        <sql:query var="resultSet" dataSource="${db}">Select * From tester</sql:query>

        <c:forEach items="${resultSet.rows}" var="row">
            ID: ${fn:toUpperCase(row.id.toString())} <br>
            Name: ${fn:toUpperCase(row.name)} <br>
            Age: ${row.age} <br><br>
<%--            Name: ${row.getName()} <br>--%>
<%--            Age: ${row.getAge()} <br> <br>--%>
        </c:forEach>

    </body>
</html>
