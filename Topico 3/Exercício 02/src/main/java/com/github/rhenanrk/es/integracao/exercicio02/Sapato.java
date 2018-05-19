/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenanrk.es.integracao.exercicio02;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Classe responsável por definir as propriedades do objeto Sapato
 */
public class Sapato {
    @JacksonXmlProperty(localName = "marca")
    private String marca;
    @JacksonXmlProperty(localName = "preco")
    private float preco;
    @JacksonXmlProperty(localName = "cor")
    private String cor;


    public Sapato() {
    }

    public Sapato(String marca, float preco, String cor) {
        this.marca = marca;
        this.preco = preco;
        this.cor = cor;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Método responsável por definir as propriedades de formatação do objeto Sapato
     *
     * @return String - Propriedades formatadas de Sapato
     */
    @Override
    public String toString() {
        return "\n  Sapato {" +
                "Marca = '" + marca + '\'' +
                ", Preco = '" + preco + '\'' +
                ", Cor = '" + cor + '\'' +
                "}";
    }
}