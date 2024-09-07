package com.cursojava.curso.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomErrorController implements ErrorController{
    @GetMapping("/error")
    @ResponseBody
    public String handleError() {
        // Você pode adicionar lógica adicional aqui para diferentes tipos de erros
        return "404";
    }  
}
