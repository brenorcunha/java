package com.algaworks.algalog.algalogapi;
import java.util.Arrays;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    //Quando conectar no BD, desativar os cmentarios, pra ele utilizar o JPA:
    @PersistenceContext
    private EntityManager manager
    
    @GetMapping("/Cliente")
    public List<Cliente> listar(){
        //Aqui, descomentar linha abaixo e apagar/comentar o resto: 
        return manager.createQuery("from Cliente, Cliente.class");
        /*
        var cliente1 = new Cliente();
        cliente1.setNome("Joao das Couves2");
        cliente1.setId(1L);
        cliente1.setEmail("joaodascouves@algaworks.com");
        cliente1.setTelefone("34 9999-1111");
        
        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Maria Virgulina");
        cliente2.setEmail("mariavirgulina@algaworks.com");
        cliente2.setTelefone("34 9999-2222");

        return Arrays.asList(cliente1, cliente2);
        */
    }
}
