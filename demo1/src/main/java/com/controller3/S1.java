package com.controller3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class S1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        int x = Integer.parseInt(req.getParameter("num1"));
        int y = Integer.parseInt(req.getParameter("num2"));

        int sum = x+y;

        HttpSession session = req.getSession();
        session.setAttribute("sum", sum);

        resp.sendRedirect("c3s2");

    }
}
