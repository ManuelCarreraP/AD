package PrimerTrimestre.P4_SerializacionXML.Parte2;

import java.io.Serializable;

public class ProductoTransient implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private transient int num1; // Esto no se guardará al serializar
    private double num2;

    public ProductoTransient(String nome, int num1, double num2) {
        this.nome = nome;
        this.num1 = num1;
        this.num2 = num2;
    }


    @Override
    public String toString() {
        return "ProductoTransient{" +
                "nome='" + nome + '\'' +
                ", num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}
