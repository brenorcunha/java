package com.algaworks.algalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgalogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgalogApiApplication.class, args);
	}

}
/*
 * FAZER REQUISICOES:
 * Executar: No terminal do VS dá "java -jar <nomedojarsnapshot>.jar"
 * GET= Só enviar GET pra http://localhost:8080/clientes
 * POST= No campo BODY coloca o JSON com dados a serem add. Ex:
 * {
        "id": 0,
        "nome": "Humberto A. da Cunha",
        "email": "bettocunha@alga.com",
        "telefone": "(12) 92000-0000"
    }
	PUT: Aí precisa mandar o dado a ser alterado na uRL. Ex:
	http://localhost:8080/clientes/3 (Quero alterar dados do cliente de ID 3).

	 No BODY:
	 {
        "nome": "Humberto A. da Cunha",
        "email": "humberto_da_cunha@alga.com",
        "telefone": "(12) 92000-0000"
    }
 */