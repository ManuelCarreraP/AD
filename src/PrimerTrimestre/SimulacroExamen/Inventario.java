package PrimerTrimestre.SimulacroExamen;

import java.sql.*;

public class Inventario {

    private Conexion conexion;

    public Inventario() {
        this.conexion = new Conexion();
    }

    public void agregarInventario(int idVehiculo, double precioMayorista, double precioVenta, int porcentajeOferta) {
        String sql = "INSERT INTO InventarioTenda (IdVehiculo, PrezoMayorista, PrezoVenta, PorcentaxeOferta) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVehiculo);
            ps.setDouble(2, precioMayorista);
            ps.setDouble(3, precioVenta);
            ps.setInt(4, porcentajeOferta);
            ps.executeUpdate();
            System.out.println("Inventario agregado para vehículo ID " + idVehiculo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void aumentarPorcentajeOferta(int incremento) {
        String sql = "UPDATE InventarioTenda SET PorcentaxeOferta = PorcentaxeOferta + ?";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, incremento);
            ps.executeUpdate();
            System.out.println("Se sumaron " + incremento + "% a todas las ofertas.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double obtenerPrecioVentaConOferta(int idVehiculo) {
        String sql = "SELECT PrezoVenta, PorcentaxeOferta FROM InventarioTenda WHERE IdVehiculo=?";
        try (Connection conn = conexion.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVehiculo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double precio = rs.getDouble("PrezoVenta");
                int porcentaje = rs.getInt("PorcentaxeOferta");
                return precio * (1 - porcentaje / 100.0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
