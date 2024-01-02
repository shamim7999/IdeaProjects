package com.filters.servlets;

import com.filters.dao.GetConnection;
import com.filters.dao.LoginDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/Register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try{
            String userName = req.getParameter("name");
            String password = req.getParameter("password");
            String confirmPassword = req.getParameter("confirmPassword");

            if(password.equals(confirmPassword)) {
                String query = "Insert into login (user_name, password) values(?, ?)";
                PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);
                preparedStatement.executeUpdate();
                resp.sendRedirect("login.jsp");
            } else {
                req.setAttribute("userName", userName);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("password_not_match.jsp");

                /*
                            If we write this, then we cannot use req Attributes in the JSP file provided here.
                            resp.sendRedirect("password_not_match.jsp");

                            We can use HttpSession here.
                 */

            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
