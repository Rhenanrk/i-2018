/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.rhenanrk.dto;

/**
 * Classe responsável por abstrair o objeto Nome.
 */
public class NomeDto {
    private String surrogateKey;
    private String titulos;
    private String nomes;
    private String sobrenomes;
    private String sufixos;
    private String nomeCompleto;
    private int preferido;
    private int usoCondicional;
    private int uso;
    private String inicioUso;
    private String fimUso;

    public String getSurrogateKey() {
        return surrogateKey;
    }

    public void setSurrogateKey(String surrogateKey) {
        this.surrogateKey = surrogateKey;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public String getNomes() {
        return nomes;
    }

    public void setNomes(String nomes) {
        this.nomes = nomes;
    }

    public String getSobrenomes() {
        return sobrenomes;
    }

    public void setSobrenomes(String sobrenomes) {
        this.sobrenomes = sobrenomes;
    }

    public String getSufixos() {
        return sufixos;
    }

    public void setSufixos(String sufixos) {
        this.sufixos = sufixos;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getPreferido() {
        return preferido;
    }

    public void setPreferido(int preferido) {
        this.preferido = preferido;
    }

    public int getUsoCondicional() {
        return usoCondicional;
    }

    public void setUsoCondicional(int usoCondicional) {
        this.usoCondicional = usoCondicional;
    }

    public int getUso() {
        return uso;
    }

    public void setUso(int uso) {
        this.uso = uso;
    }

    public String getInicioUso() {
        return inicioUso;
    }

    public void setInicioUso(String inicioUso) {
        this.inicioUso = inicioUso;
    }

    public String getFimUso() {
        return fimUso;
    }

    public void setFimUso(String fimUso) {
        this.fimUso = fimUso;
    }
}
