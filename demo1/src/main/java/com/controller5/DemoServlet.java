package com.controller5;

import com.entity.Tester;
import com.queries.QueryImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "demoServlet", value = "/demoServlet")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Tester> testers = new ArrayList<>();
        try {

            QueryImpl qi = new QueryImpl();
            String query = "Select * from tester";
            testers = qi.queryRow(query);


        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("testers", testers);

        RequestDispatcher rd = req.getRequestDispatcher("jspJSTL.jsp");
        rd.forward(req, res);

//        res.setContentType("text/html");
//        PrintWriter out = res.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Hello Demo</h1>");
//        out.println(testers.get(0).getName());
//        out.println("</body></html>");
  }

}