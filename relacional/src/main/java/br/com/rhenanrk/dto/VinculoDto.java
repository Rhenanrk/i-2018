/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dto;

/**
 * Classe responsável por abstrair o objeto Vonculo.
 */
public class VinculoDto {

    private String surrogateKey;
    private String surrogateKeyPessoaVinculada;
    private String relacionamento;
    private String dataInicio;
    private String dataFim;

    public String getSurrogateKey() {
        return surrogateKey;
    }

    public void setSurrogateKey(String surrogateKey) {
        this.surrogateKey = surrogateKey;
    }

    public String getSurrogateKeyPessoaVinculada() {
        return surrogateKeyPessoaVinculada;
    }

    public void setSurrogateKeyPessoaVinculada(String surrogateKeyPessoaVinculada) {
        this.surrogateKeyPessoaVinculada = surrogateKeyPessoaVinculada;
    }

    public String getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(String relacionamento) {
        this.relacionamento = relacionamento;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
