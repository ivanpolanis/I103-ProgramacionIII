package classes.Grafos.utils;

import classes.ListaGenerica.ListaGenerica;
import classes.Grafos.Arista;
import classes.Grafos.Grafo;

public class Floyd<T> {

  public Costo[][] floyd(Grafo<T> grafo) {
    int len = grafo.listaDeVertices().tamanio();
    Costo[][] mtx = new Costo[len][len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        Costo aux = new Costo();
        if (i == j) {
          aux.setW(0);
          aux.setPrev(j);
        }
        mtx[i][j] = aux;
      }
    }

    for (int i = 0; i < len; i++) {
      ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(grafo.listaDeVertices().elemento(i));
      ady.comenzar();
      while (!ady.fin()) {
        Arista<T> a = ady.proximo();
        int j = a.verticeDestino().posicion();
        mtx[i][j].setW(a.peso());
        mtx[i][j].setPrev(i);
      }
    }

    for (int k = 0; k < len; k++) {
      for (int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++) {
          if (mtx[i][k].getW() != Integer.MAX_VALUE && mtx[k][j].getW() != Integer.MAX_VALUE) {
            int distancia = mtx[i][k].getW() + mtx[k][j].getW();
            if (mtx[i][j].getW() > distancia) {
              mtx[i][j].setW(distancia);
              mtx[i][j].setPrev(k);
            }
          }
        }
      }
    }

    return mtx;
  }

}
