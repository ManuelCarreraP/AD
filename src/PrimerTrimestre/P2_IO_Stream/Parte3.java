package PrimerTrimestre.P2_IO_Stream;

import java.io.*;
import java.util.Scanner;

public class Parte3 {

    public static void gravarTexto(String ficheiro, String texto) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficheiro))) {

            for (int i = 0; i < 3; i++) {
                dos.writeUTF(texto);
                System.out.println("Escribindo a cadea: " + texto);
                System.out.println("Tamaño do ficheiro: " + dos.size() + " bytes\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerTexto(String ficheiro) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(ficheiro))) {

            while (dis.available() > 0) {
                System.out.println("Quedan: " + dis.available() + " bytes por ler");
                String texto = dis.readUTF();
                System.out.println("Cadea: " + texto + " \n");
            }

            System.out.println("Xa non queda nada por ler");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String ficheiro = "/home/dam/Escritorio/AD/src/PrimerTrimestre/P2_IO_Stream/texto3.txt";

        System.out.println("Introduce a cadea de texto para grabala no ficheiro:");
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();

        gravarTexto(ficheiro, texto);
        lerTexto(ficheiro);
    }
}

