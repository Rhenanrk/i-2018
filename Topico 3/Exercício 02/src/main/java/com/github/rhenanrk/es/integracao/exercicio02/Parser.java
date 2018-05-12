package com.github.rhenanrk.es.integracao.exercicio02;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Parser {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new XmlMapper();
        Sapataria sapataria = objectMapper.readValue(
                StringUtils.toEncodedString(Files.readAllBytes(Paths.get("Sapataria.xml")), StandardCharsets.UTF_8),
                Sapataria.class);
        System.out.println(sapataria);
    }
}