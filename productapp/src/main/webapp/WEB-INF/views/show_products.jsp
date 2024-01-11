<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ১১/১/২৪
  Time: ৩:৩২ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="all_css_js.jsp"%>
</head>
<body>
    <div class="container mt-3">
        <div class="row">
            <div class="col-md-12">
                <table class="table">
                    <thead class="table-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Product Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">Price</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" items="${productList}">
                            <tr>
                                <th scope="row">${product.id}</th>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                                <td>${product.price}</td>
                                <td>
                                    <a href="deleteProduct/${product.id}"> <i class="fa-solid fa-trash text-danger mr-3" style="font-size: 25px;"></i> </a>
                                    <a href="updateProduct/${product.id}"> <i class="fa-solid fa-pen-to-square"  style="font-size: 25px;"></i> </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="container text-center">
                    <a href="${pageContext.request.contextPath}/add-product" class="btn btn-outline-success">Add Product</a>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
