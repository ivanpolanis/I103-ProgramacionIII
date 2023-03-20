package practica2.a.ej1;

public class IteradorCD {
  public static void main(String[] args) {
    IteradorCD.iteracionConFor(1, 10);
    IteradorCD.iteracionConWhile(1, 10);
    IteradorCD.recursivo(10, 1);
  }

  public static void iteracionConFor(int a, int b) {
    for (int i = a; i <= b; i++) {
      System.out.println(i);
    }
  }

  public static void iteracionConWhile(int a, int b) {
    while (a <= b) {
      System.out.println(a);
      a++;
    }
  }
  public static void recursivo(int a, int b) {
    if (a >= b) {
      System.out.println(a);
      recursivo(a - 1, b);
    }
  }
}
