package PrimerTrimestre.P3_JDBC_Anime;

import java.sql.Date;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Objeto dao = new Objeto();
        // Proceso para insertar un nuevo anime
        System.out.println("1. Insertamos nuevo anime");
        Anime nuevo = new Anime(
                "Blue Lock",
                "Futbol sub-20 japonesa",
                Date.valueOf("2024-03-27"),
                93
        );
        if (dao.insertar(nuevo)) {
            System.out.println("Anime insertado.");
        } else {
            System.out.println("Error al insertar.");
        }
        // Leer todo el contenido de la tabla
        System.out.println("\n2 . Leyendo los animes:");
        List<Anime> todos = dao.leerTodos();
        for (Anime a : todos) {
            System.out.println(a);
        }
        // Actualizar el registro de la tabla tras haber insertado un nuevo anime
        System.out.println("\n 3. Actualizando tabla");
        nuevo.setPuntuacion(96);
        nuevo.setDescripcion("Basurero Asqueroso.");
        if (dao.actualizar(nuevo)) {
            System.out.println("Actualizaste correctamente.");
        } else {
            System.out.println("Error actualizando.");
        }
        // Leer dato actualizado post introducido
        System.out.println("\n 4. Leyendo el anime actualizado:");
        List<Anime> actualizado = dao.leerPorNombre("Blue Lock");
        if (!actualizado.isEmpty()) {
            System.out.println(actualizado.get(0));
        } else {
            System.out.println("No se encontró el anime actualizado");
        }
        // Eliminar el anime recientemente introducido
        System.out.println("\n 5. Eliminando anime");
        if (dao.eliminar("Blue Lock")) {
            System.out.println(" Anime eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
        // Volver a leer todos los registros tras eliminar el anime introducido
        System.out.println("\n 6. Leyendo nuevamente todos los animes tras la eliminación:");
        List<Anime> finales = dao.leerTodos();
        for (Anime a : finales) {
            System.out.println(a);
        }
    }
}