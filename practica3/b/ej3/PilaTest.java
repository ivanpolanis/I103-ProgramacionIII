package practica3.b.ej3;

import practica3.utils.Pila;

public class PilaTest {
public static void main(String[] args) {
  Pila<Character> pila = new Pila<>();
  pila.apilar('a');
  pila.apilar('b');
  pila.apilar('c');
  pila.apilar('d');
  pila.apilar('e');

  System.out.println("El ultimo elemento ingresado fue: " + pila.tope());
  System.out.println("El ultimo elemento ingresado fue: " + pila.desapilar());
  System.out.println("El ultimo elemento ingresado fue: " + pila.desapilar());
  System.out.println("El ultimo elemento ingresado fue: " + pila.desapilar());

}
}
