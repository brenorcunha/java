package com.cursojava.curso.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
@Controller
public class CustomErrorController implements ErrorController{
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Você pode adicionar lógica adicional aqui para diferentes tipos de erros
        return "error/404"; // Nome do template Thymeleaf
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
    
}
