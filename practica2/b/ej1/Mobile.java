package practica2.b.ej1;

public class Mobile {
  private String marca;
  private String sistemaOperativo;
  private String modelo;
  private double costo;

  public Mobile(String marca, String sistemaOperativo, String modelo, double costo) {
    this.marca = marca;
    this.sistemaOperativo = sistemaOperativo;
    this.modelo = modelo;
    this.costo = costo;
  }

  public String getMarca() {
    return this.marca;
  }

  public String getSistemaOperativo() {
    return this.sistemaOperativo;
  }

  public String getModelo() {
    return this.modelo;
  }

  public double getCosto() {
    return this.costo;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setSistemaOperativo(String sistemaOperativo) {
    this.sistemaOperativo = sistemaOperativo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setCosto(double costo) {
    this.costo = costo;
  }

  @Override
  public String toString() {
    return "Marca: " + this.marca + " Sistema Operativo: " + this.sistemaOperativo + " Modelo: " + this.modelo
        + " Costo: " + this.costo;
  }
}
