package classes;
public class ProcesadorDeArbol {
  private ArbolBinario<Integer> arbol;

  public ProcesadorDeArbol(ArbolBinario<Integer> arbol) {
    this.arbol = arbol;
  }

  public Repositorio procesar() {
    ListaGenerica<ArbolBinario<Integer>> lista = new ListaGenericaEnlazada<>();
    Repositorio repositorio = new Repositorio(lista, 0);
    procesar(repositorio);
    return repositorio;
  }

  private void procesar(Repositorio repo) {
    if (arbol.tieneHijoIzquierdo() && arbol.tieneHijoDerecho() && (arbol.getDato() % 2 == 0)) {
      repo.setPares(repo.getPares() + 1);
      repo.getLista().agregarFinal(arbol);
    } else if (arbol.getDato() % 2 == 0) {
      repo.setPares(repo.getPares() + 1);
    }

    if (arbol.tieneHijoIzquierdo()) {
      ProcesadorDeArbol aux = new ProcesadorDeArbol(arbol.getHijoIzquierdo());
      aux.procesar(repo);
    }

    if (arbol.tieneHijoDerecho()) {
      ProcesadorDeArbol aux = new ProcesadorDeArbol(arbol.getHijoDerecho());
      aux.procesar(repo);
    }

  }
}