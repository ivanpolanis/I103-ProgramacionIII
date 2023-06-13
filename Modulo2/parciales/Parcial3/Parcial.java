package Modulo2.parciales.Parcial3;

import classes.Grafos.Arista;
import classes.Grafos.Grafo;
import classes.Grafos.Vertice;
import classes.ListaGenerica.ListaGenerica;

public class Parcial {

    public int[] resolver(Grafo<Ciudad> ciudades, String origen, String destino) {

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

        int[] fases = new int[5];

        if (vIni != null && vFin != null)
            resolver(ciudades, vIni, vFin, marca, new boolean[v.tamanio()], fases);
        return fases;
    }

    public boolean resolver(Grafo<Ciudad> ciudades, Vertice<Ciudad> origen, Vertice<Ciudad> destino, boolean[] marca,
            boolean[] recorridos, int[] fases) {
        marca[origen.posicion()] = true;

        if (origen.dato().getNombre().equals(destino.dato().getNombre())) {
            if(!recorridos[origen.posicion()])
                fases[origen.dato().getFase() - 1]++;
            return true;
        }

        ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(origen);
        ady.comenzar();
        boolean flag = false;
        while (!ady.fin()) {
            boolean flag2 = false;
            Arista<Ciudad> a = ady.proximo();
            Vertice<Ciudad> v = a.verticeDestino();
            int j = v.posicion();
            if (!marca[j] && a.peso() != 0) {
                flag2 = resolver(ciudades, v, destino, marca, recorridos, fases);
                if (flag2) {
                    if (!recorridos[j]) {
                        recorridos[j] = true;
                        fases[v.dato().getFase() - 1]++;
                    }
                    marca[j] = false;
                    flag = flag2;
                }
                marca[j] = false;
            }
        }

        return flag;

    }

}
