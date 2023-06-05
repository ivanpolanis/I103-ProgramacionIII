package practica7.B.Ejercicio1;

import classes.grafos.*;
import classes.grafos.utils.OrdenTopologico;
import classes.ListaGenerica;

public class Test {
  public static void main(String args[]) {
    Vertice<String> v1 = new VerticeImplListAdy<String>("Boxer");
    Vertice<String> v2 = new VerticeImplListAdy<String>("Medias");
    Vertice<String> v3 = new VerticeImplListAdy<String>("Reloj");
    Vertice<String> v4 = new VerticeImplListAdy<String>("Pantalones");
    Vertice<String> v5 = new VerticeImplListAdy<String>("Zapatos");
    Vertice<String> v6 = new VerticeImplListAdy<String>("Cinturon");
    Vertice<String> v7 = new VerticeImplListAdy<String>("Camisa");
    Vertice<String> v8 = new VerticeImplListAdy<String>("Corbata");
    Vertice<String> v9 = new VerticeImplListAdy<String>("Saco");

    Grafo<String> grafo = new GrafoImplListAdy<>();

    grafo.agregarVertice(v1);
    grafo.agregarVertice(v2);
    grafo.agregarVertice(v3);
    grafo.agregarVertice(v4);
    grafo.agregarVertice(v5);
    grafo.agregarVertice(v6);
    grafo.agregarVertice(v7);
    grafo.agregarVertice(v8);
    grafo.agregarVertice(v9);

    grafo.conectar(v1, v4);
    grafo.conectar(v1, v5);
    grafo.conectar(v2, v5);
    grafo.conectar(v4, v6);
    grafo.conectar(v6, v8);
    grafo.conectar(v7, v6);
    grafo.conectar(v7, v8);
    grafo.conectar(v8, v9);

    ListaGenerica<Vertice<String>> l = OrdenTopologico.ordenTopologico(grafo);
    for (int i = 0; i < l.tamanio(); i++) {
      System.out.print(l.elemento(i).dato()+ (i== l.tamanio()-1 ? "" : " -> "));
    }
  }
}
