/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dto;

public class IdentificadorDto {

    private String surrogateKey;
    private String idCod;
    private String designacao;
    private int area;
    private String emissor;
    private String dataEmissao;
    private int tipo;

    public String getsurrogateKey() {
        return surrogateKey;
    }

    public void setsurrogateKey(String surrogateKey) {
        this.surrogateKey = surrogateKey;
    }

    public String getIdCod() {
        return idCod;
    }

    public void setIdCod(String idCod) {
        this.idCod = idCod;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getEmissor() {
        return emissor;
    }

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public int  getTipo() {
        return tipo;
    }

    public void setTipo(int  tipo) {
        this.tipo = tipo;
    }
}
