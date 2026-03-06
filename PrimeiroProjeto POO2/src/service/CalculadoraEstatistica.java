package service;

import dto.Estatistica;
import java.util.*;

public class CalculadoraEstatistica {

    public Estatistica calcular(List<Double> lista) {

        if (lista == null || lista.isEmpty()) {
            throw new RuntimeException("Lista vazia.");
        }

        double media = calcularMedia(lista);
        double mediana = calcularMediana(lista);
        double variancia = calcularVariancia(lista, media);
        double desvioPadrao = Math.sqrt(variancia);
        double moda = calcularModa(lista);

        return new Estatistica(media, mediana, variancia, desvioPadrao, moda);
    }

    private double calcularMedia(List<Double> lista) {
        return lista.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    private double calcularMediana(List<Double> lista) {

        List<Double> copia = new ArrayList<>(lista);
        Collections.sort(copia);

        int tamanho = copia.size();
        int meio = tamanho / 2;

        if (tamanho % 2 == 0) {
            return (copia.get(meio - 1) + copia.get(meio)) / 2.0;
        } else {
            return copia.get(meio);
        }
    }

    private double calcularVariancia(List<Double> lista, double media) {

        double soma = 0;

        for (Double num : lista) {
            soma += Math.pow(num - media, 2);
        }

        return soma / lista.size();
    }

    private double calcularModa(List<Double> lista) {

        Map<Double, Integer> frequencia = new HashMap<>();

        for (Double num : lista) {
            frequencia.put(num, frequencia.getOrDefault(num, 0) + 1);
        }

        return Collections.max(frequencia.entrySet(),
                Map.Entry.comparingByValue()).getKey();
    }
}