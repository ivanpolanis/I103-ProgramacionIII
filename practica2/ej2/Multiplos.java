package practica2.ej2;

public class Multiplos {
  public static void main(String[] args) {

  }

  public static int[] getMultiplos(int n) {
    int[] multiplos = new int[n];
    for (int i = 1; i <= n; i++) {
      multiplos[i - 1] = i * n;
    }
    return multiplos;
  }
}
