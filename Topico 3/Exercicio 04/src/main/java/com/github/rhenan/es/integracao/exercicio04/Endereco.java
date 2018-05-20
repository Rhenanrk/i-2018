/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenan.es.integracao.exercicio04;

public class Endereco {
    private int surrogateKey;
    private String bairro;
    private String distrito;
    protected int codigoMunicipal;
    protected String estado;
    private int Cep;
    private int caixaPostal;
    private String pais;
    private String tipo;

    public Endereco() {
    }

    public int getSurrogateKey() {
        return surrogateKey;
    }

    public void setSurrogateKey(int surrogateKey) {
        this.surrogateKey = surrogateKey;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getCodigoMunicipal() {
        return codigoMunicipal;
    }

    public void setCodigoMunicipal(int codigoMunicipal) {
        this.codigoMunicipal = codigoMunicipal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCep() {
        return Cep;
    }

    public void setCep(int cep) {
        Cep = cep;
    }

    public int getCaixaPostal() {
        return caixaPostal;
    }

    public void setCaixaPostal(int caixaPostal) {
        this.caixaPostal = caixaPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
