package com.controller3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class S2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int sum = (int) session.getAttribute("sum");

        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1> Sum is: "+sum+"</h1></body></html>");

        session.removeAttribute("sum");
    }
}
