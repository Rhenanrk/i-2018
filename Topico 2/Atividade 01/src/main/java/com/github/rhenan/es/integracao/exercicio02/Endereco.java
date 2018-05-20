/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 *
 */

package com.github.rhenan.es.integracao.exercicio02;

/**
 * Classe responsável por definir os atributos do objeto Endereco
 *
 */
public class Endereco {

    public Endereco() {
    }

    private String CEP;
    private String logradouro;

    public Endereco(String CEP, String logradouro) {
        super();
        this.CEP = CEP;
        this.logradouro = logradouro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

}