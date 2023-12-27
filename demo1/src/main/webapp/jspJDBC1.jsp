        <%@ page import="com.dao.DbSql" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.dao.MySql" %>
<%@ page import="java.sql.*" %>
        <%@ page import="com.queries.QueryImpl" %>
        <%@ page import="java.util.List" %>
        <%@ page import="com.entity.Tester" %>
        <%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ২৬/১২/২৩
  Time: ১১:৫২ AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>

        <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>In JDBC Page</h1>
        <%
            List <Tester> testers = new ArrayList<>();
            try {

                QueryImpl qi = new QueryImpl();
                String query = "Select * from tester";
                testers = qi.queryRow(query);


            } catch (Exception e) {
                e.printStackTrace();
            }
        %>

        ID: <%=testers.get(4).getId()%> <br><br>
        Name: <%=testers.get(4).getName()%> <br><br>
        Age: <%=testers.get(4).getAge()%> <br><br>

    </body>
</html>
