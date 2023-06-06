package Modulo1.practica3.a.ej1;

import java.util.Scanner;

import classes.ListaDeEnteros.ListaDeEnterosEnlazada;

public class ListaDeEnterosEnlazadaTestBasico {
  public static void main(String[] args) {
    ListaDeEnterosEnlazada listaEnlazada = new ListaDeEnterosEnlazada();
    listaEnlazada.comenzar();
    Scanner scanner = new Scanner(System.in);
    int n = -1;
    while (n != 0) {
      System.out.print("Ingrese un numero(0 para finalizar): ");
      n = scanner.nextInt();
      if (n != 0) {
        listaEnlazada.agregarInicio(n);
      }
    }
    scanner.close();
    System.out.println("La lista es: " + listaEnlazada.toString());
    imprimirRecursivo(listaEnlazada, listaEnlazada.tamanio() - 1);
  }

  public static void imprimirRecursivo(ListaDeEnterosEnlazada lista, int i) {
    System.out.println(lista.elemento(i));
    if (i != 0) {
      imprimirRecursivo(lista, i - 1);
    }
  }
}
