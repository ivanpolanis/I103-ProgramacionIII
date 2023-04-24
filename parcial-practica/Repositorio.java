package classes;

public class Repositorio {
  private ListaGenerica<ArbolBinario<Integer>> lista;
  private int pares;
  
  public Repositorio(ListaGenerica<ArbolBinario<Integer>> lista, int pares) {
    this.lista = lista;
    this.pares = pares;
  }

  public ListaGenerica<ArbolBinario<Integer>> getLista() {
    return lista;
  }

  public int getPares() {
    return pares;
  }

  public void setLista(ListaGenerica<ArbolBinario<Integer>> lista) {
    this.lista = lista;
  }

  public void setPares(int pares) {
    this.pares = pares;
  }

}
