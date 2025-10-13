package PrimerTrimestre.SimulacroExamen;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        Vehiculo vehiculo = new Vehiculo();
        Inventario inventario = new Inventario();

        // 1. Insertar vehículos (marca, modelo, año, descripción)
        System.out.println("Insertando vehículos...");
        vehiculo.agregarVehiculo("Ford", "Mustang", 2021, "Deportivos americanos icónicos.");
        vehiculo.agregarVehiculo("Tesla", "Model S", 2023, "Sedán eléctrico de luxo con gran autonomía.");
        vehiculo.agregarVehiculo("Honda", "Civic", 2020, "Compacto de gran fiabilidade.");
        vehiculo.agregarVehiculo("Chevrolet", "Corvette", 2022, "Deportivo americano con motor V8.");
        vehiculo.agregarVehiculo("Toyota", "Prius", 2022, "Híbrido de baixo consumo e ecolóxico.");

        // 2. Consultar IDs y crear mapa
        List<Map<String, Object>> vehiculos = vehiculo.leerVehiculos();
        Map<String, Integer> idMap = new HashMap<>();

        System.out.println("\nIDs dos vehículos:");
        for (Map<String, Object> v : vehiculos) {
            int id = (Integer) v.get("Id");
            String marca = (String) v.get("Marca");
            String modelo = (String) v.get("Modelo");

            // Crear clave sin espacios y mostrarla para debug
            String clave = marca + modelo;
            clave = clave.replace(" ", ""); // Eliminar espacios por si acaso

            System.out.println("ID " + id + " -> " + marca + " " + modelo + " [Clave: " + clave + "]");

            idMap.put(clave, id);
        }

        // 3. Verificar que las claves existen antes de usarlas
        System.out.println("\nVerificando claves en el mapa:");
        for (String clave : idMap.keySet()) {
            System.out.println("Clave disponible: '" + clave + "' -> ID: " + idMap.get(clave));
        }

        // 4. Insertar en InventarioTenda con verificación
        System.out.println("\nInsertando en inventario...");

        // Lista de vehículos a insertar en inventario
        String[] vehiculosInventario = {
                "FordMustang", "TeslaModelS", "HondaCivic", "ChevroletCorvette", "ToyotaPrius"
        };

        for (String vehiculoClave : vehiculosInventario) {
            Integer id = idMap.get(vehiculoClave);
            if (id != null) {
                switch (vehiculoClave) {
                    case "FordMustang":
                        inventario.agregarInventario(id, 25000.00, 30000.00, 10);
                        break;
                    case "TeslaModelS":
                        inventario.agregarInventario(id, 40000.00, 50000.00, 12);
                        break;
                    case "HondaCivic":
                        inventario.agregarInventario(id, 18000.00, 22000.00, 5);
                        break;
                    case "ChevroletCorvette":
                        inventario.agregarInventario(id, 60000.00, 70000.00, 8);
                        break;
                    case "ToyotaPrius":
                        inventario.agregarInventario(id, 25000.00, 30000.00, 6);
                        break;
                }
            } else {
                System.out.println("ERROR: No se encontró ID para " + vehiculoClave);
            }
        }

        // 5. Exportar Vehiculo a fichero serializado
        String ficheroSerializado = "vehiculos.ser";
        vehiculo.serializarVehiculos(ficheroSerializado);

        // 6. Mensaje
        System.out.println("\n===== OFERTAS COCHES =====\n");

        // 7. Modificar porcentaje de oferta
        inventario.aumentarPorcentajeOferta(15);

        // 8. Precio actual de Ford Mustang con verificación
        Integer fordId = idMap.get("FordMustang");
        if (fordId != null) {
            double precioActual = inventario.obtenerPrecioVentaConOferta(fordId);
            System.out.println("Precio actual de venta Ford Mustang con oferta: " + precioActual);
        } else {
            System.out.println("ERROR: No se encontró el ID para Ford Mustang");
        }

        // 9. Leer vehículo del fichero serializado
        List<Map<String, Object>> vehiculosDesdeFichero = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroSerializado))) {
            vehiculosDesdeFichero = (List<Map<String, Object>>) ois.readObject();
            System.out.println("Vehículos leídos desde el fichero serializado.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 10. Escribir en un fichero de texto
        if (vehiculosDesdeFichero != null) {
            try (PrintWriter pw = new PrintWriter(new FileWriter("vehiculos.txt"))) {
                for (Map<String, Object> v : vehiculosDesdeFichero) {
                    pw.println("ID: " + v.get("Id"));
                    pw.println("Marca: " + v.get("Marca"));
                    pw.println("Modelo: " + v.get("Modelo"));
                    pw.println("Ano: " + v.get("Ano"));
                    pw.println("Descripcion: " + v.get("Descripcion"));
                    pw.println("------------------------");
                }
                System.out.println("Vehículos escritos en vehiculos.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nPrograma ejecutado correctamente.");
    }
}

