/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenan.es.integracao.exercicio04;

public class Vinculo {
    private String relacionamento;
    private String dataInicio;
    private String dataFim;

    public Vinculo () {

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
