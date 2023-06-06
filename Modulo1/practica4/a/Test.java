package Modulo1.practica4.a;

import classes.ArbolBinario.ArbolBinario;
import classes.ArbolBinario.utils.ProcesadorDeArbol;
import classes.ArbolBinario.utils.Repositorio;

public class Test {
  public static void main(String[] args) {
    ArbolBinario<Integer> arbol = new ArbolBinario<>(10);
    arbol.agregarHijoIzquierdo(new ArbolBinario<Integer>(6));
    arbol.getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
    arbol.getHijoIzquierdo().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(20));
    arbol.getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(9));
    arbol.getHijoIzquierdo().getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(11));
    arbol.getHijoIzquierdo().getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(5));
    arbol.agregarHijoDerecho(new ArbolBinario<Integer>(2));
    arbol.getHijoDerecho().agregarHijoIzquierdo(new ArbolBinario<Integer>(8));
    arbol.getHijoDerecho().getHijoIzquierdo().agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
    arbol.getHijoDerecho().getHijoIzquierdo().agregarHijoDerecho(new ArbolBinario<Integer>(4));
    arbol.getHijoDerecho().agregarHijoDerecho(new ArbolBinario<Integer>(3));

    ProcesadorDeArbol procesador = new ProcesadorDeArbol(arbol);

    Repositorio repo = procesador.procesar();

    System.out.println("Cantidad de pares: " + repo.getPares());

    System.out.println("Arboles con dos hijos y dato par: " + repo.getLista().toString());
    

  }
}
