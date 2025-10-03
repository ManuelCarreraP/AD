package PrimerTrimestre.P2_IO_Stream;

import java.io.*;

public class Parte2 {
    public static void main(String[] args) {

        String rutaDirectorio = "/home/dam/Escritorio/AD/src/PrimerTrimestre/P2_IO_Stream/";
        String nombreImagenOrigen = "foto.jpg";
        String nombreImagenDestino = "foto2.jpg";

        // Copiar byte a byte
        copiarImagen(rutaDirectorio, nombreImagenOrigen, nombreImagenDestino);


        // Añadir el contenido de foto.jpg a imagen2.jpg
        añadirImagen(rutaDirectorio, nombreImagenOrigen, nombreImagenDestino);

        // Copia la imagen con el Buffered para ganar velocidad
        copiarImagenBuffered(rutaDirectorio, nombreImagenOrigen, nombreImagenDestino);
    }

    // Método que copia byte a byte
    public static void copiarImagen(String rutaDirectorio, String nombreFicheroOrigen, String nombreFicheroDestino) {
        File origen = new File(rutaDirectorio, nombreFicheroOrigen);
        File destino = new File(rutaDirectorio, nombreFicheroDestino);

        // Comprobamos si existe el fichero origen
        if (!origen.exists()) {
            System.out.println("El fichero origen no existe.");
            return;
        }

        try (
                FileInputStream fis = new FileInputStream(origen);
                FileOutputStream fos = new FileOutputStream(destino)
        ) {
            int byteLeido;
            // Leemos un byte y lo escribimos en el fichero destino
            while ((byteLeido = fis.read()) != -1) {
                fos.write(byteLeido);
            }
            System.out.println("Copia realizada correctamente");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al copiar el fichero: " + e.getMessage());
        }
    }

    // Método que añade el contenido del fichero origen al fichero destino
    public static void añadirImagen(String rutaDirectorio, String nombreFicheroOrigen, String nombreFicheroDestino) {
        File origen = new File(rutaDirectorio, nombreFicheroOrigen);
        File destino = new File(rutaDirectorio, nombreFicheroDestino);

        if (!origen.exists()) {
            System.out.println("El fichero origen no existe.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(origen);
             FileOutputStream fos = new FileOutputStream(destino, true)) {

            int byteLeido;
            while ((byteLeido = fis.read()) != -1) {
                fos.write(byteLeido);
            }
            System.out.println("Contenido añadido correctamente");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al añadir el contenido: " + e.getMessage());
        }
    }

    //Metodo que copia la imagen con BufferedStream para aumentar la velocidad del proceso
    public static void copiarImagenBuffered(String rutaDirectorio, String nombreFicheroOrigen, String nombreFicheroDestino) {
        File origen = new File(rutaDirectorio, nombreFicheroOrigen);
        File destino = new File(rutaDirectorio, nombreFicheroDestino);

        if (!origen.exists()) {
            System.out.println("El fichero origen no existe.");
            return;
        }

        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(origen));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destino))
        ) {
            int byteLeido;
            while ((byteLeido = bis.read()) != -1) {
                bos.write(byteLeido);
            }
            System.out.println("Copia con BufferedStreams realizada correctamente");
        } catch (IOException e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}