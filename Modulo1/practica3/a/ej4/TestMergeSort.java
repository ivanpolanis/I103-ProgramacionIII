package Modulo1.practica3.a.ej4;

import classes.ListaDeEnteros.ListaDeEnterosEnlazada;
import classes.ListaDeEnteros.utils.UtilitariosLista;

public class TestMergeSort {
  public static void main(String[] args) {
    ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
    lista.agregarFinal(5);
    lista.agregarFinal(1);
    lista.agregarFinal(4);
    lista.agregarFinal(2);
    lista.agregarFinal(3);
    lista.agregarFinal(0);
    lista.comenzar();
    System.out.println("Lista desordenada: " + lista.toString());
    lista = UtilitariosLista.mergeSort(lista);
    lista.comenzar();
    System.out.println("Lista ordenada: " + lista.toString());
  }

}
