<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ৩০/১২/২৩
  Time: ৫:২১ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>All Notes</title>
    <%@ include file="all_js_css.jsp"%>
</head>
<body>
    <div class="container">
        <%@ include file="navbar.jsp"%>
        <h1>Notes Here</h1>

        <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/myhiber"
                           user="root" password=""
        />
        <sql:query var="resultSet" dataSource="${db}">Select *  from notes</sql:query>

        <div class="row">
<%--            <img src="img/notes.png" class="card-img-top" alt="no images">--%>
            <div class="col-12">
                <c:forEach var="row" items="${resultSet.rows}">

                    <div class="card mt-3">
                        <img class="card-img-top m-3 mx-auto" style="max-width: 100px" src="img/notes.png" alt="no image">
                        <div class="card-body px-5">
                            <h5 style="color: darkred" class="card-title">${row.title}</h5>
                            <p class="card-text">
                                ${row.content}
                            </p>
                            <p style="color: #3f51b5;"> <b>Last updated: ${row.addedDate}</b></p>
                            <div class="container text-center mt-2">
                                <a href="DeleteServlet?note_id=${row.id}" class="btn btn-danger">Delete</a>
                                <a href="edit.jsp?note_id=${row.id}" class="btn btn-outline-primary">Update</a>
                            </div>

                        </div>
                    </div>

                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
