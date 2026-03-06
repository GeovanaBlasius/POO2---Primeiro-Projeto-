package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Estatistica;

import java.io.File;

public class PersistenciaService {

    public static void salvar(Estatistica estatistica) throws Exception {

        File pasta = new File("saida");

        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        ObjectMapper mapper = new ObjectMapper();

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("saida/estatistica-JSON.json"), estatistica);

        System.out.println("JSON salvo com sucesso!");
    }
}