package PrimerTrimestre.SimulacroExamen;

import java.sql.*;
import java.util.*;
import java.io.*;

public class Vehiculo {

    private Conexion conexion;

    public Vehiculo() {
        this.conexion = new Conexion();
    }

    public void agregarVehiculo(String marca, String modelo, int ano, String descripcion) {
        String sql = "INSERT INTO Vehiculo (Marca, Modelo, Ano, Descripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, marca);
            ps.setString(2, modelo);
            ps.setInt(3, ano);
            ps.setString(4, descripcion);
            int filasAfectadas = ps.executeUpdate();
            System.out.println("Vehículo " + marca + " " + modelo + " agregado correctamente. Filas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error al agregar vehículo " + marca + " " + modelo + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> leerVehiculos() {
        List<Map<String, Object>> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vehiculo";
        try (Connection conn = conexion.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Map<String, Object> fila = new HashMap<>();
                fila.put("Id", rs.getInt("Id"));
                fila.put("Modelo", rs.getString("Modelo"));
                fila.put("Marca", rs.getString("Marca"));
                fila.put("Ano", rs.getInt("Ano"));
                fila.put("Descripcion", rs.getString("Descripcion"));
                lista.add(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void modificarVehiculo(int id, String modelo, String marca, Integer ano, String descripcion) {
        String sql = "UPDATE Vehiculo SET Modelo=?, Marca=?, Ano=?, Descripcion=? WHERE Id=?";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, modelo);
            ps.setString(2, marca);
            ps.setInt(3, ano);
            ps.setString(4, descripcion);
            ps.setInt(5, id);
            ps.executeUpdate();
            System.out.println("Vehículo modificado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarVehiculo(int id) {
        String sql = "DELETE FROM Vehiculo WHERE Id=?";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Vehículo eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // SERIALIZACIÓN
    public void serializarVehiculos(String fichero) {
        List<Map<String, Object>> vehiculos = leerVehiculos();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(vehiculos);
            System.out.println("Vehículos serializados en " + fichero);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void deserializarVehiculos(String fichero) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            List<Map<String, Object>> vehiculos = (List<Map<String, Object>>) ois.readObject();
            for (Map<String, Object> v : vehiculos) {
                agregarVehiculo(
                        (String) v.get("Modelo"),
                        (String) v.get("Marca"),
                        (Integer) v.get("Ano"),
                        (String) v.get("Descripcion")
                );
            }
            System.out.println("Vehículos deserializados desde " + fichero);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
