<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ২৭/১২/২৩
  Time: ১১:৩৯ AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: shamim
  Date: ২৬/১২/২৩
  Time: ১১:৫২ AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach var="t" items="${testers}"> <!-- No need to import the List<Tester> testers coming from DemoServlet.java.-->
    ID: ${t.getId()} <br>
    Name: ${t.getName()} <br>
    Age: ${t.getAge()} <br><br>
</c:forEach>

</body>
</html>
