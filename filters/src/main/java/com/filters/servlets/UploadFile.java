package com.filters.servlets;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.fileupload.FileItem;

import java.util.List;

@WebServlet("/uploadFile")
public class UploadFile extends HttpServlet {
    private String message;


    public void doPost(HttpServletRequest request, HttpServletResponse response)  {
        //List<FileItem> fileItems = request.
    }

}