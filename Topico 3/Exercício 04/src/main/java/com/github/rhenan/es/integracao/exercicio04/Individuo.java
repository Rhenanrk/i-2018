/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenan.es.integracao.exercicio04;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement()  // defina o objeto Turma como a raiz do arquivo XML
public class Individuo {
    private int surrogateKey;
    private Nome nome;
    private Endereco endereco;
    private Identificador identificador;
    private dadoDemografico dadoDemografico;
    private Comunicacao comunicacao;
    private Vinculo vinculo;

    public Individuo () {

    }

    public Nome getNome() {
        return nome;
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Identificador getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Identificador identificador) {
        this.identificador = identificador;
    }

    public dadoDemografico getDadoDemografico() {
        return dadoDemografico;
    }

    public void setDadoDemografico(dadoDemografico dadoDemografico) {
        this.dadoDemografico = dadoDemografico;
    }

    public Comunicacao getComunicacao() {
        return comunicacao;
    }

    public void setComunicacao(Comunicacao comunicacao) {
        this.comunicacao = comunicacao;
    }

    public Vinculo getVinculo() {
        return vinculo;
    }

    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    public int getSurrogateKey() {
        return surrogateKey;
    }

    public void setSurrogateKey(int surrogateKey) {
        this.surrogateKey = surrogateKey;
    }
}
