package Modulo1.practica2.b.ej5;

public class TestDeFiguraGeometricas {
  public static void main(String[] args) {
    Figura[] figuras = new Figura[3];
    figuras[0] = new Circulo(5.0);
    figuras[1] = new Rectangulo(2.0, 3.0);
    figuras[2] = new Cuadrado(4.0);
    for (Figura figura : figuras) {
      System.out.println(figura); 
    }
  }
  
}
