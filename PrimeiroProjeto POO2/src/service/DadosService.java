package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DadosService {

    private String caminhoArquivo;

    public DadosService(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public List<Double> buscarDados() throws Exception {

        List<Double> dados = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(caminhoArquivo));

        String linha;

        while ((linha = reader.readLine()) != null) {

            String[] numeros = linha.trim().split("\\s+");

            for (String numero : numeros) {
                dados.add(Double.parseDouble(numero));
            }
        }

        reader.close();

        return dados;
    }
}