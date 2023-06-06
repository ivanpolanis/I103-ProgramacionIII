package Modulo1.practica3.a.ej3;

import classes.ListaDeEnteros.ListaDeEnterosEnlazada;

public class TestOrdenamiento {
  public static void main(String[] args) {
    ListaDeEnterosEnlazada l1 = new ListaDeEnterosEnlazada();
    l1.comenzar();
    l1.agregarFinal(1);
    l1.agregarFinal(3);
    l1.agregarFinal(5);
    l1.agregarFinal(7);
    l1.agregarFinal(9);
    l1.agregarFinal(11);
    ListaDeEnterosEnlazada l2 = new ListaDeEnterosEnlazada();
    l2.comenzar();
    l2.agregarFinal(2);
    l2.agregarFinal(4);
    l2.agregarFinal(6);
    l2.agregarFinal(8);
    l2.agregarFinal(10);

    System.out.println("La lista es: " + l1.toString());
    System.out.println("La lista es: " + l2.toString());
    ListaDeEnterosEnlazada combinadas = l1.combinarOrdenado(l2);

    System.out.println("La lista es: " + combinadas.toString());
  }  
}
