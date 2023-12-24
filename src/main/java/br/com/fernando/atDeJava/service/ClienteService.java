package br.com.fernando.atDeJava.service;

import br.com.fernando.atDeJava.ExternalAPI.CepUtil;
import br.com.fernando.atDeJava.model.Cep;
import br.com.fernando.atDeJava.model.Cliente;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ClienteService {

    Logger logger = LoggerFactory.getLogger(ClienteService.class);
    private List<Cliente> clientes = initClientes();

    private List<Cliente> initClientes(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        CepUtil cepUtil = new CepUtil();
        String[] listaDeCeps = {"76239-970", "60353-060", "68903-497", "68925-105", "69900-973", "59633-900"};




        for(int i = 0;i< listaDeCeps.length; i++){
            Faker faker = new Faker(new Locale("pt-BR"));
            String nome = faker.name().fullName();
            String cepCode = listaDeCeps[i];
            String[] separador = cepCode.split("-");
            String cepCorrigido = separador[0] + separador[1];
            Cep cep = cepUtil.getByCep(cepCorrigido);
            Cliente cliente = new Cliente(i, nome, cep);
            clientes.add(cliente);
        }


        return clientes;
    }

    public List<Cliente> getAll(){
        return clientes;
    }

    public Cliente getById(int id){

        return clientes.get(id);
    }
    public Cliente save(Cliente cliente){
        clientes.add(cliente);
        return cliente;
    }

    public Cliente delete(int id){
        return clientes.remove(id);
    }

    public Cliente update(int id, Cliente cliente){
        clientes.remove(id);
        cliente.setId(id);
        clientes.add(id , cliente);
        return cliente;
    }
}
