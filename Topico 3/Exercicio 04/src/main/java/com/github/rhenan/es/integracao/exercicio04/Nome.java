/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenan.es.integracao.exercicio04;

public class Nome {
    private int surrogateKey;
    private String titulos;
    private String nomes;
    private String sobrenomes;
    private String sufixos;
    private String preferido;
    private String usoCondicional;

    public Nome () {

    }

    public int getSurrogateKey() {
        return surrogateKey;
    }

    public void setSurrogateKey(int surrogateKey) {
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

    public String getPreferido() {
        return preferido;
    }

    public void setPreferido(String preferido) {
        this.preferido = preferido;
    }

    public String getUsoCondicional() {
        return usoCondicional;
    }

    public void setUsoCondicional(String usoCondicional) {
        this.usoCondicional = usoCondicional;
    }
}
