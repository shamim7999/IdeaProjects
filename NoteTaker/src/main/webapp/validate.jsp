<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); /// Http 1.1
    response.setHeader("Pragma", "no-cache"); // Http 1.0
    response.setHeader("Expires", "0"); // Proxies

    if(session.getAttribute("userName") == null) {

        response.sendRedirect("login.jsp");
    }
    /// When we change the browser, we'll automatically removing the HttpSession
%>
