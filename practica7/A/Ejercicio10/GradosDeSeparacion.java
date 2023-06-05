package practica7.A.Ejercicio10;

import classes.ListaGenerica;

import classes.grafos.Grafo;
import classes.grafos.Vertice;
import classes.grafos.Arista;

import java.util.Arrays;

import classes.Cola;

public class GradosDeSeparacion<T> {
  public int maximoGradoDeSeparacion(Grafo<T> grafo) {
    int len = grafo.listaDeVertices().tamanio();
    int max = -1, aux;
    for (int i = 0; i < len; i++) {
      aux = maximoGradoDeSeparacion(i, grafo);
      if (aux > max) {
        max = aux;
      }
    }
    return max;
  }

  private int maximoGradoDeSeparacion(int i, Grafo<T> grafo) {
    Cola<Vertice<T>> cola = new Cola<Vertice<T>>();
    Vertice<T> v = grafo.listaDeVertices().elemento(i);
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    int[] distancia = new int[grafo.listaDeVertices().tamanio()];
    marca[i] = true;
    cola.encolar(v);
    while (!cola.esVacio()) {
      Vertice<T> aux = cola.desencolar();
      ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(aux);
      ady.comenzar();
      while (!ady.fin()) {
        Arista<T> a = ady.proximo();
        int j = a.verticeDestino().posicion();
        if (!marca[j]) {
          marca[j] = true;
          cola.encolar(a.verticeDestino());
          distancia[a.verticeDestino().posicion()] = distancia[aux.posicion()] + 1;
        }
      }
    }
    return Arrays.stream(distancia).max().getAsInt();
  }
}
