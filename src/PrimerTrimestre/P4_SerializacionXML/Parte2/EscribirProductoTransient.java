package PrimerTrimestre.P4_SerializacionXML.Parte2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirProductoTransient {
    public static void main(String[] args) {
        ProductoTransient p1 = new ProductoTransient("Botas", 157, 7.35);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialTransient"))) {
            oos.writeObject(p1);
            System.out.println("Obxecto ProdutoTransient gardado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

