package org.example;

import org.example.Pilas.PilaLineal;
import org.example.Pilas.TransformadorDePalabra;

import java.util.Scanner;

public class Main {

    public static void palindromo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una palabra para verificar si es un palíndromo: ");
        String palabra = scanner.nextLine();
        String palabraTransformada = TransformadorDePalabra.transformar(palabra);
        String palabraInvertida = "";

        PilaLineal pila = new PilaLineal();

        for (int i = 0; i < palabraTransformada.length(); i++){
            try {
                pila.insertar(palabraTransformada.charAt(i));
            } catch (Exception ex){
                System.out.println("Problema al insertar: " + ex.getMessage());
            }
        }

        while (!pila.pilaVacia()){
            try {
                palabraInvertida += pila.quitar();
            } catch (Exception ex){
                System.out.println("Error comprobando!");
            }
        }

        if (palabraTransformada.equals(TransformadorDePalabra.transformar(palabraInvertida))) {
            System.out.println("La palabra '" + palabra + "' es un palíndromo.");
        } else {
            System.out.println("La palabra '" + palabra + "' no es un palíndromo.");
        }
    }

    public static void main(String[] args) {
        palindromo();
    }
}
