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
}
