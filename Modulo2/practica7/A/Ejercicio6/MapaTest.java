package Modulo2.practica7.A.Ejercicio6;

import classes.Grafos.Grafo;
import classes.Grafos.GrafoImplListAdy;
import classes.Grafos.Vertice;
import classes.Grafos.VerticeImplListAdy;
import classes.ListaGenerica.ListaGenerica;

public class MapaTest {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
        Vertice<String> v6 = new VerticeImplListAdy<String>("La Habana");
        Vertice<String> v7 = new VerticeImplListAdy<String>("Caracas");

        Grafo<String> ciudades = new GrafoImplListAdy<String>();
        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);
        ciudades.agregarVertice(v4);
        ciudades.agregarVertice(v5);
        ciudades.agregarVertice(v6);
        ciudades.agregarVertice(v7);
        ciudades.conectar(v1, v2, 3);
        ciudades.conectar(v1, v3, 2);
        ciudades.conectar(v1, v4, 4);
        ciudades.conectar(v1, v5, 10);
        ciudades.conectar(v2, v5, 500);
        ciudades.conectar(v3, v5, 4);
        ciudades.conectar(v4, v5, 6);
        ciudades.conectar(v2, v6, 4);
        ciudades.conectar(v7, v5, 11);
        ciudades.conectar(v7, v6, 10);

        Mapa M = new Mapa(ciudades);
        ListaGenerica<String> l = M.devolverCamino("Buenos Aires", "Asuncion");
        System.out.println(l.toString());

        l.eliminar("Buenos Aires");
        l.eliminar("Asuncion");
        ListaGenerica<String> l2 = M.devolverCaminoExceptuando("Buenos Aires", "Asuncion", l);
        System.out.println(l2.toString());

        ListaGenerica<String> l3 = M.caminoMasCorto("Buenos Aires", "Asuncion");
        System.out.println(l3.toString());

        ListaGenerica<String> l4 = M.caminoSinCargarCombustible("Buenos Aires", "Asuncion", 10);
        System.out.println(l4.toString());

        ListaGenerica<String> l5 = M.caminoConMenorCargaDeCombustible("Buenos Aires", "Asuncion", 10);
        System.out.println(l5.toString());
    }
}