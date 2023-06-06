package Modulo2.practica7.B.Ejercicio2;

import classes.Grafos.Grafo;
import classes.Grafos.GrafoImplListAdy;
import classes.Grafos.Vertice;
import classes.Grafos.VerticeImplListAdy;
import classes.Grafos.utils.Costo;
import classes.Grafos.utils.Dijkstra;

public class Test {
  public static void main(String[] args) {
    Vertice<String> v1 = new VerticeImplListAdy<String>("A");
    Vertice<String> v2 = new VerticeImplListAdy<String>("B");
    Vertice<String> v3 = new VerticeImplListAdy<String>("C");
    Vertice<String> v4 = new VerticeImplListAdy<String>("D");
    Vertice<String> v5 = new VerticeImplListAdy<String>("E");

    Grafo<String> grafo = new GrafoImplListAdy<String>();

    grafo.agregarVertice(v1);
    grafo.agregarVertice(v2);
    grafo.agregarVertice(v3);
    grafo.agregarVertice(v4);
    grafo.agregarVertice(v5);

    grafo.conectar(v1, v2, 4);
    grafo.conectar(v1, v3, 2);

    grafo.conectar(v2, v3, 3);
    grafo.conectar(v2, v4, 2);
    grafo.conectar(v2, v5, 3);

    grafo.conectar(v3, v2, 1);
    grafo.conectar(v3, v4, 4);
    grafo.conectar(v3, v5, 5);

    grafo.conectar(v5, v4, 1);

    Dijkstra<String> dijkstra = new Dijkstra<String>();
    Costo[] arr = dijkstra.dijkstraSinHeap(grafo, v1);
    Costo[] arr2 = dijkstra.dijkstraConHeap(grafo, v1);

    for (int i = 0; i < arr.length; i++) {
      System.out.println("Vertice: " + grafo.listaDeVertices().elemento(i).dato() + " Peso: " + arr[i].getW() + " Previo: "
          + grafo.listaDeVertices().elemento(arr[i].getPrev()).dato());
    }

    System.out.println("--------------------------------------------------");
    for (int i = 0; i < arr2.length; i++) {
      System.out.println("Vertice: " + grafo.listaDeVertices().elemento(i).dato() + " Peso: " + arr2[i].getW() + " Previo: "
          + grafo.listaDeVertices().elemento(arr2[i].getPrev()).dato());
    }
  }
}
