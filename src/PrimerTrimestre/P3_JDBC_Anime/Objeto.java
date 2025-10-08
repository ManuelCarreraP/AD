package PrimerTrimestre.P3_JDBC_Anime;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Objeto {
    // Metodo para insertar filas en la tabla anime
    public boolean insertar(Anime anime) {
        String sql = "insert into anime (nome, descripcion, data, puntuacion) values (?, ?, ?, ?)";
        try (Connection conn = Conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, anime.getNome());
            ps.setString(2, anime.getDescripcion());
            ps.setDate(3, anime.getData());
            ps.setInt(4, anime.getPuntuacion());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("No se pudo hacer la insercion: " + e.getMessage());
            return false;
        }
    }
    // Metodo para leer todas las filas de la tabla anime
    public List<Anime> leerTodos() {
        List<Anime> animes = new ArrayList<>();
        String sql = "select * from anime";
        try (Connection conn = Conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Anime a = new Anime();
                a.setNome(rs.getString("nome"));
                a.setDescripcion(rs.getString("descripcion"));
                a.setData(rs.getDate("data"));
                a.setPuntuacion(rs.getInt("puntuacion"));
                animes.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error a la hora de leer todos los animes: " + e.getMessage());
        }
        return animes;
    }
    // Metodo para leer de manera filtrada ( por el nombre del anime en este caso )
    public List<Anime> leerPorNombre(String nome) {
        List<Anime> animes = new ArrayList<>();
        String sql = "select * from anime where nome = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Anime a = new Anime();
                a.setNome(rs.getString("nome"));
                a.setDescripcion(rs.getString("descripcion"));
                a.setData(rs.getDate("data"));
                a.setPuntuacion(rs.getInt("puntuacion"));
                animes.add(a);
            }
        } catch (SQLException e) {
            System.out.println("No se encontro un anime con el nombre '"+ nome +"': " + e.getMessage());
        }
        return animes;
    }
    // Metodo para actualizar en la base de datos el anime introducido
    public boolean actualizar(Anime anime) {
        String sql = "update anime set descripcion = ?, data = ?, puntuacion = ? WHERE nome = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, anime.getDescripcion());
            ps.setDate(2, anime.getData());
            ps.setInt(3, anime.getPuntuacion());
            ps.setString(4, anime.getNome());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("No se pudo actualizar correctamente: " + e.getMessage());
            return false;
        }
    }
    // Metodo para borrar anime de la tabla mediante el nombre
    public boolean eliminar(String nome) {
        String sql = "delete from anime where nome = ?";
        try (Connection conn = Conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar correctamente: " + e.getMessage());
            return false;
        }
    }
}
