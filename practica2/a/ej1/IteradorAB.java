package practica2.a.ej1;
public class IteradorAB {
  public static void main(String[] args) {
    IteradorAB iterador = new IteradorAB();
    iterador.iteracionConFor(1, 10);
    iterador.iteracionConWhile(1, 10); 
    iterador.recursivo(1, 10);
  }
  public void iteracionConFor(int a, int b) {
    for (int i = a; i <= b; i++) {
      System.out.println(i);
    }
  }

  public void iteracionConWhile(int a, int b) {
    while (a <= b) {
      System.out.println(a);
      a++;
    }
  }
  public void recursivo(int a, int b) {
    if (a <= b) {
      System.out.println(a);
      recursivo(a + 1, b);
    }
  }
}