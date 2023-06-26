package Modulo2.parciales.Parcial;

import classes.ListaGenerica.ListaGenerica;
import classes.ListaGenerica.ListaGenericaEnlazada;
import classes.Grafos.Grafo;
import classes.Grafos.GrafoImplListAdy;
import classes.Grafos.VerticeImplListAdy;

public class Test {
    public static void main(String[] args) {
        Grafo<String> grafo = new GrafoImplListAdy<String>();
        VerticeImplListAdy<String> buzet = new VerticeImplListAdy<String>("Buzet");
        VerticeImplListAdy<String> champagne = new VerticeImplListAdy<String>("Champagne");
        VerticeImplListAdy<String> cahors = new VerticeImplListAdy<String>("Cahors");
        VerticeImplListAdy<String> bellet = new VerticeImplListAdy<String>("Bellet");
        VerticeImplListAdy<String> beaujolais = new VerticeImplListAdy<String>("Beaujolais");
        VerticeImplListAdy<String> armagnac = new VerticeImplListAdy<String>("Armagnac");
        VerticeImplListAdy<String> bugey = new VerticeImplListAdy<String>("Bugey");
        VerticeImplListAdy<String> chabils = new VerticeImplListAdy<String>("Chabils");
        grafo.conectar(buzet, champagne, 0);
        grafo.conectar(champagne, cahors, 0);
        grafo.conectar(cahors, bellet, 0);
        grafo.conectar(cahors, beaujolais, 0);
        grafo.conectar(beaujolais, cahors, 0);
        grafo.conectar(cahors, chabils, 0);
        grafo.conectar(chabils, beaujolais, 0);
        grafo.conectar(armagnac, beaujolais, 0);
        grafo.conectar(chabils, bugey, 0);
        grafo.conectar(bugey, armagnac, 0);
        grafo.agregarVertice(buzet);
        grafo.agregarVertice(champagne);
        grafo.agregarVertice(cahors);
        grafo.agregarVertice(bellet);
        grafo.agregarVertice(beaujolais);
        grafo.agregarVertice(armagnac);
        grafo.agregarVertice(bugey);
        grafo.agregarVertice(chabils);
        ListaGenericaEnlazada<String> evitarPasarPor = new ListaGenericaEnlazada<>();
        evitarPasarPor.agregarFinal("Bellet");
        evitarPasarPor.agregarFinal("Bugey");
        ListaGenerica<ListaGenerica<String>> res = Parcial.resolver(grafo, "Buzet", "Beaujolais", evitarPasarPor);

        res.comenzar();

        while (!res.fin()) {
            System.out.println("Camino " + res.proximo());
        }
    }
}
