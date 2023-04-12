package practica5.b.ej3;

import java.util.List;

import Clases.ListaDeEnterosEnlazada;
import classes.ArbolGeneral;
import classes.ListaGenerica;
import classes.ListaGenericaEnlazada;

public class Trie {
  private ArbolGeneral<Character> trie;

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

  public ListaGenerica<StringBuilder> palabraQueEmpizaCon(String prefijo) {
    ListaGenerica<StringBuilder> list = new ListaGenericaEnlazada<>();
    ListaGenerica<ArbolGeneral<Character>> l = this.trie.getHijos();
    for (char c : prefijo.toCharArray()) {
      int pos = estaChar(l, c);
      if (pos == -1)
        return null;
      l = l.elemento(pos).getHijos();
    }

    recorrer(l, new StringBuilder(prefijo), list);

    return list;
  }

  private void recorrer(ListaGenerica<ArbolGeneral<Character>> l, StringBuilder s, ListaGenerica<StringBuilder> list) {
    for (int i = 0; i < l.tamanio(); i++) {
      s.append(l.elemento(i).getDato());
      if (l.elemento(i).esHoja()) {
        list.agregarFinal(new StringBuilder(s));
      } else {
        recorrer(l.elemento(i).getHijos(), s, list);
      }
      s.deleteCharAt(s.length() - 1);
    }
  }
  
  public void ImprimirPorNiveles() {
    trie.ImprimirPorNiveles();
  }

}
