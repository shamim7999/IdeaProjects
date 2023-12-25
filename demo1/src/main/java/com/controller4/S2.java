package com.controller4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "c4s2", value = "/c4s2")
public class S2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookies[] = req.getCookies();

        int sum = Arrays.stream(cookies)
                .filter(cookie -> "sum".equals(cookie.getName()))
                .findFirst()
                .map(cookie -> Integer.parseInt(cookie.getValue()))
                .orElse(0);

        PrintWriter out = resp.getWriter();
        out.println("<html><body><h1> Sum is: "+sum+"</h1></body></html>");

    }
}
