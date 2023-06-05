package classes.grafos.utils;

import classes.grafos.Grafo;
import classes.ListaGenerica;
import classes.grafos.Arista;
import classes.grafos.Vertice;
import java.util.PriorityQueue;

public class Dijkstra<T> {

  // --------------------- LIST VERSION --------------------------

  public Costo[] dijkstraSinHeap(Grafo<T> grafo, Vertice<T> v) {
    Costo[] arr = new Costo[grafo.listaDeVertices().tamanio()];
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new Costo();
      if (v.posicion() == i) {
        arr[i].setPrev(0);
        arr[i].setW(0);
      } else {
        arr[i].setW(Integer.MAX_VALUE);
      }
    }
    for (int i = 0; i < arr.length; i++) {
      Vertice<T> u = grafo.listaDeVertices().elemento(extractMin(arr, marca));
      int camino = arr[u.posicion()].getW();
      marca[u.posicion()] = true;
      ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(u);
      ady.comenzar();
      while (!ady.fin()) {
        Arista<T> arista = ady.proximo();
        int peso = arista.peso();
        int j = arista.verticeDestino().posicion();
        if (!marca[j]) {
          if (camino + peso < arr[j].getW()) {
            arr[j].setW(camino + peso);
            arr[j].setPrev(u.posicion());
          }
        }
      }
    }

    return arr;
  }

  // --------------------- HEAP VERSION --------------------------

  public Costo[] dijkstraConHeap(Grafo<T> grafo, Vertice<T> v) {
    int lenght = grafo.listaDeVertices().tamanio();
    Costo[] costos = new Costo[lenght];
    if ((!grafo.listaDeVertices().incluye(v)))
      return null;
    boolean[] marca = new boolean[lenght];
    PriorityQueue<Costo> heap = new PriorityQueue<>();

    for (int i = 0; i < lenght; i++) {
      costos[i] = new Costo();
    }

    costos[v.posicion()].setW(0);
    heap.offer(new Costo(0, v.posicion()));

    while (!heap.isEmpty()) {
      Vertice<T> U = grafo.listaDeVertices().elemento(heap.poll().getPrev());
      if (marca[U.posicion()])
        continue;
      marca[U.posicion()] = true;
      ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(U);
      ady.comenzar();
      while (!ady.fin()) {
        Arista<T> A = ady.proximo();
        Vertice<T> W = A.verticeDestino();
        if ((!marca[W.posicion()])
            && (costos[W.posicion()].getW() > costos[U.posicion()].getW() + A.peso())) {
          costos[W.posicion()].setW(costos[U.posicion()].getW() + A.peso());
          costos[W.posicion()].setPrev(U.posicion());
          heap.offer(new Costo(costos[W.posicion()].getW(), W.posicion()));
        }
      }
    }
    return costos;
  }

  // ------------------------------------------------------------

  private int extractMin(Costo[] arr, boolean[] marca) {
    Costo aux = new Costo();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].getW() < aux.getW() && !marca[i]) {
        aux.setPrev(i);
        aux.setW(arr[i].getW());
      }
    }
    return aux.getPrev();
  }

  // --------------------- TODOS MINIMOS --------------------------

  public CostoTodosMinimos[] dijkstraTodosMinimos(Grafo<T> grafo, Vertice<T> v) {
    CostoTodosMinimos[] arr = new CostoTodosMinimos[grafo.listaDeVertices().tamanio()];
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new CostoTodosMinimos();
      if (v.posicion() == i) {
        arr[i].setPrev(0);
        arr[i].setW(0);
        arr[i].setNumCaminosMinimos(1);
      } else {
        arr[i].setW(Integer.MAX_VALUE);
      }
    }
    for (int i = 0; i < arr.length; i++) {
      Vertice<T> u = grafo.listaDeVertices().elemento(extractMin(arr, marca));
      int camino = arr[u.posicion()].getW();
      marca[u.posicion()] = true;
      ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(u);
      ady.comenzar();
      while (!ady.fin()) {
        Arista<T> arista = ady.proximo();
        int peso = arista.peso();
        int j = arista.verticeDestino().posicion();
        if (!marca[j]) {
          if (camino + peso < arr[j].getW()) {
            arr[j].setW(camino + peso);
            arr[j].setPrev(u.posicion());
            arr[j].setNumCaminosMinimos(arr[u.posicion()].getNumCaminosMinimos());
          } else if (camino + peso == arr[j].getW()) {
            arr[j].setNumCaminosMinimos(arr[j].getNumCaminosMinimos() + arr[u.posicion()].getNumCaminosMinimos());
          }
        }
      }
    }

    return arr;
  }

}
