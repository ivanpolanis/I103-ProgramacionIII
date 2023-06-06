package Modulo1.practica2.b.ej1;

public class Tablet extends Mobile {
  private int pulgadas;

  public Tablet(String marca, String sistemaOperativo, String modelo, int costo, int pulgadas) {
    super(marca, sistemaOperativo, modelo, costo);
    this.pulgadas = pulgadas;
  }

  public int getPulgadas() {
    return this.pulgadas;
  }

  public void setPulgadas(int pulgadas) {
    this.pulgadas = pulgadas;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof Tablet)) {
      return false;
    }
    Tablet tablet = (Tablet) obj;
    return this.getMarca().equals(tablet.getMarca()) && this.getSistemaOperativo().equals(tablet.getSistemaOperativo())
        && this.getModelo().equals(tablet.getModelo()) && this.getCosto() == tablet.getCosto()
        && this.pulgadas == tablet.pulgadas;
  }

  @Override
  public String toString() {
    return super.toString() + " Pulgadas: " + this.pulgadas;
  }
}
