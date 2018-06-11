/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dto;

/**
 * Classe responsável por abstrair o objeto Endereço.
 */
public class EnderecoDto {

    private String surrogateKey;
    private int tipo;
    private String endereco;
    private String bairro;
    private String distrito;
    private String municipio;
    private String estado;
    private String cep;
    private String caixaPostal;
    private String pais;
    private String dataInicio;
    private String acuraciaInicio;
    private String dataFim;
    private String acuraciaFim;

    public String getSurrogateKey() {
        return surrogateKey;
    }

    public void setSurrogateKey(String surrogateKey) {
        this.surrogateKey = surrogateKey;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCaixaPostal() {
        return caixaPostal;
    }

    public void setCaixaPostal(String caixaPostal) {
        this.caixaPostal = caixaPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getAcuraciaInicio() {
        return acuraciaInicio;
    }

    public void setAcuraciaInicio(String acuraciaInicio) {
        this.acuraciaInicio = acuraciaInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getAcuraciaFim() {
        return acuraciaFim;
    }

    public void setAcuraciaFim(String acuraciaFim) {
        this.acuraciaFim = acuraciaFim;
    }
}
