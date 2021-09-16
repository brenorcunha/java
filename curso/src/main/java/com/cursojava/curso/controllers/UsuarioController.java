package com.cursojava.curso.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class UsuarioController {
    @RequestMapping(value = "prueba")
    public String prueba(){
     return("prubea");
    }
}
