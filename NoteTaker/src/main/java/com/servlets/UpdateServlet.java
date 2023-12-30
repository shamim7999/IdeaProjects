package com.servlets;

import com.entities.Note;
import com.helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int id = Integer.parseInt(req.getParameter("id"));

        Session session = FactoryProvider.getFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Note note = session.get(Note.class, id);
        note.setTitle(title);
        note.setContent(content);
        note.setAddedDate(LocalDateTime.now());

        transaction.commit();
        session.close();

        res.sendRedirect("all_notes.jsp");
    }
}
