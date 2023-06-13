package Modulo2.parciales.Parcial4;

import classes.Grafos.Arista;
import classes.Grafos.Grafo;
import classes.Grafos.Vertice;
import classes.ListaGenerica.ListaGenerica;
import classes.ListaGenerica.ListaGenericaEnlazada;

public class Parcial {
    public ListaGenerica<String> resolver(Grafo<Ciudad> ciudades, String origen, String destino) {
        if (ciudades == null || ciudades.esVacio())
            return null;
        ListaGenerica<Vertice<Ciudad>> V = ciudades.listaDeVertices();
        Vertice<Ciudad> vIni = null;
        Vertice<Ciudad> vFin = null;
        for (int i = 0; i < V.tamanio(); i++) {
            if (V.elemento(i).dato().getNombre().equals(origen))
                vIni = V.elemento(i);
            if (V.elemento(i).dato().getNombre().equals(destino))
                vFin = V.elemento(i);
        }

        boolean[] marca = new boolean[V.tamanio()];

        ListaGenerica<String> l = new ListaGenericaEnlazada<>();

        if (vIni != null && vFin != null)
            resolver(ciudades, vIni, vFin, marca, new boolean[V.tamanio()], l);

        return l;

    }

    public boolean resolver(Grafo<Ciudad> ciudades, Vertice<Ciudad> origen, Vertice<Ciudad> destino, boolean[] marca,
            boolean[] visitados, ListaGenerica<String> l) {
        marca[origen.posicion()] = true;

        l.agregarFinal(origen.dato().getNombre());

        if (origen.dato().getNombre().equals(destino.dato().getNombre())) {
            if (!visitados[origen.posicion()])
                visitados[origen.posicion()] = true;
            else
                l.eliminarEn(l.tamanio() - 1);
            return true;
        }

        ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(origen);
        ady.comenzar();
        boolean flag = false;
        while (!ady.fin()) {
            Arista<Ciudad> act = ady.proximo();
            Vertice<Ciudad> v = act.verticeDestino();
            int j = v.posicion();
            if (!marca[j] && v.dato().getFase() > 1 && act.peso() != 0) {
                if (resolver(ciudades, v, destino, marca, visitados, l)) {
                    if (!visitados[j]) {
                        visitados[j] = true;
                    }
                    flag = true;
                } else {
                    l.eliminarEn(l.tamanio() - 1);
                }
                marca[j] = false;
            }
        }
        return flag;
    }
}
