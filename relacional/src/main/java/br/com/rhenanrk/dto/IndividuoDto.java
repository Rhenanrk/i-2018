/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dto;

/**
 * Classe responsável por abstrair o objeto Identificador.
 */
public class IndividuoDto {

    private String surrogateKey;

    public String getsurrogateKey() {
        return surrogateKey;
    }

    public void setsurrogateKey(String surrogateKey) {
        this.surrogateKey = surrogateKey;
    }
}
