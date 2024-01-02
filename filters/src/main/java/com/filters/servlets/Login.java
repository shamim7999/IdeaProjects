package com.filters.servlets;

import com.filters.dao.LoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        String password = req.getParameter("password");

        LoginDao loginDao = new LoginDao();

        if(loginDao.check(userName, password) == true) {
            HttpSession session = req.getSession();
            session.setAttribute("userName", userName);
            resp.sendRedirect("welcome.jsp");
        } else {
            resp.sendRedirect("register.jsp");
        }
    }
}
