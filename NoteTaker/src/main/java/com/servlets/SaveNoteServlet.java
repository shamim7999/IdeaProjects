package com.servlets;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.entities.Note;
import com.helper.FactoryProvider;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class SaveNoteServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        try {
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            Note note = new Note(title, content, LocalDateTime.now());
            Session session = FactoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();

            session.save(note);

            transaction.commit();
            session.close();

            out.println("<html><body>");
            out.println(title);
            out.println(content);
            out.println("<h1>Inserted</h1></html></body>");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}