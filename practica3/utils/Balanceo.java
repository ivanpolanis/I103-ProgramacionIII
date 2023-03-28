package practica3.utils;

public class Balanceo {
  public static boolean balanceado(StringBuffer exp) {
    if(exp.length() == 1)
      return false;
    Pila<Character> pila = new Pila<>();
    while (exp.length() != 0) {
      if (isOpener(exp.charAt(0))) {
        pila.apilar(exp.charAt(0));
        exp.deleteCharAt(0);
      } else {
        if (pila.esVacia())
          return false;
        if (!pila.esVacia() && !esPareja(exp.charAt(0), pila.desapilar()))
          return false;
        exp.deleteCharAt(0);
      }
    }
    return true;
  }

  private static boolean isOpener(Character c) {
    return (c == '(' || c == '[' || c == '{');
  }

  private static boolean esPareja(Character c, Character c2) {
    if (c == ')')
      return (c2 == '(');
    if (c == '}')
      return (c2 == '{');
    return (c2 == '[');
  }
}
