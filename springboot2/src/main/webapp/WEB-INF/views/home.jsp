<!doctype html>
<html lang="en">
<head>
    <%@ include file="all_css_js.jsp"%>
</head>
<body>
<%@ include file="validate.jsp" %>
<%--<%--%>
<%--    String name = request.getAttribute("name").toString();--%>
<%--%>--%>

<%--<h1> Hi, <%= name %> This is home page.</h1>--%>
<h1> Hi, ${userName}. This is Home Page.</h1>


<%--<img alt="bunny hop image"  src="<c:url value="../resources/images/spider.png" />" />--%>


<div class="container">
    <div class="card mx-auto mt-5 bg-primary" style="width: 50%;">
        <div class="card-body py-5">
            <h3 class="text-center text-white">My Search</h3>
            <form action="search" method="post" class="mt-3">
                <div class="form-group">
                    <input type="text" name="querybox" placeholder="Search...." class="form-control"/>
                </div>
                <div class="container text-center">
                    <button type="submit" class="btn btn-outline-light">Search</button>
                </div>
            </form>
            <form action="logoutHandler" method="post">
                <div class="container text-center">
                    <button type="submit" class="btn btn-outline-danger">Logout</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>