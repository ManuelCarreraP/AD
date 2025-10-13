package PrimerTrimestre.P4_SerializacionXML.Parte2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerProductoTransient {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialTransient"))) {
            ProductoTransient p2 = (ProductoTransient) ois.readObject();

            System.out.println("Obxecto ProdutoTransient lido do ficheiro:");
            System.out.println(p2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
