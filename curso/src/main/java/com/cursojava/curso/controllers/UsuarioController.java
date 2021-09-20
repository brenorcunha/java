package com.cursojava.curso.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.models.Usuario;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class UsuarioController {
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setFirstName("Breno");
        usuario.setLastName("Cunha");
        usuario.setEmail("brenno@brenno.com");
        usuario.setPhone("08001110000");
        return usuario;
    }
}
