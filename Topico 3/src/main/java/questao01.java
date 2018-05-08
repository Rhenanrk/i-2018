import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class questao01 {
    private static final String VIRGULA = ",";

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Arq.csv")));
        String linha = null;

        System.out.println("<alunos>");

        while ((linha = reader.readLine()) != null) {
            
            if ((linha = reader.readLine()) == "NOME,EMAIL") {
                System.out.println("teste");
                continue; }

            else {
                String[] dadosUsuario = linha.split(VIRGULA);
                System.out.println("    <aluno>");
                System.out.println("        <nome>" + dadosUsuario[0]+ "</nome>");
                System.out.println("        <email>" + dadosUsuario[1] + "</email>");
                System.out.println("    </aluno>");
            }
        }

        System.out.println("</alunos>");
        reader.close();
    }
}

