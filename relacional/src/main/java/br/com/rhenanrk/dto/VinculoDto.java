/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dto;

public class VinculoDto {

    private String surrogateKeyPessoaVinculada;
    private String relacionamento;
    private String dataInicio;
    private String dataFim;

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
