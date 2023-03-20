package practica2.b.ej5;

public class Rectangulo extends Figura {
  private double ancho;
  private double largo;
  
  public Rectangulo() {
    super();
    this.ancho = 1.0;
    this.largo = 1.0;
  }

  public Rectangulo(double ancho, double largo) {
    super();
    this.ancho = ancho;
    this.largo = largo;
  }

  public Rectangulo(double ancho, double largo, String color, boolean relleno) {
    super(color,relleno);
    this.ancho = ancho;
    this.largo = largo;
  }

  public double getAncho() {
    return this.ancho;
  }

  public void setAncho(double ancho) {
    this.ancho = ancho;
  }

  public double getLargo() {
    return this.largo;
  }

  public void setLargo(double largo) {
    this.largo = largo;
  }

  public double getArea() {
    return this.ancho * this.largo;
  }

  public double getPerimetro() {
    return 2 * (this.ancho + this.largo);
  }

  @Override
  public String toString() {
    return super.toString() + ", ancho=" + this.ancho + ", largo=" + this.largo;
  }
}
