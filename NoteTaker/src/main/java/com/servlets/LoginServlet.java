package com.servlets;

import com.helper.FactoryProvider;
import com.helper.GetConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userName = req.getParameter("user_name");
        String password = req.getParameter("user_password");

        String query = "SELECT * FROM reg WHERE user_name=? AND password=?";
        try {
            PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("userName", userName);
                res.sendRedirect("index.jsp");
            } else {
                res.sendRedirect("register.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect("register.jsp");
        }
    }
}
