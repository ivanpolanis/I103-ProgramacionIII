package Modulo2.practica7.A.Ejercicio6;

import classes.Grafos.Grafo;
import classes.Grafos.GrafoImplListAdy;
import classes.Grafos.Vertice;
import classes.Grafos.VerticeImplListAdy;
import classes.ListaGenerica.ListaGenerica;
import classes.ListaGenerica.ListaGenericaEnlazada;

public class Test {
  public static void main(String args[]) {
    Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
    Vertice<String> v2 = new VerticeImplListAdy<String>("Cordoba");
    Vertice<String> v3 = new VerticeImplListAdy<String>("Rosario");
    Vertice<String> v4 = new VerticeImplListAdy<String>("Mendoza");
    Vertice<String> v5 = new VerticeImplListAdy<String>("La Plata");
    Vertice<String> v6 = new VerticeImplListAdy<String>("Mar del Plata");
    Vertice<String> v7 = new VerticeImplListAdy<String>("San Luis");
    Vertice<String> v8 = new VerticeImplListAdy<String>("San Juan");

    Grafo<String> grafo = new GrafoImplListAdy<String>();
    grafo.agregarVertice(v1);
    grafo.agregarVertice(v2);
    grafo.agregarVertice(v3);
    grafo.agregarVertice(v4);
    grafo.agregarVertice(v5);
    grafo.agregarVertice(v6);
    grafo.agregarVertice(v7);
    grafo.agregarVertice(v8);

    grafo.conectar(v1, v2, 2);
    grafo.conectar(v1, v3, 5);
    grafo.conectar(v1, v4, 8);
    grafo.conectar(v2, v3, 2);
    grafo.conectar(v2, v5, 3);
    grafo.conectar(v3, v4, 1);
    grafo.conectar(v3, v5, 1);
    grafo.conectar(v3, v6, 3);
    grafo.conectar(v4, v6, 2);
    grafo.conectar(v4, v7, 4);
    grafo.conectar(v4, v8, 5);

    Mapa mapa = new Mapa(grafo);

    ListaGenerica<String> exc = new ListaGenericaEnlazada<String>();
    exc.agregarFinal("Rosario");

    System.out
        .println("El camino desde Buenos Aires a San Juan es: " + mapa.devolverCamino("Buenos Aires", "Mar del Plata"));

    System.out.println("El camino desde Buenos Aires a San Juan exceptuando Rosario es: "
        + mapa.devolverCaminoExceptuando("Cordoba", "Mendoza", exc));

    System.out.println("El camino más corto entre Buenos Aires y San Juan es: "
        + mapa.caminoMasCorto("Buenos Aires", "San Juan"));

    System.out.println("El camino utilizando 20 litros de combustible entre Buenos Aires y San Juan es: "
        + mapa.caminoSinCargarCombustible("Buenos Aires", "San Juan", 20));

    System.out.println("El camino con menor carga de combustible entre Buenos Aires y San Juan es: "
        + mapa.caminoConMenorCargaDeCombustible("Buenos Aires", "San Juan", 10));
  }
}
