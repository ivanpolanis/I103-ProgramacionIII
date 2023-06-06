package Modulo1.practica3.b.ej5;

import classes.ListaGenerica.utils.Cola;

public class Test {

  public static void main(String[] args) {
    Cola<Integer> cola = new Cola<>();
    cola.encolar(1);
    cola.encolar(2);
    cola.encolar(3);
    cola.encolar(4);
    cola.encolar(5);

    while (!cola.esVacio()) {
      System.out.println(cola.desencolar());
   }
  }
  
}
