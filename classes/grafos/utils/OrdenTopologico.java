package classes.Grafos.utils;

import classes.ListaGenerica.ListaGenerica;
import classes.ListaGenerica.ListaGenericaEnlazada;
import classes.Grafos.Arista;
import classes.Grafos.Grafo;
import classes.Grafos.Vertice;
import classes.ListaGenerica.utils.Pila;

public class OrdenTopologico {
  public static ListaGenerica<Vertice<String>> ordenTopologico(Grafo<String> grafo) {
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    Pila<Vertice<String>> pila = new Pila<>();
    ListaGenerica<Vertice<String>> l = new ListaGenericaEnlazada<>();
    for (int i = 0; i < marca.length; i++) {
      if (!marca[i]) {
        ordenTopologico(grafo, marca, grafo.listaDeVertices().elemento(i), pila);
      }
    }
    while (!pila.esVacia()) {
      l.agregarFinal(pila.desapilar());
    }
    return l;
  }

  private static void ordenTopologico(Grafo<String> grafo, boolean[] marca, Vertice<String> v, Pila<Vertice<String>> pila) {
    marca[v.posicion()] = true;
    ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      Vertice<String> actual = ady.proximo().verticeDestino();
      int j = actual.posicion();
      if (!marca[j]) {
        ordenTopologico(grafo, marca, actual, pila);
      }
    }
    pila.apilar(v);
  }
}
