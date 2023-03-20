package practica2.b.ej1;

public class SmartPhone extends Mobile {
  private int numero;

  public SmartPhone(String marca, String sistemaOperativo, String modelo, int costo, int numero) {
    super(marca, sistemaOperativo, modelo, costo);
    this.numero = numero;
  }

  public int getNumero() {
    return this.numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof SmartPhone)) {
      return false;
    }
    SmartPhone smartPhone = (SmartPhone) obj;
    return this.getMarca().equals(smartPhone.getMarca())
        && this.getSistemaOperativo().equals(smartPhone.getSistemaOperativo())
        && this.getModelo().equals(smartPhone.getModelo()) && this.getCosto() == smartPhone.getCosto()
        && this.numero == smartPhone.numero;
  }

  @Override
  public String toString() {
    return super.toString() + " Numero: " + this.numero;
  }
}
