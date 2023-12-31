<%@ page import="org.hibernate.Session" %>
<%@ page import="com.helper.FactoryProvider" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="java.util.List" %>
<%@ page import="com.entities.Note" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
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

<html>
<head>
    <title>All Notes</title>
    <%@ include file="all_js_css.jsp"%>
</head>
<body>
    <div class="container">
        <%@ include file="navbar.jsp"%>
        <h1>Notes Here</h1>

<%--        <%@ include file="connection.jsp"%>--%>

<%--        <sql:query var="resultSet" dataSource="${db}">Select *  from notes</sql:query>--%>
        <%!
            public String formatDate(LocalDateTime addedDate) {
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEE, dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);

                String formattedDate = addedDate.format(myFormatObj);
                return formattedDate;
            }
        %>

        <%
            Session s = FactoryProvider.getFactory().openSession();
            Query query = s.createQuery("from Note n order by n.addedDate desc");
            List<Note> notes = query.list();
            for(Note note : notes) {
        %>

        <div class="row">
<%--            <img src="img/notes.png" class="card-img-top" alt="no images">--%>
            <div class="col-12">
                    <div class="card mt-3">
                        <img class="card-img-top m-3 mx-auto" style="max-width: 100px" src="img/notes.png" alt="no image">
                        <div class="card-body px-5">
                            <h5 style="color: darkred" class="card-title"><%= note.getTitle() %></h5>
                            <p class="card-text">
                                <%= note.getContent()%>
                            </p>
                            <p style="color: #3f51b5;"> <b>Last updated: <%= formatDate(note.getAddedDate())%>
                            </b></p>
                            <div class="container text-center mt-2">
                                <a href="DeleteServlet?note_id=<%= note.getId() %>" class="btn btn-danger">Delete</a>
                                <a href="edit.jsp?note_id=<%= note.getId() %>" class="btn btn-outline-primary">Update</a>
                            </div>

                        </div>
                    </div>
            </div>
        </div>

        <%
            }
        %>
    </div>
</body>
</html>
