/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dto;

/**
 * Classe responsável por abstrair o objeto Representacao.
 */
public class RepresentacaoDto {

    private String surrogateKey;
    private String utilizacao;
    private String alternativa;

    public String getsurrogateKey() {
        return surrogateKey;
    }

    public void setsurrogateKey(String surrogateKey) {
        this.surrogateKey = surrogateKey;
    }

    public String getUtilizacao() {
        return utilizacao;
    }

    public void setUtilizacao(String utilizacao) {
        this.utilizacao = utilizacao;
    }

    public String getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(String alternativa) {
        this.alternativa = alternativa;
    }
}
