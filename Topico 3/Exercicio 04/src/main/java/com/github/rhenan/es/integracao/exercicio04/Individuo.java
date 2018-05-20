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

    public Individuo () {

    }

    public int getSurrogateKey() {
        return surrogateKey;
    }

    public void setSurrogateKey(int surrogateKey) {
        this.surrogateKey = surrogateKey;
    }
}
