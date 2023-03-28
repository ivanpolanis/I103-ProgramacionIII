package practica3.utils;

import java.io.CharConversionException;

import practica3.utils.Pila;

public class Balanceo {
  public static boolean balanceado(StringBuffer exp) {
    Pila<Character> pila = new Pila<>();
    while (exp.length() != 0) {
      if (isOpener(exp.charAt(0))) {
        pila.apilar(exp.charAt(0));
        exp.deleteCharAt(0);
      } else {

      }
    }
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
