package utils;

import classes.ArbolBinario;
import classes.ListaGenericaEnlazada;

public class Adivinanza {
  public static ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> arbol) {
    //Si es hoja creamos una lista y la devolvemos.
    if (arbol.esHoja()) {
      ListaGenericaEnlazada<String> lista = new ListaGenericaEnlazada<>();
      lista.agregarInicio(arbol.getDato());
      return lista;
    }
    //Si no es hoja, creamos dos listas
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

    //Devolvemos la lista con mas elementos
    return listaIzq.tamanio() >= listaDer.tamanio() ? listaIzq : listaDer;

  }

  public static ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntas2(ArbolBinario<String> arbol) {
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> lista = new ListaGenericaEnlazada<>();

    if (arbol.esHoja()) {
      ListaGenericaEnlazada<String> aux = new ListaGenericaEnlazada<>();
      aux.agregarInicio(arbol.getDato());
      lista.agregarInicio(aux);
      return lista;
    }

    ListaGenericaEnlazada<String> listaIzq = new ListaGenericaEnlazada<>();
    ListaGenericaEnlazada<String> listaDer = new ListaGenericaEnlazada<>();

    if (arbol.tieneHijoIzquierdo()) {
      ListaGenericaEnlazada<ListaGenericaEnlazada<String>> caminosIzq = secuenciaConMasPreguntas2(
          arbol.getHijoIzquierdo());
      listaIzq = secuenciaConMasPreguntas2(arbol.getHijoIzquierdo()).elemento(0);
      listaIzq.agregarInicio(arbol.getDato());
    }
    if (arbol.tieneHijoDerecho()) {
      listaDer = secuenciaConMasPreguntas2(arbol.getHijoDerecho()).elemento(0);
      listaDer.agregarInicio(arbol.getDato());
    }

    System.out.println("IZQ: " + listaIzq.toString());
    System.out.println("DER: " + listaDer.toString());

    if (listaIzq.tamanio() == listaDer.tamanio()) {
      lista.agregarFinal(listaIzq);
      lista.agregarFinal(listaDer);
    } else if (listaIzq.tamanio() > listaDer.tamanio()) {
      lista.agregarFinal(listaIzq);
    } else {
      lista.agregarFinal(listaDer);
    }

    return lista;
  }
}
