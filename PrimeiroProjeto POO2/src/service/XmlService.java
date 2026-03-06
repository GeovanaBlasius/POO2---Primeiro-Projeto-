package service;

import dto.Estatistica;
import java.io.File;
import java.io.FileWriter;

public class XmlService {

    public static void gerar(Estatistica e) throws Exception {

        File pasta = new File("saida");
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        FileWriter writer = new FileWriter("saida/estatistica-XML.xml");

        writer.write("<estatistica>\n");
        writer.write("  <media>" + e.getMedia() + "</media>\n");
        writer.write("  <mediana>" + e.getMediana() + "</mediana>\n");
        writer.write("  <moda>" + e.getModa() + "</moda>\n");
        writer.write("  <variancia>" + e.getVariancia() + "</variancia>\n");
        writer.write("  <desvioPadrao>" + e.getDesvioPadrao() + "</desvioPadrao>\n");
        writer.write("</estatistica>");

        writer.close();

        System.out.println("XML gerado com sucesso!");
    }
}