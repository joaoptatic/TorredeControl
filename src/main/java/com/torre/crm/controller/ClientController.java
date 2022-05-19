package com.torre.crm.controller;

import com.torre.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

@RestController
public class ClientController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/cliente/{id}")
    public ResponseEntity <Cliente> buscar(@PathVariable ("id") Long id){
        var cliente = clienteRepository.findById(id);

        if(cliente.isEmpty()) throw new RuntimeException("Não foi encontrado cliente com o id " + id);

        return ResponseEntity.ok(cliente.get());
    }

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente){
        var novoCliente = clienteRepository.save(cliente);
        var novoClienteURL = "http://localhost:8080/cliente/" + cliente.getId();

        return ResponseEntity.created(URI.create(novoClienteURL)).body(novoCliente);
    }
}
