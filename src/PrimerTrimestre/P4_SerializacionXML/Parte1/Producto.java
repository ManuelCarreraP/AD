package PrimerTrimestre.P4_SerializacionXML.Parte1;

import java.io.Serializable;

public class Producto implements Serializable {

    private String nome;
    private int num1;
    private double num2;

    // Constructor
    public Producto(String nome, int num1, double num2) {
        this.nome = nome;
        this.num1 = num1;
        this.num2 = num2;
    }


    // Método para mostrar información
    @Override
    public String toString() {
        return "Producto{" +
                "nome='" + nome + '\'' +
                ", num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }
}
