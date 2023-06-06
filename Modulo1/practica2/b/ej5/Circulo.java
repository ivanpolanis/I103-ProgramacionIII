package Modulo1.practica2.b.ej5;

public class Circulo extends Figura {
  private double radio; 
  public Circulo() {
    super();
    this.radio = 1.0;
  }

  public Circulo(double radio) {
    super();
    this.radio = radio;
  }
  public Circulo(double radio, String color, boolean relleno) {
    super(color,relleno);
    this.radio = radio;
  }

  public double getRadio() {
    return this.radio;
  }
  
  public void setRadio(double radio) {
    this.radio = radio;
  }

  public double getArea() {
    return Math.PI * this.radio * this.radio;
  }

  public double getPerimetro() {
    return 2 * Math.PI * this.radio;
  }

  @Override
  public String toString() {
    return super.toString() + ", radio=" + this.radio;
  }
}
