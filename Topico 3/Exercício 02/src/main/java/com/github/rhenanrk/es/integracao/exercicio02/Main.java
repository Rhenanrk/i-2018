/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenanrk.es.integracao.exercicio02;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Classe responsável por instanciar o objeto Calcado, que contem, respectivamente,
 * objetos do tipo Sapato e Tenis
 * <p>
 * O arquivo de entrada deve estar presente na pasta raiz
 */

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new XmlMapper();
            Calcado calcado = objectMapper.readValue(
                    StringUtils.toEncodedString(Files.readAllBytes(Paths.get("Calcados.xml")), StandardCharsets.UTF_8),
                    Calcado.class);
            System.out.println(calcado);
        } catch (NoClassDefFoundError e) {
            System.out.println("Erro durante execução: " + e);
        } catch (IOException e) {
            System.out.println("Erro durante execução: " + e);
        }
    }
}