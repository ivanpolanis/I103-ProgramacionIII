package utils;

import classes.ArbolBinario;

public class Utils {
  public static int sumaMaximaVertical(ArbolBinario<Integer> arbol) {
    // Si es hoja devolvemos el dato
    if (arbol.esHoja())
      return arbol.getDato();
    int der = 0;
    int izq = 0;
    // Si no es hoja, sumamos el dato con la suma maxima de los hijos
    if (arbol.tieneHijoIzquierdo()) {
      izq += sumaMaximaVertical(arbol.getHijoIzquierdo()) + arbol.getDato();
    }
    if (arbol.tieneHijoDerecho()) {
      der += sumaMaximaVertical(arbol.getHijoDerecho()) + arbol.getDato();
    }
    // Devolvemos la suma maxima
    return Math.max(der, izq);
  }

  public static int sumaMaximaHorizontal(ArbolBinario<Integer> arbol) {
    // Declaramos la variables para ir llevando el maximo
    int max = 0;
    int nivelActual = 0;
    // Creamos una cola para llevar el recorrido por nivel
    Cola<ArbolBinario<Integer>> cola = new Cola<>();
    cola.encolar(arbol);
    cola.encolar(null);

    ArbolBinario<Integer> tree = new ArbolBinario<>();

    while (!cola.esVacia()) {
      tree = cola.desencolar();
      // Si no es null, significa que es un nodo o una hoja, por lo que sumamos el
      // dato actual y encolamos si tiene hijos
      if (tree != null) {
        nivelActual += tree.getDato();
        if (tree.tieneHijoIzquierdo()) {
          cola.encolar(tree.getHijoIzquierdo());
        }
        if (tree.tieneHijoDerecho()) {
          cola.encolar(tree.getHijoDerecho());
        }
      } else if (!cola.esVacia()) {
        // Si la cola no esta vacia y el elemento actual es null,
        // significa que todavía nos quedan niveles por recorrer, por lo que comparamos
        // el nivel actual con el anterior
        // Y se lo asignamos al maximo
        max = Math.max(max, nivelActual);
        nivelActual = 0;
        cola.encolar(null);
      } else {
        max = Math.max(max, nivelActual);
      }
    }
    return max;
  }

}