package com.github.rhenanrk.es.integracao.exercicio02;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public final class Sapato {
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

    @Override
    public String toString() {
        return "\n  Sapato {" +
                "Marca = '" + marca + '\'' +
                ", Preco = '" + preco + '\'' +
                ", Cor = '" + cor + '\'' +
                "}";
    }
}