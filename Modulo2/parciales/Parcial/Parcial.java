package Modulo2.parciales.Parcial;

import classes.Grafos.Arista;
import classes.Grafos.Grafo;
import classes.Grafos.Vertice;
import classes.ListaGenerica.ListaGenerica;
import classes.ListaGenerica.ListaGenericaEnlazada;

public class Parcial {

  public static ListaGenerica<ListaGenerica<String>> resolver(Grafo<String> ciudades, String origen, String destino,
      ListaGenerica<String> evitarPasarPor) {
    ListaGenerica<ListaGenerica<String>> caminos = new ListaGenericaEnlazada<>();
    if (ciudades == null || ciudades.esVacio()) {
      return caminos;
    }
    Vertice<String> vOrigen = null;
    Vertice<String> vDestino = null;
    for (int i = 0; i < ciudades.listaDeVertices().tamanio(); i++) {
      Vertice<String> v = ciudades.listaDeVertices().elemento(i);
      if (v.dato().equals(origen)) {
        vOrigen = v;
      }
      if (v.dato().equals(destino)) {
        vDestino = v;
      }
    }
    
    if (vOrigen == null || vDestino == null) {
      return caminos;
    }

    resolver(ciudades, vOrigen, vDestino, evitarPasarPor, new ListaGenericaEnlazada<>(), caminos,
        new boolean[ciudades.listaDeVertices().tamanio()]);

    return caminos;
  }

  private static void resolver(Grafo<String> ciudades, Vertice<String> origen, Vertice<String> destino,
      ListaGenerica<String> evitarPasarPor, ListaGenerica<String> caminoActual,
      ListaGenerica<ListaGenerica<String>> caminos, boolean[] marca) {
        
    marca[origen.posicion()] = true;
    caminoActual.agregarFinal(origen.dato());
    if (origen.dato().equals(destino.dato())) {
      copiarLista(caminos, caminoActual);
      return;
    }

    ListaGenerica<Arista<String>> adyacentes = ciudades.listaDeAdyacentes(origen);
    adyacentes.comenzar();

    while (!adyacentes.fin()) {

      Arista<String> a = adyacentes.proximo();
      Vertice<String> v = a.verticeDestino();
      int j = v.posicion();
      if (!marca[j] && !evitarPasarPor.incluye(v.dato())) {
        resolver(ciudades, v, destino, evitarPasarPor, caminoActual, caminos, marca);
        caminoActual.eliminarEn(caminoActual.tamanio() - 1);
        marca[j] = false;
      }
    }
  }

  private static void copiarLista(ListaGenerica<ListaGenerica<String>> caminos, ListaGenerica<String> actual) {
    actual.comenzar();
    ListaGenerica<String> copia = new ListaGenericaEnlazada<>();
    while (!actual.fin()) {
      copia.agregarFinal(actual.proximo());
    }
    caminos.agregarFinal(copia);
  }
  
}
