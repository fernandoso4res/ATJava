package br.com.fernando.atDeJava.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class Pessoa {
    private int id;
    private String nome;
    private Cep cep;
}
