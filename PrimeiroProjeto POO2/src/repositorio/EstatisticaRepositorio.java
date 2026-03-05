//package repositorio;
//
//import dto.Estatistica;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//public class EstatisticaRepositorio {
//
//    public static void salvar(Estatistica e) throws Exception {
//
//        Connection conn = DriverManager.getConnection("jdbc:sqlite:estatistica.db");
//
//        String sql = """
//        CREATE TABLE IF NOT EXISTS estatistica (
//        media REAL,
//        mediana REAL,
//        moda REAL,
//        variancia REAL,
//        desvio REAL
//        )
//        """;
//
//        conn.createStatement().execute(sql);
//
//        PreparedStatement stmt = conn.prepareStatement(
//                "INSERT INTO estatistica VALUES (?,?,?,?,?)");
//
//        stmt.setDouble(1, e.getMedia());
//        stmt.setDouble(2, e.getMediana());
//        stmt.setDouble(3, e.getModa());
//        stmt.setDouble(4, e.getVariancia());
//        stmt.setDouble(5, e.getDesvioPadrao());
//
//        stmt.execute();
//
//        conn.close();
//    }
//}