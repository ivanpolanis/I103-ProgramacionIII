package practica3.b.ej4;

import utils.Balanceo;

public class Test {
  public static void main(String[] args) {
    StringBuffer str = new StringBuffer("[{()}]");
    System.out.println(Balanceo.balanceado(str));
  }
  
}
