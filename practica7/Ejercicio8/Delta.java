package practica7.Ejercicio8;

import classes.grafos.Grafo;
import classes.grafos.Vertice;
import classes.grafos.Arista;
import classes.ListaGenerica;
import java.util.Arrays;

public class Delta<T> {

  public int maxIslasDistintas(Grafo<T> grafo) {
    Vertice<T> v = grafo.listaDeVertices().elemento(0);
    int[] islas = new int[grafo.listaDeAdyacentes(v).tamanio()];
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    marca[0] = true;
    int i = 0;
    ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      Arista<T> arista = ady.proximo();
      if (!marca[arista.verticeDestino().posicion()]) {
        maxIslasDistintas(grafo, arista.verticeDestino(), marca, islas, i);
      }
      islas[i]++;
      i++;
    }
    return Arrays.stream(islas).max().getAsInt();
  }

  private void maxIslasDistintas(Grafo<T> grafo, Vertice<T> v, boolean[] marca, int[] islas, int i) {
    marca[v.posicion()] = true;
    ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      Arista<T> arista = ady.proximo();
      if (!marca[arista.verticeDestino().posicion()]) {
        islas[i]++;
        maxIslasDistintas(grafo, arista.verticeDestino(), marca, islas, i);
      }
    }
  }
  
  // ------------------------------------------------------

  public RutaMinima<T> caminoMasCorto(Grafo<T> grafo, String islaO, String islaD) {
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    RutaMinima<T> ruta = new RutaMinima<>();
    RutaMinima<T> rutaActual = new RutaMinima<>();
    rutaActual.setBoletos(1);
    Vertice<T> origen = null;
    Vertice<T> destino = null;
    for (int i = 0; i < marca.length; i++) {
      if (grafo.listaDeVertices().elemento(i).dato().equals(islaO)) {
        origen = grafo.listaDeVertices().elemento(i);
      }
      if (grafo.listaDeVertices().elemento(i).dato().equals(islaD)) {
        destino = grafo.listaDeVertices().elemento(i);
      }
    }

    if (origen != null && destino != null) {
      caminoMasCorto(grafo, origen, destino, marca, ruta, rutaActual);
    }
    return ruta;
  }

  private void caminoMasCorto(Grafo<T> grafo, Vertice<T> origen, Vertice<T> destino, boolean[] marca, RutaMinima<T> ruta, RutaMinima<T> rutaActual) {
    marca[origen.posicion()] = true;
    rutaActual.agregar(origen.dato());
    if (origen.dato().equals(destino.dato())) {
      if(rutaActual.getRuta().tamanio() < ruta.getRuta().tamanio() || ruta.getRuta().tamanio() == 0){
        copiar(ruta, rutaActual);
      }
      return;
    }
    if(origen.posicion() == 0 && !origen.dato().equals(destino.dato())) {
      rutaActual.agregarBoleto();
    }
    ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(origen);
    ady.comenzar();
    while (!ady.fin()) {
      Arista<T> arista = ady.proximo();
      if (!marca[arista.verticeDestino().posicion()]) {
        caminoMasCorto(grafo, arista.verticeDestino(), destino, marca, ruta, rutaActual);
        marca[arista.verticeDestino().posicion()] = false;
        rutaActual.eliminar(rutaActual.getRuta().tamanio() - 1);
        if(origen.posicion() == 0 && !origen.dato().equals(destino.dato())) {
          rutaActual.eliminarBoleto();
        }
      }
      
    }
  }

  private void copiar(RutaMinima<T> ruta, RutaMinima<T> rutaActual) {
    while (!ruta.getRuta().esVacia()) {
      ruta.eliminar(0);
    }
    rutaActual.getRuta().comenzar();
    while (!rutaActual.getRuta().fin()) {
      ruta.agregar(rutaActual.getRuta().proximo());
    }
    ruta.setBoletos(rutaActual.getBoletos());
  }
  
}
