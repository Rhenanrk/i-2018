/*
 * Copyright (c) 2018.
 * Rhenan Konrad
 * Creative Commons Attribution 4.0 International License.
 */

package com.github.rhenanrk.es.integracao.questao07;import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Classe responsável por obter o JSON de um usuário do Github, armazenar esse JSON na pasta raiz
 * e realizar o download do avatar do usuário a partir do link obtido no JSON
 *
 * Código referente à questão número 7 da lista de exercícios de JSON
 */
public class Main {

    /**
     * Método principal do programa
     * @param args
     */
    public static void main(String[] args){

        Scanner leitor = new Scanner(System.in);
        System.out.print("Informe o nome do usuário no GitHub para qual deseja obter o JSON e o avatar: ");
        String usuario = leitor.next();

        obtemJson(usuario);  // obtem JSON com dados

        String avatar_url = obtemUrlAvatar();  // obtem url do avatar

        obtemAvatar(avatar_url);  // obtem avatar
    }

    /**
     * Obtem arquivo JSON utilizando HttpUrlConnection
     * @param usuario - nome do usuário do GitHub para qual serão obtidos os dados
     */
    private static void obtemJson(String usuario) {
        try {
            URL url = new URL("https://api.github.com/users/" + usuario);
            URLConnection connection = url.openConnection();
            InputStream in = connection.getInputStream();
            FileOutputStream fos = new FileOutputStream(new File("idGit.json"));
            byte[] buf = new byte[512];
            while (true) {
                int len = in.read(buf);
                if (len == -1) {
                    break;
                }
                fos.write(buf, 0, len);
            }
            in.close();
            fos.flush();
            fos.close();
        }catch (IOException e) {
            System.out.println("Problema na obtenção do arquivo: " + e);
        }
    }

    /**
     * Faz o parser e obtem o URL do avatar
     */
    private static String obtemUrlAvatar() {
        JSONObject jsonObject; //Cria o parse de tratamento
        JSONParser parser = new JSONParser(); //Variaveis que irao armazenar os dados do arquivo JSON
        String avatar_url = "", nomeUser;

        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader("idGit.json"));

            //Salva nas variaveis os dados retirados do arquivo
            avatar_url = (String) jsonObject.get("avatar_url");
            nomeUser = (String) jsonObject.get("name");

            System.out.printf("Nome do usuário: %s\n", nomeUser);
            System.out.println("Dados obtidos com sucesso!\n");
        } //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            System.out.println("Problema ao procurar arquivo: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("Problema na conversão do arquivo: " + e);
        }
        return avatar_url;
    }

    /**
     * Obtem o arquivo de imagem a partir da URL do avatar
     * @param avatar_url - URL do avatar
     */
    private static void obtemAvatar(String avatar_url) {
        URL url;
        URLConnection connection;
        InputStream in;
        FileOutputStream fos;
        byte[] buf;
        try {
            url = new URL(avatar_url);
            connection = url.openConnection();
            in = connection.getInputStream();
            fos = new FileOutputStream(new File("idGit.jpeg"));
            buf = new byte[512];

            while (true) {
                int len = in.read(buf);
                if (len == -1) {
                    break;
                }
                fos.write(buf, 0, len);
            }

            in.close();
            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("Problema na obtenção da imagem: " + e);
        }
    }
}
