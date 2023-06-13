package Modulo2.parciales.Parcial1;

import classes.Grafos.Arista;
import classes.Grafos.Grafo;
import classes.Grafos.Vertice;
import classes.ListaGenerica.ListaGenerica;

public class Parcial {
    public int resolver(Grafo<Ciudad> ciudades, String origen, String destino, int maxControles) {
        if (ciudades == null || ciudades.esVacio())
            return 0;
        boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()];
        ListaGenerica<Vertice<Ciudad>> v = ciudades.listaDeVertices();
        Vertice<Ciudad> vIni = null;
        Vertice<Ciudad> vFin = null;
        for (int i = 0; i < marca.length; i++) {
            if (v.elemento(i).dato().getNombre().equals(origen))
                vIni = v.elemento(i);
            if (v.elemento(i).dato().getNombre().equals(destino))
                vFin = v.elemento(i);
        }
        if (vIni != null && vFin != null)
            return resolver(ciudades, marca, vIni, vFin, maxControles, -1, 0);
        else
            return 0;
    }

    private int resolver(Grafo<Ciudad> ciudades, boolean[] marca, Vertice<Ciudad> origen, Vertice<Ciudad> destino,
            int maxCount, int dias, int diasActual) {
        marca[origen.posicion()] = true;
        diasActual += origen.dato().getMaxDias();
        if (origen.dato().getNombre().equals(destino.dato().getNombre())) {
            if (diasActual > dias) {
                return diasActual;
            }
            return dias;
        }
        ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(origen);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<Ciudad> a = ady.proximo();
            Vertice<Ciudad> v = a.verticeDestino();
            int j = v.posicion();
            if (!marca[j] && a.peso() <= maxCount) {
                dias = resolver(ciudades, marca, v, destino, maxCount, dias, diasActual);
                marca[j] = false;
                diasActual -= origen.dato().getMaxDias();
            }
        }
        return dias;
    }
}