package Modulo1.practica5.b.ej2;

import classes.ArbolGeneral.ArbolGeneral;

public class RedDeAguaPotable {

  public static void main(String[] args) {
    ArbolGeneral<Double> a = new ArbolGeneral<Double>(1.0);
    a.agregarHijo(new ArbolGeneral<Double>(2.0));
    a.agregarHijo(new ArbolGeneral<Double>(3.0));
    a.agregarHijo(new ArbolGeneral<Double>(4.0));
    a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Double>(5.0));
    a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(6.0));
    a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Double>(7.0));
    a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(8.0));
    a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(9.0));
    System.out.println("minCaudal: " + minCaudal(a, 2000));
  }
  
  public static double minCaudal(ArbolGeneral<Double> a , double n) {
    if(a.esHoja())
      return n;
    
    double min = Double.MAX_VALUE;
    double m = n / a.getHijos().tamanio();
      for (int i = 0; i < a.getHijos().tamanio(); i++) {
        double l = minCaudal(a.getHijos().elemento(i), m);
        if (l < min) {
          min = l;
        }
      }
    return min; 
  }
  
}
