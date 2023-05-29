package classes.grafos.utils;

import classes.grafos.Grafo;
import classes.grafos.Vertice;
import classes.grafos.Arista;
import classes.ListaGenerica;
import classes.ListaGenericaEnlazada;

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
}