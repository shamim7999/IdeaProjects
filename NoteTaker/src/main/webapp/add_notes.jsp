<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ৩০/১২/২৩
  Time: ১২:৪২ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Notes</title>
    <%@ include file="all_js_css.jsp"%>
</head>
<body>
    <div class="container">
        <%@ include file="navbar.jsp"%>
        <h1>Please Enter your notes here.</h1> <br>
        <form action="SaveNoteServlet" method="post">
            <div class="mb-3">
                <label for="title" class="form-label">Enter Title</label>
                <input name="title" required type="text" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter Here...">
            </div>
            <div class="mb-3">
                <label for="content">Note Content</label>
                <textarea name="content" required id="content" style="height:300px;" class="form-control" placeholder="Enter Content..">
                </textarea>
            </div>
<%--            <div class="mb-3 form-check">--%>
<%--                <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
<%--                <label class="form-check-label" for="exampleCheck1">Check me out</label>--%>
<%--            </div>--%>
            <div class="container text-center">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
        </form>
    </div>
</body>
</html>
