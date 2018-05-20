/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenan.es.integracao.exercicio04;

public class Nacionalidade {
    private String municipio;
    private String estado;
    private String pais;
    private String dataEntradaPais;

    public Nacionalidade () {

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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDataEntradaPais() {
        return dataEntradaPais;
    }

    public void setDataEntradaPais(String dataEntradaPais) {
        this.dataEntradaPais = dataEntradaPais;
    }
}
