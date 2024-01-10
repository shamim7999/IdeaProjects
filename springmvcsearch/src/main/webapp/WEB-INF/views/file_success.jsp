<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!doctype html>
<html lang="en">
<head>
    <title>File Uploaded Result</title>
</head>
<body>
<h1>File Uploaded Result</h1>

<h2>${msg}</h2>
<img alt="profile image"
     src='<c:url value="/resources/images/${filename }" />'>

</body>
</html>