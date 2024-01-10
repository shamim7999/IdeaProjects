<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ৯/১/২৪
  Time: ৩:৪৮ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container text-center">
    <h1>This is a File Upload Form</h1>
    <form action="fileUploader" enctype="multipart/form-data" method="post">
        <div class="mb-3 col-md-6 offset-md-3 mt-4">
            <input type="file" name="img" class="form-control">
        </div>
        <div class="mb-3 col-md-6 offset-md-3 mt-4">
            <button class="btn btn-primary">Upload</button>
        </div>
    </form>
</div>
</body>
</html>