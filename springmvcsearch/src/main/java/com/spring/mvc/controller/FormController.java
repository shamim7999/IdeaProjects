package com.spring.mvc.controller;

import com.spring.mvc.model.Pupil;
import com.spring.mvc.model.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
}