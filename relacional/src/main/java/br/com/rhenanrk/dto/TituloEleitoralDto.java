/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dto;

/**
 * Classe responsável por abstrair o objeto Titulo eleitoral.
 */
public class TituloEleitoralDto {

    private String idCod;
    private String surrogateKey;
    private int secao;
    private int zona;

    public String getIdCod() {
        return idCod;
    }

    public void setIdCod(String idCod) {
        this.idCod = idCod;
    }

    public String getSurrogateKey() {
        return surrogateKey;
    }

    public void setSurrogateKey(String surrogateKey) {
        this.surrogateKey = surrogateKey;
    }

    public int getSecao() {
        return secao;
    }

    public void setSecao(int secao) {
        this.secao = secao;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }
}
