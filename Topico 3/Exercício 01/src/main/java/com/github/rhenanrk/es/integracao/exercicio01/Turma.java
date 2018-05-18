/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.rhenanrk.es.integracao.exercicio01;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Classe responsável por definir as propriedades do objeto Turma
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Turma {
    @XmlElementWrapper(name = "alunos")
    @XmlElement(name = "aluno")

    private List<Aluno> alunos;

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}