package Modulo2.parciales.Parcial11;

import classes.Grafos.Arista;
import classes.Grafos.Grafo;
import classes.Grafos.Vertice;
import classes.ListaGenerica.ListaGenerica;
import classes.ListaGenerica.ListaGenericaEnlazada;

public class CaminoSinControles {

    private Grafo<String> mapa;

    public CaminoSinControles(Grafo<String> mapa){
        this.mapa = mapa;
    }

    public ListaGenerica<ListaGenerica<String>> devolverCaminos(String origen, String destino){
       if (mapa == null || mapa.esVacio())
            return null;
       ListaGenerica<Vertice<String>> vertices = mapa.listaDeVertices();
       boolean[] marca = new boolean[vertices.tamanio()];
       Vertice<String> vIni = null;
       Vertice<String> vFin = null;
       for(int i  = 0; i < vertices.tamanio(); i++){
            if(vertices.elemento(i).dato().equals(origen))
                vIni = vertices.elemento(i);
            if(vertices.elemento(i).dato().equals(destino))
                vFin = vertices.elemento(i);
       }

        ListaGenerica<ListaGenerica<String>> l = new ListaGenericaEnlazada<>();

       if(vIni != null && vFin != null){
            resolver(vIni,vFin,marca,l,new ListaGenericaEnlazada<>());
       }
       return l;
    }

    private void resolver(Vertice<String> origen, Vertice<String> destino, boolean[] marca, ListaGenerica<ListaGenerica<String>> l, ListaGenerica<String> actual){
        marca[origen.posicion()] = true;

        actual.agregarFinal(origen.dato());

        if (origen.dato().equals(destino.dato())) {
            agregarCopia(l,actual);
            return;
        }

        ListaGenerica<Arista<String>> ady = mapa.listaDeAdyacentes(origen);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<String> arista = ady.proximo();
            Vertice<String> v = arista.verticeDestino();
            int j = v.posicion();
            if(!marca[j] && arista.peso() == 0){
                resolver(v,destino,marca,l,actual);
                marca[j] = false;
                actual.eliminarEn(actual.tamanio() - 1);
           }
        }

    }

    private void agregarCopia(ListaGenerica<ListaGenerica<String>> l, ListaGenerica<String> actual){
        ListaGenerica<String> n = new ListaGenericaEnlazada<>();
        actual.comenzar();
        while(!actual.fin()){
            n.agregarFinal(actual.proximo());
        }
        l.agregarFinal(n);
    }
}
