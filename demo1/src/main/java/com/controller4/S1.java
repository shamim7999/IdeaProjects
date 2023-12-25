package com.controller4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "c4s1", value = "/c4s1")
public class S1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int x = Integer.parseInt(req.getParameter("num1"));
        int y = Integer.parseInt(req.getParameter("num2"));

        int sum = x+y;

        Cookie cookie = new Cookie("sum", sum+"");
        resp.addCookie(cookie);

        resp.sendRedirect("c4s2");
    }
}
