package PrimerTrimestre.P4_SerializacionXML.Parte1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerProducto {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serial"))) {
            // Ler o obxecto do ficheiro e castealo á clase Producto
            Producto p2 = (Producto) ois.readObject();

            // Mostrar os datos recuperados
            System.out.println("Obxecto lido do ficheiro:");
            System.out.println(p2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

