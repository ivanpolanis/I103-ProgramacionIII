package classes.grafos.utils;

import classes.grafos.Grafo;
import classes.grafos.Vertice;
import classes.grafos.Arista;
import classes.ListaGenerica;
import java.util.Arrays;

public class Algoritmos<T> {
  public boolean subgrafoCuadrado(Grafo<T> grafo) {
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    for (int i = 0; i < marca.length; i++) {
      if (!marca[i]) {
        Vertice<T> vertice = grafo.listaDeVertices().elemento(i);
        boolean[] enRecursion = new boolean[grafo.listaDeVertices().tamanio()];
        if (subgrafoCuadrado(grafo, vertice, marca, enRecursion) == 4) {
          return true;
        }
      }
    }
    return false;
  }

  private int subgrafoCuadrado(Grafo<T> grafo, Vertice<T> vertice, boolean[] marca, boolean[] enRecursion) {
    marca[vertice.posicion()] = true;
    enRecursion[vertice.posicion()] = true;
    ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(vertice);
    ady.comenzar();
    int cant = 0;
    while (!ady.fin()) {
      Arista<T> arista = ady.proximo();
      Vertice<T> verticeAdy = arista.verticeDestino();
      if (!marca[verticeAdy.posicion()]) {
        cant += subgrafoCuadrado(grafo, verticeAdy, marca, enRecursion);
        if (cant > 0)
          return cant + 1;
      } else if (enRecursion[verticeAdy.posicion()]) {
        return 1;
      }
    }
    enRecursion[vertice.posicion()] = false;
    return cant;
  }

  // -------------------------------------------------------------------

  public int getGrado(Grafo<T> grafo) {
    int grados[] = new int[grafo.listaDeVertices().tamanio()];
    for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
      Vertice<T> vertice = grafo.listaDeVertices().elemento(i);
      ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(vertice);
      ady.comenzar();
      grados[i] += ady.tamanio();
      while (!ady.fin()) {
        grados[ady.proximo().verticeDestino().posicion()]++;
      }
    }
    return Arrays.stream(grados).max().getAsInt();
  }

  // -------------------------------------------------------------------


  public boolean tieneCiclo(Grafo<T> grafo) {
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    for (int i = 0; i < marca.length; i++) {
      if (!marca[i]) {
        Vertice<T> vertice = grafo.listaDeVertices().elemento(i);
        boolean[] enRecursion = new boolean[grafo.listaDeVertices().tamanio()];
        if (tieneCiclo(grafo, vertice, marca, enRecursion)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean tieneCiclo(Grafo<T> grafo, Vertice<T> vertice, boolean[] marca, boolean[] enRecursion) {
    marca[vertice.posicion()] = true;
    enRecursion[vertice.posicion()] = true;
    ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(vertice);
    ady.comenzar();
    while (!ady.fin()) {
      Arista<T> arista = ady.proximo();
      Vertice<T> verticeAdy = arista.verticeDestino();
      if (!marca[verticeAdy.posicion()]) {
        if (tieneCiclo(grafo, verticeAdy, marca, enRecursion)) {
          return true;
        }
      } else if (enRecursion[verticeAdy.posicion()]) {
        return true;
      }
    }
    enRecursion[vertice.posicion()] = false;
    return false;
  }
}
