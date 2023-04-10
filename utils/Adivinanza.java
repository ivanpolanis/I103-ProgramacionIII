package utils;

import classes.ArbolBinario;
import classes.ListaGenericaEnlazada;

public class Adivinanza {
  public static ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> arbol) {
    // Si es hoja creamos una lista y la devolvemos.
    if (arbol.esHoja()) {
      ListaGenericaEnlazada<String> lista = new ListaGenericaEnlazada<>();
      lista.agregarInicio(arbol.getDato());
      return lista;
    }
    // Si no es hoja, creamos dos listas
    ListaGenericaEnlazada<String> listaIzq = new ListaGenericaEnlazada<>();
    ListaGenericaEnlazada<String> listaDer = new ListaGenericaEnlazada<>();

    if (arbol.tieneHijoIzquierdo()) {
      listaIzq = secuenciaConMasPreguntas(arbol.getHijoIzquierdo());
      listaIzq.agregarInicio(arbol.getDato());
    }
    if (arbol.tieneHijoDerecho()) {
      listaDer = secuenciaConMasPreguntas(arbol.getHijoDerecho());
      listaDer.agregarInicio(arbol.getDato());
    }

    // Devolvemos la lista con mas elementos
    return listaIzq.tamanio() >= listaDer.tamanio() ? listaIzq : listaDer;

  }

  public static ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntas2(
      ArbolBinario<String> arbol) {
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> lista = new ListaGenericaEnlazada<>();
    if (arbol.esHoja()) {
      ListaGenericaEnlazada<String> aux = new ListaGenericaEnlazada<>();
      aux.agregarInicio(arbol.getDato());
      lista.agregarInicio(aux);
      System.out.println(arbol.getDato());
      return lista;
    }
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> listaIzq = new ListaGenericaEnlazada<>();
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> listaDer = new ListaGenericaEnlazada<>();

    if (arbol.tieneHijoIzquierdo()) {
      listaIzq = secuenciaConMasPreguntas2(arbol.getHijoIzquierdo());
      int i = 0;
      while (i < listaIzq.tamanio()) {
        listaIzq.elemento(i).agregarInicio(arbol.getDato());
        i++;
      }
    }

    if (arbol.tieneHijoDerecho()) {
      listaDer = secuenciaConMasPreguntas2(arbol.getHijoDerecho());
      int i = 0;
      while (i < listaDer.tamanio()) {
        listaDer.elemento(i).agregarInicio(arbol.getDato());
        i++;
      }
    }
    if (listaIzq.elemento(0) != null && listaDer.elemento(0) != null
        && listaIzq.elemento(0).tamanio() > listaDer.elemento(0).tamanio()) {
      return listaIzq;
    }
    if (listaDer.elemento(0) != null && listaIzq.elemento(0) != null
        && listaDer.elemento(0).tamanio() > listaIzq.elemento(0).tamanio()) {
      return listaDer;
    }
    for (int i = 0; i < listaIzq.tamanio(); i++) {
      lista.agregarFinal(listaIzq.elemento(i));
    }
    for (int i = 0; i < listaDer.tamanio(); i++) {
      lista.agregarFinal(listaDer.elemento(i));
    }

    return lista;
  }

}