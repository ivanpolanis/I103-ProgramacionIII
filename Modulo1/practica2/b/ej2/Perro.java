package Modulo1.practica2.b.ej2;

public class Perro extends Animal {
  @Override
  public void saludo() {
    System.out.println("Guau");
  }

  public void saludo(Perro otro) {
    System.out.println("Guau Guau");
  }
}
