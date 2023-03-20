package practica2.b.ej4;

public class Resultados {
  private int maximo;
  private int minimo;
  private float promedio;

  public Resultados() {
    this.maximo = 0;
    this.minimo = 0;
    this.promedio = 0f;
  }
  
  public Resultados(int maximo, int minimo, float promedio) {
    this.maximo = maximo;
    this.minimo = minimo;
    this.promedio = promedio;
  }

  public int getMaximo() {
    return this.maximo;
  }

  public void setMaximo(int maximo) {
    this.maximo = maximo;
  }

  public int getMinimo() {
    return this.minimo;
  }

  public void setMinimo(int minimo) {
    this.minimo = minimo;
  }

  public float getPromedio() {
    return this.promedio;
  }

  public void setPromedio(float promedio) {
    this.promedio = promedio;
  }
}
