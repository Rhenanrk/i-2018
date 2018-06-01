/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dto;

public class ComunicacaoDto {

    private String surrogateKey;
    private int meio;
    private String detalhe;
    private int preferencia;
    private int utilizacao;

    public String getsurrogateKey() {
        return surrogateKey;
    }

    public void setsurrogateKey(String surrogateKey) {
        this.surrogateKey = surrogateKey;
    }

    public int getMeio() {
        return meio;
    }

    public void setMeio(int meio) {
        this.meio = meio;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public int getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(int preferencia) {
        this.preferencia = preferencia;
    }

    public int getUtilizacao() {
        return utilizacao;
    }

    public void setUtilizacao(int utilizacao) {
        this.utilizacao = utilizacao;
    }
}
