package practica7.Ejercicio8;

import classes.ListaGenerica;
import classes.ListaGenericaEnlazada;

public class RutaMinima<T> {
  private ListaGenerica<T> ruta;
  private int boletos;
  
  public RutaMinima() {
    ruta = new ListaGenericaEnlazada<T>();
    boletos = 0;
  }

  public RutaMinima(ListaGenerica<T> ruta, int boletos) {
    this.ruta = ruta;
    this.boletos = boletos;
  }

  public ListaGenerica<T> getRuta() {
    return ruta;
  }

  public void setRuta(ListaGenerica<T> ruta) {
    this.ruta = ruta;
  }

  public int getBoletos() {
    return boletos;
  }

  public void setBoletos(int boletos) {
    this.boletos = boletos;
  }

  public void agregar(T estacion) {
    ruta.agregarFinal(estacion);
  }

  public void agregarBoleto() {
    boletos++;
  }

  public void eliminarBoleto() {
    boletos--;
  }

  public void eliminar(int i) {
    ruta.eliminarEn(i);
  }
}
