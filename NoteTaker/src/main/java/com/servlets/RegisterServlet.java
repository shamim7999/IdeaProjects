package com.servlets;

import com.entities.Note;
import com.helper.FactoryProvider;
import com.helper.GetConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        String userName = req.getParameter("user_name");
        String password = req.getParameter("user_password");
        String confirmPassword = req.getParameter("user_confirm_password");

        //String query = "Select * from reg where user_name=? and password=?";
        if(password.equals(confirmPassword)) {
            try {

                String query = "select * from reg where user_name=?";

                PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(query);
                preparedStatement.setString(1, userName);
                //preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()) {
                    res.sendRedirect("register.jsp");
                } else {
                    String query2 = "insert into reg (user_name, password) values(?, ?)";
                    preparedStatement = GetConnection.getConnection().prepareStatement(query2);

                    preparedStatement.setString(1, userName);
                    preparedStatement.setString(2, password);

                    preparedStatement.executeUpdate();

                    res.sendRedirect("login.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
                res.sendRedirect("register.jsp");
            }
        } else {
            out.println("<html><body>");
            out.println("<h1>Passwords don't match.</h1></html></body>");
            res.sendRedirect("register.jsp");
        }


//        String userName = req.getParameter("user_name");
//        String password = req.getParameter("user_password");
//        String confirmPassword = req.getParameter("user_confirm_password");
//
//        if(password.equals(confirmPassword)) {
//            Session session = FactoryProvider.getFactory().openSession();
//            NativeQuery query = session.createSQLQuery("select * from reg where user_name=?");
//            List<Object[]> list = query.list();
//        } else {
//            out.println("<html><body>");
//            out.println("<h1>Passwords don't match.</h1></html></body>");
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.jsp");
//            requestDispatcher.include(req, res);
//        }
    }
}
