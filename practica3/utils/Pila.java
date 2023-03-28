package practica3.utils;

import practica3.b.Clases.ListaGenericaEnlazada;

public class Pila<T> {
  private ListaGenericaEnlazada<T> lista;

  public void apilar(T elem) {
    if(this.esVacia()) {
      this.lista = new ListaGenericaEnlazada<>();
    }
    this.lista.agregarFinal(elem);
  }

  public T desapilar() {
    if (this.esVacia())
      return null;
    T dato = this.lista.elemento(this.lista.tamanio() - 1);
    this.lista.eliminarEn(this.lista.tamanio() - 1);
    if (this.lista.tamanio() == 0)
      this.lista = null;
    return dato;
  }

  public T tope() {
    if (this.esVacia()) {
      return null;
    }
    return lista.elemento(this.lista.tamanio() - 1);
  }

  public boolean esVacia() {
    return this.lista == null;
  }
}
