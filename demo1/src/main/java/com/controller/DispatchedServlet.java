package com.controller;

import com.dao.*;
import java.io.*;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class DispatchedServlet extends HttpServlet{

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("user_name");
        String course = req.getParameter("user_course");
        String email = req.getParameter("user_email");
        String age = req.getParameter("user_age");

        MySql ob = new MySql(name, email, course, age);

        out.println("<html><body>");
        out.println("<h1>"+name+"</h1>");
        out.println("<h1>"+course+"</h1>");
        out.println("<h1>"+email+"</h1>");
        out.println("<h1>"+age+"</h1>");
        out.println("Inserted Successfully</body></html>");

        RequestDispatcher rd = req.getRequestDispatcher("form.jsp");
        rd.include(req, resp);
    }
}