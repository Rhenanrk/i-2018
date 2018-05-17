package com.github.rhenanrk.es.integracao.exercicio02;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Arrays;

/**
 * Classe responssável por desserializar, a partir de arquivo .XML, objetos do tipo Sapato e Tenis
 *
 * @author rhenanrk
 */

@JacksonXmlRootElement(localName = "calcados")
public final class Sapataria {
    @JacksonXmlElementWrapper(localName = "tenis", useWrapping = false)
    private Tenis[] tenis;

    @JacksonXmlElementWrapper(localName = "sapato", useWrapping = false)
    private Sapato[] sapato;

    public Sapataria() {
    }

    public Sapataria(Tenis[] tenis, Sapato[] sapato) {
        this.tenis = tenis;
        this.sapato = sapato;
    }

    public Tenis[] getTenis() {
        return tenis;
    }

    public void setTenis(Tenis[] tenis) {
        this.tenis = tenis;
    }

    public Sapato[] getSapato() {
        return sapato;
    }

    public void setSapato(Sapato[] sapato) {
        this.sapato = sapato;
    }


    @Override
    public String toString() {
        return "Calçados:\nTenis --> " + Arrays.toString(tenis) +
                        "\nSapato --> " + Arrays.toString(sapato) +
                "}";
    }
}