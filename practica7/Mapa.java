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
        if (i < marca.length) // Si la ciudad1 se encuentra en el grafo
            devolverCamino(i, mapaCiudades, marca, l, ciudad2);
        return l;
    }

    private boolean devolverCamino(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> l,
            String ciudad2) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        if (v.dato().equals(ciudad2)) { // Agrego si encuentro la ciudad2
            l.agregarFinal(v.dato());
            return true;
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                if (devolverCamino(j, grafo, marca, l, ciudad2)) { // Si se encontro el camino
                    l.agregarInicio(v.dato());
                    return true;
                }
            }
        }
        return false;
    }

    // -------------------------------------------------------------------------------------------

    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2,
            ListaGenerica<String> ciudades) {
        ListaGenerica<String> l = new ListaGenericaEnlazada<>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
        if (i < marca.length) // Si la ciudad1 se encuentra en el grafo
            devolverCaminoExceptuando(i, mapaCiudades, marca, l, ciudad2, ciudades);
        return l;
    }

    private void devolverCaminoExceptuando(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> l,
            String ciudad2, ListaGenerica<String> ciudades) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        if (v.dato().equals(ciudad2)) { // Agrego si encuentro la ciudad2
            l.agregarFinal(v.dato());
            return;
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j] && !ciudades.incluye(v.dato())) {
                devolverCaminoExceptuando(j, grafo, marca, l, ciudad2, ciudades);
                if (!l.esVacia()) {
                    l.agregarInicio(v.dato());
                    return;
                }
            }
        }
    }

    // -------------------------------------------------------------------------------------------

    public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
        ListaGenerica<String> l = new ListaGenericaEnlazada<>();
        ListaGenerica<String> resultado = new ListaGenericaEnlazada<>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                break;
            }
        }
        if (i < marca.length) // Si la ciudad1 se encuentra en el grafo
            caminoMasCorto(i, mapaCiudades, marca, l, ciudad2, resultado);
        return resultado;
    }

    private void caminoMasCorto(int i, Grafo<String> grafo, boolean[] marca, ListaGenerica<String> l, String ciudad2,
            ListaGenerica<String> resultado) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        l.agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)) {
            if ((resultado.tamanio() == 0) || (l.tamanio() < resultado.tamanio()))
                copiarCamino(resultado, l);
            return;
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(grafo.listaDeVertices().elemento(i));
        ady.comenzar();
        while (!ady.fin()) {
            int j = ady.proximo().verticeDestino().posicion();
            if (!marca[j]) {
                caminoMasCorto(j, grafo, marca, l, ciudad2, resultado);
                marca[j] = false;
                l.eliminarEn(l.tamanio() - 1);
            }
        }
    }

    private void copiarCamino(ListaGenerica<String> resultado, ListaGenerica<String> l) {
        while (!resultado.esVacia()) {
            resultado.eliminarEn(0);
        }
        l.comenzar();
        while (!l.fin()) {
            resultado.agregarFinal(l.proximo());
        }
    }

    // -------------------------------------------------------------------------------------------

    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanque) {
        ListaGenerica<String> l = new ListaGenericaEnlazada<>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1))
                break;
        }
        if (i < marca.length)
            caminoSinCargarCombustible(i, ciudad2, marca, tanque, mapaCiudades, l);
        return l;
    }

    private void caminoSinCargarCombustible(int i, String ciudad2, boolean[] marca, int tanque, Grafo<String> grafo,
            ListaGenerica<String> l) {
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        if (v.dato().equals(ciudad2)) {
            if (tanque > 0) {
                l.agregarFinal(ciudad2);
            }
            return;
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);

        ady.comenzar();
        while (!ady.fin()) {
            Arista<String> aux = ady.proximo();
            int j = aux.verticeDestino().posicion();
            if (!marca[j]) {
                caminoSinCargarCombustible(j, ciudad2, marca, tanque - aux.peso(), grafo, l);
                if (!l.esVacia()) {
                    l.agregarInicio(v.dato());
                    return;
                }
            }

        }
    }

    // -------------------------------------------------------------------------------------------

    public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanque) {
        ListaGenerica<String> camino = new ListaGenericaEnlazada<>();
        ListaGenerica<String> caminoActual = new ListaGenericaEnlazada<>();
        boolean[] marca = new boolean[mapaCiudades.listaDeVertices().tamanio()];
        int i;
        for (i = 0; i < marca.length; i++) {
            if (mapaCiudades.listaDeVertices().elemento(i).dato().equals(ciudad1))
                break;
        }
        if (i < marca.length) {
            caminoConMenorCargaDeCombustible(i,marca,mapaCiudades,ciudad2,tanque,tanque,0,0, camino, caminoActual);
        }
        return camino;
    }

    private void caminoConMenorCargaDeCombustible(int i, boolean[] marca,Grafo<String> grafo, String ciudad2, int capacidad, int tanque, int carga, int cargaActual, ListaGenerica<String> camino, ListaGenerica<String> caminoActual){
        marca[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        caminoActual.agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)) {
            if ((camino.tamanio() == 0) || (carga > cargaActual)){
                copiarCamino(camino, caminoActual);
                carga = cargaActual;
            }
            return;
        }

        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<String> aux = ady.proximo();
            int j = aux.verticeDestino().posicion();
            if (!marca[j]) {
                tanque -= aux.peso();
                if (tanque <= 0 && capacidad > aux.peso()) {
                    tanque = capacidad;
                    cargaActual++;
                }
                if (capacidad > aux.peso()) {
                    caminoConMenorCargaDeCombustible(j, marca, grafo, ciudad2, capacidad, tanque, carga, cargaActual,
                            camino, caminoActual);
                    marca[j] = false;
                    caminoActual.eliminarEn(caminoActual.tamanio() - 1);
                }
            }
        }



    }
}
