package PrimerTrimestre.SimulacroExamen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Variables de conexión
    private final String url = "jdbc:postgresql://10.0.9.100:5432/postgresql";
    private final String usuario = "postgres";
    private final String contraseña = "admin";

    // Método para realizar la conexión
    public Connection conexion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión establecida correctamente!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar coa base de datos: " + e.getMessage());
        }
        return conn;
    }


    // Método main para probar a conexión
    public static void main(String[] args) {
        Conexion c = new Conexion();

        Connection conn = c.conexion();
        if (conn == null) {
            System.out.println("❌ Non se puido establecer conexión. Abortando operación.");
            return;
        }

    }
}
