package service;

import java.io.File;

public class ControleArquivo {

    public static void verificar(String caminho) {

        File arquivo = new File(caminho);

        if (!arquivo.exists()) {
            throw new RuntimeException("Arquivo não encontrado: " + caminho);
        }

        System.out.println("Arquivo encontrado com sucesso!");
    }
}