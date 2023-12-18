package com.controller;

import com.dao.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class DispatchedServlet extends HttpServlet{

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("user_name");
        String course = req.getParameter("user_course");
        String email = req.getParameter("user_email");
        String age = req.getParameter("user_age");

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config.xml"});
        DbSql dbSql = (DbSql) context.getBean("dbsql");

        String id = dbSql.checkEmail(email);
        if(id != null) {
            dbSql.setId(id);
            dbSql.setName(name);
            dbSql.setAge(age);
            dbSql.setCourse(course);
            dbSql.setEmail(email);
            dbSql.sendData();

            out.println("<html><body>");
            out.println("<h1>"+name+"</h1>");
            out.println("<h1>"+course+"</h1>");
            //out.println("<h1>"+email+"</h1>");
            out.println("<h1>"+age+"</h1>");
            out.println("Inserted Successfully</body></html>");

            RequestDispatcher rd = req.getRequestDispatcher("form.jsp");
            rd.include(req, resp);
        } else {
            out.println("<html><body>");
            out.println("<h1>You haven't register through the provided email.</h1>");
            out.println("<h2>Please Register First</h2>");

            RequestDispatcher rd = req.getRequestDispatcher("form2.jsp");
            rd.include(req, resp);
        }
    }
}