package com.github.rhenanrk.es.integracao.exercicio02;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Classe responssável por definir as propriedades do objeto Tenis
 *
 * @author rhenanrk
 */

public final class Tenis {
    @JacksonXmlProperty(localName = "marca")
    private String marca;
    @JacksonXmlProperty(localName = "preco")
    private float preco;
    @JacksonXmlProperty(localName = "esporte")
    private String esporte;

    public Tenis() {
    }

    public Tenis(String marca, float preco, String esporte) {
        this.marca = marca;
        this.preco = preco;
        this.esporte = esporte;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getEsporte() {
        return esporte;
    }

    public void setEsporte(String esporte) {
        this.esporte = esporte;
    }


    /**
     * Método responssável por definir as propriedades de formatação do objeto Tenis
     *
     * @return String - Propriedades formatadas de Tenis
     */
    @Override
    public String toString() {
        return "\n  Tenis {" +
                "Marca = '" + marca + '\'' +
                ", Preco = '" + preco + '\'' +
                ", Esporte = " + esporte +
                "}";
    }
}