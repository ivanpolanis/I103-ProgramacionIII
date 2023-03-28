package practica3.utils;

import practica3.b.Clases.ListaGenericaEnlazada;

public class Cola<T> {
  private ListaGenericaEnlazada<T> lista;

  public void encolar(T elem) {
    if(this.esVacia())
      lista = new ListaGenericaEnlazada<>();
    this.lista.agregarFinal(elem);
  }
  
  public T desencolar() {
    if(this.esVacia())
      return null;
    T dato = this.lista.elemento(0);
    this.lista.eliminarEn(0);
    if(this.lista.tamanio() == 0)
      this.lista = null;
    return dato;
  }
  
  public T tope() {
    if(this.esVacia())
      return null;
    return this.lista.elemento(0);
  }
  
  public boolean esVacia() {
    return this.lista == null;
  }
  
}
