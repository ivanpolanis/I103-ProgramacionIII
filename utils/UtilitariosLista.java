package utils;

import Clases.ListaDeEnterosEnlazada;

public class UtilitariosLista {
  public static ListaDeEnterosEnlazada mergeSort(ListaDeEnterosEnlazada lista) {
    if (lista.tamanio() <= 1) // Si la lista tiene un solo elemento, la devuelvo
      return lista;
    int middle = (lista.tamanio()) / 2;
    // Divido la lista en dos
    ListaDeEnterosEnlazada left = new ListaDeEnterosEnlazada();
    ListaDeEnterosEnlazada right = new ListaDeEnterosEnlazada();
    // Agrego los elementos a las listas
    for (int i = 0; i < middle; i++) {
      left.agregarFinal(lista.elemento(i));
    }
    for (int i = middle; i < lista.tamanio(); i++) {
      right.agregarFinal(lista.elemento(i));
    }
    // Ordeno las listas
    left = mergeSort(left);
    right = mergeSort(right);

    ListaDeEnterosEnlazada resultado = merge(left, right);
    return resultado;
  }

  private static ListaDeEnterosEnlazada merge(ListaDeEnterosEnlazada left, ListaDeEnterosEnlazada right) {
    ListaDeEnterosEnlazada resultado = new ListaDeEnterosEnlazada();
    while (!left.esVacia() && !right.esVacia()) {
      if (left.elemento(0) <= right.elemento(0)) {
        resultado.agregarFinal(left.elemento(0));
        left.eliminarEn(0);
      } else {
        resultado.agregarFinal(right.elemento(0));
        right.eliminarEn(0);
      }
    }
    while (!right.esVacia()) {
      resultado.agregarFinal(right.elemento(0));
      right.eliminarEn(0);
    }
    while (!left.esVacia()) {
      resultado.agregarFinal(left.elemento(0));
      left.eliminarEn(0);
    }
    return resultado;
  }
}
