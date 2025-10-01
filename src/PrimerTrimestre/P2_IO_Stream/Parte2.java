package PrimerTrimestre.P2_IO_Stream;

import java.io.*;

public class Parte2 {

    public static void copiarConBuffer(String origen, String destino) {
        byte[] buffer = new byte[8192];
        int bytesLeidos;

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(origen));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destino))) {

            while ((bytesLeidos = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesLeidos);
            }

            System.out.println("Imagen copiada de " + origen + " a " + destino);

        } catch (IOException e) {
            System.err.println("Error copiando el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String rutaBase = "/home/dam/Escritorio/AD/src/PrimerTrimestre/P2_IO_Stream/";
        String foto1 = rutaBase + "foto.jpg";
        String foto2 = rutaBase + "foto2.jpg";

        long inicio = System.currentTimeMillis();
        copiarConBuffer(foto1, foto2);
        long fin = System.currentTimeMillis();

        System.out.println("Tiempo de copia: " + (fin - inicio) + " ms");

        File archivo1 = new File(foto1);
        File archivo2 = new File(foto2);
        System.out.println("Tamaño de foto.jpg: " + archivo1.length() + " bytes");
        System.out.println("Tamaño de foto2.jpg: " + archivo2.length() + " bytes");
        System.out.println("¿Archivos iguales en tamaño? " + (archivo1.length() == archivo2.length()));
    }
}
