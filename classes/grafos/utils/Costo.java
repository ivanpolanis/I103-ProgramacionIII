package classes.grafos.utils;

public class Costo implements Comparable<Costo> {
  private int w;
  private int prev;

  public Costo() {
    w = Integer.MAX_VALUE;
    prev = -1;
  }

  public Costo(int w, int prev) {
    this.w = w;
    this.prev = prev;
  }

  public int getW(){
    return w;
  }

  public void setW(int w){
    this.w = w;
  }

  public int getPrev(){
    return prev;
  }

  public void setPrev(int prev) {
    this.prev = prev;
  }
  
  public int compareTo(Costo c) {
    return this.w - c.w;
  }

}
