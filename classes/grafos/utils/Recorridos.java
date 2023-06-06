package classes.Grafos.utils;

import classes.ListaGenerica.utils.Cola;
import classes.ListaGenerica.ListaGenerica;
import classes.ListaGenerica.ListaGenericaEnlazada;
import classes.Grafos.Arista;
import classes.Grafos.Grafo;
import classes.Grafos.Vertice;

public class Recorridos<T> {
  public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo){
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
    for (int i = 0; i < marca.length; i++) {
      if (!marca[i]) {
        dfs(i, grafo, marca, lista);
      }
    }
    return lista;
  }
  private void dfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> lista){
    marca[i] = true;
    Vertice<T> v = grafo.listaDeVertices().elemento(i);
    lista.agregarFinal(v);
    ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);
    adyacentes.comenzar();
    while (!adyacentes.fin()) {
      int j = adyacentes.proximo().verticeDestino().posicion();
      if (!marca[j]) {
        dfs(j, grafo, marca, lista);
      }
    }
  }
  public ListaGenerica<Vertice<T>> bfs(Grafo<T> grafo){
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
    for (int i = 0; i < marca.length; i++) {
      if (!marca[i]) {
        bfs(i, grafo, marca, lista);
      }
    }
    return lista;
  }
  private void bfs(int i, Grafo<T> grafo, boolean[] marca, ListaGenerica<Vertice<T>> lista){
    Cola<Vertice<T>> cola = new Cola<Vertice<T>>();
    marca[i] = true;
    cola.encolar(grafo.listaDeVertices().elemento(i));
    while (!cola.esVacio()) {
      Vertice<T> v = cola.desencolar();
      lista.agregarFinal(v);
      ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);
      adyacentes.comenzar();
      while (!adyacentes.fin()) {
        int j = adyacentes.proximo().verticeDestino().posicion();
        if (!marca[j]) {
          marca[j] = true;
          cola.encolar(grafo.listaDeVertices().elemento(j));
        }
      }
    }
  }
}