package com.controller2;

import com.controller.HelloServlet;
import com.dao.DbSql;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;

public class DispatchedPersonServlet extends HelloServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String email = req.getParameter("user_email");
        String password = req.getParameter("user_password");
        String confirmPassword = req.getParameter("user_confirm_password");


        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"config.xml"});
        DbSql dbSql = (DbSql) context.getBean("dbsql");

        if(password.equals(confirmPassword) && dbSql.checkEmail(email) == null) {
            dbSql.setRegEmail(email);
            dbSql.setRegPassword(password);

            dbSql.sendRegData();

            out.println("<html><body>");

            out.println("Registration Completed</body></html>");


            RequestDispatcher rd = req.getRequestDispatcher("form.jsp");
            rd.include(req, resp);
        } else{
            out.println("<html><body>");

            out.println("Registration Failed... You have used duplicate email or you have entered wrong confirm password..</body></html>");
            RequestDispatcher rd = req.getRequestDispatcher("form2.jsp");
            rd.include(req, resp);
        }


    }
}
