package Modulo1.practica3.a.ej2;

import classes.ListaDeEnteros.ListaDeEnterosEnlazada;

public class Test {
  public static void main(String[] args) {
    ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
    lista.comenzar();
    lista.agregarInicio(6);
    lista.agregarInicio(8);
    lista.agregarInicio(2);
    lista.agregarInicio(1);
    lista.agregarInicio(9);
    lista.agregarInicio(7);


    System.out.println("La lista es: " + lista.toString());
    ListaDeEnterosEnlazada ordenada = lista.ordenar();
    System.out.println("La lista es: " + ordenada.toString());

   } 
}
