package practica5.b.ej3;

import classes.ArbolGeneral;
import classes.ListaGenerica;

public class Trie {
  private ArbolGeneral<Character> trie;
  private boolean fin;

  public Trie() {
    trie = new ArbolGeneral<Character>(null);
  }

  public ArbolGeneral<Character> getTrie() {
    return trie;
  }

  public void agregarPalabra(String palabra) {
    ArbolGeneral<Character> curr = this.trie;
    for (char c : palabra.toCharArray()) {
      ListaGenerica<ArbolGeneral<Character>> a = curr.getHijos();
      int pos = estaChar(a, c);
      if (pos != -1) {
        curr = curr.getHijos().elemento(pos);
      } else {
        curr = curr.getHijos().elemento(agregarChar(a, c));

      }
    }

  }

  private int estaChar(ListaGenerica<ArbolGeneral<Character>> l, char c) {
    for (int i = 0; i < l.tamanio(); i++) {
      if (c == l.elemento(i).getDato())
        return i;
    }
    return -1;
  }

  private int agregarChar(ListaGenerica<ArbolGeneral<Character>> l, char c) {

    ArbolGeneral<Character> a = new ArbolGeneral<Character>(c);
    if (l.esVacia()) {
      l.agregarInicio(a);
      return 0;
    }

    for (int i = 0; i < l.tamanio(); i++) {
      if (c < l.elemento(i).getDato()) {
        l.agregarEn(a, i);
        return i;
      }
    }
    l.agregarFinal(a);
    return l.tamanio() - 1;

  }

  public void ImprimirPorNiveles() {
    trie.ImprimirPorNiveles();
  }

}
