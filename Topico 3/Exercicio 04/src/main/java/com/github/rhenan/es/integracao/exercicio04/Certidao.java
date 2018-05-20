/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenan.es.integracao.exercicio04;

public class Certidao {
    private String tipo;
    private String cartorio;
    private String livro;
    private int folha;
    private String termo;

    public Certidao () {

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCartorio() {
        return cartorio;
    }

    public void setCartorio(String cartorio) {
        this.cartorio = cartorio;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public int getFolha() {
        return folha;
    }

    public void setFolha(int folha) {
        this.folha = folha;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }
}
