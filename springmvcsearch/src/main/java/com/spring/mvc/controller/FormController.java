package com.spring.mvc.controller;

import com.spring.mvc.model.Pupil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {
    @RequestMapping("/complex")
    public String showComplexForm() {
        return "complex_form";
    }

    @RequestMapping(path = "/formHandler", method = RequestMethod.POST)
    public String processComplexForm(HttpServletRequest req, Model model) {
        String name = req.getParameter("name");
        long id = Integer.parseInt(req.getParameter("id"));
        String date = req.getParameter("date").toString();
        String[] subjectsArray = req.getParameterValues("subjects");
        List<String> subjects = (subjectsArray != null) ? Arrays.asList(subjectsArray) : null;
        String gender = req.getParameter("gender");
        String type = req.getParameter("type");

        Pupil pupil = new Pupil(name, id, date, subjects, gender, type);
        model.addAttribute("pupil", pupil);
        return "show_complex_form_output";
    }
    /*
        We could also do this. But we did above for insert the date in a String
        Type variable defined in Pupil Class. The date there is as String type.

        @RequestMapping(path = "/formHandler", method = RequestMethod.POST)
        public String processComplexForm(@ModelAttribute Pupil pupil) {
            return "show_complex_form_output";
        }

     */


    @RequestMapping("/fileUpload")
    public String fileUpload() {
        return "file_upload";
    }

    @RequestMapping(path = "/fileUploader", method = RequestMethod.POST)
    public String uploadImage(@RequestParam("img") CommonsMultipartFile file,
                              HttpServletRequest request, Model model) {
        System.out.println("file upload handler........");
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getStorageDescription());
        System.out.println(file.getFileItem());

        byte[] data = file.getBytes();

        // save this file in server
        String path = request.getServletContext().getRealPath("/") + "WEB-INF/resources/image/"
                + file.getOriginalFilename();
        System.out.println(path);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(path);
            fos.write(data);
            fos.close();
            model.addAttribute("msg", "uploaded successfully");
            model.addAttribute("filename", file.getOriginalFilename());
            System.out.println("File Uploaded...........");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File has Some error!!!!!!!!!!");
            model.addAttribute("msg", "uploaded Error!!");
        }
        return "file_success";
    }
    @RequestMapping("/errorTest")
    public String errorTest() {
        String s1 = null;
        System.out.println(s1.length());
        return "home";
    }

}