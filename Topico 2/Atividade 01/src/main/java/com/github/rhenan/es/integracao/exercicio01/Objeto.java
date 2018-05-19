/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 *
 */

package com.github.rhenan.es.integracao.exercicio01;

/**
 * Classe responsável por abstrair as propriedades do abjeto que será serializado
 */
public class Objeto {

    private String nome;

    public Objeto(String nome) {
        super();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
