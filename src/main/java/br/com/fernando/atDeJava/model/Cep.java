package br.com.fernando.atDeJava.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder

public class Cep {
    private String cep;
    private String state;
    private String city;
    private String service;
}
