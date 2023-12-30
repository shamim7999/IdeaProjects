<%@ page import="org.hibernate.Session" %>
<%@ page import="com.helper.FactoryProvider" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="com.entities.Note" %><%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ৩০/১২/২৩
  Time: ১০:৩৮ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Note</title>
    <%@ include file="all_js_css.jsp"%>
</head>
<body>
<div class="container">
    <%@ include file="navbar.jsp"%>
    <h1>Edit your notes..</h1> <br>

    <%
        int noteId = Integer.parseInt(request.getParameter("note_id"));
        Session session2 = FactoryProvider.getFactory().openSession();
        Note note = session2.get(Note.class, noteId);
    %>

    <form action="UpdateServlet" method="post">
        <input name="id" value="<%= note.getId() %>" type="hidden"/>
        <div class="mb-3">
            <label for="title" class="form-label">Enter Title</label>
            <input name="title" required type="text" class="form-control" id="title"
                   aria-describedby="emailHelp"
                   placeholder="Enter Here..."
                   value="<%= note.getTitle() %>"
            >
        </div>
        <div class="mb-3">
            <label for="content">Note Content</label>
            <textarea name="content" required id="content" style="height:300px;" class="form-control" placeholder="Enter Content..">
                <%= note.getContent() %>
            </textarea>
        </div>
        <%--            <div class="mb-3 form-check">--%>
        <%--                <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
        <%--                <label class="form-check-label" for="exampleCheck1">Check me out</label>--%>
        <%--            </div>--%>
        <div class="container text-center">
            <button type="submit" class="btn btn-success">Save Your Note</button>
        </div>
    </form>
</div>
</body>
</html>
