package practica3.b.ej2;
import practica3.b.Clases.ListaGenericaEnlazada;

public class Test {
  public static void main(String[] args) {
    ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<>();
    lista.comenzar();
    lista.agregarInicio(6);
    lista.agregarInicio(8);
    lista.agregarInicio(2);
    lista.agregarInicio(1);
    lista.agregarInicio(9);
    lista.agregarInicio(7);

    System.out.println("La lista es: " + lista.toString());
    ListaGenericaEnlazada<Integer> invertida = lista.invertir();
    System.out.println("La lista es: " + invertida.toString());
  }  
}
