package Modulo1.practica2.b.ej5;

public class Cuadrado extends Rectangulo {
  public Cuadrado() {
    super();
  }

  public Cuadrado(double lado) {
    super(lado, lado);
  }

  public Cuadrado(double lado, String color, boolean relleno) {
    super(lado, lado, color, relleno);
  }

  public double getLado() {
    return this.getAncho();
  }

  public void setLado(double lado) {
    this.setAncho(lado);
    this.setLargo(lado);
  }

  @Override
  public void setAncho(double ancho) {
    this.setLado(ancho);
  }

  @Override
  public void setLargo(double largo) {
    this.setLado(largo);
  }

}
