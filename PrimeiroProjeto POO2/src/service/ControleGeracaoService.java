package service;

import java.io.File;
import java.util.Scanner;

public class ControleGeracaoService {

    public static boolean precisaGerar(String arquivoEntrada, String arquivoSaida) {

        File entrada = new File(arquivoEntrada);
        File saida = new File(arquivoSaida);

        if (!saida.exists()) {
            return true;
        }

        long modEntrada = entrada.lastModified();
        long modSaida = saida.lastModified();

        if (modSaida >= modEntrada) {

            System.out.println("Os dados já foram processados anteriormente.");
            System.out.print("Deseja gerar novamente? (s/n): ");

            Scanner scanner = new Scanner(System.in);
            String resposta = scanner.nextLine();

            return resposta.equalsIgnoreCase("s");
        }

        return true;
    }
}
