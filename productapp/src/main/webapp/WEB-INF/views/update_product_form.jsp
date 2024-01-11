<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ১১/১/২৪
  Time: ১১:৫৭ AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="./all_css_js.jsp"%>
</head>
<body>
<h1>This is Product CRUD App</h1>
<div class="container mt-3">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h1 class="text-center mb-3">Change The Product Detail</h1>
            <form action="${pageContext.request.contextPath}/processProductForm" method="post">
                <input name="id" value="${product.id}" type="hidden"/>
                <div class="form-group mt-5">
                    <label for="name">Product Name</label>
                    <input type="text" class="form-control" name="name" value="${product.name}" id="name" aria-describedby="emailHelp" placeholder="Enter the product name here">
                </div>
                <div class="form-group mt-5">
                    <label for="description">Product Description</label>
                    <textarea rows="5" class="form-control" name="description" id="description"
                              aria-describedby="emailHelp" placeholder="Enter the product description here">
                        ${product.description}
                    </textarea>
                </div>
                <div class="form-group mt-5">
                    <label for="price">Product Price</label>
                    <input type="text" class="form-control" name="price" value="${product.price}" id="price" placeholder="Enter the product price here">
                </div>
                <div class="container text-center mt-5">
                    <a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">back</a>
                    <button type="submit" class="btn btn-primary">Update</button>
                    <a href="${pageContext.request.contextPath}/all-products" class="btn btn-outline-success">Show All</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
