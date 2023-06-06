package Modulo1.practica2.b.ej5;

public abstract class Figura {
  private String color;
  private boolean relleno;

  public Figura() {
    this.color = "rojo";
    this.relleno = true;
  }

  public Figura(String color,boolean relleno) {
    this.color = color;
    this.relleno = relleno;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public boolean getRelleno() {
    return this.relleno;
  }

  public void setRelleno(boolean relleno) {
    this.relleno = relleno;
  }

  public abstract double getArea();

  public abstract double getPerimetro();

  public String toString() {
    return "color=" + this.color + ", relleno=" + this.relleno;
  }
  
}
