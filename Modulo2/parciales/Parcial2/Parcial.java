package Modulo2.parciales.Parcial2;

import classes.Grafos.Arista;
import classes.Grafos.Grafo;
import classes.Grafos.Vertice;
import classes.ListaGenerica.ListaGenerica;
import classes.ListaGenerica.ListaGenericaEnlazada;

public class Parcial {
  public ListaGenerica<String> resolver(Grafo<Ciudad> ciudades, String origen, String destino, int minFase) {
    if (ciudades == null || ciudades.esVacio())
      return null;
    ListaGenerica<Vertice<Ciudad>> v = ciudades.listaDeVertices();
    boolean[] marca = new boolean[v.tamanio()];
    Vertice<Ciudad> vIni = null;
    Vertice<Ciudad> vFin = null;
    for (int i = 0; i < v.tamanio(); i++) {
      if (v.elemento(i).dato().getNombre().equals(origen))
        vIni = v.elemento(i);
      if (v.elemento(i).dato().getNombre().equals(destino))
        vFin = v.elemento(i);
    }

    ListaGenerica<String> l = new ListaGenericaEnlazada<>();

    if (vIni != null && vFin != null)
      resolver(ciudades, marca, vIni, vFin, 2, l, new ListaGenericaEnlazada<>());
    return l;
  }

  private boolean resolver(Grafo<Ciudad> ciudades, boolean[] marca, Vertice<Ciudad> origen, Vertice<Ciudad> destino,
      int minFase, ListaGenerica<String> l, ListaGenerica<String> actual) {
    marca[origen.posicion()] = true;
    actual.agregarFinal(origen.dato().getNombre());
    if (origen.dato().getNombre().equals(destino.dato().getNombre())) {
      copiar(l, actual);
      return true;
    }

    ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(origen);
    ady.comenzar();
    while (!ady.fin()) {
      Arista<Ciudad> a = ady.proximo();
      Vertice<Ciudad> v = a.verticeDestino();
      int j = v.posicion();
      if (!marca[j] && a.peso() != 0 && minFase <= v.dato().getFase()) {
        if (resolver(ciudades, marca, v, destino, minFase, l, actual))
          return true;
        marca[j] = false;
      }
    }
    actual.eliminarEn(actual.tamanio() - 1);
    return false;
  }

  private void copiar(ListaGenerica<String> l, ListaGenerica<String> actual) {
    l.comenzar();
    while (!l.fin())
      l.eliminarEn(l.tamanio() - 1);
    actual.comenzar();
    while (!actual.fin()) {
      l.agregarFinal(actual.proximo());
    }
  }
}