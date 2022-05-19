package com.torre.crm.controller;

import java.util.List;
import java.util.Optional;

import com.torre.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping("/clientes")
public class ClientController<string> {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @DeleteMapping("/clientes")
    @ResponseBody
    public ResponseEntity deletarCliente(@PathParam("id") Long id) {
        return new ResponseEntity<String>("Cliente deletado com sucesso", HttpStatus.OK);
    }

    @GetMapping("/clientes")
    @ResponseBody
    public ResponseEntity <List<Cliente>> buscar(@PathParam("id") Long id){

       return new ResponseEntity (HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

}
