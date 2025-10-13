package PrimerTrimestre.P3_JDBC_Anime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    private static final String URL = "jdbc:postgresql://10.0.9.100:5432/postgresql";
    private static final String USUARIO = "postgres";
    private static final String PASS = "admin";
    public static Connection conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USUARIO, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("La conexión es estable: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("No se pudo establecer conexión: " + e.getMessage());
            return null;
        }
    }

}
