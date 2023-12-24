package br.com.fernando.atDeJava.controller;

import br.com.fernando.atDeJava.model.Cliente;
import br.com.fernando.atDeJava.model.ResponsePayload;
import br.com.fernando.atDeJava.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    ClienteService clienteService;


    @GetMapping
    public List<Cliente> listar(){
        logger.info("Listagem Clientes");

        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable int id){
        logger.info("Listagem Clientes pelo ID");
        return clienteService.getById(id);

    }

    @PostMapping
    public ResponseEntity save(@RequestBody Cliente cliente){
        Cliente returned = clienteService.save(cliente);
        logger.info("Criado com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(returned);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        try {
            Cliente removed = clienteService.delete(id);
            logger.info("CLIENTE REMOVIDO");
            return ResponseEntity.ok(removed);
        } catch (RuntimeException ex) {
            ResponsePayload responsePayload = new ResponsePayload(ex.getMessage());
            logger.info("Cliente não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePayload);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Cliente cliente){
        try{
            Cliente returned = clienteService.update(id, cliente);
            logger.info("CLIENTE ATUALIZADO");
            return ResponseEntity.status(HttpStatus.OK).body(returned);
        }catch(RuntimeException ex){
            ResponsePayload responsePayload = new ResponsePayload(ex.getMessage());
            logger.info("Cliente Não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePayload);
        }



        }

    }

