package PrimerTrimestre.P4_SerializacionXML.Parte1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirProducto {
    public static void main(String[] args) {
        // Crear un obxecto de tipo Producto
        Producto p1 = new Producto("Balón", 7, 3.33);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serial"))) {
            // Gardar o obxecto no ficheiro
            oos.writeObject(p1);
            System.out.println("Obxecto gardado correctamente no ficheiro 'serial'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

