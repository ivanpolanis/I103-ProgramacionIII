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
}