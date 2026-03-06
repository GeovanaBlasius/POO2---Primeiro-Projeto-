//package service;
//
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WebServiceIBGE {
//
//    public static List<Double> buscarPopulacao() throws Exception {
//
//        String url = "https://servicodados.ibge.gov.br/api/v3/agregados/6579/periodos/2022/variaveis/9324?localidades=N6[all]";
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .build();
//
//        HttpResponse<String> response =
//                client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        String json = response.body();
//
//        List<Double> lista = new ArrayList<>();
//
//        String[] partes = json.split("\"V\":\"");
//
//        for (int i = 1; i < partes.length; i++) {
//            String valor = partes[i].split("\"")[0];
//
//            if (!valor.equals("...")) {
//                lista.add(Double.parseDouble(valor));
//            }
//        }
//
//        return lista;
//    }
//}