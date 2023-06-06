package Modulo1.practica2.b.ej2;

public class PerroGrande extends Perro {
  @Override
  public void saludo() {
    System.out.println("Guauuuuu");
  }

  @Override
  public void saludo(Perro otro) {
    System.out.println("Guauuuuu Guauuuuu");
  }

  public boolean esMasBuenoQue(Animal otro) {
    return true;
  }
}
