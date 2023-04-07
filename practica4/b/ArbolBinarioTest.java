package practica4.b;

import classes.ArbolBinario;
import utils.Utils;

public class ArbolBinarioTest {

	public static void main(String[] args) {
		ArbolBinario<Integer> arbolBinarioA;
		// ----- arbolBinarioA -----
		arbolBinarioA = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdo = new ArbolBinario<Integer>(2);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(4));
		ArbolBinario<Integer> hijoDerecho = new ArbolBinario<Integer>(6);
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);


		System.out.println(Utils.sumaMaximaVertical(arbolBinarioA));
		System.out.println(Utils.sumaMaximaHorizontal(arbolBinarioA));

	}

}
