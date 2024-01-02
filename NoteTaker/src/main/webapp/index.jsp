<!doctype html>
<html lang="en">
<head>
    <title>index</title>
    <%@ include file="all_js_css.jsp"%>
</head>
<body>
    <%@ include file="validate.jsp" %>
    <div class="container">
        <%@ include file="navbar.jsp"%>
        <h1>Welcome ${userName} This is Home Page</h1>
    </div>

    <form action="Logout" method="post">
        <button type="submit">Logout</button>
    </form>

</body>
</html>