package br.com.fernando.atDeJava.controller;

import br.com.fernando.atDeJava.model.Pessoa;
import br.com.fernando.atDeJava.service.EnderecoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/pessoas")
public class PessoaController {

    Logger logger = LoggerFactory.getLogger(PessoaController.class);
    @Autowired
    EnderecoService enderecoService;



    @GetMapping
    public List<Pessoa> getAll(){

        return enderecoService.getAll();
    }
}
