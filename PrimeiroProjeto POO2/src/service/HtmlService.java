package service;

import dto.Estatistica;
import java.io.File;
import java.io.FileWriter;

public class HtmlService {

    public static void gerar(Estatistica estatistica) throws Exception {

        File pasta = new File("saida");
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        FileWriter writer = new FileWriter("saida/estatistica-HTML.html");

        writer.write("<html><head>");
        writer.write("<script src=\"https://www.gstatic.com/charts/loader.js\"></script>");
        writer.write("<script>");
        writer.write("google.charts.load('current', {'packages':['corechart']});");
        writer.write("google.charts.setOnLoadCallback(drawChart);");
        writer.write("function drawChart() {");
        writer.write("var data = google.visualization.arrayToDataTable([");
        writer.write("['Medida','Valor'],");
        writer.write("['Média'," + estatistica.getMedia() + "],");
        writer.write("['Mediana'," + estatistica.getMediana() + "],");
        writer.write("['Moda'," + estatistica.getModa() + "],");
        writer.write("['Variância'," + estatistica.getVariancia() + "],");
        writer.write("['Desvio Padrão'," + estatistica.getDesvioPadrao() + "]");
        writer.write("]);");
        writer.write("var chart = new google.visualization.ColumnChart(document.getElementById('chart'));");
        writer.write("chart.draw(data);");
        writer.write("}");
        writer.write("</script></head>");
        writer.write("<body>");
        writer.write("<h1>Resultado Estatístico</h1>");
        writer.write("<div id='chart' style='width:900px;height:500px'></div>");
        writer.write("</body></html>");

        writer.close();

        System.out.println("HTML gerado com sucesso!");
    }
}