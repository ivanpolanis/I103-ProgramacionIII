package classes.ListaGenerica.utils;

import classes.ListaGenerica.ListaGenericaEnlazada;

public class Cola<T> {
  private ListaGenericaEnlazada<T> lista;

  public Cola() {
    this.lista = new ListaGenericaEnlazada<>();
  }

  public void encolar(T elem) {
    this.lista.agregarFinal(elem);
  }

  public T desencolar() {
    if (this.esVacio())
      return null;
    T dato = this.lista.elemento(0);
    this.lista.eliminarEn(0);
    if (this.lista.tamanio() == 0)
      this.lista.comenzar();
    return dato;
  }

  public T tope() {
    if (this.esVacio())
      return null;
    return this.lista.elemento(0);
  }

  public boolean esVacio() {
    return this.lista.esVacia();
  }

}
