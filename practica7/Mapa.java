package practica7;

import classes.grafos.Grafo;
import classes.grafos.Vertice;
import classes.grafos.Arista;
import classes.ListaGenerica;
import classes.ListaGenericaEnlazada;

public class Mapa {
  private Grafo<String> mapaCiudades;

  public Mapa(Grafo<String> mapaCiudades) {
    this.mapaCiudades = mapaCiudades;
  }

  public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
        ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
        if (i < marca.length) //Si la ciudad1 se encuentra en el grafo
            devolverCamino(i, mapaCiudades, marca, l, ciudad2);
        return l;
    }

    private boolean devolverCamino(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> l, String ciudad2){
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        if (v.dato().equals(ciudad2)) { //Agrego si encuentro la ciudad2
            l.agregarFinal(v.dato());
            return true;
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                if (devolverCamino(j, grafo, marca, l, ciudad2)) { //Si se encontro el camino
                    l.agregarInicio(v.dato());
                    return true;
                }
            }
        }
        return false;
    }

}
