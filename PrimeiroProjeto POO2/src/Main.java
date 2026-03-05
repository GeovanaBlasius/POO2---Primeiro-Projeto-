import dto.Estatistica;
import service.CalculadoraEstatistica;
import service.ControleGeracaoService;
import service.DadosService;
import service.HtmlService;
import service.PersistenciaService;
import service.XmlService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            String arquivoEntrada = "dados_10000.txt";
            String arquivoSaida = "saida/estatistica.json";

            if (!ControleGeracaoService.precisaGerar(arquivoEntrada, arquivoSaida)) {
                System.out.println("Processo cancelado pelo usuário.");
                return;
            }

            DadosService dadosService = new DadosService(arquivoEntrada);
            CalculadoraEstatistica calculadora = new CalculadoraEstatistica();
            PersistenciaService persistencia = new PersistenciaService();
            XmlService xmlService = new XmlService();
            HtmlService htmlService = new HtmlService();

            List<Double> dados = dadosService.buscarDados();

            Estatistica estatistica = calculadora.calcular(dados);

            persistencia.salvar(estatistica);
            xmlService.gerar(estatistica);
            htmlService.gerar(estatistica);

            System.out.println("Processo concluído com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}