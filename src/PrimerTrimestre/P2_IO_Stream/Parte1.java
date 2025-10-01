package PrimerTrimestre.P2_IO_Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Parte1 {

    // Método para copiar byte a byte
    public static void copiarFicheiro(String orixe, String destino) {
        try (FileInputStream fis = new FileInputStream(orixe);
             FileOutputStream fos = new FileOutputStream(destino)) {

            int byteLido;
            while ((byteLido = fis.read()) != -1) {
                fos.write(byteLido);
            }
            System.out.println("Ficheiro copiado de " + orixe + " a " + destino);

        } catch (IOException e) {
            System.err.println("Erro ao copiar o ficheiro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para engadir contido ao ficheiro
    public static void engadirFicheiro(String orixe, String destino) {
        try (FileInputStream fis = new FileInputStream(orixe);
             FileOutputStream fos = new FileOutputStream(destino, true)) { // modo append activado

            int byteLido;
            while ((byteLido = fis.read()) != -1) {
                fos.write(byteLido);
            }
            System.out.println("Contido engadido de " + orixe + " a " + destino);

        } catch (IOException e) {
            System.err.println("Erro ao engadir contido: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String rutaBase = "/home/dam/Escritorio/AD/src/PrimerTrimestre/P2_IO_Stream/";
        String texto1 = rutaBase + "texto1.txt";
        String texto2 = rutaBase + "texto2.txt";

        copiarFicheiro(texto1, texto2);
        engadirFicheiro(texto1, texto2);
    }
}
