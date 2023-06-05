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
    int length = grafo.listaDeVertices().tamanio();
    Costo[] costos = new Costo[length];
    if (!grafo.listaDeVertices().incluye(v)) {
      return null;
    }
    boolean[] marca = new boolean[length];
    PriorityQueue<Costo> heap = new PriorityQueue<>();

    for (int i = 0; i < length; i++) {
      costos[i] = new Costo();
      costos[i].setW(Integer.MAX_VALUE); // Establecer distancias iniciales como infinito
    }

    costos[v.posicion()].setW(0);
    costos[v.posicion()].setPrev(v.posicion()); // Establecer distancia inicial del vertice origen como 0
    heap.offer(new Costo(0, v.posicion()));
    while (!heap.isEmpty()) {
      Costo costoActual = heap.poll();
      int uPosicion = costoActual.getPrev();
      Vertice<T> U = grafo.listaDeVertices().elemento(uPosicion);
      if (marca[U.posicion()]) {
        continue;
      }
      marca[U.posicion()] = true;
      ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(U);
      ady.comenzar();
      while (!ady.fin()) {
        Arista<T> arista = ady.proximo();
        Vertice<T> W = arista.verticeDestino();
        if (!marca[W.posicion()] && costos[W.posicion()].getW() > costos[uPosicion].getW() + arista.peso()) {
          costos[W.posicion()].setW(costos[uPosicion].getW() + arista.peso());
          costos[W.posicion()].setPrev(uPosicion);
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
