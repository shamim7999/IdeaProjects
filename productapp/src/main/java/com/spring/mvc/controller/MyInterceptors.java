package com.spring.mvc.controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptors extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("text/html");
        System.out.println("Pre Handle ran first..");
        String personName = request.getParameter("person_name");
        if(personName.startsWith("Sh")) {
            response.getWriter().println("Correct Person.. You're welcome");
            return true;
        }
        response.getWriter().println("Stranger came, get out..!!!");
        return false;
    }
}
