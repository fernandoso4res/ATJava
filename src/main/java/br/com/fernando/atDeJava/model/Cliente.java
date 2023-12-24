package br.com.fernando.atDeJava.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Cliente {
    private int id;
    private String nome;
    private Cep endereco;

}
