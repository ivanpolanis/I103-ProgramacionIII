package Modulo2.parciales.Parcial7;

import classes.Grafos.Arista;
import classes.Grafos.Grafo;
import classes.Grafos.Vertice;
import classes.ListaGenerica.ListaGenerica;
import classes.ListaGenerica.utils.Cola;

public class Parcial{
    public int resolver(Vertice<Integer> virus,Grafo<Integer> grafo){
        Cola<Vertice<Integer>> cola = new Cola<>();
        cola.encolar(virus);
        cola.encolar(null);
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        int tiempo = 0;
        while(!cola.esVacio()){
            Vertice<Integer> v = cola.desencolar();
            if (v != null) {
                ListaGenerica<Arista<Integer>> ady = grafo.listaDeAdyacentes(v);
                ady.comenzar();
                while(!ady.fin()){
                    Arista<Integer> act = ady.proximo();
                    Vertice<Integer> vAct = act.verticeDestino();
                    int j = vAct.posicion();
                    if(!marca[j]){
                        cola.encolar(vAct);
                        marca[j] = true;
                    }
                }
            } else if (!cola.esVacio()){
                tiempo++;
                cola.encolar(null);
            }
        }
        return tiempo;
    }
}
