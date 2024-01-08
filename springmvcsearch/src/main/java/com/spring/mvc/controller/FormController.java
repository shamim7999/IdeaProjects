package com.spring.mvc.controller;

import com.spring.mvc.model.Pupil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FormController {
    @RequestMapping("/complex")
    public String showComplexForm() {
        return "complex_form";
    }

    @RequestMapping(path = "/formHandler", method = RequestMethod.POST)
    public String processComplexForm(@ModelAttribute Pupil pupil) {
        return "show_complex_form_output";
    }

//    @RequestMapping(path = "/formHandler", method = RequestMethod.POST)
//    public String processComplexForm(@ModelAttribute Pupil pupil,
//                                     @RequestParam("date")
//                                     @DateTimeFormat(pattern = "dd/MM/yyyy") String dateString) {
//        // Convert the string to a Date object using SimpleDateFormat or another method
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date date;
//        try {
//            date = dateFormat.parse(dateString);
//        } catch (ParseException e) {
//            // Handle parsing exception if needed
//            e.printStackTrace();
//            return "redirect:/complex"; // You might want to redirect to an error page
//        }
//
//        // Now you have the 'date' variable ready for use
//
//        return "show_complex_form_output";
//    }
}
