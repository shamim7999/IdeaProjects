package com.controller;

import java.io.*;
import java.sql.*;

import com.dao.MySql;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class RegisterServlet extends HttpServlet{

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher rd = req.getRequestDispatcher("dispatchedservlet"); //// ------> url pattern
        rd.forward(req, resp);
    }
}