package practica2.b.ej3;

public class SwapValores {
  public static void swap1(int x, int y) {
    if (x < y) {
      int tmp = x;
      x = y;
      y = tmp;
    }
  }

  public static void swap2(Integer x, Integer y) {
    if (x < y) {
      int tmp = x;
      x = y;
      y = tmp;
    }
  }

  public static void main(String[] args) {
    int a = 1, b = 2;
    Integer c = 3, d = 4;
    swap1(a, b);
    swap2(c, d);
    System.out.println("a=" + a + " b=" + b);
    System.out.println("c=" + c + " d=" + d);
  }
}
//swap1 no funcionara ya que las variables se estan pasando por valor. Por lo que las variables en el main conservaran su valor original.
//swap2 no funcionara ya que las variables aunque sean objetos, se esta modificando la direccion apuntada. Por lo que las variables en el main conservaran su valor original.